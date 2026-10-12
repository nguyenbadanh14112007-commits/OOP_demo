import java.util.Scanner;

public class Hinhchunhat{
    private double height ;
    private double weight ;
    public Hinhchunhat()
    {
        this.height = 0 ;
        this.weight = 0 ;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight)
    {
        this.weight = weight ;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void set_hcn ()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("height: ");
        this.height = scanner.nextDouble() ;
        System.out.println("weight: ");
        this.weight = scanner.nextDouble() ;
    }
    public void get_hcn ()
    {
        System.out.println("height: " + this.height );
        System.out.println("weight: " + this.weight);
    }
    public void get_chuvi()
    {
        System.out.println("Chu vi: " + (this.height + this.weight)*2);
    }
    public void get_dientich()
    {
        System.out.println("Dien tich: " + (this.height*this.weight));
    }
}