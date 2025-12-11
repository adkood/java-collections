package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Concurrency {

    public static CompletableFuture<String> getUserId() {
        return CompletableFuture.supplyAsync(() -> "userId");
    }

    public static CompletableFuture<Integer> getOrders(String userId) throws Exception {
        if (userId.equals("userId")) {
            throw new Exception("testing completable future");
        }
        return CompletableFuture.supplyAsync(() -> 100);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        CompletableFuture<?> future = getUserId().thenCompose(n -> {
            try {
                return getOrders(n);
            } catch (Exception e) {
                System.out.println("Custom : " + e);
            }
            return null;
        })
        .handle((result, ex) -> {
                    if (ex != null) {
                        System.out.println("Error handled: " + ex.getMessage());
                        return 0; // recover with 0
                    }
                    return result * 10; // normal flow
                });


        System.out.println(future.get());

    }

}
