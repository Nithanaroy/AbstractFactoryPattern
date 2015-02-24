package factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public abstract class IGenerateMenu {

	/**
	 * Fetch the food items from an input source
	 * 
	 * @param inputFilePath
	 *            File path where I can find the food items
	 * @return An array of FoodItem type
	 * @throws IOException
	 */
	public abstract FoodItem[] fetchFoodItems(String inputFilePath)
			throws IOException;

	/**
	 * Filter those items from the complete list which are commonly found in the
	 * given country
	 * 
	 * @param country
	 *            country code to filter on. Eg: GB for Great Britan.
	 * @param foodItems
	 *            List of all food items
	 * @return Filtered list of food items for the given country
	 */
	public FoodItem[] filterItemsForCountry(String country, FoodItem[] foodItems) {
		Object[] temp = Arrays.stream(foodItems)
				.filter(item -> item.getCountry().equalsIgnoreCase(country))
				.toArray();
		FoodItem[] filteredItems = new FoodItem[temp.length];
		for (int i = 0; i < temp.length; i++) {
			filteredItems[i] = (FoodItem) temp[i];
		}
		return filteredItems;
	}

	public abstract Map<FoodItemCategory, FoodItem[]> groupItemsByRestaurantCategory(
			FoodItem[] foodItems);

	public abstract void printMenu(Map<FoodItemCategory, FoodItem[]> items,
			String outputFilePath) throws FileNotFoundException;
}
