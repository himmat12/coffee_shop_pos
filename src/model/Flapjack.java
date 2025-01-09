package model;

import java.util.Objects;

/**
 * The {@code Flapjack} class represents a type of cake. It implements the
 * {@code Cake} interface and provides details about the name and cost of the
 * flapjack.
 * 
 * <p>
 * The class includes constructors for default and custom initialization, along
 * with methods to get and set the properties of the flapjack. It also overrides
 * {@code equals}, {@code hashCode}, and {@code toString} methods for object
 * comparison and representation.
 * </p>
 * 
 * @author Himmat
 */
public class Flapjack implements Cake {

	// fields
	private String name;
	private Double cost;

	// constructors

	/**
	 * Default constructor that initializes the {@code Flapjack} instance with
	 * default values for name ("Flapjack") and cost (2.59).
	 */
	public Flapjack() {
		this.name = "Flapjack";
		this.cost = 2.59;
	}

	/**
	 * Parameterized constructor that initializes the {@code Flapjack} instance with
	 * specified values for name and cost.
	 * 
	 * @param name the name of the flapjack.
	 * @param cost the cost of the flapjack.
	 */
	public Flapjack(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}

	// methods

	/**
	 * Retrieves the cost of the flapjack.
	 * 
	 * @return the cost of the flapjack as a {@code Double}.
	 */
	@Override
	public Double getCost() {
		return cost;
	}

	/**
	 * Retrieves the name of the flapjack.
	 * 
	 * @return the name of the flapjack as a {@code String}.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the flapjack.
	 * 
	 * @param name the name to set for the flapjack.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the cost of the flapjack.
	 * 
	 * @param cost the cost to set for the flapjack.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Generates a hash code for the {@code Flapjack} instance based on its name and
	 * cost.
	 * 
	 * @return a hash code as an {@code int}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cost, name);
	}

	/**
	 * Compares this {@code Flapjack} instance with another object for equality
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
		Flapjack other = (Flapjack) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name);
	}

	/**
	 * Generates a string representation of the {@code Flapjack} instance, including
	 * its name and cost.
	 * 
	 * @return a string representation of the flapjack.
	 */
	@Override
	public String toString() {
		return "Flapjack [name=" + name + ", cost=" + cost + "]";
	}

}
