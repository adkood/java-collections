import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static CompletableFuture<String> getUserByUserId(String userId) {
        System.out.println("Fetching user for userId : " + userId);
        if(userId.equals("101")) throw new RuntimeException("Something went wrong");
        return CompletableFuture.completedFuture("ashutosh");
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<String> userId = CompletableFuture.supplyAsync(() -> {
            System.out.println("UserId fetched for user");
            return "101";
        });
        
        CompletableFuture<String> user = userId.thenCompose(n -> getUserByUserId(n)).handle((res, err) -> {
            if(res == null) {
                System.out.println("Something went wrong");
                return "Default user"; 
            }
            return res;
        });

        System.out.println(user.get());
    }

}
