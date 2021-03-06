package restauranttypes;

import java.util.HashMap;
import java.util.Map;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public class AllDay extends IRestaurantType {

	@Override
	public Map<FoodItemCategory, FoodItem[]> getRelevantFoodItemsByCategory(
			FoodItem[] items) {
		FoodItemCategory[] categories = { FoodItemCategory.BREAKFAST,
				FoodItemCategory.SNACK, FoodItemCategory.APPETIZER,
				FoodItemCategory.LUNCH, FoodItemCategory.DINNER,
				FoodItemCategory.DESSERT, FoodItemCategory.SIDE_DISH };

		Map<FoodItemCategory, FoodItem[]> itemsByCategory = new HashMap<FoodItemCategory, FoodItem[]>();

		for (FoodItemCategory category : categories) {
			itemsByCategory.put(category, filterByCategory(items, category));
		}
		return itemsByCategory;
	}
}
