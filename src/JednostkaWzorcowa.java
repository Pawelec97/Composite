public abstract class JednostkaWzorcowa {

    public JednostkaWzorcowa(String nazwa){
        this.nazwa = nazwa;
    }

    protected String nazwa;
    protected String typ;
    protected JednostkaWzorcowa parrent = null;

    public abstract String path();
}
