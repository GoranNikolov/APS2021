/**
 * Треба да се провери колку посто од тестираните се позитивни со помош на две CBHT табели
 * една за позитивни една за негативни. Се внесуваат прво општина па презиме па резултат.Ако има две исти
 * презимиња тие се сметаат како две посебни личности.

 * riskfactor = бр.позитивни/бр.позитивни + бр.негативни
 * riskfactor се принта со две децимални цифри

5
Centar Trajko pozitiven
Centar Vladislav negativen
Karpos Svetoslava pozitiven
Centar Trajan negativen
Karpos Darko pozitiven
Centar

 * output:
 * 0.33
 **/
package Hash;

import codeForHash.CBHT;
import codeForHash.MapEntry;
import codeForHash.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IspitnaCoronaRickFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(stdin.readLine());
        CBHT<String, Integer> pozitivni = new CBHT<>(2 * N);
        CBHT<String, Integer> negativni = new CBHT<>(2 * N);
        for (int i = 0; i < N; i++) {
            String pom[] = stdin.readLine().split(" ");
            String opstina = pom[0];
            String ime = pom[1];
            String rezultat = pom[2];
            if (rezultat.equals("negativen")) {
                SLLNode<MapEntry<String, Integer>> search = negativni.search(opstina);
                if (search == null) {
                    negativni.insert(opstina, 1);
                } else {
                    int value = negativni.search(opstina).element.value + 1;
                    negativni.insert(opstina, value);
                }
            } else if (rezultat.equals("pozitiven")) {
                SLLNode<MapEntry<String, Integer>> search = pozitivni.search(opstina);
                if (search == null) {
                    pozitivni.insert(opstina, 1);
                }
            } else {
                int value = pozitivni.search(opstina).element.value + 1;
                pozitivni.insert(opstina, value);
            }
        }

        String opstina = stdin.readLine();
        int poz = 0;
        int neg = 0;
        SLLNode<MapEntry<String, Integer>> searchNegativni = negativni.search(opstina);
        SLLNode<MapEntry<String, Integer>> searchPozitivni = pozitivni.search(opstina);
        if (searchNegativni != null) {
            neg = negativni.search(opstina).element.value;
        }
        if (searchPozitivni != null) {
            poz = pozitivni.search(opstina).element.value;
        }
        int vkupno = poz + neg;
        float riskFactor = (float) poz / vkupno;
        System.out.printf("%.2f%n", riskFactor);
    }
}
