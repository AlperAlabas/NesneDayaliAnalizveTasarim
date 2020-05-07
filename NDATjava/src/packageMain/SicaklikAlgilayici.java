package packageMain;

import java.util.Random;

public class SicaklikAlgilayici extends Observer implements ISicaklikAlgilayici
{
    private int sicaklik;

    @Override
    public void observer(MerkeziIslemBirimi mibe)
    {
        this.mib = mibe;
        this.mib.attach(this);
    }
    private SicaklikAlgilayici(){


    }
    private static SicaklikAlgilayici instance = new SicaklikAlgilayici();
    public static  SicaklikAlgilayici getInstance()
    {
        return  instance;
    }


    @Override
    public void update() {
        this.sicaklik=this.mib.getSicaklik();
    }



    @Override
    public int  sicaklikOku()
    {
        Random rand=new Random();

        sicaklik=rand.nextInt(100);

        System.out.println("Sıcaklık: "+sicaklik);
        return sicaklik;
    }



}

