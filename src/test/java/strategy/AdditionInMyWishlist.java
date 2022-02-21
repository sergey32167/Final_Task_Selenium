package strategy;

import pages.MyAccountPage;

public class AdditionInMyWishlist implements Addition {

    @Override
    public void addItem() {
        MyAccountPage accountPage = new MyAccountPage(false);
        accountPage.signInWishlist()
                .createMyWishlist()
                .addToWishlist()
                .goToAccount()
                .signInWishlist()
                .contentWishlist()
                .cleanWishlistTable();
    }
}