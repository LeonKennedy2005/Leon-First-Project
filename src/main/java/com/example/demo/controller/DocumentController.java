package com.example.demo.controller;

import com.example.demo.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
@Api(tags = "Document Controller", description = "Controller to generate and manage documents")
public class DocumentController {
    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/generate-pdf")
    @ApiOperation(value = "Generate a sample PDF")
    public ResponseEntity<byte[]> generatePDF() throws IOException {
        byte[] contents = documentService.createSamplePDF();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("sample.pdf").build()); // изменено на "attachment"
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }

    @PostMapping("/generate-custom-pdf")
    @ApiOperation(value = "Generate a PDF with custom text")
    public ResponseEntity<byte[]> generateCustomPDF(@RequestParam String customText) throws IOException {
        byte[] contents = documentService.createPDFWithCustomText(customText);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("custom.pdf").build());
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }

}
