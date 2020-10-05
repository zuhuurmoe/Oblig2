package no.oslomet.cs.algdat;

public class Main {
    public static void main(String[] args) {
        Liste<String>liste1 = new DobbeltLenketListe<>();
        System.out.println(liste1.antall()+" "+liste1.tom());

        String [] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste2 = new DobbeltLenketListe<>(s);
        System.out.println(liste2.antall( ) + " " + liste2.tom( ));
    }
}
