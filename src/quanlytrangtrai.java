import java.util.Scanner ;
import java.util.Random ;
abstract class Giasuc{
    int Soluong , Soluong_con ;
    String loai ;
    public Giasuc(){
        Soluong = 0 ;
        Soluong_con = 0 ;
        loai = "" ;
    }
    public abstract void tiengkeu() ;
    public abstract void Sl_sua() ;
    public abstract void sinh_san() ;
    public void set_giasuc(){
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap so luong loai: ");
        Soluong = scanner.nextInt() ;
    }
    public void get_giasuc(){
        System.out.println("Loai " + loai + " co " + Soluong + " con! ");
    }
}
class Bo extends Giasuc{
    public Bo()
    {
        loai = "Bo" ;
    }

    @Override
    public void tiengkeu() {
        System.out.println("um bo.....");
    }

    @Override
    public void Sl_sua() {
        Random random = new Random() ;
        int sl_sua = 0 ;
        for ( int i = 0 ; i < Soluong ; i++ )
        {
            int sua = random.nextInt(21);
            sl_sua += sua ;
        }
        System.out.println("So luong sua cua tat ca bo la: " + sl_sua );
    }

    @Override
    public void sinh_san() {
        Random random = new Random() ;
        int so_luong_con = 0 ;
        for ( int i = 0 ; i < Soluong ; i++ )
        {
            int so_con = random.nextInt(2) ;
            so_luong_con += so_con ;
        }
        Soluong_con = so_luong_con ;
        System.out.println("So luong con cua 1 lua bo la: " + so_luong_con );
    }
}
class Cuu extends Giasuc{
    public Cuu()
    {
        loai = "Cuu" ;
    }

    @Override
    public void tiengkeu() {
        System.out.println("Be be....");
    }

    @Override
    public void Sl_sua() {
        Random random = new Random() ;
        int sl_sua = 0 ;
        for ( int i = 0 ; i < Soluong ; i++ )
        {
            int sua = random.nextInt(6) ;
            sl_sua += sua ;
        }
        System.out.println("So luong sua cua tat ca Cuu la: " + sl_sua );
    }

    @Override
    public void sinh_san() {
        Random random = new Random() ;
        int so_luong_con = 0 ;
        for ( int i = 0 ; i < Soluong ; i++ )
        {
            int so_con = random.nextInt(3)  ;
            so_luong_con += so_con ;
        }
        Soluong_con = so_luong_con ;
        System.out.println("So luong con cua 1 lua Cuu la: " + so_luong_con );
    }
}
class De extends Giasuc{
    public De()
    {
        loai = "De" ;
    }

    @Override
    public void tiengkeu() {
        System.out.println("Meeee Meeee......");
    }

    @Override
    public void Sl_sua() {
        Random random = new Random() ;
        int sl_sua = 0 ;
        for ( int i = 0 ; i < Soluong ; i++ )
        {
            int sua = random.nextInt(11) ;
            sl_sua += sua ;
        }
        System.out.println("So luong sua cua tat ca De la: " + sl_sua );
    }

    @Override
    public void sinh_san() {
        Random random = new Random() ;
        int so_luong_con = 0 ;
        for ( int i = 0 ; i < Soluong ; i++ )
        {
            int so_con = random.nextInt(4) ;
            so_luong_con += so_con ;
        }
        Soluong_con = so_luong_con ;
        System.out.println("So luong con cua 1 lua De la: " + so_luong_con );
    }
}
class QLtrangtrai {
    Giasuc[] arr = new Giasuc[3] ;
    public QLtrangtrai()
    {
        arr[0] = new Bo() ;
        arr[1] = new Cuu() ;
        arr[2] = new De() ;
    }
    public void set_giasuc()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap so luong bo: ");
        arr[0].Soluong = scanner.nextInt() ;
        System.out.println("Nhap so luong cuu: ");
        arr[1].Soluong = scanner.nextInt() ;
        System.out.println("Nhap so luong De: ");
        arr[2].Soluong = scanner.nextInt() ;
    }
    public void get_giasuc()
    {
        System.out.println("So luong bo: " + arr[0].Soluong);
        arr[0].Sl_sua();
        arr[0].sinh_san();
        System.out.println("So luong cuu: " + arr[1].Soluong);
        arr[1].Sl_sua();
        arr[1].sinh_san();
        System.out.println("So luong De: " + arr[0].Soluong);
        arr[2].Sl_sua();
        arr[2].sinh_san();
    }
    public void giasuc_keu()
    {
        for ( int i = 0 ; i < 3 ; i++ )
        {
            System.out.println("Con " + arr[i].loai + " keu: " );
            arr[i].tiengkeu();
        }
    }
}
public class quanlytrangtrai {
    public static void main( String[] args)
    {
        Scanner scanner = new Scanner(System.in) ;
        QLtrangtrai QL = new QLtrangtrai() ;
        QL.set_giasuc();
        QL.giasuc_keu();
        QL.get_giasuc();
        scanner.close();
    }
}
