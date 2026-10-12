import java.util.Scanner;

public class Hinhtron {
    private double r ;
    final static double PI = 3.14 ;
    public Hinhtron() {
        r = 0 ;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void set_r(){
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Input r: ");
        this.r = scanner.nextDouble() ;
    }
    public void get_r(){
        System.out.println("r: " + this.r );
    }
    public void get_chuvi(){
        System.out.println("chu vi: " + ( 2*PI*r) );
    }
    public void get_dientich()
    {
        System.out.println("Dien tich: " + (PI*r*r));
    }
}