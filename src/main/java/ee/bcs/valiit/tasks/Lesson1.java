package ee.bcs.valiit.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("***********");
            System.out.println("Vali meetod, mida tahad tööle panna");
            System.out.println("1 - min");
            System.out.println("2 - max");
            System.out.println("3 - absoluutarv");
            System.out.println("4 - isEven - paaris number");
            System.out.println("5 - miinimum kolmest arvust");
            System.out.println("6 - maksimum kolmest arvust");
            System.out.println("7 - arvu tulem programmist");
            System.out.println("0 - välju");


            int choise = scanner.nextInt();
            if (choise == 1) {
                System.out.println("sisesta esimene number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("nendest kõige väiksem on:" + min(a, b));
            } else if (choise == 2) {
                System.out.println("sisesta esimene number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("nendest kõige suurem on:" + max(a, b));
            } else if (choise == 3) {
                System.out.println("sisesta number");
                int a = scanner.nextInt();
                System.out.println("arvu" + a + " absoluutväärtus on:" + abs(a));
            } else if (choise == 4) {
                System.out.println("sisesta number");
                int a = scanner.nextInt();
                System.out.println("Arv on paarisarv " + isEven(a));
            } else if (choise == 5) {
                System.out.println("sisesta number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("sisesta kolmas number");
                int c = scanner.nextInt();
                System.out.println("nendest kõige väiksem on:" + min3(a, b, c));
            } else if (choise == 6) {
                System.out.println("sisesta number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("sisesta kolmas number");
                int c = scanner.nextInt();
                System.out.println("nendest kõige suurem on:" + max3(a, b, c));
            }else if (choise == 7) {
                System.out.println("sisesta number");
                int a = scanner.nextInt();

                System.out.println("Funktsiooni tulemus on:" + someString());
            } else if(choise == 0){
                break;
            }
        }

//            System.out.println("sisesta number");
//            int a = scanner.nextInt();
//            System.out.println("sisesta teine number");
//            int b = scanner.nextInt();
//            System.out.println("Nendest kõige väiksem on: " + min(a, b));


        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
//        someString();
//        System.out.println(min(1, 3)); // trükib miinimumi 1 ja 3
//        System.out.println(min3(4,2,6));
//        System.out.println(abs(-15));
//        System.out.println(max3(3,3,2));
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        return "\"\\\"\\\\\"\"";
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return 0 - a;
        } else return a;
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        a = a % 2;
        if (a == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if ((a <= b) && (a <= c)) {
            return a;
        } else if ((b <= a) && (b <= c)) {
            return b;
        } else return c;
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if ((a >= b) && (a >= c)) {
            return a;
        } else if ((b >= a) && (b >= c)) {
            return b;
        } else return c;
    }

}
