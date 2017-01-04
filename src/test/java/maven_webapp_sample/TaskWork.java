package maven_webapp_sample;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.kkdm.worker.service.WorkService;
import com.quya.core.utils.DateTimeUtils;

public class TaskWork {
	public static ScheduledExecutorService service;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable runable = new Runnable() {
			
			@Override
			public void run() {
				WorkService workService = new WorkService();
				int state = workService.checkWork();
				if(state == WorkService.WORK_STATE_END){
					service.shutdown();
				}
			}
		};
		//
		service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runable, 0, 5, TimeUnit.SECONDS);
	
	}

}
