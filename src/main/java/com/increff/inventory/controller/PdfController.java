package com.increff.inventory.controller;


import com.increff.inventory.data.InvoiceForm;
import com.increff.inventory.service.InvoiceGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api
@RestController
public class PdfController {

    @Autowired
    InvoiceGenerator invoiceGenerator;
    @ApiOperation("pdf generation")
    @RequestMapping(value = "/pdfGenerator",method = RequestMethod.POST)
    public String pdf(@RequestBody InvoiceForm invoiceForm) throws IOException {
        return invoiceGenerator.GeneratePdf(invoiceForm);
    }
}
