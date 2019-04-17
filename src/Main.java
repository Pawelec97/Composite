import java.util.Scanner;

public class Main {

 /*   Z punktu widzenia systemu plików systemu operacyjnego, zapis dotyczący samego pliku jak i folderu (katalogu) jest dość podobny. Plik oraz katalog mają swoją nazwę, przy listowaniu zawartości dysku takie nazwy są wypisywane, niezależnie od tego, czy mamy doczynienia z plikiem czy folderem, przy czym nazwy folderów są w pewien sposób wyróżniane (proszę sprawdzić zlecenia listowania zawartości dysku/folderów w swoim ulubionym systemie operacyjnym). Foldery mogą zawierać w sobie pliki i/lub podfoldery. W analogiczny sposób można potraktować dysk, który ma swój literowy identyfikator oraz nazwę. Proszę zidentyfikować prosty wzorzec projektowy pozwalający na opisanie powyższych zależności oraz, z wykorzystaniem tego wzorca, napisać program pozwalający na:

    Założenie hipotetycznego systemu plików, struktura może być zdefiniowana sztywno w programie (zapisana w kodzie). Proszę programowo zbudować przykładową strukturę.
            Symulowanie „linii poleceń” — program ma pozwalać użytkownikowi na sprowadzanie poleceń typu dir, cd .., cd <nazwa podkatalogu>. A zatem użytkownik może poruszać się po zdefiniowanej strukturze dysku, mając możliwość przeglądania zawartości odwiedzanych katalogów. Zakładamy, że na starcie katalogiem domyślnym jest główny katalog symulowanego systemu plików.*/

    public static void main(String[] args) {
        System.out.println("Symulator terminalu Windowsa autor Paweł Wiśniewski");
        System.out.println("Lista komend: cd , cd.. , dir , cd <nazwa katalogu>");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String komenda;  // nasz String w którym zapisuje sie wpisana komenda
        Folder katalogDysku = new Folder("D:"); // tworze folder katologu dysku
        Folder otwarty = katalogDysku; // ustalam folder otwarty na początku działania

        Folder pierwszy = new Folder("System"); // tworze pierwszy folder
        Folder drugi = new Folder("Pliki programów"); // tworze drugi folder

        katalogDysku.dodaj(drugi); // dodaje drugi folder do pierwszego
        katalogDysku.dodaj(pierwszy); //dodaje pierwszy folder do katalogu dysku


        Plik plik1 = new Plik("Ważny Plik");
        Plik plik2 = new Plik("metin2.exe");
        katalogDysku.dodaj(plik1);
        katalogDysku.dodaj(plik2);

        do {
            System.out.print(otwarty.path() + ">");
            komenda = scan.nextLine();


            //System.out.println(komenda);

            if (komenda.equals("dir") || komenda.equals("DIR")) otwarty.zawartosc();
            else if (komenda.equals("cd")) otwarty.path();
            else if (komenda.equals(("cd.."))){
                if(otwarty.parrent != null)
                        otwarty = (Folder) otwarty.parrent;
            }
            else if (komenda.matches("(cd [a-zA-Z]+)")) {
                komenda = komenda.substring(3, komenda.length());
                JednostkaWzorcowa nowy = otwarty.sprawdzNazwe(komenda);
                if (nowy != null) otwarty = (Folder) nowy;
                else System.out.println("System nie może znaleźć okreslonej ścieżki");
            }



            System.out.println();

        }while(!(komenda.equals("exit")));
    }
}
