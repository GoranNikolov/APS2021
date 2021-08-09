package SLL;

import codeForSLLandDLL.SLL;
import codeForSLLandDLL.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class teachKek {

    public static void sort(SLL<Integer> lista) {
        SLLNode<Integer> d1 = lista.getFirst();
        while (d1 != null){
            SLLNode<Integer> d2 = lista.getFirst();
            while (d2 != null){
                if (d1.element > d2.element){
                    int temp = d1.element;
                    d1.element = d2.element;
                    d2.element = temp;
                }
                d2 = d2.succ;
            }
            d1 = d1.succ;
        }
    }

    public static int kekl(SLL<Integer>test) {
        int n = 0;
        SLLNode<Integer> d1 = test.getFirst();
        int dolzina = test.length() / 2;
        for (int i = 0; i < dolzina ; i++) {
            d1 = d1.succ;
        }
        test.delete(d1);
        return d1.element;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> listaSLL = new SLL<>();
        Integer broj = Integer.parseInt(stdin.readLine());
        String pom[] = stdin.readLine().split(" ");
        for (int i = 0; i < broj; i++) {
            listaSLL.insertLast(Integer.parseInt(pom[i]));
        }
        System.out.println(listaSLL);
        sort(listaSLL);
        System.out.println(listaSLL);
        System.out.println(kekl(listaSLL));
        System.out.println(listaSLL);
    }
}
