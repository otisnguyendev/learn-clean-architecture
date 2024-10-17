import com.lab.database.DAOMemory;
import com.lab.entity.Customer;
import com.lab.usecase.DatabaseUseCase;
import com.lab.usecase.ReqData;
import com.lab.usecase.UseCase;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseUseCase database = new DAOMemory();
        UseCase useCase = new UseCase(database);

        boolean running = true;
        while (running) {
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Tính tổng số lượng theo loại khách hàng");
            System.out.println("5. Tính trung bình thành tiền của khách hàng nước ngoài");
            System.out.println("6. Xuất hóa đơn theo tháng");
            System.out.println("7. Thoát");
            System.out.print("Chọn một thao tác: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addInvoice(scanner, useCase);
                    break;
                case 2:
                    updateInvoice(scanner, useCase);
                    break;
                case 3:
                    removeInvoice(scanner, useCase);
                    break;
                case 4:
                    calculateTotalByCustomerType(scanner, useCase);
                    break;
                case 5:
                    calculateAverageForForeigners(useCase);
                    break;
                case 6:
                    exportInvoicesByMonth(scanner, useCase);
                    break;
                case 7:
                    running = false;
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }

        scanner.close();
    }

    private static void addInvoice(Scanner scanner, UseCase useCase) {
        ReqData data = new ReqData();
        System.out.println("Thêm hóa đơn:");

        System.out.print("Nhập mã khách hàng: ");
        data.setCustomerId(scanner.nextLine());

        System.out.print("Nhập tên khách hàng: ");
        data.setName(scanner.nextLine());

        System.out.print("Khách hàng nước ngoài (nhập quốc tịch) hay Việt Nam (để trống nếu không phải): ");
        String nationality = scanner.nextLine();
        if (!nationality.isEmpty()) {
            data.setNationality(nationality);
        }

        System.out.print("Nhập ngày xuất hóa đơn (yyyy-MM-dd): ");
        data.setInvoiceDate(LocalDate.parse(scanner.nextLine()));

        System.out.print("Nhập số lượng (KW tiêu thụ): ");
        data.setQuantity((int) scanner.nextDouble());

        System.out.print("Nhập đơn giá: ");
        data.setUnitPrice(scanner.nextDouble());

        if (data.getNationality() == null) {
            System.out.print("Nhập loại khách hàng (sinh hoạt, kinh doanh, sản xuất): ");
            scanner.nextLine();
            data.setCustomerType(scanner.nextLine());

            System.out.print("Nhập định mức: ");
            data.setLimit(scanner.nextDouble());
        }

        useCase.addInvoice(data);
        System.out.println("Hóa đơn đã được thêm thành công!");
    }

    private static void updateInvoice(Scanner scanner, UseCase useCase) {
        System.out.println("Sửa hóa đơn:");
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String customerId = scanner.nextLine();

        ReqData data = new ReqData();
        data.setCustomerId(customerId);

        addInvoice(scanner, useCase);
    }

    private static void removeInvoice(Scanner scanner, UseCase useCase) {
        System.out.println("Xóa hóa đơn:");
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String customerId = scanner.nextLine();

        useCase.removeInvoice(customerId);
        System.out.println("Hóa đơn đã được xóa.");
    }

    private static void calculateTotalByCustomerType(Scanner scanner, UseCase useCase) {
        System.out.println("Tính tổng số lượng theo loại khách hàng:");
        System.out.print("Nhập loại khách hàng (sinh hoạt, kinh doanh, sản xuất): ");
        String customerType = scanner.nextLine();

        double total = useCase.calculateTotalQuantityByType(customerType);
        System.out.println("Tổng số lượng tiêu thụ của khách hàng loại " + customerType + " là: " + total);
    }

    private static void calculateAverageForForeigners(UseCase useCase) {
        double average = useCase.calculateAverageTotalForeigner();
        System.out.println("Trung bình thành tiền của khách hàng nước ngoài là: " + average);
    }

    private static void exportInvoicesByMonth(Scanner scanner, UseCase useCase) {
        System.out.println("Xuất hóa đơn theo tháng:");
        System.out.print("Nhập tháng (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();

        List<Customer> invoices = useCase.getInvoicesByMonth(month, year);
        System.out.println("Các hóa đơn trong tháng " + month + "/" + year + ":");
        for (Customer invoice : invoices) {
            System.out.println(invoice);
        }
    }
}
