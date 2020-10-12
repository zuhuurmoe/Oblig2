package no.oslomet.cs.algdat;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //Oppgave 1
        // Tester antall() og tom()
        Liste<String>liste1 = new DobbeltLenketListe<>();
        System.out.println(liste1.antall()+" "+liste1.tom());

        String [] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste2 = new DobbeltLenketListe<>(s);
        System.out.println(liste2.antall( ) + " " + liste2.tom( ));


        String[] s1 = {};
        String [] s2 = {"A"};
        String [] s3 = {null, " A", null, "B", null};

        //Oppgave 2
        // a) Tester toString() og omvendtString()
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() +" "+ l2.toString() +" " + l3.toString() +" " + l1.omvendtString() + " "
                + l2.omvendtString() +" " + l3.omvendtString());

        // b) Tester boolean leggInn()
        DobbeltLenketListe<Integer>liste3 = new DobbeltLenketListe<>();
        System.out.println(liste3.toString()+" "+liste3.omvendtString());

        for(int i = 1; i<=3; i++) {
            System.out.println(liste3.leggInn(i));
            System.out.println(liste3.toString() + " " + liste3.omvendtString());
        }

        //3b
        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);

        System.out.println(liste.subliste(3,8)); // [D, E, F, G, H]
        System.out.println(liste.subliste(5,5)); // []
        //System.out.println(liste.subliste(8,liste.antall())); ​// [I, J]
        System.out.println(liste.subliste(0,11)); // skal kaste unntak

        /////Oppgave 9
        DobbeltLenketListe<String> liste9 = new DobbeltLenketListe<>(new String []{"Birger" , "Lars" , "Anders" , "Bodil" , "Kari" , "Per" , "Berit"});
        liste9.fjernHvis(n -> n.charAt(0) == 'B'); // Fjerner navn som starter på B
        System.out.println("Oppgave 9: " + liste9 + " " + liste9.omvendtString());

        liste9.fjernHvis(n -> n.toLowerCase().contains("e")); //fjerner navn som starter på E
        System.out.println("Oppgave 9: " + liste9 + " " + liste9.omvendtString());

        //////Oppgave 10
        System.out.println(" // 10 // ");
        String [] navn = {"Lars" , "Anders" , "Bodil" , "Kari" , "Per" , "Berit"};
        Liste<String> liste10 = new DobbeltLenketListe<>(navn);
        DobbeltLenketListe.sorter(liste10, Comparator.naturalOrder());

    }
}
