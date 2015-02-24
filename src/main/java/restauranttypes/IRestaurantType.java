package restauranttypes;

import java.util.Arrays;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public abstract class IRestaurantType {

	abstract public FoodItem[] getRelevantFoodItems(FoodItem[] items);

	public static FoodItem[] filter(FoodItem[] items, FoodItemCategory type) {
		Object[] temp = Arrays.stream(items)
				.filter(item -> item.getCategory() == type).toArray();
		FoodItem[] filteredItems = new FoodItem[temp.length];
		for (int i = 0; i < temp.length; i++) {
			filteredItems[i] = (FoodItem) temp[i];
		}
		return filteredItems;
	}
}
