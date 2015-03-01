package writers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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

	protected final void saveAsFile(String content, String filename) throws FileNotFoundException {
		String filepath = new File(filename).getAbsolutePath(); 
		PrintWriter printer = new PrintWriter(new FileOutputStream(filepath));
		printer.println(content);
		printer.close();
	}
}
