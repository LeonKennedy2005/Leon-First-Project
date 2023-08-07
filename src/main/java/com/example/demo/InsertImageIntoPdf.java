package com.example.demo;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class InsertImageIntoPdf {
    public static void main(String[] args) {
        String inputFile = "resources\\pdf\\First_PDF.pdf"; // Path to the input PDF with fillable text fields
        String outputFile = "resources\\pdf\\Blue_Picture.pdf"; // Path to the output PDF with filled text field
        String imagePath = "resources\\images\\Blue.png"; // Replace with the actual path to your image file

        try {
            // Load the existing PDF
            PdfReader reader = new PdfReader(inputFile);
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            PdfStamper stamper = new PdfStamper(reader, outputStream);

            // Get the PdfContentByte from the PdfStamper
            PdfContentByte content = stamper.getOverContent(1); // Page number, here we use 1 for the first page

            // Create an Image object from the image file
            Image image = Image.getInstance(imagePath);

            // Set the position and size of the image on the page
            image.setAbsolutePosition(113, 594); // Replace 'x' and 'y' with the coordinates where you want to place the image
            image.scaleToFit(70, 70); // Replace 'width' and 'height' with the desired width and height of the image

            // Add the image to the PDF document
            content.addImage(image);

            // Close the PdfStamper
            stamper.close();

            // Close the input and output streams
            reader.close();
            outputStream.close();

            System.out.println("Image inserted successfully.");
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
