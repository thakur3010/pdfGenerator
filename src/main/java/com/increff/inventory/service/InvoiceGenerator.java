package com.increff.inventory.service;

import com.increff.inventory.data.InvoiceForm;
import com.increff.inventory.util.PathUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

@Service
public class InvoiceGenerator
{
    @Value("${invoice.path}")
    private static String path;
    public String GeneratePdf(InvoiceForm invoiceForm) throws IOException {
        // Path from env file
        //todo: path is null
        System.out.println(path);
        String styleSheetPath =  "invoice-template.xslt";
        String xmlFilePath = "xmlFile.xml";
        String pdfPath = "invoice.pdf";
        CreateXMLFileJava.xmlGenerator(invoiceForm);
        PdfGenerator pdfGenerator = new PdfGenerator(new HashMap<String, String>());
        try (FileOutputStream pdfOutput = new FileOutputStream(pdfPath)) {
            pdfGenerator.createPdfFile(xmlFilePath,styleSheetPath,pdfOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] inFileBytes = Files.readAllBytes(Paths.get(pdfPath));
        byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(inFileBytes);
        String base64EncodedFile = new String(encoded, StandardCharsets.UTF_8);
        return base64EncodedFile;

    }

}
