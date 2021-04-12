package cn.targetpath;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2021/4/12 22:53
 */
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledThreadPool.scheduleAtFixedRate(new Task("Task-"+i), 2,2, TimeUnit.SECONDS);
        }
    }
}
class Task implements Runnable{
    private String name;

    public Task(String name){
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println("name="+name+",startTime="+new Date());
            Thread.sleep(3 * 1000);
            System.out.println("name="+name+",endTime="+new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}