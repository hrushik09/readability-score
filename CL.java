package readability;

public class CL {
    double score;
    TakeInput input;

    public CL(TakeInput input) {
        this.input = input;
    }

    void calculateScore() {
        double l = input.letters * 100.0 / input.words;
        double s = input.sentences * 100.0 / input.words;
        score = 0.0588 * l - 0.296 * s - 15.8;
        System.out.printf("Coleman%cLiau: %f (about %d year olds).%n", (char) 8211, score, calculateAge.age(score));
    }
}
