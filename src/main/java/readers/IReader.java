package readers;

import java.io.IOException;

import restaurant.FoodItem;


public abstract class IReader {

	abstract public FoodItem[] processDocument(String path) throws IOException;
	
}
