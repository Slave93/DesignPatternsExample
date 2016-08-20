package database;

import java.util.ArrayList;
import java.util.List;

import model.AirConditioner;
import model.AirConditionerService;
import model.Product;
import model.ProductToServiceAdapter;
import model.Service;
import model.Television;
import model.TelevisionService;
import model.document.BusinessDocument;

//##############Singleton#################
public class ControllorSingleton {

	private static Controller controller = null;

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	
}
