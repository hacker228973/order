
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.EnumSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Запись");
        record(orders);
        System.out.println(orders);

        File file = new File("file.txt");

        addOrder(orders, scanner);

        upgrade(orders);

    }

    public static void record(ArrayList<Order> orders) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            br.readLine();
            String str;
            while ((str = br.readLine()) != null) {
                str = str.replaceAll(",", "");
                str = str.replaceAll("]", "");
                String[] arr = str.split(" ");

                int number = Integer.parseInt(arr[0]);
                LocalDateTime dateOfCreate = LocalDateTime.parse(arr[1], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
                LocalDateTime dateOfUpdate = LocalDateTime.parse(arr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
                OrderStatus status = OrderStatus.getStatus(arr[3]);
                orders.add(new Order(number, dateOfCreate, dateOfUpdate, status));

            }
            br.close();
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
    }

    public static void addOrder(ArrayList<Order> orders, Scanner scanner) {
        System.out.println("Введите номер заказа");
        int numberOfOrder = scanner.nextInt();
        if (orders.size() == 0) {
            orders.add(new Order(numberOfOrder, LocalDateTime.now(), LocalDateTime.now(), OrderStatus.NEW));
            System.out.println(orders);
        } else {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getNumberOfOrder() == numberOfOrder) {
                    scanner = new Scanner(System.in);

                    for (OrderStatus status : EnumSet.allOf(OrderStatus.class)) {
                        System.out.println(status);
                    }

                    System.out.println("Введите новый Статус");
                    String newStatus = scanner.nextLine();
                    OrderStatus status = OrderStatus.getStatus(newStatus);
                    if( OrderStatus.getValue(status)< OrderStatus.getValue(orders.get(i).status)){
                        System.out.println("Вы не можете поменять заказ на более ранию стадию его развития");
                        return;
                    }
                    LocalDateTime date = orders.get(i).dateOfCreateOrder;
                    orders.remove(i);
                    orders.add(new Order(numberOfOrder, date, LocalDateTime.now(), OrderStatus.getStatus(newStatus)));
                    System.out.println("Установлен новый статус " + orders.get(i).status);
                    return;
                }
            }
            orders.add(new Order(numberOfOrder, LocalDateTime.now(), LocalDateTime.now(), OrderStatus.NEW));
            System.out.println(orders);


        }


    }

    public static void upgrade(ArrayList<Order> orders) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("file.txt");
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
        pw.println(orders);
        pw.close();
    }


}
