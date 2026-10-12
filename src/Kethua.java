import java.util.Scanner ;
class Mau extends Toado
{
    private int mau ;
    public Mau()
    {
        mau = 0 ;
    }
    public void input_mau()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap ma mau: ");
        mau = scanner.nextInt() ;
    }
    public void output_mau()
    {
        System.out.println("Ma mau: " + mau);
    }
}
class Line
{
    Toado a , b ;
    public Line()
    {
        a = new Toado() ;
        b = new Toado() ;
    }
    public void set_line()
    {
        System.out.println("Nhap toa do diem A:" );
        a.set_td();
        System.out.println("Nhap toa do diem B: ");
        b.set_td();
    }

    public Toado getA() {
        return a;
    }

    public Toado getB() {
        return b;
    }

    public void setA(Toado a) {
        this.a = a;
    }

    public void setB(Toado b) {
        this.b = b;
    }
    public void get_line()
    {
        System.out.println("Toa do diem a: ");
        a.get_td();
        System.out.println("Toa do diem b: ");
        b.get_td();
    }
    public double tinh_khoang_cach()
    {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY() , 2) ) ;
    }
    public void in_khoang_cach()
    {
        System.out.println("Khoang cach giua hai diem tre mot duong thang: " + tinh_khoang_cach());
    }
}

public class Kethua {
    public static void main( String[] args) {
        Mau a = new Mau() ;
        a.set_td();
        a.input_mau();
        a.get_td();
        a.output_mau();
    }
}
