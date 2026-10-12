import java.util.ArrayList;
import java.util.Scanner ;
public class Main {
    public static  boolean is_nt ( int n )
    {
        if ( n < 2 ) return false ;
        if ( n == 2 ) return true ;
        for ( int i = 2 ; i <= Math.sqrt(n) ; i++ )
            if ( n%i == 0 ) return false ;
        return true ;
    }
    public static int timkiem ( int[] arr , int n , int x )
    {
        for ( int i = 0 ; i < n ; i++ )
        {
            if ( arr[i] == x ) return i ;
        }
        return -1 ;
    }
    public static int[] thempt ( int[] arr , int x )
    {
        int new_size = arr.length + 1 ;
        int[] arr1 = new int[new_size] ;
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        arr1[arr.length] = x ;
        return arr1 ;
    }
    public static int[] xoapt ( int[] arr , int index )
    {
        if ( index <= 0) return arr;
        int new_size = arr.length - 1 ;
        int[] arr1 = new int[new_size] ;
        for ( int i = index ; i < arr.length - 1; i++ )
        {
            int vitual = arr[i] ;
            arr[i] = arr[i+1] ;
            arr[i+1] = vitual ;
        }
        for ( int i = 0 ; i < new_size ; i++ ) {
            arr1[i] = arr[i];
        }
        return arr1;
    }
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in) ;
      int n = 0 ;
      System.out.println("n: ") ;
      n = scanner.nextInt() ;
      int sum = 0 ;
      int[] arr = new int[n] ;
      System.out.println("Nhap mang: ") ;
      for ( int i = 0 ; i < n ; i++ )
      {
          arr[i] = scanner.nextInt() ;
      }
     System.out.println("x: ");
      int x = scanner.nextInt() ;
      arr = thempt( arr , x );
      System.out.println("Mang moi: " );
      for ( int i = 0 ; i < arr.length ; i++ ) System.out.println(arr[i]);
      System.out.println("Nhap vi tri can xoa:" );
      int y = scanner.nextInt() ;
      arr = xoapt( arr , y - 1 );
      System.out.println("Mang sau khi xoa: ");
        for ( int i = 0 ; i < arr.length; i++ ) System.out.println(arr[i]);
      scanner.close();
    }
}