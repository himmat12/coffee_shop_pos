package model;

import java.util.Objects;

/**
 * The {@code Milk} class represents an add-on item that can be used in
 * beverages. It implements the {@code AddOns} interface and provides details
 * about the name and cost of the milk.
 * 
 * <p>
 * The class includes constructors for default and custom initialization, along
 * with methods to get and set the properties of the milk. It also overrides
 * {@code equals}, {@code hashCode}, and {@code toString} methods for object
 * comparison and representation.
 * </p>
 * 
 * @author Himmat
 */
public class Milk implements AddOns {

	// fields
	private String name;
	private Double cost;

	// constructors

	/**
	 * Default constructor that initializes the {@code Milk} instance with default
	 * values for name ("Milk") and cost (0.53).
	 */
	public Milk() {
		this.name = "Milk";
		this.cost = 0.53;
	}

	/**
	 * Parameterized constructor that initializes the {@code Milk} instance with
	 * specified values for name and cost.
	 * 
	 * @param name the name of the milk.
	 * @param cost the cost of the milk.
	 */
	public Milk(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}

	// methods

	/**
	 * Retrieves the cost of the milk.
	 * 
	 * @return the cost of the milk as a {@code Double}.
	 */
	@Override
	public Double getCost() {
		return cost;
	}

	/**
	 * Retrieves the name of the milk.
	 * 
	 * @return the name of the milk as a {@code String}.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the milk.
	 * 
	 * @param name the name to set for the milk.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the cost of the milk.
	 * 
	 * @param cost the cost to set for the milk.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Generates a hash code for the {@code Milk} instance based on its name and
	 * cost.
	 * 
	 * @return a hash code as an {@code int}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cost, name);
	}

	/**
	 * Compares this {@code Milk} instance with another object for equality based on
	 * their name and cost.
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
		Milk other = (Milk) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name);
	}

	/**
	 * Generates a string representation of the {@code Milk} instance, including its
	 * name and cost.
	 * 
	 * @return a string representation of the milk.
	 */
	@Override
	public String toString() {
		return "Milk [name=" + name + ", cost=" + cost + "]";
	}

}
