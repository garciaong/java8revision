package simply.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * Execution result :
         * First attempt 1
         * Second attempt 2
         * 
         * Future result is 1
         * Future result is 2
         * Future result is 3
         */
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Callable<Counter> callable = () -> {
            Counter c = new Counter();
            c.increse();
            return c;
        };
        Future<Counter> future = executor.submit(callable);
        if (future.get() != null) {
            System.out.println(String.format("First attempt %d", future.get().getCounter()));
        }
        future = executor.submit(callable);
        if (future.get() != null) {
            System.out.println(String.format("Second attempt %d", future.get().getCounter()));
        }
        executor.shutdown();

        System.out.println();
        Callable<Integer> runningNo = new RunningNo();
        Collection<Callable<Integer>> callables = new ArrayList<>();
        callables.add(runningNo);
        callables.add(runningNo);
        callables.add(runningNo);
        ExecutorService executor2 = Executors.newFixedThreadPool(1000);
        List<Future<Integer>> taskFutureList = executor2.invokeAll(callables);
        taskFutureList.stream().forEach(futureObj -> {
            try {
                System.out.println(String.format("Future result is %d", futureObj.get().intValue()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor2.shutdown();
    }

    public static class Counter {
        private static int counter;

        public int getCounter() {
            return counter;
        }

        public void increse() {
            counter++;
        }
    }

    public static class RunningNo implements Callable<Integer> {
        private static int runningNo = 0;

        @Override
        public Integer call() throws Exception {
            runningNo++;
            return Integer.valueOf(runningNo);
        }

    }

}
