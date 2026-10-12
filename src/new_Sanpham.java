import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Sanpham {
    private String Ma_sp , Ten_sp , Loai ;
    private int gia_nhap , gia_ban , So_luong_ton_kho , so_sp_trungbay;
    private ArrayList<LocalDate> Ngay_nhap ;
    private ArrayList<Integer> so_luong_nhap ;
    private ArrayList<String> Ma_ncc ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Sanpham()
    {
        Ma_sp = Ten_sp = "" ;
        gia_nhap = gia_ban = So_luong_ton_kho = so_sp_trungbay = 0 ;
        Ngay_nhap = new ArrayList<>() ;
        so_luong_nhap = new ArrayList<>() ;
        Ma_ncc = new ArrayList<>() ;
    }
    public void set_sp()
    {
        System.out.println("Nhap Ma san pham: ");
        Ma_sp = scanner.nextLine() ;
        System.out.println("Nhap ten san pham: ");
        Ten_sp = scanner.nextLine() ;
        System.out.println("Gia nhap: " );
        gia_nhap = scanner.nextInt() ;
        System.out.println("Gia ban: ");
        gia_ban = scanner.nextInt() ;
        System.out.println("So luong ton kho: ");
        So_luong_ton_kho = scanner.nextInt() ;
        System.out.println("So luong san pham muon trung bay:");
        so_sp_trungbay = scanner.nextInt() ;
        scanner.nextLine();
    }

    public int getSo_sp_trungbay() {
        return so_sp_trungbay;
    }

    public void setSo_sp_trungbay(int so_sp_trungbay) {
        this.so_sp_trungbay = so_sp_trungbay;
    }

    public int getGia_nhap()
    {
        return gia_nhap ;
    }
    public int getGia_ban()
    {
        return gia_ban ;
    }
    public int getSo_luong_ton_kho()
    {
        return So_luong_ton_kho ;
    }

    public ArrayList<LocalDate> getNgay_nhap() {
        return Ngay_nhap;
    }

    public ArrayList<Integer> getSo_luong_nhap() {
        return so_luong_nhap;
    }

    public ArrayList<String> getMa_ncc() {
        return Ma_ncc;
    }

    public String getLoai() {
        return Loai;
    }

    public String getMa_sp() {
        return Ma_sp;
    }

    public String getTen_sp() {
        return Ten_sp;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public void setGia_nhap(int gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public void setMa_sp(String ma_sp) {
        Ma_sp = ma_sp;
    }

    public void setSo_luong_ton_kho(int so_luong_ton_kho) {
        So_luong_ton_kho = so_luong_ton_kho;
    }

    public void setTen_sp(String ten_sp) {
        Ten_sp = ten_sp;
    }

    public void setMa_ncc(ArrayList<String> ma_ncc) {
        Ma_ncc = ma_ncc;
    }

    public void setNgay_nhap(ArrayList<LocalDate> ngay_nhap) {
        Ngay_nhap = ngay_nhap;
    }

    public void setSo_luong_nhap(ArrayList<Integer> so_luong_nhap) {
        this.so_luong_nhap = so_luong_nhap;
    }

    public abstract int Trang_thai_ban(int Sl_ban , int so_ngay_ton_kho) ;
    public String toString()
    {
        return "Ma san pham: " + Ma_sp + " | Ten san pham: " + Ten_sp + " | Gia nhap: " + gia_nhap + " | gia ban: " + gia_ban + " | So luong ton kho: " + So_luong_ton_kho + " | So luong trung bay: " +so_sp_trungbay;
    }
    public String toString_trung_bay()
    {
        return "Ma san pham: " + Ma_sp + " | Ten san pham: " + Ten_sp + " | Gia ban: " + gia_ban + " | So san pham con lai: " + so_sp_trungbay ;
    }
}
interface Khuyenmai {
    public void giamgiahethan() ;
    public void khuyenmaicuoituan() ;
}
class Thucpham extends Sanpham implements Khuyenmai
{
    private String  cach_thuc ;
    private LocalDate ngay_sx , ngay_het_han ;
    private float giam_gia ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Thucpham()
    {
        super.setLoai("Thuc pham");
        cach_thuc = "" ;
        giam_gia = 0 ;
        ngay_sx = ngay_het_han = LocalDate.now() ;
    }

    @Override
    public void set_sp() {
        super.set_sp();
        System.out.println("Nhap ngay san xuat(dd/mm/yyyy): ");
        String ngay_sanxuat = scanner.nextLine() ;
        System.out.println("Nhap ngay het han(dd/mm/yyyy): ");
        String ngay_hethan = scanner.nextLine();
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        ngay_sx = LocalDate.parse(ngay_sanxuat , khuon) ;
        ngay_het_han = LocalDate.parse(ngay_hethan , khuon) ;
    }

    public LocalDate getNgay_sx() {
        return ngay_sx;
    }

    public LocalDate getNgay_het_han() {
        return ngay_het_han;
    }

    public float getGiam_gia() {
        return giam_gia;
    }

    public String getCach_thuc() {
        return cach_thuc;
    }

    public void setCach_thuc(String cach_thuc) {
        this.cach_thuc = cach_thuc;
    }

    public void setGiam_gia(float giam_gia) {
        this.giam_gia = giam_gia;
    }

    public void setNgay_het_han(LocalDate ngay_het_han) {
        this.ngay_het_han = ngay_het_han;
    }

    public void setNgay_sx(LocalDate ngay_sx) {
        this.ngay_sx = ngay_sx;
    }

    public double so_ngay_su_dung()
    {
        return ChronoUnit.DAYS.between( ngay_sx , ngay_het_han ) ;
    }
    public double so_ngay_con_hansd()
    {
        LocalDate ngay_thuc = LocalDate.now() ;
        return ChronoUnit.DAYS.between( ngay_thuc , ngay_het_han ) ;
    }
    public int gia_sau_giam ()
    {
        return (int)(super.getGia_ban()*(1-giam_gia)) ;
    }
    public void giamgiahethan() {
        if ( so_ngay_su_dung() < 7 )
        {
            if ( so_ngay_con_hansd() < so_ngay_su_dung()*0.5)
            {
                cach_thuc = "Giam gia" ;
                giam_gia = 0.25f ;
            }
            else if ( so_ngay_con_hansd() < so_ngay_su_dung()*0.75)
            {
                cach_thuc = "Giam gia" ;
                giam_gia = 0.5f ;
            }
        }
    }
    public void khuyenmaicuoituan() {
        LocalDate homnay = LocalDate.now() ;
        DayOfWeek ngaytrongtuan = homnay.getDayOfWeek() ;
        int giatriso = ngaytrongtuan.getValue() ;
        if ( giatriso == 6 || giatriso == 7 )
        {
            if (so_ngay_su_dung() - so_ngay_con_hansd() > 3) {
                Random random = new Random();
                int Luachon = random.nextInt(3) ;
                switch (Luachon) {
                    case 0:
                        break ;
                    case 1:
                        cach_thuc = "Mua 1 tang 1";
                        break;
                    case 2:
                        cach_thuc = "Giam gia";
                        giam_gia = random.nextFloat(0.31f);
                        break;
                    default:
                        System.out.println("Lua chon giam gia dang bi loi! ");
                }
            }
        }
    }
    public void hinh_thuc_giamgia()
    {
        if ( cach_thuc.equalsIgnoreCase("Mua 1 tang 1"))
        {
            System.out.println("Ban se nhan duoc them 1 " + super.getTen_sp());
        }
        else if ( cach_thuc.equalsIgnoreCase("Giam gia"))
        {
            System.out.println("Ban da duoc giam san pham con: " + gia_sau_giam() + " tiet kiem duoc " + (super.getGia_ban()-gia_sau_giam()) + " nghin dong!" );
        }
        else if ( cach_thuc.equalsIgnoreCase("Giam gia theo gia tri"))
        {
            System.out.println("Ban da tiet kiem duoc 5 nghin dong!");
        }
        else
        {
            System.out.println("Khong ton tai giam gia");
        }
    }
    public boolean ktra_hong()
    {
        return so_ngay_con_hansd() == 0;
    }

    @Override
    public int Trang_thai_ban(int Sl_ban, int so_ngay_ton_kho) {
        ArrayList<Integer> so_luongnhap = super.getSo_luong_nhap() ;
        if ( so_luongnhap.isEmpty() ) return 0 ;
        int index = so_luongnhap.size()-1 ;
        if ( Sl_ban < so_luongnhap.get(index)*0.5 && so_ngay_con_hansd() < so_ngay_su_dung()/2 && so_ngay_su_dung() < 8)
            return - 1;
        else if ( Sl_ban < so_luongnhap.get(index)*0.7 && so_ngay_ton_kho > 30 && so_ngay_su_dung() > 8 )
            return -1 ;
        else if ( Sl_ban > so_luongnhap.get(index)*0.7 && so_ngay_con_hansd() > so_ngay_su_dung()/2 && so_ngay_su_dung() < 8 )
            return 1 ;
        else if (  Sl_ban > so_luongnhap.get(index)*0.7 && so_ngay_ton_kho < 30 && so_ngay_su_dung() > 8 )
            return 1 ;
        return 0 ;
    }

    public String toString()
    {
        return super.toString() + " | Loai: " + super.getLoai() + " | ngay san xuat: " + ngay_sx + " | ngay het han: " + ngay_het_han + " | Giam gia: " + giam_gia + " | cach thuc: " + cach_thuc;
    }
    public String toString_trung_bay()
    {
        return super.toString_trung_bay() + " | Loai: " + super.getLoai() + " | ngay san xuat: " + ngay_sx + " | ngay het han: " + ngay_het_han + " | Giam gia: " + giam_gia + " | cach thuc: " + cach_thuc;
    }
}
class Tieudung extends Sanpham implements Khuyenmai
{
    private String Thuonghieu , Noi_sx , cach_thuc;
    private float giam_gia ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Tieudung()
    {
        Thuonghieu = Noi_sx = cach_thuc = "" ;
        super.setLoai("Tieu dung");
        giam_gia = 0 ;
    }
    public void set_sp ()
    {
        super.set_sp();
        System.out.println("Nhap thuong hieu: ");
        Thuonghieu = scanner.nextLine() ;
        System.out.println("Nhap noi san xuat: ");
        Noi_sx = scanner.nextLine() ;
    }

    public void setThuonghieu(String thuonghieu) {
        Thuonghieu = thuonghieu;
    }

    public void setGiam_gia(float giam_gia) {
        this.giam_gia = giam_gia;
    }

    public void setCach_thuc(String cach_thuc) {
        this.cach_thuc = cach_thuc;
    }

    public void setNoi_sx(String noi_sx) {
        Noi_sx = noi_sx;
    }

    public String getCach_thuc() {
        return cach_thuc;
    }

    public float getGiam_gia() {
        return giam_gia;
    }

    public String getNoi_sx() {
        return Noi_sx;
    }

    public String getThuonghieu() {
        return Thuonghieu;
    }

    public int gia_sau_giam ()
    {
        return (int)(super.getGia_ban()*(1-giam_gia)) ;
    }
    @Override
    public void giamgiahethan() {
        System.out.println("Mon nay khong nam trong danh sach giam gia!");
    }

    @Override
    public void khuyenmaicuoituan() {
        LocalDate homnay = LocalDate.now() ;
        DayOfWeek ngaytrongtuan = homnay.getDayOfWeek() ;
        int giatriso = ngaytrongtuan.getValue() ;
        if ( giatriso == 6 || giatriso == 7 )
        {
            Random random = new Random() ;
            if ( super.getGia_ban() > 100000 )
            {
                int luachon = random.nextInt(3)  ;
                switch ( luachon)
                {
                    case 0:
                        break;
                    case 1:
                        cach_thuc = "Giam gia" ;
                        giam_gia = 0.05f;
                        break;
                    case 2:
                        cach_thuc = "Giam gia" ;
                        giam_gia = 0.1f;
                        break;
                    default: System.out.println("He thong da bi loi!");
                }
            }
            else if ( super.getGia_ban() < 100000 )
            {
                int luachon = random.nextInt(4) ;
                switch (luachon)
                {
                    case 0:
                        System.out.println("Mon hang nay khong nhan duoc giam gia");
                        break;
                    case 1:
                        cach_thuc = "Mua 1 tang 1" ;
                        break;
                    case 2:
                        cach_thuc = "Giam gia" ;
                        giam_gia = 0.1f;
                        break;
                    case 3:
                        cach_thuc = "Giam gia theo gia tri" ;
                        giam_gia = 5000/(float)super.getGia_ban() ;
                        System.out.println("Ban da tiet kiem duoc 5 nghin dong!");

                }
            }
        }
    }
    public void hinh_thuc_giamgia()
    {
        if ( cach_thuc.equalsIgnoreCase("Mua 1 tang 1"))
        {
            System.out.println("Ban se nhan duoc them 1 " + super.getTen_sp());
        }
        else if ( cach_thuc.equalsIgnoreCase("Giam gia"))
        {
            System.out.println("Ban da duoc giam san pham con: " + gia_sau_giam() + " tiet kiem duoc " + (super.getGia_ban()-gia_sau_giam()) + " nghin dong!" );
        }
        else if ( cach_thuc.equalsIgnoreCase("Giam gia theo gia tri"))
        {
            System.out.println("Ban da tiet kiem duoc 5 nghin dong!");
        }
        else
        {
            System.out.println("Khong ton tai giam gia");
        }
    }
    public double thue_nhapkhau()
    {
        if ( Noi_sx.equalsIgnoreCase("Viet Nam"))
            return 0 ;
        else
            return super.getGia_ban()*0.1 ;
    }

    @Override
    public int Trang_thai_ban(int Sl_ban, int so_ngay_ton_kho) {
        ArrayList<LocalDate> ngay_nhap = super.getNgay_nhap() ;
        ArrayList<Integer> soluongnhap = super.getSo_luong_nhap() ;
        if ( ngay_nhap.isEmpty()) return 0 ;
        int index = ngay_nhap.size() -1 ;
        if ( so_ngay_ton_kho > 30 && Sl_ban < soluongnhap.get(index)*0.4)
            return -1;
        else if ( so_ngay_ton_kho < 30 && Sl_ban > soluongnhap.get(index)*0.7)
            return 1 ;
        return 0 ;
    }

    @Override
    public String toString() {
        return super.toString() + " | Loai: " + super.getLoai()+ " | Thương hieu : " + Thuonghieu + " | Noi san xuat: "  + Noi_sx + " | Giam gia: " + giam_gia + " | Hinh thuc: " + cach_thuc ;
    }
    public String toString_trung_bay()
    {
        return super.toString_trung_bay() + " | Loai: " + super.getLoai()+ " | Thương hieu : " + Thuonghieu + " | Noi san xuat: "  + Noi_sx + " | Giam gia: " + giam_gia + " | Hinh thuc: " + cach_thuc ;
    }
}
class Dientu extends Sanpham
{
    private int thoi_gian_bao_hanh, tien_bao_hanh ;
    private LocalDate ngay_dang_ky ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Dientu ()
    {
        super.setLoai("Dien tu");
        thoi_gian_bao_hanh = tien_bao_hanh = 0 ;
        ngay_dang_ky = LocalDate.now() ;
    }
    public void set_sp()
    {
        super.set_sp();
        System.out.println("Nhập ngày mua(dd/MM/yyyy): ");
        String ngay_mua = scanner.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        ngay_dang_ky = LocalDate.parse(ngay_mua , khuon );
        System.out.println("Nhap thoi gian bao hanh( Số Tháng ): ");
        thoi_gian_bao_hanh = scanner.nextInt() ;
    }

    public int getThoi_gian_bao_hanh() {
        return thoi_gian_bao_hanh;
    }

    public int getTien_bao_hanh() {
        return tien_bao_hanh;
    }

    public LocalDate getNgay_dang_ky() {
        return ngay_dang_ky;
    }

    public void setNgay_dang_ky(LocalDate ngay_dang_ky) {
        this.ngay_dang_ky = ngay_dang_ky;
    }

    public void setThoi_gian_bao_hanh(int thoi_gian_bao_hanh) {
        this.thoi_gian_bao_hanh = thoi_gian_bao_hanh;
    }

    public void setTien_bao_hanh(int tien_bao_hanh) {
        this.tien_bao_hanh = tien_bao_hanh;
    }

    public void set_dang_ky()
    {
        ngay_dang_ky = LocalDate.now() ;
    }
    public LocalDate ngay_het_han()
    {
        return ngay_dang_ky.plusMonths(thoi_gian_bao_hanh) ;
    }
    public void Ktra_baohanh()
    {
        LocalDate ngay_ht = LocalDate.now() ;
        long so_ngay_con_lai = ChronoUnit.DAYS.between(ngay_ht , ngay_het_han() ) ;
        if ( so_ngay_con_lai > 0 )
            System.out.println("San pham con bao hanh " + so_ngay_con_lai + " ngay! ");
        else System.out.println("San pham da het bao hanh!");
    }
    public void gia_han_bao_hanh()
    {
        System.out.println("Nhap so thang can gia han: ");
        int so_thang_gia_han = scanner.nextInt() ;
        double chi_phi_baohanh = super.getGia_ban()*0.05*((double)so_thang_gia_han/6.0) ;
        System.out.println("So tien can thanh toan la: " + chi_phi_baohanh );
        System.out.println("Ban co muon gia han khong?(yes/no)");
        String giahan = scanner.nextLine() ;
        if ( giahan.equalsIgnoreCase("yes") )
        {
            ngay_dang_ky = LocalDate.now() ;
            tien_bao_hanh += (int)chi_phi_baohanh ;
            thoi_gian_bao_hanh = so_thang_gia_han ;
            System.out.println("Gia han thanh cong! ");
        }
        else System.out.println("Gia han that bai!");
    }

    @Override
    public int Trang_thai_ban(int Sl_ban, int so_ngay_ton_kho) {
        ArrayList<Integer> soluongnhap = super.getSo_luong_nhap() ;
        if ( soluongnhap.isEmpty()) return 0 ;
        int index = soluongnhap.size() -1 ;
        if ( so_ngay_ton_kho > 400 && Sl_ban < soluongnhap.get(index)*0.3)
            return -1 ;
        if ( so_ngay_ton_kho < 400 && Sl_ban > soluongnhap.get(index)*0.6)
            return 1 ;
        return 0 ;
    }

    @Override
    public String toString() {
        return super.toString() + " | Loai: " + super.getLoai() + " | Bao hanh " + thoi_gian_bao_hanh + " thang";
    }
    public String toString_trung_bay()
    {
        return super.toString_trung_bay() + " | Loai: " + super.getLoai() + " | Bao hanh " + thoi_gian_bao_hanh + " thang";
    }
}
