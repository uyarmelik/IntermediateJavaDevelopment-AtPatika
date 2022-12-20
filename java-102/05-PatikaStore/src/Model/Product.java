package Model;
public abstract class Product extends Brand
{
    Brand brand;
    float cost;
    int discount;
    int stock;
    int memory;
    int power;
    int ram;

    public Product(){
    }

    public Product(Brand brand, String uniqueID, String name, float cost, int discount,
                   int stock, int memory, int power, int ram) {
        super(uniqueID, name);
        this.brand = brand;
        this.cost = cost;
        this.discount = discount;
        this.stock = stock;
        this.memory = memory;
        this.power = power;
        this.ram = ram;
    }

    public Brand getBrand() {
        return brand;
    }

    public float getCost() {
        return cost;
    }

    public int getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public int getMemory() {
        return memory;
    }

    public int getPower() {
        return power;
    }

    public int getRam() {
        return ram;
    }

}