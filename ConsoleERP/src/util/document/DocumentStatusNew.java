/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.document;

import database.ControllorSingleton;
import model.document.BusinessDocument;

/**
 *
 * @author Slavko
 */
public class DocumentStatusNew extends DocumentStatus {

    public DocumentStatusNew(BusinessDocument businessDocument) {
        super(businessDocument);
    }  

    @Override
    public String getStatus() {
        return "NEW";
    }

    @Override
    public void complete() throws Exception {
        throw new Exception("Document can't be completed because it is not yet saved!");
    }

    @Override
    public void save() throws Exception {        
        businessDocument.saveValidation();
        businessDocument.setDocumentStatus(new DocumentStatusDraft(businessDocument));
        ControllorSingleton.getInstance().addDocument(businessDocument);
    }
    
}
