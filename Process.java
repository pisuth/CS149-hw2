import java.util.ArrayList;

public class Process implements Comparable<Object> {

    private String processName;
    private float arrivalTime = 0;
    private float runTime = 0;
    private int responseTime;
    private int completeTime;
    private int priority;
    private boolean isDone = false;

    public Process(float arrivalTime, float runTime, int priority, String name) {
        this.arrivalTime = arrivalTime;
        this.runTime = runTime;
        this.priority = priority;
        this.processName = name;
        this.responseTime = -999;
    }

    public String toString() {
        return "Arrival Time: " + arrivalTime + " Run Time: " + runTime
                + " Priority: " + priority + " ID: " + processName + " Response Time: " + responseTime + " Complete Time: " + completeTime;
    }

    public float getArrivalTime() {
        return arrivalTime;
    }

    public int getCompleteTime() {
        return completeTime;
    }

    public int getResponseTime() {
        return responseTime;
    }
    
    public int getWaitTime() {
        return completeTime - responseTime;
    }

    public int getTurnAroundTime(){
        return completeTime - (int)arrivalTime;
    }
    
    public float getRunTime() {
        return runTime;
    }

    public int getPriority() {
        return priority;
    }

    public String getProcessName() {
        return processName;
    }
    
    public void setIsDone() {
        isDone = true;
    }
    

    public void setResponseTime(int i) {
        responseTime = i;
    }
    
    public void setCompleteTime(int i) {
        completeTime = i;
    }

    public boolean isResponseTimeSet() {
        return responseTime != -999;
    }

    public boolean isDone() {
        //return runTime <= 0;
        return isDone;
    }

    @Override
    public int compareTo(Object o) {
        float nxt_process_AT = ((Process) o).getArrivalTime();
        /**
         * take my arrival time and compare to another arrivial time if my is
         * bigger than another than replace another with my else if my is
         * smaller than another then use my as lower else they are the same
         */
        // checks if my arrival time is greater than the next arrival time
        if (arrivalTime > nxt_process_AT) {
            return -1;
        } else if (arrivalTime < nxt_process_AT) {
            return 1;
        } else {
            return 0;
        }

    }

}
