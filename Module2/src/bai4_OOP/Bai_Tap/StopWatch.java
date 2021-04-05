package bai4_OOP.Bai_Tap;

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

    private static int sum() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    private static void doJob(int count) {

        for (int i = 0; i < count; i++) {
            sum();
        }
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        doJob(100000000);
        stopWatch.end();
        System.out.println("Distance time in milli second: " + stopWatch.getElapsedTime());
    }

}

