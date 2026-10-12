import java.util.Scanner;
abstract class Batdongsan {
    String ma_so , Loai ;
    int chieudai , chieurong ;
    public Batdongsan()
    {
        ma_so = "" ;
        chieudai = chieurong = 0 ;
    }
    public abstract int giaban() ;
    public void set_bds()
    {
        Scanner scanner =new Scanner(System.in) ;
        System.out.println("Nhap ma so: ");
        ma_so = scanner.nextLine() ;
        System.out.println("Nhap chieu dai: ");
        chieudai = scanner.nextInt() ;
        System.out.println("Nhap chieu rong: ");
        chieurong = scanner.nextInt() ;
        scanner.nextLine() ;
    }
    public int dientich()
    {
        return chieudai*chieurong ;
    }
    public String toString()
    {
        return "Ma so: " + ma_so + " | chieu dai: " + chieudai + " | chieu rong: " + chieurong ;
    }
}
interface Phikinhdoanh
{
    public int phikinhdoanh() ;
}
class Dattrong extends Batdongsan
{
    public Dattrong()
    {
        super();
        Loai = "Dat trong" ;
    }

    @Override
    public int giaban() {
        return dientich()*10000 ;
    }

    @Override
    public String toString() {
        return super.toString() + " | loai: " + Loai + " | gia ban: " + giaban() ;
    }
}
class NhaO extends Batdongsan
{
    int so_lau ;
    public NhaO(){
        super();
        so_lau = 0 ;
        Loai = "Nha o" ;
    }
    public void set_bds()
    {
        super.set_bds();
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap so lau: ");
        so_lau = scanner.nextInt() ;
    }

    @Override
    public int giaban() {
        return dientich()*10000 + so_lau*100000;
    }

    @Override
    public String toString() {
        return super.toString() + " | loai: " + Loai + " | so lau: " + so_lau + " | gia ban: " + giaban() ;
    }
}
class Khachsan extends Batdongsan implements Phikinhdoanh
{
    int so_sao ;
    public Khachsan()
    {
        super();
        so_sao = 0 ;
        Loai = "Khach san" ;
    }
    public void set_bds()
    {
        super.set_bds();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so sao: ");
        so_sao = scanner.nextInt() ;
    }

    @Override
    public int phikinhdoanh() {
        return chieurong*5000 ;
    }

    @Override
    public int giaban() {
        return dientich()*10000 + so_sao*50000;
    }
    @Override
    public String toString() {
        return super.toString() + " | loai: " + Loai + " | so sao " + so_sao +" | gia ban: " + giaban() + " | phi kinh doanh: " + phikinhdoanh() ;
    }
}
class Bietthu extends Batdongsan implements Phikinhdoanh {
    public Bietthu()
    {
        super();
        Loai = "Biet thu" ;
    }

    @Override
    public int phikinhdoanh() {
        return dientich()*1000;
    }

    @Override
    public int giaban() {
        return dientich()*400000 ;
    }

    @Override
    public String toString() {
        return super.toString() + " | loai: " + Loai + " | gia ban: " + giaban() + " | phi kinh doanh: " + phikinhdoanh();
    }
}
class Quanlybds {
    Batdongsan[] arr ;
    int soluong ;
    public Quanlybds( int max )
    {
        arr = new Batdongsan[max] ;
        soluong = 0 ;
    }
    public void add_bds()
    {
        System.out.println("Nhap lua chon: ");
        System.out.println("1.Them khu dat trong!");
        System.out.println("2.Them nha o!");
        System.out.println("3.Them khach san!");
        System.out.println("4.Them biet thu!");
        System.out.println("Lua chon: ");
        Scanner scanner = new Scanner(System.in) ;
        int Luachon = scanner.nextInt() ;
        scanner.nextLine() ;
        switch (Luachon)
        {
            case 1:
                if ( soluong < arr.length )
                {
                    Dattrong a = new Dattrong() ;
                    a.set_bds();
                    arr[soluong] = a ;
                    soluong++;
                    System.out.println("Them bat dong san thanh cong!");
                }
                else
                {
                    System.out.println("So luong bat dong san da toi da!");
                }
                break;
            case 2:
                if ( soluong < arr.length )
                {
                    NhaO a = new NhaO() ;
                    a.set_bds();
                    arr[soluong] = a ;
                    soluong++;
                    System.out.println("Them bat dong san thanh cong!");
                }
                else
                {
                    System.out.println("So luong bat dong san da toi da!");
                }
                break;
            case 3:
                if ( soluong < arr.length )
                {
                    Khachsan a = new Khachsan() ;
                    a.set_bds();
                    arr[soluong] = a ;
                    soluong++;
                    System.out.println("Them bat dong san thanh cong!");
                }
                else
                {
                    System.out.println("So luong bat dong san da toi da!");
                }
                break;
            case 4:
                if ( soluong < arr.length )
                {
                    Bietthu a = new Bietthu() ;
                    a.set_bds();
                    arr[soluong] = a ;
                    soluong++;
                    System.out.println("Them bat dong san thanh cong!");
                }
                else
                {
                    System.out.println("So luong bat dong san da toi da!");
                }
                break;

            default: System.out.println("Lua chon khong hop le!");
                break;
        }
    }
    public void in_bds()
    {
        for ( int i = 0 ; i < soluong ; i++ )
        {
            System.out.println(arr[i]);
        }
    }
    public void xoa_bds ( String ma_bds)
    {
        if ( arr.length > 0 ) {
            int vitri = -1;
            for (int i = 0; i < soluong; i++) {
                if (arr[i].ma_so.equals(ma_bds)) {
                    vitri = i;
                    break;
                }
            }
            if (vitri == -1) System.out.println("Ma bat dong san khong hop le");
            else {
                Batdongsan a = new Dattrong();
                for (int i = vitri; i < soluong - 1; i++) {
                    a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = a;
                }
                arr[soluong - 1] = null;
                soluong--;
            }
        }
    }
    public void sua_bds( String ma_bds )
    {
        if ( arr.length > 0 ) {
            int vitri = -1;
            for (int i = 0; i < soluong; i++) {
                if (arr[i].ma_so.equals(ma_bds)) {
                    vitri = i;
                    break;
                }
            }
            if (vitri == -1) System.out.println("Ma ho dan khong hop le");
            else arr[vitri].set_bds();
        }
    }
    public void tim_kiem_bds ( String ma_bds )
    {
        if ( arr.length > 0 ) {
            int vitri = -1;
            for (int i = 0; i < soluong; i++) {
                if (arr[i].ma_so.equals(ma_bds)) {
                    vitri = i;
                    break;
                }
            }
            if (vitri == -1) System.out.println("Ma bat dong san khong hop le");
            else System.out.println(arr[vitri]);
        }
    }
    public void tong_gtri_bds()
    {
        long tong_gia_tri_bds = 0 ;
        for ( int i = 0 ; i < soluong ; i++ )
            tong_gia_tri_bds += arr[i].giaban() ;
        System.out.println("Tong gia tri cua tat ca bat dong san: " + tong_gia_tri_bds);
    }
    public void tong_chiphi_kinhdoanh()
    {
        long tong_phi_kdoanh = 0 ;
        for ( int i = 0 ; i < soluong ; i++ )
        {
            if ( arr[i] instanceof  Phikinhdoanh )
            {
                Phikinhdoanh chi_phi = ((Phikinhdoanh) arr[i]) ;
                tong_phi_kdoanh += chi_phi.phikinhdoanh() ;
            }
        }
        System.out.println("Tong chi phi kinh doanh cua tat ca bat dong san: " + tong_phi_kdoanh);
    }
}
public class Quyhoach {
    public static void main( String[] args)
    {
        Scanner scanner = new Scanner(System.in) ;
    }
}
