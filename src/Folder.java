import java.util.ArrayList;
import java.util.List;

public class Folder extends JednostkaWzorcowa {
    public Folder(String nazwa){
        super(nazwa);
        super.typ= "folder";
    }
    List<JednostkaWzorcowa> lista = new ArrayList();

    @Override
    public String path() {
        if(parrent != null)
            return parrent.path() + "\\" + nazwa;
        else
            return nazwa;
    }

    public void dodaj(JednostkaWzorcowa nowy){
        lista.add(nowy);
        nowy.parrent = this;
    }
    public void zawartosc(){
        for(JednostkaWzorcowa j: lista){
            System.out.println(j.nazwa + "  " +j.typ);
        }
    }
    public JednostkaWzorcowa sprawdzNazwe(String nazwa){
        for(JednostkaWzorcowa j : lista){
            if(nazwa.equals(j.nazwa) && j.typ.equals("folder")) return j;
        }
        return null;
    }
}
