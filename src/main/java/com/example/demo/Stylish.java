package com.example.demo;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.IOException;

public class Stylish {
    public static final String Pacifico = "fonts\\Pacifico.ttf";

    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\leonk\\Desktop\\Results\\StylishText.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        PdfFont Pacifico1 = PdfFontFactory.createFont(Pacifico,true );

        PdfFont roman = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);


        Text text1 = new Text("Brown fox jumped over lazy dog").setFont(Pacifico1);
        Text text2 = new Text("\nBrown fox jumped over lazy dog").setFont(roman);
        Text text3 = new Text("\nBrown fox jumped over lazy dog").setFont(roman).setBold();
        Text text4 = new Text("\nBrown fox jumped over lazy dog").setFont(roman).setItalic();
        Text text5 = new Text("\nBrown fox jumped over lazy dog").setFont(roman).setUnderline();
        Text text6 = new Text("\nBrown fox jumped over lazy dog").setFont(roman).setBold().setItalic();
        Text text7 = new Text("\nBrown fox jumped over lazy dog").setFont(roman).setFontColor(Color.BLUE);
        Text text8 = new Text("\nBrown fox jumped over lazy dog").setFont(roman).setBold().setStrokeColor(Color.YELLOW);
        Text text9 = new Text("\nBrown fox jumped over lazy dog").setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE).setStrokeColor(Color.GREEN).setStrokeWidth(0.7f);
        Text text10 = new Text("\nBrown fox jumped over lazy dog").setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE).setStrokeColor(Color.GREEN).setStrokeWidth(.3f);


        Paragraph paragraph =new Paragraph().add(text1).add(text2).add(text3).add(text4).add(text5).add(text6).add(text7).add(text8).add(text9).add(text10);

        document.add(paragraph);
        document.close();
        System.out.println("PDF created");

    }
}
