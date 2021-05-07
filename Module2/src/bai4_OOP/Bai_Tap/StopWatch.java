package bai4_OOP.Bai_Tap;

import java.util.Arrays;

//import java.time.LocalTime;
public class StopWatch {
    private Long startTime, endTime;


    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public Long start() {
        return startTime = System.currentTimeMillis();
    }

    public Long end() {
        return endTime = System.currentTimeMillis();
    }

    public Long getElapsedTime() {
        return endTime-startTime;
    }


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] arr=new int[10000000];
        stopWatch.start();
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int) (Math.random()*100);
        }
        Arrays.sort(arr);
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime()+"mls");
    }

}

