package com.example.demo;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class CheckPdfCheckbox {
    public static void main(String[] args) {
        String inputFilePath = "resources\\pdf\\First_PDF.pdf";
        String outputFilePath = "resources\\pdf\\checked_NOOO.pdf";
        String checkboxFieldName = "no";

        try {
            // Load the existing PDF
            PdfReader reader = new PdfReader(inputFilePath);
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            PdfStamper stamper = new PdfStamper(reader, outputStream);

            // Get the AcroFields from the PDF
            AcroFields form = stamper.getAcroFields();

            // Check the checkbox
            form.setField(checkboxFieldName, "Yes"); // "Yes" will check the checkbox, "Off" will uncheck it

            // If the checkbox appearance needs to be updated, uncomment the following line
            // form.setGenerateAppearances(true);

            // Close the PdfStamper
            stamper.close();

            // Close the input and output streams
            reader.close();
            outputStream.close();

            System.out.println("Checkbox checked successfully.");
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

