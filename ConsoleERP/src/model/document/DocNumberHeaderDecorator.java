package model.document;

public class DocNumberHeaderDecorator extends HeaderDocumentDecorator {

	private int documentNumber;
	
	public void setDocumentNumber(int documentNumber){
		this.documentNumber = documentNumber;
	}
	
	public DocNumberHeaderDecorator(HeaderDocument headerDocument) {
		super(headerDocument);
	}
	@Override
	public String getHeader() {
		return super.getHeader()+"\nDocumentNumber: "+documentNumber;
	}
	
	
}
