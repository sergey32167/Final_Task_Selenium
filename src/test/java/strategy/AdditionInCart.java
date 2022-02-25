package strategy;

import pages.MyAccountPage;

public class AdditionInCart implements Addition{

    @Override
    public void addItem() {

        MyAccountPage accountPage = new MyAccountPage(false);
               accountPage.jumpToHomePage()
                .goToItem()
                .addProduct()
                .goToItem()
                .addProduct()
                .goToItem()
                .addProduct()
                .cartEntry()
        ;
    }
}