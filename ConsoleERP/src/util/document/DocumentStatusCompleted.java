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
public class DocumentStatusCompleted extends DocumentStatus {

    public DocumentStatusCompleted(BusinessDocument businessDocument) {
        super(businessDocument);
    }

    @Override
    public String getStatus() {
        return "COMPLETED";
    }

    @Override
    public void complete() throws Exception {
        throw new Exception("Document already completed");
    }

    @Override
    public void save() throws Exception {
        throw new Exception("Completed document could not be edited");
    }
    
}
