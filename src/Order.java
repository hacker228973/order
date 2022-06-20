import java.time.LocalDateTime;



public class Order {


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
        public int getNumberOfOrder(){
            return numberOfOrder;
        }

    }

