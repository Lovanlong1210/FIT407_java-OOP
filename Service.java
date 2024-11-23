package org.example;

public class Service {
        // Thêm phương thức hiển thị dịch vụ
        public void displayServices() {
            System.out.println("Danh sách dịch vụ:");
            System.out.println("1. Giặt ủi - 100.000 VNĐ");
            System.out.println("2. Đưa đón - 200.000 VNĐ");
            System.out.println("3. Ăn uống - 150.000 VNĐ");
            System.out.println("4. Spa - 300.000 VNĐ");
        }
    
        // Thêm phương thức sử dụng dịch vụ
        public void useService(int serviceId) {
            switch (serviceId) {
                case 1:
                    System.out.println("Bạn đã chọn dịch vụ Giặt ủi với giá 100.000 VNĐ.");
                    break;
                case 2:
                    System.out.println("Bạn đã chọn dịch vụ Đưa đón với giá 200.000 VNĐ.");
                    break;
                case 3:
                    System.out.println("Bạn đã chọn dịch vụ Ăn uống với giá 150.000 VNĐ.");
                    break;
                case 4:
                    System.out.println("Bạn đã chọn dịch vụ Spa với giá 300.000 VNĐ.");
                    break;
                default:
                    System.out.println("Dịch vụ không hợp lệ.");
                    break;          
        }
    }
}
