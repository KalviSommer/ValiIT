package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson3 {

    public static void main(String[] args) {
//        System.out.println(isPrime(5));
//        System.out.println(factorial(5));
//        System.out.println(Arrays.toString(sort(new int[]{2, 4, 9, 7, 4})));
//        System.out.println(evenFibonacci(10));
//        System.out.println(reverseString("mismoodi"));
        System.out.println(morseCode("hello"));
    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int value = x;
        for (int i = (x - 1); i >= 1; i--) {
            int mply = value * i;
            value = mply;
        }
        return value;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String revA = "";
        char ch;
        for (int i = 0; i < a.length(); i++) {
            ch = a.charAt(i); //eraldab iga tähemärgi
            revA = ch + revA; //lisab iga tähemärgi olemasolevasse stringi
        }
        return revA;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        int count = 0;
        int remainde = 0;
        for (int i = 1; i <= x; i++) {
            remainde = x % i;
            if (remainde == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            for (int i = 0; i < a.length - j; i++) {
                if (a[i + 1] < a[i]) {
                    int n1 = a[i];
                    int n2 = a[i + 1];
                    a[i] = n2;
                    a[i + 1] = n1;
                }
            }
        }
        return a;
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int x1 = 0, x2 = 1, x3;
        int[] fibArray = new int[x + 1];
        int sum = 0;
        fibArray[0] = 0;
        if (x > 0) {
            fibArray[1] = 1;
            for (int i = 2; i <= x; i++) {
                x3 = x1 + x2;
                fibArray[i] = x3;
                x1 = x2;
                x2 = x3;
                int remind = x3 % 2;
                if (remind == 0 && x3 <= x) {
                    sum = sum + x3;
                }
            }
        }
        return sum;
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        String morse = "";
        char ch;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i); //eraldab iga tähemärgi
            switch (ch){
                case 'e':
                    morse = morse + ". ";
                    break;
                case 'h':
                    morse = morse + ".... ";
                    break;
                case 'l':
                    morse = morse + ".-.. ";
                    break;
                case 'o':
                    morse = morse + "--- ";
                    break;
                case 'r':
                    morse = morse + ".-. ";
                    break;
                case 's':
                    morse = morse + "... ";
                    break;
                case 't':
                    morse = morse + "- ";
                    break;
                default:
                    continue;
            }
        }
        return morse.trim();
    }
}
