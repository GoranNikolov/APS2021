package Queue;

import codeForStackAndQueue.LinkedQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        LinkedQueue<Integer> redica =new LinkedQueue<Integer>();
        Integer n = Integer.parseInt(stdin.readLine());
        String []pom = stdin.readLine().split(" ");
        for (int i = 0; i < n  ; i++) {
            redica.enqueue(Integer.parseInt(pom[i]));
        }
        redica.dequeue();
    }
}
