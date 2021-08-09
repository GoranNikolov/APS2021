package SLL;

import codeForSLLandDLL.SLL;
import codeForSLLandDLL.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SLLJoinLists {

    public static void sort(SLL<Integer> list) {
        SLLNode<Integer> k1 = list.getFirst();
        while (k1 != null) {
            SLLNode<Integer> k2 = list.getFirst();
            while (k2 != null) {
                if (k1.element < k2.element) {
                    int temp = k1.element;
                    k1.element = k2.element;
                    k2.element = temp;
                }
                k2 = k2.succ;
            }
            k1 = k1.succ;
        }
    }

    public static void print(SLL<Integer> list) {
        SLLNode<Integer> node = list.getFirst();

        while (node != null) {
            if (node.succ == null) {
                System.out.print(node.element);
                System.out.println();
                break;
            }
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }

    public static SLL<Integer> spoi(SLL<Integer> firstList, SLL<Integer> secondList) {
        SLL<Integer> rezultat = new SLL();
        SLLNode<Integer> nodeForFirst = firstList.getFirst();
        SLLNode<Integer> nodeForSecond = secondList.getFirst();
        while (nodeForFirst != null && nodeForSecond != null) {
            rezultat.insertLast(nodeForFirst.element);
            rezultat.insertLast(nodeForSecond.element);
            nodeForFirst = nodeForFirst.succ;
            nodeForSecond = nodeForSecond.succ;
        }
        while (nodeForFirst != null) {
            rezultat.insertLast(nodeForFirst.element);
            nodeForFirst = nodeForFirst.succ;
        }
        while (nodeForSecond != null) {
            rezultat.insertLast(nodeForSecond.element);
            nodeForSecond = nodeForSecond.succ;
        }
        sort(rezultat);
        SLLNode<Integer> rezultnode = rezultat.getFirst();
        while (rezultnode != null && rezultnode.succ != null) {
            if (rezultnode.element.equals(rezultnode.succ.element)) {
                rezultnode.succ = rezultnode.succ.succ;
            }else {
                rezultnode = rezultnode.succ;
            }
        }
        return rezultat;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> firstList = new SLL();
        SLL<Integer> secondList = new SLL();
        int n = Integer.parseInt(stdin.readLine());
        String[] pom = stdin.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            firstList.insertLast(Integer.parseInt(pom[i]));
        }
        int m = Integer.parseInt(stdin.readLine());
        String pom2[] = stdin.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            secondList.insertLast(Integer.parseInt(pom2[i]));
        }
        System.out.println(firstList);
        System.out.println(secondList);
        SLL<Integer> spoeni = spoi(firstList,secondList);
        print(spoeni);
    }
}
