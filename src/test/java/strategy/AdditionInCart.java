package strategy;

import pages.MyAccountPage;

public class AdditionInCart implements Addition{

    @Override
    public void addItem() {

        MyAccountPage accountPage = new MyAccountPage(false);
               accountPage.jumpToHomePage()
                .goToItem1()
                .addProduct()
                .goToItem2()
                .addProduct()
                .goToItem3()
                .addProduct()
                .cartEntry()
        ;
    }
}