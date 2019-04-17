public class Plik extends JednostkaWzorcowa {

    public Plik(String nazwa){
        super(nazwa);
        super.typ = "plik";
    }

    @Override
    public String path() {
        return parrent.path() + "/" + nazwa;

    }


}
