package com.example.demo;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.IOException;

public class Fonts_custom {
    public static final String Pacifico = "fonts\\Pacifico.ttf";
    public static final String OpenSansB = "fonts\\OpenSans-Bold.ttf";

    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\leonk\\Desktop\\Results\\FontsCustom.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        PdfFont Pacifico1 = PdfFontFactory.createFont(Pacifico,true );
        PdfFont OpenSansB1 = PdfFontFactory.createFont(OpenSansB, true);


        Text text1 = new Text("Brown fox jumped over lazy dog").setFont(Pacifico1);
        Text text2 = new Text("Brown fox jumped over lazy dog").setFont(OpenSansB1);

        Paragraph paragraph =new Paragraph().add(text1).add(text2);

        document.add(paragraph);
        document.close();
        System.out.println("PDF created");

    }
}
