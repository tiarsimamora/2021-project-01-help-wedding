
package HelpWedding;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author Agnes Sagita Lumban Tobing
 * @author Imelda Siregar
 * @author Tiar Saroha Simamora
 */
public class main {
    public static void main(String[] args) throws SQLException {
       Orders orders = new Orders();
       OrderItem orderItem = new OrderItem ();
       int command = 0;
       Scanner scan = new Scanner(System.in);
       Vendor vendor = new Vendor();
       String username;
       String password;
       boolean isLogin = false;
       
       do{
           if (isLogin) {
            System.out.println("======= Pilih Menu Di Bawah =======");
            System.out.println("1. Tampilkan semua orders");
            System.out.println("2. Buat Orders baru");
            System.out.println("3. Buat OrderItem baru");
            System.out.println("4. Tampilkan semua orderItem");
            System.out.println("9. Exit");
            System.out.print("Pilihan anda : ");
            command = scan.nextInt();
            
            if(command == 1){
                LinkedList<OrdersModel> tempOrder =   orders.getAllOrders();
                for(OrdersModel order : tempOrder){
                    System.out.println("=================== =====================");
                    System.out.println("Order ID : " + order.getOrderID());
                    System.out.println("Vendor ID : " + order.getVendorID());
                    System.out.println("Order Date : " + order.getOrderDate());
                    System.out.println("Order Address : " + order.getAddress());
                    System.out.println("CustomerName : " + order.getCustomerName());
                    System.out.println("Payment Type : " + order.getPaymentType());
                    System.out.println("Total Payment : " + order.getTotalPayment());
                    System.out.println("Payment Date : " + order.getPaymentDate());
                    System.out.println("=================== =====================");
                }
            }else if(command == 2){
               OrdersModel order = orders.getAllOrders().getLast();
               String[] split = order.getOrderID().split("D");
               orders.insertData(Integer.parseInt(split[1].trim()), "19/01/2021", "21/01/2021");
           }else if(command == 3){
                OrderItemModel item = orderItem.getAllOrderItem().getLast();
                String[] split = item.getOrderItemID().split("M");
                orderItem.insertItem(Integer.parseInt(split[1].trim()));
           }else if(command == 4){
                LinkedList<OrderItemModel> tempItem =   orderItem.getAllOrderItem();
                for(OrderItemModel item : tempItem){
                    System.out.println("=================== =====================");
                    System.out.println("OrderItem ID : " + item.getOrderItemID());
                    System.out.println("Order ID : " + item.getOrderID());
                    System.out.println("Service ID : " + item.getServiceID());
                    System.out.println("Quantity : " + item.getQuantity());
                    System.out.println("Price : " + item.getPrice());
                    System.out.println("=================== =====================");
                }
           }else if(command == 9){
               System.out.println("Terima kasih telah menggunakan aplikasi kami !");
               break;
            }
               
           } else{
               System.out.println("username: ");
               username = scan.nextLine();
               System.out.println("password: ");
               password = scan.nextLine();
               if(vendor.Login(username, password)){
                   isLogin = true;
               System.out.println("================== ====================");
               System.out.println("Selamat datang di Aplikasi HelpWedding!");
            } else{
                System.out.println("username atau password salah");
               }
           }
           
       }while(command != -1);
       scan.close();
    }
}
