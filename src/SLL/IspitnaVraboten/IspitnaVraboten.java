/**Податоци за вработените во компанијата IOSolutions се чуваат во две еднострано поврзани листи. Во првата листа се чуваат податоците за вработените кои се дел од тимот Dev,
а додека пак во втората се чуваат податоците за вработените кои се дел од тимот Qa. И кај двете листи, во секој од јазлите се чуваат број за идентификација (id)
и возраста на вработениот за кој се однесува тој јазел.

Со зголемување на обемот на работа, потребно е да се зголеми бројот на членови во Dev тимот. За таа цел,
главниот менаџер решил да го отстрани најмладиот член од Qa тимот и да го додаде кон Dev тимот. Тоа значи дека
потребно е од листата каде се чуваат членовите на Qa тимот да се отстрани (избрише) најмладиот член (доколку има повеќе,
последниот таков член), и истиот да се додаде на средина на листата каде што се чуваат членовите на Dev тимот.

Влез:
Во првиот ред е даден бројот на вработени кои се дел од Dev тимот.
Во вториот ред е даден бројот на вработени кои се дел од Qa тимот.
Во следните редови се дадени паровите податоци за секој вработен, одделени со празно место, во формат id возраст.
Излез:

Во првиот ред id на сите вработени кои се дел од Dev тимот.
Во вториот ред id на сите вработени кои се дел од Qa тимот.

Забелешка:

Даден е целосниот код на структурата која што треба да се користи.
Потребно е да направат дополнувања во main функцијата и да се имплементирана void alterTeams(SLL devTeam, SLL qaTeam) функцијата.
Притоа, бришењето треба да биде имплементирано како бришење на цел јазел, а додавањето како додавање на цел јазел.
Промените (бришење/додавање елемент) не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.

For example:

Input	Result
2
3
16100 20
17200 30
19898 20
14203 35
18100 19
16100 18100 17200
19898 14203
3
3
16100 20
17200 30
18112 45
14102 19
19203 35
18900 20
16100 17200 14102 18112
19203 18900
**/
package SLL.IspitnaVraboten;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode {
    int id;
    int age;
    SLLNode succ;

    public SLLNode(int id, int age, SLLNode succ) {
        this.id = id;
        this.age = age;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

class SLL {
    SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void insertFirst(int id, int age) {
        SLLNode insert = new SLLNode(id, age, first);
        first = insert;
    }

    public void insertAfter(int id, int age, SLLNode after) {
        if (after != null) {
            SLLNode insert = new SLLNode(id, age, after.succ);
            after.succ = insert;
        } else {
            System.out.println("NULL NODE!");
        }
    }

    public void insertBefore(int id, int age, SLLNode before) {
        if (first != null) {
            SLLNode tmp = first;
            if (first == before) {
                this.insertFirst(id, age);
                return;
            }
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode insert = new SLLNode(id, age, before);
                tmp.succ = insert;
            } else {
                System.out.println("NULL NODE!");
            }
        } else {
            System.out.println("EMPTY LIST!");
        }
    }

    public void insertLast(int id, int age) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode insert = new SLLNode(id, age, null);
            tmp.succ = insert;
        } else {
            insertFirst(id, age);
        }
    }

    public SLLNode deleteFirst() {
        if (first != null) {
            SLLNode tmp = first;
            first = first.succ;
            return tmp;
        } else {
            System.out.println("EMPTY LIST!");
            return null;
        }
    }

    public SLLNode delete(SLLNode node) {
        if (first != null) {
            SLLNode tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node;
            } else {
                System.out.println("NODE WAS NOT FOUND!");
                return null;
            }
        } else {
            System.out.println("EMPTY LIST!");
            return null;
        }
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode tmp = first;
            ret.append(tmp).append(" ");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append(" ");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}

public class IspitnaVraboten {

    public static void alterTeams(SLL devTeam, SLL qaTeam) {
        SLLNode devNode = devTeam.first;
        SLLNode qaNode = qaTeam.first;
        SLLNode qaNodeYoungest = qaTeam.first;
        while (qaNode != null){
            if (qaNode.age < qaNodeYoungest.age){
                qaNodeYoungest = qaNode;
                qaNode  = qaNode.succ;
            }else {
            qaNode=qaNode.succ;
            }
        }
        qaTeam.delete(qaNodeYoungest);
        int devTeamLength = devTeam.length();
        if (devTeamLength % 2 == 0 ){
            int even = devTeamLength/2;
            for (int i = 0; i < even ; i++) {
                devNode = devNode.succ;
            }
            devTeam.insertBefore(qaNodeYoungest.id,qaNodeYoungest.age,devNode);
        }
        else {
            int uneven = (devTeamLength+1)/2;
            for (int i = 0; i < uneven ; i++) {
                devNode = devNode.succ;
            }
            devTeam.insertBefore(qaNodeYoungest.id,qaNodeYoungest.age,devNode);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SLL devTeam = new SLL();
        SLL qaTeam = new SLL();
        Integer n = Integer.parseInt(stdin.readLine());
        Integer m = Integer.parseInt(stdin.readLine());
        for (int i = 0; i < n; i++) {
            String input = stdin.readLine();
            String pom[] = input.split("\\s+");
            devTeam.insertLast(Integer.parseInt(pom[0]), Integer.parseInt(pom[1]));
        }
        for (int i = 0; i < m; i++) {
            String input = stdin.readLine();
            String pom[] = input.split("\\s+");
            qaTeam.insertLast(Integer.parseInt(pom[0]), Integer.parseInt(pom[1]));
        }
        alterTeams(devTeam,qaTeam);
        System.out.println("DEV TEAM: " + devTeam);
        System.out.println("QA TEAM: " + qaTeam);
    }
}
