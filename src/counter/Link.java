package counter;

public interface Link {
  void step();

  void giveLastLink(Link last);
}
