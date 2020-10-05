package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


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
        throw new UnsupportedOperationException();
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
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        if(tom()){
            return "[]";
        }
        else{
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

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


