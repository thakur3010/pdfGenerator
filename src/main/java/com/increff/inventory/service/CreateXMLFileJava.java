package com.increff.inventory.service;

import com.increff.inventory.data.InvoiceForm;
import com.increff.inventory.util.PathUtil;
import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CreateXMLFileJava {
    @Value("${invoice.path}")
    private static String path;
    public static void xmlGenerator(InvoiceForm invoiceForm) throws IOException {

        String xmlFilePath = "xmlFile.xml";

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("invoice");
            document.appendChild(root);

            Element lineItems = document.createElement("lineitems");
            root.appendChild(lineItems);

            Element total = document.createElement("total");
            total.appendChild(document.createTextNode(String.valueOf(invoiceForm.getTotal_cost())));
            root.appendChild(total);

            Element date = document.createElement("date");
            date.appendChild(document.createTextNode(String.valueOf(new Date())));
            root.appendChild(date);
            Element orderId = document.createElement("orderId");
            orderId.appendChild(document.createTextNode(String.valueOf(invoiceForm.getOrderId())));
            root.appendChild(orderId);
            Element invoiceId = document.createElement("invoiceId");
            invoiceId.appendChild(document.createTextNode(String.valueOf(invoiceForm.getId())));
            root.appendChild(invoiceId);
            
            Element tax = document.createElement("terms");
            tax.appendChild(document.createTextNode("5 days"));
            root.appendChild(tax);

            //asdasda asyduays d
            for(int i=0; i<invoiceForm.getOrderItems().size(); i++){
                String barcode = invoiceForm.getOrderItems().get(i).getBarcode();
                String name = invoiceForm.getOrderItems().get(i).getProduct_name();
                Integer quantity = invoiceForm.getOrderItems().get(i).getQuantity();
                Double mrp = invoiceForm.getOrderItems().get(i).getSelling_price();

                Element lineItem = document.createElement("lineitem");
                lineItems.appendChild(lineItem);

                // amount element
                Element barcodeEl = document.createElement("amount");
                barcodeEl.appendChild(document.createTextNode(String.valueOf(quantity*mrp)));
                lineItem.appendChild(barcodeEl);
                // description element
                Element nameEl = document.createElement("description");
                nameEl.appendChild(document.createTextNode(name));
                lineItem.appendChild(nameEl);

                // quantity element
                Element quantityEl = document.createElement("quantity");
                quantityEl.appendChild(document.createTextNode(String.valueOf(quantity)));
                lineItem.appendChild(quantityEl);

                // unitprice elements
                Element mrpEl = document.createElement("unitprice");
                mrpEl.appendChild(document.createTextNode(String.valueOf(mrp)));
                lineItem.appendChild(mrpEl);
            }



            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
