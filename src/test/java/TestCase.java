import cart.Cart;
import catelog.Products;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCase {
    @Autowired
    private static Products products = Products.getInstance();

    @Autowired
    private static Cart cart = new Cart();
    public static void main (String [] args) {
        System.out.println("======TEST CASE STEP 1====");
        products.printItems();
        cart.addProductToCartByPID(1, 2);
        cart.addProductToCartByPID(2, 2);
        cart.printCartItems();
        products.printItems();

        System.out.println("======TEST CASE STEP 2====");
        cart.addProductToCartByPID(1, 6);
        cart.addProductToCartByPID(2, 2);
        products.printItems();
        cart.printCartItems();

        System.out.println("======TEST CASE STEP 3====");
        cart.removeProductByPID(1);
        cart.removeProductByPID(2);
        products.printItems();
        cart.printCartItems();
        cart.addProductToCartByPID(1, 1);
        cart.addProductToCartByPID(2, 1);
        products.printItems();
        cart.printCartItems();
    }
}
