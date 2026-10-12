import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

interface gia_ca
{
    public Sanpham tra_cuu_san_pham( String ma_sp) ;
    public String tra_cuu_giam_gia ( String ma_sp ) ;
}
class Hoadon implements gia_ca
{
    private String Ma_phieu , Ma_nv , Ma_kh ;
    private LocalDate ngay_in ;
    private LocalDateTime gio_in ;
    private ArrayList<String> Ma_sp;
    private ArrayList<Integer> soluong ;
    private ArrayList<Sanpham> sanphams ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Hoadon( ArrayList<String> _ma_sp , ArrayList<Integer> _soluong , ArrayList<Sanpham>  _sanphams , String _Ma_phieu , String _Ma_nv )
    {
        Ma_nv = _Ma_nv ;
        Ma_kh = "" ;
        Ma_phieu = _Ma_phieu ;
        Ma_sp = _ma_sp ;
        soluong = _soluong ;
        sanphams = _sanphams ;
    }

    public void setMa_phieu(String ma_phieu) {
        Ma_phieu = ma_phieu;
    }

    public void setGio_in(LocalDateTime gio_in) {
        this.gio_in = gio_in;
    }

    public void setMa_kh(String ma_kh) {
        Ma_kh = ma_kh;
    }

    public void setMa_sp(ArrayList<String> ma_sp) {
        Ma_sp = ma_sp;
    }

    public void setMa_nv(String ma_nv) {
        Ma_nv = ma_nv;
    }

    public void setNgay_in(LocalDate ngay_in) {
        this.ngay_in = ngay_in;
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public void setSoluong(ArrayList<Integer> soluong) {
        this.soluong = soluong;
    }

    public LocalDate getNgay_in() {
        return ngay_in;
    }

    public LocalDateTime getGio_in() {
        return gio_in;
    }

    public ArrayList<String> getMa_sp() {
        return Ma_sp;
    }

    public String getMa_phieu() {
        return Ma_phieu;
    }

    public String getMa_kh() {
        return Ma_kh;
    }

    public String getMa_nv() {
        return Ma_nv;
    }

    public ArrayList<Integer> getSoluong() {
        return soluong;
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public void set_ngayin ()
    {
        System.out.println("Nhap lai ngay in(dd/MM/yyyy)): ");
        String ngayin = scanner.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        ngay_in = LocalDate.parse( ngayin , khuon) ;
    }
    public void set_gioin ()
    {
        System.out.println("Nhap gio in(Hour:Min:s): ");
        String gioin = scanner.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("HH:mm:ss") ;
        gio_in = LocalDateTime.from(LocalTime.parse( gioin , khuon));
    }
    public void set_hd()
    {
        System.out.println("Nhap ma khach hang: ");
        Ma_kh = scanner.nextLine() ;
        set_ngayin();
        set_gioin();
        scanner.nextLine() ;
    }
    public ctHoadon tra_cuu_cthd ( ArrayList<ctHoadon> cthoadons)
    {
        for ( ctHoadon cthd:cthoadons )
        {
            if ( cthd.getMa_phieu().equalsIgnoreCase(Ma_phieu))
                return cthd ;
        }
        return null ;
    }
    @Override
    public Sanpham tra_cuu_san_pham( String ma_sp ) {
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
                return sp ;
        }
        return null ;
    }

    @Override
    public String tra_cuu_giam_gia(String ma_sp ) {
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
            {
                if ( sp instanceof Thucpham )
                    return ((Thucpham) sp).getCach_thuc() ;
                else if ( sp instanceof Tieudung )
                    return ((Tieudung) sp).getCach_thuc() ;
            }
        }
        return "" ;
    }

    public long tong_tien_hd()
    {
        long sum = 0 ;
        for ( int i = 0 ; i < Ma_sp.size() ; i++ )
        {
            Sanpham sanpham = tra_cuu_san_pham(Ma_sp.get(i)) ;
            if ( tra_cuu_giam_gia( Ma_sp.get(i) ).equalsIgnoreCase("Mua 1 tang 1"))
            {
                if ( soluong.get(i) %2 == 1 ) soluong.set(i , soluong.get(i)+1) ;
                sum += (long)sanpham.getGia_ban()*(soluong.get(i)/2) ;
            }
            else
            {
                if ( sanpham instanceof Thucpham)
                {
                    sum += (long)((Thucpham) sanpham).gia_sau_giam()*soluong.get(i) ;
                }
                else if ( sanpham instanceof Tieudung )
                {
                    sum += (long)((Tieudung) sanpham).gia_sau_giam()*soluong.get(i) ;
                }
            }
        }
        return sum ;
    }
    public String toString()
    {
        return "Ma hoa don: " + Ma_phieu + " | Ma nhan vien: " + Ma_nv + " | Ma khach hang: " + Ma_kh + " | Gio in " + gio_in + " Ngay " + ngay_in +  " | Thanh tien: " + tong_tien_hd() ;
    }
}
class ctHoadon implements gia_ca
{
    private ArrayList<String> Ma_sp ;
    private ArrayList<Integer> soluong ;
    private ArrayList<Sanpham> sanphams ;
    private String Ma_phieu ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public ctHoadon(ArrayList<Sanpham> _sanpham )
    {
        Ma_sp = new ArrayList<>() ;
        soluong = new ArrayList<>() ;
        sanphams = _sanpham ;
        Ma_phieu = "" ;
    }

    public String getMa_phieu() {
        return Ma_phieu;
    }

    public void setMa_phieu(String ma_phieu) {
        Ma_phieu = ma_phieu;
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public ArrayList<Integer> getSoluong() {
        return soluong;
    }

    public ArrayList<String> getMa_sp() {
        return Ma_sp;
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public void setSoluong(ArrayList<Integer> soluong) {
        this.soluong = soluong;
    }

    public void setMa_sp(ArrayList<String> ma_sp) {
        Ma_sp = ma_sp;
    }

    @Override
    public Sanpham tra_cuu_san_pham( String ma_sp ) {
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
                return sp ;
        }
        return null ;
    }
    @Override
    public String tra_cuu_giam_gia(String ma_sp ) {
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
            {
                if ( sp instanceof Thucpham )
                    return ((Thucpham) sp).getCach_thuc() ;
                else if ( sp instanceof Tieudung )
                    return ((Tieudung) sp).getCach_thuc() ;
            }
        }
        return "" ;
    }
    public void set_ct_hoadon()
    {
        System.out.println("Nhap ma hoa don: ");
        Ma_phieu = scanner.nextLine() ;
        System.out.println("Nhap danh sach cac san pham: ");
        boolean countinue = true ;
        while (countinue)
        {
            System.out.println("Nhap ma san pham: ");
            String ma_sp = scanner.nextLine() ;
            Ma_sp.add(ma_sp) ;
            System.out.println("Nhap so luong san pham: ");
            int so_luong = scanner.nextInt() ;
            scanner.nextLine() ;
            soluong.add(so_luong) ;
            boolean tim_thay = false ;
            for ( Sanpham sp: sanphams )
            {
                if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
                {
                    tim_thay = true ;
                    if (sp.getSo_luong_ton_kho() > so_luong )
                    {
                        sp.setSo_luong_ton_kho( sp.getSo_luong_ton_kho() - so_luong );
                        if ( sp instanceof Khuyenmai )
                        {
                            ((Khuyenmai) sp).giamgiahethan();
                            ((Khuyenmai) sp).khuyenmaicuoituan();
                        }
                    }
                    else
                    {
                        Ma_sp.removeLast() ;
                        soluong.removeLast() ;
                        System.out.println("San pham ban chon da het hang!");
                    }
                }
            }
            if ( !tim_thay)
            {
                System.out.println("Khong tim thay ma san pham!");
            }
            System.out.println("Ban co muon tiep tuc(yes/no): ");
            String luachon = scanner.nextLine() ;
            if ( luachon.equalsIgnoreCase("no"))
            {
                countinue = false ;
            }
        }
        System.out.println("Nhap hoa don thanh cong!");
    }
    public void get_hd()
    {
        System.out.println("Cac san pham da mua: ");
        long tong_hoa_don = 0 ;
        for ( int i = 0 ; i < Ma_sp.size() ; i++ )
        {
            Sanpham sanpham = tra_cuu_san_pham(Ma_sp.get(i)) ;
            if ( sanpham instanceof Thucpham )
            {
                System.out.println("Stt: " + i + " | Ma san pham: " + Ma_sp.get(i) + " | Ten san pham: " + sanpham.getTen_sp() + " | So luong: " + soluong.get(i) + " | Gia ca: " + sanpham.getGia_ban()  + " | khuyen mai: " + tra_cuu_giam_gia(Ma_sp.get(i)));
                ((Thucpham) sanpham).hinh_thuc_giamgia();
            }
            else if ( sanpham instanceof Tieudung )
            {
                System.out.println("Stt: " + i + " | Ma san pham: " + Ma_sp.get(i) + " | Ten san pham: " + sanpham.getTen_sp() + " | So luong: " + soluong.get(i) + " | Gia ca: " + sanpham.getGia_ban() + " | khuyen mai: " + tra_cuu_giam_gia(Ma_sp.get(i)));
                ((Tieudung)sanpham).hinh_thuc_giamgia();
            }
            else System.out.println("Stt: " + i + " | Ma san pham: " + Ma_sp.get(i) + " | Ten san pham: " + sanpham.getTen_sp() + " | So luong: " + soluong.get(i) + " | Gia ca: " + sanpham.getGia_ban() + " | khuyen mai: " + tra_cuu_giam_gia(Ma_sp.get(i)));
            tong_hoa_don += (long) soluong.get(i) *sanpham.getGia_ban() ;
        }
        System.out.println("Tong hoa don: " + tong_hoa_don );
    }
}