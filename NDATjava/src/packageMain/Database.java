package packageMain;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database implements IDatabase
{
    private String nick;
    private String pass;
    private boolean control;
    private String mesaj;
    public Database()
    {
        nick=" ";
        pass=" ";
        control=false;
        mesaj="kullanici eklendi";
    }

    @Override
    public String Kullaniciekle(String kullaniciadi, String sifre)
    {

        try{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cihaz","postgres","gUGUK0954");
            if (con!=null)
            {
                System.out.println("Veritabanına bağlandı!");
            }
            else
                System.out.println("Bağlantı girişimi başarısız!");


            String sql= "insert into\"Kullanicilar\" values("+kullaniciadi+","+sifre+")";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);


            stmt.close();
            con.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return mesaj;
    }

    public boolean kullaniciKontrol(String nickname, String sifre)
    {
        String isim=nickname;
        String passo=sifre;
        try{
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cihaz","postgres","gUGUK0954");
            if (con!=null)
            {
                System.out.println("Veritabanına bağlandı!");
            }
            else
                System.out.println("Bağlantı girişimi başarısız!");


            String sql= "select * from \"Kullanicilar\"where kullaniciadi='"+nickname+"' and sifre='"+sifre+"'";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {

                    control=true;



            }
            if (control==true)
            {
                System.out.println("kullanici bulundu");

            }
            else
            {
                System.out.println("kullanici bulunamadi");

            }

            rs.close();
            stmt.close();
            con.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return control;
    }
}

