public class Danhsachsv
{
    Sinhvien[] arr ;
    int siso ;
    public Danhsachsv( int so_luong_toi_da)
    {
        arr = new Sinhvien[so_luong_toi_da] ;
        siso = 0 ;
    }
    public void them_sv()
    {
        if ( siso < arr.length ) {
            Sinhvien a = new Sinhvien();
            a.get_sv();
            arr[siso] = a;
            siso++;
            System.out.println("Da them sinh vien thanh cong!");
        }
        else System.out.println("So luong sinh vien da toi da!");
    }
    public void print_ds_sv()
    {
        for ( int i = 0 ; i < siso ; i++ )
        {
            arr[i].get_sv();
        }
    }
    public void xoa_sv ( String massv )
    {
        if ( arr.length > 0 )
        {
            int vitri = -1 ;
            for ( int i = 0 ; i < siso ; i++ )
            {
                if ( arr[i].mssv.equals(massv)){
                    vitri = i ;
                    break ;
                }
            }
            if ( vitri == -1 ) System.out.println("Mssv khong hop le");
            else{
                Sinhvien a = new Sinhvien() ;
                for ( int i = vitri ; i < siso ; i++ )
                {
                    a = arr[i] ;
                    arr[i] = arr[i+1] ;
                    arr[i+1] = a ;
                }
                arr[siso-1] = null ;
                siso-- ;
                System.out.println("Xoá sinh viên thành công!");
            }
        }
        else System.out.println("Danh sach sinh vien dang trong!");
    }
    public void timkiem_sv ( String massv )
    {
        int x = 0 ;
        for ( int i = 0 ; i < siso ; i++ )
        {
            if ( arr[i].mssv.equals(massv)){
                x = i ;
                break ;
            }
        }
        arr[x].get_sv();
    }
}
