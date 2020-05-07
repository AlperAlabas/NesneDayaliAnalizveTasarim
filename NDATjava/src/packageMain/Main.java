package packageMain;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        int sayac=0;
        boolean durum;
        do {
            if(sayac!=0)
            {
                String ad=scan.nextLine();
            }
            System.out.println("kullanici adi:");
            String ad=scan.nextLine();
            System.out.println(" ");
            System.out.println("Şifre: ");
            String sifre=scan.nextLine();
            Database db=new Database();
            durum=db.kullaniciKontrol(ad,sifre);
            sayac++;
        }while (durum==false);

        if (durum==true) {
            Cihaz cihaz = new Cihaz();
            cihaz.kapali();
        }





    }
}
