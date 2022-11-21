package shopTests;

public class Main {
    public static void main(String[] args) {


        Products p1 = new Products("Samsung", "Phone", 500);
        Products p2 = new Products("Apple", "Phone", 700);
        Products p3 = new Products("LG", "Television", 1000);

        Admin admin1 = new Admin("Cashier");

        admin1.AddProducts(p1.Name, p1.Group, p1.Price);
        admin1.AddProducts(p2.Name, p2.Group, p2.Price);
        admin1.AddProducts(p3.Name, p3.Group, p3.Price);


        System.out.println("\nCashier adds Products :");
        admin1.ViewProducts();
        Customer customer1 = new Customer("Noor");

//Products are added to cart by customer

        customer1.AddToCart(p1);
        customer1.AddToCart(p2);
        customer1.AddToCart(p3);

        System.out.println("\nCart Items : ");
        customer1.ViewCartProducts();

        System.out.println();
        System.out.println("\nTotal Price: " + "$"+customer1.cart.SumTotalPrice());


        System.out.println("\nPayable :");

        customer1.payment.MakePayment(customer1.cart.SumTotalPrice());


        System.out.println("\nGuest view Products : ");

        Guest guest1 = new Guest();
        guest1.ViewProducts(admin1);
        guest1.GetRegistered(customer1.Name);


    }
}