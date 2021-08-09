/**
 Дадена е еднострано поврзана листа. Се бара N пати да се избрише средината. Ако листата е со парен
 број елементи, од двата средишни елементи се брише помалиот, а ако се исти, се брише првиот.

 Влез: Првата линија е број на елементи, втората линија се елементите на листата, а во третата
 е број кој означува колку пати да се избрише средината.

 Input:
5
1 2 3 4 5
2

 Output:
 1->4->5

 */
package SLL;

import codeForSLLandDLL.SLL;
import codeForSLLandDLL.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IspitnaIzbrsiNSredina {


    public static void deleteSredina(SLL<Integer>lista , int m){
        int flag = 0;
        while (flag != m){
        SLLNode<Integer> node = lista.getFirst();
        int dolzina = lista.length();
        if (dolzina % 2 == 0){
            int golemina = dolzina/2;
            for (int i = 1; i < golemina ; i++) {
                node = node.succ;
            }
            if (node.element > node.succ.element){
                lista.delete(node.succ);
            }
            else if (node.element < node.succ.element){
                lista.delete(node);
            }
            else if (node.element.equals(node.succ.element)){
                lista.delete(node);
            }
        }
        else {
            int golemina = dolzina/2;
            for (int i = 0; i < golemina ; i++) {
                node = node.succ;
            }
            lista.delete(node);
        }
        flag++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista = new SLL<>();
        int n = Integer.parseInt(stdin.readLine());
        String pom[] = stdin.readLine().split(" ");
        for (int i = 0; i < n ; i++) {
            lista.insertLast(Integer.parseInt(pom[i]));
        }
        int delete = Integer.parseInt(stdin.readLine());
        deleteSredina(lista,delete);
        System.out.println(lista);
    }
}
