package SLL;

import codeForSLLandDLL.SLL;
import codeForSLLandDLL.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTheBiggestNumber {

    public static void sort(SLL<Integer> lista) {
        SLLNode<Integer> k1 = lista.getFirst();
        while (k1 != null) {
            SLLNode<Integer> k2 = lista.getFirst();
            while (k2 != null) {
                if (k1.element > k2.element) {
                    int tmp = k1.element;
                    k1.element = k2.element;
                    k2.element = tmp;
                }
                k2 = k2.succ;
            }
            k1 = k1.succ;
        }
    }

    public static void pecati(SLL<Integer> lista) {
        SLLNode<Integer> k1 = lista.getFirst();
        while (k1 != null) {
            if (k1.succ == null) {
                System.out.print(k1.element);
                System.out.println();
                break;
            }
            System.out.print(k1.element + " ");
            k1 = k1.succ;
        }
    }

    public static int findLargestNumber(SLL<Integer> lista) {
        SLLNode<Integer> k1 = lista.getFirst();
        int max = 0;
        while (k1 != null) {
            if (k1.element > max) {
                max = k1.element;
                k1 = k1.succ;
            } else {
                k1 = k1.succ;
            }
        }
        return max;
    }

    public static int findSmallestNumber(SLL<Integer> lista) {
        SLLNode<Integer> k1 = lista.getFirst();
        SLLNode<Integer> min = lista.getFirst();
        while (k1 != null) {
            if (min.element > k1.element) {
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
        pecati(lista);
        sort(lista);
        pecati(lista);

    }
}
