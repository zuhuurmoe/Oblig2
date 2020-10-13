# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 

# Krav til innlevering

Se oblig-tekst for alle krav. Oppgaver som ikke oppfyller følgende vil ikke få godkjent:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* Ingen debug-utskrifter
* Alle testene som kreves fungerer (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet

# Arbeidsfordeling

Oppgaven er levert av følgende studenter:
* Hifsah Khan, s344235, S344235@oslomet.no
* Hava,s344182, S344182@oslomet.no
* Cynthia Muljono, s309641, S309641@oslomet.no
* Zuhuur Mohammed, s344095, S344095@oslomet.no

Vi har brukt git til å dokumentere arbeidet vårt. Vi har 16 commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Hifsah har hatt hovedansvar for oppgave 1, 2, og 3. 
* Hava har hatt hovedansvar for oppgave 0, 4, og 5. 
* Zuhuur har hatt hovedansvar for oppgave 6, 7 og 8. 
* Cynthia har i hatt hovedansvar for oppgave 9 og 10. 

# Beskrivelse av oppgaveløsning (maks 5 linjer per oppgave)

* Oppgave 1: Løste denne oppgaven ved å implementere metodene antall() og tom(). Antall() returnerer antall verdier i en liste, mens tom()
 returnerer true om listen er tom og false om den ikke er det. Deretter lagde jeg DobbeltLenketListe(T[] a). Her sjekkes det først om 
 det er null verdier i listen. Hvis det ikke er det settes hode til den første verdien i listen, og hale til den siste. Hvis det er kun en verdi
 i listen settes hode og hale til samme verdi. Forrige og neste verdi genereres med neste peker og  forrige peker.
* Oppgave 2: I denne oppgaven ble toString() og omvendtString() implementert. toString() sjekker om listen er tom først. Dersom den ikke er det går
 den gjennom listen sine verdier og formatterer dem slik det er bedt om. StringBuilder benyttes for å utføre denne oppgaven. omvendtString() gjør det
  samme, men motsatt vei i listen. leggInn(T verdi) sjekker for null-verdier. Dersom det ikke er null-verdier oppretter den en ny node som legger inn den nye
  noden etter at det sjekkes om listen er tom på forhånd eller ikke. 
* Oppgave 3: Oppgaven ble løst ved å implementere metoden finnNode(int indeks) som avhengig av indeksen avgjør hvor letingen
skal begynne (fra hode eller hale). hent(int indeks) ble implementert ved å bruke finnNode() til å finne verdien til en node på en spesifikk plass. oppdater(int indeks, T nyverdi) gir
 en node ny verdi, og returnerer den gamle verdier. fratilKontroll() ble deretter lagd for å sjekke om verdiene som legges inn i intervallet er gyldige.
 Til slutt ble subliste(int fra, int til) implementert. Metoden returnerer en liste med verdiene i intervallet.
* Oppgave 6: Metoden sjekker om at listen ikke er tom. Brukte fjernNode som hjelpemetode for å finne ut om verdien er like hode
  hale og flytter forrige og neste pekere, og returnerer til slutt verdien til noden 
  som slettes. i fjern metoden brukes det en for-løkke for å løpe gjennom listen og finne verdein til noden. I fjern(int indeks) kontrolleres parameteret først, 
  deretter bruker finnNode (hjelpemetoden) til å finne noden som skal fjernes.
* Oppgave 7: Måte 1 er raskere, fordi i for løkken starter vi å loope gjennom listen og det tar lengre tid å klasse på metoden så mange ganger.
  I metode 2 setter vi startposisjonen lik 1. I metode 1 settes bådde hode og hale lik 0, antall til 0 og endringer økes
  med 1. Implementeringen i denne oppgaven var ganske "enkel".
* Oppgave 8: Følgte oppgavetesten, sjekker om iteratorendringer er lik endringer. Hvis ikke hasNext() er true kaster vi en 
  NoSuchElementException. Lagde en iterator metode, returnerer en ny dobbelenkelisteiterato(). Til slutt returnere en ny dobbelenklisteiterator 
  med samme index, dette hadde vi glemt første gangen vi løste oppgaven og det kom feilmeldinger opp. Men nå er det løst.
* Oppgave 9: Til å begynne med, starter metoden å sjekke om listen har noe innhold og om iteratorendringer er lik endringene.
  Videre, vil remove-metoden slette noden ("denne") ved å ta hensyn til punktene skrevet i oppgaveteksten. 
* Oppgave 10: Sortere ved hjelp av et array. 
