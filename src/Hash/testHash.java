package Hash;

import codeForHash.CBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testHash {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(stdin.readLine());
        CBHT<String,String> table = new CBHT<>(2*n);
        for (int i = 0; i < n ; i++) {
            String []pom = stdin.readLine().split(" ");
            table.insert(pom[0],pom[1]);
        }
        System.out.println(table);
    }
}
