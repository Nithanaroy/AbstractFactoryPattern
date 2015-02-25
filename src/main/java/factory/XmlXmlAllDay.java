package factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import readers.IReader;
import readers.XMLReader;
import restaurant.FoodItem;
import restaurant.FoodItemCategory;
import restauranttypes.AllDay;
import restauranttypes.IRestaurantType;
import writers.IWriter;
import writers.XMLWriter;

public class XmlXmlAllDay extends IGenerateMenu {

	@Override
	public FoodItem[] fetchFoodItems(String inputFilePath) throws IOException {
		IReader r = new XMLReader();
		return r.processDocument(inputFilePath);
	}

	@Override
	public Map<FoodItemCategory, FoodItem[]> groupItemsByRestaurantCategory(
			FoodItem[] foodItems) {
		IRestaurantType restaurant = new AllDay();
		return restaurant.getRelevantFoodItemsByCategory(foodItems);
	}

	@Override
	public void printMenu(Map<FoodItemCategory, FoodItem[]> items,
			String outputFilePath) throws FileNotFoundException {
		IWriter w = new XMLWriter();
		w.createDocument(items, outputFilePath);
	}

}
