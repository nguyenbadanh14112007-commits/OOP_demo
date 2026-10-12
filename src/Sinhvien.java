import java.util.Scanner;

public class Sinhvien {
    String mssv, hoten , lop , gioi_tinh , ngay_sinh , so_dt , dia_chi;
    double diem1 , diem2 , diem3 ;
    public Sinhvien() {
        mssv = hoten = lop = gioi_tinh = ngay_sinh = so_dt = dia_chi = "" ;
        diem1 = diem2 = diem3 = 0 ;
    }
    public void set_sv() {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("mssv: ");
        mssv = scanner.nextLine() ;
        System.out.println("Ho ten: ");
        hoten = scanner.nextLine() ;
        System.out.println("Lop: ");
        lop = scanner.nextLine() ;

        System.out.println("diem mon 1: ");
        diem1 = scanner.nextDouble() ;
        System.out.println("diem mon 2: ");
        diem2 = scanner.nextDouble() ;
        System.out.println("diem mon 3: ");
        diem3 = scanner.nextDouble() ;
    }
    public void get_sv() {
        System.out.println("mssv: " + mssv );
        System.out.println("Ho ten: " + hoten);
        System.out.println("Lop: " + lop );
        System.out.println("diem mon 1: " + diem1 );
        System.out.println("diem mon 2: " + diem2 );
        System.out.println("diem mon 3: " + diem3 );
    }
    public void diemTB()
    {
        System.out.println("Diem trung binh: " + (diem1 + diem2 + diem3)/3);
    }
    public void xeploai()
    {
        double Diemtb = (diem1 + diem2 + diem3)/3 ;
        if ( Diemtb >= 9 ) System.out.println("Xep loai: Xuat sac!");
        else if ( Diemtb >= 8 ) System.out.println("Xep loai: Gioi!");
        else if ( Diemtb >= 7 ) System.out.println("Xep loai: Kha!");
        else if ( Diemtb >= 6.5 ) System.out.println("Xep loai: Trung binh!");
        else System.out.println("Xep loai: yeu!");
    }
}
