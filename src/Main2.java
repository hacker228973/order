import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("file.txt"));
        } catch (IOException e) {
            System.out.println("Exception " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Exception " + e);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Запись");
        record(br,orders);


        File file = new File("file.txt");

        addOrder(orders, scanner);
        addOrder(orders, scanner);
        addOrder(orders, scanner);
    }
    public static void record(BufferedReader br, ArrayList<Order> orders){
        try {
            String line = br.readLine();
            while (br.readLine() == null) {
                String str = br.readLine();
                str = str.replaceAll(",", "");
                str = str.replaceAll("]", "");
                String[] arr = str.split(" ");
                int number=Integer.parseInt(arr[0]);
                LocalDateTime dateOfCreate = LocalDateTime.parse(arr[1], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
                LocalDateTime dateOfUpdate = LocalDateTime.parse(arr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
                OrderStatus status = OrderStatus.getStatus(arr[3]);
                orders.add(new Order(number, dateOfCreate, dateOfUpdate, status));
                System.out.println("Запись прошла успешно");
            }
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
    }
    public static void addOrder(ArrayList<Order> orders, Scanner scanner) {
        System.out.println("Введите номер заказа");
        int numberOfOrder = scanner.nextInt();
        orders.add(new Order(numberOfOrder, LocalDateTime.now(), LocalDateTime.now(), OrderStatus.NEW));

        System.out.println(orders);
    }
    public void upgrade(ArrayList<Order> orders){
        PrintWriter pw=null;
        try {
            pw = new PrintWriter("file.txt");
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
        pw.println(orders);
        pw.close();
    }

//    public static void addOrder(ArrayList<Order> orders, Scanner scanner, File file) {
//        System.out.println("Введите номер заказа");
//        int numberOfOrder = scanner.nextInt();
//        if (orders.size() == 0) {
//            Order newOrder = new Order(numberOfOrder, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), OrderStatus.NEW);
//            orders.add(newOrder);
//            System.out.println("Добавлено");
//
//            PrintWriter pw = new PrintWriter(file);
//            String str;
//            str = "\n" + numberOfOrder;
//            str = str.replaceAll(",", "");
//            str = str.replaceAll("]", "");
//            data.add(str);
//            str = "\n" + new Date(System.currentTimeMillis());
//            str = str.replaceAll(",", "");
//            str = str.replaceAll("]", "");
//            data.add(str);
//            str = "\n" + new Date(System.currentTimeMillis());
//            str = str.replaceAll(",", "");
//            str = str.replaceAll("]", "");
//            data.add(str);
//            str = "\n" + OrderStatus.NEW;
//            str = str.replaceAll(",", "");
//            str = str.replaceAll("]", "");
//            data.add(str);
//            pw.println(data);
//            System.out.println(data);
//            pw.close();
//        } else {
//            for (int i = 0; i < orders.size(); i++) {
//                if (orders.get(i).getNumberOfOrder() == numberOfOrder) {
//                    for (OrderStatus info : EnumSet.allOf(OrderStatus.class)) {
//                        System.out.println(info);
//
////                    System.out.println(info);
//                    }
//                    break;
//                } else {
//                    Order newOrder = new Order(numberOfOrder, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), OrderStatus.NEW);
//                    orders.add(newOrder);
//                    System.out.println("Добавлено");
//
//                    PrintWriter pw = new PrintWriter(file);
//                    String str;
//
//                    str = "\n" + numberOfOrder;
//                    str = str.replaceAll(",", "");
//                    str = str.replaceAll("]", "");
//                    data.add(str);
//
//                    str = "\n" + new Date(System.currentTimeMillis());
//                    str = str.replaceAll(",", "");
//                    str = str.replaceAll("]", "");
//                    data.add(str);
//
//                    str = "\n" + new Date(System.currentTimeMillis());
//                    str = str.replaceAll(",", "");
//                    str = str.replaceAll("]", "");
//                    data.add(str);
//
//                    str = "\n" + OrderStatus.NEW;
//                    str = str.replaceAll(",", "");
//                    str = str.replaceAll("]", "");
//                    data.add(str);
//
//                    pw.println(data);
//                    System.out.println(data);
//                    pw.close();
//                    break;
//                }
//            }

//        else if (orders.get(numberOfOrder) == null) {
//            for (OrderStatus info : EnumSet.allOf(OrderStatus.class)) {
//                System.out.println(info);
//            }
//        }

//        }
//    }
}
