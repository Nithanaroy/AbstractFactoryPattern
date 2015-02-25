package writers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import restaurant.FoodItem;
import restaurant.FoodItemCategory;

public class XMLWriter extends IWriter {

	@Override
	public void createDocument(Map<FoodItemCategory, FoodItem[]> items,
			String outputFilePath) throws FileNotFoundException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("MenuItems");
			doc.appendChild(rootElement);

			for (FoodItemCategory category : foodCategoriesPrintOrder) {
				if (items.containsKey(category)) {
					Element categoryNode = doc.createElement("MenuCategory");
					categoryNode.setAttribute("category", category.toString()
							.toUpperCase());
					appendXmlForItems(items.get(category), categoryNode, doc);
					rootElement.appendChild(categoryNode);
				}
			}

			// write the content into xml file
			// Source:
			// http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(outputFilePath));
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	private void appendXmlForItems(FoodItem[] foodItems, Element categoryNode,
			Document doc) {
		for (FoodItem item : foodItems) {

			Element menuItemNode = doc.createElement("MenuItem");
			menuItemNode.appendChild(doc.createElement("Name").appendChild(
					doc.createTextNode(item.getName())));

			Element priceNode = doc.createElement("Price");
			// TODO: Get the right currency code
			priceNode.appendChild(doc.createElement("CurrencyCode")
					.appendChild(doc.createTextNode("CODE")));
			priceNode.appendChild(doc.createElement("Amount").appendChild(
					doc.createTextNode(item.getFormattedPrice(""))));

			menuItemNode.appendChild(priceNode);

			menuItemNode.appendChild(doc.createElement("Description")
					.appendChild(doc.createTextNode(item.getDescription())));

			categoryNode.appendChild(menuItemNode);
		}
	}
}
