package SLL;

import codeForSLLandDLL.SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

    public static void testOne(String str, Integer broj) {
        String bString = String.valueOf(broj);
        String test = str + broj + " " + bString;
        System.out.println(test);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista = new SLL<Integer>();
        SLL<String> StringLista = new SLL<String>();
        Integer n = Integer.parseInt(stdin.readLine());
        String s = stdin.readLine();
//        System.out.println(s);
//        System.out.println(n);
//        testOne(s, n);
        String[] pomniza = s.split(" ");
        for (int i = 0; i < n; i++) {
//            lista.insertLast(Integer.parseInt(pomniza[i]));
            StringLista.insertLast(pomniza[i]);
        }
        System.out.println(StringLista);
    }
}
