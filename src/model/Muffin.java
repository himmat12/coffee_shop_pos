package model;

import java.util.Objects;

/**
 * The {@code Muffin} class represents a type of cake. It implements the
 * {@code Cake} interface and provides details about the name and cost of the
 * muffin.
 * 
 * <p>
 * The class includes constructors for default and custom initialization, along
 * with methods to get and set the properties of the muffin. It also overrides
 * {@code equals}, {@code hashCode}, and {@code toString} methods for object
 * comparison and representation.
 * </p>
 * 
 * @author Himmat
 */
public class Muffin implements Cake {

	// fields
	private String name;
	private Double cost;

	// constructors

	/**
	 * Default constructor that initializes the {@code Muffin} instance with default
	 * values for name ("Muffin") and cost (2.03).
	 */
	public Muffin() {
		this.name = "Muffin";
		this.cost = 2.03;
	}

	/**
	 * Parameterized constructor that initializes the {@code Muffin} instance with
	 * specified values for name and cost.
	 * 
	 * @param name the name of the muffin.
	 * @param cost the cost of the muffin.
	 */
	public Muffin(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}

	// methods

	/**
	 * Retrieves the cost of the muffin.
	 * 
	 * @return the cost of the muffin as a {@code Double}.
	 */
	@Override
	public Double getCost() {
		return cost;
	}

	/**
	 * Retrieves the name of the muffin.
	 * 
	 * @return the name of the muffin as a {@code String}.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the muffin.
	 * 
	 * @param name the name to set for the muffin.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the cost of the muffin.
	 * 
	 * @param cost the cost to set for the muffin.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Generates a hash code for the {@code Muffin} instance based on its name and
	 * cost.
	 * 
	 * @return a hash code as an {@code int}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cost, name);
	}

	/**
	 * Compares this {@code Muffin} instance with another object for equality based
	 * on their name and cost.
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
		Muffin other = (Muffin) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name);
	}

	/**
	 * Generates a string representation of the {@code Muffin} instance, including
	 * its name and cost.
	 * 
	 * @return a string representation of the muffin.
	 */
	@Override
	public String toString() {
		return "Muffin [name=" + name + ", cost=" + cost + "]";
	}

}
