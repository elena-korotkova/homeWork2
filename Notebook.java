

public class Notebook implements Comparable<Notebook>{
    
    private String brand;
    private int ram;
    private int hddSize;
    private String os;
    private String color;
    private double price;
   
    public void set_brand(String brand){
        this.brand = brand;
    }
    public void set_ram(Integer ram){
        this.ram = ram;
    }
    public void set_hddSize(Integer hddSize){
        this.hddSize = hddSize;
    }
    public void set_os(String os){
        this.os = os;
    }
    public void set_color(String color){
        this.color = color;
    }
    public void set_price(double price){
        this.price = price;
    }

    public String get_brand(){
        return this.brand;
    }
    public Integer get_ram(){
        return this.ram;
    }
    public Integer get_hddSize(){
        return this.hddSize;
    }
    public String get_os(){
        return this.os;
    }
    public String get_color(){
        return this.color;
    }
    public double get_price(){
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %s %s %f",this.brand,this.ram,this.hddSize,this.os,this.color,this.price);
    }

    public int compareTo(Notebook not)
    {
        return this.get_brand().compareToIgnoreCase(not.get_brand());
    }

}
