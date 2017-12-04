package threadlabs.lab4.hairdresser;

public class Barber extends Thread {
    BarberShop barberShop;

    public Barber(BarberShop barberShop){
        this.barberShop = barberShop;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            barberShop.cut();

        }
    }
}
