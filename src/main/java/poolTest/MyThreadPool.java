package poolTest;

import java.util.LinkedList;

public class MyThreadPool {

    private int poolSize;
    private LinkedList<Worker> workers = new LinkedList<Worker>();
    private LinkedList<Runnable> jobs = new LinkedList<Runnable>();


    public void initWorkers(int i) {

        for (int j = 0; j < i; i++) {
            Worker worker = new Worker();
            Thread thread = new Thread(new Worker(), String.format("worker_%d", j));
            thread.start();
            workers.add(worker);
        }
    }

    public void execute(Runnable runnable) {

        synchronized (jobs) {
            jobs.add(runnable);
            jobs.notify();
        }
    }

    private class Worker implements Runnable {

        private boolean running = true;
        private Runnable job;

        @Override
        public void run() {
            while (running) {
                synchronized (jobs) {
                    if (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    job = jobs.getFirst();
                    jobs.remove(0);
                }
                job.run();
            }
        }

        public void shutDown() {
            this.running = false;
        }
    }
}
