package no.oslomet.cs.algdat;


// class DobbeltLenketListe

//Hifsah Khan, s344235, S344235@oslomet.no
//Hava,s344182, S344182@oslomet.no
//Cynthia Muljono, s309641, S309641@oslomet.no
//Zuhuur Mohammed, s344095, S344095@oslomet.no

import jdk.jshell.spi.ExecutionControl;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;



 public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen


    public DobbeltLenketListe() {
        this.hode = null;
        this.hale = null;
        this.antall = 0;
        this.endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a);
        if(a==null){
            throw new NullPointerException("Ingen verdier i tabellen");
        }
        int indeks = 0;

        if(a.length>0){
            for(; indeks<a.length; indeks++){
                if(a[indeks]!=null){
                    hode = new Node<>(a[indeks]);

                    antall++;
                    endringer++;

                    break;
                }
            }
            hale = hode;
            if(hode!=null){
                indeks++;

                for (; indeks<a.length; indeks++){
                    if(a[indeks]!=null){
                        hale.neste = new Node(a[indeks], hale, null);
                        hale = hale.neste;

                        antall++;
                        endringer++;
                    }
                }
            }
        }
    }

    public Liste<T> subliste(int fra, int til){
        endringer=0;
        fratilKontroll(antall, fra, til);
        int elementer = til-fra;

        Liste<T> nyListe = new DobbeltLenketListe<>();
        if(elementer<1){
            return nyListe;
        }
        Node<T> thisNode = finnNode(fra);
        while(elementer>0){
            nyListe.leggInn(thisNode.verdi);
            thisNode=thisNode.neste;
            elementer--;
        }
        return nyListe;

    }

    @Override
    public int antall() { //returnerer antall verdier i listen
        return antall;
    }

    @Override
    public boolean tom() { //returnerer om listen er tom
        if(hode==null && hale==null){
            if(antall==0){
               return true;
            }
        }
        return false;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi);
        if(verdi==null){
            throw new NullPointerException("Null-verdi er ikke gyldig");
        }
        else{
            Node<T> node = new Node<>(verdi);

            // Tilfelle 1: at listen er tom på forhånd
            if(tom()){
                hode = node;
                hale = hode;
                endringer++;
                antall++;

                return true;
            }
            // Tilfelle 2: at listen ikke er tom
            else {
                hale.neste = node;
                node.forrige = hale;
                hale = node;
                endringer++;
                antall++;

                return true;
            }
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) { //oppg 5
        Objects.requireNonNull(verdi, "Tillatter ikke null-verdier");

        indeksKontroll(indeks, true);

        if (tom())
        {
            hode = hale = new Node<>(verdi, null, null);
        }
        else if (indeks == 0)
        {
            hode = hode.forrige = new Node<>(verdi, null, hode);
        }
        else if (indeks == antall)
        {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        else
        {
            Node<T> p = finnNode(indeks);
            p.forrige = p.forrige.neste = new Node<>(verdi, p.forrige, p);
        }

        antall++;
        endringer++;



    }

    @Override
    public boolean inneholder(T verdi) { //oppg 4
        if (indeksTil(verdi) > -1) {
            return true;
        } else if (indeksTil(verdi) < 0){
            return false;
        }

        throw new UnsupportedOperationException();
    }



    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        Node<T> node = finnNode(indeks);
        return node.verdi;
    }

    @Override
    public int indeksTil(T verdi) {

        Node<T> temp = hode;
        for(int i=0; i<antall;i++){
            if(temp.verdi.equals(verdi)){
                return i;
            }
            temp = temp.neste;

        }
        return -1;


    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "Null-verdier er ugyldig");
        indeksKontroll(indeks, false);

        Node<T> node = finnNode(indeks);
        T gammelVerdi = node.verdi;
        endringer++;
        node.verdi= nyverdi;

        return gammelVerdi;
    }
    //Hjelpemetode
    private T fjernNode(Node<T> p)
    {
        //første node
        if (p == hode)
        {
            //sjekker om listen har kun 1 node
            if(antall == 1)
            hode = hale= null;

            else (hode = hode.neste).forrige = null;
        }
        //siste node
        else if(p == hale)
        (hale = hale.forrige).neste = null;

        else (p.forrige.neste = p.neste).forrige = p.forrige;

        antall --;       //antall reduserer
        endringer++;    //endringer oker

        return p.verdi;
    }
     //Hjelpemetode
     private Node <T> finnNode(int indeks){
         Node <T> currentNode;
         if(indeks < (antall/2)){
             currentNode = hode;
             for(int i = 0; i < indeks; i++){
                 currentNode = currentNode.neste;
             }
             return currentNode;
         }
         else{
             currentNode = hale;
             for(int i = antall -1; i > indeks; i--){
                 currentNode = currentNode.forrige;
             }
         }
         return currentNode;
     }
    @Override
    //oppgave 6
    public boolean fjern(T verdi) {
        if (verdi == null)
            return false;       // Fjerner en eventuell null-verdi

        for (Node<T> node = hode; node !=null; node = node.neste){ //løper over hele listen - finne verdien - løkke

            if (node.verdi.equals(verdi)){ //hvis vi finner verdien fjernes den ved hjelp av hjelpemetode - fjerNode

                fjernNode(node); //hjelpemetode
                return true;
            }
        }
        return false; //Hvis verdien ikke er i listen - false
    }



    @Override
    public T fjern(int indeks) {
        //Parameter Kontroll - lovelig verdier
        indeksKontroll(indeks, false);

        return fjernNode(finnNode(indeks)); //bruker finnNode for å finne posisjoene til noden

    }


     //oppgave 7
    @Override
    public void nullstill() {
        //Maate 1 (raskere)
        hode = hale = null;
        antall = 0;
        endringer ++;

        //Maate 2
        for (int i = 1; i < antall; i++){
            hode.verdi = null;
            hode.forrige = null;
            hode = hode.neste;
        }
    }


    @Override
    public String toString() {
        if(tom()){
            return "[]";
        }
            Node<T> currentNode = hode;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(currentNode.verdi);
            currentNode = currentNode.neste;

            while(currentNode!=null){
                sb.append(", ");
                sb.append(currentNode.verdi);
                currentNode = currentNode.neste;
            }
            sb.append("]");
            return sb.toString();

    }

    public String omvendtString() { //samme som toString metoden, bare at vi begynner på halen og jobber mot hodet
        if(tom()){
            return "[]";
        }
        else{
            Node<T> currentNode = hale;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(currentNode.verdi);
            currentNode = currentNode.forrige;

            while(currentNode!=null){
                sb.append(", ");
                sb.append(currentNode.verdi);
                currentNode = currentNode.forrige;
            }
            sb.append("]");
            return sb.toString();
        }

    }

    //oppgave 8
    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        //Paramter kontroll - sjekker som indeks er lovelig
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            denne = finnNode(indeks);           //noden som hører til den oppgitte indeksen
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }


        @Override
        public T next(){
            //sjekker om iterasjonsendringer er lik endringer
            if (endringer != iteratorendringer)
                throw new ConcurrentModificationException("Ikke endret riktig");
            //sjekker om det er flere verdier
            if(!hasNext())
                throw new NoSuchElementException("Ingen flere verdier i listen");

            fjernOK = true;

            T tempVerdi = denne.verdi;
            denne = denne.neste;
            return tempVerdi;

        }

        /// Opgave 9
        @Override
        public void remove(){
            if(!fjernOK)throw new UnsupportedOperationException("Ikke lov å fjerne en verdi");
            if(iteratorendringer != endringer) throw new ConcurrentModificationException("Listen er endret");

            fjernOK = false; //setter false

            if(antall == 1) {
                hode = hale = null;
            } else if(denne == null){
                hale = hale.forrige;
                hale.neste = null;
            } else if(denne.forrige == hode){
                hode = hode.neste;
                hode.forrige=null;
            } else {
               Node<T> node = denne.forrige;
               node.forrige.neste = denne;
               node.neste.forrige= node.forrige;
               node = null;
            }

            iteratorendringer++;
            endringer++;
            antall--;


        }

    } // class DobbeltLenketListeIterator

     // Oppgave 10
     public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
         throw new UnsupportedOperationException();
     }


    public static void fratilKontroll(int antall, int fra, int til){
        if(til>antall){
            throw new IndexOutOfBoundsException("Ugyldig intervall");
        }
        if(fra<0){
            throw new IndexOutOfBoundsException("Ugyldig intervall");
        }
        if(fra>til){
            throw new IllegalArgumentException("Ugyldig intervall");
        }
    }
} // class DobbeltLenketListe




