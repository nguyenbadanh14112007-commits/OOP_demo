import java.util.Scanner ;
public class chuoi {
    public static void main( String[] args){
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap chuoi: ");
        String s = scanner.nextLine() ;
        System.out.println("Do dai: " + s.length());
        System.out.println("Xoa khoang trang: " + s.trim());
        String[] arr = s.split(" ") ;
        System.out.println("So tu: " + arr.length ) ;
        System.out.println("Tung ky tu: " ) ;
        for (String string : arr) {
            System.out.println(string);
        }
        System.out.println("k: ");
        int k = scanner.nextInt() ;
        if ( k > s.length() ) System.out.println(s);
        else
        {
            System.out.println("Ben trai sang: ");
            for ( int i = 0 ; i < k ; i++ )
                System.out.println(s.charAt(i));
            System.out.println("Ben phai sang");
            for ( int i = s.length() - k ; i < s.length() ; i++)
                System.out.println(s.charAt(i));
        }
        System.out.println("m: ");
        int m = scanner.nextInt() ;
        System.out.println("n: ");
        int n = scanner.nextInt() ;
        System.out.println("tu vi tri m in n ky tu la: ");
        if ( m + n - 1 < s.length() )
        {
            for ( int i = m ; i < m + n ; i++ )
                System.out.println(s.charAt(i));
        }
        else {
            for ( int i = m ; i < s.length() ; i++ )
                System.out.println(s.charAt(i));
        }
    }
}
