package lop_va_doi_tuong.stop_watch;

import java.util.Arrays;

public class StopWatchMain {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] number = new int[1000000];
        for (int i = 0; i < number.length; i++) {
            number[i] = (int) (Math.random()*1000000);
        }
        stopWatch.start();
        System.out.println(stopWatch.getStartTime());
        Arrays.sort(number);
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
