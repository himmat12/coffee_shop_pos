package model;

import java.util.Objects;

/**
 * The {@code Panettone} class represents a type of cake. It implements the
 * {@code Cake} interface and provides details about the name and cost of the
 * panettone.
 * 
 * <p>
 * The class includes constructors for default and custom initialization, along
 * with methods to get and set the properties of the panettone. It also
 * overrides {@code equals}, {@code hashCode}, and {@code toString} methods for
 * object comparison and representation.
 * </p>
 * 
 * @author Himmat
 */
public class Panettone implements Cake {

	// fields
	private String name;
	private Double cost;

	// constructors

	/**
	 * Default constructor that initializes the {@code Panettone} instance with
	 * default values for name ("Panettone") and cost (2.88).
	 */
	public Panettone() {
		this.name = "Panettone";
		this.cost = 2.88;
	}

	/**
	 * Parameterized constructor that initializes the {@code Panettone} instance
	 * with specified values for name and cost.
	 * 
	 * @param name the name of the panettone.
	 * @param cost the cost of the panettone.
	 */
	public Panettone(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}

	// methods

	/**
	 * Retrieves the cost of the panettone.
	 * 
	 * @return the cost of the panettone as a {@code Double}.
	 */
	@Override
	public Double getCost() {
		return cost;
	}

	/**
	 * Retrieves the name of the panettone.
	 * 
	 * @return the name of the panettone as a {@code String}.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the panettone.
	 * 
	 * @param name the name to set for the panettone.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the cost of the panettone.
	 * 
	 * @param cost the cost to set for the panettone.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Generates a hash code for the {@code Panettone} instance based on its name
	 * and cost.
	 * 
	 * @return a hash code as an {@code int}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cost, name);
	}

	/**
	 * Compares this {@code Panettone} instance with another object for equality
	 * based on their name and cost.
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
		Panettone other = (Panettone) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name);
	}

	/**
	 * Generates a string representation of the {@code Panettone} instance,
	 * including its name and cost.
	 * 
	 * @return a string representation of the panettone.
	 */
	@Override
	public String toString() {
		return "Panettone [name=" + name + ", cost=" + cost + "]";
	}

}
