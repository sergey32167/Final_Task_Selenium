package strategy;

import core.ReadProperties;
import pages.MyAccountPage;

public class AdditionInMyWishlist implements Addition {

    @Override
    public void addItem() {
        MyAccountPage accountPage = new MyAccountPage(false);
        accountPage.signInWishlist()
                .createMyWishlist(ReadProperties.getInstance().getWishlistName())
                .addToWishlist()
                .goToAccount()
                .signInWishlist()
                .contentWishlist()
                .cleanWishlistTable();
    }
}