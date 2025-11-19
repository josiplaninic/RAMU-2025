public abstract class Item {
    private final String sku; //Stock Keeping Unit (ProductNumber)
    private String name;
    private double netSalePrice;
    public String getSku() {
        return sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getNetSalePrice() {
        return netSalePrice;
    }
    public void setNetSalePrice(double netSalePrice) {
        if (netSalePrice<0)
            netSalePrice=0;
        if (netSalePrice>2000)
            netSalePrice=2000;
        this.netSalePrice = netSalePrice;
    }
    public double getVAT(){
        return 0.25;
    }
    public double getPrice(int count){
        return count * getNetSalePrice() * (1 + getVAT());
    }
    public abstract String getItemType();
    public Item(String sku, String name){
        this.sku=sku;
        this.name=name;
        //this.netSalePrice=0;
    }

    public Item(String sku, String name, double price){
        this.sku = sku;
        this.name = name;
        this.netSalePrice = price;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", getSku(), getName());
    }

}

