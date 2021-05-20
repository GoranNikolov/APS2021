package Hash;

import codeForHash.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class preveduvac {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin  =new BufferedReader(new InputStreamReader(System.in));
        OBHT<String,String> table = new OBHT<>(20);
        Integer n = Integer.parseInt(stdin.readLine());
        for (int i = 0; i < n ; i++) {
            String []pom = stdin.readLine().split(" ");
            table.insert(pom[1],pom[0]);
        }
        while (true){
            String vlez = stdin.readLine();
            if (vlez.equals("KRAJ"))
                break;
            int test = table.search(vlez);
            if (test == -1 )
                System.out.println("Nepostoi");
            else
                System.out.println(table.buckets[test].value);
        }

    }
}
