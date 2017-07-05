package counter;

public class Combination {
<<<<<<< HEAD

=======
  private Link lastLink;
  private boolean finished;
  
  private Link finishedChecker = new Link(){

    @Override
    public void step() {
      finished = true;
    }

    @Override
    public void giveLastLink(Link last) {
      lastLink = last;
    }
    
  };
>>>>>>> started counter exercise
}
