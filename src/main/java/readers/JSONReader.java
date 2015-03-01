package readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;
import utilities.Logger;

public class JSONReader extends IReader {

	@Override
	public FoodItem[] processDocument(String path) throws IOException {
		String inp;
		path = new File(path).getAbsolutePath();
		FoodItem[] items = null;
		try (FileInputStream inputStream = new FileInputStream(path)) {
			inp = IOUtils.toString(inputStream);
		}

		// Pass to JSON reader
		try {
			JSONObject json = new JSONObject(inp);

			JSONArray foodItemsInJson = (JSONArray) json.get("FoodItemData");

			int itemsCount = foodItemsInJson.length();
			items = new FoodItem[itemsCount];

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
		} catch (JSONException e) {
			Logger.logErrorIfDebug("Invalid JSON File");
			e.printStackTrace();
		}

		return items;
	}
}
