import java.util.concurrent.*;

public class FutureAndCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Object> callable = () ->{

            return "Return Some Result";
        };

        System.out.println("Submiting Callable");

        Future<Object> future = executorService.submit(callable);

        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        String result = (String) future.get();
        System.out.println(result);

        executorService.shutdown();
    }
}
