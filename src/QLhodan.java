import java.util.Scanner ;
abstract class Hodan {
    String ten_chu_ho , Dia_chi , Loai_hodan , Ma_hodan;
    int so_nuoc_cu , so_nuoc_moi ;
    public Hodan()
    {
        ten_chu_ho = Dia_chi = Loai_hodan = Ma_hodan =  "" ;
        so_nuoc_moi = so_nuoc_cu = 0 ;
    }
    public void set_Hodan()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap ma ho dan: ");
        Ma_hodan = scanner.nextLine() ;
        System.out.println("Nhap ten ho dan: ");
        ten_chu_ho =scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        Dia_chi = scanner.nextLine() ;
        System.out.println("Nhap so nuoc cu: ");
        so_nuoc_cu = scanner.nextInt() ;
        System.out.println("Nhap so nuoc moi: ");
        so_nuoc_moi = scanner.nextInt() ;
    }
    public abstract void Tien_nuoc() ;
    public void get_Hodan()
    {
        System.out.println("Ma ho dan: " + Ma_hodan);
        System.out.println("Ten chu ho: " + ten_chu_ho);
        System.out.println("Dia chi: " + Dia_chi );
        System.out.println("So nuoc cu: " + so_nuoc_cu );
        System.out.println("So nuoc moi: " + so_nuoc_moi);
        Tien_nuoc();
    }
}
class HodanA extends Hodan
{
    int so_nhan_khau ;
    public HodanA(){
        super();
        so_nhan_khau = 0;
        Loai_hodan = "Ho dan A" ;
    }

    @Override
    public void set_Hodan() {
        super.set_Hodan();
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap so nhan khau: ");
        so_nhan_khau = scanner.nextInt() ;
    }

    @Override
    public void get_Hodan() {
        super.get_Hodan();
        System.out.println("So nhan khau: " + so_nhan_khau);
    }

    @Override
    public void Tien_nuoc() {
        int khoi_nuoc_su_dung = so_nuoc_moi - so_nuoc_cu ;
        int so_nuoc_tra_tien = khoi_nuoc_su_dung - 5*so_nhan_khau ;
        if ( so_nuoc_tra_tien <= 0 ) so_nuoc_tra_tien = 0 ;
        System.out.println("So tien nuoc can tra: " + so_nuoc_tra_tien*8000);
    }
}
class HodanB extends Hodan
{
    public HodanB()
    {
        super();
        Loai_hodan = "Ho dan B" ;
    }
    @Override
    public void Tien_nuoc() {
        int khoi_nuoc_su_dung = so_nuoc_moi - so_nuoc_cu ;
        int so_nuoc_tra_tien = (khoi_nuoc_su_dung>20)?(khoi_nuoc_su_dung - 20):0 ;
        System.out.println("So tien nuoc can tra: " + so_nuoc_tra_tien*8000);
    }
}
class HodanC extends Hodan
{
    int so_nhan_khau_phucvu_chungcu ;
    public HodanC(){
        super();
        Loai_hodan = "Ho dan C" ;
        so_nhan_khau_phucvu_chungcu = 0;
    }

    @Override
    public void set_Hodan() {
        super.set_Hodan();
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap so nhan khau phuc vu cho chung cu: ");
        so_nhan_khau_phucvu_chungcu = scanner.nextInt() ;
    }

    @Override
    public void Tien_nuoc() {
        int khoi_nuoc_su_dung = so_nuoc_moi - so_nuoc_cu ;
        int so_nuoc_tra_tien = khoi_nuoc_su_dung - 10*so_nhan_khau_phucvu_chungcu ;
        if ( so_nuoc_tra_tien <= 0 ) so_nuoc_tra_tien = 0 ;
        System.out.println("So tien nuoc can tra: " + so_nuoc_tra_tien*8000);
    }
}
class Quanlyhodan
{
    Hodan[] arr ;
    int so_luong_ho_dan ;
    public Quanlyhodan( int max )
    {
        arr = new Hodan[max] ;
        so_luong_ho_dan = 0 ;
    }
    public void them_hodan()
    {
        System.out.println("Nhap lua chon: ");
        System.out.println("1.Them ho dan A!");
        System.out.println("2.Them ho dan B!");
        System.out.println("3.Them ho dan C!");
        System.out.println("Lua chon: ");
        Scanner scanner = new Scanner(System.in) ;
        int Luachon = scanner.nextInt() ;
        scanner.nextLine() ;
        switch (Luachon)
        {
            case 1:
                if ( so_luong_ho_dan < arr.length )
                {
                    HodanA a = new HodanA() ;
                    a.set_Hodan();
                    arr[so_luong_ho_dan] = a ;
                    so_luong_ho_dan++;
                    System.out.println("Them ho dan thanh cong!");
                }
                else
                {
                    System.out.println("So luong ho dan da toi da!");
                }
                break;
            case 2:
                if ( so_luong_ho_dan < arr.length )
                {
                    HodanB a = new HodanB() ;
                    a.set_Hodan();
                    arr[so_luong_ho_dan] = a ;
                    so_luong_ho_dan++;
                    System.out.println("Them ho dan thanh cong!");
                }
                else
                {
                    System.out.println("So luong ho dan da toi da!");
                }
                break;
            case 3:
                if ( so_luong_ho_dan < arr.length )
                {
                    HodanC a = new HodanC() ;
                    a.set_Hodan();
                    arr[so_luong_ho_dan] = a ;
                    so_luong_ho_dan++;
                    System.out.println("Them ho dan thanh cong!");
                }
                else
                {
                    System.out.println("So luong ho dan da toi da!");
                }
                break;
            default: System.out.println("Lua chon khong hop le!");
            break;
        }
    }
    public void in_hodan()
    {
        for ( int i = 0 ; i < so_luong_ho_dan ; i++ )
        {
            arr[i].get_Hodan();
        }
    }
    public void xoa ( String ma_hodan)
    {
        if ( arr.length > 0 ) {
            int vitri = -1;
            for (int i = 0; i < so_luong_ho_dan; i++) {
                if (arr[i].Ma_hodan.equals(ma_hodan)) {
                    vitri = i;
                    break;
                }
            }
            if (vitri == -1) System.out.println("Ma ho dan khong hop le");
            else {
                Hodan a = new HodanA();
                for (int i = vitri; i < so_luong_ho_dan - 1; i++) {
                    a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = a;
                }
                arr[so_luong_ho_dan - 1] = null;
                so_luong_ho_dan--;
            }
        }
    }
    public void sua_hodan( String ma_hodan )
    {
        if ( arr.length > 0 ) {
            int vitri = -1;
            for (int i = 0; i < so_luong_ho_dan; i++) {
                if (arr[i].Ma_hodan.equals(ma_hodan)) {
                    vitri = i;
                    break;
                }
            }
            if (vitri == -1) System.out.println("Ma ho dan khong hop le");
            else arr[vitri].set_Hodan();
        }
    }
    public void tim_kiem_hodan ( String ma_hodan)
    {
        if ( arr.length > 0 ) {
            int vitri = -1;
            for (int i = 0; i < so_luong_ho_dan; i++) {
                if (arr[i].Ma_hodan.equals(ma_hodan)) {
                    vitri = i;
                    break;
                }
            }
            if (vitri == -1) System.out.println("Ma ho dan khong hop le");
            else arr[vitri].get_Hodan();
        }
    }
}
public class QLhodan {
    public static void main( String[] args)
    {

    }
}
