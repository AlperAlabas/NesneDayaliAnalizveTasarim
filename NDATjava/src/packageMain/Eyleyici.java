package packageMain;

import java.io.IOException;

public class Eyleyici extends Observer implements IEyleyici
{
    private String state;
    private int sicaklik;


    private Eyleyici(){

    }

    private static Eyleyici instance = new Eyleyici();
    public static  Eyleyici getInstance()
    {

        return instance;
    }

    @Override
    public void observer(MerkeziIslemBirimi mibe) {
        this.mib = mibe;
        this.mib.attach(this);
    }

    @Override
    public void update() {
        this.sicaklik=this.mib.getSicaklik();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void sogutucuAc() {

        System.out.println("Soğutucuyu açılıyor.");
        if (this.sicaklik>25)
        {
            while (sicaklik!=25) {

                System.out.println("sicaklik: "+sicaklik);
                sicaklik--;
            }

        }
        if (this.sicaklik<25)
        {
            while (sicaklik!=25) {

                System.out.println("sicaklik: "+sicaklik);
                sicaklik++;
            }

        }

    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Soğutucuyu kapanıyor.");

    }
}

