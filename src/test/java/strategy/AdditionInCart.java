package strategy;

import pages.MyAccountPage;

public class AdditionInCart implements Addition{

    @Override
    public void addItem() {

        MyAccountPage accountPage = new MyAccountPage(false);
               accountPage.jumpToHomePage()
                .goToProductByName("Faded Short Sleeve T-shirts")
                .addProduct()
                .goToProductByName("Blouse")
                .addProduct()
                .goToProductByName("Printed Dress")
                .addProduct()
                .cartEntry()
                .addCheck()
        ;
    }
}
