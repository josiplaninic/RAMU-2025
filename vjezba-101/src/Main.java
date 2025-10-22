import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Food hrana = new Food("1256", "Domaćica", LocalDate.parse("2027-12-03"));
        hrana.setNetSalePrice(10);
        System.out.println(hrana.getBestBefore());
        System.out.println(hrana.getPrice(20));
        System.out.println(hrana);
        System.out.println(hrana.getItemType());

        Beverage pice=new Beverage("2111",
                "Coca-cola", 2);
        System.out.println(pice);
        System.out.println(pice.getItemType());

        Cloth odjeca=new Cloth("3222", "Odijelo", 46);
        System.out.println(odjeca);
        System.out.println(odjeca.getItemType());

    }
}