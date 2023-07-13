import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //text
        String path = "C:\\Users\\leonk\\Desktop\\Results\\Text-Image-List.pdf";
        String paraText = "What is Lorem Ipsum?\n" +
                "Body text, nothing to see here";
        //
        Paragraph paragraph1=new Paragraph(paraText);
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);
        document.add(paragraph1);
        //image
        try {

            String XboxImage = "images\\Xbox.jpg";
            ImageData data = ImageDataFactory.create(XboxImage);
            Image Xbox = new Image(data);
            float desiredWidth = 197;
            float desiredHeight = 111;
            Xbox.scaleToFit(desiredWidth, desiredHeight);
            document.add(Xbox);
        }
        catch (Exception e) {
            e.printStackTrace();
        }//

        List programming_lan = new List();
        programming_lan.add("Python");
        programming_lan.add("Java");
        programming_lan.add("C");
        programming_lan.add("JavaScrpit");
        document.add(programming_lan);
        document.close();
        System.out.println("PDF created");
    }
}
