package com.example.demo;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class FillPDFForm {

    public static void main(String[] args) {
        String inputFile = "resources\\pdf\\First_PDF.pdf"; // Path to the input PDF with fillable text fields
        String outputFile = "resources\\pdf\\filled_pdf2.pdf"; // Path to the output PDF with filled text field
      //  String checkboxFieldName = "no";
        String imagePath = "resources\\images\\Blue.png"; // Replace with the actual path to your image file

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
            formFields.setField("no","Yes"); // "Yes" will check the checkbox, "Off" will uncheck it
            formFields.setField("yes","Off");

            String fieldName = "text_field"; // Replace with the actual field name in the PDF
            String fieldValue = "Something something"; // Replace with the desired text
            formFields.setField(fieldName, fieldValue);

            PdfContentByte content = stamper.getOverContent(1); // Page number, here we use 1 for the first page

            // Create an Image object from the image file
            Image image = Image.getInstance(imagePath);

            // Set the position and size of the image on the page
            image.setAbsolutePosition(113, 594); // Replace 'x' and 'y' with the coordinates where you want to place the image
            image.scaleToFit(70, 70); // Replace 'width' and 'height' with the desired width and height of the image

            // Add the image to the PDF document
            content.addImage(image);

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
