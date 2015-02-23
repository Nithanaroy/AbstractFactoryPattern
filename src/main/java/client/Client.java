package client;

import org.json.simple.parser.ParseException;

import jdk.nashorn.internal.parser.JSONParser;

import org.json.JSONArray;
import org.json.JSONObject;

public class Client {

	public static void main(String[] args) {
		// JSONReader reader = new JSONReader();
		// Restaurant[] res = reader.processDocument("");

		javaToJson();

		JSONParser parser = new JSONParser(null, null);
		String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		try {
			Object obj = parser.parse();
			JSONArray array = (JSONArray) obj;
			System.out.println("The 2nd element of array");
			System.out.println(array.get(1));
			System.out.println();

			JSONObject obj2 = (JSONObject) array.get(1);
			System.out.println("Field \"1\"");
			System.out.println(obj2.get("1"));

			s = "{}";
			obj = parser.parse(s);
			System.out.println(obj);

			s = "[5,]";
			obj = parser.parse(s);
			System.out.println(obj);

			s = "[5,,2]";
			obj = parser.parse(s);
			System.out.println(obj);
		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}
	}

	private static void javaToJson() {
		JSONObject obj = new JSONObject();

		obj.put("name", "foo");
		obj.put("num", new Integer(100));
		obj.put("balance", new Double(1000.21));
		obj.put("is_vip", new Boolean(true));

		System.out.print(obj);
	}

}
