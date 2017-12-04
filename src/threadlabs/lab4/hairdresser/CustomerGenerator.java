package threadlabs.lab4.hairdresser;

public class CustomerGenerator extends Thread{
    BarberShop barberShop;
    private int count = 0;

    public CustomerGenerator(BarberShop barberShop){
        this.barberShop = barberShop;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            Customer customer = new Customer(barberShop, "Customer" + count);
            customer.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}
