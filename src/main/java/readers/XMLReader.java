package readers;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class XMLReader extends IReader {

	@Override
	public FoodItem[] processDocument(String path) {
		FoodItem[] foodItems = null;
		try {

			// Source:
			// http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList foodItemNodes = doc.getElementsByTagName("FoodItem");

			foodItems = new FoodItem[foodItemNodes.getLength()];

			for (int i = 0; i < foodItemNodes.getLength(); i++) {

				Node node = foodItemNodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element foodItemNode = (Element) node;

					String country = foodItemNode.getAttribute("country");
					int id = new Integer(foodItemNode
							.getElementsByTagName("id").item(0)
							.getTextContent());
					String name = foodItemNode.getElementsByTagName("name")
							.item(0).getTextContent();
					String description = foodItemNode
							.getElementsByTagName("description").item(0)
							.getTextContent();
					float price = new Float(foodItemNode
							.getElementsByTagName("price").item(0)
							.getTextContent());
					FoodItemCategory category = FoodItemCategory
							.getCategory(foodItemNode
									.getElementsByTagName("category").item(0)
									.getTextContent());

					foodItems[i] = new FoodItem(id, name, description, country,
							price, category);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodItems;
	}

}
