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
public abstract class DocumentStatus {
    
    protected BusinessDocument businessDocument;
    
    public DocumentStatus(BusinessDocument businessDocument){
        this.businessDocument = businessDocument;
    } 
  
    public abstract void save() throws Exception;
    public abstract void complete() throws Exception;
    public abstract String getStatus();
    
  
}
