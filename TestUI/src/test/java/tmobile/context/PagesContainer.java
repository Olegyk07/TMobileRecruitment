package tmobile.context;

import tmobile.pages.*;

public class PagesContainer {
    public final HomePage home;
    public final DevicesPage devices;
    public final SmartphonesPage smartphones;
    public final ProductPage product;
    public final CartPage cart;

    public PagesContainer() {
        this.home = new HomePage();
        this.devices = new DevicesPage();
        this.smartphones = new SmartphonesPage();
        this.product = new ProductPage();
        this.cart = new CartPage();
    }
}