package counter;

import java.util.concurrent.Callable;

public class TaskArranger {
    private static final int NUMBER_OF_LETTERS = 35;
    private final Callable<String>[] tasks;

    public TaskArranger(int divideInto, String target) {
        tasks = new CombinationChecker[divideInto];
        arrange(divideInto, target);
    }

    private void arrange(int divideInto, String target) {
        int divideBy = NUMBER_OF_LETTERS / divideInto;
        Combination lastFiveLetters = new Combination(5);
        Combination firstLetter = new Combination(1);
        Combination fromCombination;
        Combination toCombination;

        int i = 0;
        while (i < divideInto) {
            fromCombination = new Combination(firstLetter, lastFiveLetters);
            if (i < divideInto - 1) {
                firstLetter.stepBy(divideBy);
                toCombination = new Combination(firstLetter, lastFiveLetters);
            } else {
                toCombination = Combination.maxCombination(6);
            }
            tasks[i++] = new CombinationChecker(fromCombination, toCombination, target);
        }
    }

    public Callable<String>[] getTasks() {
        return tasks;
    }
}
