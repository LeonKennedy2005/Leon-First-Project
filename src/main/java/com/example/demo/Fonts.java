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

public class Fonts {
    // public static final String = "fonts\\"
    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\leonk\\Desktop\\Results\\Fonts.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        //pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);

        PdfFont fontTR = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont fontTB = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
        PdfFont fontTI = PdfFontFactory.createFont(FontConstants.TIMES_ITALIC);
        PdfFont fontTBI = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);

        Text text1 = new Text("What are you doing?").setFont(fontTR);
        Text text2 = new Text("What are you doing?").setFont(fontTB);
        Text text3 = new Text("What are you doing?").setFont(fontTI);
        Text text4 = new Text("What are you doing?").setFont(fontTBI);

        Paragraph paragraph =new Paragraph().add(text1).add(text2).add(text3).add(text4);

        document.add(paragraph);
        document.close();
        System.out.println("PDF created");

    }
}
