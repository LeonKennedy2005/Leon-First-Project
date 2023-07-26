package com.example.demo;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.IOException;

public class Style_personal {


    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\leonk\\Desktop\\Results\\Style.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        Style author=new Style();
        author.setFontColor(Color.RED).setFontSize(20f).setItalic();

        Text text1 = new Text("Do you sell glue?").addStyle(author);


        Paragraph paragraph =new Paragraph().add(text1);

        document.add(paragraph);
        document.close();
        System.out.println("PDF created");

    }

}
