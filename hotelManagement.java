import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hotelManagement {
    private List<Room> roomList; // Danh sách phòng
    private Scanner scanner;

    public hotelManagement() {
        roomList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Thêm phòng vào danh sách
    public void themPhong() {
        System.out.print("Nhập số phòng: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
        System.out.print("Nhập loại phòng (đơn, đôi, suite): ");
        String roomType = scanner.nextLine();
        System.out.print("Nhập giá mỗi đêm: ");
        double pricePerNight = scanner.nextDouble();
        scanner.nextLine(); // Xóa bộ đệm
        roomList.add(new Room(roomNumber, roomType, pricePerNight));
        System.out.println("Đã thêm thành công phòng vào danh sách.");
    }

    // Hiển thị danh sách phòng
    public void danhSachPhong() {
        if (roomList.isEmpty()) {
            System.out.println("Danh sách phòng rỗng!");
            return;
        }
        System.out.println("\t\t\t\t\t\tDanh Sách Phòng");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-15s |%n", "Số Phòng", "Loại Phòng", "Giá/Đêm", "Trạng Thái");
        System.out.println("---------------------------------------------------------------------------");
        for (Room room : roomList) {
            String status = room.isAvailable() ? "Có sẵn" : "Đã đặt";
            System.out.printf("| %-10d | %-20s | %-10.2f | %-15s |%n", room.getRoomNumber(), room.getRoomType(), room.getPricePerNight(), status);
        }
    }

    public void timPhong() {
        System.out.print("Nhập số phòng cần tìm: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
        Room room = searchRoomByNumber(roomNumber);
        if (room != null) {
            System.out.println("Phòng tìm thấy: " + room);
        } else {
            System.out.println("Không tìm thấy phòng với số: " + roomNumber);
        }
    }

    private Room searchRoomByNumber(int roomNumber) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void xoaPhong() {
        System.out.print("Nhập số phòng cần xóa: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
        boolean removed = roomList.removeIf(room -> room.getRoomNumber() == roomNumber);
        if (removed) {
            System.out.println("Xóa phòng thành công.");
        } else {
            System.out.println("Không tìm thấy phòng với số: " + roomNumber);
        }
    }

    public void suaPhong() {
        System.out.print("Nhập số phòng cần sửa: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
        Room room = searchRoomByNumber(roomNumber);
        if (room != null) {
            System.out.print("Nhập loại phòng mới: ");
            String newType = scanner.nextLine();
            System.out.print("Nhập giá mới: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine(); // Xóa bộ đệm
            room.setRoomType(newType);
            room.setPricePerNight(newPrice);
            System.out.println("Sửa phòng thành công!");
        } else {
            System.out.println("Không tìm thấy phòng với số: " + roomNumber);
        }
    }

    public void luuFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("rooms.dat"))) {
            outputStream.writeObject(roomList);
            System.out.println("Lưu file thành công!");
        } catch (IOException e) {
            System.out.println("Không thể mở file để lưu!");
            e.printStackTrace();
        }
    }

    public void docFile() {
        roomList.clear(); // Xóa danh sách hiện tại trước khi đọc từ file
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("rooms.dat"))) {
            roomList = (List<Room>) inputStream.readObject();
            System.out.println("Đọc file thành công!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không thể mở file để đọc!");
            e.printStackTrace();
        }
    }

    public boolean checkRoomNumberExists(int roomNumber) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNumber) {
                return true; // Trùng số phòng
            }
        }
        return false; // Không trùng
    }
}