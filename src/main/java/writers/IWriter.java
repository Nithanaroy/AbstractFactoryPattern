package writers;

import java.io.FileNotFoundException;
import java.util.Map;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public abstract class IWriter {

	protected final FoodItemCategory[] foodCategoriesPrintOrder = {
			FoodItemCategory.BREAKFAST, FoodItemCategory.SNACK,
			FoodItemCategory.APPETIZER, FoodItemCategory.LUNCH,
			FoodItemCategory.DINNER, FoodItemCategory.DESSERT,
			FoodItemCategory.SIDE_DISH };

	abstract public void createDocument(
			Map<FoodItemCategory, FoodItem[]> items, String outputFilePath)
			throws FileNotFoundException;
}
