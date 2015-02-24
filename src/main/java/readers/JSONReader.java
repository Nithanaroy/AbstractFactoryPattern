package readers;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public class JSONReader extends IReader {

	@Override
	public FoodItem[] processDocument(String path) throws IOException {
		// check if JSON
		// Read JSON file
		String inp;
		try (FileInputStream inputStream = new FileInputStream(path)) {
			inp = IOUtils.toString(inputStream);
		}

		// Pass to JSON reader
		JSONObject json = new JSONObject(inp);
		JSONArray foodItemsInJson = (JSONArray) json.get("FoodItemData");

		int itemsCount = foodItemsInJson.length();
		FoodItem[] items = new FoodItem[itemsCount];

		// Create FoodItem objects
		for (int itemIndex = 0; itemIndex < itemsCount; itemIndex++) {
			JSONObject item = foodItemsInJson.getJSONObject(itemIndex);

			int id = item.getInt("id");
			String name = item.getString("name");
			String description = item.getString("description");
			String country = item.getString("-country");
			float price = Float.parseFloat(item.getString("price"));
			FoodItemCategory category = FoodItemCategory.getCategory(item
					.getString("category"));

			items[itemIndex] = new FoodItem(id, name, description, country,
					price, category);
		}

		return items;
	}

}
