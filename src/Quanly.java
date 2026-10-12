import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

class Quanly extends Nhanvien implements Admin_Sp
{
    private transient ArrayList<Nhanvien> nhanviens ;
    private transient ArrayList<Sanpham> sanphams ;
    private transient ArrayList<Nhacungcap> nhacungcaps ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Quanly( ArrayList<Sanpham> _sanphams , ArrayList<Nhacungcap> _nhacungcaps , ArrayList<Nhanvien> _nhanviens)
    {
        sanphams = _sanphams ;
        nhacungcaps = _nhacungcaps ;
        nhanviens = _nhanviens ;
        setLuong_theo_gio(37000);
        setChuc_vu("Quan ly");
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public void setNhanviens(ArrayList<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }

    public void setNhacungcaps(ArrayList<Nhacungcap> nhacungcaps) {
        this.nhacungcaps = nhacungcaps;
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public ArrayList<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public ArrayList<Nhacungcap> getNhacungcaps() {
        return nhacungcaps;
    }

    @Override
    public int tien_luong() {
        return getLuong_theo_gio()*getSo_gio_lam() ;
    }
    public void them_sp_trungbay( String ma_sp )
    {
        int index = tim_kiem_sp(ma_sp) ;
        if ( index == -1 )
        {
            System.out.println("Khong tim thay san pham can them!");
            return;
        }
        System.out.println("Nhap so luong san pham trung bay moi");
        int new_sluong = scanner.nextInt();
        while ( new_sluong > sanphams.get(index).getSo_luong_ton_kho())
        {
            System.out.println("So luong san pham ton kho khong dap ung nhu cau trung bay, hien tai san pham ton kho la: " + sanphams.get(index).getSo_luong_ton_kho());
            System.out.println("Nhap lai so san pham trung bay moi: ");
            new_sluong = scanner.nextInt() ;
        }
        sanphams.get(index).setSo_sp_trungbay(new_sluong);
        sanphams.get(index).setSo_luong_ton_kho(sanphams.get(index).getSo_luong_ton_kho() - new_sluong);
        System.out.println("Them san pham trung bay moi thanh cong!");
    }
    public void ds_sp_trungbay()
    {
        System.out.println("Danh sach cac san pham dang duoc trung bay!");
        for ( Sanpham sp:sanphams)
        {
            if ( sp.getSo_sp_trungbay() != 0 )
                System.out.println(sp);
        }
        System.out.println("Ban co muon khong trung bay san pham nua khong(yes/no):");
        String luachon = scanner.nextLine() ;
        if ( luachon.equalsIgnoreCase("yes"))
        {
            System.out.println("Nhap ma san pham muon xoa trung bay: ");
            String ma_sp = scanner.nextLine() ;
            xoa_sp_trungbay(ma_sp);
        }
    }
    public void ds_sp_khongtrungbay()
    {
        System.out.println("Danh sach cac san pham dang khong duoc trung bay!");
        for ( Sanpham sp:sanphams)
        {
            if ( sp.getSo_sp_trungbay() == 0 )
                System.out.println(sp);
        }
        System.out.println("Ban co muon trung bay them khong(yes/no):");
        String luachon = scanner.nextLine() ;
        if ( luachon.equalsIgnoreCase("yes"))
        {
            System.out.println("Nhap ma san pham can trung bay them: ");
            String ma_sp = scanner.nextLine() ;
            them_sp_trungbay(ma_sp);
        }
    }
    public void xoa_sp_trungbay ( String ma_sp )
    {
        Sanpham sp = sanphams.get(tim_kiem_sp(ma_sp)) ;
        if ( sp == null )
        {
            System.out.println("Khong tim thay san pham!");
            return ;
        }
        if ( sp.getSo_sp_trungbay() != 0 )
            sp.setSo_luong_ton_kho(sp.getSo_luong_ton_kho()+sp.getSo_sp_trungbay());
        sp.setSo_sp_trungbay(0);
    }
    public void thietlap_so_giolam_nv ()
    {
        System.out.println("Thiet lap so gio lam cua cac nhan vien: ");
        for ( Nhanvien nv: nhanviens)
        {
            if ( !(nv instanceof Quanly))
            {
                System.out.println("Nhap gio lam cua nhan vien co ma nhan vien " + nv.getMa_nv() + " va co ho ten la " + nv.getHoten() + " : ");
                int gio_lam = scanner.nextInt() ;
                nv.setSo_gio_lam(gio_lam); ;
                System.out.println("Nhap gio lam cua nhan vien thanh cong!");
            }
        }
    }
    public void tracuu_sp_saphet ()
    {
        System.out.println("Danh sach cac san pham sap het!");
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getSo_luong_ton_kho() < 10 &&( sp instanceof Tieudung || (sp instanceof Thucpham && ((Thucpham) sp).so_ngay_su_dung() > 8)))
            {
                System.out.println(sp);
            }
        }
    }
    public int tim_kiem_ncc ( String ma_ncc )
    {
        int index = -1 ;
        for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
        {
            if ( nhacungcaps.get(i).getMa_ncc().equalsIgnoreCase(ma_ncc))
            {
                index = i ;
                break;
            }
        }
        return index ;
    }
    public void them_sp()
    {
        System.out.println("Nhap lua chon: ");
        System.out.println("1.Them san pham thuc pham!");
        System.out.println("2.Them san pham tieu dung!");
        System.out.println("3.Them san pham dien tu!");
        Sanpham sanpham ;
        int Luachon = scanner.nextInt() ;
        scanner.nextLine();
        switch (Luachon)
        {
            case 1 :
                if ( nhacungcaps == null )
                {
                    System.out.println("Vui lòng thêm nhà cung cấp trước đó!");
                }
                else
                {
                    sanpham = new Thucpham() ;
                    sanpham.set_sp();
                    System.out.println("Ngay nhap hang(dd/MM/yyyy): ");
                    String date = scanner.nextLine() ;
                    DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                    LocalDate ngay_nhap = LocalDate.parse(date , khuon) ;
                    System.out.println("Chon nha cung cap: ");
                    for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
                    {
                        System.out.println( (i+1) + ".Nha cung cap " + nhacungcaps.get(i).getTen_ncc() + "!");
                    }
                    System.out.println("Nhap lua chon: ");
                    int luachon1 = scanner.nextInt() ;
                    scanner.nextLine() ;
                    for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
                    {
                        if ( luachon1 - 1 == i )
                            nhacungcaps.get(i).nhandon(sanpham , sanpham.getSo_luong_ton_kho() , ngay_nhap);
                    }
                    sanphams.add(sanpham) ;
                }
                break;
            case 2 :
                if ( nhacungcaps == null )
                {
                    System.out.println("Vui lòng thêm nhà cung cấp trước đó!");
                }
                else
                {
                    sanpham = new Tieudung() ;
                    sanpham.set_sp();
                    System.out.println("Ngay nhap hang(dd/MM/yyyy): ");
                    String date = scanner.nextLine() ;
                    DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                    LocalDate ngay_nhap = LocalDate.parse(date , khuon) ;
                    System.out.println("Chon nha cung cap: ");
                    for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
                    {
                        System.out.println( (i+1) + ".Nha cung cap " + nhacungcaps.get(i).getTen_ncc() + "!");
                    }
                    System.out.println("Nhap lua chon: ");
                    int luachon2 = scanner.nextInt() ;
                    for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
                    {
                        if ( luachon2 - 1 == i )
                            nhacungcaps.get(i).nhandon(sanpham , sanpham.getSo_luong_ton_kho() , ngay_nhap );
                    }
                    sanphams.add(sanpham) ;
                }
                break;
            case 3 :
                if ( nhacungcaps == null )
                {
                    System.out.println("Vui lòng thêm nhà cung cấp trước đó!");
                }
                else
                {
                    sanpham = new Dientu() ;
                    sanpham.set_sp();
                    System.out.println("Ngay nhap hang(dd/MM/yyyy): ");
                    String date = scanner.nextLine() ;
                    DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
                    LocalDate ngay_nhap = LocalDate.parse(date , khuon) ;
                    System.out.println("Chon nha cung cap: ");
                    for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
                    {
                        System.out.println( (i+1) + ".Nha cung cap " + nhacungcaps.get(i).getTen_ncc() + "!");
                    }
                    System.out.println("Nhap lua chon: ");
                    int luachon3 = scanner.nextInt() ;
                    for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
                    {
                        if ( luachon3 - 1 == i )
                            nhacungcaps.get(i).nhandon(sanpham , sanpham.getSo_luong_ton_kho() , ngay_nhap);
                    }
                    sanphams.add(sanpham) ;
                }
                break;
            default: System.out.println("Lua chon khong hop le!");
                break;
        }
        if ( Luachon > 0 && Luachon < 4)
        {
            System.out.println("Them san pham moi thanh cong!");
        }
    }
    public int tim_kiem_sp ( String ma_sp )
    {
        int index = -1 ;
        for ( int i = 0 ; i < sanphams.size() ; i++ )
        {
            if ( sanphams.get(i).getMa_sp().equalsIgnoreCase(ma_sp))
            {
                index = i ;
                break;
            }
        }
        return index ;
    }
    public void xoa_sp( String ma_sp)
    {
        int index = tim_kiem_sp(ma_sp) ;
        if ( index == -1 )
        {
            System.out.println("Khong tim thay san pham!");
            return ;
        }
        for ( int i = 0 ; i < sanphams.get(index).getMa_ncc().size() ; i++ )
        {
            int index2 = tim_kiem_ncc(sanphams.get(index).getMa_ncc().get(i)) ;
            if ( index2 != - 1 )
                nhacungcaps.get(index2).xoa_sp(ma_sp);
        }
        sanphams.remove(index) ;
        System.out.println("Xoa san pham thanh cong!");
    }

    public void sua_tt_sp( String ma_sp )
    {
        System.out.println("Sua thong tin san pham!");
        int index = tim_kiem_sp(ma_sp) ;
        Sanpham sanpham = sanphams.get(index) ;
        System.out.println("Chon thuoc tinh can sua: ");
        System.out.println("1.Ma san pham!");
        System.out.println("2.Ten san pham!");
        System.out.println("3.Gia nhap!");
        System.out.println("4.Gia ban!");
        System.out.println("5.So luong ton kho!");
        int luachon = scanner.nextInt() ;
        scanner.nextLine() ;
        switch (luachon)
        {
            case 1:
                System.out.println("Nhap ma san pham moi cua san pham: ");
                sanphams.get(index).setMa_sp(scanner.nextLine());
                break;
            case 2:
                System.out.println("Nhap ten san pham moi cua san pham: ");
                sanphams.get(index).setTen_sp(scanner.nextLine());
                break;
            case 3:
                System.out.println("Nhap gia nhap moi cua san pham: ");
                sanphams.get(index).setGia_nhap(scanner.nextInt()); ;
                break;
            case 4:
                System.out.println("Nhap gia ban moi cua san pham: ");
                sanphams.get(index).setGia_ban(scanner.nextInt()); ;
                break;
            case 5:
                System.out.println("Nhap so luong ton kho moi cua san pham: ");
                sanphams.get(index).setSo_luong_ton_kho(scanner.nextInt());
                break;
            default: System.out.println("Lua chon khong hop le!");
        }
        System.out.println("Da thay doi thong tin sản phẩm!");
        for ( int i = 0 ; i < nhacungcaps.size() ; i++ )
        {
            for ( int j = 0 ; j < nhacungcaps.get(i).getSanphams().size() ; j++ )
            {
                if ( nhacungcaps.get(i).getSanphams().get(j) == sanpham )
                {
                    nhacungcaps.get(i).getSanphams().set(i , sanphams.get(index)) ;
                    break;
                }
            }
        }
        System.out.println("Thay doi thong tin thanh cong!");
    }

    @Override
    public void tracuu_sp(String ma_sp) {
        System.out.println("San pham can tra cuu: ");
        int index = tim_kiem_sp(ma_sp) ;
        System.out.println(sanphams.get(index));
    }
    @Override
    public void hien_thi_sp()
    {
        System.out.println("Hien thi danh sach cac san pham:");
        for ( Sanpham sp:sanphams )
            System.out.println(sp);
    }
    public ArrayList<Sanpham> tinh_sp_banchay()
    {
        ArrayList<Sanpham> spbanchay = new ArrayList<>() ;
        for ( Sanpham sp:sanphams)
        {
            int index = sp.getNgay_nhap().size() -1 ;
            int SL_ban = sp.getSo_luong_nhap().get(index) - sp.getSo_luong_ton_kho() ;
            long So_ngay_tonkho = ChronoUnit.DAYS.between(sp.getNgay_nhap().get(index) , LocalDate.now()) ;
            if (sp.Trang_thai_ban(SL_ban , (int)So_ngay_tonkho) == 1)
                spbanchay.add(sp) ;
        }
        return spbanchay ;
    }
    public ArrayList<Sanpham> tinh_sp_bane()
    {
        ArrayList<Sanpham> spbane = new ArrayList<>() ;
        for ( Sanpham sp:sanphams)
        {
            int index = sp.getNgay_nhap().size() -1 ;
            int SL_ban = sp.getSo_luong_nhap().get(index) - sp.getSo_luong_ton_kho() ;
            long So_ngay_tonkho = ChronoUnit.DAYS.between(sp.getNgay_nhap().get(index) , LocalDate.now()) ;
            if ( sp.Trang_thai_ban(SL_ban , (int)So_ngay_tonkho) == -1 )
                spbane.add(sp) ;
        }
        return spbane ;
    }
    public void phantich_sp_ban_ra()
    {
        ArrayList<Sanpham> sanphambanchay = tinh_sp_banchay() ;
        ArrayList<Sanpham> sanphambane = tinh_sp_bane() ;
        System.out.println("Danh sach san pham ban chay: ");
        for ( Sanpham sp:sanphambanchay )
            System.out.println(sp);
        System.out.println("Danh sach san pham ban e: ");
        for ( Sanpham sp:sanphambane )
            System.out.println(sp);
    }
    public void nhapthemhang()
    {
        Thukho thukho = null ;
        for ( Nhanvien nv:nhanviens)
        {
            if ( nv instanceof Thukho )
            {
                thukho = (Thukho) nv ;
                break;
            }
        }
        phantich_sp_ban_ra();
        System.out.println("Danh sach cac san pham sap het va da het hang!");
        for ( Sanpham sp:sanphams )
        {
            if ( sp.getSo_luong_ton_kho() == 0 ) System.out.println(sp);
        }
        tracuu_sp_saphet();
        boolean countinue = true ;
        while( countinue )
        {
            System.out.println("Nhap ma san pham ban muon nhap them: ");
            String ma_sp = scanner.nextLine() ;
            System.out.println("Nhap so luong san pham ban muon nhap: ");
            int so_luong = scanner.nextInt() ;
            scanner.nextLine() ;
            System.out.println("Ngay nhap hang(dd/MM/yyyy): ");
            String date = scanner.nextLine() ;
            DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd//MM/yyyy") ;
            LocalDate ngay_nhap = LocalDate.parse(date , khuon) ;
            System.out.println("Nhap ma nha cung cap: ");
            String ma_ncc = scanner.nextLine() ;
            if ( thukho != null )
            {
                if ( thukho.ktra_sl_sp_tonkho() + so_luong > Thukho.getSuc_chua_toi_da() )
                {
                    System.out.println("Suc chua cua kho da dat toi da khong the them tiep san pham!");
                }
                else
                {
                    for ( Sanpham sp: sanphams)
                    {
                        if ( sp.getMa_sp().equalsIgnoreCase(ma_sp))
                        {
                            if ( sp instanceof Thucpham )
                            {
                                double so_ngay_sd = ((Thucpham) sp).so_ngay_su_dung() ;
                                ((Thucpham) sp).setNgay_sx(LocalDate.now());
                                ((Thucpham) sp).setNgay_het_han(LocalDate.now().plusDays((long)so_ngay_sd));
                                sp.setSo_luong_ton_kho(sp.getSo_luong_ton_kho()+ so_luong);
                            }
                            else
                            {
                                sp.setSo_luong_ton_kho(sp.getSo_luong_ton_kho()+ so_luong);
                            }
                            int index = tim_kiem_ncc(ma_ncc) ;
                            nhacungcaps.get(index).nhandon(sp , so_luong , ngay_nhap );
                        }
                    }

                    System.out.println("Nhap hang thanh cong!");
                }
            }
            else System.out.println("Khong ton tai thu kho!");
            System.out.println("Ban co muon tiep tuc(yes/no): ");
            String tiep_tuc = scanner.nextLine() ;
            if ( tiep_tuc.equalsIgnoreCase("no"))
                countinue = false ;
        }
    }
    public String toString() {
        return super.toString() + " | Luong: " + tien_luong() + " | Chuc vu: " + getChuc_vu() ;
    }
}