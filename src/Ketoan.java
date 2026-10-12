import java.time.LocalDate;
import java.util.ArrayList;

class Ketoan extends Nhanvien implements Thongke
{
    private transient ArrayList<Sanpham> sanphams ;
    private transient ArrayList<Nhanvien> nhanviens ;
    private transient ArrayList<Thungan> thungans ;
    private transient final ArrayList<Hoadon> tong_hd ;
    private transient final ArrayList<ctHoadon> tong_cthd ;
    public Ketoan( ArrayList<Sanpham> _sanphams , ArrayList<Nhanvien> _nhanviens)
    {
        sanphams = _sanphams ;
        thungans = new ArrayList<>();
        nhanviens = _nhanviens ;
        super.setChuc_vu("Ke toan");
        super.setLuong_theo_gio(39000);
        tong_hd = new ArrayList<>() ;
        tong_cthd = new ArrayList<>() ;
    }

    public void setNhanviens(ArrayList<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public ArrayList<Thungan> getThungans() {
        return thungans;
    }

    public ArrayList<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public ArrayList<Hoadon> getTong_hd() {
        return tong_hd;
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public ArrayList<ctHoadon> getTong_cthd() {
        return tong_cthd;
    }

    public boolean ktra_hd (String Ma_hd )
    {
        for ( Hoadon hd:tong_hd)
            if ( hd.getMa_phieu().equalsIgnoreCase(Ma_hd))
                return true ;
        return false ;
    }
    public void thiet_lap_hodon()
    {
        for ( Thungan tn: thungans)
        {
            ArrayList<Hoadon> hdon = tn.getHoadons() ;
            for ( Hoadon hd:hdon )
            {
                if ( !ktra_hd(hd.getMa_phieu()))
                {
                    tong_hd.add(hd) ;
                    tong_cthd.add(hd.tra_cuu_cthd(tn.getCtHoadons())) ;
                }
            }
        }
    }
    public void loc_thungan()
    {
        if (this.thungans == null) {
            this.thungans = new ArrayList<>();
        }
        for ( Nhanvien nv: nhanviens )
        {
            if ( nv instanceof Thungan)
                thungans.add((Thungan) nv) ;
        }
    }
    @Override
    public int tien_luong() {
        return getSo_gio_lam()*getLuong_theo_gio();
    }
    public long  tinh_thong_ke_doanhthu( int ngay , int thang , int nam )
    {
        long sum = 0 ;
        for ( Hoadon hd: tong_hd)
        {
            LocalDate check_time = hd.getNgay_in() ;
            if ( check_time.getDayOfMonth() == ngay && check_time.getMonthValue() == thang && check_time.getYear() == nam)
            {
                sum += hd.tong_tien_hd() ;
            }
        }
        return sum ;
    }
    public void thong_ke_doanhthu( int ngay , int thang , int nam ){
        System.out.println("Doanh thu cua ngay " + ngay + " thang " + thang + " nam " + nam + " : " + tinh_thong_ke_doanhthu(ngay , thang , nam ));
    }
    public long tinh_thong_ke_doanhthu ( int thang , int nam )
    {
        long sum = 0 ;
        for ( Hoadon hd: tong_hd)
        {
            LocalDate check_time = hd.getNgay_in() ;
            if ( check_time.getMonthValue() == thang && check_time.getYear() == nam )
            {
                sum+= hd.tong_tien_hd() ;
            }
        }
        return sum ;
    }
    public void thong_ke_doanhthu ( int thang , int nam ) {
        System.out.println("Doanh thu cua thang "+ thang + " nam " + nam + " : " + tinh_thong_ke_doanhthu( thang , nam));
    }
    public long  tinh_thong_ke_doanhthu_theoquy( int quy , int nam )
    {
        long sum1 , sum2 , sum3 , sum4 ;
        sum1 = sum2 = sum3 = sum4 = 0 ;
        thiet_lap_hodon();
        for ( Hoadon hd: tong_hd )
        {
            LocalDate check_time = hd.getNgay_in();
            if ( check_time.getMonthValue() < 4 && check_time.getYear() == nam)
                sum1 += hd.tong_tien_hd() ;
            else if ( check_time.getMonthValue() >= 4 && check_time.getMonthValue() < 7 && check_time.getYear() == nam)
                sum2 += hd.tong_tien_hd() ;
            else if ( check_time.getMonthValue() >= 7 && check_time.getMonthValue() < 10 && check_time.getYear() == nam)
                sum3 += hd.tong_tien_hd() ;
            else if (check_time.getMonthValue() >= 10 && check_time.getYear() == nam)
                sum4 += hd.tong_tien_hd() ;
        }
        if ( quy == 1 ) return sum1 ;
        else if ( quy == 2 ) return sum2 ;
        else if ( quy == 3 ) return sum3 ;
        else return sum4 ;
    }
    public void thong_ke_doanhthu_theoquy ( int quy , int nam )
    {
        System.out.println("Doanh thu cua quy " + quy + " nam " + nam + " : " + tinh_thong_ke_doanhthu(nam));
    }
    public long tinh_thong_ke_doanhthu ( int nam )
    {
        long sum = 0 ;
        for ( Hoadon hd: tong_hd)
        {
            LocalDate check_time = hd.getNgay_in() ;
            if ( check_time.getYear() == nam )
            {
                sum+= hd.tong_tien_hd() ;
            }
        }
        return sum ;
    }
    public void thong_ke_doanhthu ( int nam ) {
        System.out.println("Doanh thu cua nam " + nam + " : " + tinh_thong_ke_doanhthu(nam));
    }
    public long tinh_sl_bansp ( String ma_sp , Hoadon hoadon , ArrayList<ctHoadon> ctHoadons)
    {
        ctHoadon ctHd = hoadon.tra_cuu_cthd(ctHoadons) ;
        ArrayList<String> ds_ma = ctHd.getMa_sp() ;
        for ( int i = 0 ; i < ds_ma.size(); i++ )
        {
            if ( ds_ma.get(i).equalsIgnoreCase(ma_sp))
            {
                ArrayList<Integer> so_luong = ctHd.getSoluong() ;
                return so_luong.get(i) ;
            }
        }
        return 0 ;
    }
    public void sp_banchay ( int ngay , int thang , int nam )
    {
        System.out.println("San pham ban chay nhat ngay " + ngay + " thang " + thang + " nam " + nam +" !");
        ArrayList<Long> soluong = new ArrayList<>() ;
        for ( Sanpham sp:sanphams )
        {
            long so_luong_ban_ra = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in() ;
                if ( check_time.getDayOfMonth() == ngay && check_time.getMonthValue() == thang && check_time.getYear() == nam)
                {
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                }
            }
            soluong.add(so_luong_ban_ra) ;
        }
        int index = 0 ; long max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Thucpham)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        long doanh_thu = max*sanphams.get(index).getGia_ban();
        long chi_phi = max*sanphams.get(index).getGia_nhap();
        long loi_nhuan = doanh_thu - chi_phi ;
        System.out.println("San pham thuoc loai thuc pham");
        System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Tieudung)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai tieu dung");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
        else System.out.println("Hom nay khong ban duoc hang tieu dung nao");
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Dientu)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            System.out.println();
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai dien tu");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
        else System.out.println("Hom nay khong ban duoc mon hang dien tu nao!");
    }
    public void sp_banchay ( int thang , int nam )
    {
        System.out.println("San pham ban chay nhat thang " + thang + " nam " + nam +" !");
        ArrayList<Long> soluong = new ArrayList<>() ;
        for ( Sanpham sp:sanphams )
        {
            long so_luong_ban_ra = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in();
                if ( check_time.getMonthValue() == thang && check_time.getYear() == nam)
                {
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                }
            }
            soluong.add(so_luong_ban_ra) ;
        }
        int index = 0 ; long max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Thucpham)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        long doanh_thu = max*sanphams.get(index).getGia_ban();
        long chi_phi = max*sanphams.get(index).getGia_nhap();
        long loi_nhuan = doanh_thu - chi_phi ;
        System.out.println("San pham thuoc loai thuc pham");
        System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Tieudung)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai tieu dung");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
        else System.out.println("thang nay khong ban duoc hang tieu dung nao");
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Dientu)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai dien tu");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
        else System.out.println("Thang nay khong ban duoc mon hang dien tu nao!");
    }
    public void sp_banchay_theoquy ( int quy , int nam )
    {
        System.out.println("San pham ban chay nhat quy " + quy + " nam " + nam +" !");
        ArrayList<Long> soluong = new ArrayList<>() ;
        for ( Sanpham sp:sanphams )
        {
            long so_luong_ban_ra = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in() ;
                if ( quy == 1 && check_time.getMonthValue() < 4 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                else if ( quy == 2 && check_time.getMonthValue() >= 4 && check_time.getMonthValue() < 7 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                else if ( quy == 3 && check_time.getMonthValue() >= 7 && check_time.getMonthValue() < 10 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp(), hd , tong_cthd ) ;
                else if ( quy == 4 && check_time.getMonthValue() >= 10 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
            }
            soluong.add(so_luong_ban_ra) ;
        }
        int index = 0 ; long max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Thucpham)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        long doanh_thu = max*sanphams.get(index).getGia_ban();
        long chi_phi = max*sanphams.get(index).getGia_nhap();
        long loi_nhuan = doanh_thu - chi_phi ;
        System.out.println("San pham thuoc loai thuc pham");
        System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Tieudung)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai tieu dung");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
        else System.out.println("Quy nay khong ban duoc hang tieu dung nao");
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Dientu)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai dien tu");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
        else System.out.println("Quy nay khong ban duoc mon hang dien tu nao!");
    }
    public void sp_banchay ( int nam )
    {
        System.out.println("San pham ban chay nhat nam " + nam +" !");
        ArrayList<Long> soluong = new ArrayList<>() ;
        for ( Sanpham sp:sanphams )
        {
            long so_luong_ban_ra = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in() ;
                if ( check_time.getYear() == nam)
                {
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                }
            }
            soluong.add(so_luong_ban_ra) ;
        }
        int index = 0 ; long max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Thucpham)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        long doanh_thu = max*sanphams.get(index).getGia_ban();
        long chi_phi = max*sanphams.get(index).getGia_nhap();
        long loi_nhuan = doanh_thu - chi_phi ;
        System.out.println("San pham thuoc loai thuc pham");
        System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Tieudung)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai tieu dung");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
        index = -1 ; max = 0 ;
        for ( int i = 0 ; i < soluong.size() ; i++ )
        {
            if ( soluong.get(i) > max && sanphams.get(i) instanceof Dientu)
            {
                index = i ;
                max = soluong.get(i) ;
            }
        }
        if ( index != -1 )
        {
            doanh_thu = max*sanphams.get(index).getGia_ban();
            chi_phi = max*sanphams.get(index).getGia_nhap();
            loi_nhuan = doanh_thu - chi_phi ;
            System.out.println("San pham thuoc loai dien tu");
            System.out.println("Ma san pham: " + sanphams.get(index).getMa_sp() + " | Ten san pham:" + sanphams.get(index).getTen_sp() + " | so luong: " + max + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
        }
    }
    public void Tke_hanghoa_ban_duoc ( int ngay , int thang , int nam ) {
        System.out.println("So san pham ban duoc trong ngay " + ngay + " thang " + thang + " nam " + nam + " la: ");
        thiet_lap_hodon();
        for ( Sanpham sp:sanphams )
        {
            long so_luong_ban_ra , doanh_thu , loi_nhuan , chi_phi ;
            so_luong_ban_ra = doanh_thu = loi_nhuan = chi_phi = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in() ;
                if ( check_time.getDayOfMonth() == ngay && check_time.getMonthValue() == thang && check_time.getYear() == nam)
                {
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                }
            }
            doanh_thu = so_luong_ban_ra*sp.getGia_ban() ;
            chi_phi = so_luong_ban_ra*sp.getGia_nhap() ;
            loi_nhuan = doanh_thu - chi_phi ;
            if ( so_luong_ban_ra != 0 )
            {
                System.out.println("Ma san pham: " + sp.getMa_sp() + " | Ten san pham:" + sp.getTen_sp() + " | so luong: " + so_luong_ban_ra + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
            }
        }
    }
    public void Tke_hanghoa_ban_duoc ( int thang , int nam )
    {
        System.out.println("So san pham ban duoc trong thang " + thang + " nam " + nam + " la: ");
        thiet_lap_hodon();
        for ( Sanpham sp:sanphams )
        {
            long so_luong_ban_ra , doanh_thu , loi_nhuan , chi_phi ;
            so_luong_ban_ra = doanh_thu = loi_nhuan = chi_phi = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in() ;
                if ( check_time.getMonthValue() == thang && check_time.getYear() == nam)
                {
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                }
            }
            doanh_thu = so_luong_ban_ra*sp.getGia_ban() ;
            chi_phi = so_luong_ban_ra*sp.getGia_nhap() ;
            loi_nhuan = doanh_thu - chi_phi ;
            if ( so_luong_ban_ra != 0 )
            {
                System.out.println("Ma san pham: " + sp.getMa_sp() + " | Ten san pham:" + sp.getTen_sp() + " | so luong: " + so_luong_ban_ra + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
            }
        }
    }
    public void Tke_hanghoa_ban_duoc_theoquy ( int quy , int nam )
    {
        System.out.println("So san pham ban duoc trong quy " + quy + " nam " + nam + " la: ");
        thiet_lap_hodon();
        for ( Sanpham sp: sanphams )
        {
            long so_luong_ban_ra , doanh_thu , loi_nhuan , chi_phi ;
            so_luong_ban_ra = doanh_thu = loi_nhuan = chi_phi = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in();
                if ( quy == 1 && check_time.getMonthValue() < 4 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp( sp.getMa_sp(), hd , tong_cthd ) ;
                else if ( quy == 2 && check_time.getMonthValue() >= 4 && check_time.getMonthValue() < 7 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp( sp.getMa_sp() , hd , tong_cthd ) ;
                else if ( quy == 3 && check_time.getMonthValue() >= 7 && check_time.getMonthValue() < 10 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp( sp.getMa_sp() , hd , tong_cthd ) ;
                else if ( quy == 4 && check_time.getMonthValue() >= 10 && check_time.getYear() == nam)
                    so_luong_ban_ra += tinh_sl_bansp( sp.getMa_sp() , hd , tong_cthd ) ;
            }
            doanh_thu = so_luong_ban_ra*sp.getGia_ban() ;
            chi_phi = so_luong_ban_ra*sp.getGia_nhap() ;
            loi_nhuan = doanh_thu - chi_phi ;
            if ( so_luong_ban_ra != 0 )
            {
                System.out.println("Ma san pham: " + sp.getMa_sp() + " | Ten san pham:" + sp.getTen_sp() + " | so luong: " + so_luong_ban_ra + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
            }
        }
    }
    public void Tke_hanghoa_ban_duoc ( int nam )
    {
        System.out.println("So san pham ban duoc trong nam " + nam + " la: ");
        thiet_lap_hodon();
        for ( Sanpham sp:sanphams )
        {
            long so_luong_ban_ra , doanh_thu , loi_nhuan , chi_phi ;
            so_luong_ban_ra = doanh_thu = loi_nhuan = chi_phi = 0 ;
            for ( Hoadon hd:tong_hd )
            {
                LocalDate check_time = hd.getNgay_in() ;
                if ( check_time.getYear() == nam)
                {
                    so_luong_ban_ra += tinh_sl_bansp(sp.getMa_sp() , hd , tong_cthd ) ;
                }
            }
            doanh_thu = so_luong_ban_ra*sp.getGia_ban() ;
            chi_phi = so_luong_ban_ra*sp.getGia_nhap() ;
            loi_nhuan = doanh_thu - chi_phi ;
            if ( so_luong_ban_ra != 0 )
            {
                System.out.println("Ma san pham: " + sp.getMa_sp() + " | Ten san pham:" + sp.getTen_sp() + " | so luong: " + so_luong_ban_ra + " | Doanh thu: " + doanh_thu + " | Loi nhuan: " + loi_nhuan);
            }
        }
    }
    public long tinh_loinhuan ( int ngay , int thang , int nam )
    {
        thiet_lap_hodon();
        int chi_phi = 0 ;
        for ( Hoadon hd: tong_hd)
        {
            LocalDate check_time = hd.getNgay_in();
            if ( check_time.getDayOfMonth() == ngay && check_time.getMonthValue() == thang && check_time.getYear() == nam )
            {
                ctHoadon cthd = hd.tra_cuu_cthd(tong_cthd) ;
                ArrayList<String> ma_sp = cthd.getMa_sp() ;
                ArrayList<Integer> soluong = cthd.getSoluong() ;
                for ( int i = 0 ; i < ma_sp.size() ; i++ )
                {
                    Sanpham sp = cthd.tra_cuu_san_pham(ma_sp.get(i)) ;
                    chi_phi += sp.getGia_nhap()*soluong.get(i) ;
                }
            }
        }
        return tinh_thong_ke_doanhthu(ngay , thang , nam) - chi_phi ;
    }
    public void thong_ke_loinhuan ( int ngay , int thang , int nam )
    {
        System.out.println("Loi nhuan thu duoc ngay " + ngay + " thang " + thang + " nam " + nam + " la: " + tinh_loinhuan(ngay , thang , nam));
    }
    public long tinh_loinhuan ( int thang , int nam )
    {
        thiet_lap_hodon();
        int chi_phi = 0 ;
        for ( Hoadon hd: tong_hd)
        {
            LocalDate check_time = hd.getNgay_in();
            if ( check_time.getMonthValue() == thang && check_time.getYear() == nam )
            {
                ctHoadon cthd = hd.tra_cuu_cthd(tong_cthd) ;
                ArrayList<String> ma_sp = cthd.getMa_sp() ;
                ArrayList<Integer> soluong = cthd.getSoluong() ;
                for ( int i = 0 ; i < ma_sp.size() ; i++ )
                {
                    Sanpham sp = cthd.tra_cuu_san_pham(ma_sp.get(i)) ;
                    chi_phi += sp.getGia_nhap()*soluong.get(i) ;
                }
            }
        }
        return tinh_thong_ke_doanhthu(thang , nam) - chi_phi ;
    }
    public void thong_ke_loinhuan ( int thang , int nam )
    {
        System.out.println("Loi nhuan thu duoc thang " + thang + " nam " + nam + " la: " + tinh_loinhuan(thang , nam));
    }
    public long tinh_loinhuan_theoquy ( int quy , int nam )
    {
        thiet_lap_hodon();
        int chi_phi = 0 ;
        for ( Hoadon hd: tong_hd)
        {
            LocalDate check_time = hd.getNgay_in() ;
            if ( quy == 1 && check_time.getMonthValue() < 4 && check_time.getYear() == nam )
            {
                ctHoadon cthd = hd.tra_cuu_cthd(tong_cthd) ;
                ArrayList<String> ma_sp = cthd.getMa_sp() ;
                ArrayList<Integer> soluong = cthd.getSoluong() ;
                for ( int i = 0 ; i < ma_sp.size() ; i++ )
                {
                    Sanpham sp = cthd.tra_cuu_san_pham(ma_sp.get(i)) ;
                    chi_phi += sp.getGia_nhap()*soluong.get(i) ;
                }
            }
            if ( quy == 2 && check_time.getMonthValue() >= 4  && check_time.getMonthValue() < 7 && check_time.getYear() == nam )
            {
                ctHoadon cthd = hd.tra_cuu_cthd(tong_cthd) ;
                ArrayList<String> ma_sp = cthd.getMa_sp() ;
                ArrayList<Integer> soluong = cthd.getSoluong() ;
                for ( int i = 0 ; i < ma_sp.size() ; i++ )
                {
                    Sanpham sp = cthd.tra_cuu_san_pham(ma_sp.get(i)) ;
                    chi_phi += sp.getGia_nhap()*soluong.get(i) ;
                }
            }
            if ( quy == 3 && check_time.getMonthValue() >= 7  && check_time.getMonthValue() < 10 && check_time.getYear() == nam )
            {
                ctHoadon cthd = hd.tra_cuu_cthd(tong_cthd) ;
                ArrayList<String> ma_sp = cthd.getMa_sp() ;
                ArrayList<Integer> soluong = cthd.getSoluong() ;
                for ( int i = 0 ; i < ma_sp.size() ; i++ )
                {
                    Sanpham sp = cthd.tra_cuu_san_pham(ma_sp.get(i)) ;
                    chi_phi += sp.getGia_nhap()*soluong.get(i) ;
                }
            }
            if ( quy == 4 && check_time.getMonthValue() >= 10 && check_time.getYear() == nam )
            {
                ctHoadon cthd = hd.tra_cuu_cthd(tong_cthd) ;
                ArrayList<String> ma_sp = cthd.getMa_sp() ;
                ArrayList<Integer> soluong = cthd.getSoluong() ;
                for ( int i = 0 ; i < ma_sp.size() ; i++ )
                {
                    Sanpham sp = cthd.tra_cuu_san_pham(ma_sp.get(i)) ;
                    chi_phi += sp.getGia_nhap()*soluong.get(i) ;
                }
            }
        }
        return tinh_thong_ke_doanhthu_theoquy( quy , nam) - chi_phi ;
    }
    public void thong_ke_loinhuan_theoquy ( int quy , int nam )
    {
        System.out.println("Loi nhuan thu duoc quy " + quy + " nam " + nam + " la: " + tinh_loinhuan_theoquy( quy , nam));
    }
    public long tinh_loinhuan ( int nam )
    {
        thiet_lap_hodon();
        int chi_phi = 0 ;
        for ( Hoadon hd: tong_hd)
        {
            LocalDate check_time = hd.getNgay_in() ;
            if ( check_time.getYear() == nam )
            {
                ctHoadon cthd = hd.tra_cuu_cthd(tong_cthd) ;
                ArrayList<String> ma_sp = cthd.getMa_sp() ;
                ArrayList<Integer> soluong = cthd.getSoluong() ;
                for ( int i = 0 ; i < ma_sp.size() ; i++ )
                {
                    Sanpham sp = cthd.tra_cuu_san_pham(ma_sp.get(i)) ;
                    chi_phi += sp.getGia_nhap()*soluong.get(i) ;
                }
            }
        }
        return tinh_thong_ke_doanhthu(nam) - chi_phi ;
    }
    public void thong_ke_loinhuan ( int nam )
    {
        System.out.println("Loi nhuan thu duoc nam " + nam + " la: " + tinh_loinhuan(nam));
    }
    public String toString()
    {
        return super.toString() + " | Luong: " + tien_luong()  + " | Chuc vu: " + getChuc_vu();
    }
}