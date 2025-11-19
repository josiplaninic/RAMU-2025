public class Beverage extends Item {

    private double volume;

    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Beverage(String sku, String name, double volume)
    {
        super(sku, name);
        this.volume=volume;
    }
    public Beverage(String sku, String name,
                    double netSalePrice, double volume)
    {
        super(sku, name, netSalePrice);
        this.volume=volume;
    }

    @Override
    public String getItemType() {
        return "Beverage";
    }
}
