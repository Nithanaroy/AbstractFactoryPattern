package readers;

import restaurant.Restaurant;


public abstract class IReader {

	abstract Restaurant[] processDocument(String path);
	
}
