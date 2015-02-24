package restaurant;

public class FoodItem {
	private int id;
	private String name, description, country;
	private float price;
	private FoodItemCategory category;

	public FoodItem(int id, String name, String description, String country,
			float price, FoodItemCategory category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.country = country;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public FoodItemCategory getCategory() {
		return category;
	}

	public void setCategory(FoodItemCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return getName();
	}

}
