package no.oslomet.cs.algdat;

public class Main {
    public static void main(String[] args) {
        Liste<String>liste1 = new DobbeltLenketListe<>();
        System.out.println(liste1.antall()+" "+liste1.tom());

        String [] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste2 = new DobbeltLenketListe<>(s);
        System.out.println(liste2.antall( ) + " " + liste2.tom( ));


        String[] s1 = {};
        String [] s2 = {"A"};
        String [] s3 = {null, " A", null, "B", null};

        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() +" "+ l2.toString() +" " + l3.toString() +" " + l1.omvendtString() + " "
                + l2.omvendtString() +" " + l3.omvendtString());
    }
}
