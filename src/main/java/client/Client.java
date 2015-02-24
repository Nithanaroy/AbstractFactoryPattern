package client;

import org.json.JSONObject;

import readers.IReader;
import readers.JSONReader;
import restaurant.FoodItem;
import writers.HTMLWriter;
import writers.IWriter;

public class Client {

	public static void main(String[] args) throws Exception {
		IReader r = new JSONReader();
		FoodItem[] items = r
				.processDocument("D:\\Cloud\\Dropbox\\Personal Stuff\\ASU Acads\\Sem 2\\Software Design\\Assignments\\1. Design Patters\\Input\\FoodItemData.json");
		IWriter w = new HTMLWriter();
		w.createDocument(items);
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
