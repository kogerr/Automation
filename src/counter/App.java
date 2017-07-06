package counter;

class App {

  public static void main(String[] args) {
    String targetHashCode = new HashCalculator().hash("abbaaa");
    int length = 6;
    CombinationChecker checker = new CombinationChecker(new Combination(length), Combination.maxCombination(length), targetHashCode);
    checker.call();
    System.out.println("megvan");
  }

}
