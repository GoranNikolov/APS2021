package DLL;

import codeForSLLandDLL.DLL;
import codeForSLLandDLL.DLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testDLL {

    public static int soberi(DLL<Integer> lista){
        int zbir = 0;
        int n = lista.length();
        int m = 0;
        DLLNode<Integer>k1 = lista.getFirst();
        DLLNode<Integer>k2 = lista.getLast();
        while (m != n){
            zbir += k1.element + k2.element;
            k1=k1.succ;
            k2=k2.pred;
            m++;
        }
        return zbir;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer>lista = new DLL<Integer>();
        Integer n = Integer.parseInt(stdin.readLine());
        String[] pom = stdin.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(pom[i]));
        }
        System.out.println(soberi(lista));
        System.out.println(lista);
    }
}
