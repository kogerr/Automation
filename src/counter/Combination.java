package counter;

import java.util.Arrays;

public class Combination {
  private static final byte MIN_VALUE = 97;
  private static final byte MAX_VALUE = 122;
  private final byte[] combination;
  private boolean atMax;

  Combination(int length) {
    combination = new byte[length];
    Arrays.fill(combination, MIN_VALUE);
  }

  Combination(byte[] from) {
    combination = Arrays.copyOf(from, from.length);
  }

  Combination(Combination a, Combination b) {
      combination = new byte[a.combination.length + b.combination.length];
      System.arraycopy(a.combination, 0, combination, 0, a.combination.length);
      System.arraycopy(b.combination, 0, combination, a.combination.length, b.combination.length);
  }

  private void step(int cursor) {
    if (combination[cursor] < MAX_VALUE) {
      combination[cursor]++;
    } else {
      if (cursor > 0) {
        combination[cursor] = MIN_VALUE;
        step(cursor - 1);
      } else {
        atMax = true;
      }
    }
  }

  public void step() {
    step(combination.length - 1);
  }

  public void stepBy(int stepsToMake) {
      int i = 0;
      while (i++ < stepsToMake) {
          step();
      }
    }

  @Override
  public String toString() {
    return new String(combination);
  }

  public boolean isAtMax() {
    return atMax;
  }

  public static Combination maxCombination(int length) {
      byte[] combination = new byte[length];
      Arrays.fill(combination, MAX_VALUE);
      return new Combination(combination);
  }
}
