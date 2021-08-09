/**
 * Во магацинот на една фармацевтска компанија се чуваат најразлични видови лекови.За секој лек потребно
 * е да се чуваат податоци за името на лекот,цената во денари и намената на лекот.За поефикасен пристап до
 * податоците за лековите,фармацевтската компанија одлучила податоците да ги чува во хеш табела(CBHT)
 * каде се сместуваат соодветните податоци.
 * <p>
 * Хеш табелата е достапна до крајните клиенти и истите може да пребаруваат низ внесените податоци.
 * Бидејќи на пазарот постојат повеќе лекови кои таргетираат иста болест,најчесто клиентите го бараат оној лек кој има најниска цена.
 * Па вашата задача е со користење на хеш табелата,за дадена намена(болест),да го испечатите лекот кој има најниска цена на пазарот.
 * Доколку за бараната намена во магацинот нема лек се печати"Nema lek za baranata namena vo magacin.".
 * <p>
 * Влез:
 * Најпрво е даден бројот на лекови-N,а потоа секој лек е даден во нов ред во форматот:
 * “Име на лек” “Намена” “Цена во денари”
 * На крај е дадена намената за која треба да се пронајде лекот со најниска цена.
 * <p>
 * Излез:
 * <p>
 * Името на лекот со најмала цена.
 * <p>
 * <p>
 * Пример:
 * Влез:
 * <p>
 * 5
 * Analgin Glavobolka 80
 * Daleron Glavobolka 90
 * Lineks Bolki_vo_stomak 150
 * Spazmeks Bolki_vo_stomak 150
 * Loratadin Alergija 150
 * Glavobolka
 * <p>
 * Излез:
 * Analgin
 **/
package Hash;

import codeForHash.CBHT;
import codeForHash.MapEntry;
import codeForHash.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IspitnaAptekaCorrect {

    static class lek {
        String ime;
        String namena;
        Integer cena;

        public lek(String ime, String namena, Integer cena) {
            this.ime = ime;
            this.namena = namena;
            this.cena = cena;
        }

        public String getNamena() {
            return namena;
        }

        public void setNamena(String namena) {
            this.namena = namena;
        }

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public Integer getCena() {
            return cena;
        }

        public void setCena(Integer cena) {
            this.cena = cena;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(stdin.readLine());
        CBHT<Integer, lek> table = new CBHT<>(2 * N);
        for (int i = 0; i < N; i++) {
            String pom[] = stdin.readLine().split(" ");
            String ime = pom[0];
            String namena = pom[1];
            int cena = Integer.parseInt(pom[2]);
            lek dodajlek = new lek(ime,namena, cena);
            table.insert(i,dodajlek);
//            SLLNode<MapEntry<String, lek>> search = table.search(namena);
//            if (search == null) {
//                table.insert(namena, dodajlek);
//            } else if (table.search(namena).element.value.cena > cena) {
//                table.insert(namena, dodajlek);
//            }

        }
        String vlez = stdin.readLine();
        String rezultat = null;
        int min = 10000;
        for (int i = 0; i < 10; i++) {
            SLLNode<MapEntry<Integer, lek>> search = table.search(i);
            if (search != null){
               if (table.search(i).element.value.namena.equals(vlez)){
                   if (table.search(i).element.value.cena <= min) {
                       min = table.search(i).element.value.cena;
                       rezultat = table.search(i).element.value.ime;
                       System.out.println(rezultat);
                   }
               }
            }
        }
//        SLLNode<MapEntry<String, lek>> findUpotreba = table.search(vlez);
//        if (findUpotreba != null) {
//            rezultat = table.search(vlez).element.value.ime;
//        }

    }
}
