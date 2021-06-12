package readability;

public class ARI {
    double score;
    TakeInput input;

    public ARI(TakeInput input) {
        this.input = input;
    }

    void calculateScore() {
        score = 4.71 * input.chars / input.words + 0.5 * input.words / input.sentences - 21.43;
        System.out.printf("Automated Readability Index: %f (about %d year olds).%n", score, calculateAge.age(score));
    }
}
