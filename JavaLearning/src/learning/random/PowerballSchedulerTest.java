package learning.random;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PowerballSchedulerTest {
	
	private static final int dailyPauseTimeHour = 0;
	private static final int dailyPauseTimeMinute = 2;
	private static final int dailyPauseTimeSecond = 0;
	
	private static final int dailyResumeTimeHour = 6;
	private static final int dailyResumeTimeMinute = 0;
	private static final int dailyResumeTimeSecond = 10;
	
	public static void main(String[] args) {
//		LocalDateTime localDateTime = LocalDateTime.now();
//		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		ZonedDateTime koreanDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		
//		System.out.println("Local Date Time is: "+localDateTime);
//		System.out.println("UTC Date Time is: "+utcDateTime);
		System.out.println("Korean Standard Time is: "+koreanDateTime);
		
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted Korean Date Time is: "+koreanDateTime.format(formatter)+"\n\n\n");
		
//		int dailyPauseTimeHour = 0;
//		int dailyPauseTimeMinute = 2;
//		int dailyPauseTimeSecond = 0;
//		
//		int dailyResumeTimeHour = 6;
//		int dailyResumeTimeMinute = 0;
//		int dailyResumeTimeSecond = 10;
//		
//		LocalDateTime.parse("2020-02-20T06:30:00");
//		DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd"); LocalDateTime datetime = LocalDateTime.parse(input, oldPattern); String output = datetime.format(newPattern);
		
		ZonedDateTime todaysPauseTime = koreanDateTime.withHour(dailyPauseTimeHour).withMinute(dailyPauseTimeMinute).withSecond(dailyPauseTimeSecond).withNano(0);
		ZonedDateTime todaysResumeTime = koreanDateTime.withHour(dailyResumeTimeHour).withMinute(dailyResumeTimeMinute).withSecond(dailyResumeTimeSecond).withNano(0);
		
		System.out.println("Today's Pause Time "+todaysPauseTime);
		System.out.println("Today's Resume Time "+todaysResumeTime);
		
		ZonedDateTime pauseTime;
		ZonedDateTime resumeTime;
		
		boolean isActive = false;
		
		//Find if currently its Resume Time or Block Time:
		if (todaysResumeTime.isAfter(todaysPauseTime)) {
			isActive = koreanDateTime.isAfter(todaysResumeTime) ||
					koreanDateTime.isEqual(todaysResumeTime);
			
			if (isActive) {
				//In this Case, Scheduler Timings should be incremented by 1 Day:
				resumeTime = todaysResumeTime.plusDays(1);
				pauseTime = todaysPauseTime.plusDays(1);
			} else {
				resumeTime = todaysResumeTime;
				pauseTime = todaysPauseTime.plusDays(1);
			}
		} else {
			isActive = koreanDateTime.isBefore(todaysPauseTime) &&
					(koreanDateTime.isAfter(todaysResumeTime) ||
							koreanDateTime.isEqual(todaysResumeTime));
			
			if (isActive) {
				resumeTime = todaysResumeTime.plusDays(1);
				pauseTime = todaysPauseTime.plusDays(1);
			} else {
				if (koreanDateTime.isAfter(todaysResumeTime) ||
						koreanDateTime.isEqual(todaysResumeTime))
					resumeTime = todaysResumeTime.plusDays(1);
				else
					resumeTime = todaysResumeTime;
				
				if (koreanDateTime.isAfter(todaysPauseTime) ||
						koreanDateTime.isEqual(todaysPauseTime))
					pauseTime = todaysPauseTime.plusDays(1);
				else
					pauseTime = todaysPauseTime;
				
			}
		}
		
		System.out.println("\n\nCurrent Active Status is: "+isActive);
		System.out.println("Upcoming Pause Time "+pauseTime);
		System.out.println("Upcoming Resume Time "+resumeTime);
		
		//If Current Time is between the Active Time Duration, start the Link Service right away:
		//Also schedule Link Service Pausing Thread & Link Service Reactivation Thread accordingly:
		
		//If Current Time is between Inactive Time Duration,
		//Schedule Link Service Initialization/Reactivation Thread & 
		//Schedule Link Service Pausing Thread:
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
		
		PowerballSchedulerTest outerInstance = new PowerballSchedulerTest();
		
		ScheduledFuture<?> resultUpdater = null;
		
		//Possible ways to Achieve:
		//Way 1:
		//Initialize the Link Game(but Don't schedule the Game Updater)
		//Check if this is Active Period or Inactive Period:
		//If Active Period, schedule the Game Updater,
		//Schedule the Deactivation Thread(In Deactivation Thread, schedule the Activation Thread(In Activation Thread, schedule the Game Updater))
		//If Inactive Period, schedule the Activation Thread(In Activation Thread, schedule the Game Updater & schedule The Deactivation Thread).
		
		if (isActive) {
			//Currently Activation Time is going On:
			//That means De-activation Time surely comes later:
			//Maybe in same Day or Maybe in Next Day:
			
			//So have to Start the Update Timer(1) & have to Schedule De-activation Thread(2):
			//De-Activation Thread will schedule the Activation Thread internally:
			
			
			//1. Starting Update Timer:
			resultUpdater = ses.scheduleAtFixedRate((outerInstance).new UpdateRemainingTimer(), 0, 1, TimeUnit.SECONDS);
			
			//2. Schedule De-Activation Thread:
			long deactivationDelay = pauseTime.toEpochSecond()-koreanDateTime.toEpochSecond();
			
			ses.schedule((outerInstance).new DeactivationThread(ses, resumeTime, resultUpdater), deactivationDelay, TimeUnit.SECONDS);
			
			System.out.println("Deactivation Thread schdeuled for: "+pauseTime);
			
		} else {
			//Currently De-Activation Time is going On:
			//That means Activation Time surely comes later:
			//Maybe in same Day or Maybe in Next Day:
			
			//So have to Schedule Activation Thread(1):
			//Activation Thread will Start the Update Timer & Schedule De-Activation Thread:
			
			//1. Schedule Activation Thread:
			long activationDelay = resumeTime.toEpochSecond()-koreanDateTime.toEpochSecond();
			
			ses.schedule((outerInstance).new ActivationThread(ses, pauseTime), activationDelay, TimeUnit.SECONDS);
			
			System.out.println("Activation Thread scheduled for: "+resumeTime);
			
		}
		
	}
	
	class UpdateRemainingTimer implements Runnable {
		
		@Override
		public void run() {
			System.out.println("Its Active Time, I'm doing my work...");
		}
		
	}
	
	class ActivationThread implements Runnable {
		
		private final ScheduledExecutorService ses;
		private final ZonedDateTime upcomingDeactivationTime;
		private ScheduledFuture<?> resultUpdater;
		
		public ActivationThread(ScheduledExecutorService ses, ZonedDateTime upcomingDeactivationTime) {
			this.ses = ses;
			this.upcomingDeactivationTime = upcomingDeactivationTime;
		}
		
		@Override
		public void run() {
			//Initialize & Start Update Timer:
			resultUpdater = ses.scheduleAtFixedRate((new PowerballSchedulerTest()).new UpdateRemainingTimer(), 0, 1, TimeUnit.SECONDS);
			
			//Schedule Deactivation Thread:
			ZonedDateTime koreanDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
			long deactivationDelay = upcomingDeactivationTime.toEpochSecond()-koreanDateTime.toEpochSecond();
			
			//Calculate Next Activation Time to provide to Deactivation Thread:
			ZonedDateTime upcomingResumeTime = koreanDateTime.withHour(dailyResumeTimeHour).withMinute(dailyResumeTimeMinute).withSecond(dailyResumeTimeSecond).withNano(0);
			
			if (upcomingResumeTime.isBefore(koreanDateTime))
				upcomingResumeTime = upcomingResumeTime.plusDays(1);
			
			ses.schedule((new PowerballSchedulerTest()).new DeactivationThread(ses, upcomingResumeTime, resultUpdater), deactivationDelay, TimeUnit.SECONDS);
			
			System.out.println("Have run Activation Thread @"+koreanDateTime+
					"\nHave started Game Updater Thread"+
					"\nDe-Activation Thread is scheduled to run @"+upcomingDeactivationTime);
			
		}
		
	}
	
	class DeactivationThread implements Runnable {
		
		private final ScheduledExecutorService ses;
		private final ZonedDateTime upcomingActivationTime;
		private final ScheduledFuture<?> resultUpdater;
		
		public DeactivationThread(ScheduledExecutorService ses,
				ZonedDateTime upcomingActivationTime,
				ScheduledFuture<?> resultUpdater) {
			this.ses =ses;
			this.upcomingActivationTime = upcomingActivationTime;
			this.resultUpdater = resultUpdater;
		}
		
		@Override
		public void run() {
			//Stop Update Timer:
			resultUpdater.cancel(true);
			
			//Schedule Activation Thread:
			ZonedDateTime koreanDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
			long activationDelay = upcomingActivationTime.toEpochSecond()-koreanDateTime.toEpochSecond();
			
			//Calculate Next Deactivation Time to provide to Activation Thread:
			ZonedDateTime upcomingPauseTime = koreanDateTime.withHour(dailyPauseTimeHour).withMinute(dailyPauseTimeMinute).withSecond(dailyPauseTimeSecond).withNano(0);
			
			if (upcomingPauseTime.isBefore(koreanDateTime))
				upcomingPauseTime = upcomingPauseTime.plusDays(1);
			
			ses.schedule((new PowerballSchedulerTest()).new ActivationThread(ses, upcomingPauseTime), activationDelay, TimeUnit.SECONDS);
			
			System.out.println("Have run Deactivation Thread @"+koreanDateTime+
					"\nHave stopped Game Updater Thread"+
					"\nActivation Thread is scheduled to run @"+upcomingActivationTime);
			
		}
		
	}
	
}
