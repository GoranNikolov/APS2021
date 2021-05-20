package Hash;

import codeForHash.CBHT;
import codeForHash.MapEntry;
import codeForHash.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lozinka {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(stdin.readLine());
        CBHT<String, String> table = new CBHT<>(2 * n);
        for (int i = 0; i < n; i++) {
            String[] pom = stdin.readLine().split(" ");
            table.insert(pom[0], pom[1]);
        }
        while (true) {
            String vlez = stdin.readLine();
            if (vlez.equals("STOP")) {
                break;
            }
            String []pom =vlez.split(" ");
            SLLNode<MapEntry<String, String>> temp = table.search(pom[0]);
            if (temp == null || !(temp.element.value.equals(pom[1])))
                System.out.println("Nenajaven");
            else {
                System.out.println("Najaven");
                break;
            }
        }
    }
}