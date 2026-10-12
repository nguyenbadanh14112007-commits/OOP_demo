import java.util.ArrayList;
import java.util.Scanner;

class Thukho extends Nhanvien implements Admin_Sp
{
    private transient ArrayList<Sanpham> sanphams ;
    private static long suc_chua_toi_da ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Thukho( ArrayList<Sanpham> _sanphams )
    {
        sanphams = _sanphams ;
        setChuc_vu("Thu kho");
        setLuong_theo_gio(33000);
        suc_chua_toi_da = 2000 ;
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public static long getSuc_chua_toi_da() {
        return suc_chua_toi_da;
    }

    public static void setSuc_chua_toi_da(long suc_chua_toi_da) {
        Thukho.suc_chua_toi_da = suc_chua_toi_da;
    }

    public static void thay_doi_suc_chua (int suc_chua_moi )
    {
        suc_chua_toi_da = suc_chua_moi ;
    }
    public long ktra_sl_sp_tonkho()
    {
        long sum = 0 ;
        for ( Sanpham sp:sanphams )
        {
            sum += sp.getSo_luong_ton_kho() ;
        }
        return sum ;
    }
    public void Soluong_sp_tonkho()
    {
        System.out.println("So luong san pham ton kho la: " + ktra_sl_sp_tonkho());
    }
    @Override
    public int tien_luong() {
        return getSo_gio_lam()*getLuong_theo_gio();
    }
    public void them_sp()
    {
        System.out.println("Thu kho khong co quyen han lam dieu nay!");
    }
    public void xoa_sp( String ma_sp )
    {
        System.out.println("Thu kho khong co quyen han lam dieu nay!");
    }
    public void sua_tt_sp ( String ma_sp )
    {
        System.out.println("Sua thong tin san pham!");
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
            {
                sp.set_sp();
                break;
            }
        }
        System.out.println("Thay doi thong tin thanh cong!");
    }
    public void tracuu_sp ( String ma_sp )
    {
        System.out.println("San pham can tra cuu: ");
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
            {
                System.out.println(sp);
                break;
            }
        }
    }

    @Override
    public void hien_thi_sp() {
        System.out.println("Danh sach san pham ton kho: ");
        for ( Sanpham sp: sanphams)
        {
            System.out.println("Ma san pham: " + sp.getMa_sp() + " | Ten san pham: " + sp.getTen_sp() + " | So luong: " + sp.getSo_luong_ton_kho() + " | Loai: " + sp.getLoai() );
        }
    }

    public void Loaibo_sp_hethan()
    {
        System.out.println("Danh sach san pham het han: ");
        int index = 0 ;
        for ( Sanpham sp: sanphams)
        {
            if( sp instanceof  Thucpham && ((Thucpham) sp).ktra_hong() && sp.getSo_luong_ton_kho() > 0 )
            {
                System.out.println(sp);
                index = 1 ;
            }
        }
        if ( index == 1 )
        {
            System.out.println("Ban co muon loai bo(yes/no): ");
            String luachon = scanner.nextLine() ;
            if ( luachon.equalsIgnoreCase("yes"))
            {
                for ( Sanpham sp:sanphams )
                {
                    if ( sp instanceof Thucpham && ((Thucpham) sp).ktra_hong() )
                    {
                        sp.setSo_luong_ton_kho(0);
                        sp.setSo_sp_trungbay(0);
                    }
                }
                System.out.println("Loai bo cac san pham hong thanh cong!");
            }
            else System.out.println("Chua loai bo cac san pham hong!");
        }
        else System.out.println("Khong co san pham nao hong!");
    }

    @Override
    public String toString() {
        return super.toString() + " | Luong: " + tien_luong() + " | Chuc vu: " + getChuc_vu() ;
    }
}