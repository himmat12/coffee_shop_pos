package model;

import java.util.Objects;

/**
 * The {@code RegularCoffee} class represents a type of regular coffee. It
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
public class RegularCoffee implements Beverage {

	// fields
	private String name;
	private String type;
	private Double cost;

	// constructors

	/**
	 * Default constructor that initializes the {@code RegularCoffee} instance with
	 * default values for name "Regular Coffee", type "Regular", and cost (2.11).
	 */
	public RegularCoffee() {
		this.name = "Regular Coffee";
		this.type = "Regular";
		this.cost = 2.11;
	}

	/**
	 * Parameterized constructor that initializes the {@code RegularCoffee} instance
	 * with specified values for name, type, and cost.
	 * 
	 * @param name the name of the coffee.
	 * @param type the type of the coffee.
	 * @param cost the cost of the coffee.
	 */
	public RegularCoffee(String name, String type, Double cost) {
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
	 * Generates a string representation of the {@code RegularCoffee} instance,
	 * including its name, type, and cost.
	 * 
	 * @return a string representation of the coffee.
	 */
	@Override
	public String toString() {
		return "RegularCoffee [name=" + name + ", type=" + type + ", cost=" + cost + "]";
	}

	/**
	 * Generates a hash code for the {@code RegularCoffee} instance based on its
	 * name, type, and cost.
	 * 
	 * @return a hash code as an {@code int}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cost, name, type);
	}

	/**
	 * Compares this {@code RegularCoffee} instance with another object for equality
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
		RegularCoffee other = (RegularCoffee) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

}
