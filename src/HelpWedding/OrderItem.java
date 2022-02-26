
package HelpWedding;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author 12S19020 Imelda Siregar
 */
public class OrderItem {
    
    public DB dbCon;

    public LinkedList<OrderItemModel> getAllOrderItem() throws SQLException{
        this.dbCon = new DB();
        String sql = "SELECT * FROM orderItem";
        LinkedList<OrderItemModel> orderItem = this.dbCon.getAllDataOrderItem(sql);
        return orderItem;
    }
    public void insertItem(int lastItemID){
       Scanner scan = new Scanner(System.in);
       String orderItemID = "ITM" + String.format("%04d",lastItemID  +1);
       String orderID =  "ORD" + String.format("%04d",lastItemID  +1);
       String serviceID =  "STR" + String.format("%04d",lastItemID  +1);;
       int quantity;
       int price;
       System.out.println("Quantity: ");
       quantity = Integer.parseInt(scan.nextLine());
       System.out.println("Price: ");
       price =Integer.parseInt(scan.nextLine());

        this.dbCon = new DB();
        String sql = "INSERT INTO orderItem VALUES ('"+ orderItemID +" ','"+orderID +"','"+serviceID+"','"+quantity +"','"+price+"')";
        this.dbCon.insertItem(sql);
    }
    
}
