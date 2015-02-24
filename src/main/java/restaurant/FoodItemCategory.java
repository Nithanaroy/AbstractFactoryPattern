package restaurant;

public enum FoodItemCategory {
	// BREAKFAST("Breakfast"), LUNCH("Lunch"), SNACK("Snack"),
	// SIDE_DISH("Side Items"), APPETIZER(
	// "Appetizer"), DINNER("Dinner"), DESSERT("Dessert"), UNKNOWN(
	// "Unknown");

	BREAKFAST("Breakfast"), LUNCH("Lunch"), SNACK("Snack"), SIDE_DISH(
			"Side_Dish"), APPETIZER("Appetizer"), DINNER("Dinner"), DESSERT(
			"Dessert"), UNKNOWN("Unknown");

	private final String displayName;

	FoodItemCategory(String displayName) {
		this.displayName = displayName;
	}

	public static FoodItemCategory getCategory(String category) {
		if (category.equalsIgnoreCase("Breakfast"))
			return FoodItemCategory.BREAKFAST;

		if (category.equalsIgnoreCase("Lunch"))
			return FoodItemCategory.LUNCH;

		if (category.equalsIgnoreCase("Snack"))
			return FoodItemCategory.SNACK;

		if (category.equalsIgnoreCase("Side Dish"))
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
