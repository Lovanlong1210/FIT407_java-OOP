package org.example;
// import java.util.ArrayList;
import java.util.List;

public class Staff {
    private final String employeeId; // Mã nhân viên
    private final String name; // Tên nhân viên
    private final String position; // Vị trí công việc
    private final String phoneNumber; // Số điện thoại

    public Staff(String employeeId, String name, String position, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
    }

    // Getter cho các thuộc tính
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Phương thức hiển thị thông tin nhân viên
    public void displayInfo() {
        System.out.println("Mã nhân viên: " + employeeId + ", Tên: " + name + ", Vị trí: " + position + ", Số điện thoại: " + phoneNumber);
    }

    // Phương thức hiển thị danh sách nhân viên
    public static void displayStaffList(List<Staff> staffList) {
        System.out.println("Danh sách nhân viên:");
        for (Staff staff : staffList) {
            staff.displayInfo();
        }
    }
}