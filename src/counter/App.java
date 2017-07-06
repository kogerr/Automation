package counter;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class App {

  public static void main(String[] args) throws Exception {
    String target = "dc127f5d2483352fd20eaddb38feb6d2";
    Executor executor = Executors.newFixedThreadPool(30);
    Callable<String>[] commands = new TaskArranger(30, target).getTasks();
    ExecutorCompletionService<String> executorService = new ExecutorCompletionService<>(executor);
    long startTime = System.nanoTime();

    for (Callable<String> command : commands) {
        executorService.submit(command);
    }

    Future<String> result = executorService.take();
    long doneTime = System.nanoTime();
    System.out.println(result.get());

    System.out.println(doneTime - startTime);
  }
}
