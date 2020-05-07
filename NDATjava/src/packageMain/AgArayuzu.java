package packageMain;

public class AgArayuzu implements IAgArayuzu,IDatabase
{
    IMerkeziIslemBirimi mib;
    IDatabase database;
    private AgArayuzu(){
        mib=new MerkeziIslemBirimi();
        database=new Database();
    }
    private static AgArayuzu instance = new AgArayuzu();
    public static  AgArayuzu getInstance()
    {
        return instance;
    }
    @Override
    public void sogutucuKapat() {
        mib.calistir("kapat");
    }

    @Override
    public void sogutucuAc() {
        mib.calistir("ac");
    }

    @Override
    public void sicaklikGoruntule() {
        mib.calistir("sicaklik");
    }

    @Override
    public boolean kullaniciKontrol(String kullaniciadi, String sifre) {
        return database.kullaniciKontrol(kullaniciadi,sifre);
    }

    @Override
    public String Kullaniciekle(String kullaniciadi, String sifre) {
        return Kullaniciekle(kullaniciadi,sifre);
    }
}