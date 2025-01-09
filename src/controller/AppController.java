package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.AddOns;
import model.Beverage;
import model.Cake;
import model.Cream;
import model.DecafCoffee;
import model.Flapjack;
import model.Milk;
import model.Muffin;
import model.Panettone;
import model.RegularCoffee;
import model.Sprinkles;
import model.Sugar;
import view.AddonsListPane;
import view.BeverageListPane;
import view.BottomPane;
import view.CakesListPane;
import view.DashboardPane;
import view.OrdersListPane;

public class AppController {

	// fields

	// array of coffee - purpose of this array is to swap element at 0 index as only
	// one type of coffee can be selected at a time
	private ArrayList<String> coffeeArr = new ArrayList<String>();

	// unique set of add ons
	private Set<String> addOnsSet = new HashSet<String>();

	// ckaes frequency map - which accumulates the number of same type of cakes with
	// key (cake name) value (frequency) paired
	private HashMap<String, Integer> cakesFreq = new HashMap<String, Integer>();

	// to store string value of each item order
	private String itemField;

	private ArrayList<String> orders = new ArrayList<String>(); // orders

	private DashboardPane dashboard;
	private OrdersListPane ordersListPane;
	private BeverageListPane beverageListPane;
	private AddonsListPane addonListPane;
	private CakesListPane cakesListPane;
	private BottomPane bottomPane;

	// constructors
	public AppController(DashboardPane dashboard) {
		this.dashboard = dashboard;

		ordersListPane = dashboard.getOrdersListPane();

		beverageListPane = dashboard.getBeverageListPane();
		beverageListPane.addBeveragesData(generateBeverages(), (b) -> handleBeverageEvent(b));

		addonListPane = dashboard.getAddonsListPane();
		addonListPane.addAddOnsData(generateAddons(), this::handleAddonsEvent);

		cakesListPane = dashboard.getCakeListPane();
		cakesListPane.addCakesData(generateCakes(), this::handleCakesEvent);

		bottomPane = dashboard.getBottomPane();

		// ataching event handlers for view from controller
		attachEventHandlers();
	}

	// methods

	/**
	 * alert dialog box
	 */
	private void alert(String title, String header, String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(text);
		alert.showAndWait();
	}

	/**
	 * helper method - handles action event of beverages
	 */
	private void handleBeverageEvent(Beverage beverage) {
		coffeeArr.add(0, beverage.getDescription());

		itemField = "1 x " + coffeeArr.get(0); // updating input value string
		addOnsSet.clear(); // resetting addons set
		bottomPane.setTextFieldText(itemField); // upadting view state
	}

	/**
	 * helper method - handles action event of addons
	 */
	private void handleAddonsEvent(AddOns addOns) {
		if (!coffeeArr.isEmpty()) {
			// validating only one addons entry logic - alerting dialog box when user press
			// same btn more than one time
			if (!addOnsSet.contains(addOns.getName())) {
				addOnsSet.add(addOns.getName());
				itemField += " + " + addOns.getName();
				bottomPane.setTextFieldText(itemField); // upadting view state
			} else {
				alert("Info", addOns.getName() + " already added.", "Add-on items cannot be added twice!");
			}
		} else {
			alert("Info", addOns.getName() + " cannot be added without coffee.",
					"Please select coffee first to add add-ons items!");
		}
	}

	/**
	 * helper method - handles action event of cakes
	 */
	private void handleCakesEvent(Cake cake) {
		// validating cakes - cakes cannot be added with coffee and addons
		if (coffeeArr.isEmpty() && addOnsSet.isEmpty()) {
			if (!cakesFreq.containsKey(cake.getName())) {
				cakesFreq.clear(); // reseting before switching to different cake
				cakesFreq.put(cake.getName(), 1); // if there is no cake in the hashMap
			} else {
				cakesFreq.put(cake.getName(), cakesFreq.get(cake.getName()) + 1); // if cake already exists then
																					// increment frequency by 1
			}

			itemField = cakesFreq.get(cake.getName()) + " x " + cake.getName();
			bottomPane.setTextFieldText(itemField); // upadting view state
		} else {
			alert("Info", "Cakes cannot be added with coffee.", "Only add-ons can be added with coffee!");
		}
	}

	/**
	 * helper method - attaches the event handler to bottom pane from controller
	 */
	private void attachEventHandlers() {
		bottomPane.addAddBtnHandler(e -> {
			if (!bottomPane.getTextField().getText().isEmpty() && !itemField.isEmpty()) {
				orders.add(itemField); // adding each item string from item field
				resetItemFieldData(); // clearing item field along with all related datas
				ordersListPane.setOrders('"' + String.join(", ", orders) + '"'); // updating view
			} else {
				alert("Info", "Item field empty.",
						"Please select your items (coffee + add-ons / cakes) before you add them to your orders!");
			}

		});

		bottomPane.addClearBtnHandler(e -> {
			resetItemFieldData(); // clearing item field along with all related datas
		});

		bottomPane.addVoidOrderBtnHandler(e -> {
			resetItemFieldData(); // resetting items field and related datas
			orders.clear(); // reseting the order list
			ordersListPane.setOrders(""); // updating view
		});

		bottomPane.addPayBtnHandler(e -> {
			// converting orders array into string of orders - to comply with the coding
			// assessment specification of input being a string type
			final String strOrders = String.join(", ", orders);
			if (!orders.isEmpty()) {
				alert("Checkout", "Orders summary:\n\n" + String.join("\n", orders),
						"Final bill is $" + getTotalOrder(strOrders));
				getTotalOrder(strOrders);
			} else {
				alert("Info", "No any orders yet.", "Please add an items to your orders list before you pay!");
			}

		});
	}

	/**
	 * helper method - calculates the input string order and returns the calculated
	 * order string
	 */
	private String getTotalOrder(String strOrders) {
		String[] items = new String[0]; // items in an order
		Double totalCost = 0.0; // total cost of the order
		var orders = strOrders.split(", "); // Spiting the string of orders into separate orders

		// Separating each order
		for (String order : orders) {
			items = order.split(" \\+ ");

			// getting quantity and main item from the order (eg. 1 x Regular / 1 x Muffin)
			String mainOrder = items[0]; // main item (eg. 1 x Mufin / 1 x Regular)
			String[] mainOrderParts = mainOrder.split(" x "); // spliting the qty and main order item seperately
			int qty = Integer.parseInt(mainOrderParts[0]); // quantity of the item
			String itemName = mainOrderParts[1].trim().toLowerCase(); // name of the item

			Double itemCost = 0.0; // item cost

			// initializing main items and calculating the cost
			Beverage beverage = createBeverage(itemName); // for beverages
			Cake cake = createCake(itemName); // for cakes

			if (beverage != null) {
				itemCost = beverage.getCost() * qty;
			} else if (cake != null) {
				itemCost = cake.getCost() * qty;
			}

			// initializing add ons items nd calculating the cost
			for (int i = 1; i < items.length; i++) {
				String addOnName = items[i].trim().toLowerCase();
				AddOns addOn = createAddOn(addOnName);

				if (addOnName != null) {
					itemCost += addOn.getCost();
				}

			}
			// adding each item cost to total cost
			totalCost += itemCost;

		}

		// converting double to big double and setting scale of 2 to grab first 2 digits
		// after decimal and rounding up to the next digit
		String totalCostStr = new BigDecimal(totalCost).setScale(2, RoundingMode.HALF_UP).toString();

		return totalCostStr;
	}

	/**
	 * helper method - creates a Beverage object based on item name
	 */
	private Beverage createBeverage(String itemName) {
		switch (itemName) {
		case "regular":
			return new RegularCoffee();
		case "decaf":
			return new DecafCoffee();
		default:
			return null;
		}
	}

	/**
	 * helper method - creates an AddOns object based on addon name
	 */
	private AddOns createAddOn(String addonName) {
		switch (addonName) {
		case "milk":
			return new Milk();
		case "sugar":
			return new Sugar();
		case "cream":
			return new Cream();
		case "sprinkles":
			return new Sprinkles();
		default:
			return null;
		}
	}

	/**
	 * helper method - creates a Cake object based on item name
	 */
	private Cake createCake(String itemName) {
		switch (itemName) {
		case "muffin":
			return new Muffin();
		case "flapjack":
			return new Flapjack();
		case "panettone":
			return new Panettone();
		default:
			return null;
		}
	}

	/**
	 * helper method - resets all the datas from itemField, coffeeArr, addOnsSet,
	 * and cakesFreq
	 */
	private void resetItemFieldData() {
		// resetting everything
		coffeeArr.clear();
		addOnsSet.clear();
		cakesFreq.clear();
		itemField = "";

		bottomPane.clearTextField(); // updating view
	}

	/**
	 * This method generates beverages
	 */
	public ArrayList<Beverage> generateBeverages() {

		ArrayList<Beverage> beverages = new ArrayList<Beverage>();
		beverages.add(new RegularCoffee());
		beverages.add(new DecafCoffee());

		return beverages;
	}

	/**
	 * This method generates add ons
	 */
	public ArrayList<AddOns> generateAddons() {
		ArrayList<AddOns> addOns = new ArrayList<AddOns>();
		addOns.add(new Milk());
		addOns.add(new Sugar());
		addOns.add(new Cream());
		addOns.add(new Sprinkles());

		return addOns;
	}

	/**
	 * This method generates cakes
	 */
	public ArrayList<Cake> generateCakes() {
		ArrayList<Cake> cakes = new ArrayList<Cake>();
		cakes.add(new Muffin());
		cakes.add(new Flapjack());
		cakes.add(new Panettone());

		return cakes;
	}

}
