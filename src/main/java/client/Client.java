package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;
import factory.IGenerateMenu;
import factory.JsonHtmlAllDay;
import factory.JsonHtmlDiner;
import factory.JsonHtmlEveningOnly;
import factory.JsonTextAllDay;
import factory.JsonTextDiner;
import factory.JsonTextEveningOnly;
import factory.JsonXmlAllDay;
import factory.JsonXmlDiner;
import factory.JsonXmlEveningOnly;
import factory.XmlHtmlAllDay;
import factory.XmlHtmlDiner;
import factory.XmlHtmlEveningOnly;
import factory.XmlTextAllDay;
import factory.XmlTextDiner;
import factory.XmlTextEveningOnly;
import factory.XmlXmlAllDay;
import factory.XmlXmlDiner;
import factory.XmlXmlEveningOnly;

public class Client {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String jsonInpFilePath = "D:\\Cloud\\Dropbox\\Personal Stuff\\ASU Acads\\Sem 2\\Software Design\\Assignments\\1. Design Patters\\Input\\FoodItemData.json";
		String xmlInpFilePath = "D:\\Cloud\\Dropbox\\Personal Stuff\\ASU Acads\\Sem 2\\Software Design\\Assignments\\1. Design Patters\\Input\\FoodItemData.xml";
		String htmlOutFile = "C:\\Users\\Nitin Pasumarthy\\Desktop\\JsonAlldayGBMenu.html";
		String textOutFile = "C:\\Users\\Nitin Pasumarthy\\Desktop\\JsonAlldayGBMenu.txt";
		String xmlOutFile = "C:\\Users\\Nitin Pasumarthy\\Desktop\\JsonAlldayGBMenu.xml";

		/*
		 * User choice 1) Input file type - JSON, XML 2) Country Code 3)
		 * Restaurant Type - Diner, All Day, Evening Only 4) Output file type -
		 * HTML, Text, XML
		 */

		System.out.print("Input file path\t\t: ");
		String inputFilePath = br.readLine().trim();
		String inputType = FilenameUtils.getExtension(inputFilePath)
				.toLowerCase();

		System.out.print("Country Code (Eg: GB)\t\t: ");
		String countryCode = br.readLine().trim().toUpperCase();

		int restaurantType = 0;
		while (restaurantType < 1 || restaurantType > 3) {
			System.out
					.print("Restaurant type\n 1) All day\n 2) Diner\n 3) Evening Only [1-3]\t: ");
			restaurantType = Integer.parseInt(br.readLine());
		}

		System.out.print("Output file path\t: ");
		String outputFilePath = br.readLine().trim();
		String outputType = FilenameUtils.getExtension(outputFilePath)
				.toLowerCase();

		String userChoice = inputType + restaurantType + outputType;

		IGenerateMenu menuGenerator = instantiateFactory(userChoice);

		System.out.println("Fetching food items...");
		FoodItem[] allItems = menuGenerator.fetchFoodItems(inputFilePath);
		System.out.println("Filtering food items for " + countryCode + "...");
		allItems = menuGenerator.filterItemsForCountry(countryCode, allItems);
		System.out.println("Generating menu...");
		Map<FoodItemCategory, FoodItem[]> groupedItems = menuGenerator
				.groupItemsByRestaurantCategory(allItems);
		System.out.println("Printing menu...");
		menuGenerator.printMenu(groupedItems, outputFilePath);
		System.out.println("I am done!");
	}

	private static IGenerateMenu instantiateFactory(String userChoice) {
		IGenerateMenu menuGenerator = null;
		switch (userChoice) {
		case "json1html":
			menuGenerator = new JsonHtmlAllDay();
			break;
		case "json2html":
			menuGenerator = new JsonHtmlDiner();
			break;
		case "json3html":
			menuGenerator = new JsonHtmlEveningOnly();
			break;
		case "json1xml":
			menuGenerator = new JsonXmlAllDay();
			break;
		case "json2xml":
			menuGenerator = new JsonXmlDiner();
			break;
		case "json3xml":
			menuGenerator = new JsonXmlEveningOnly();
			break;
		case "json1txt":
			menuGenerator = new JsonTextAllDay();
			break;
		case "json2txt":
			menuGenerator = new JsonTextDiner();
			break;
		case "json3txt":
			menuGenerator = new JsonTextEveningOnly();
			break;

		case "xml1html":
			menuGenerator = new XmlHtmlAllDay();
			break;
		case "xml2html":
			menuGenerator = new XmlHtmlDiner();
			break;
		case "xml3html":
			menuGenerator = new XmlHtmlEveningOnly();
			break;
		case "xml1xml":
			menuGenerator = new XmlXmlAllDay();
			break;
		case "xml2xml":
			menuGenerator = new XmlXmlDiner();
			break;
		case "xml3xml":
			menuGenerator = new XmlXmlEveningOnly();
			break;
		case "xml1txt":
			menuGenerator = new XmlTextAllDay();
			break;
		case "xml2txt":
			menuGenerator = new XmlTextDiner();
			break;
		case "xml3txt":
			menuGenerator = new XmlTextEveningOnly();
			break;

		default:
			System.out
					.println("Incorrect choice!!!\nPlease verfiy these when you try again: 1) All file paths should have extensions also\n 2) Made the right integer choice of restaurant type.");
			System.exit(-1);
			; // Exiting the program
		}
		return menuGenerator;
	}
}
