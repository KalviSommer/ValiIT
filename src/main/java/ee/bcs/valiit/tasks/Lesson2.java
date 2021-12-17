package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
//        System.out.println(generateArray(5));
        System.out.println(Arrays.toString(decreasingArray(-5)));
//        System.out.println(Arrays.toString(yl3(5)));

    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] newArray = new int[5];
        newArray[0] = 1;
        newArray[1] = 2;
        newArray[2] = 3;
        newArray[3] = 4;
        newArray[4] = 5;
        return newArray;
    }


    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] newArray = new int[n];
        for (int a = 0; a < n; a++) {
            newArray[a] = a + 1;
        }
        return newArray;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
        //resultArray[0] = 5;(i)   i=5; n = 5;
        //resultArray[1] = 4;   i=4; n = 5;
        //resultArray[2] = 3;   i=3; n =5;
        //resultArray[3] = 2;
        //resultArray[4] = 1;
        //resultArray[5] = 0;
        int[] newArray = new int[Math.abs(n) + 1];
        if (n >= 0) {
            for (int i = n; i >= 0; i--) {
                newArray[i] = n - i;
            }
        } else {
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = n + i;
            }
        }
        return newArray;

    }


    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] newArray = new int[n];
        for (int i = 0; i < newArray.length;i++) {
            newArray[i] = 3;
        }return newArray;
    }
}
