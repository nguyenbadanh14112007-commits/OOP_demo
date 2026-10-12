import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Nhacungcap implements Admin_Sp
{
    private String Ma_ncc , Ten_ncc , Dia_chi , So_dt , email;
    private transient ArrayList<Sanpham> sanphams ;
    private final static Scanner scanner = new Scanner(System.in) ;
    public Nhacungcap()
    {
        sanphams = new ArrayList<>() ;
        Ma_ncc = Ten_ncc = Dia_chi = So_dt = "" ;
    }

    public void setSo_dt(String so_dt) {
        So_dt = so_dt;
    }

    public ArrayList<Sanpham> getSanphams() {
        return sanphams;
    }

    public void setSanphams(ArrayList<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public void setMa_ncc(String ma_ncc) {
        Ma_ncc = ma_ncc;
    }

    public void setDia_chi(String dia_chi) {
        Dia_chi = dia_chi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTen_ncc(String ten_ncc) {
        Ten_ncc = ten_ncc;
    }

    public String getSo_dt() {
        return So_dt;
    }

    public String getDia_chi() {
        return Dia_chi;
    }

    public String getEmail() {
        return email;
    }

    public String getMa_ncc() {
        return Ma_ncc;
    }

    public String getTen_ncc() {
        return Ten_ncc;
    }

    public void set_ncc()
    {
        System.out.println("Nhap ma nha cung cap: ");
        Ma_ncc = scanner.nextLine() ;
        System.out.println("Nhap ten nha cung cap: ");
        Ten_ncc = scanner.nextLine() ;
        System.out.println("Nhap dia chi: ");
        Dia_chi = scanner.nextLine() ;
        System.out.println("Nhap so dien thoai: ");
        So_dt = scanner.nextLine() ;
        System.out.println("Nhap email: ");
        email = scanner.nextLine() ;
    }
    public String toString()
    {
        return "Ma nha cung cap: " + Ma_ncc + " | Ten nha cung cap: " + Ten_ncc + " | Dia chi: " + Dia_chi + " | So dien thoai: " + So_dt + " | Email: " + email ;
    }
    public int ktra_sp_tontai ( String ma_sp )
    {
        for ( int i = 0 ; i < sanphams.size() ; i++ )
        {
            if ( sanphams.get(i).getMa_sp().equalsIgnoreCase(ma_sp) )
                return i ;
        }
        return -1 ;
    }
    public void nhandon ( Sanpham sanpham , int so_luong , LocalDate date )
    {
        int index = ktra_sp_tontai(sanpham.getMa_sp()) ;
        if ( index != -1 )
        {
            ArrayList<LocalDate> ngay_nhap = sanphams.get(index).getNgay_nhap() ;
            ArrayList<Integer> soluongnhap = sanphams.get(index).getSo_luong_nhap() ;
            ArrayList<String> ma_ncc = sanpham.getMa_ncc() ;
            ngay_nhap.add(date) ;
            soluongnhap.add(so_luong) ;
            ma_ncc.add(Ma_ncc) ;
            sanphams.get(index).setMa_ncc(ma_ncc);
            sanphams.get(index).setSo_luong_nhap(soluongnhap);
            sanphams.get(index).setNgay_nhap(ngay_nhap);
        }
        else
        {
            ArrayList<LocalDate> ngay_nhap = sanpham.getNgay_nhap() ;
            ArrayList<Integer> soluongnhap = sanpham.getSo_luong_nhap() ;
            ArrayList<String> ma_ncc = sanpham.getMa_ncc() ;
            ngay_nhap.add(LocalDate.now()) ;
            soluongnhap.add(so_luong) ;
            ma_ncc.add(Ma_ncc) ;
            sanpham.setMa_ncc(ma_ncc);
            sanpham.setSo_luong_nhap(soluongnhap);
            sanpham.setNgay_nhap(ngay_nhap);
            sanphams.add(sanpham) ;
        }
        System.out.println("Da them vao danh sach nhap hang!");
    }
    public void them_sp()
    {
        System.out.println("Nha cung cap khong co quyen han nay!");
    }
    public void xoa_sp( String ma_sp)
    {
        int index_remove = ktra_sp_tontai(ma_sp) ;
        if ( index_remove == -1 )
        {
            System.out.println("Ma san pham khong ton tai!");
            return;
        }
        sanphams.remove(sanphams.get(index_remove)) ;
        System.out.println("San pham da bi xoa khoi danh sach nhap hang!");
    }

    @Override
    public void sua_tt_sp(String ma_sp) {
        System.out.println("Nha cung cap khong co quyen han nay!");
    }

    public void sua_tt_sp(String ma_sp , LocalDate ngay_dat_hang)
    {
        int index = ktra_sp_tontai(ma_sp) ;
        if ( index == -1 )
        {
            System.out.println("Ma san pham khong ton tai!");
            return;
        }
        if (!sanphams.get(index).getNgay_nhap().contains(ngay_dat_hang))
        {
            System.out.println("Khong ton tai ngay dat hang!");
            return ;
        }
        System.out.println("Nhap so luong san pham can nhap moi: ");
        int soluong = scanner.nextInt() ;
        int index_ngay_nhap = sanphams.get(index).getNgay_nhap().indexOf(ngay_dat_hang) ;
        ArrayList<Integer> soluongnhap = sanphams.get(index).getSo_luong_nhap() ;
        soluongnhap.set( index_ngay_nhap , soluong ) ;
        sanphams.get(index).setSo_luong_nhap(soluongnhap);
        System.out.println("Thay doi so luong nhap hang thanh cong!");
    }
    public void hien_thi_sp()
    {
        ArrayList<LocalDate> ds_ngay  = new ArrayList<>() ;
        for ( Sanpham sp: sanphams)
        {
            for ( LocalDate ngay:sp.getNgay_nhap() )
            {
                if ( !ds_ngay.contains(ngay))
                {
                    ds_ngay.add(ngay) ;
                }
            }
        }
        ds_ngay.sort(Comparator.naturalOrder());
        System.out.println("Danh sach cac hang hoa da duoc nhap hang tu nha cung cap" + Ten_ncc + "la:  ");
        for ( LocalDate ngay: ds_ngay )
        {
            for ( Sanpham sp: sanphams)
            {
                for ( int i = 0 ; i < sp.getNgay_nhap().size() ; i++  )
                {
                    if ( sp.getNgay_nhap().get(i).equals(ngay))
                    {
                        System.out.println("Ma san pham: " + sp.getMa_sp() + " | Ten san pham: " + sp.getTen_sp() + " | Gia nhap: " + sp.getGia_nhap() * sp.getSo_luong_nhap().get(i) + " | So luong: " + sp.getSo_luong_nhap().get(i) + " | Ngay nhap: " + sp.getNgay_nhap().get(i));
                    }
                }
            }
        }
    }
    public void tracuu_sp( String ma_sp ) {
        int index = ktra_sp_tontai(ma_sp);
        if (index == -1) {
            System.out.println("San pham khong ton tai!");
            return;
        }
        Sanpham sanpham = sanphams.get(index);
        for (int j = 0; j < sanpham.getNgay_nhap().size(); j++) {
            System.out.println("Ma san pham: " + sanpham.getMa_sp()+ " | Ten san pham: " + sanpham.getTen_sp() + " | Gia nhap: " + sanpham.getGia_nhap() * sanpham.getSo_luong_nhap().get(j) + " | So luong: " + sanpham.getSo_luong_nhap().get(j) + " | Ngay nhap: " + sanpham.getNgay_nhap().get(j) + " | Nha cung cap: " + Ten_ncc ) ;
        }
    }
    public long tinh_chi_phi_nhap_hang ( int ngay , int thang , int nam )
    {
        long sum = 0 ;
        for ( Sanpham sp:sanphams )
        {
            for ( int j = 0 ; j < sp.getNgay_nhap().size() ; j++ )
            {
                LocalDate ngay_nhap = sp.getNgay_nhap().get(j) ;
                if ( ngay_nhap.getDayOfMonth() == ngay && ngay_nhap.getMonthValue() == thang && ngay_nhap.getYear() == nam )
                {
                    sum += (long)sp.getGia_nhap()*sp.getSo_luong_nhap().get(j) ;
                }
            }
        }
        return sum ;
    }
    public void in_chi_phi_nhap_hang ( int ngay , int thang , int nam )
    {
        System.out.println("Chi phi nhap hang cua nha cung cap " + Ten_ncc + " ngay " + ngay + " thang " + thang + " nam " + " la: " + tinh_chi_phi_nhap_hang( ngay , thang , nam));
    }
    public long tinh_chi_phi_nhap_hang ( int thang , int nam )
    {
        long sum = 0 ;
        for ( Sanpham sp:sanphams )
        {
            for ( int j = 0 ; j < sp.getNgay_nhap().size() ; j++ )
            {
                LocalDate ngay_nhap = sp.getNgay_nhap().get(j) ;
                if ( ngay_nhap.getMonthValue() == thang && ngay_nhap.getYear() == nam )
                {
                    sum += (long)sp.getGia_nhap()*sp.getSo_luong_nhap().get(j) ;
                }
            }
        }
        return sum ;
    }
    public long tinh_chi_phi_nhap_hang_theoquy ( int quy , int nam )
    {
        long sum = 0 ;
        for ( Sanpham sp:sanphams )
        {
            for ( int j = 0 ; j < sp.getNgay_nhap().size() ; j++ )
            {
                LocalDate ngay_nhap = sp.getNgay_nhap().get(j) ;
                if ( quy == 1 && ngay_nhap.getMonthValue() < 4 && ngay_nhap.getYear() == nam )
                    sum += (long)sp.getGia_nhap()*sp.getSo_luong_nhap().get(j) ;
                if ( quy == 2 && ngay_nhap.getMonthValue() >= 4 && ngay_nhap.getMonthValue() < 7 && ngay_nhap.getYear() == nam )
                    sum += (long)sp.getGia_nhap()*sp.getSo_luong_nhap().get(j) ;
                if ( quy == 3 && ngay_nhap.getMonthValue() >= 7 && ngay_nhap.getMonthValue() < 10 && ngay_nhap.getYear() == nam )
                    sum += (long)sp.getGia_nhap()*sp.getSo_luong_nhap().get(j) ;
                if ( quy == 4 && ngay_nhap.getMonthValue() >= 10 && ngay_nhap.getYear() == nam )
                    sum += (long)sp.getGia_nhap()*sp.getSo_luong_nhap().get(j) ;
            }
        }
        return sum ;
    }
    public void in_chi_phi_nhap_hang_theoquy ( int quy , int nam)
    {
        System.out.println("Chi phi nhap hang cua " + Ten_ncc + " quy " + quy  + " nam " + nam + " la: " + tinh_chi_phi_nhap_hang_theoquy( quy , nam) );
    }
    public void in_chi_phi_nhap_hang ( int thang , int nam )
    {
        System.out.println("Chi phi nhap hang cua " + Ten_ncc + " thang " + thang + " nam " + nam + " la: " + tinh_chi_phi_nhap_hang( thang , nam) );
    }
    public long tinh_chi_phi_nhap_hang ( int nam )
    {
        long sum = 0 ;
        for ( Sanpham sp:sanphams )
        {
            for ( int j = 0 ; j < sp.getNgay_nhap().size() ; j++ )
            {
                LocalDate ngay_nhap = sp.getNgay_nhap().get(j) ;
                if ( ngay_nhap.getYear() == nam )
                {
                    sum += (long)sp.getGia_nhap()*sp.getSo_luong_nhap().get(j) ;
                }
            }
        }
        return sum ;
    }
    public void in_chi_phi_nhap_hang ( int nam )
    {
        System.out.println("Chi phi nhap hang cua " + Ten_ncc + " nam " + nam + " la: " + tinh_chi_phi_nhap_hang(nam) );
    }
}