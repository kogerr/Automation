package counter;

import java.util.concurrent.Callable;

public class CombinationChecker implements Callable<String> {
    private Combination combination;
    private final Combination toCombination;
    private final String targetHashCode;

    public CombinationChecker(Combination fromCombination, Combination toCombination, String targetHashCode) {
        combination = fromCombination;
        this.toCombination = toCombination;
        this.targetHashCode = targetHashCode;
    }

    @Override
    public String call() {
        String combinationAsHash;
        while (!combination.equals(toCombination)) {
//            System.out.println(combination);
            combinationAsHash = new HashCalculator().hash(combination.toString());
            if (combinationAsHash.equals(targetHashCode)) {
                return combination.toString();
            }
            combination.step();
        }
        return null;
    }
}
