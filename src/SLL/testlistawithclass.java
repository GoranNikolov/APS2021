package SLL;

import codeForSLLandDLL.SLL;
import codeForSLLandDLL.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testlistawithclass {

    static class vrboten {
        Integer index;
        Integer age;
        public vrboten(int index, int age) {
            this.index = index;
            this.age = age;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    public static void print(SLL<vrboten>lista){
        SLLNode<vrboten> node = lista.getFirst();
        while (node!=null){
            if (node.succ == null){
                System.out.print(node.element.index + " " + node.element.age);
                System.out.println();
                break;
            }
            System.out.println(node.element.index +" "+ node.element.age + " ");
            node= node.succ;
        }
    }
    public static void sortByAge(SLL<vrboten>lista){
        SLLNode<vrboten>k1 = lista.getFirst();
        while (k1 !=null){
        SLLNode<vrboten>k2 = lista.getFirst();
        while (k2 !=null){
            if (k1.element.age > k2.element.age){
                int tmpAge =k1.element.age;
                int tmpIndex =k1.element.index;
                k1.element.age = k2.element.age;
                k1.element.index =k2.element.index;
                k2.element.age=tmpAge;
                k2.element.index=tmpIndex;
            }
            k2 = k2.succ;
        }
        k1 = k1.succ;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        SLL<vrboten> lista = new SLL<>();
        int n  = Integer.parseInt(stdin.readLine());
        for (int i = 0; i < n ; i++) {
            String input = stdin.readLine();
            String pom[] =input.split(" ");
            vrboten newVraboten = new vrboten(Integer.parseInt(pom[0]),Integer.parseInt(pom[1]));
            lista.insertLast(newVraboten);
        }
        sortByAge(lista);
        print(lista);
    }
}
