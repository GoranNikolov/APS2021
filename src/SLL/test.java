package SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

    public static void testOne(String str , Integer broj ){
        String bString = String.valueOf(broj);
        String test = str + broj + " " + bString;
        System.out.println(test);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        System.out.println(s);
        Integer n =Integer.parseInt(stdin.readLine());
        System.out.println(n);
        testOne(s,n);

    }
}
