package com.example.demo.service;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class DocumentService {

    public byte[] createSamplePDF() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        PdfFont fontTR = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont fontTB = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
        PdfFont fontTI = PdfFontFactory.createFont(FontConstants.TIMES_ITALIC);
        PdfFont fontTBI = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);

        Text text1 = new Text("What are you doing?").setFont(fontTR);
        Text text2 = new Text("What are you doing?").setFont(fontTB);
        Text text3 = new Text("What are you doing?").setFont(fontTI);
        Text text4 = new Text("What are you doing?").setFont(fontTBI);

        Paragraph paragraph = new Paragraph().add(text1).add(text2).add(text3).add(text4);

        document.add(paragraph);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    public byte[] createPDFWithCustomText(String customText) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        PdfFont fontTR = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

        Text text = new Text(customText).setFont(fontTR);
        Paragraph paragraph = new Paragraph().add(text);

        document.add(paragraph);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }




}
