package SLL;

import codeForSLLandDLL.SLL;
import codeForSLLandDLL.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTheBiggestNumber {

    public static int findLargestNumber(SLL<Integer> lista) {
        SLLNode<Integer> k1 = lista.getFirst();
        int max = 0;
        while (k1 != null) {
            if (k1.element > max) {
                max = k1.element;
                k1 = k1.succ;
            }
            k1 = k1.succ;
        }
        return max;
    }
    public static int findSmallestNumber(SLL<Integer> lista){
        SLLNode<Integer>k1 = lista.getFirst();
        SLLNode<Integer>min = lista.getFirst();
        while (k1 !=null){
            if (min.element>k1.element){
                min.element = k1.element;
                k1 = k1.succ;
            }
            k1 = k1.succ;
        }
        return min.element;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista = new SLL<>();
        Integer n = Integer.parseInt(stdin.readLine());
        String[] pom = stdin.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(pom[i]));
        }
        System.out.println(findLargestNumber(lista));
        System.out.println(findSmallestNumber(lista));

    }
}
