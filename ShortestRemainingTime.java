
import java.util.ArrayList;

public class ShortestRemainingTime extends AlgStrategies {

    public static ArrayList<Process> ShortestRemainingTime(ArrayList<Process> list) {
        Process process;
        ArrayList<Process> processList = new ArrayList<>(list);
        ArrayList<Process> processResult = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int SRTindex = getSRTIndex(processList, i);
            System.out.println(SRTindex);
            if (!processList.isEmpty() && SRTindex != -1) {
                process = processList.get(SRTindex);
                if (process != null) {
                    if (!process.isResponseTimeSet()) {
                        process.setResponseTime(i);
                    }
                    process.setIsDone();
                    if (process.isDone()) {
                        process.setCompleteTime(i);
                        processResult.add(process);
                        processList.remove(process);
                    }
                }
            } else {
                //break;
            }
        }
        return processResult;

    }

    public static int getSRTIndex(ArrayList<Process> list, int quanta) {
        int minIndex = -1;
        for (int i = list.size() - 1; i >= 0 && quanta >= list.get(i).getArrivalTime(); i--) {
            if (minIndex == -1) {
                minIndex = i;
            }
            if (list.get(i).getRunTime() < list.get(minIndex).getRunTime()) {
                minIndex = i;
            }
        }
        return minIndex;

    }
}
