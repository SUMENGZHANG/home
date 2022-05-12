package sumeng.delay;



import sumeng.home.mapper.LogMapper;

import java.util.concurrent.DelayQueue;

public class DelayMessageConsumer extends Thread{

     private final DelayQueue<DelayMessage> queue;
     public DelayMessageConsumer(DelayQueue<DelayMessage> queue){
         this.queue = queue;
     }
    @Override
    public void run() {
        DelayMessage message  = null;
        try {
            while(true){
                System.out.println("开始执行。。。。。"+System.currentTimeMillis());
                message = queue.take();
                System.out.println("取任务。。。。。"+System.currentTimeMillis());
                message.execute();
                if(queue.size()==0) this.interrupt();
            }
        } catch (InterruptedException e) {
            System.out.println("执行延迟任务结束");

        }
    }
}
