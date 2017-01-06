package Lesson1ThreadCreation;

import java.util.concurrent.TimeUnit;

/**
 * Created by karan on 1/6/17.
 */



public class ThreadCreation1 {
    public static void main(String[] args) {
        System.out.println("Main Thread start");
        Thread t1 = new ThreadTask();
        Thread t2= new ThreadTask();
        System.out.println("Main Thread ends");
    }
}


class ThreadTask extends Thread{

    private static int count = 0;
    private int id;

    public void run(){
        for(int i=0; i<10;i++) {
            System.out.println("Value of i=="+i +" and id=="+id);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ThreadTask(){
        this.id = ++count;
        this.start();
    }
}




