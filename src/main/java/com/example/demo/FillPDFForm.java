package com.example.demo;

import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class FillPDFForm {

    public static void main(String[] args) {
        String inputFile = "pdf\\First_PDF.jpg"; // Path to the input PDF with fillable text fields
        String outputFile = "pdf\\filled_pdf.jpg"; // Path to the output PDF with filled text field

        try {
            // Step 1: Load the PDF document
            PdfReader reader = new PdfReader(inputFile);

            // Create an output stream to save the modified PDF
            FileOutputStream fos = new FileOutputStream(outputFile);

            // Step 2: Create a PdfStamper to write the filled content into the PDF
            PdfStamper stamper = new PdfStamper(reader, fos);

            // Step 3: Access the form fields
            AcroFields formFields = stamper.getAcroFields();

            // Step 4: Fill the text field with the desired value
            String fieldName = "text_field"; // Replace with the actual field name in the PDF
            String fieldValue = "Something something"; // Replace with the desired text
            formFields.setField(fieldName, fieldValue);

            // Step 5: Save and close the modified document
            stamper.close();
            reader.close();
            fos.close();

            System.out.println("PDF form filled successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
