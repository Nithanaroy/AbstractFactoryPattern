package factory;

import java.io.IOException;

import readers.IReader;
import readers.JSONReader;
import restaurant.FoodItem;
import restauranttypes.AllDay;

public class JsonHtmlAllDay extends IGenerateMenu {

	public JsonHtmlAllDay(String _foodItemsFilePath, String _countryCode) {
		super(_foodItemsFilePath, _countryCode);
	}

	@Override
	public FoodItem[] saveFoodItems() throws IOException {
		IReader r = new JSONReader();
		allItems = r.processDocument(foodItemsFilePath);
		return allItems;
	}

	@Override
	public FoodItem[] filterItemByRestaurantCategory(FoodItem[] foodItems) {
		AllDay allDayRestaurant = new AllDay();
		return allDayRestaurant.getRelevantFoodItems(foodItems);
	}

	@Override
	public void printMenu(FoodItem[] items) {
		// TODO Auto-generated method stub

	}

}
