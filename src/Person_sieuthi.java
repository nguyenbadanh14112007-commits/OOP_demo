import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

abstract class PersonSieuthi
{
    private String hoten , so_dt , diachi , email;
    private final static Scanner scanner = new Scanner(System.in) ;
    private LocalDate Ngay_sinh ;
    public PersonSieuthi()
    {
        hoten = so_dt = diachi = email = "" ;
        Ngay_sinh = LocalDate.now() ;
        int age = LocalDate.now().getYear() - Ngay_sinh.getYear();
    }
    public void set_person()
    {
        System.out.println("Nhap ho ten: ");
        hoten = scanner.nextLine() ;
        System.out.println("Nhap ngay sinh(dd/MM/yyyy): ");
        String ngay_sinh = scanner.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_sinh = LocalDate.parse(ngay_sinh , khuon) ;
        System.out.println("Nhap so dien thoai: ");
        so_dt = scanner.nextLine() ;
        System.out.println("Nhap dia chi: ");
        diachi = scanner.nextLine();
        System.out.println("Nhap email: ");
        email = scanner.nextLine() ;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getNgay_sinh() {
        return Ngay_sinh;
    }

    public String getHoten() {
        return hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSo_dt() {
        return so_dt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNgay_sinh(LocalDate ngay_sinh) {
        Ngay_sinh = ngay_sinh;
    }

    public void setSo_dt(String so_dt) {
        this.so_dt = so_dt;
    }

    public String toString()
    {
        return "Ho ten: " + hoten + " | Ngay sinh: " + Ngay_sinh + " | So dien thoai: " + so_dt + " | Dia chi: " + diachi + " | email: " + email;
    }
}
class Khachhang extends PersonSieuthi
{
    private String Ma_kh , thu_hang;
    private LocalDate Ngay_dk ;
    private long doanh_thu ;
    private transient ArrayList<Sanpham> giohang = new ArrayList<>() ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Khachhang()
    {
        Ma_kh =  thu_hang = "" ;
        Ngay_dk = LocalDate.now() ;
        doanh_thu = 0 ;
    }
    public void set_person()
    {
        System.out.println("Nhap ma khach hang: ");
        Ma_kh = scanner.nextLine() ;
        System.out.println("Nhap ngay dang ky(dd/MM/yyyy): ");
        String ngay_dk = scanner.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_dk = LocalDate.parse( ngay_dk , khuon) ;
        super.set_person();
    }

    public String getMa_kh() {
        return Ma_kh;
    }

    public void setMa_kh(String ma_kh) {
        Ma_kh = ma_kh;
    }

    public LocalDate getNgay_sinh() {
        return super.getNgay_sinh();
    }

    public LocalDate getNgay_dk() {
        return Ngay_dk;
    }

    public void setNgay_dk(LocalDate ngay_dk) {
        Ngay_dk = ngay_dk;
    }

    public long getDoanh_thu() {
        return doanh_thu;
    }

    public void setDoanh_thu(long doanh_thu) {
        this.doanh_thu = doanh_thu;
    }

    public String getThu_hang() {
        return thu_hang;
    }

    public void setThu_hang(String thu_hang) {
        this.thu_hang = thu_hang;
    }

    public void Hang_thanh_vien()
    {
        if ( doanh_thu < 1000000 ) thu_hang = "Hang dong" ;
        else if ( doanh_thu < 5000000 ) thu_hang = "Hang bac" ;
        else if (doanh_thu < 10000000) thu_hang = "Hang vang" ;
        else thu_hang = "Hang kim cuong" ;
    }
    public void xem_thu_hang()
    {
        System.out.println("Hang cua nguoi dung hien tai la: " + thu_hang);
        if ( doanh_thu < 1000000 && doanh_thu > 0 )
            System.out.println("Quy khach can tieu tich luy " + (1000000 - doanh_thu) + " de len hang bac!");
        else if ( doanh_thu > 1000000 && doanh_thu < 5000000)
            System.out.println("Quy khach can tieu tich luy " + (5000000 - doanh_thu) + " de len hang vang!");
        else if ( doanh_thu > 5000000 && doanh_thu < 10000000 )
            System.out.println("Quy khach can tieu tich luy " + (10000000 - doanh_thu) + " de len hang kim cuong!");
        else System.out.println("Quy khach dang o thu hang cao nhat!");
    }
    public void Danhsachmuasam( ArrayList<Sanpham> sanphams , String Loai)
    {
        System.out.println("Danh sach cac san pham thuoc loai: " + Loai );
        for ( Sanpham sp: sanphams )
        {
            if ( Loai.equalsIgnoreCase("Thuc Pham") && sp instanceof Thucpham )
                System.out.println(sp.toString_trung_bay());
            else if ( Loai.equalsIgnoreCase("Tieu Dung") && sp instanceof Tieudung )
                System.out.println(sp.toString_trung_bay());
            else System.out.println(sp.toString_trung_bay());
        }
    }
    public void mua_sam( ArrayList<Sanpham> sanphams )
    {
        boolean countinue = true ;
        while (countinue)
        {
            System.out.println("Chon gian hang ban muon mua!");
            System.out.println("1. Hang Thuc Pham!");
            System.out.println("2. Hang Tieu Dung!");
            System.out.println("3. Hang Dien Tu!");
            int Luachon = Integer.parseInt(scanner.nextLine()) ;
            switch ( Luachon )
            {
                case 1:
                    Danhsachmuasam( sanphams , "Thuc Pham");
                    break;
                case 2:
                    Danhsachmuasam( sanphams , "Tieu Dung");
                    break;
                case 3:
                    Danhsachmuasam( sanphams , "Dien Tu");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
            System.out.println("Nhap ma cac mon hang ban muon mua: ");
            boolean tiep_tuc = true ;
            while(tiep_tuc)
            {
                String ma_sp = scanner.nextLine() ;
                if ( tim_sp(sanphams , ma_sp) == -1 ) System.out.println("Ma san pham khong ton tai!");
                else
                {
                    giohang.add(sanphams.get(tim_sp(sanphams , ma_sp))) ;
                    System.out.println("T");
                }
            }
        }

    }
    public void gio_hang()
    {

    }
    public void lich_su_hoadon()
    {

    }
    public void Danh_sach_ma_giam_gia()
    {

    }
    public int tim_sp ( ArrayList<Sanpham> sanphams , String ma_sp )
    {
        for ( int i = 0 ; i < sanphams.size() ; i++ )
            if ( sanphams.get(i).getTen_sp().equalsIgnoreCase(ma_sp))
                return i ;
        return -1 ;
    }
    public String toString()
    {
        return "Ma khach hang: " + Ma_kh + " | Ngay dang ky: " + Ngay_dk + " | " +super.toString() + " | Doanh thu: " + doanh_thu + " | Thu hang: " + thu_hang;
    }
}
abstract class Nhanvien extends PersonSieuthi
{
    private String Ma_nv ;
    private LocalDate Ngay_vao_lam ;
    private int so_gio_lam ,  luong_theo_gio;
    private String chuc_vu ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Nhanvien()
    {
        super();
        Ma_nv = chuc_vu =  "" ;
        so_gio_lam = luong_theo_gio = 0 ;
    }
    public void set_person ()
    {
        System.out.println("Nhap ma nhan vien: ");
        Ma_nv = scanner.nextLine() ;
        super.set_person();
        System.out.println("Nhap ngay vao lam(dd/MM/yyyy): ");
        String ngay_vao_lam = scanner.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_vao_lam = LocalDate.parse( ngay_vao_lam , khuon) ;
        System.out.println("Nhap so gio lam trong thang");
        so_gio_lam = scanner.nextInt() ;
        scanner.nextLine();
    }

    public String getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }

    public String getMa_nv() {
        return Ma_nv;
    }

    public void setMa_nv(String ma_nv) {
        Ma_nv = ma_nv;
    }

    public LocalDate getNgay_vao_lam() {
        return Ngay_vao_lam;
    }

    public void setNgay_vao_lam(LocalDate ngay_vao_lam) {
        Ngay_vao_lam = ngay_vao_lam;
    }

    public int getLuong_theo_gio() {
        return luong_theo_gio;
    }

    public void setLuong_theo_gio(int luong_theo_gio) {
        this.luong_theo_gio = luong_theo_gio;
    }

    public int getSo_gio_lam() {
        return so_gio_lam;
    }

    public void setSo_gio_lam(int so_gio_lam) {
        this.so_gio_lam = so_gio_lam;
    }

    public abstract int tien_luong() ;

    @Override
    public String toString() {
        return "Ma nhan vien: " + Ma_nv + " | " + super.toString() + " | Ngay vao lam: " + Ngay_vao_lam + " | So gio lam: " + so_gio_lam;
    }
}