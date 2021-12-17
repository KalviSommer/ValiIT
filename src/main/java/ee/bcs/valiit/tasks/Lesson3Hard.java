package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String args[]) {
        Random random = new Random();
        int number = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int guess;
        int count = 0;
        System.out.println(
                "A number is chosen"
                        + " between 0 to 99."
                        + "Guess the number");
        while (true) {
            System.out.println(
                    "Guess the number:");
            guess = scanner.nextInt();

            if (number == guess) {
                count++;
                System.out.println(
                        "Congratulations!"
                                + " You guessed the number, by "
                                + count + " times!");
                break;
            } else if (number > guess) {
                count++;
                System.out.println(
                        "The number is "
                                + "greater than " + guess);
            } else if (number < guess) {
                count++;
                System.out.println(
                        "The number is"
                                + " less than " + guess);
            }
        }
    }
}
