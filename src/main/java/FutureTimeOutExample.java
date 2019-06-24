import java.util.concurrent.*;

public class FutureTimeOutExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(()->{
            Thread.sleep(2000);
           return "Hi I'am Callable";
        });

        try {
            String result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        }catch (TimeoutException e){
            System.out.println("Time Out");
        }


        executorService.shutdown();
    }
}
