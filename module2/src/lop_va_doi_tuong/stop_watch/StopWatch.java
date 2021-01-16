package lop_va_doi_tuong.stop_watch;

public class StopWatch {
    private int startTime,endTime;

    public StopWatch() {
    }
    public StopWatch(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public void start(){
        this.startTime = (int) System.currentTimeMillis();
    }
    public void end(){
        this.endTime = (int) System.currentTimeMillis();
    }
    public int getElapsedTime(){
        return this.endTime-this.startTime;
    }
}
