/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.document;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.util.List;

import util.document.DocumentStatus;
import util.document.DocumentStatusDraft;
import util.document.DocumentStatusNew;
import util.pdf.PDFCreator;
import util.tax.TaxListener;

/**
 *
 * @author Slavko
 */
public abstract class BusinessDocument extends TaxListener implements HeaderDocument {
    
    //#####################STATE PATTERN###################################
    protected DocumentStatus documentStatus;
    protected int documentNumber;    
   

    public int getDocumentNumber() {
        return documentNumber;
    }

    public BusinessDocument() {
       this.documentStatus = new DocumentStatusNew(this);
    } 
    
    public void setDocumentStatus(DocumentStatus documentStatus) {
        this.documentStatus = documentStatus;
    }
    
    public String getStatus(){
        return documentStatus.getStatus();
    }
    
    public void complete()throws Exception{
        documentStatus.complete();
    }
    
    public void save() throws Exception{
        documentStatus.save();
    }
    
    public abstract void saveValidation() throws Exception;
    public abstract void completeValidation() throws Exception;   
    public void completeOperation(){};
    
    public abstract String getHeader();
    public abstract List<String> getLines();
    public abstract String getFooter();
    public abstract String getDocumentName();
    
    //####################TEMPLATE METHOD PATTERN###############################
    //####################DECORATOR PATTERN#####################################
    public void generatePDF() throws Exception{
    	if(getStatus().equalsIgnoreCase("NEW")){
    		throw new Exception("Document must be saved before print!");
    	}
        PDFCreator pdfCreator = new PDFCreator();
        HeaderDocumentDecorator headerDocumentDecorator = new HeaderDocumentDecorator(this);
        DocNumberHeaderDecorator docNumberHeaderDecorator = new DocNumberHeaderDecorator(headerDocumentDecorator);
        docNumberHeaderDecorator.setDocumentNumber(documentNumber);
        DateHeaderDecorator dateHeaderDecorator = new DateHeaderDecorator(docNumberHeaderDecorator);        
        pdfCreator.buildHeader(dateHeaderDecorator.getHeader());
        pdfCreator.buildFooter(getFooter());
        pdfCreator.buildLines(getLines());
        pdfCreator.printDocument(getDocumentName()+""+getDocumentNumber()+""+getStatus());
    }
    

    
    
 
   
}
