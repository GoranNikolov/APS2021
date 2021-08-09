package Stack;

import codeForStackAndQueue.LinkedStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostFixEvaluation {

    public static  int postFix(String pom[]){

        LinkedStack<Integer> stek = new LinkedStack<>();
        int rezult = 0;
        for (String x : pom) {
            if (Character.isDigit(x.charAt(0))){
                stek.push(Integer.parseInt(x));
            }
            else if (x.charAt(0)=='+'){
                while (stek.isEmpty() != true){
                int vtor = stek.pop();
                int prv = stek.pop();
                rezult += prv + vtor;
                }
                stek.push(rezult);
            }
            else if (x.charAt(0)=='-'){
                int vtor = stek.pop();
                int prv = stek.pop();
                stek.push(prv-vtor);
            }
            else if (x.charAt(0)=='*'){
                int vtor = stek.pop();
                int prv = stek.pop();
                stek.push(prv*vtor);
            }
            else if (x.charAt(0)=='/'){
                int vtor = stek.pop();
                int prv = stek.pop();
                stek.push(prv/vtor);
            }
        }
        return stek.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String pom[] = stdin.readLine().split(" ");
        System.out.println(postFix(pom));
    }
}
