import java.util.Scanner ;
class Sinhvienchinhquy extends Sinhvien
{
    double Diem_thi_dh ;
    public Sinhvienchinhquy()
    {
        Diem_thi_dh = 0 ;
    }
    @Override
    public void set_sv()
    {
        super.set_sv();
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap diem thi dai hoc: ");
        Diem_thi_dh = scanner.nextDouble() ;
    }
    @Override
    public void get_sv() {
        super.get_sv();
        System.out.println("Diem thi dai hoc: " + Diem_thi_dh );
    }
}
class Sinhvienlienthong extends Sinhvien
{
    String bangcaptruoc;
    int Diem_thi_lienthong ;
    public Sinhvienlienthong()
    {
        bangcaptruoc = "" ;
        Diem_thi_lienthong = 0 ;
    }

    @Override
    public void set_sv() {
        super.set_sv();
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap bang cap truoc: ");
        bangcaptruoc = scanner.nextLine() ;
        System.out.println("Nhap diem thu lien thong: ");
        Diem_thi_lienthong = scanner.nextInt() ;
    }

    @Override
    public void get_sv() {
        super.get_sv();
        System.out.println("Bang cap truoc: " + bangcaptruoc);
        System.out.println("Diem thi lien thong: " + Diem_thi_lienthong);
    }
}
class Quanlysv extends Danhsachsv
{
   public Quanlysv (int max )
   {
       super(max);
   }

    @Override
    public void them_sv() {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Chon sinh vien can them: ");
        System.out.println("1.Sinh vien chinh quy: ");
        System.out.println("2.Sinh vien lien thong : ");
        int sivien = scanner.nextInt() ;
        switch (sivien)
        {
            case 1:
                if ( siso < arr.length ) {
                    Sinhvienchinhquy a = new Sinhvienchinhquy();
                    a.set_sv();
                    arr[siso] = a;
                    siso++;
                    System.out.println("Da them sinh vien thanh cong!");
                    break;
                }
                else System.out.println("So luong sinh vien da toi da!");
            case 2:
                if ( siso < arr.length ) {
                    Sinhvienlienthong a = new Sinhvienlienthong();
                    a.set_sv();
                    arr[siso] = a;
                    siso++;
                    System.out.println("Da them sinh vien thanh cong!");
                    break;
                }
                else System.out.println("So luong sinh vien da toi da!");
            default: System.out.println("Lua chon khong hop le! ");
        }
    }
    public void sua_sv ( String masosv)
    {
        int x = 0 ;
        for ( int i = 0 ; i < siso ; i++ )
        {
            if ( arr[i].mssv.equals(masosv)){
                x = i ;
                break ;
            }
        }
        arr[x].set_sv();
    }
}
public class Dahinh {
    public static void main ( String[] agrs )
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap so luong sinh vien toi da: ");
        int sl_max = scanner.nextInt() ;
        Quanlysv sivien = new Quanlysv(sl_max) ;
        boolean countinue = true ;
        while (countinue) {
            System.out.println("Nhập lựa chọn của bạn: ");
            System.out.println("0.Thoat chuong trinh!");
            System.out.println("1.Them sinh vien moi! ");
            System.out.println("2.In danh sach sinh vien! ");
            System.out.println("3.Xoa sinh vien theo ma sinh vien!");
            System.out.println("4.Tim kiem sinh vien theo ma sinh vien!");
            System.out.println("5.Sua sinh vien dua theo mssv!");
            System.out.println("Lua chon: ");
            int luachon = scanner.nextInt() ;
            scanner.nextLine() ;
            switch (luachon)
            {
                case 0:
                    System.out.println("Bye!");
                    break;
                case 1:
                    sivien.them_sv();
                    break;
                case 2:
                    sivien.print_ds_sv();
                    break;
                case 3:
                    System.out.println("Nhap mssv can xoa: ");
                    String s = scanner.nextLine() ;
                    sivien.xoa_sv(s);
                    break;
                case 4:
                    System.out.println("Nhap mssv can tim kiem: ");
                    String s1 = scanner.nextLine() ;
                    sivien.timkiem_sv(s1);
                    break;
                case 5:
                    System.out.println("Nhap mssv can sua: ");
                    String s2 = scanner.nextLine() ;
                    sivien.sua_sv(s2);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
            if ( luachon == 0 ) countinue = false ;
        }
    }
}
