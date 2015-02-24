package factory;

import java.io.IOException;

import restaurant.FoodItem;

public abstract class IGenerateMenu {

	protected final String foodItemsFilePath, countryCode;
	protected FoodItem[] allItems;

	public IGenerateMenu(String _foodItemsFilePath, String _countryCode) {
		foodItemsFilePath = _foodItemsFilePath;
		countryCode = _countryCode;
	}

	public abstract FoodItem[] saveFoodItems() throws IOException;

	protected FoodItem[] filterItemsForCountry(String countryCode,
			FoodItem[] foodItems) {
		return null;
	}

	public abstract FoodItem[] filterItemByRestaurantCategory(
			FoodItem[] foodItems);

	public abstract void printMenu(FoodItem[] items);
}
