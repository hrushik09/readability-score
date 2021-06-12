package readability;

public class SMOG {
    double score;
    TakeInput input;

    public SMOG(TakeInput input) {
        this.input = input;
    }

    void calculateScore() {
        score = 1.043 * Math.sqrt(input.polysyllables * 30.0 / input.sentences) + 3.1291;
        System.out.printf("Simple Measure of Gobbledygook: %f (about %d year olds).%n", score, calculateAge.age(score));
    }
}
