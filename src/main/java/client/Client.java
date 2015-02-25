package client;

import java.util.Map;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;
import factory.IGenerateMenu;
import factory.JsonHtmlAllDay;

public class Client {

	public static void main(String[] args) throws Exception {
		String jsonInpFilePath = "D:\\Cloud\\Dropbox\\Personal Stuff\\ASU Acads\\Sem 2\\Software Design\\Assignments\\1. Design Patters\\Input\\FoodItemData.json";
		String xmlInpFilePath = "D:\\Cloud\\Dropbox\\Personal Stuff\\ASU Acads\\Sem 2\\Software Design\\Assignments\\1. Design Patters\\Input\\FoodItemData.xml";
		String htmlOutFile = "C:\\Users\\Nitin Pasumarthy\\Desktop\\JsonAlldayGBMenu.html";
		String textOutFile = "C:\\Users\\Nitin Pasumarthy\\Desktop\\JsonAlldayGBMenu.txt";
		String xmlOutFile = "C:\\Users\\Nitin Pasumarthy\\Desktop\\JsonAlldayGBMenu.xml";

		IGenerateMenu menuGenerator = new JsonHtmlAllDay();
		FoodItem[] allItems = menuGenerator.fetchFoodItems(jsonInpFilePath);
		allItems = menuGenerator.filterItemsForCountry("GB", allItems);
		Map<FoodItemCategory, FoodItem[]> groupedItems = menuGenerator
				.groupItemsByRestaurantCategory(allItems);
		menuGenerator.printMenu(groupedItems, htmlOutFile);

		System.out.println("Done");
	}
}
