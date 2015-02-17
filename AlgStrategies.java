
import java.util.*;

public abstract class AlgStrategies {

    public static void main(String[] args) {

        //runFCFS();
        //runSJF();
        runSRT();
        
        //runRR();
        //runHPF();
    }

    public static ArrayList<Process> createProcessList(int num) {
        Random randomNum = new Random(0);
        ArrayList<Process> processList = new ArrayList<Process>();
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int i = 0; i < num; i++) {
            int nameIndex = randomNum.nextInt(6) + 1;
            processList.add(new Process(randomNum.nextFloat() * 100, randomNum.nextFloat() * 10 + (float) .1, randomNum.nextInt(4) + 1, names[nameIndex].toUpperCase()));
            Collections.sort(processList);
        }
        return processList;
    }

    public static ArrayList<Process> FirstComeFirstServed(ArrayList<Process> processList) {
        return processList;
    }

    public static ArrayList<Process> ShortestJobFirst(ArrayList<Process> processList) {
        return processList;
    }

    public static ArrayList<Process> ShortestRemainingTime(ArrayList<Process> processList) {
        return processList;
    }

    /*
     public static ArrayList<Process> RoundRobin(ArrayList<Process> processList) {
     return processList;
     }

     public static ArrayList<Process> HighestPriorityFirst(ArrayList<Process> processList) {
     return processList;
     }     

     public static ArrayList<Process> HighestPriorityFirstNP(ArrayList<Process> processList) {
     return HighestPriorityFirstNP(processList);
     }
     */
    public static void print(ArrayList<Process> arr) {
        for (Process x : arr) {
            System.out.println(x);
        }
    }

    public static void statusReport(ArrayList<Process> list) {
        float totalWaitTime = 0;
        float totalTurnAroundTime = 0;
        for (Process p : list) {
            totalWaitTime += p.getWaitTime();
            totalTurnAroundTime += p.getTurnAroundTime();
        }
        System.out.format("Average WaitTime is: %f \n", totalWaitTime / list.size());
        System.out.format("Average Turnaround is: %f \n", totalTurnAroundTime / list.size());
        System.out.format("Average Throughput is: %f \n ", list.size() * (1.0 / 100));

    }

    public static void runFCFS() {
        //Create processes for FCFS
        ArrayList<Process> processListFCFS = createProcessList(100);
        int runNum = 0;
        for (Process process : processListFCFS) {
            System.out.println("#" + runNum);
            System.out.println("Arrival Time: " + process.getArrivalTime()
                    + "; Run Time: " + process.getRunTime() + "; Priority: "
                    + process.getPriority() + "; Process Name: " + process.getProcessName()
                    + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
                    + process.getCompleteTime());
            runNum++;
        }
        System.out.println("\n\n");

        //Run First-Come First-Served
        System.out.println("===========================");
        System.out.println("First-Come First-Served");
        System.out.println("===========================");
        ArrayList<Process> FCFSList = FirstComeFirstServed.FirstComeFirstServed(processListFCFS);
        runNum = 0;
        for (Process process : FCFSList) {
            System.out.println("#" + runNum);
            System.out.println("Arrival Time: " + process.getArrivalTime()
                    + "; Run Time: " + process.getRunTime() + "; Priority: "
                    + process.getPriority() + "; Process Name: " + process.getProcessName()
                    + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
                    + process.getCompleteTime());
            runNum++;
        }
        System.out.println("---------------------------");
        statusReport(FCFSList);
        System.out.println("===========================\n\n");
    }

    public static void runSJF() {
        //Create processes for SJF
        ArrayList<Process> processListSJF = createProcessList(100);
        int runNum = 0;
        for (Process process : processListSJF) {
            System.out.println("#" + runNum);
            System.out.println("Arrival Time: " + process.getArrivalTime()
                    + "; Run Time: " + process.getRunTime() + "; Priority: "
                    + process.getPriority() + "; Process Name: " + process.getProcessName()
                    + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
                    + process.getCompleteTime());
            runNum++;
        }
        System.out.println("\n\n");

        //Run Shortest Job First
        System.out.println("===========================");
        System.out.println("Shortest Job First");
        System.out.println("===========================");
        ArrayList<Process> SJFList = ShortestJobFirst.ShortestJobFirst(processListSJF);
        runNum = 0;
        for (Process process : SJFList) {
            System.out.println("#" + runNum);
            System.out.println("Arrival Time: " + process.getArrivalTime()
                    + "; Run Time: " + process.getRunTime() + "; Priority: "
                    + process.getPriority() + "; Process Name: " + process.getProcessName()
                    + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
                    + process.getCompleteTime());
            runNum++;
        }
        System.out.println("---------------------------");
        statusReport(SJFList);
        System.out.println("===========================\n\n");
    }

    public static void runSRT() {
        //Create processes for SJF
        ArrayList<Process> processListSRT = createProcessList(100);
        int runNum = 0;
        for (Process process : processListSRT) {
            System.out.println("#" + runNum);
            System.out.println("Arrival Time: " + process.getArrivalTime()
                    + "; Run Time: " + process.getRunTime() + "; Priority: "
                    + process.getPriority() + "; Process Name: " + process.getProcessName()
                    + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
                    + process.getCompleteTime());
            runNum++;
        }
        System.out.println("\n\n");

        //Run Shortest Job First
        System.out.println("===========================");
        System.out.println("Shortest Remaining Time First");
        System.out.println("===========================");
        ArrayList<Process> SRTList = ShortestRemainingTime.ShortestRemainingTime(processListSRT);
        runNum = 0;
        for (Process process : SRTList) {
            System.out.println("#" + runNum);
            System.out.println("Arrival Time: " + process.getArrivalTime()
                    + "; Run Time: " + process.getRunTime() + "; Priority: "
                    + process.getPriority() + "; Process Name: " + process.getProcessName()
                    + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
                    + process.getCompleteTime());
            runNum++;
        }
        System.out.println("---------------------------");
        statusReport(SRTList);
        System.out.println("===========================\n\n");
    }
    /*
     public static void runRR() {
     //Create processes for SJF
     ArrayList<Process> processListRR = createProcessList(100);
     int runNum = 0;
     for (Process process : processListRR) {
     System.out.println("#" + runNum);
     System.out.println("Arrival Time: " + process.getArrivalTime()
     + "; Run Time: " + process.getRunTime() + "; Priority: "
     + process.getPriority() + "; Process Name: " + process.getProcessName()
     + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
     + process.getCompleteTime());
     runNum++;
     }
     System.out.println("\n\n");

     //Run Shortest Job First
     System.out.println("===========================");
     System.out.println("Round Robin");
     System.out.println("===========================");
     ArrayList<Process> RRList = RoundRobin.RoundRobin(processListRR);
     runNum = 0;
     for (Process process : RRList) {
     System.out.println("#" + runNum);
     System.out.println("Arrival Time: " + process.getArrivalTime()
     + "; Run Time: " + process.getRunTime() + "; Priority: "
     + process.getPriority() + "; Process Name: " + process.getProcessName()
     + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
     + process.getCompleteTime());
     runNum++;
     }
     System.out.println("---------------------------");
     statusReport(RRList);
     System.out.println("===========================\n\n");
     }
    
     public static void runHPF() {
     //Create processes for SJF
     ArrayList<Process> processListHPF = createProcessList(100);
     int runNum = 0;
     for (Process process : processListHPF) {
     System.out.println("#" + runNum);
     System.out.println("Arrival Time: " + process.getArrivalTime()
     + "; Run Time: " + process.getRunTime() + "; Priority: "
     + process.getPriority() + "; Process Name: " + process.getProcessName()
     + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
     + process.getCompleteTime());
     runNum++;
     }
     System.out.println("\n\n");

     //Run Shortest Job First
     System.out.println("===========================");
     System.out.println("Round Robin");
     System.out.println("===========================");
     ArrayList<Process> HPFList = HighestPriorityFirst.HighestPriorityFirst(processListHPF);
     runNum = 0;
     for (Process process : HPFList) {
     System.out.println("#" + runNum);
     System.out.println("Arrival Time: " + process.getArrivalTime()
     + "; Run Time: " + process.getRunTime() + "; Priority: "
     + process.getPriority() + "; Process Name: " + process.getProcessName()
     + "; Response Time: " + process.getResponseTime() + "; Complete Time: "
     + process.getCompleteTime());
     runNum++;
     }
     System.out.println("---------------------------");
     statusReport(HPFList);
     System.out.println("===========================\n\n");
     }
     */

}
