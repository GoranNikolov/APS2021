package SLL;

import codeForSLLandDLL.SLL;
import codeForSLLandDLL.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SLLJoinListsNaizmnicno {

    public static void print(SLL<Integer>lista){
        SLLNode<Integer> node = lista.getFirst();
        while (node!=null){
            if (node.succ == null){
                System.out.print(node.element);
                System.out.println();
                break;
            }
           System.out.print(node.element + " ");
            node = node.succ;
        }
    }

    public static  SLL<Integer> lista (SLL<Integer>firstList,SLL<Integer>secondList){
        SLL<Integer>rezult = new SLL<>();
        SLLNode<Integer> node = firstList.getFirst();
        SLLNode<Integer> nodeSecond = secondList.getFirst();
        while (node != null && nodeSecond !=null && node.succ != null && nodeSecond.succ !=null){
            rezult.insertLast(node.element);
            rezult.insertLast(node.succ.element);
            rezult.insertLast(nodeSecond.element);
            rezult.insertLast(nodeSecond.succ.element);
            node = node.succ;
            node =node.succ;
            nodeSecond = nodeSecond.succ;
            nodeSecond =nodeSecond.succ;
        }
        while (node!=null){
            rezult.insertLast(node.element);
            node = node.succ;
        }
        while (nodeSecond !=null){
            rezult.insertLast(nodeSecond.element);
            nodeSecond = nodeSecond.succ;
        }
        return rezult;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> firstList = new SLL<>();
        SLL<Integer> secondList = new SLL<>();
        int n = Integer.parseInt(stdin.readLine());
        String pom[] = stdin.readLine().split( " ");
        for (int i = 0; i < n ; i++) {
            firstList.insertLast(Integer.parseInt(pom[i]));
        }
        int m = Integer.parseInt(stdin.readLine());
        String pom1[] = stdin.readLine().split(" ");
        for (int i = 0; i < m ; i++) {
            secondList.insertLast(Integer.parseInt(pom1[i]));
        }
        print(lista(firstList,secondList));
    }
}
