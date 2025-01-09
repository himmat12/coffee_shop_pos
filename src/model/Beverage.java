package model;

/**
 * The {@code Beverage} interface represents a type of drink that has a cost and
 * a description. Implementing classes should define the specific cost and
 * description of the beverage.
 * 
 * @author Himmat
 */
public interface Beverage {

	/**
	 * Retrieves the total cost of the beverage.
	 * 
	 * @return the cost of the beverage as a {@link Double}.
	 */
	public Double getCost();

	/**
	 * Retrieves a description of the beverage.
	 * 
	 * @return the description of the beverage as a {@link String}.
	 */
	public String getDescription();

}
