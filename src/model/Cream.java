package model;

import java.util.Objects;

/**
 * The {@code Cream} class represents an add-on item that can be used in
 * beverages. It implements the {@code AddOns} interface and provides details
 * about the name and cost of the cream.
 * 
 * <p>
 * The class includes constructors for default and custom initialization, along
 * with methods to get and set the properties of the cream. It also overrides
 * {@code equals}, {@code hashCode}, and {@code toString} methods for object
 * comparison and representation.
 * </p>
 * 
 * @author Himmat
 */
public class Cream implements AddOns {

	// fields
	private String name;
	private Double cost;

	/**
	 * Default constructor that initializes the cream with a default name ("Cream")
	 * and cost (0.73).
	 */
	public Cream() {
		this.name = "Cream";
		this.cost = 0.73;
	}

	/**
	 * Parameterized constructor that initializes the cream with the specified name
	 * and cost.
	 * 
	 * @param name the name of the cream.
	 * @param cost the cost of the cream.
	 */
	public Cream(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}

	/**
	 * Retrieves the cost of the cream.
	 * 
	 * @return the cost of the cream as a {@code Double}.
	 */
	@Override
	public Double getCost() {
		return cost;
	}

	/**
	 * Retrieves the name of the cream.
	 * 
	 * @return the name of the cream as a {@code String}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the cream.
	 * 
	 * @param name the name to set for the cream.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the cost of the cream.
	 * 
	 * @param cost the cost to set for the cream.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Generates a hash code for the {@code Cream} object based on its name and
	 * cost.
	 * 
	 * @return a hash code as an {@code int}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cost, name);
	}

	/**
	 * Compares this {@code Cream} object with another object for equality.
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
		Cream other = (Cream) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name);
	}

	/**
	 * Returns a string representation of the {@code Cream} object, including its
	 * name and cost.
	 * 
	 * @return a string representation of the cream.
	 */
	@Override
	public String toString() {
		return "Cream [name=" + name + ", cost=" + cost + "]";
	}

}
