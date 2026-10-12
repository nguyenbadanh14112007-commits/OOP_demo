import java.util.Scanner;

class Array
{
    private int size ;
    private int[] arr = null ;
    Scanner sc = new Scanner(System.in) ;
    public Array( int size )
    {
        this.size = size ;
        this.arr = new int[this.size] ;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int[] getArr() {
        return arr;
    }
    public void thietlap()
    {
        System.out.println("Nhap gia tri cho cac phan tu mang: " );
        for ( int i = 0 ; i < size ; i++ )
            this.arr[i] =sc.nextInt() ;
        System.out.println("Nhap gia tri cho cac phan tu mang thanh cong!");
    }
    public void add_units( int value )
    {
        int new_size = this.size + 1 ;
        int[] arr1 = new int[new_size] ;
        System.arraycopy(arr, 0, arr1, 0, this.size);
        arr1[new_size - 1] = value ;
        this.arr = arr1 ;
        this.size = new_size ;
        System.out.println("Mang sau khi them: ");
        print_arr();
    }
    public void remove( int index )
    {
        int new_size = this.size - 1 ;
        int[] arr1 = new int[new_size] ;
        for ( int i = index ; i < size -1 ; i++ )
        {
            int pseudo = arr[i+1] ;
            arr[i+1] = arr[i] ;
            arr[i] = pseudo ;
        }
        System.arraycopy(arr , 0 , arr1 , 0 , new_size );
        this.size = new_size ;
        this.arr = arr1 ;
        System.out.println("Mang sau khi xoa: ");
        print_arr();
    }
    public void fix ( int index , int value )
    {
        if ( index > this.size ){
            System.out.println("Giá trị nhập không hợp lệ");
            return;
        }
        arr[index] = value ;
        System.out.println("Mang sau khi sua: ");
        print_arr();
    }
    public int find_value ( int value )
    {
        for ( int i = 0 ; i < this.size ; i++ )
            if ( this.arr[i] == value ) return i ;
        return -1 ;
    }
    public void print_arr ()
    {
        System.out.println("Cac phan tu trong mang");
        for ( int i:arr)
        {
            System.out.println(i + " ");
        }
    }
}