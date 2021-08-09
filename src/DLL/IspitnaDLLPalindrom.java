/**

 Input:         Rezult:
 5                 -1
 1 2 3 1 2

 5                  1
 1 2 3 2 1

 6                 -1
 2 1 6 7 1 2

 7                  1
 5 4 8 9 8 4 5
 **/
package DLL;

import codeForSLLandDLL.DLL;
import codeForSLLandDLL.DLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IspitnaDLLPalindrom {

    public static int checkPolindrom(DLL<Integer> list) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();
        int flag = 0;
        int even = list.length() / 2;
            for (int i = 1; i <= even; i++) {
                if (first.element.equals(last.element)){
                    flag=1;
                    first = first.succ;
                    last = last.pred;
                }else {
                    flag = -1;
                    break;
                }
            }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> list = new DLL<>();
        int n = Integer.parseInt(stdin.readLine());
        String pom[] = stdin.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.insertLast(Integer.parseInt(pom[i]));
        }
        System.out.println(checkPolindrom(list));
    }
}
