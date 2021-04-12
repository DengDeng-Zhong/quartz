package cn.targetpath.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2021/4/12 22:06
 */
public class TimerTest {
    public static void main(String[] args) {
        // 任务启动
        Timer t = new Timer();
        for (int i = 0; i < 2; i++) {
            TimerTask tiemrTask = new FooTimerTask("foo" + i);
            //任务添加
            t.scheduleAtFixedRate(tiemrTask,new Date(),2000);

            /*
            schedule 真正的执行时间 取决于上一次任务的结束时间   弊端:丢任务(少执行了次数)
            scheduleAtFixedRate 严格按照预设时间执行  弊端:执行时间会乱(提前执行)
             */
        }
    }
}

class FooTimerTask extends TimerTask{

    private String name;

    public FooTimerTask( String name) {
        this.name=name;
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