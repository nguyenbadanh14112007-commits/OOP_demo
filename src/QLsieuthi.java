import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.*;

import java.util.*;

interface Thongke
{
    public void thong_ke_doanhthu( int ngay , int thang , int nam ) ;
    public void thong_ke_doanhthu ( int thang , int nam ) ;
    public  void thong_ke_doanhthu ( int nam ) ;
    public void thong_ke_doanhthu_theoquy ( int quy , int nam ) ;
    public void Tke_hanghoa_ban_duoc ( int ngay , int thang , int nam ) ;
    public void Tke_hanghoa_ban_duoc ( int thang , int nam ) ;
    public void Tke_hanghoa_ban_duoc ( int nam ) ;
    public void Tke_hanghoa_ban_duoc_theoquy ( int quy , int nam) ;
    public void thong_ke_loinhuan ( int ngay , int thang , int nam ) ;
    public void thong_ke_loinhuan ( int thang , int nam ) ;
    public  void thong_ke_loinhuan ( int nam ) ;
    public void thong_ke_loinhuan_theoquy( int quy , int nam ) ;
}
interface Admin_Sp
{
    public void them_sp() ;
    public void xoa_sp( String ma_sp) ;
    public void sua_tt_sp( String ma_sp ) ;
    public void hien_thi_sp() ;
    public void tracuu_sp( String ma_sp ) ;
}
class Quanlysieuthi
{
   private ArrayList<Nhanvien> nhanviens ;
   private ArrayList<Sanpham> sanphams ;
   private ArrayList<Nhacungcap> nhacungcaps ;
   private ArrayList<Khachhang> khachhangs ;
   private final static Scanner scanner = new Scanner(System.in) ;
   public Quanlysieuthi()
   {
       nhanviens = new ArrayList<>() ;
       sanphams = new ArrayList<>() ;
       nhacungcaps = new ArrayList<>() ;
       khachhangs = new ArrayList<>() ;
   }

    public ArrayList<Nhacungcap> getNhacungcaps() {
        return nhacungcaps;
    }

    public ArrayList<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public ArrayList<Khachhang> getKhachhangs() {
        return khachhangs;
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public void setNhanviens(ArrayList<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }

    public void setKhachhangs(ArrayList<Khachhang> khachhangs) {
        this.khachhangs = khachhangs;
    }

    public void setNhacungcaps(ArrayList<Nhacungcap> nhacungcaps) {
        this.nhacungcaps = nhacungcaps;
    }

    public static void khong_tontai()
   {
       System.out.println("Ma nhap khong hop le!");
   }
   public void them_nv()
   {
       System.out.println("Chon nhan vien can them: ");
       System.out.println("1.Them nhan vien thu ngan!");
       System.out.println("2.Them nhan vien ke toan!");
       System.out.println("3.Them nhan vien thu kho!");
       System.out.println("4.Them nhan vien quan ly!");
       System.out.println("0.Trở về giao diện!");
       System.out.println();
       Nhanvien nhanvien ; int dem_nv = 0 ;
       System.out.println("Nhap lua chon: ");
       int Luachon = scanner.nextInt() ;
       scanner.nextLine();
       switch (Luachon)
       {
           case 1 :
               for ( Nhanvien nv:nhanviens)
               {
                   if ( nv instanceof Thungan ) dem_nv++ ;
               }
               if ( dem_nv >= 4 )
               {
                   System.out.println("So luong thu ngan da toi da!");
                   return;
               }
               nhanvien = new Thungan( sanphams , khachhangs ) ;
               nhanvien.set_person();
               nhanviens.add(nhanvien) ;
               break;
           case 2 :
               for ( Nhanvien nv: nhanviens )
                   if ( nv instanceof Ketoan ) dem_nv++ ;
               if ( dem_nv >= 1 )
               {
                   System.out.println("So luong ke toan da toi da!");
                   return;
               }
               Ketoan kt = new Ketoan( sanphams , nhanviens ) ;
               kt.set_person();
               kt.loc_thungan();
               kt.thiet_lap_hodon();
               nhanviens.add(kt) ;
               break;
           case 3 :
               for ( Nhanvien nv: nhanviens )
                   if ( nv instanceof Thukho ) dem_nv++ ;
               if ( dem_nv >= 1 )
               {
                   System.out.println("So luong thu kho da toi da!");
                   return;
               }
               nhanvien = new Thukho( sanphams ) ;
               nhanvien.set_person();
               nhanviens.add(nhanvien) ;
               break;
           case 4:
               for ( Nhanvien nv: nhanviens )
                   if ( nv instanceof Quanly ) dem_nv++ ;
               if ( dem_nv >= 1 )
               {
                   System.out.println("So luong quan ly da toi da!");
                   return;
               }
               nhanvien = new Quanly( sanphams , nhacungcaps , nhanviens ) ;
               nhanvien.set_person();
               nhanviens.add(nhanvien) ;
               break;
           case 0: break ;
           default: System.out.println("Lua chon khong hop le!");
               break;
       }
   }
   public void them_sp()
   {
       for ( Nhanvien nv:nhanviens)
       {
           if ( nv instanceof Quanly )
           {
               ((Quanly) nv).them_sp();
           }
       }
   }
   public void them_ncc()
   {
       System.out.println("Vui long nhap thong tin nha cung cap moi!");
       Nhacungcap a = new Nhacungcap() ;
       a.set_ncc();
       nhacungcaps.add(a) ;
       System.out.println("Da them nha cung cap!");
   }
   public void them_kh()
   {
       System.out.println("Vui long nhap thong tin khach hang moi!");
       Khachhang a = new Khachhang() ;
       a.set_person();
       khachhangs.add(a);
       System.out.println("Da them khach hang!");
   }
    public void tao_dulieu_nv()
    {
        System.out.println("Nhap du lieu nhan vien!");
        boolean countinue = true ;
        while(countinue)
        {
            them_nv();
            System.out.println("Ban co muon tiep tuc(yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
               countinue = false ;
        }
    }
    public void tao_dulieu_sp()
    {
        Quanly ql = (Quanly) tim_kiem_chucvu("Quan ly") ;
        if ( ql == null )
        {
            System.out.println("Vui lòng thêm nhân viên quản lý!");
            return;
        }
        System.out.println("Nhap du lieu san pham!");
        boolean countinue = true ;
        while(countinue)
        {
            them_sp();
            System.out.println("Ban co muon tiep tuc(yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
                countinue = false ;
        }
        System.out.println("Nhập dữ liệu cho sản phẩm thành công!");
    }
    public void tao_dulieu_ncc()
    {
        System.out.println("Nhap du lieu nha cung cap!");
        boolean countinue = true ;
        while(countinue)
        {
            them_ncc();
                System.out.println("Ban co muon tiep tuc(yes/no): ");
                String tiep_tuc = scanner.nextLine() ;
                if ( tiep_tuc.equalsIgnoreCase("no"))
                    countinue = false ;
        }
        System.out.println("Them du lieu nha cung cap thanh cong!");
    }
    public void tao_dulieu_kh()
    {
        System.out.println("Nhap du lieu khach hang!");
        boolean countinue = true ;
        while(countinue)
        {
            them_kh();
            System.out.println("Ban co muon tiep tuc(yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
               countinue = false ;
        }
        System.out.println("Them du lieu khach hang thanh cong!");
    }
    public void tao_ds_hoadon()
    {
        System.out.println("Chon nhan vien de them hoa don: ");
        for ( int i = 0 ; i < nhanviens.size() ; i++ )
        {
            if ( nhanviens.get(i) instanceof Thungan)
                System.out.println( (i+1) + ".Ma nhan vien: " + nhanviens.get(i).getMa_nv() + " | Ten nhan vien: " + nhanviens.get(i).getHoten());
        }
        System.out.println("Lua chon: ");
        int Luachon = scanner.nextInt() ;
        int index = 0 ;
        for ( int i = 0 ; i < nhanviens.size() ; i++ )
        {
            if ( nhanviens.get(i) instanceof Thungan )
            {
                index++ ;
                if ( index == Luachon)
                {
                    index = i ;
                    break;
                }
            }
        }
        Thungan tn = (Thungan) nhanviens.get(index) ;
        System.out.println("Nhap du lieu hoa don va chi tiet hoa don!");
        boolean countinue = true ;
        while(countinue)
        {
            tn.tao_hoa_don();
            System.out.println("Ban co muon tiep tuc(yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
                countinue = false ;
        }
        System.out.println("Them du lieu hoa don thanh cong!");
    }
    public int tim_kiem_nv ( String ma_nv )
    {
        int index = -1 ;
        for ( int i = 0 ; i < nhanviens.size() ; i++ )
        {
            if ( nhanviens.get(i).getMa_nv().equalsIgnoreCase(ma_nv))
            {
                index = i ;
                break;
            }
        }
        return index ;
    }
    public int tim_kiem_ncc ( String ma_ncc)
    {
        for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
            if ( nhacungcaps.get(i).getMa_ncc().equalsIgnoreCase(ma_ncc))
                return i ;
        return -1 ;
    }
    public int tim_kiem_kh ( String ma_kh )
    {
        for ( int i = 0 ; i < khachhangs.size() ; i++ )
            if ( khachhangs.get(i).getMa_kh().equalsIgnoreCase(ma_kh))
                return i ;
        return -1 ;
    }
    public void sa_thai_nv ( String ma_nv)
    {
        int index = tim_kiem_nv(ma_nv) ;
        if ( index == -1 )
        {
            khong_tontai();
            return ;
        }
        nhanviens.remove(index) ;
        System.out.println("Da sa thai nhan vien thanh cong!");
    }
    public void loaibo_sp ( String ma_sp )
    {
        for ( Nhanvien nv: nhanviens)
        {
            if ( nv instanceof Quanly)
            {
                ((Quanly) nv).xoa_sp(ma_sp);
            }
        }
        System.out.println("Da loai bo san pham nay ra khoi danh sach san pham!");
    }
    public void huy_hoptac_ncc ( String ma_ncc )
    {
        int index = tim_kiem_ncc( ma_ncc) ;
        if ( index == -1 )
        {
            khong_tontai();
            return ;
        }
        nhacungcaps.remove(index) ;
        System.out.println("Da hy hop tac voi nha cung cap nay!");
    }
    public void xoa_kh ( String ma_kh )
    {
       int index = tim_kiem_kh(ma_kh) ;
       if ( index == -1 )
       {
           khong_tontai();
           return;
       }
       khachhangs.remove(index) ;
        System.out.println("Da xoa khach hang nay!");
    }
    public void sua_tt_nv ( String ma_nv )
    {
        int index = tim_kiem_nv(ma_nv) ;
        if ( index == -1 )
        {
            khong_tontai();
            return;
        }
        System.out.println("Chon thuoc tinh can sua: ");
        System.out.println("1.Ma nhan vien!");
        System.out.println("2.Ten nhan vien!");
        System.out.println("3.luong theo gio cua nhan vien!");
        System.out.println("4.So gio lam!");
        System.out.println("5.Dia chi!");
        System.out.println("6.Ngay sinh!");
        System.out.println("7.So dien thoai!");
        int luachon = scanner.nextInt() ;
        switch (luachon)
        {
            case 1:
                System.out.println("Nhap ma nhan vien moi cua nhan vien: ");
                nhanviens.get(index).setMa_nv(scanner.nextLine()) ;
                break;
            case 2:
                System.out.println("Nhap ho ten moi cua nhan vien: ");
                nhanviens.get(index).setHoten(scanner.nextLine());
                break;
            case 3:
                System.out.println("Nhap luong moi cua nhan vien: ");
                nhanviens.get(index).setLuong_theo_gio(scanner.nextInt()); ;
                break;
            case 4:
                System.out.println("Nhap so gio lam moi cua nhan vien: ");
                nhanviens.get(index).setSo_gio_lam(scanner.nextInt());
                break;
            case 5:
                System.out.println("Nhap dia chi moi cua nhan vien: ");
                nhanviens.get(index).setDiachi(scanner.nextLine() );
                break;
            case 6:
                System.out.println("Nhap ngay sinh moi cua nhan vien: ");
                String ngay_sinh_moi = scanner.nextLine() ;
                DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                nhanviens.get(index).setNgay_sinh(LocalDate.parse( ngay_sinh_moi , khuon)) ;
                break;
            case 7:
                System.out.println("Nhap so dien thoai moi cua nhan vien: ");
                nhanviens.get(index).setSo_dt(scanner.nextLine()); ;
                break;
            default: System.out.println("Lua chon khong hop le!");
        }
        System.out.println("Da thay doi thong tin nhan vien!");
    }
    public void sua_tt_sp ( String ma_sp )
    {
        for ( Nhanvien nv:nhanviens)
        {
            if ( nv instanceof Quanly)
                ((Quanly) nv).sua_tt_sp(ma_sp);
        }
    }
    public void sua_tt_ncc ( String ma_ncc )
    {
        int index = tim_kiem_ncc(ma_ncc) ;
        if ( index == -1 )
        {
            khong_tontai();
            return;
        }
        System.out.println("Chon thuoc tinh can sua: ");
        System.out.println("1.Ma nha cung cap!");
        System.out.println("2.Ten nha cung cap!");
        System.out.println("3.So dien thoai!");
        System.out.println("4.Email!");
        System.out.println("5.Dia chi!");
        int luachon = scanner.nextInt() ;
        scanner.nextLine();
        switch (luachon)
        {
            case 1:
                System.out.println("Nhap ma nha cung cap moi cua nha cung cap: ");
                nhacungcaps.get(index).setMa_ncc(scanner.nextLine());
                break;
            case 2:
                System.out.println("Nhap ho ten moi cua nha cung cap: ");
                nhacungcaps.get(index).setTen_ncc(scanner.nextLine());
                break;
            case 3:
                System.out.println("Nhap so dien thoai moi cua nha cung cap: ");
                nhacungcaps.get(index).setSo_dt(scanner.nextLine()); ;
                break;
            case 4:
                System.out.println("Nhap email moi cua nha cung cap: ");
                nhacungcaps.get(index).setEmail(scanner.nextLine());
                break;
            case 5:
                System.out.println("Nhap dia chi moi cua nha cung cap: ");
                nhacungcaps.get(index).setDia_chi(scanner.nextLine());
                break;
            default: System.out.println("Lua chon khong hop le!");
        }
        System.out.println("Da thay doi thong tin nha cung cap thanh cong!");
    }
    public void sua_tt_kh ( String ma_kh )
    {
        int index = tim_kiem_kh(ma_kh) ;
        if ( index == -1 )
        {
            khong_tontai();
            return ;
        }
        System.out.println("Chon thuoc tinh can sua: ");
        System.out.println("1.Ma khach hang!");
        System.out.println("2.Ten khach hang!");
        System.out.println("3.Doanh thu!");
        System.out.println("4.Cap nhat thu hang!");
        System.out.println("5.Dia chi!");
        System.out.println("6.Ngay sinh!");
        System.out.println("7.So dien thoai!");
        System.out.println("8.Ngay dang ky!");
        int luachon = scanner.nextInt() ;
        scanner.nextLine() ;
        switch (luachon)
        {
            case 1:
                System.out.println("Nhap ma khach hang moi cua khach hang: ");
                khachhangs.get(index).setMa_kh(scanner.nextLine());
                break;
            case 2:
                System.out.println("Nhap ho ten moi cua khach hang: ");
                khachhangs.get(index).setMa_kh(scanner.nextLine());
                break;
            case 3:
                System.out.println("Nhap doanh thu moi cua khach hang: ");
                khachhangs.get(index).setDoanh_thu(scanner.nextInt() );
                break;
            case 4:
                System.out.println("Nhap thu hang moi cua khach hang: ");
                khachhangs.get(index).setThu_hang(scanner.nextLine());
                break;
            case 5:
                System.out.println("Nhap dia chi moi cua khach hang: ");
                khachhangs.get(index).setDiachi(scanner.nextLine());
                break;
            case 6:
                System.out.println("Nhap ngay sinh moi cua khach hang: ");
                String ngay_sinh_moi = scanner.nextLine() ;
                DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                khachhangs.get(index).setNgay_sinh(LocalDate.parse( ngay_sinh_moi , khuon));
                break;
            case 7:
                System.out.println("Nhap so dien thoai moi cua khach hang: ");
                khachhangs.get(index).setSo_dt(scanner.nextLine()); ;
                break;
            case 8:
                System.out.println("Nhap ngay dang ky moi cua khach hang: ");
                String ngay_dk_moi = scanner.nextLine() ;
                DateTimeFormatter khuon1 = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                khachhangs.get(index).setNgay_dk(LocalDate.parse( ngay_dk_moi , khuon1));
                break;
            default: System.out.println("Lua chon khong hop le!");
        }
        System.out.println("Da thay doi thong tin khach hang!");
    }
    public void hien_thi_nv()
    {
        System.out.println("Danh sach nhan vien!");
        for ( Nhanvien nv: nhanviens)
            System.out.println(nv);
    }
    public void in_ds_san_pham()
    {
        System.out.println("Hien thi danh sach cac san pham:");
        for ( Sanpham sp:sanphams )
            System.out.println(sp);
    }
    public void in_ds_nhacungcap()
    {
        System.out.println("Hien thi danh sach nha cung cap!");
        for ( Nhacungcap ncc:nhacungcaps )
            System.out.println(ncc);
    }
    public void in_sp_nhap_tu_ncc()
    {
        System.out.println("Danh sach san pham duoc nhap tu cac nha cung cap!");
        for ( Nhacungcap ncc:nhacungcaps )
            ncc.hien_thi_sp();
    }
    public void in_ds_kh ()
    {
        System.out.println("Danh sach cac khach hang cua sieu thi!");
        for ( Khachhang kh:khachhangs)
            System.out.println(kh);
    }
    public long chi_phi_nhap_hang ( int ngay , int thang , int nam )
    {
        long sum = 0 ;
        for ( Nhacungcap ncc:nhacungcaps)
            sum += ncc.tinh_chi_phi_nhap_hang( ngay , thang , nam) ;
        return sum ;
    }
    public void in_chiphi_nhap_hang ( int ngay , int thang , int nam )
    {
        System.out.println("Cho phi nhap hang cua ngay " + ngay + " thang " + thang + " nam " + nam + " la: " + chi_phi_nhap_hang(ngay , thang , nam) );
    }
    public long chi_phi_nhap_hang ( int thang , int nam )
    {
        long sum = 0 ;
        for ( Nhacungcap ncc:nhacungcaps)
            sum += ncc.tinh_chi_phi_nhap_hang( thang , nam) ;
        return sum ;
    }
    public void in_chiphi_nhap_hang ( int thang , int nam )
    {
        System.out.println("Cho phi nhap hang cua thang " + thang + " nam " + nam + " la: " + chi_phi_nhap_hang( thang , nam) );
    }
    public long chi_phi_nhap_hang ( int nam )
    {
        long sum = 0 ;
        for ( Nhacungcap ncc:nhacungcaps)
            sum += ncc.tinh_chi_phi_nhap_hang( nam) ;
        return sum ;
    }
    public void in_chiphi_nhap_hang (  int nam )
    {
        System.out.println("Cho phi nhap hang cua nam " + nam + " la: " + chi_phi_nhap_hang( nam) );
    }
    public void tracuu_nv ( String tt_nv )
    {
        int index = tim_kiem_nv(tt_nv) ;
        System.out.println("Nhan vien can tim  co thong tin la: ");
        if ( index != -1 )
        {
            System.out.println(nhanviens.get(index));
            return;
        }
        for ( Nhanvien nv:nhanviens)
        {
            if ( nv.getHoten().equalsIgnoreCase(tt_nv) || nv.getSo_dt().equalsIgnoreCase(tt_nv) || nv.getDiachi().equalsIgnoreCase(tt_nv) || nv.getChuc_vu().equalsIgnoreCase(tt_nv))
            {
                System.out.println(nv);
            }
        }
        for ( Nhanvien nv:nhanviens)
        {
            if ( (nv.getHoten().contains(tt_nv) && !nv.getHoten().equalsIgnoreCase(tt_nv)) || (nv.getDiachi().contains(tt_nv) && !nv.getDiachi().equalsIgnoreCase(tt_nv)))
            {
                System.out.println(nv);
            }
        }
    }
    public void tracuu_nv ( int tt_nv )
    {
        System.out.println("Nhan vien can tim  co thong tin la: ");
        for ( Nhanvien nv:nhanviens)
        {
            if ( nv.getSo_gio_lam() == tt_nv || nv.getLuong_theo_gio() == tt_nv )
            {
                System.out.println(nv);
            }
        }
    }
    public void tracuu_nv ( LocalDate tt_nv )
    {
        System.out.println("Nhan vien can tim  co thong tin la: ");
        for ( Nhanvien nv:nhanviens)
        {
            if ( nv.getNgay_sinh().equals(tt_nv) || nv.getNgay_vao_lam().equals(tt_nv) )
            {
                System.out.println(nv);
            }
        }
    }
    public void tracuu_sp ( String tt_sp )
    {
        System.out.println("Thong tin san pham can tra cuu: ");
        for ( Sanpham sp:sanphams)
        {
            if ( sp.getMa_sp().equalsIgnoreCase(tt_sp) || sp.getTen_sp().equalsIgnoreCase(tt_sp) || sp.getLoai().equalsIgnoreCase(tt_sp))
            {
                System.out.println(sp);
            }
        }
        for ( Sanpham sp:sanphams)
        {
            if ( sp.getTen_sp().contains(tt_sp) && sp.getTen_sp().equalsIgnoreCase(tt_sp))
                System.out.println(sp);
        }
    }
    public void tracuu_sp ( int tt_sp )
    {
        System.out.println("Thong tin san pham can tra cuu: ");
        for ( Sanpham sp:sanphams)
        {
            if ( sp.getSo_luong_ton_kho() == tt_sp || sp.getGia_ban() == tt_sp || sp.getGia_nhap() == tt_sp)
            {
                System.out.println(sp);
            }
        }
    }
    public void tracuu_sp_tren_khoang( String ten_sp , int gia_ban_min , int gia_ban_max )
    {
        System.out.println("Cac san pham phu hop voi yeu cau la: ");
        for ( Sanpham sp:sanphams)
        {
            if ( (sp.getTen_sp().equalsIgnoreCase(ten_sp) || sp.getTen_sp().contains(ten_sp)) && ( sp.getGia_ban() < gia_ban_max && sp.getGia_ban() > gia_ban_min) )
            {
                System.out.println(sp);
            }
        }
    }
    public void tracuu_ncc ( String tt_ncc )
    {
        System.out.println("Nha cung cap ban muon tim la: ");
        for ( Nhacungcap ncc: nhacungcaps)
        {
            if ( ncc.getMa_ncc().equalsIgnoreCase(tt_ncc) || ncc.getTen_ncc().equalsIgnoreCase(tt_ncc) || ncc.getDia_chi().equalsIgnoreCase(tt_ncc) || ncc.getEmail().equalsIgnoreCase(tt_ncc) || ncc.getSo_dt().equalsIgnoreCase(tt_ncc))
            {
                System.out.println(ncc);
            }
        }
        for ( Nhacungcap ncc: nhacungcaps)
        {
            if ( (ncc.getTen_ncc().contains(tt_ncc) && !ncc.getTen_ncc().equalsIgnoreCase(tt_ncc)) || (ncc.getDia_chi().contains(tt_ncc) && !ncc.getDia_chi().equalsIgnoreCase(tt_ncc)))
            {
                System.out.println(ncc);
            }
        }
    }
    public void tracuu_kh ( String tt_kh )
    {
        System.out.println("Danh sach khach hang can tra cuu: ");
        for ( Khachhang kh:khachhangs)
        {
            if ( kh.getMa_kh().equalsIgnoreCase(tt_kh) || kh.getThu_hang().equalsIgnoreCase(tt_kh) || kh.getDiachi().equalsIgnoreCase(tt_kh) || kh.getHoten().equalsIgnoreCase(tt_kh) || kh.getSo_dt().equalsIgnoreCase(tt_kh))
            {
                System.out.println(kh);
            }
        }
        for ( Khachhang kh:khachhangs)
        {
            if ( (kh.getDiachi().contains(tt_kh) && !kh.getDiachi().equalsIgnoreCase(tt_kh)) || ( kh.getHoten().contains(tt_kh) && !kh.getHoten().equalsIgnoreCase(tt_kh)) )
            {
                System.out.println(kh);
            }
        }
    }
    public void tracuu_kh ( LocalDate tt_kh )
    {
        System.out.println("Danh sach khach hang can tra cuu: ");
        for ( Khachhang kh: khachhangs)
        {
            if ( kh.getNgay_dk().equals(tt_kh) || kh.getNgay_sinh().equals(tt_kh))
                System.out.println(kh);
        }
    }
    public Nhanvien tim_kiem_chucvu ( String chucvu )
    {
        for ( Nhanvien nv:nhanviens)
        {
            if ( nv.getChuc_vu().equalsIgnoreCase(chucvu))
                return nv ;
        }
        khong_tontai();
        return null ;
    }
    public void Baocao_doanhthu_loinhuan_ngay ( int ngay , int thang , int nam)
    {
        Ketoan ketoan = (Ketoan) tim_kiem_chucvu("Ke toan") ;
        if (ketoan == null)
        {
            System.out.println("Vui long them nhan vien Ke toan truoc khi xem bao cao!");
            return;
        }
        ketoan.tinh_thong_ke_doanhthu( ngay , thang , nam ) ;
        ketoan.thong_ke_loinhuan(ngay , thang , nam );
    }
    public void Baocao_doanhthu_loinhuan_hangthang ( int nam )
    {
        Ketoan ketoan = (Ketoan)tim_kiem_chucvu("Ke toan") ;
        if (ketoan == null)
        {
            System.out.println("Vui long them nhan vien Ke toan truoc khi xem bao cao!");
            return;
        }
        ketoan.thong_ke_doanhthu(1 , nam);
        ketoan.thong_ke_loinhuan(1 , nam);
        for ( int i = 2 ; i <= 12 ; i++ )
        {
            ketoan.thong_ke_doanhthu(i , nam);
            if ( ketoan.tinh_thong_ke_doanhthu(i - 1 , nam ) != 0 )
            {
                double tang_theo_phantram_dt = ((float)ketoan.tinh_thong_ke_doanhthu(i , nam)/ (float) ketoan.tinh_thong_ke_doanhthu(i - 1 , nam)) - 1.0;
                double tang_theo_phantram_ln = ((float)ketoan.tinh_loinhuan(i , nam)/ (float) ketoan.tinh_loinhuan(i - 1 , nam)) - 1.0;
                if ( tang_theo_phantram_dt < 0 ) System.out.printf("Doanh thu giam %.2f so voi thang truoc!" , (double)Math.round(tang_theo_phantram_dt*-100));
                else System.out.printf( "Doanh thu tang %.2f so voi thang truoc!" , (double)Math.round(tang_theo_phantram_dt*100) );
                ketoan.thong_ke_loinhuan(i , nam);
                if ( tang_theo_phantram_ln < 0 ) System.out.printf("Loi nhuan giam %.2f so voi thang truoc!" , (double)Math.round(tang_theo_phantram_ln*-100));
                else System.out.printf( "Loi nhuan tang %.2f so voi thang truoc!" , (double)Math.round(tang_theo_phantram_ln*100) );
            }
            else
            {
                ketoan.thong_ke_loinhuan(i , nam);
                System.out.println("Thang truoc khong co hoat dong kinh doanh!");
            }
        }
    }
    public void Baocao_doanhthu_loinhuan_hangnam ( int nam_thanh_lap )
    {
        Ketoan ketoan = (Ketoan)tim_kiem_chucvu("Ke toan") ;
        if (ketoan == null)
        {
            System.out.println("Vui long them nhan vien Ke toan truoc khi xem bao cao!");
            return;
        }
        ketoan.thong_ke_doanhthu(nam_thanh_lap);
        ketoan.thong_ke_loinhuan(nam_thanh_lap);
        for ( int i = nam_thanh_lap + 1 ; i < LocalDate.now().getYear() ; i++ )
        {
            ketoan.thong_ke_doanhthu(i);
            if ( ketoan.tinh_thong_ke_doanhthu(i - 1 ) != 0 )
            {
                double tang_theo_phantram_dt = ((float)ketoan.tinh_thong_ke_doanhthu(i)/ (float) ketoan.tinh_thong_ke_doanhthu(i - 1 )) - 1.0;
                double tang_theo_phantram_ln = ((float)ketoan.tinh_loinhuan(i)/ (float) ketoan.tinh_loinhuan(i - 1)) - 1.0;
                if ( tang_theo_phantram_dt < 0 ) System.out.printf("Doanh thu giam %.2f so voi nam truoc!" , (double)Math.round(tang_theo_phantram_dt*-100));
                else System.out.printf( "Doanh thu tang %.2f so voi nam truoc!" , (double)Math.round(tang_theo_phantram_dt*100) );
                ketoan.thong_ke_loinhuan(i);
                if ( tang_theo_phantram_ln < 0 ) System.out.printf("Loi nhuan giam %.2f so voi thang truoc!" , (double)Math.round(tang_theo_phantram_ln*-100));
                else System.out.printf( "Loi nhuan tang %.2f so voi nam truoc!" , (double)Math.round(tang_theo_phantram_ln*100) );
            }
            else
            {
                ketoan.thong_ke_loinhuan(i);
                System.out.println("nam truoc khong co hoat dong kinh doanh!");
            }
        }
    }
    public void Baocao_doanhthu_loinhuan_hangquy ( int nam )
    {
        Ketoan ketoan = (Ketoan)tim_kiem_chucvu("Ke toan") ;
        if (ketoan == null)
        {
            System.out.println("Vui long them nhan vien Ke toan truoc khi xem bao cao!");
            return;
        }
        ketoan.tinh_thong_ke_doanhthu_theoquy(1 , nam) ;
        ketoan.thong_ke_loinhuan_theoquy(1 ,nam);
        for ( int i = 2 ; i <= 4 ; i++ )
        {
            ketoan.thong_ke_doanhthu_theoquy(i , nam);
            if ( ketoan.tinh_thong_ke_doanhthu_theoquy( i - 1 , nam ) != 0 )
            {
                double tang_theo_phantram_dt = (float)ketoan.tinh_thong_ke_doanhthu_theoquy(i , nam)/ (float) ketoan.tinh_thong_ke_doanhthu_theoquy(i - 1 , nam ) - 1.0;
                double tang_theo_phantram_ln = (float)ketoan.tinh_loinhuan_theoquy(i , nam)/ (float) ketoan.tinh_loinhuan_theoquy(i - 1 , nam ) - 1.0;
                if ( tang_theo_phantram_dt < 0 ) System.out.printf("Doanh thu giam %.2f so voi quy truoc!" , (double)Math.round(tang_theo_phantram_dt*-100));
                else System.out.printf( "Doanh thu tang %.2f so voi quy truoc!" , (double)Math.round(tang_theo_phantram_dt*100) );
                ketoan.thong_ke_loinhuan_theoquy(i , nam);
                if ( tang_theo_phantram_ln < 0 ) System.out.printf("Loi nhuan giam %.2f so voi quy truoc!" , (double)Math.round(tang_theo_phantram_ln*-100));
                else System.out.printf( "Loi nhuan tang %.2f so voi quy truoc!" , (double)Math.round(tang_theo_phantram_ln*100) );
            }
            else
            {
                ketoan.thong_ke_loinhuan_theoquy( i , nam);
                System.out.println("Quy truoc khong co hoat dong kinh doanh!");
            }
        }
    }
    public void tke_sp_ban( int ngay , int thang , int nam )
    {
        Ketoan ketoan = (Ketoan)tim_kiem_chucvu("Ke toan") ;
        ketoan.Tke_hanghoa_ban_duoc( ngay , thang , nam );
    }
    public void tke_sp_ban_theothang( int nam )
    {
        Ketoan ketoan = (Ketoan)tim_kiem_chucvu("Ke toan") ;
        for ( int i = 1 ; i <= 12 ; i++ )
           ketoan.Tke_hanghoa_ban_duoc( i , nam );
    }
    public void tke_sp_ban(  int nam )
    {
        Ketoan ketoan = (Ketoan)tim_kiem_chucvu("Ke toan") ;
        ketoan.Tke_hanghoa_ban_duoc( nam );
    }
    public void tke_sp_bantheoquy( int nam )
    {
        Ketoan ketoan = (Ketoan)tim_kiem_chucvu("Ke toan") ;
        for ( int i = 1 ; i <= 4 ; i++ )
        {
            ketoan.Tke_hanghoa_ban_duoc_theoquy(i , nam);
        }
    }
    public void thong_ke_sp_ban_duoc()
    {
        Quanly quanly = (Quanly) tim_kiem_chucvu("Quan ly") ;
        quanly.phantich_sp_ban_ra();
    }
    public void ktra_sp_saphet()
    {
        Quanly quanly = (Quanly) tim_kiem_chucvu("Quan ly") ;
        quanly.tracuu_sp_saphet();
    }
    public void Quanly_nhapxuat ()
    {
        System.out.println("Danh sach qua trinh nhap san pham! ");
        for ( Sanpham sp:sanphams)
        {
            for ( int i = 0 ; i < sp.getNgay_nhap().size() ; i++  )
            {
                System.out.println("Ma san pham: " + sp.getMa_sp() + " | Ten san pham: " + sp.getTen_sp() + " | Gia nhap: " + sp.getNgay_nhap() + " | So luong: " + sp.getSo_luong_nhap().get(i) + " | Ngay nhap: " + sp.getNgay_nhap().get(i) + " | Chi phi nhap: " + sp.getSo_luong_nhap().get(i)*sp.getGia_nhap() );
            }
        }
    }
    public void tke_sp_banchayhangthang( int nam )
    {
        Ketoan ketoan = (Ketoan) tim_kiem_chucvu("Ke toan") ;
        System.out.println("Cac san pham ban chay qua tung thang!");
        for ( int i = 1 ; i <= 12 ; i++ )
        {
            ketoan.sp_banchay( i , nam  );
        }
    }
    public void tke_sp_banchayhangquy ( int nam )
    {
        Ketoan ketoan = (Ketoan) tim_kiem_chucvu("Ke toan") ;
        System.out.println("Cac san pham ban chay qua tung quy !");
        for ( int i = 1 ; i <= 4 ; i++ )
        {
            ketoan.sp_banchay_theoquy(i , nam);
        }
    }
    public void tke_sp_banchayhangnam ( int nam_thanh_lap )
    {
        Ketoan ketoan = (Ketoan) tim_kiem_chucvu("Ke toan") ;
        System.out.println("Cac san pham ban chay qua tung nam!");
        for ( int i = nam_thanh_lap ; i < LocalDate.now().getYear(); i++ )
        {
            ketoan.sp_banchay(i);
        }
    }
    public void lich_su_mua_hang ( String ma_kh )
    {
        int index = -1 ;
        for ( int i = 0 ; i < khachhangs.size() ; i++ )
        {
            if ( khachhangs.get(i).getMa_kh().equalsIgnoreCase(ma_kh))
            {
                index = i ;
                break;
            }
        }
        if ( index == -1 )
        {
            khong_tontai();
            return;
        }
        System.out.println("Lịch sử mua hàng của khách hàng có mã khách hàng " + khachhangs.get(index).getMa_kh() + " ten " +  khachhangs.get(index).getHoten() + " la: ");
        for ( Nhanvien nv: nhanviens)
        {
            if ( nv instanceof Thungan)
            {
                for ( Hoadon hd: ((Thungan) nv).getHoadons() )
                {
                    if ( hd.getMa_kh().equalsIgnoreCase(ma_kh))
                    {
                        System.out.println(hd);
                        ctHoadon cthd = hd.tra_cuu_cthd(((Thungan) nv).getCtHoadons()) ;
                        cthd.get_hd();
                    }
                }
            }
        }
    }
}
class Ghidocfilejs
{
    public static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(date.format(DateTimeFormatter.ofPattern("d/M/yyyy")));
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern("d/M/yyyy"));
                }
            })
            .create();
    public static void ghi_sanpham (ArrayList<Sanpham> sanphams )
    {
        String ten_file = "dulieusanpham.json" ;
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ten_file)))
        {
            for ( Sanpham sp:sanphams)
            {
                String data = gson.toJson(sp);
                bw.write(data);
                bw.newLine();
            }
            System.out.println("Lưu dữ liệu thành công!");
        }
        catch ( IOException e)
        {
            System.out.println("Ghi file thất bại!");
        }
    }
    public static void ghi_nhanvien (ArrayList<Nhanvien> nhanviens )
    {
        String ten_file = "dulieunhanvien.json" ;
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ten_file)))
        {
            for ( Nhanvien nv:nhanviens)
            {
                String data = gson.toJson(nv);
                bw.write(data);
                bw.newLine();
            }
            System.out.println("Lưu dữ liệu thành công!");
        }
        catch ( IOException e)
        {
            System.out.println("Ghi file thất bại!");
        }
    }
    public static void ghi_nhacungcap (ArrayList<Nhacungcap> nhacungcaps )
    {
        String ten_file = "dulieunhacungcap.json" ;
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ten_file)))
        {
            for ( Nhacungcap ncc:nhacungcaps)
            {
                String data = gson.toJson(ncc);
                bw.write(data);
                bw.newLine();
            }
            System.out.println("Lưu dữ liệu thành công!");
        }
        catch ( IOException e)
        {
            System.out.println("Ghi file thất bại!");
        }
    }
    public static void ghi_khachhang (ArrayList<Khachhang> khachhangs )
    {
        String ten_file = "dulieukhachhang.json" ;
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ten_file)))
        {
            for ( Khachhang kh: khachhangs)
            {
                String data = gson.toJson(kh);
                bw.write(data);
                bw.newLine();
            }
            System.out.println("Lưu dữ liệu thành công!");
        }
        catch ( IOException e)
        {
            System.out.println("Ghi file thất bại!");
        }
    }
    public static void ghi_hoadon ( ArrayList<Hoadon> hoadons)
    {
        String ten_file = "dulieuhoadon.json" ;
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ten_file)))
        {
            if (hoadons == null) {
                hoadons = new ArrayList<>();
            }
            for ( Hoadon hd: hoadons)
            {
                String data = gson.toJson(hd);
                bw.write(data);
                bw.newLine();
            }
            System.out.println("Lưu dữ liệu thành công!");
        }
        catch ( IOException e)
        {
            System.out.println("Ghi file thất bại!");
        }
    }
    public static ArrayList<Sanpham> nap_sanpham()
    {
        String ten_file = "dulieusanpham.json" ;
        ArrayList<Sanpham> ds_sp = new ArrayList<>() ;
        try ( FileReader reader = new FileReader(ten_file))
        {
            JsonElement parsedElement = JsonParser.parseReader(reader);
            if (parsedElement != null && parsedElement.isJsonArray()) {
                JsonArray jsonArray = parsedElement.getAsJsonArray();
                Sanpham sp = null ;
                for ( JsonElement element: jsonArray )
                {
                    JsonObject jsonObject = element.getAsJsonObject();
                    String Loai_sp = jsonObject.get("Loai").getAsString() ;
                    if ( Loai_sp.equalsIgnoreCase("Thuc pham"))
                    {
                        sp = gson.fromJson( jsonObject , Thucpham.class) ;
                    }
                    else if ( Loai_sp.equalsIgnoreCase("Tieu dung"))
                    {
                        sp = gson.fromJson( jsonObject , Tieudung.class) ;
                    }
                    else if ( Loai_sp.equalsIgnoreCase("Dien tu"))
                    {
                        sp = gson.fromJson( jsonObject , Dientu.class) ;
                    }
                    if ( sp != null ) ds_sp.add(sp) ;
                }
                System.out.println("Nạp dữ liệu thành công!");
            } else {
                System.out.println("File " + ten_file + " hiện đang trống, bỏ qua việc đọc.");
            }
        }
        catch ( IOException e)
        {
            System.out.println("Nạp dữ liệu thất bại!");
            e.printStackTrace();
        }
        return ds_sp ;
    }
    public static ArrayList<Khachhang> nap_khachhang()
    {
        String ten_file = "dulieukhachhang.json" ;
        ArrayList<Khachhang> khachhhangs = new ArrayList<>() ;
        try ( FileReader reader = new FileReader(ten_file))
        {
            JsonElement parsedElement = JsonParser.parseReader(reader);

            // 2. Chặn lỗi: Nếu file không rỗng VÀ đúng là một danh sách (bắt đầu bằng '[')
            if (parsedElement != null && parsedElement.isJsonArray()) {
                JsonArray jsonArray = parsedElement.getAsJsonArray();

                for (JsonElement element : jsonArray) {
                    Khachhang kh = gson.fromJson(element, Khachhang.class);
                    khachhhangs.add(kh) ;
                }
                System.out.println("Nạp dữ liệu thành công!");
            } else {
                System.out.println("File " + ten_file + " hiện đang trống, bỏ qua việc đọc.");
            }
        }
        catch ( IOException e )
        {
            System.out.println("Nạp dữ liệu thất bại!");
            e.printStackTrace();
        }
        return khachhhangs ;
    }
    public static ArrayList<Nhacungcap> Nap_nhacungcap()
    {
        String ten_file = "dulieunhacungcap.json" ;
        ArrayList<Nhacungcap> nhacungcaps = new ArrayList<>() ;
        File ktra_file = new File(ten_file) ;
        try ( FileReader reader = new FileReader(ten_file))
        {
            JsonElement parsedElement = JsonParser.parseReader(reader);
            if (parsedElement != null && parsedElement.isJsonArray()) {
                JsonArray jsonArray = parsedElement.getAsJsonArray();
                for (JsonElement element : jsonArray) {
                    Nhacungcap ncc = gson.fromJson(element, Nhacungcap.class);
                    nhacungcaps.add(ncc) ;
                }
                System.out.println("Nạp dữ liệu thành công!");
            } else {
                // Tùy chọn: In ra để bạn biết file đang trống
                System.out.println("File " + ten_file + " hiện đang trống, bỏ qua việc đọc.");
            }
        }
        catch ( IOException e)
        {
            System.out.println("Nạp dữ liệu thất bại!");
            e.printStackTrace();
        }
        return nhacungcaps ;
    }
    public static ArrayList<Hoadon> nap_hoadon()
    {
       String ten_file = "dulieuhoadon.json" ;
       ArrayList<Hoadon> hoadons = new ArrayList<>();
       try ( FileReader reader = new FileReader(ten_file))
       {
           JsonElement parsedElement = JsonParser.parseReader(reader);
           if (parsedElement != null && parsedElement.isJsonArray()) {
               JsonArray jsonArray = parsedElement.getAsJsonArray();
               for (JsonElement element : jsonArray) {
                   Hoadon hd = gson.fromJson(element, Hoadon.class);
                   hoadons.add(hd) ;
               }
               System.out.println("Nạp dữ liệu thành công!");
           } else {
               // Tùy chọn: In ra để bạn biết file đang trống
               System.out.println("File " + ten_file + " hiện đang trống, bỏ qua việc đọc.");
           }
       }
       catch ( IOException e )
       {
           System.out.println("Nạp dữ liệu thất bại");
           e.printStackTrace();
       }
       return hoadons ;
    }
    public static ArrayList<Nhanvien> nap_nhanvien()
    {
        String ten_file = "dulieunhanvien.json";
        ArrayList<Nhanvien> nhanviens = new ArrayList<>();
        try (FileReader reader = new FileReader(ten_file))
        {
            JsonElement parsedElement = JsonParser.parseReader(reader);
            if (parsedElement != null && parsedElement.isJsonArray()) {
                JsonArray jsonArray = parsedElement.getAsJsonArray();
                for (JsonElement element : jsonArray)
                {
                    JsonObject jsonObject = element.getAsJsonObject();
                    String chucvu = jsonObject.get("chuc_vu").getAsString();
                    Nhanvien nv = null;
                    if (chucvu.equalsIgnoreCase("Thu ngan"))
                    {
                        nv = gson.fromJson(jsonObject, Thungan.class);
                    }
                    else if (chucvu.equalsIgnoreCase("Thu kho"))
                    {
                        nv = gson.fromJson(jsonObject, Thukho.class);
                    }
                    else if (chucvu.equalsIgnoreCase("Ke toan"))
                    {
                        nv = gson.fromJson(jsonObject, Ketoan.class);
                    }
                    else if (chucvu.equalsIgnoreCase("Quan ly"))
                    {
                        nv = gson.fromJson(jsonObject, Quanly.class);
                    }

                    if (nv != null) {
                        nhanviens.add(nv);
                    }
                }
                System.out.println("Nạp dữ liệu thành công!");
            } else {
                System.out.println("File " + ten_file + " hiện đang trống, bỏ qua việc đọc.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Nạp dữ liệu thất bại!");
            e.printStackTrace();
        }

        return nhanviens;
    }
}
class Giaodien
{
    private static final Quanlysieuthi qly = new Quanlysieuthi() ;
    private static final Scanner scanner = new Scanner(System.in) ;
    public void giaodien()
    {
        boolean countinue = true;
        while ( countinue )
        {
            System.out.println("================QUAN LY SIEU THI MINI===============");
            System.out.println("1.Nạp dữ liệu vào chương trình!");
            System.out.println("2.Đăng nhập dưới vai trò khách hàng!");
            System.out.println("3.Đăng nhập dưới vai trò thu ngân!");
            System.out.println("4.Đăng nhập dưới vai trò thủ kho!");
            System.out.println("5.Đăng nhập dưới vai trò kế toán !");
            System.out.println("6.Đăng nhập dưới vai trò quản lý!");
            System.out.println("7.Đăng nhập dưới vai trò nhà cung cấp!");
            System.out.println("8.Đăng nhập dưới vai trò chủ siêu thị!");
            System.out.println("0.Thoát chương trình!");
            System.out.println("Nhap Lua Chon: ");
            int Luachon = scanner.nextInt();
            switch (Luachon)
            {
                case 1:
                    Menu_taodulieu() ;
                    break;
                case 2:
                    Menu_Khachhang();
                    break;
                case 3:
                    Menu_Thungan() ;
                    break;
                case 4:
                    Menu_Thukho() ;
                    break;
                case 5:
                    Menu_Ketoan() ;
                    break;
                case 6:
                    Menu_Quanly() ;
                    break;
                case 7:
                    Menu_nhacungcap() ;
                    break;
                case 8:
                    Menu_chusieuthi() ;
                    break;
                case 0:
                    Ghidocfilejs.ghi_khachhang(qly.getKhachhangs());
                    Ghidocfilejs.ghi_nhacungcap(qly.getNhacungcaps());
                    Ghidocfilejs.ghi_nhanvien(qly.getNhanviens());
                    Ghidocfilejs.ghi_sanpham(qly.getSanphams());
                    Ketoan kt = (Ketoan) qly.tim_kiem_chucvu("Ke toan") ;
                    if ( kt != null )
                    {
                        Ghidocfilejs.ghi_hoadon(kt.getTong_hd());
                    }
                    else
                        System.out.println("Chương trình chưa có kế toán nên không sao lưu hoá đơn");
                    System.out.println("Sao lưu dữ liệu thành công!");
                    System.out.println("Tạm bịt");
                    countinue = false ;
                    break;
                default: System.out.println("Lua chon khong hop le!");
                break;
            }
        }
        System.out.println("tạm bịt!");
    }
    public void Menu_taodulieu()
    {
        boolean countinue = true;
        while ( countinue )
        {
            System.out.println("==================NẠP DỮ LIỆU CHO CHƯƠNG TRÌNH===============");
            System.out.println("1.Tạo danh sách sản phẩm!");
            System.out.println("2.Tạo danh sách nhân viên!");
            System.out.println("3.Tạo danh sách nhà cung cấp!");
            System.out.println("4.Tạo danh sách khách hàng!");
            System.out.println("5.Tạo danh sách hoá đơn và chi tiết hoá đơn!");
            System.out.println("6.Nạp sẵn dữ liệu vào!");
            System.out.println("0.Trở về giao diện!");
            System.out.println("Nhap Lua Chon: ");
            int Luachon = scanner.nextInt();
            scanner.nextLine() ;
            switch (Luachon)
            {
                case 1:
                    qly.tao_dulieu_sp();
                    break;
                case 2:
                    qly.tao_dulieu_nv();
                    break;
                case 3:
                    qly.tao_dulieu_ncc();
                    break;
                case 4:
                    qly.tao_dulieu_kh();
                    break;
                case 5:
                    qly.tao_ds_hoadon();
                    break;
                case 6:
                    qly.setKhachhangs(Ghidocfilejs.nap_khachhang());
                    qly.setSanphams(Ghidocfilejs.nap_sanpham());
                    qly.setNhacungcaps(Ghidocfilejs.Nap_nhacungcap());
                    qly.setNhanviens(Ghidocfilejs.nap_nhanvien());
                    ArrayList<Hoadon> hoadons = Ghidocfilejs.nap_hoadon() ;
                    ArrayList<ctHoadon> cthds = new ArrayList<>();
                    for (Hoadon hd : hoadons) {
                        hd.setSanphams(qly.getSanphams());
                        ctHoadon cthd = new ctHoadon(hd.getSanphams());
                        cthd.setMa_phieu(hd.getMa_phieu());
                        cthd.setMa_sp(hd.getMa_sp());
                        cthd.setSoluong(hd.getSoluong());
                        cthds.add(cthd);
                    }
                    for ( Nhacungcap ncc: qly.getNhacungcaps())
                    {
                        for ( Sanpham sp: qly.getSanphams())
                        {
                            for ( String ma_ncc: sp.getMa_ncc())
                            {
                                if ( ma_ncc.equalsIgnoreCase(ncc.getMa_ncc()))
                                {
                                    ncc.getSanphams().add(sp) ;
                                    break;
                                }
                            }
                        }
                    }
                    for ( Nhanvien nv: qly.getNhanviens())
                    {
                        if (nv instanceof Thungan) {
                            ((Thungan) nv).setSanphams(qly.getSanphams());
                            ((Thungan) nv).setKhachhangs(qly.getKhachhangs());
                            ArrayList<Hoadon> hoadons1 = new ArrayList<>();
                            ArrayList<ctHoadon> ctHoadons = new ArrayList<>();
                            for (Hoadon hd : hoadons) {
                                if (hd.getMa_nv().equalsIgnoreCase(nv.getMa_nv())) {
                                    hoadons1.add(hd);
                                    if (!cthds.isEmpty()) ctHoadons.add(hd.tra_cuu_cthd(cthds));
                                }
                            }
                            ((Thungan) nv).setHoadons(hoadons1);
                            ((Thungan) nv).setCtHoadons(ctHoadons);
                        }
                        else if (nv instanceof Ketoan) {
                            ((Ketoan) nv).setSanphams(qly.getSanphams());
                            ((Ketoan) nv).setNhanviens(qly.getNhanviens());
                        }
                        else if (nv instanceof Thukho) {
                            ((Thukho) nv).setSanphams(qly.getSanphams());
                        }
                        else if (nv instanceof Quanly) {
                            ((Quanly) nv).setSanphams(qly.getSanphams());
                            ((Quanly) nv).setNhanviens(qly.getNhanviens());
                            ((Quanly) nv).setNhacungcaps(qly.getNhacungcaps());
                        }
                    }
                case 0: countinue = false ;
                default: System.out.println("Lua chon khong hop le!");
                    break;
            }
            System.out.println("Ban co muon tiep tuc trong thư mục tạo dữ liệu(yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
                countinue = false ;
        }
    }
    public void Menu_Khachhang()
    {

    }
    public void Menu_Thungan()
    {
        ArrayList<Nhanvien> nv = qly.getNhanviens() ;
        if ( qly.tim_kiem_chucvu("Thu ngan") == null )
        {
            System.out.println("Vui long them nhan vien thu ngan!");
            giaodien();
        }
        else
        {
            System.out.println("Chon nhan vien de them hoa don: ");
            for ( int i = 0 ; i < nv.size() ; i++ )
            {
                if ( nv.get(i) instanceof Thungan)
                    System.out.println( (i+1) + ".Ma nhan vien: " + nv.get(i).getMa_nv() + " | Ten nhan vien: " + nv.get(i).getHoten());
            }
            System.out.println("Lua chon: ");
            int Luachon = scanner.nextInt() ;
            scanner.nextLine() ;
            int index = 0 ;
            for ( int i = 0 ; i < nv.size() ; i++ )
            {
                if ( nv.get(i) instanceof Thungan )
                {
                    index++ ;
                    if ( index == Luachon)
                    {
                        index = i ;
                        break;
                    }
                }
            }
            Thungan tn = (Thungan) nv.get(index) ;
            boolean countinue = true;
            while ( countinue )
            {
                System.out.println("==================NHÂN VIÊN THU NGÂN===============");
                System.out.println("1.Thêm hoá đơn!");
                System.out.println("2.Xoá hoá đơn!");
                System.out.println("3.Sửa hoá đơn!");
                System.out.println("4.Tra cứu hoá đơn!");
                System.out.println("5.in tất cả hoá đơn!");
                System.out.println("6.Thông tin nhân viên!");
                System.out.println("0.Trở về giao diện!");
                System.out.println("Nhập lựa chọn: ");
                int Luachon1 = scanner.nextInt();
                scanner.nextLine();
                switch (Luachon1)
                {
                    case 1:
                        tn.tao_hoa_don();
                        break;
                    case 2:
                        System.out.println("Nhập mã hoá đơn cần xoá: ");
                        tn.xoa_hd(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập mã hoá đơn cần sửa: ");
                        tn.sua_hd(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập mã hoá đơn cần tra cứu: ");
                        tn.Tra_cuu_hd(scanner.nextLine());
                        break;
                    case 5:
                        tn.in_ds_hoadon();
                        break;
                    case 6:
                        System.out.println("Thông tin nhân viên");
                        System.out.println(tn);
                    case 0: countinue = false ;
                    default: System.out.println("Lựa chọn không hợp lệ!");
                        break;
                }
                System.out.println("Bạn có muốn tiếp tục ở lại trong thư mục thu ngân(yes/no): ");
                String tiep_tuc = scanner.nextLine() ;
                if ( tiep_tuc.equalsIgnoreCase("no"))
                    countinue = false ;
            }
        }
    }
    public void Menu_Thukho()
    {
        Thukho thukho = (Thukho) qly.tim_kiem_chucvu("Thu kho") ;
        if ( thukho == null )
        {
            System.out.println("Vui lòng thêm nhân viên thủ kho!");
            giaodien();
        }
        else
        {
            boolean countinue = true;
            while ( countinue )
            {
                System.out.println("==================NHÂN VIÊN THỦ KHO===============");
                System.out.println("1.Kiểm tra số lượng tồn kho!");
                System.out.println("2.Sửa số liệu sản phẩm trong kho!");
                System.out.println("3.In danh sách các sản phẩm tồn kho!");
                System.out.println("4.Tra cứu sản phẩm trong kho!");
                System.out.println("5.Loại bỏ các sản phẩm hết hạn!");
                System.out.println("6.Tra cứu sản phẩm trên khoảng giá bán ");
                System.out.println("7.Thong tin nhân viên thủ khoa!");
                System.out.println("0.Trở về giao diện!");
                System.out.println("Nhập lựa chọn: ");
                int Luachon = scanner.nextInt();
                scanner.nextLine();
                switch (Luachon)
                {
                    case 1:
                        thukho.Soluong_sp_tonkho();
                        break;
                    case 2:
                        System.out.println("Nhập mã sản phẩm cần sửa");
                        thukho.sua_tt_sp(scanner.nextLine());
                        break;
                    case 3:
                        thukho.hien_thi_sp();
                        break;
                    case 4:
                        System.out.println("Nhập mã sản phẩm cần tra cứu");
                        thukho.tracuu_sp(scanner.nextLine());
                        break;
                    case 5:
                        thukho.Loaibo_sp_hethan();
                        break;
                    case 6:
                        System.out.println("Nhập tên sản phẩm: ");
                        String ten = scanner.nextLine() ;
                        System.out.println("Nhập khoảng giá trị sản phẩm!");
                        System.out.println("Giá trị min: ");
                        int min = scanner.nextInt() ;
                        System.out.println("Giá trị max: ");
                        int max = scanner.nextInt() ;
                        qly.tracuu_sp_tren_khoang(ten , min , max );
                        break;
                    case 7:
                        System.out.println("Thông tin nhân viên thủ kho");
                        System.out.println(thukho);
                        break;
                    case 0: countinue = false ;
                    default: System.out.println("Lua chon khong hop le!");
                        break;
                }
                System.out.println("Ban co muon tiep tuc ở trong thư mục thủ kho(yes/no): ");
                String tiep_tuc = scanner.nextLine() ;
                if ( tiep_tuc.equalsIgnoreCase("no"))
                    countinue = false ;
            }
        }
    }
    public void Menu_Ketoan()
    {
        Ketoan kt = (Ketoan) qly.tim_kiem_chucvu("Ke toan") ;
        if ( kt == null )
        {
            System.out.println("Vui lòng thêm nhân viên kế toán!");
            giaodien();
        }
        else
        {
            kt.loc_thungan();
            kt.thiet_lap_hodon();
            boolean countinue = true;
            int ngay = 0 ; int thang = 0 ; int nam = 0 ;
            while ( countinue )
            {
                System.out.println("==================NHÂN VIÊN KẾ TOÁN===============");
                System.out.println("1.Thống kê doanh thu lợi nhuận theo ngày!");
                System.out.println("2.Thống kê doanh thu lợi nhuận theo tháng!");
                System.out.println("3.Thống kê doanh thu lợi nhuận theo quý!");
                System.out.println("4.Thống kê doanh thu lợi nhuận theo năm!");
                System.out.println("5.Thống kê danh sách sản phẩm bán ra trong ngày!");
                System.out.println("6.Thống kê danh sách sản phẩm bán ra trong tháng!");
                System.out.println("7.Thống kê danh sách sản phẩm bán ra trong quý!");
                System.out.println("8.Thống kê danh sách sản phẩm bán ra trong năm!");
                System.out.println("9.Thống kê danh sách sản phẩm bán chạy trong tháng!");
                System.out.println("10.Thống kê danh sách sản phẩm bán chạy trong quý!");
                System.out.println("11.Thống kê danh sách sản phẩm bán chạy trong năm!");
                System.out.println("12.Xem thông tin kế toán!");
                System.out.println("0.Trở về giao diện!");
                System.out.println("Nhập lựa chọn: ");
                int Luachon = scanner.nextInt();
                scanner.nextLine() ;
                switch (Luachon)
                {
                    case 1:
                        System.out.println("Nhập ngày tháng năm cần thống kê doanh thu lợi nhuận!");
                        System.out.println("Ngay: ");
                        ngay = scanner.nextInt() ;
                        System.out.println("Thang: ");
                        thang = scanner.nextInt() ;
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.Baocao_doanhthu_loinhuan_ngay( ngay , thang , nam);
                        break;
                    case 2:
                        System.out.println("Nhập năm cần thống kê doanh thu lợi nhuận theo từng tháng!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.Baocao_doanhthu_loinhuan_hangthang( nam);
                        break;
                    case 3:
                        System.out.println("Nhập năm cần thống kê doanh thu lợi nhuận theo từng quý!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.Baocao_doanhthu_loinhuan_hangquy( nam);
                        break;
                    case 4:
                        System.out.println("Nhập năm thành lập để bắt đầu thống kê doanh thu lợi nhuận theo từng năm!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.Baocao_doanhthu_loinhuan_hangnam(nam);
                        break;
                    case 5:
                        System.out.println("Nhập ngày tháng năm cần thống kê sản phẩm bán ra!");
                        System.out.println("Ngay: ");
                        ngay = scanner.nextInt() ;
                        System.out.println("Thang: ");
                        thang = scanner.nextInt() ;
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.tke_sp_ban( ngay , thang , nam);
                        break;
                    case 6:
                        System.out.println("Nhập năm cần thống kê sản phẩm bán ra theo hàng tháng!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.tke_sp_ban(nam);
                        break;
                    case 7:
                        System.out.println("Nhập năm cần thống kê sản phẩm bán ra theo hàng quý!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.tke_sp_bantheoquy(nam);
                        break;
                    case 8:
                        System.out.println("Nhập năm thành lập để thống kê sản phẩm bán ra theo từng nam!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.tke_sp_ban(nam);
                        break;
                    case 9:
                        System.out.println("Nhập năm cần thống kê sản phẩm bán chạy theo hàng tháng!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.tke_sp_banchayhangthang(nam);
                        break;
                    case 10:
                        System.out.println("Nhập năm cần thống kê sản phẩm bán chạy theo hàng quý!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.tke_sp_banchayhangquy(nam);
                        break;
                    case 11:
                        System.out.println("Nhập năm thành lập để thống kê sản phẩm bán chạy theo từng năm!");
                        System.out.println("Nam: ");
                        nam = scanner.nextInt() ;
                        qly.tke_sp_banchayhangnam(nam);
                        break;
                    case 12:
                        System.out.println("Thông tin nhân viên kế toán!");
                        System.out.println(kt);
                    case 0: countinue = false ;
                    default: System.out.println("Lua chon khong hop le!");
                        break;
                }
                System.out.println("Ban co muon tiep tuc ở trong thư muc kế toán (yes/no): ");
                String tiep_tuc = scanner.nextLine() ;
                if ( tiep_tuc.equalsIgnoreCase("no"))
                    countinue = false ;
            }
        }
    }
    public void Menu_Quanly()
    {
        Quanly quanly = (Quanly) qly.tim_kiem_chucvu("Quan ly");
        if ( quanly == null )
        {
            System.out.println("Vui lòng thêm nhân viên quản lý!");
            giaodien();
        }
        else
        {
            boolean countinue = true;
            while ( countinue )
            {
                System.out.println("=========================NHÂN VIÊN QUẢN LÝ=======================");
                System.out.println("1.Thêm sản phẩm mới!");
                System.out.println("2.Xoá sản phẩm!");
                System.out.println("3.Sửa thông tin sản phẩm");
                System.out.println("4.Hiển thị tất cả sản phẩm có trong siêu thị!");
                System.out.println("5.Tra cứu sản phẩm có trong siêu thị!");
                System.out.println("6.In danh sách sản phẩm đang được trưng bày!");
                System.out.println("7.In danh sách các sản phẩm không được trưng bày!");
                System.out.println("8.Them san pham trung bay!");
                System.out.println("9.Loai bo san pham trung bay!");
                System.out.println("10.Tra cứu danh sách sản phẩm sắp hết!");
                System.out.println("11.Phân tích sản phẩm bán ra!");
                System.out.println("12.Nhập thêm hàng hoá!");
                System.out.println("13.Thiết lập giờ làm của các nhân viên!");
                System.out.println("14.Quản lý nhập xuất sản phẩm!");
                System.out.println("15.Thông tin nhân viên quản lý!");
                System.out.println("0.Trở về giao diện!");
                System.out.println("Nhập lựa chọn: ");
                int Luachon = scanner.nextInt();
                scanner.nextLine() ;
                switch (Luachon)
                {
                    case 1:
                        quanly.them_sp();
                        break;
                    case 2:
                        System.out.println("Nhập mã sản phẩm cần xoa");
                        String ma_sp = scanner.nextLine() ;
                        quanly.xoa_sp(ma_sp);
                        break;
                    case 3:
                        System.out.println("Nhập mã sản phẩm cần sua");
                        String ma_sp1 = scanner.nextLine() ;
                        quanly.sua_tt_sp(ma_sp1);
                        break;
                    case 4:
                        quanly.hien_thi_sp();
                        break;
                    case 5:
                        System.out.println("Nhập mã, tên hoặc những thứ liên quan đến sản phẩm để tra cứu:");
                        String tt_sp = scanner.nextLine() ;
                        System.out.println("Sản phẩm cần tra cứu:");
                        qly.tracuu_sp(tt_sp);
                        try
                        {
                            int soluong = Integer.parseInt(tt_sp) ;
                            qly.tracuu_sp(soluong);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("chuỗi không tồn tại chữ số để tra cứu!");
                        }
                        break;
                    case 6:
                        quanly.ds_sp_trungbay();
                        break;
                    case 7:
                        quanly.ds_sp_khongtrungbay();
                        break;
                    case 8:
                        System.out.println("Nhập mã sản phẩm để trưng bày");
                        String ma_sp2 = scanner.nextLine() ;
                        quanly.them_sp_trungbay(ma_sp2);
                        break;
                    case 9:
                        System.out.println("Nhập mã sản phẩm cần loại bỏ khỏi quầy trưng bày");
                        String ma_sp3 = scanner.nextLine() ;
                        quanly.xoa_sp_trungbay(ma_sp3);
                        break;
                    case 10:
                        quanly.tracuu_sp_saphet();
                        break;
                    case 11:
                        quanly.phantich_sp_ban_ra();
                        break;
                    case 12:
                        quanly.nhapthemhang();
                        break ;
                    case 13:
                        quanly.thietlap_so_giolam_nv();
                        break;
                    case 14:
                        qly.Quanly_nhapxuat();
                        break;
                    case 15:
                        System.out.println("Thông tin nhân viên quản lý: ");
                        System.out.println(quanly);
                        break;
                    case 0: countinue = false ;
                    default: System.out.println("Lua chon khong hop le!");
                        break;
                }
                System.out.println("Ban co muon tiep tuc ở trong thư mục quản lý (yes/no): ");
                String tiep_tuc = scanner.nextLine() ;
                if ( tiep_tuc.equalsIgnoreCase("no"))
                    countinue = false ;
            }
            giaodien();
        }
    }
    public void Menu_nhacungcap()
    {
        ArrayList<Nhacungcap> ncc = qly.getNhacungcaps() ;
        if ( ncc.isEmpty() )
        {
            System.out.println("Vui lòng thêm nhà cung cấp!");
            return;
        }
        System.out.println("Chọn nhà cung cấp: ");
        for ( int i = 0 ; i < ncc.size() ; i++ )
        {
            System.out.println((i+1) + ".Ma nha cung cap: " + ncc.get(i).getMa_ncc() + " | Tên nhà cung cấp: " + ncc.get(i).getTen_ncc());
        }
        System.out.println("Lua chon: ");
        int Luachon = scanner.nextInt() ;
        scanner.nextLine();
        Nhacungcap nhacungcap = ncc.get(Luachon) ;
        boolean countinue = true;
        while ( countinue )
        {
            System.out.println("==========================NHÀ CUNG CẤP========================");
            System.out.println("1.tra cứu sản phẩm được cung cấp bởi nhà cung cấp!");
            System.out.println("2.Danh sách các sản phẩm được nhập từ nhà cung cấp!");
            System.out.println("3.Chi phí nhập hàng từ nhà cung cấp trong 1 tháng!");
            System.out.println("4.Chi phí nhập hàng từ nhà cung cấp trong 1 quý!");
            System.out.println("5.Chi phí nhập hàng từ nhà cung cấp trong 1 năm!");
            System.out.println("6.Thông tin nhà cung cấp!");
            System.out.println("0.Trở về giao diện!");
            System.out.println("Nhập lựa chọn: ");
            int Luachon1 = scanner.nextInt();
            scanner.nextLine();
            switch (Luachon1)
            {
                case 1:
                    System.out.println("Nhập mã sản phẩm cần tra cứu: ");
                    nhacungcap.tracuu_sp(scanner.nextLine());
                    break;
                case 2:
                    nhacungcap.hien_thi_sp();
                    break;
                case 3:
                    System.out.println("Nhập tháng và năm cần tra cứu: ");
                    System.out.println("Thang: ");
                    int thang = scanner.nextInt() ;
                    System.out.println("Nam: ");
                    int nam = scanner.nextInt() ;
                    nhacungcap.in_chi_phi_nhap_hang(thang , nam);
                    break;
                case 4:
                    System.out.println("Nhập quy và năm cần tra cứu: ");
                    System.out.println("quy: ");
                    int quy = scanner.nextInt() ;
                    System.out.println("Nam: ");
                    int nam1 = scanner.nextInt() ;
                    nhacungcap.in_chi_phi_nhap_hang_theoquy(quy , nam1);
                    break;
                case 5:
                    System.out.println("Nhập năm cần tra cứu: ");
                    nhacungcap.in_chi_phi_nhap_hang(scanner.nextInt());
                case 6:
                    System.out.println("Thông tin nhà cung cấp!");
                    System.out.println(nhacungcap);
                case 0: countinue = false ;
                default: System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục ở trong thư mục nhà cung cấp (yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
                countinue = false ;
        }
    }
    public void Menu_chusieuthi()
    {
        boolean countinue = true;
        while ( countinue )
        {
            System.out.println("=========================QUẢN LÝ SIÊU THỊ=======================");
            System.out.println("1.Thêm nhân viên mới!");
            System.out.println("2.Xoá nhân viên!");
            System.out.println("3.Sửa thông tin nhân viên");
            System.out.println("4.Danh sách tất cả nhân viên!");
            System.out.println("5.Tra cứu thông tin nhân viên!");
            System.out.println("6.Thêm khách hàng mới!");
            System.out.println("7.Xoá khách hàng cũ!");
            System.out.println("8.Sửa thông tin khách hàng!");
            System.out.println("9.Danh sách khách hàng!");
            System.out.println("10.Tra cứu thông tin khách hàng!");
            System.out.println("11.Tra cứu lịch sử mua hàng của khách hàng!");
            System.out.println("12.Thêm nhà cung cấp mới!");
            System.out.println("13.Xoá nhà cung cấp!");
            System.out.println("14.Sửa thông tin nhà cung cấp!");
            System.out.println("15.Danh sách nhà cung cấp!");
            System.out.println("16.Danh sách các sản phẩm được nhập từ nhà cung cấp!");
            System.out.println("17.Tra cứu thông tin nhà cung cấp!");
            System.out.println("18.Tra cứu chi phí nhập hàng theo từng ngay!");
            System.out.println("19.Tra cứu chi phí nhập hàng theo từng tháng!");
            System.out.println("20.Tra cứu chi phí nhập hàng theo từng quý!");
            System.out.println("21.Tra cứu chi phí nhập hàng theo từng năm!");
            System.out.println("0.Trở về giao diện!");
            System.out.println("Nhập lựa chọn: ");
            int Luachon = scanner.nextInt();
            scanner.nextLine() ;
            switch (Luachon)
            {
                case 1:
                    qly.them_nv();
                    break;
                case 2:
                    System.out.println("Nhập mã nhân viên cần muốn xoá: ");
                    qly.sa_thai_nv(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập mã nhân viên cần muốn sửa: ");
                    qly.sua_tt_nv(scanner.nextLine());
                    break;
                case 4:
                    qly.hien_thi_nv();
                    break;
                case 5:
                    System.out.println("Chọn phương thức tra cứu:");
                    System.out.println("1.Tra cứu theo chuỗi!");
                    System.out.println("2.Tra cứu theo ngày tháng năm!");
                    int luachon = scanner.nextInt() ;
                    scanner.nextLine();
                    switch (luachon) {
                        case 1:
                            System.out.println("Nhập mã, tên hoặc những thứ liên quan đến nhân viên để tra cứu:");
                            String tt_nv = scanner.nextLine() ;
                            System.out.println("Nhân viên cần tra cứu:");
                            qly.tracuu_nv(tt_nv);
                            try
                            {
                                int soluong = Integer.parseInt(tt_nv) ;
                                qly.tracuu_sp(soluong);
                            }
                            catch (NumberFormatException e) {
                                System.out.println("chuỗi không tồn tại chữ số để tra cứu!");
                            }
                            break;
                        case 2:
                            System.out.println("Nhập ngày tháng năm cần tra cứu nhân viên(vd: ngày sinh 18/04/2007): ");
                            String ngay = scanner.nextLine() ;
                            DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                            qly.tracuu_nv(LocalDate.parse(ngay , khuon));
                            break;
                        default: System.out.println("Lựa chọn không hợp lệ");
                        break;
                    }
                    break;
                case 6:
                    qly.them_kh();
                    break;
                case 7:
                    System.out.println("Nhập mã khách hàng cần xoá: ");
                    qly.xoa_kh(scanner.nextLine());
                    break;
                case 8:
                    System.out.println("Nhập mã khách hàng cần sua: ");
                    qly.sua_tt_kh(scanner.nextLine());
                    break;
                case 9:
                    qly.in_ds_kh();
                    break;
                case 10:
                    System.out.println("Chọn phương thức tra cứu khách hàng:");
                    System.out.println("1.Tra cứu theo chuỗi!");
                    System.out.println("2.Tra cứu theo ngày tháng năm!");
                    int luachon1 = scanner.nextInt();
                    scanner.nextLine() ;
                    switch (luachon1) {
                        case 1:
                            System.out.println("Nhập mã, tên hoặc những thứ liên quan đến khách hàng để tra cứu:");
                            String tt_kh = scanner.nextLine() ;
                            System.out.println("Khách hàng cần tra cứu:");
                            qly.tracuu_kh(tt_kh);
                            break;
                        case 2:
                            System.out.println("Nhập ngày tháng năm cần tra cứu khách hàng(vd: ngày sinh 18/04/2007): ");
                            String ngay_nhap = scanner.nextLine() ;
                            DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                            qly.tracuu_nv(LocalDate.parse(ngay_nhap , khuon));
                            break;
                        default: System.out.println("Lựa chọn không hợp lệ");
                            break;
                    }
                    break;
                case 11:
                    System.out.println("Nhập mã khách hàng để tra cứu lịch sử mua hàng: ");
                    qly.lich_su_mua_hang(scanner.nextLine());
                    break;
                case 12:
                    qly.them_ncc();
                    break;
                case 13:
                    System.out.println("Nhập mã nhà cung cấp cần xoá!");
                    qly.huy_hoptac_ncc(scanner.nextLine());
                    break;
                case 14:
                    System.out.println("Nhập mã nhà cung cấp cần sửa!");
                    qly.sua_tt_ncc(scanner.nextLine());
                    break;
                case 15:
                    qly.in_ds_nhacungcap();
                    break;
                case 16:
                    qly.in_sp_nhap_tu_ncc();
                    break;
                case 17:
                    System.out.println("Nhập mã, tên hoặc những thứ liên quan đến nhà cung cấp để tra cứu!");
                    qly.tracuu_ncc(scanner.nextLine());
                    break;
                case 18:
                    System.out.println("Nhập ngày tháng năm cần tra cứu(vd: 18/04/2007):");
                    String ngaynhap = scanner.nextLine() ;
                    DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                    LocalDate ngaythang = LocalDate.parse(ngaynhap, khuon) ;
                    qly.chi_phi_nhap_hang(ngaythang.getDayOfMonth() , ngaythang.getMonthValue() , ngaythang.getYear()) ;
                    break;
                case 19:
                    System.out.println("Nhập tháng năm cần tra cứu):");
                    System.out.println("Nhập tháng: ");
                    int thang = scanner.nextInt() ;
                    System.out.println("Nhập năm: ");
                    int nam = scanner.nextInt() ;
                    scanner.nextLine();
                    qly.chi_phi_nhap_hang(thang , nam);
                    break;
                case 20:
                    System.out.println("Nhập quý và năm cần tra cứu):");
                    System.out.println("Nhập quý: ");
                    int quy = scanner.nextInt() ;
                    System.out.println("Nhập năm: ");
                    int nam1 = scanner.nextInt() ;
                    scanner.nextLine();
                    qly.chi_phi_nhap_hang(quy , nam1);
                    break;
                case 21:
                    System.out.println("Nhập năm cần tra cứu):");
                    System.out.println("Nhập năm: ");
                    int nam2 = scanner.nextInt() ;
                    scanner.nextLine() ;
                    qly.chi_phi_nhap_hang(nam2);
                    break;
                case 0: countinue = false ;
                default: System.out.println("Lua chon khong hop le!");
                    break;
            }
            System.out.println("Ban co muon tiep tuc thư mục chủ siêu thị(yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
                countinue = false ;
        }
    }
}

public class QLsieuthi {
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in) ;
        Giaodien giaodien = new Giaodien() ;
        giaodien.giaodien();
    }
}