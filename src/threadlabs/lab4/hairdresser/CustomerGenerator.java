package threadlabs.lab4.hairdresser;

public class CustomerGenerator extends Thread{
    BarberShop barberShop;
    public int count = 1;

    public CustomerGenerator(BarberShop barberShop){
        this.barberShop = barberShop;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            Customer customer = new Customer(barberShop, "Customer" + count);
            customer.start();
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception(");
            }
        }
    }

}
