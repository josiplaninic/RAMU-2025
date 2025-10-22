import java.time.LocalDate;

public  class Food extends Item implements Perishable{
    private double weight;
    private LocalDate bestBefore;

    public Food(String sku, String name, double price, LocalDate bestBefore)
    {
        super(sku, name, price);
        this.bestBefore=bestBefore;
    }
    public Food(String sku, String name, LocalDate bestBefore)
    {
        super(sku, name);
        this.bestBefore=bestBefore;
    }

    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }


    public String getItemType(){
        return "Food";
    }

    @Override
    public double getVAT(){
        return 0.13;
    }

    @Override
    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore=bestBefore;
    }

    @Override
    public LocalDate getBestBefore() {
        return bestBefore;
    }
}
