package no.oslomet.cs.algdat;

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
    }
}
