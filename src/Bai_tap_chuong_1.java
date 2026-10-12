import java.util.Arrays;
import java.util.Scanner;
class Mang
{
    int n ;
    int[] arr ;
    Scanner sc = new Scanner(System.in);
    public Mang( int n )
    {
        this.n = n ;
        arr = new int[n] ;
    }
    public void set_value()
    {
        System.out.println("Nhập n phần tử trong mảng: ");
        for ( int i = 0 ; i < n ; i++ ) arr[i] = sc.nextInt() ;
        System.out.println("Nhap giá trị mảng thành công!");
    }
    public boolean is_nt( int n )
    {
        if ( n < 2 ) return false ;
        if ( n == 2 ) return true ;
        for ( int i = 2 ; i <= n/2 ; i++ )
            if ( n%i == 0 )
                return false ;
        return true ;
    }
    public void get_value()
    {
        long sum = 0 ;
        System.out.println("Cac phan tu trong mang: ");
        for ( int i = 0 ; i < n ; i++ )
        {
            sum += arr[i] ;
            System.out.println(arr[i]);
        }
        System.out.println("Tong phan tu trong mang: " + sum );
    }
    public void get_value_chan()
    {
        long sum = 0 ;
        System.out.println("Cac phan tu chan trong mang: ");
        for ( int i = 0 ; i < n ; i++ )
        {
            if ( arr[i]%2 == 0 )
            {
                sum += arr[i] ;
                System.out.println(arr[i]);
            }
        }
        System.out.println("Tong phan tu chan trong mang: " + sum );
    }
    public void get_value_le()
    {
        long sum = 0 ;
        System.out.println("Cac phan tu le trong mang: ");
        for ( int i = 0 ; i < n ; i++ )
        {
            if ( arr[i]%2 == 1 )
            {
                sum += arr[i] ;
                System.out.println(arr[i]);
            }
        }
        System.out.println("Tong phan tu le trong mang: " + sum );
    }
    public void get_value_so_nt()
    {
        long sum = 0 ;
        System.out.println("Cac phan tu la so nguyen to trong mang: ");
        for ( int i = 0 ; i < n ; i++ )
        {
            if ( is_nt(arr[i]) )
            {
                sum += arr[i] ;
                System.out.println(arr[i]);
            }
        }
        System.out.println("Tong phan tu la so nguyen to trong mang: " + sum );
    }
    public int timkiem ( int x )
    {
        for ( int i = 0 ; i < n ; i++ )
        {
            if ( arr[i] == x ) return i ;
        }
        return -1 ;
    }
    public void thempt ( int x )
    {
        int new_size = arr.length + 1 ;
        int[] arr1 = new int[new_size] ;
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        arr1[arr.length] = x ;
        this.arr = arr1 ;
        System.out.println("Thêm phần tử thành công!");
    }
    public void xoapt ( int index )
    {
        if ( index <= 0) return ;
        int new_size = arr.length - 1 ;
        int[] arr1 = new int[new_size] ;
        for ( int i = index ; i < arr.length - 1; i++ )
        {
            int vitual = arr[i] ;
            arr[i] = arr[i+1] ;
            arr[i+1] = vitual ;
        }
        System.arraycopy(arr, 0, arr1, 0, new_size);
        this.arr = arr1 ;
        System.out.println("Xoá phần tử thành công!");
    }
}
class Songuyen
{
    int a , b ;
    Scanner sc = new Scanner(System.in) ;
    public void set_value()
    {
        System.out.println("Nhap hai so nguyen a, b: ");
        a = sc.nextInt() ;
        b = sc.nextInt() ;
    }
    public void get_value()
    {
        System.out.println("Tong: " + ( a + b));
        System.out.println("Hieu: " + (a - b));
        System.out.println("Tich: " + ( a*b ));
        System.out.println("Thuong: " + ((double)a/(double) b));
    }
}
class Hinhvuong
{
    int height , weight ;
    Scanner sc = new Scanner(System.in) ;
    public void set_value()
    {
        System.out.println("Nhap chieu dai va chieu rong: ");
        height = sc.nextInt() ;
        weight = sc.nextInt() ;
    }
    public void get_value()
    {
        System.out.println("Chu vi" + ( (height + weight)*2));
        System.out.println("Dien tich: " + (height*weight));
    }
}
class Cycle
{
    int r ;
    float PI = 3.14F;
    Scanner sc = new Scanner(System.in) ;
    public void set_value()
    {
        System.out.println("Nhap ban kinh hinh tron: ");
        r = sc.nextInt() ;
    }
    public void get_value()
    {
        System.out.println("Chu vi hinh tron: " + 2*PI*r );
        System.out.println("Dien tich hinh tron: " + PI*r*r);
    }
}
class Chanle
{
    int a ;
    Scanner sc = new Scanner(System.in) ;
    public void set_value()
    {
        System.out.println("Nhap so nguyen N ngau nhien: ");
        a = sc.nextInt() ;
    }
    public void ktra()
    {
        if ( a%2 == 0 ) System.out.println( a + " la so chan");
        else System.out.println( a + " la so le");
    }
}
class Amduong
{
    int a ;
    Scanner sc = new Scanner(System.in) ;
    public void set_value()
    {
        System.out.println("Nhap so nguyen N ngau nhien: ");
        a = sc.nextInt() ;
    }
    public void ktra()
    {
        if ( a > 0 ) System.out.println( a + " la so duong");
        else if ( a < 0 ) System.out.println(a + " la so am");
        else System.out.println( a + " la so 0");
    }
}
class So_nt
{
    int a ;
    Scanner sc = new Scanner(System.in) ;
    public void set_value()
    {
        System.out.println("Nhap so nguyen N ngau nhien: ");
        a = sc.nextInt() ;
    }
    public void ktra()
    {
        if (is_nt(a)) System.out.println( a + " La so nguyen to!");
        else System.out.println( a + " khong phai la so nguyen to!");
    }
    public boolean is_nt( int n )
    {
        if ( n < 2 ) return false ;
        if ( n == 2 ) return true ;
        for ( int i = 2 ; i <= n/2 ; i++ )
            if ( n%i == 0 )
                return false ;
        return true ;
    }
}
class Ktra {
    int n;
    Scanner sc = new Scanner(System.in) ;
    public void set_value() {
        System.out.println("Nhap so tu nhien N: ");
        n =sc.nextInt();
    }
    public void sum_value() {
        int sum = 0;
        for( int i = 0;  i <= n; i++)
        {
            sum += i;
        }
        System.out.println("Tong cac phan tu <= N la: "+sum);
    }
    public void sum_chan() {
        long sum =0;
        for( int i = 0; i < n ; i++)
        {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("Tong cac phan tu la so chan <= N la : "+sum);
    }
    public void sum_le() {
        long sum =0;
        for( int i = 0; i <= n ; i++)
        {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        System.out.println("Tong cac phan tu la so le <= N la : "+sum);
    }
    public boolean is_nt( int n )
    {
        if ( n < 2 ) return false ;
        if ( n == 2 ) return true ;
        for ( int i = 2 ; i <= n/2 ; i++ )
            if ( n%i == 0 )
                return false ;
        return true ;
    }
    public void sum_nt() {
        long sum =0;
        for( int i = 0;  i <= n ; i++)
        {
            if (is_nt(i)) {
                sum += i;
            }
        }
        System.out.println("Tong cac phan tu la so nguyen to <= N la : "+sum);
    }
    public void Nt_dautien() {
        System.out.println("N so nguyen to dau tien la: ");
        for( int i = 0; i <= n; i++)
        {
            if (is_nt(i)) {
                System.out.println(i + " ");
            }
        }
    }
}
class Chuoi
{
    String s ;
    Scanner sc = new Scanner(System.in) ;
    public void set_value() {
        System.out.println("Nhap chuoi s: ");
        s = sc.nextLine() ;
    }
    public void length_chuoi()
    {
        System.out.println("Do dai cua chuoi s: " + s.length());
    }
    public void xoa_khoang_trang() {
        System.out.println("Chuoi s sau khi xoa bo khoang trang: " + s.trim());
    }
    public void tung_pt() {
        s = s.trim() ;
        String[] arr = s.split(" ") ;
        System.out.println("So tu cua chuoi s: " + arr.length);
        System.out.println("Tung tu cua chuoi s: ");
        for (String string : arr) System.out.println(string);
    }
    public void k_ky_tu() {
        System.out.println("Nhap k ky tu de xuat tu ben trai va phai: ");
        int k = sc.nextInt() ;
        System.out.println("K ky tu ben trai chuoi: ");
        for ( int i = 0 ; i < k ; i++ ) System.out.println(s.charAt(i));
        System.out.println("K ky tu ben phai chuoi: ");
        for ( int i = s.length() - k ; i < s.length() ; i++ ) System.out.println(s.charAt(i));
    }
    public void k_n_kytu() {
        System.out.println("Nhap k, n ky tu de xuat tu vi tri k trong cuoi s n ky tu: ");
        int k = sc.nextInt() ;
        int n = sc.nextInt() ;
        System.out.println(" xuat tu vi tri k trong cuoi s n ky tu: ");
        if ( k + n >= s.length() )
        {
            for ( int i = k ; i < s.length() ; i++ ) System.out.println(s.charAt(i));
        }
        else {
            for ( int i = k ; i < k + n  ; i++ ) System.out.println(s.charAt(i));
        }
    }
}
public class Bai_tap_chuong_1{
    public static void main( String[] args)
    {
        Scanner scanner = new Scanner(System.in) ;
        boolean countinue = true ;
        while (countinue)
        {
            System.out.println("Chon bai lam: ");
            System.out.println("1. Bai 1");
            System.out.println("2. Bai 2");
            System.out.println("3. Bai 3");
            System.out.println("4. Bai 4");
            System.out.println("5. Bai 5");
            System.out.println("6. Bai 6");
            System.out.println("7. Bai 7");
            System.out.println("8. Bai 8");
            System.out.println("9. Bai 9");
            System.out.println("Nhap lua chon: ");
            int luachon = scanner.nextInt() ;
            switch (luachon)
            {
                case 1:
                    Songuyen value = new Songuyen();
                    value.set_value();
                    value.get_value();
                    break;
                case 2:
                    Hinhvuong vuong = new Hinhvuong() ;
                    vuong.set_value();
                    vuong.get_value();
                    break;
                case 3:
                    Cycle tron = new Cycle() ;
                    tron.set_value();
                    tron.get_value();
                    break;
                case 4:
                    Chanle ce = new Chanle();
                    ce.set_value();
                    ce.ktra();
                    break;
                case 5:
                    Amduong ad = new Amduong() ;
                    ad.set_value();
                    ad.ktra();
                    break;
                case 6:
                    So_nt nt = new So_nt() ;
                    nt.set_value();
                    nt.ktra();
                    break;
                case 7:
                    Ktra kt = new Ktra();
                    kt.set_value();
                    kt.sum_chan();
                    kt.sum_le();
                    kt.Nt_dautien();
                    break;
                case 8:
                    System.out.println("Nhap kich thuoc cho mang: ");
                    int n = scanner.nextInt();
                    Mang gia_tri = new Mang(n) ;
                    gia_tri.set_value();
                    gia_tri.get_value();
                    gia_tri.get_value_chan();
                    gia_tri.get_value_le();
                    gia_tri.get_value_so_nt();
                    System.out.println("Nhap phan tu can them: ");
                    int x = scanner.nextInt() ;
                    gia_tri.thempt(x);
                    System.out.println("Nhap vi tri phan tu can xoa: ");
                    x = scanner.nextInt();
                    gia_tri.xoapt(x);
                    System.out.println("Nhap gia tri cua phan tu can tim kiem: ");
                    x = scanner.nextInt();
                    if ( gia_tri.timkiem(x) == -1 ) System.out.println("Khong tim thay phan tu trong mang!");
                    else System.out.println("Vi tri phan tu can tim la: " + gia_tri.timkiem(x));
                case 9:
                    Chuoi chuoi = new Chuoi();
                    chuoi.set_value();
                    chuoi.length_chuoi();
                    chuoi.tung_pt();
                    chuoi.xoa_khoang_trang();
                    chuoi.k_ky_tu();
                    chuoi.k_n_kytu();
                    break;
                default: System.out.println("Gia tri nhap khong hop le!");
            }
            System.out.println("Ban co muon tiep tuc(1/0): ");
            int luachon_1 = scanner.nextInt() ;
            if ( luachon_1 == 0 ) countinue = false ;
        }
    }
}