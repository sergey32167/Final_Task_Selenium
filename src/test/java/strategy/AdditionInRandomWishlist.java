package strategy;

import pages.MyAccountPage;

public class AdditionInRandomWishlist implements Addition {

    @Override
    public void addItem() {
        MyAccountPage accountPage = new MyAccountPage(false);
        accountPage.signInWishlist()
                .createRandomWishlist()
                .addToWishlist()
                .goToAccount()
                .signInWishlist()
                .contentMyWishlist()
                .cleanWishlistTable()
        ;
    }
}