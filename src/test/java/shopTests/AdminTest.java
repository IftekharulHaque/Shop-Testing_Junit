package shopTests;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    static Admin admin1;
    static Admin admin2;
    static Products product1;
    static Products product2;
    static Products product3;


    @BeforeAll
    static void init(){
        admin1 = new Admin("admin1");
        admin2 = new Admin("admin2");

        product1 = new Products("Samsung", "Phone", 500);
        product2 = new Products("Apple", "Phone", 700);
        product3 = new Products("LG", "Televison", 1000);

        admin1.AddProducts(product1.Name, product1.Group, product1.Price);
        admin1.AddProducts(product2.Name, product2.Group, product2.Price);
        admin1.AddProducts(product3.Name, product3.Group, product3.Price);
    }

    @Test
    void ProductsItemsSizeIsThree() {
        assertEquals(3, admin1.productItems.size());
    }

    @Test
    void viewProducts() {

        assertEquals(3, admin1.productItems.size());

        assertEquals("Samsung", admin1.productItems.get(0).Name);
        assertEquals("Phone", admin1.productItems.get(0).Group);
        assertEquals(4, admin1.productItems.get(0).Id);
        assertEquals(500, admin1.productItems.get(0).Price);
    }

    @Test
    void addProducts() {
        admin2.AddProducts(product1.Name, product1.Group, product1.Price);
        assertEquals(1, admin2.productItems.size());

        admin2.AddProducts(product2.Name, product2.Group, product2.Price);
        assertEquals(2, admin2.productItems.size());

        admin2.AddProducts(product3.Name, product3.Group, product3.Price);
        assertEquals(3, admin2.productItems.size());
    }

    @Test
    void deleteProducts() {
        admin1.DeleteProducts(1);
        assertEquals(2, admin1.productItems.size());

        admin1.DeleteProducts(0);
        assertEquals(1, admin1.productItems.size());

    }

    @Test
    void modifyProducts() {
        admin2.AddProducts(product1.Name, product1.Group, product1.Price);
        admin2.AddProducts(product2.Name, product2.Group, product2.Price);
        admin2.AddProducts(product3.Name, product3.Group, product3.Price);


        admin2.ModifyProducts(0,"Xiaomi", "Fan", 100);
        assertEquals("Xiaomi", admin2.productItems.get(0).Name);
        assertEquals("Fan", admin2.productItems.get(0).Group);
        assertEquals(100, admin2.productItems.get(0).Price);
    }
}