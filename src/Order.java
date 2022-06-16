import java.time.LocalDateTime;
import java.util.*;


public class Order {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        OrderStatus status;
        int numberOfOrder;
        LocalDateTime dateOfCreateOrder;
        LocalDateTime dateOfOrderUpdate;

        public Order(int numberOfOrder,LocalDateTime dateOfCreateOrder,LocalDateTime dateOfOrderUpdate,OrderStatus status) {
            this.numberOfOrder = numberOfOrder;
            this.dateOfCreateOrder=dateOfCreateOrder;
            this.dateOfOrderUpdate=dateOfOrderUpdate;
            this.status=status;
        }




        @Override
        public String toString() {
            return "\n" + numberOfOrder + " " + dateOfCreateOrder + " " + dateOfOrderUpdate + " "+status;
        }
    public int hashCode() {
        return (int) numberOfOrder * dateOfCreateOrder.hashCode() * dateOfOrderUpdate.hashCode() * status.hashCode();
    }
        public int getNumberOfOrder(){
            return numberOfOrder;
        }
    }

