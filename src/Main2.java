
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    static String file = "file.txt";

    public static void main(String[] args) {
        ArrayList<Order> orders;
        orders = readOrdersFromFile();
        System.out.println(orders);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер заказа");
            String strNumberOfOrder = scanner.nextLine();
            if (Objects.equals(strNumberOfOrder, "exit")) {
                break;
            }
            addOrderInFile(orders, strNumberOfOrder);
        }

        writingOrdersToTheFile(orders);

    }

    public static ArrayList<Order> readOrdersFromFile() {
        ArrayList<Order> newOrders = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
                newOrders.add(new Order(number, dateOfCreate, dateOfUpdate, status));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return newOrders;
    }


    public static void findOrderIndex(ArrayList<Order> orders, int numberOfOrder) {
        Scanner scanner = new Scanner(System.in);
        if (orders.size() != 0) {
            for (Order order : orders) {
                if (order.getNumberOfOrder() == numberOfOrder) {

                    for (OrderStatus status : EnumSet.allOf(OrderStatus.class)) {
                        System.out.println(status);
                    }

                    System.out.println("Введите новый Статус");
                    String newStatus = scanner.nextLine();
                    OrderStatus status = OrderStatus.getStatus(newStatus);
                    if (OrderStatus.getValue(status) < OrderStatus.getValue(order.status)) {
                        writingOrdersToTheFile(orders);
                        throw new IllegalArgumentException("Вы не можете поменять заказ на более ранию стадию его развития");
                    }
                    order.status = status;
                    System.out.println(orders);
                    return;
                }
            }

        }
        orders.add(new Order(numberOfOrder, LocalDateTime.now(), LocalDateTime.now(), OrderStatus.NEW));
        System.out.println(orders);
    }

    public static void addOrderInFile(ArrayList<Order> orders, String strNumberOfOrder) {

        int numberOfOrder = Integer.parseInt(strNumberOfOrder);
        findOrderIndex(orders, numberOfOrder);


    }

    public static void writingOrdersToTheFile(ArrayList<Order> orders) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
        assert pw != null;
        pw.println(orders);
        pw.close();
    }


}
