package maven_webapp_sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.joda.time.DateTime;
import org.junit.Test;

import com.kkdm.worker.service.WorkService;
import com.kkdm.worker.service.workers.GetInfoWorker;
import com.quya.core.utils.DateTimeUtils;
import com.quya.core.utils.MysqlUtils;

public class WorkServiceTest {

	
	@Test
	public void checkWorkTest(){
		WorkService workService = new WorkService();
		workService.checkWork();
	}
	
	@Test
	public void getInfoWorkerTest(){
		GetInfoWorker.getInstance().getInfo(null);
		
	}
	@Test
	public void timerTest(){
		System.out.println(DateTimeUtils.getYestoday());
//		MysqlUtils.truncate("tbTopicTags");
	}
}
