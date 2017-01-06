package Lesson2ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by karan on 1/6/17.
 */
public class SingleThreadExecutorCreation {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new TaskC());
        executorService.execute(new TaskC());
        executorService.execute(new TaskC());
        executorService.execute(new TaskC());
        executorService.shutdown();
    }
}


class TaskC implements Runnable {

    private int id;
    private static int count = 0;

    @Override
    public void run() {
        System.out.println("Thread "+id+ " started");

        for(int i=0;i<1000000;i++) {
            try{
                TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Value of i=="+i+" and id=="+id);
        }
        System.out.println("##########Thread "+id+ " completed********");

    }

    public TaskC() {
        this.id = ++count;
    }
}

