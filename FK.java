package readability;

public class FK {
    double score;
    TakeInput input;

    public FK(TakeInput input) {
        this.input = input;
    }

    void calculateScore() {
        score = 0.39 * input.words / input.sentences + 11.8 * input.syllables / input.words - 15.59;
        System.out.printf("Flesch%cKincaid: %f (about %d year olds).%n", (char) 8211, score, calculateAge.age(score));
    }
}
