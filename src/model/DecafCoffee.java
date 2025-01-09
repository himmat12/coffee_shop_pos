package model;

import java.util.Objects;

/**
 * The {@code DecafCoffee} class represents a type of decaffeinated coffee. It
 * implements the {@code Beverage} interface and provides details about the
 * name, type, and cost of the coffee.
 * 
 * <p>
 * The class includes constructors for default and custom initialization, along
 * with methods to get and set the properties of the coffee. It also overrides
 * {@code equals}, {@code hashCode}, and {@code toString} methods for object
 * comparison and representation.
 * </p>
 * 
 * @author Himmat
 */
public class DecafCoffee implements Beverage {

	// fields
	private String name;
	private String type;
	private Double cost;

	// constructors

	/**
	 * Default constructor that initializes the {@code DecafCoffee} instance with
	 * default values for name "Decaf Coffee", type "Decaf", and cost (1.51).
	 */
	public DecafCoffee() {
		this.name = "Decaf Coffee";
		this.type = "Decaf";
		this.cost = 1.51;
	}

	/**
	 * Parameterized constructor that initializes the {@code DecafCoffee} instance
	 * with specified values for name, type, and cost.
	 * 
	 * @param name the name of the coffee.
	 * @param type the type of the coffee.
	 * @param cost the cost of the coffee.
	 */
	public DecafCoffee(String name, String type, Double cost) {
		this.name = name;
		this.type = type;
		this.cost = cost;
	}

	// methods

	/**
	 * Retrieves the cost of the coffee.
	 * 
	 * @return the cost of the coffee as a {@code Double}.
	 */
	@Override
	public Double getCost() {
		return cost;
	}

	/**
	 * Retrieves a description of the coffee, which includes the type of coffee.
	 * 
	 * @return the description of the coffee as a {@code String}.
	 */
	@Override
	public String getDescription() {
		final String description = type;

		return description;
	}

	/**
	 * Retrieves the name of the coffee.
	 * 
	 * @return the name of the coffee as a {@code String}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the coffee.
	 * 
	 * @param name the name to set for the coffee.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the type of the coffee.
	 * 
	 * @return the type of the coffee as a {@code String}.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the coffee.
	 * 
	 * @param type the type to set for the coffee.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Sets the cost of the coffee.
	 * 
	 * @param cost the cost to set for the coffee.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Generates a hash code for the {@code DecafCoffee} instance based on its name,
	 * type, and cost.
	 * 
	 * @return a hash code as an {@code int}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cost, name, type);
	}

	/**
	 * Compares this {@code DecafCoffee} instance with another object for equality
	 * based on their name, type, and cost.
	 * 
	 * @param obj the object to compare with.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DecafCoffee other = (DecafCoffee) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	/**
	 * Generates a string representation of the {@code DecafCoffee} instance,
	 * including its name, type, and cost.
	 * 
	 * @return a string representation of the coffee.
	 */
	@Override
	public String toString() {
		return "DecafCoffee [name=" + name + ", type=" + type + ", cost=" + cost + "]";
	}

}
