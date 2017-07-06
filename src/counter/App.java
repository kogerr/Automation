package counter;

class App {

  public static void main(String[] args) {
    Combination combination = new Combination(6);
    while (!combination.isAtMax()) {
      System.out.println(combination);
      combination.step();
    }
  }

}
