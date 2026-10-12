import java.util.ArrayList;
import java.util.Scanner;

class Thungan extends Nhanvien
{
    private transient ArrayList<Sanpham> sanphams ;
    private transient ArrayList<Khachhang> khachhangs ;
    private transient ArrayList<Hoadon> hoadons ;
    private transient ArrayList<ctHoadon> ctHoadons ;
    public Thungan ( ArrayList<Sanpham> _sanphams , ArrayList<Khachhang> _khachhangs )
    {
        sanphams = _sanphams ;
        khachhangs = _khachhangs ;
        hoadons = new ArrayList<>() ;
        ctHoadons = new ArrayList<>() ;
        super.setChuc_vu("Thu ngan");
        super.setLuong_theo_gio(30000);
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public ArrayList<Hoadon> getHoadons() {
        return hoadons;
    }

    public ArrayList<ctHoadon> getCtHoadons() {
        return ctHoadons;
    }

    public ArrayList<Khachhang> getKhachhangs() {
        return khachhangs;
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public void setCtHoadons(ArrayList<ctHoadon> ctHoadons) {
        this.ctHoadons = ctHoadons;
    }

    public void setHoadons(ArrayList<Hoadon> hoadons) {
        this.hoadons = hoadons;
    }

    public void setKhachhangs(ArrayList<Khachhang> khachhangs) {
        this.khachhangs = khachhangs;
    }

    @Override
    public int tien_luong() {
        return super.getSo_gio_lam()*30000 ;
    }
    public void tao_hoa_don()
    {
        ctHoadon new_cthoadon = new ctHoadon( sanphams ) ;
        new_cthoadon.set_ct_hoadon();
        ctHoadons.add(new_cthoadon) ;
        Hoadon new_Hoadon = new Hoadon(new_cthoadon.getMa_sp(),  new_cthoadon.getSoluong() , sanphams , new_cthoadon.getMa_phieu() , getMa_nv()) ;
        new_Hoadon.set_hd();
        hoadons.add(new_Hoadon) ;
        for ( Khachhang kh:khachhangs )
        {
            if ( kh.getMa_kh().equalsIgnoreCase(new_Hoadon.getMa_kh()))
            {
                kh.setDoanh_thu( kh.getDoanh_thu() + new_Hoadon.tong_tien_hd());
                kh.Hang_thanh_vien();
                break;
            }
        }
    }
    public void in_ds_hoadon()
    {
        System.out.println("In danh sach cac hoa don");
        for ( Hoadon hd: hoadons )
        {
            System.out.println(hd);
            ctHoadon cthd = hd.tra_cuu_cthd(ctHoadons) ;
            cthd.get_hd();
        }
    }
    public int timkiem_hd ( String ma_hd )
    {
        for ( int i = 0 ; i < hoadons.size() ; i++ )
        {
            if ( hoadons.get(i).getMa_phieu().equalsIgnoreCase(ma_hd))
                return i ;
        }
        return -1 ;
    }
    public void sua_hd ( String ma_hd )
    {
        int index = timkiem_hd(ma_hd) ;
        if ( index == -1)
        {
            System.out.println("Khong tim thay hoa don!");
            return;
        }
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Chon thuoc tinh can sua: ");
        System.out.println("1.Ma phieu!");
        System.out.println("2.Ma nhan vien!");
        System.out.println("3.Ma khach hang!");
        System.out.println("4.Ngay in!");
        System.out.println("5.Ma san pham!");
        System.out.println("6.So luong!");
        int luachon = scanner.nextInt() ;
        scanner.nextLine() ;
        switch (luachon)
        {
            case 1:
                System.out.println("Nhap ma phieu moi cua hoa don: ");
                String ma_phieu = scanner.nextLine() ;
                hoadons.get(index).setMa_phieu(ma_phieu);
                ctHoadon cthd = hoadons.get(index).tra_cuu_cthd(ctHoadons) ;
                cthd.setMa_phieu(ma_phieu);
                break;
            case 2:
                System.out.println("Nhap ma nhan vien moi cua nhan vien: ");
                hoadons.get(index).setMa_nv(scanner.nextLine());
                break;
            case 3:
                System.out.println("Nhap ma khach hang moi cua hoa don: ");
                hoadons.get(index).setMa_kh(scanner.nextLine());
                break;
            case 4:
                hoadons.get(index).set_ngayin();
                break;
            case 5:
                System.out.println("Nhap ma sp can sua: ");
                String ma_sp = scanner.nextLine() ;
                System.out.println("Nhap ma sp moi : ");
                String masp = scanner.nextLine() ;
                for ( int i = 0 ; i < hoadons.get(index).getMa_sp().size() ; i++ )
                {
                    if ( hoadons.get(index).getMa_sp().get(i).equalsIgnoreCase(ma_sp))
                    {
                        hoadons.get(index).getMa_sp().set( i , masp) ;
                        ctHoadon cthdon = hoadons.get(index).tra_cuu_cthd(ctHoadons) ;
                        cthdon.getMa_sp().set(i , masp);
                        break;
                    }
                }
                break;
            case 6:
                System.out.println("Nhap ma sp can sua so luong: ");
                String ma_sp1 = scanner.nextLine() ;
                System.out.println("Nhap so luong moi : ");
                int soluong = scanner.nextInt() ;
                for ( int i = 0 ; i < hoadons.get(index).getMa_sp().size() ; i++ )
                {
                    if ( hoadons.get(index).getMa_sp().get(i).equalsIgnoreCase(ma_sp1))
                    {
                        hoadons.get(index).getSoluong().set( i , soluong) ;
                        ctHoadon cthdon = hoadons.get(index).tra_cuu_cthd(ctHoadons) ;
                        cthdon.getSoluong().set(i , soluong);
                        break;
                    }
                }
                break;
            default: System.out.println("Lua chon khong hop le!");
        }
        System.out.println("Da thay doi thong tin nhan vien!");
    }
    public void xoa_hd ( String ma_hd )
    {
        int index = timkiem_hd(ma_hd) ;
        if ( index == -1 )
        {
            System.out.println("Khong tim thay hoa don can xoa!");
            return ;
        }
        for ( int i = 0 ; i < ctHoadons.size() ; i++ )
        {
            if ( ctHoadons.get(i).getMa_phieu().equalsIgnoreCase(ma_hd))
            {
                ctHoadons.remove(i) ;
                break;
            }
        }
        hoadons.remove(index) ;
        System.out.println("Xoa hoa don thanh cong!");
    }
    public void Tra_cuu_hd ( String ma_hd )
    {
        int index = timkiem_hd(ma_hd) ;
        if ( index == -1 )
        {
            System.out.println("Khong tim thay hoa don can xoa!");
            return ;
        }
        System.out.println("Hoa don can tra cuu!");
        System.out.println(hoadons.get(index));
        ctHoadon cthd = hoadons.get(index).tra_cuu_cthd(ctHoadons) ;
        cthd.get_hd();
    }
    @Override
    public String toString() {
        return super.toString() + " | Tien luong: " + tien_luong() + " | Chuc vu: " + super.getChuc_vu();
    }
}