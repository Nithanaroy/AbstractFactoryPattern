package writers;

import restaurant.FoodItem;

public abstract class IWriter {

	abstract public void createDocument(FoodItem[] items);
}
