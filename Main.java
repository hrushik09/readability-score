package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TakeInput input = new TakeInput(args[0]);
        input.readFile();
        input.printData();

        ARI ari = new ARI(input);
        FK fk = new FK(input);
        SMOG smog = new SMOG(input);
        CL cl = new CL(input);
        Scanner scanner = new Scanner(System.in);
        String method = scanner.next();
        switch(method) {
            case "ARI":
                ari.calculateScore();
                break;

            case "FK":
                fk.calculateScore();
                break;

            case "SMOG":
                smog.calculateScore();
                break;

            case "CL":
                cl.calculateScore();
                break;

            case "all":
                System.out.println();
                ari.calculateScore();
                fk.calculateScore();
                cl.calculateScore();
                smog.calculateScore();
                System.out.printf("This text should be understood in average by %.2f-year-olds", (ari.score + fk.score + cl.score + smog.score) / 4);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}