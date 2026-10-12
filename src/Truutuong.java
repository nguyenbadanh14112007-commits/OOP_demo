import java.util.Scanner ;
abstract class Animal
{
    String Animalcode , Name , Loai ;
    public Animal(){
        Animalcode = "" ;
        Name = "" ;
    }
    public abstract void animalsound() ;
    public abstract void animalfood() ;
    public abstract void animalreproduce() ;
    public abstract void animalmove() ;
    public void set_animal()
    {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap ma dong vat: ");
        Animalcode = scanner.nextLine() ;
        System.out.println("Nhap ten: ");
        Name = scanner.nextLine() ;
    }
    public void get_animal()
    {
        System.out.println("Ma dong vat: " + Animalcode);
        System.out.println("Ten dong vat: " + Name);
        System.out.println("Loai: " + Loai);
    }
    public static void sleep()
    {
        System.out.println("zzz");
    }
}
class Dog extends Animal
{
    public Dog()
    {
        super();
        Loai = "Dog" ;
    }
    @Override
    public void animalsound() {
         System.out.println("gau gau");
    }

    @Override
    public void animalfood() {
        System.out.println("xuong");
    }

    @Override
    public void animalmove() {
        System.out.println("bon chan");
    }

    @Override
    public void animalreproduce() {
        System.out.println("Sinh san huu tinh: De con");
    }
}
class Cat extends Animal
{
    public Cat ()
    {
        super();
        Loai = "Cat" ;
    }
    @Override
    public void animalsound() {
        System.out.println("Meow Meow");
    }

    @Override
    public void animalfood() {
        System.out.println("pate");
    }

    @Override
    public void animalmove() {
        System.out.println("bon chan");
    }

    @Override
    public void animalreproduce() {
        System.out.println("Sinh san huu tinh: De con");
    }
}
class Chicken extends Animal
{
    public Chicken()
    {
        super();
        Loai = "Chicken" ;
    }
    @Override
    public void animalsound() {
        System.out.println("tuc tac tuc tac");
    }

    @Override
    public void animalfood() {
        System.out.println("thoc");
    }

    @Override
    public void animalmove() {
        System.out.println("hai chan");
    }

    @Override
    public void animalreproduce() {
        System.out.println("Sinh san huu tinh: De trung");
    }
}
class manageAnimal
{
    Animal[]arr ;
    int Soluong ;
    public manageAnimal(int Max)
    {
        arr = new Animal[Max] ;
        Soluong = 0 ;
    }
    public void add_animal() {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Nhap lua chon: ");
        System.out.println("1.Them loai cho!");
        System.out.println("2.Them loai meo!");
        System.out.println("3.Them loai ga!");
        System.out.println("Lua chon");
        int luachon = scanner.nextInt() ;
        switch (luachon)
        {
            case 1:
                if ( Soluong < arr.length ) {
                    Animal a = new Dog();
                    a.set_animal();
                    arr[Soluong] = a ;
                    Soluong++;
                    System.out.println("Them dong vat thanh cong!");
                }
                else System.out.println("So luong da toi da!");
                break;
            case 2:
                if ( Soluong < arr.length ) {
                    Animal a = new Cat();
                    a.set_animal();
                    arr[Soluong] = a ;
                    Soluong++;
                    System.out.println("Them dong vat thanh cong!");
                }
                else System.out.println("So luong da toi da!");
                break;
            case 3:
                if ( Soluong < arr.length ) {
                    Animal a = new Chicken();
                    a.set_animal();
                    arr[Soluong] = a ;
                    Soluong++;
                    System.out.println("Them dong vat thanh cong!");
                }
                else System.out.println("So luong da toi da!");
                break;
            default: System.out.println("Lua chon khong hop le!");
            break;
        }
    }
    public void print_animal()
    {
        for ( int i = 0 ; i < Soluong ; i++ )
            arr[i].get_animal();
    }
    public void xoa_animal( String ma_dv)
    {
        int index = -1 ;
        for ( int i = 0 ; i < Soluong ; i++)
        {
            if ( arr[i].Animalcode.equals(ma_dv))
            {
                index = i ;
                break;
            }
        }
        if ( index == -1 ) System.out.println("ma dong vat khong hop le! ");
        else {
            for ( int i = index ; i < Soluong - 1 ; i++ )
            {
                Animal a = arr[i] ;
                arr[i] = arr[i+1] ;
                arr[i+1] = a ;
            }
            arr[Soluong] = null ;
            Soluong--;
            System.out.println("Xoa dong vat thanh cong!");
        }
    }
    public void repeat_animal( String ma_dv ){
        int index = -1 ;
        for ( int i = 0 ; i < Soluong ; i++)
        {
            if ( arr[i].Animalcode.equals(ma_dv))
            {
                index = i ;
                break;
            }
        }
        if ( index == -1 ) System.out.println("ma dong vat khong hop le! ");
        else {
            arr[index].set_animal();
        }
    }
    public void Search_animal( String ma_dv )
    {
        int index = -1 ;
        for ( int i = 0 ; i < Soluong ; i++)
        {
            if ( arr[i].Animalcode.equals(ma_dv))
            {
                index = i ;
                break;
            }
        }
        if ( index == -1 ) System.out.println("ma dong vat khong hop le! ");
        else arr[index].get_animal();
    }
    public void tong_soluong_cac_loai()
    {
        int sum_dog = 0 , sum_cat = 0 , sum_chicken = 0 ;
        for ( int i = 0 ; i < Soluong ; i++ )
        {
            if ( arr[i].Loai.equals("Dog")) sum_dog++ ;
            else if ( arr[i].Loai.equals("Cat")) sum_cat++ ;
            else if ( arr[i].Loai.equals("Chicken")) sum_chicken++;
        }
        System.out.println("So luong cho la: " + sum_dog);
        System.out.println("So luong meo la: " + sum_cat);
        System.out.println("So luong ga la: " + sum_chicken);
    }
}
public class Truutuong {
    public static void main( String[] agrs)
    {
        Scanner scanner = new Scanner(System.in) ;
    }
}