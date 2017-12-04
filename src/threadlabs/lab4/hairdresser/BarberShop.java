package threadlabs.lab4.hairdresser;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BarberShop {
    private int size;
    private List<Customer> customerList;

    public BarberShop(int n){
        size = n;
        customerList = new LinkedList<>();
    }

    public void add(Customer customer){
        System.out.println("Customer : " + customer.getCustomerName() + " entering the shop");

        synchronized (customerList){
            if(customerList.size() == size){
                System.out.println("No chair available for customer : " + customer.getCustomerName());
                return;
            }

            customerList.add(customer);
            System.out.println("Customer : " + customer.getCustomerName() + " got the chair");

            if(customerList.size() == 1){
                customerList.notify();
            }
        }
    }

    public void cut(){
        Customer customer;

        synchronized (customerList){
            while(customerList.size() == 0){
                System.out.println("Barber is sleeping");
                try {
                    customerList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Barber found a customer in waiting room");
            customer = customerList.get(0);
            customerList.remove(0);
        }

        try {
            System.out.println("Cutting hair of Customer : " + customer.getCustomerName());
            long duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Haircut for Customer : " + customer.getCustomerName() + " is completed");
    }

}
