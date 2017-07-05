package java.util.concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class MyLittleExecutor implements Executor {
    Queue<Runnable> jobs = new LinkedList<>();

    public MyLittleExecutor() {
        worker.start();
        worker.setDaemon(true);
    }

    @Override
    public void execute(Runnable command) {
        jobs.add(command);
    }

    private final Thread worker = new Thread("Worker") {
        @Override
        public void run() {
            while(!Thread.interrupted()) {
                if (!jobs.isEmpty()) {
                    jobs.poll().run();
                }
            }
        }
    };

    public void terminate() {
        worker.interrupt();
    }
}
