package Stack;

import codeForStackAndQueue.LinkedStack;
import codeForStackAndQueue.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testStack {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        LinkedStack<Integer> stek =  new LinkedStack<Integer>();
        Integer n = Integer.parseInt(stdin.readLine());
        String []pom = stdin.readLine().split(" ");
        for (int i = 0; i < n ; i++) {
            stek.push(Integer.parseInt(pom[i]));
        }
        System.out.println(stek.peek());
    }
}
