package model;

/**
 * The {@code AddOns} interface represents additional items that can be added to
 * a base product, such as beverages. Implementing classes should define the
 * specific cost and name of the add-on.
 * 
 * @author Himmat
 */
public interface AddOns {

	/**
	 * Retrieves the cost of the add-on.
	 * 
	 * @return the cost of the add-on as a {@code Double}.
	 */
	public Double getCost();

	/**
	 * Retrieves the name of the add-on.
	 * 
	 * @return the name of the add-on as a {@code String}.
	 */
	public String getName();

}
