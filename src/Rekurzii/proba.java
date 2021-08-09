package Rekurzii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class proba {

    public static int test(int a, int b){
        int max = 20;
        int rezult = a + b;
        while (a != max){
            a++;
            test(a,b);
        }
        return rezult;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(stdin.readLine());
        int b = Integer.parseInt(stdin.readLine());
        System.out.println(test(a,b));
    }
}
