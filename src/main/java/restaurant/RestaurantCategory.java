package restaurant;

public enum RestaurantCategory {
	DINER("Diner"), EVENING_ONLY("Evening Only"), ALL_DAY("All Day");

	private final String displayName;

	RestaurantCategory(String displayName) {
		this.displayName = displayName;
	}

	public String toString() {
		return this.displayName;
	}
}
