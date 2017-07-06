package counter;

public class Letter implements Link {
  private byte value = MIN_VALUE;
  private final Link previous;
  private static final byte MIN_VALUE = 97;
  private static final byte MAX_VALUE = 122;

  private Letter(Link previous, int linksLeft) {
    this.previous = previous;
    if (linksLeft > 0) {
      new Letter(this, linksLeft - 1);
    } else {
      giveLastLink(this);
    }
  }

  @Override
  public void step() {
    if (value < MAX_VALUE) {
      value++;
    } else {
      value = MIN_VALUE;
      previous.step();
    }
  }

  byte getValue() {
    return value;
  }
  
  public void giveLastLink(Link last) {
    previous.giveLastLink(last);
  }
}
