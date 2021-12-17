package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks

//          int []someNumbers = {2,4,9,7,4};
//        System.out.println(sum(someNumbers));
//          System.out.println(max(new int []{2,4,9,7,4}));
//        System.out.println(Arrays.toString(reverseArray(someNumbers)));
//        System.out.println(Arrays.toString(evenNumbers(5)));
//            multiplyTable(3, 3);
//       System.out.println( fibonacci(0));
//       System.out.println( fibonacci(1));
//       System.out.println( fibonacci(2));
//       System.out.println( fibonacci(15));
        System.out.println(sequence3n(1,10));
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int[] newArray = new int[inputArray.length];
        int count = (inputArray.length - 1);
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = inputArray[count];
            count--;
        }
        return newArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] evenArray = new int[n];
        int count = 0;
        for (int i = 0; i < evenArray.length; i++) {
            if (i > 0) {
                evenArray[i] = evenArray[i - 1] + 2;
//            count++;
            } else {
                evenArray[i] = evenArray[i] + 2;
            }
        }
        return evenArray;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) {
        int minValue = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] < minValue) {
                minValue = x[i];
            }
        }
        return minValue;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int maxValue = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] > maxValue) {
                maxValue = x[i];
            }
        }
        return maxValue;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {

        for (int j = 1; j <= y; j++) {
            for (int i = 1; i <= x; i++) {
                System.out.format("%2d", i * j);
            }
            System.out.println();
        }

    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {

        int n1 = 0, n2 = 1, n3;

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;

        if (n > 0) {
            fibArray[1] = 1;

            for (int i = 2; i <= n; i++) {
                n3 = n1 + n2;
                fibArray[i] = n3;
                n1 = n2;
                n2 = n3;
            }
        }

        return fibArray[n];
    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 1 ja 10 puhul on vastus 20

    public static int sequence3n(int x, int y) {

        int num=x;
        int maxCount = 0;
        int remind;
        for(int i = x; i<=y;i++){

            num = i;
            int count = 1;
            for(;num>1;){
               remind = num % 2;
               if (remind == 0) {
                    num = num / 2;
                    count++;
                } else {
                    num = 3 * num + 1;
                    count++;
                }
               if(count > maxCount){
                   maxCount = count;
               }
            }
        }
        return maxCount;
    }
}
