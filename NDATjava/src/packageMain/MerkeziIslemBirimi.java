package packageMain;


import java.util.ArrayList;
import java.util.List;

public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    IEyleyici eyleyici;
    ISicaklikAlgilayici sicalikAlgilayici;
    private List<Observer> observers = new ArrayList<Observer>();
    private int sicaklik;


    public  MerkeziIslemBirimi(){
       eyleyici=Eyleyici.getInstance();
       eyleyici.observer(this);
       sicalikAlgilayici=SicaklikAlgilayici.getInstance();
       sicalikAlgilayici.observer(this);
    }





    public int getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void calistir(String islem) {
        if (islem=="kapat")
        {
            eyleyici.sogutucuKapat();
            notifyAllObservers();
        }
        if (islem=="ac")
        {
            eyleyici.sogutucuAc();
            notifyAllObservers();
        }
        if (islem=="sicaklik")
        {

            this.setSicaklik(sicalikAlgilayici.sicaklikOku());

            notifyAllObservers();
        }

    }
}
