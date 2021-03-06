package restaurant;

public enum RestaurantCategory {
	DINER("Diner"), ALL_DAY("All Day"), EVENING_ONLY("Evening Only"), UNKNOWN(
			"Unknown");

	private final String displayName;

	RestaurantCategory(String displayName) {
		this.displayName = displayName;
	}

	public static FoodItemCategory getCategory(String category) {
		if (category.equalsIgnoreCase("Breakfast"))
			return FoodItemCategory.BREAKFAST;

		if (category.equalsIgnoreCase("Lunch"))
			return FoodItemCategory.LUNCH;

		if (category.equalsIgnoreCase("Snack"))
			return FoodItemCategory.SNACK;

		if (category.equalsIgnoreCase("Side Items"))
			return FoodItemCategory.SIDE_DISH;

		if (category.equalsIgnoreCase("Appetizer"))
			return FoodItemCategory.APPETIZER;

		if (category.equalsIgnoreCase("Dinner"))
			return FoodItemCategory.DINNER;

		if (category.equalsIgnoreCase("Dessert"))
			return FoodItemCategory.DESSERT;

		return FoodItemCategory.UNKNOWN;

	}

	public String toString() {
		return this.displayName;
	}
}
