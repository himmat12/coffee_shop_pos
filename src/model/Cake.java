package model;

/**
 * The {@code Cake} interface represents a cake item that has a cost and a name.
 * Implementing classes should define the specific cost and name of the cake.
 * 
 * @author Himmat
 */
public interface Cake {
	/**
	 * Retrieves the cost of the cake.
	 * 
	 * @return the cost of the cake as a {@code Double}.
	 */
	public Double getCost();

	/**
	 * Retrieves the name of the cake.
	 * 
	 * @return the name of the cake as a {@code String}.
	 */
	public String getName();
}
