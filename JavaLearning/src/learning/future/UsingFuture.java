package learning.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SquareCalculator {
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public Future<Integer> calculate(Integer num) {
		//Here we are submitting a Callable via Lambda Expression to the Executor:
		return executor.submit(() -> {
			Thread.sleep(3000);
			return num*num;
			});
	}
	
}

public class UsingFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Future class represents a future result of an asynchronous computation.
		//The Result will eventually appear in the Future after the processing is complete:
		
		//Long Running Methods are good candidates for asynchronous processing,
		//as we can execute other processes while waiting for the task encapsulated
		//in the Future to complete. For example:
		//	* Computational intensive processes(mathematical or scientific calculation).
		//	* Manipulating large data structures(big data).
		//	* Remote method calls(downloading files, HTTP Scrapping, Web Services).
		Future<Integer> future = new SquareCalculator().calculate(11);
		
		while(!future.isDone()) {
			System.out.println("Calculating...");
			Thread.sleep(300);
			
			//We can use <boolean cancel(boolean)> method on Future to cancel execution.
			//Has no impact if the Thread has already completed, or has already been cancelled,
			//or couldn't be cancelled due to some other reason.
			
			//If this method is called before the Thread starts execution then its promptly cancelled,
			//but if the Thread has started execution but not yet completed, then the boolean input
			//parameter, mayInterruptIfRunning determines whether the Thread running this task
			//(when known by the implementation) is interrupted in an attempt to stop the task.
			//The return value from this method doesn't necessarily indicate whether the task has been
			//cancelled or not, rather use isCancelled() method to check.
			
			//Also isDone() method will return true if either the Task completes or if it is cancelled
			future.cancel(false);
		}
		
		Integer result = 0;
		
		if (!future.isCancelled()) {
			//Just that in case if the Task was cancelled, subsequent call to .get() method
			//will throw CancellationException which is a RuntimeException.
			result = future.get();
			
			//Another flavor of get() method is get(long timeout, TimeUnit unit),
			//This method will wait for the mentioned amount of Time to get the result from future
			//If the result is not produced in the specified amount of timeout then
			//TimeoutException will be thrown which is a CheckedException.
//			result = future.get(10, TimeUnit.SECONDS);
		}
		
		System.out.println("Result is: "+result);
	}

}
