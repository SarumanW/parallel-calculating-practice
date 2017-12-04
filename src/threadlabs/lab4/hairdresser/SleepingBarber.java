package threadlabs.lab4.hairdresser;

public class SleepingBarber {

    public static void main(String[] args) throws InterruptedException {
        BarberShop barberShop = new BarberShop(3);

        Barber barber = new Barber(barberShop);
        CustomerGenerator customerGenerator = new CustomerGenerator(barberShop);

        customerGenerator.start();
        barber.start();

        Thread.sleep(6000);
        customerGenerator.interrupt();
        barber.interrupt();
    }


}
