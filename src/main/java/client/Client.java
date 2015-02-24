package client;

import java.util.Map;

import org.json.JSONObject;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;
import factory.IGenerateMenu;
import factory.JsonHtmlAllDay;

public class Client {

	public static void main(String[] args) throws Exception {
		String inpFilePath = "D:\\Cloud\\Dropbox\\Personal Stuff\\ASU Acads\\Sem 2\\Software Design\\Assignments\\1. Design Patters\\Input\\FoodItemData.json";
		String outFilePath = "C:\\Users\\Nitin Pasumarthy\\Desktop\\JsonAlldayGBMenu.html";
		IGenerateMenu menuGenerator = new JsonHtmlAllDay();
		FoodItem[] allItems = menuGenerator.fetchFoodItems(inpFilePath);
		allItems = menuGenerator.filterItemsForCountry("GB", allItems);
		Map<FoodItemCategory, FoodItem[]> groupedItems = menuGenerator
				.groupItemsByRestaurantCategory(allItems);
		menuGenerator.printMenu(groupedItems, outFilePath);
		System.out.println();
	}

	@SuppressWarnings("unused")
	private static void jsonToJava() {
		String s = "{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}";
		JSONObject json = new JSONObject(s);
		json.get("1");
	}

	@SuppressWarnings("unused")
	private static void javaToJson() {
		JSONObject obj = new JSONObject();

		obj.put("name", "foo");
		obj.put("num", new Integer(100));
		obj.put("balance", new Double(1000.21));
		obj.put("is_vip", new Boolean(true));

		System.out.print(obj);
	}

}
