package model.document;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHeaderDecorator extends HeaderDocumentDecorator {

	private int documentNumber;
	
	public void setDocumentNumber(int documentNumber){
		this.documentNumber = documentNumber;
	}
	
	public DateHeaderDecorator(HeaderDocument headerDocument) {
		super(headerDocument);
	}
	@Override
	public String getHeader() {
		return super.getHeader()+"\nDate: "+ new SimpleDateFormat("dd.MM.YYYY").format(new Date());
	}
	
	
}
