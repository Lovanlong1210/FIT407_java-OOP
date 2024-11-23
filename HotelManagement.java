package org.example;
import java.util.ArrayList;
import java.util.List;

public class HotelManagement {
    private List<Room> roomList;
    private List<Customer> customerList;
    private List<Booking> bookingList;

    public HotelManagement() {
        roomList = new ArrayList<>();
        customerList = new ArrayList<>();
        bookingList = new ArrayList<>();
        initializeRooms();

    }

    public void addCustomer(int id, String name, String address, String phoneNumber, String birthDate) {
        Customer customer = new Customer(id, name,address, phoneNumber, birthDate, "");
        customer.setBirthDate(birthDate);
        customerList.add(customer);
    }
    public void addCustomers(List<Customer> newCustomers) {
        for (Customer customer : newCustomers) {
            customerList.add(customer);
        }
        System.out.println("Đã thêm " + newCustomers.size() + " khách hàng thành công!");
    }

    public void updateCustomersInfo(List<Customer> updatedCustomers) {
        for (Customer updatedCustomer : updatedCustomers) {
            for (Customer customer : customerList) {
                if (customer.getId() == updatedCustomer.getId()) {
                    customer.setName(updatedCustomer.getName());
                    customer.setAddress(updatedCustomer.getAddress());
                    customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    customer.setBirthDate(updatedCustomer.getBirthDate());
                }
            }
        }
        System.out.println("Thông tin khách hàng đã được cập nhật!");
    }

    public void displayCustomers() {
        System.out.println("\t\t\t\t\t\tDanh Sách Khách Hàng");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-30s | %-15s | %-15s | %-15s |%n", "Tên", "Địa chỉ", "Số điện thoại", "Ngày sinh", "Phòng cần thuê");
        System.out.println("---------------------------------------------------------------------------");
        for (Customer customer : customerList) {
            System.out.printf("| %-20s | %-30s | %-15s | %-15s | %-15s |%n", 
                customer.getName(), 
                customer.getAddress(), 
                customer.getPhoneNumber(), 
                customer.getBirthDate(), 
                customer.getRoomNeeded());
        }
    }

    public void displayRooms() {
        System.out.println("\t\t\t\t\t\tDanh Sách Phòng");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-15s |%n", "Số Phòng", "Loại Phòng", "Giá/Đêm", "Trạng Thái");
        System.out.println("---------------------------------------------------------------------------");
        for (Room room : roomList) {
            String status = room.isAvailable() ? "Có sẵn" : "Đã đặt";
            System.out.printf("| %-10d | %-20s | %-10.2f | %-15s |%n", room.getRoomNumber(), room.getRoomType(), room.getPricePerNight(), status);
        }
    }

    
    public void bookRoom(int bookingId, int customerId, String roomType, String checkInDate, String checkOutDate) {
        Booking booking = new Booking(bookingId, customerId, roomType, checkInDate, checkOutDate);
        bookingList.add(booking);
        
        // Tìm khách hàng và thêm thông tin phòng cần thuê
        for (Customer customer : customerList) {
            if (customer.getId() == customerId) {
                customer.setRoomNeeded(roomType); // Cập nhật thông tin phòng cần thuê
                System.out.println("Đặt phòng thành công cho khách h��ng: " + customer.getName());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng với mã: " + customerId);
    }
    public void returnRoom(int roomNumber) {
        Room room = roomList.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
        if (room != null) {
            if (!room.isAvailable()) {
                room.setAvailable(true);
                System.out.println("Phòng số " + roomNumber + " đã được trả thành công và hiện đang trống.");
            } else {
                System.out.println("Phòng số " + roomNumber + " hiện không được đặt, không thể trả.");
            }
        } else {
            System.out.println("Phòng số " + roomNumber + " không tồn tại.");
        }
    }

    private void initializeRooms() {
        roomList.add(new Room(101, "Đơn", 500000));
        roomList.add(new Room(102, "Đôi", 750000));
        roomList.add(new Room(103, "Suite", 1200000));
        // Thêm các phòng khác nếu cần
    }


    public void calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Room room : roomList) {
            if (!room.isAvailable()) {
                totalRevenue += room.getPricePerNight(); // Giả sử mỗi phòng đã thuê sẽ tính giá một lần
            }
        }
        System.out.println("Tổng doanh thu hiện tại: " + totalRevenue + " VNĐ");
    }

    public void viewRevenueReport() {
        System.out.println("\t\t\t\t\t\tBáo Cáo Doanh Thu");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s |%n", "Số Phòng", "Loại Phòng", "Giá/Đêm");
        System.out.println("---------------------------------------------------------------------------");
        for (Room room : roomList) {
            if (!room.isAvailable()) {
                System.out.printf("| %-10d | %-20s | %-10.2f |%n", room.getRoomNumber(), room.getRoomType(), room.getPricePerNight());
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
    
    
