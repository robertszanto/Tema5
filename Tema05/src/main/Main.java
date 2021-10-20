package main;

import basic.Persoana;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Vom construi array-uri separate pentru proprietatile necesare realizarii a 5 Persoane
        //TODO 1: Definiti un array de Stringuri numit "prenume"
        String[] prenume = new String[5];
        //TODO 2: Alocati memorie pentru 5 stringuri

        //TODO 3: Initializati valorile cu 5 prenume la alegere
        prenume[0] = "Ana";
        prenume[1] = "Adi";
        prenume[2] = "Edi";
        prenume[3] = "Lili";
        prenume[4] = "Rex";

        //TODO 4: Definiti un array de Stringuri numit "nume" si alocati memorie pentru 5 stringuri
        String nume[] = new String[5];
        //TODO 5: Initializati valorile cu 5 nume de familie la alegere
        nume[0] = "Baciu";
        nume[1] = "Stanciu";
        nume[2] = "Voda";
        nume[3] = "Todor";
        nume[4] = "Crainic";

        //TODO 6: Definiti un array de valori intregi numit "varste" si initializati valorile cu 5 varste corespondente numelor
        int[] varste = new int[5];
        varste [0] = 18;
        varste [1] = 19;
        varste [2] = 20;
        varste [3] = 21;
        varste [4] = 22;

        //TODO 6: Definiti un array de Stringuri numit "orase" si initializati valorile cu 5 nume de orase (nu neaparat unice)
        String [] orase = new String[5];
        orase [0] = "Brasov";
        orase [1] = "Galati";
        orase [2] = "Bacau";
        orase [3] = "Iasi";
        orase [4] = "Cluj-Napoca";

        //TODO 6: Definiti un array de valori boolean numit "stareCivila" si initializati valorile cu valoarea de adevar corespunzatoare numelor
        boolean [] stareCivila = new boolean[5];
        stareCivila[0] = true;
        stareCivila[1] = true;
        stareCivila[2] = true;
        stareCivila[3] = true;
        stareCivila[4] = true;

        //TODO 7: Atribuiti proprietatii statice "curs" a clasei "Persoana" valoare "JAVA"
        Persoana.curs = "JAVA";

        //TODO 8: Definiti un ArrayList cu tipul "Persoana" numit "persoane"
        List<Persoana> persoane = new ArrayList(5); // e si todo 9

        //TODO 9: Instantiati variabila persoane si alocati dimensiunea 5

        //TODO 10: Folositi un for pentru a parcurge array-urile
        for (int i = 0; i <= 4; i++){
            persoane.add(new Persoana(nume[i], prenume[i], orase[i], varste[i], stareCivila[i]));
        }

        //si a crea folosind valorile de pe fiecare pozitie o noua instanta de tip persoana
        //care sa fie apoi adaugata in ArrayList-ul "persoane"
        //Rezultatul final ar trebui sa fie un ArrayList cu 5 instante de tip Persoana
        //prima avand nume, prenume, oras, varsta, stareCivila ce corespunde cu pozitia 0, al doilea cu pozitia 1 samd

        //TODO 11: Folositi un simplu System.out.println pentru a vedea cum arata afisarea ArrayListului persoane
        System.out.println(persoane.get(0));

        //TODO 12: Folositi un for-each pentru a parcurge si a afisa persoanele din lista persoane pe cate un rand
        for (Persoana persoana : persoane) {
            System.out.println(persoana);
        }

        //Vom realiza o structura de date ce contine notele elevilor bazata pe o cheie reprezentata de identificatorul persoanei
        //TODO 13: Definiti si initializati un HashMap numit "catalog" cu tipurile <String, Integer>
        Map<String,Integer> catalog = new HashMap<>();

        //TODO 14: Pentru fiecare persoana din lista introduceti in HashMap valoarea returnata de
        //metoda obtineIdentificator() drept cheie si o nota intre 1 si 10 drept valoare (minim o nota sub 5)
        //Hint: obtineti persoana din lista folosind pozitia acesteia, nu parcurgeti lista intr-o bucla

        catalog.put(persoane.get(0).obtineIdentificator(), 6);
        catalog.put(persoane.get(1).obtineIdentificator(), 1);
        catalog.put(persoane.get(2).obtineIdentificator(), 5);
        catalog.put(persoane.get(3).obtineIdentificator(), 10);
        catalog.put(persoane.get(4).obtineIdentificator(), 2);

        //TODO 15: Folositi un simplu System.out.println pentru a afisa HashMapul catalog
        System.out.println();
        System.out.println("CATALOG");
        System.out.println(catalog);
        System.out.println();
        
        //TODO 16: Iterati peste HashMapul catalog si afisati pe cate un rand fiecare key-value
        //cu formatarea "Studentul ID are nota NOTA" - ex: "Studentul ion_POPESCU are nota 7"
        for (Map.Entry<String, Integer> m : catalog.entrySet()){
            System.out.println("Studentul " + m.getKey() + " are nota " + m.getValue());
        }

        //TODO 17: Afisati dimensiunea listei de persoane si a catalogului
        System.out.println("Dimensiune lista persoane: " + persoane.size());
        System.out.println("Dimensiune map catalog: " + catalog.size());
        System.out.println();
        System.out.println(" next ");
        //TODO 18: Iterati peste lista de persoane si eliminati studentii cu nota mai mica decat 5
        //Pentru aceasta se va verifica valoarea notei pentru fiecare persoana din "catalog"
        //Daca se elimina o persoana din lista se va elimina si intrarea legata de aceasta din catalog
        //HINT: ordinea stergerilor conteaza

        List<Persoana> personsToRemove = new ArrayList<>();
        for (Persoana persoana : persoane) {
            String id = persoana.obtineIdentificator();
            if(catalog.get(id) < 5){
                catalog.remove(id);
                personsToRemove.add(persoana);
            }
        }
        persoane.removeAll(personsToRemove);

        //TODO 19: Afisati iar dimensiunea listei de persoane si a catalogului pentru a vedea rezultatele
        System.out.println(persoane.size());
        System.out.println(catalog.size());
        //TODO 20: Afisati lista de persoane si catalogul pentru a vedea ca au fost sterse valorile corecte
        System.out.println(catalog);
        System.out.println(persoane);


    }
}

