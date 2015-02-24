package restauranttypes;

import java.util.Arrays;
import java.util.Map;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public abstract class IRestaurantType {

	abstract public Map<FoodItemCategory, FoodItem[]> getRelevantFoodItemsByCategory(FoodItem[] items);

	protected FoodItem[] filterByCategory(FoodItem[] items, FoodItemCategory type) {
		Object[] temp = Arrays.stream(items)
				.filter(item -> item.getCategory() == type).toArray();
		FoodItem[] filteredItems = new FoodItem[temp.length];
		for (int i = 0; i < temp.length; i++) {
			filteredItems[i] = (FoodItem) temp[i];
		}
		return filteredItems;
	}
}
