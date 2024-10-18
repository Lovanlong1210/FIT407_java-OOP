import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        hotelManagement hotelManagement = new hotelManagement();    
        Scanner scanner = new Scanner(System.in);

        int luaChon;
        do {
            System.out.println("----------------------------------------------------------------");
            System.out.println("|" + "\t\t\t\t\t\t\t\tMENU" + "\t\t\t\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t1. Thêm phòng" + "\t\t\t\t\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t2. Hiển thị danh sách phòng" + "\t\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t3. Tìm kiếm phòng theo số" + "\t\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t4. Xóa phòng theo số" + "\t\t\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t5. Sửa thông tin phòng" + "\t\t\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t6. Lưu danh sách phòng vào file" + "\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t7. Đọc danh sách phòng từ file" + "\t\t\t\t|");
            System.out.println("|" + "\t\t\t\t\t0. Thoát chương trình" + "\t\t\t\t\t\t|");
            System.out.println("----------------------------------------------------------------");
            System.out.print("> > Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1:
                    hotelManagement.themPhong();
                    break;
                case 2:
                    hotelManagement.danhSachPhong();
                    break;
                case 3:
                    hotelManagement.timPhong();
                    break;
                case 4:
                    hotelManagement.xoaPhong();
                    break;
                case 5:
                    hotelManagement.suaPhong();
                    break;
                case 6:
                    hotelManagement.luuFile();
                    break;
                case 7:
                    hotelManagement.docFile();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 0);
    }
}