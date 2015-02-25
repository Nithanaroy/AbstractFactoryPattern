package writers;

import java.io.FileNotFoundException;
import java.util.Map;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public class TextWriter extends IWriter {

	@Override
	public void createDocument(Map<FoodItemCategory, FoodItem[]> items,
			String outputFilePath) throws FileNotFoundException {
		StringBuilder output = new StringBuilder("Menu\n\n\n");

		for (FoodItemCategory category : foodCategoriesPrintOrder) {
			if (items.containsKey(category)) {
				output.append(category.toString().toUpperCase() + "\n\n");
				output.append(getTextForItems(items.get(category)));
			}
		}

		// Save as a Text file
		saveAsFile(output.toString(), outputFilePath);
	}

	private String getTextForItems(FoodItem[] items) {
		StringBuilder text = new StringBuilder();
		for (FoodItem item : items) {
			// TODO: Should add currency code for Price
			text.append(item.getName() + "\t\t\t" + item.getFormattedPrice("")
					+ "\n");
			text.append(item.getDescription() + "\n\n");
		}
		return text.toString();
	}

}
