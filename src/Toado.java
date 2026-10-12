import java.util.Scanner;

public class Toado {
    private int x ;
    private int y ;
    public Toado ()
    {
        x = 0 ; y = 0 ;
    }
    public void setX( int x )
    {
        this.x = x ;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void set_td ()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("x: ");
        this.x = scanner.nextInt();
        System.out.println("y: ");
        this.y = scanner.nextInt();
    }
    public void get_td ()
    {
        System.out.println(" (" + this.x  + " ; " + this.y + ") ");
    }
    public void move_td ()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("di chuyen x: ");
        int x1 = scanner.nextInt();
        System.out.println("di chuyen y: ");
        int y1 = scanner.nextInt();
        this.x = x + x1 ;
        this.y = y + y1 ;
        get_td();
    }
}