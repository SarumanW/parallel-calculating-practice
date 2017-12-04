package threadlabs.lab4.hairdresser;

public class Customer extends Thread {
    private String name;
    BarberShop barberShop;

    public Customer(BarberShop barberShop, String name){
        this.name = name;
        this.barberShop = barberShop;
    }


    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String name) {
        this.name = name;
    }

    private synchronized void goCut(){
        barberShop.add(this);
    }

    @Override
    public void run(){
        goCut();
    }
}
