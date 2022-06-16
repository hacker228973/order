//
//
//
//
//import java.io.*;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.EnumSet;
//import java.util.Scanner;
//
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        ArrayList<Order> orders = new ArrayList();
//        ArrayList<String> data =new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
////        if(br.readLine()==null){
////
////
////        }else{
////            String line=br.readLine();
////            while((line= br.readLine())!=null) {
////                int one = Integer.parseInt (br.readLine());
////                String DateOne=br.readLine();
////                SimpleDateFormat formatter1=new SimpleDateFormat("E MM dd HH:mm:ss GMT+02:00 yyyy");
////                Order newOrder = new Order(one,two,three,four);
////            }br.close();
////
////
////        }
//
//
//
//
//        File file = new File("test.txt");
//        Scanner scanner = new Scanner(System.in);
//
//        addOrder(orders, scanner,file,data);
//        addOrder(orders, scanner,file,data);
//        addOrder(orders, scanner,file,data);
////        addOrder(Order.orders);
//    }
//
//    public static void addOrder(ArrayList<Order> orders, Scanner scanner,File file,ArrayList<String> data) throws FileNotFoundException {
//        System.out.println("Введите номер заказа");
//        int numberOfOrder = scanner.nextInt();
//        if (orders.size() == 0) {
//            Order newOrder = new Order(numberOfOrder, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), OrderStatus.NEW);
//            orders.add(newOrder);
//            System.out.println("Добавлено");
//
//            PrintWriter pw =new PrintWriter(file);
//            String str;
//            str="\n"+numberOfOrder;
//            str=str.replaceAll(",","");
//            str=str.replaceAll("]","");
//            data.add(str);
//            str="\n"+new Date(System.currentTimeMillis());
//            str=str.replaceAll(",","");
//            str=str.replaceAll("]","");
//            data.add(str);
//            str="\n"+new Date(System.currentTimeMillis());
//            str=str.replaceAll(",","");
//            str=str.replaceAll("]","");
//            data.add(str);
//            str="\n"+OrderStatus.NEW;
//            str=str.replaceAll(",","");
//            str=str.replaceAll("]","");
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
//                }
//                else{
//                    Order newOrder = new Order(numberOfOrder, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), OrderStatus.NEW);
//                    orders.add(newOrder);
//                    System.out.println("Добавлено");
//
//                    PrintWriter pw =new PrintWriter(file);
//                    String str;
//
//                    str="\n"+numberOfOrder;
//                    str=str.replaceAll(",","");
//                    str=str.replaceAll("]","");
//                    data.add(str);
//
//                    str="\n"+new Date(System.currentTimeMillis());
//                    str=str.replaceAll(",","");
//                    str=str.replaceAll("]","");
//                    data.add(str);
//
//                    str="\n"+new Date(System.currentTimeMillis());
//                    str=str.replaceAll(",","");
//                    str=str.replaceAll("]","");
//                    data.add(str);
//
//                    str="\n"+OrderStatus.NEW;
//                    str=str.replaceAll(",","");
//                    str=str.replaceAll("]","");
//                    data.add(str);
//
//                    pw.println(data);
//                    System.out.println(data);
//                    pw.close();
//                    break;
//                }
//            }
//
////        else if (orders.get(numberOfOrder) == null) {
////            for (OrderStatus info : EnumSet.allOf(OrderStatus.class)) {
////                System.out.println(info);
////            }
////        }
//
//        }
//    }
//}
