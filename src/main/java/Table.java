import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;


import java.io.IOException;

public class Table {
    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\leonk\\Desktop\\Results\\table.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        float columnWidth[]={100f, 25f,25f};
        com.itextpdf.layout.element.Table table = new com.itextpdf.layout.element.Table(columnWidth);

        Cell cell_11 = new Cell();
        cell_11.add("Goods");
        table.addCell(cell_11);

        table.addCell(new Cell().add("Price"));
        table.addCell(new Cell().add("Available"));

        table.addCell(new Cell().add("Apples"));
        table.addCell(new Cell().add("4"));
        table.addCell(new Cell().add("Yes"));

        table.addCell(new Cell().add("Bananas"));
        table.addCell(new Cell().add("6"));
        table.addCell(new Cell().add("No"));

        table.addCell(new Cell().add("e"));
        table.addCell(new Cell().add("r"));
        table.addCell(new Cell().add("t"));

        document.add(table);
        document.close();
        System.out.println("PDF created");
    }

}
