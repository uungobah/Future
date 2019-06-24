import java.util.concurrent.*;

public class FutureCancelExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();

        Future<String> future = executorService.submit(()->{
           Thread.sleep(2000);
            return "Hello From Callable";
        });

        while (!future.isDone()){
            System.out.println("Task Still Running");
            Thread.sleep(200);
            double elapsedTimeInSec = (System.nanoTime() -startTime)/1000000000.0;

            if (elapsedTimeInSec > 1){
                future.cancel(true);
            }
        }

        if (future.isCancelled()){
            System.out.println("Task was cancelled");
        }else{
            System.out.println("Task completed! Retrieving the result");
            String result = future.get();
            System.out.println(result);
        }
        executorService.shutdown();
    }
}
