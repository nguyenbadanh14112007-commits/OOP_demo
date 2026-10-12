import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
class Person {
    private String Ho_ten , Dia_chi , so_dt , email ;
    private LocalDate Ngay_sinh ;
    Scanner sc = new Scanner(System.in) ;
    public Person()
    {
        Ho_ten = Dia_chi = so_dt = email = "" ;
    }

    public void setDia_chi(String dia_chi) {
        Dia_chi = dia_chi;
    }

    public void setHo_ten(String ho_ten) {
        Ho_ten = ho_ten;
    }

    public void setSo_dt(String so_dt) {
        this.so_dt = so_dt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNgay_sinh(LocalDate ngay_sinh) {
        Ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return Dia_chi;
    }

    public String getSo_dt() {
        return so_dt;
    }

    public String getHo_ten() {
        return Ho_ten;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getNgay_sinh() {
        return Ngay_sinh;
    }
    public void set_person()
    {
        System.out.println("Nhap ho ten: ");
        Ho_ten = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        Dia_chi = sc.nextLine() ;
        System.out.println("Nhap so dien thoai: " );
        so_dt = sc.nextLine() ;
        System.out.println("Nhap email: ");
        email = sc.nextLine() ;
        System.out.println("Nhap ngay sinh: ");
        String ngaysinh = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_sinh = LocalDate.parse( ngaysinh , khuon ) ;
    }
    public String toString()
    {
        return "Ho ten: " + Ho_ten + " | Dia chi: " + Dia_chi + " | So dien thoai: " + so_dt + " | email: " + email + " | Ngay sinh: " + Ngay_sinh ;
    }
}
class Student extends Person
{
    private double Diem_mon_1 , Diem_mon_2 ;
    private String Lop , Truong;
    Scanner sc = new Scanner(System.in) ;
    public Student()
    {

        Diem_mon_1 = Diem_mon_2 = 0.0 ;
        Lop = Truong = "" ;
    }

    public void setDiem_mon_1(double diem_mon_1) {
        Diem_mon_1 = diem_mon_1;
    }

    public void setDiem_mon_2(double diem_mon_2) {
        Diem_mon_2 = diem_mon_2;
    }
    public void setLop(String lop)
    {
        Lop = lop ;
    }

    public void setTruong(String truong) {
        Truong = truong;
    }

    public double getDiem_mon_1() {
        return Diem_mon_1;
    }

    public double getDiem_mon_2() {
        return Diem_mon_2;
    }

    public String getLop() {
        return Lop;
    }

    public String getTruong() {
        return Truong;
    }

    @Override
    public void set_person() {
        super.set_person();
        System.out.println("Nhap ten lop: ");
        Lop = sc.nextLine() ;
        System.out.println("Nhap ten truong: ");
        Truong = sc.nextLine() ;
    }
    public String toString()
    {
        return super.toString() + " | Lop: " + Lop + " | Truong: " + Truong ;
    }
    public double Diem_tb()
    {
        return (Diem_mon_1 + Diem_mon_2)/2.0 ;
    }
}
public class QLhocvien {
    public static void main( String[] agrs)
    {
        Scanner scanner = new Scanner(System.in) ;

    }
}
