package shopTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    static Cart cart;
    static Cart cart2;
    static Products p1;
    static Products p2;
    static Products p3;

    @BeforeAll
    static void init(){
        cart = new Cart();
        p1 = new Products("Samsung", "Phone", 500);
        p2 = new Products("Apple", "Phone", 700);
        p3 = new Products("LG", "Television", 1000);

        cart.AddToCart(p1);
        cart.AddToCart(p2);
        cart.AddToCart(p3);
    }

    @Test
    void addToCart() {

        assertEquals(3, cart.cartItems.size());
        assertEquals("Samsung", cart.cartItems.get(0).Name);
        assertEquals("Phone", cart.cartItems.get(0).Group);
        assertEquals(500, cart.cartItems.get(0).Price);
    }

    @Test
    void deleteFromCard() {

        assertEquals(3, cart.cartItems.size());

        cart.DeleteFromCart(1);
        assertEquals(2, cart.cartItems.size());
        assertEquals("Samsung", cart.cartItems.get(0).Name);
        assertEquals("Phone", cart.cartItems.get(0).Group);
        assertEquals(500, cart.cartItems.get(0).Price);
    }

    @Test
    void viewCart() {
        cart2 = new Cart();
        cart2.AddToCart(p1);
        cart2.AddToCart(p2);
        cart2.AddToCart(p3);


        assertEquals(3, cart2.cartItems.size());


        assertEquals("Samsung", cart2.cartItems.get(0).Name);
        assertEquals("Phone", cart2.cartItems.get(0).Group);
        assertEquals(500, cart2.cartItems.get(0).Price);

        assertEquals("LG", cart2.cartItems.get(2).Name);
        assertEquals("Television", cart2.cartItems.get(2).Group);
        assertEquals(1000, cart2.cartItems.get(2).Price);

        assertSame(cart2.cartItems, cart2.ViewCart());
    }

    @Test
    void sumTotalPrice() {

        assertEquals(1500, cart.SumTotalPrice());
    }

    @Test
    void makePayment() {
        cart2 = new Cart();
        cart2.AddToCart(p1);
        cart2.AddToCart(p2);
        assertEquals(1200, cart2.SumTotalPrice());
    }
}