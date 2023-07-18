import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DoubleBorder;
import com.itextpdf.layout.border.GrooveBorder;
import com.itextpdf.layout.element.Cell;

import java.io.IOException;

public class Table_array {
    public static void main(String[] args) throws IOException
    {
        String path = "C:\\Users\\leonk\\Desktop\\Results\\table_array.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        float columnWidth[]={40f, 40f,40f};
        Border border1 = new GrooveBorder(new DeviceRgb(200,7,4),5);
        DoubleBorder border2 = new DoubleBorder(new DeviceRgb(100,30,120),5);
        com.itextpdf.layout.element.Table table = new com.itextpdf.layout.element.Table(columnWidth);

        String[] tableHeader = {"Item", "Color", "Size"};
        String[][] itemArray = {
                {"Bicycle", "Red", "Large"},
                {"Lamp", "Blue", "Small"},
                {"Flag", "White", "Medium"},
                {"Bicycle", "Green", "Large"},
                {"Book", "Black", "Small"},
        };
        for (int i=0; i<3; i++){
            table.addCell(new Cell().add(tableHeader[i]).setBackgroundColor(Color.YELLOW).setBorder(border1));
        }


        for (int i=0; i<5; i++){
            for (int j=0; j<3; j++){
                if((i%2)==0)
                table.addCell(new Cell().add(itemArray[i][j]).setBackgroundColor(Color.LIGHT_GRAY).setBorder(border2));
                else  {
                    table.addCell(new Cell().add(itemArray[i][j]).setBackgroundColor(Color.DARK_GRAY));
                } ;
            }
        }

        document.add(table);
        document.close();
        System.out.println("PDF created");
    }
}
