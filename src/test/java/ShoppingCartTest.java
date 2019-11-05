
import cart.Cart;
import catelog.Products;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartTest {

    @Autowired
    private static Products products = Products.getInstance();

    @Autowired
    private static  Cart cart = new Cart();
    public static void main (String [] args) {
        products.printItems();
        cart.addProductToCartByPID(1, 2);
        cart.addProductToCartByPID(2, 2);
        cart.printCartItems();
        products.printItems();
        cart.removeProductByPID(1);
        cart.removeProductByPID(2);
        cart.printCartItems();

    }
}