package PPJ04;

public class Main {
    public static void main(String[] args) {
        int a = 10;
int b = 20;
IO.println(a);
IO.println(b);
a = a + b;
b = a - b ;
IO.println(" === result === ");
IO.println(a);
IO.println(b);

final double euroRate = 4.32;
double priceInPLN = 250;
double priceInEUR = priceInPLN / euroRate;
IO.println(priceInEUR);
double discount = 0.1;
//euroRate = priceInPLN * discount;
// euroRate++;
double discountedPriceInEUR = (priceInPLN - priceInPLN * discount);
IO.println(discountedPriceInEUR);

//Order:
	String productName = IO.readln("Product name: ");
	int quantity = Integer.parseInt(IO.readln("Quantity: "));
	double pricePerUnit = Double.parseDouble(IO.readln("Price per unit: "));
	boolean expressCourier = Boolean.parseBoolean(IO.readln("Express courier (true/false): "));

          IO.println("Product: " + productName);
          IO.println("Quantity: " + quantity);
         IO.println("Price per unit: " + pricePerUnit);
          IO.println("Price per unit: " + quantity * pricePerUnit);
          IO.println("Express courier: " + expressCourier);

        int score1 = 7, score2 = 8, score3 = 6, score4 = 9;
        double average = (score1 + score2 + score3 + score4) / 4.;
        System.out.println(average);
    }
    }