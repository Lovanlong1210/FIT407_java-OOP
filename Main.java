package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HotelManagement hotelManagement = new HotelManagement();
        Scanner scanner = new Scanner(System.in);

        int luaChon;
        do {
            System.out.println("+----------------------------------------------+");
            System.out.println("|                  MENU                         |");
            System.out.println("+----------------------------------------------+");
            System.out.println("|           Quản lý khách hàng                 |");
            System.out.println("|  1. Thêm khách hàng                          |");
            System.out.println("|  2. Sửa thông tin khách hàng                 |");
            System.out.println("|  3. Hiển thị thông tin khách hàng            |");
            System.out.println("+----------------------------------------------+");
            System.out.println("|           Quản lý đặt phòng                  |");
            System.out.println("|  4. Đặt phòng                                |");
            System.out.println("|  5. Trả phòng                                |");
            System.out.println("|  6. Hiện thị danh sách phòng                 |");
            System.out.println("+----------------------------------------------+");
            System.out.println("|           Quản lý nhân viên                  |");
            System.out.println("|  7. Hiện thị danh sách nhân viên             |");
            System.out.println("+----------------------------------------------+");
            System.out.println("|           Quản lý dịch vụ                    |");
            System.out.println("|  8. Hiện thị danh sách dịch vụ               |");
            System.out.println("|  9. Sử dụng dịch vụ                          |");
            System.out.println("+----------------------------------------------+");
            System.out.println("|  10. Tổng doanh thu                          |");
            System.out.println("|  11. Xem báo cáo doanh thu                   |");
            System.out.println("+----------------------------------------------+");
            System.out.println("|  12. Thoát chương trình                      |");
            System.out.println("+----------------------------------------------+");
            System.out.print("> > Nhập lựa chọn của bạn: ");

            luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm sau khi nhập số
            switch (luaChon) {
                case 1:
                    List<Customer> newCustomers = new ArrayList<>();
                    System.out.println("Nhập số lượng khách hàng cần thêm:");
                    int numberOfCustomers = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm
                    for (int i = 0; i < numberOfCustomers; i++) {
                        System.out.println("Nhập thông tin khách hàng thứ " + (i + 1) + ":");
                        System.out.print("Mã khách hàng: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Xóa bộ đệm
                        System.out.print("Tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Địa chỉ: ");
                        String address = scanner.nextLine();
                        System.out.print("Số điện thoại: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Ngày sinh: ");
                        String birthDate = scanner.nextLine();
                        System.out.print("Phòng cần thuê: ");
                        String roomNeeded = scanner.nextLine();
                        newCustomers.add(new Customer(id, name, address, phoneNumber, birthDate, roomNeeded));
                    }
                    hotelManagement.addCustomers(newCustomers);
                    break;
                    
                case 2:
                    List<Customer> updatedCustomers = new ArrayList<>();
                    System.out.println("Nhập số lượng khách hàng cần sửa:");
                    int numberOfUpdates = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm
                    for (int i = 0; i < numberOfUpdates; i++) {
                        System.out.println("Nhập thông tin khách hàng cần sửa thứ " + (i + 1) + ":");
                        System.out.print("Mã khách hàng: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Xóa bộ đệm
                        System.out.print("Tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Địa chỉ mới: ");
                        String newAddress = scanner.nextLine();
                        System.out.print("Số điện thoại mới: ");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.print("Ngày sinh mới: ");
                        String newBirthDate = scanner.nextLine();
                        updatedCustomers.add(new Customer(id, newName, newAddress, newPhoneNumber, newBirthDate, ""));
                    }
                    hotelManagement.updateCustomersInfo(updatedCustomers);
                    break;
                case 3:
                    hotelManagement.displayCustomers();
                    break;
                case 4:
                    System.out.print("Nhập mã đặt phòng: ");
                    int bookingId = scanner.nextInt();
                    System.out.print("Nhập mã khách hàng: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm
                    System.out.print("Nhập loại phòng: ");
                    String roomType = scanner.nextLine();
                    System.out.print("Nhập ngày nhận phòng: ");
                    String checkInDate = scanner.nextLine();
                    System.out.print("Nhập ngày trả phòng: ");
                    String checkOutDate = scanner.nextLine();
                    
                    hotelManagement.bookRoom(bookingId, customerId, roomType, checkInDate, checkOutDate);
                    break;
                case 5:
                    System.out.print("Nhập số phòng cần trả: ");
                    int returnRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm
                    hotelManagement.returnRoom(returnRoomNumber);
                    break;
                case 6:
                    hotelManagement.displayRooms();
                    break;
                case 7:
                    List<Staff> staffList = new ArrayList<>();
                    // Thêm dữ liệu nhân viên mẫu
                    staffList.add(new Staff("001", "Nguyễn Văn A", "Quản lý", "0123456789"));
                    staffList.add(new Staff("002", "Trần Thị B", "Lễ tân", "0987654321"));
                    staffList.add(new Staff("003", "Lê Văn C", "Nhân viên phục vụ", "0912345678"));
                    
                    Staff.displayStaffList(staffList); // Hiển thị danh sách nhân viên
                    break;
                case 8:
                    Service service = new Service();
                    service.displayServices();
                    break;
                case 9:
                    System.out.print("Nhập ID dịch vụ bạn muốn sử dụng: ");
                    int serviceId = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm
                    service = new Service();
                    service.useService(serviceId);
                    break;
                case 10:
                    hotelManagement.calculateTotalRevenue();
                    break;
                case 11:
                    hotelManagement.viewRevenueReport();
                    break;
                case 12:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 0);

        scanner.close(); // Đóng scanner khi không còn sử dụng
    }
}