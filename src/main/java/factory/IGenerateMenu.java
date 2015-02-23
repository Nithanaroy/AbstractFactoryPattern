package factory;

import readers.IReader;
import restaurant.Restaurant;
import restaurant.RestaurantCategory;
import restauranttypes.IRestaurantType;
import writers.IWriter;

public interface IGenerateMenu {
	IReader inputReader = null;
	IWriter menuPrinter = null;
	IRestaurantType resType = null;
	
	public Restaurant[] fetchRestaurants();
	public Restaurant[] filterRestaurantsForCountry(String countryCode);
	public Restaurant[] filterRestaurantsByCategory(RestaurantCategory category);
	public void printMenu(Restaurant[] restaurants);
}
