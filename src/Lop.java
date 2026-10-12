import java.util.Arrays;
import java.util.Scanner ;
public class Lop {
    public static void main( String[] agrs){
        Scanner sc = new Scanner(System.in) ;
        boolean countinue = true ;
        while( countinue )
        {
            System.out.println("Chon bai tap: ");
            System.out.println("BT1. Toạ độ");
            System.out.println("BT2. Hình chữ nhật");
            System.out.println("BT3. Hình tròn");
            System.out.println("BT4. Sinh viên");
            System.out.println("BT5. Số nguyên ");
            System.out.println("BT6. Mảng ");
            System.out.println("BT7. Chuỗi ");
            System.out.println("BT8. Bổ sung cho BT4");
            System.out.println("0. Thoát chương trình!");
            System.out.println("Chon bài tập theo số(1->8): ");
            int luachon = sc.nextInt() ;
            sc.nextLine() ;
            switch (luachon)
            {
                case 1:
                    Toado a = new Toado() ;
                    a.set_td();
                    a.get_td();
                    a.move_td();
                    break;
                case 2:
                    Hinhchunhat b = new Hinhchunhat() ;
                    b.set_hcn();
                    b.get_hcn();
                    b.get_chuvi();
                    b.get_dientich();
                    break;
                case 3:
                    Hinhtron c = new Hinhtron();
                    c.set_r();
                    c.get_r();
                    c.get_chuvi();
                    c.get_dientich();
                    break;
                case 4:
                    Sinhvien sinhvien = new Sinhvien() ;
                    sinhvien.set_sv();
                    sinhvien.get_sv();
                    sinhvien.xeploai();
                    sinhvien.diemTB();
                    break;
                case 5:
                    System.out.println("Nhập giá trị cho số nguyên: ");
                    int value = sc.nextInt() ;
                    SoNguyen n = new SoNguyen(value) ;
                    System.out.println("Số nguyên vừa nhập: " + n.getValue());
                    System.out.println("Nhập số nguyên khác để tính toán: ");
                    int ot = sc.nextInt();
                    SoNguyen other = new SoNguyen(ot) ;
                    SoNguyen kquacong = n.add(other) ;
                    System.out.println( "Cong hai so nguyen n + other: " + kquacong.getValue());
                    SoNguyen kquatru = n.sub(other) ;
                    System.out.println( "Tru hai so nguyen n - other: " + kquatru.getValue());
                    SoNguyen kquanhan = n.mutil(other) ;
                    System.out.println( "Nhan hai so nguyen n * other: " + kquanhan.getValue());
                    SoNguyen kquachiadu = n.chia_du(other) ;
                    System.out.println( "Chia du hai so nguyen n % other: " + kquachiadu.getValue());
                    SoNguyen kquachianguyen = n.chia_nguyen(other) ;
                    System.out.println( "Chia nguyen hai so nguyen n/other: " + kquachianguyen.getValue());
                    if ( n.CompareTo(other) > 0 )
                    {
                        System.out.println( value + " > " + ot );
                    }
                    else if ( n.CompareTo(other) < 0 )
                        System.out.println( value + " < " + ot );
                    else
                        System.out.println( value + " = " + ot );
                    break;
                case 6:
                   System.out.println("Nhập kích thước cho mảng: ");
                   int size = sc.nextInt() ;
                   Array arr = new Array(size) ;
                   arr.thietlap();
                   arr.print_arr();
                   System.out.println("Nhập phần tử mới: ");
                   int new_value = sc.nextInt() ;
                   arr.add_units(new_value);
                   System.out.println("Nhập vị trí cần xoá: ");
                   int index = sc.nextInt();
                   arr.remove(index);
                   System.out.println("Nhập giá trị mới và vị trí cần sửa: ");
                   int index_fix = sc.nextInt() ;
                   int value_fix = sc.nextInt() ;
                   arr.fix(index_fix , value_fix);
                   System.out.println("Nhập giá trị cần tìm kiếm: ");
                   int find_value = sc.nextInt() ;
                   if ( arr.find_value(find_value) == -1 ) System.out.println("Giá trị không tồn tại trong mảng!");
                   else System.out.println("Vị trí của giá trị ở trong mảng là: " + arr.find_value(find_value));
                   break;
                case 7:
                    System.out.println("Nhập chuỗi: ");
                    String str = sc.nextLine() ;
                    myString string = new myString(str) ;
                    System.out.println("Lấy từng ký tự: ");
                    for ( int i = 0 ; i < string.getLength() ; i++ )
                    {
                        System.out.println(string.CharAt(i));
                    }
                    System.out.println("Nhập chuỗi mới cần thêm vào: ");
                    String new_str = sc.nextLine() ;
                    myString new_string = new myString(new_str);
                    System.out.println("So sánh 2 chuỗi: " + string.toString() + " và " + new_string.toString() );
                    if ( string.squals(new_string) ) System.out.println("Hai chuỗi bằng nhau!");
                    else System.out.println("Hai chuỗi khác nhau!");
                    myString concat_str = string.concat(new_string) ;
                    System.out.println("Chuỗi sau khi được thêm: " + Arrays.toString(concat_str.getChars()));
                    System.out.println("Nhập vị trị bắt đầu và kết thúc để cắt chuỗi: ");
                    int start = sc.nextInt() ;
                    int end = sc.nextInt() ;
                    System.out.println("Đoạn chuỗi được cắt ra: " + string.substring(start , end).toString());
                    break;
                case 8:
                    Danhsachsv ds = new Danhsachsv(100) ;
                    boolean tieptuc = true ;
                    while ( tieptuc ) {
                        System.out.println("Nhập lựa chọn trong quản lý lớp học: ");
                        System.out.println("1. Thêm sinh viên!");
                        System.out.println("2. Xoá sinh viên!");
                        System.out.println("3. Tìm kiếm thông tin sinh viên!");
                        System.out.println("4. In danh sách sinh viên!");
                        System.out.println("0. Quay lại giao diện!");
                        System.out.println("Nhập lựa chọn: ");
                        int luachon_2 = sc.nextInt();
                        sc.nextLine();
                        switch (luachon_2) {
                            case 1:
                                ds.them_sv();
                                break;
                            case 2:
                                System.out.println("Nhập mã số sinh viên cần xoá: ");
                                String mssv = sc.nextLine();
                                ds.xoa_sv(mssv);
                                break;
                            case 3:
                                System.out.println("Nhập mã số sinh viên cần tìm kiếm: ");
                                String mssv2 = sc.nextLine();
                                ds.timkiem_sv(mssv2);
                                break;
                            case 4:
                                System.out.println("Danh sách sinh viên: ");
                                ds.print_ds_sv();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Giá trị nhập không hợp lệ!");
                                break;
                        }
                        if ( luachon_2 != 0 )
                        {
                            System.out.println("Bank có muốn tiếp tục(1/0): ");
                            int chon = sc.nextInt();
                            sc.nextLine();
                            if ( chon == 0 ) tieptuc = false ;
                        }
                        else tieptuc = false ;
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
            if ( luachon == 0 )
            {
                countinue = false ;
            }
            else
            {
                System.out.println("Bank có muốn tiếp tục(1/0): ");
                int tieptuc_2  = sc.nextInt();
                sc.nextLine();
                if ( tieptuc_2 == 0 ) countinue = false ;
            }
        }
    }
}
