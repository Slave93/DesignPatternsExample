package util.pdf;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.tax.TaxAdministration;
import util.tax.TaxListener;
import model.AirConditioner;
import model.AirConditionerService;
import model.BusinessPartner;
import model.Product;
import model.ProductToServiceAdapter;
import model.Service;
import model.Television;
import model.document.BusinessDocument;
import model.document.Invoice;
import model.document.Offer;
import model.offerbuilder.ChristmassOfferBuilder;
import model.offerbuilder.NewYearOfferBuilder;
import model.offerbuilder.SpecialOfferBuilder;

public class PDFCreator {

    //private static String FILE = "c:/temp/FirstPdf.pdf";
    private static final Font HEADERFONT = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.NORMAL);
    private static final Font LINESFONT = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);
    private static final Font FOOTERFONT = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private static final String DOCLOCATION = System.getProperty("user.dir")+"/pdfdocuments/";
    private static final String DOCEXT = ".pdf";
    private Paragraph linesParagraph;
    private Paragraph headerParagraph;
    private Paragraph footerParagraph;

   
    public void printDocument(String fileName) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(DOCLOCATION + fileName + DOCEXT));
        document.open();
        Paragraph preface = new Paragraph();
        preface.add(headerParagraph);
        addEmptyLine(preface, 3);
        preface.add(linesParagraph);
        addEmptyLine(preface, 2);
        preface.add(footerParagraph);
        document.add(preface);
        document.close();
        System.out.println("PDF is generated: "+DOCLOCATION + fileName + DOCEXT);
    }

    public void buildHeader(String header) {
        this.headerParagraph = new Paragraph(header, HEADERFONT);
    }

    public void buildFooter(String footer) {
        this.footerParagraph = new Paragraph(footer, FOOTERFONT);
    }

    public void buildLines(java.util.List<String> documentLines) {
        List list = new List(true, false, 10);
        java.util.List<Paragraph> paragraphList = new ArrayList<>();
        for (String line : documentLines) {
            list.add(new ListItem(line));
        }
        linesParagraph = new Paragraph();
        linesParagraph.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
