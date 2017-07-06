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
  
  @Override
  public String toString() {
    return new String(combination);
  }

  public boolean isAtMax() {
    return atMax;
  }
}
