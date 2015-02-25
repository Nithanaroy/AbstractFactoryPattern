package factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import readers.IReader;
import readers.JSONReader;
import restaurant.FoodItem;
import restaurant.FoodItemCategory;
import restauranttypes.AllDay;
import restauranttypes.IRestaurantType;
import writers.HTMLWriter;
import writers.IWriter;

public class JsonHtmlAllDay extends IGenerateMenu {

	@Override
	public FoodItem[] fetchFoodItems(String inputFilePath) throws IOException {
		IReader r = new JSONReader();
		return r.processDocument(inputFilePath);
	}

	@Override
	public Map<FoodItemCategory, FoodItem[]> groupItemsByRestaurantCategory(
			FoodItem[] foodItems) {
		IRestaurantType allDayRestaurant = new AllDay();
		return allDayRestaurant.getRelevantFoodItemsByCategory(foodItems);
	}

	@Override
	public void printMenu(Map<FoodItemCategory, FoodItem[]> items,
			String outputFilePath) throws FileNotFoundException {
		IWriter w = new HTMLWriter();
		w.createDocument(items, outputFilePath);
	}

}
