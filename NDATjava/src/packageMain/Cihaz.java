package packageMain;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cihaz extends MerkeziIslemBirimi
{
    AgArayuzu arayuzu=AgArayuzu.getInstance();

    private int input;
    private int beforeInput=0;
    public void kapali()
    {
        super.eyleyici.setState("kapali");
        Scanner scan=new Scanner(System.in);
        do {
            System.out.println("Kapalı!");
            System.out.println("******************************");
            System.out.println("Cihazı açmak icin '1' tuşuna basin");
            input=scan.nextInt();
        }while(input!=1);
        bekleme();
    }
    public void bekleme()
    {

        Scanner scan=new Scanner(System.in);
        System.out.println("İslem bekleniyor.");
        System.out.println("******************************");
        System.out.println("|1|Sıcaklık görüntüle.");
        System.out.println("|2|Soğutucuyu aç.");
        System.out.println("|3|Soğutucuyu kapat.");
        System.out.println("|4|Cihazı kapat.");
        System.out.println("Seçim yapınız");
        input=scan.nextInt();
        kontrol(input);
    }
    public void algilama()
    {
        if (input==1)
        {
            arayuzu.sicaklikGoruntule();
            bekleme();
        }
        if (input==2)
        {
            arayuzu.sogutucuAc();
            bekleme();

        }
        if (input==3) {
            arayuzu.sogutucuKapat();
            bekleme();
        }
        if (input==4) {

            kapali();

        }

    }
    public void kontrol(int input) {
        if (input == 2 && super.eyleyici.getState() == "acik") {
            System.out.println("Zaten açık");
            bekleme();
        }
        if (input == 3 & super.eyleyici.getState() == "kapali") {
            System.out.println("Zaten kapali");
            bekleme();
        }
        if (input == 2 && super.eyleyici.getState() == "kapali") {
            super.eyleyici.setState("acik");
            algilama();
        }
        if (input == 3 & super.eyleyici.getState() == "acik") {
            super.eyleyici.setState("kapali");
            algilama();
        }else {
            beforeInput=input;
            algilama();
        }
    }
}
