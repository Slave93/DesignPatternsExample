/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.document;

import model.document.BusinessDocument;

/**
 *
 * @author Slavko
 */
public class DocumentStatusDraft extends DocumentStatus{

    public DocumentStatusDraft(BusinessDocument businessDocument) {
        super(businessDocument);
    }  

    @Override
    public String getStatus() {
        return "DRAFT";
    }

    @Override
    public void complete() throws Exception {        
        businessDocument.completeValidation();
        businessDocument.completeOperation();
        this.businessDocument.setDocumentStatus(new DocumentStatusCompleted(businessDocument));        
    }

    @Override
    public void save() throws Exception {
        throw new Exception("Document already saved!");
    }
    
}
