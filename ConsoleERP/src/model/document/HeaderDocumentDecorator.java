package model.document;

public class HeaderDocumentDecorator implements HeaderDocument {

	HeaderDocument headerDocument;
	
	public HeaderDocumentDecorator(HeaderDocument headerDocument){
		this.headerDocument = headerDocument;
	}
	
	@Override
	public String getHeader() {
		return headerDocument.getHeader();
	}

}
