package view;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardPane extends VBox {
	private OrdersListPane ordersListPane;
	private BeverageListPane beverageListPane;
	private AddonsListPane addonsListPane;
	private CakesListPane cakeListPane;
	private BottomPane bottomPane;

	public DashboardPane() {
		// top box
		HBox hBox1 = new HBox();

		// set panes
		ordersListPane = new OrdersListPane();
		beverageListPane = new BeverageListPane();
		addonsListPane = new AddonsListPane();
		cakeListPane = new CakesListPane();
		bottomPane = new BottomPane();

		VBox vBox1 = new VBox();
		vBox1.getChildren().addAll(beverageListPane, addonsListPane, cakeListPane);

		hBox1.getChildren().addAll(ordersListPane, vBox1);

		// dashboard attributes
		this.setPadding(new Insets(12, 16, 12, 16));
		this.setSpacing(30);
		this.getChildren().addAll(hBox1, bottomPane);
	}

	/**
	 * @return the bottomPane
	 */
	public BottomPane getBottomPane() {
		return bottomPane;
	}

	/**
	 * @param bottomPane the bottomPane to set
	 */
	public void setBottomPane(BottomPane bottomPane) {
		this.bottomPane = bottomPane;
	}

	/**
	 * @return the cakeListPane
	 */
	public CakesListPane getCakeListPane() {
		return cakeListPane;
	}

	/**
	 * @param cakeListPane the cakeListPane to set
	 */
	public void setCakeListPane(CakesListPane cakeListPane) {
		this.cakeListPane = cakeListPane;
	}

	/**
	 * @return the ordersListPane
	 */
	public OrdersListPane getOrdersListPane() {
		return ordersListPane;
	}

	/**
	 * @param ordersListPane the ordersListPane to set
	 */
	public void setOrdersListPane(OrdersListPane ordersListPane) {
		this.ordersListPane = ordersListPane;
	}

	/**
	 * @return the BeverageListPane
	 */
	public BeverageListPane getBeverageListPane() {
		return beverageListPane;
	}

	/**
	 * @param BeverageListPane the BeverageListPane to set
	 */
	public void setBeverageListPane(BeverageListPane beverageListPane) {
		this.beverageListPane = beverageListPane;
	}

	/**
	 * @return the AddonsListPane
	 */
	public AddonsListPane getAddonsListPane() {
		return addonsListPane;
	}

	/**
	 * @param AddonsListPane the AddonsListPane to set
	 */
	public void setAddonsListPane(AddonsListPane addonsListPane) {
		this.addonsListPane = addonsListPane;
	}

}
