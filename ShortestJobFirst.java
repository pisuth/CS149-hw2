
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

public class ShortestJobFirst extends AlgStrategies {

    public static ArrayList<Process> ShortestJobFirst(ArrayList<Process> list) {

        Process process;
        ArrayList<Process> processList = new ArrayList<>(list);
        ArrayList<Process> processResult = new ArrayList<>();
      
        for (int i = 0; i < 100; i++) {
            if (!processList.isEmpty()) {
                int SJFindex = getSJFIndex(processList);
                process = processList.get(SJFindex);

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
                break;
            }
        }
        return processResult;
    }

    public static int getSJFIndex(ArrayList<Process> list) {
        int minIndex;
        if (list.isEmpty()) {
            minIndex = -1;
        } else {
            final ListIterator<Process> itr = list.listIterator();
            Process min = itr.next();
            minIndex = itr.previousIndex();
            while (itr.hasNext()) {
                final Process curr = itr.next();
                Float p1 = curr.getRunTime();
                Float p2 = min.getRunTime();
                if (p1.compareTo(p2) < 0) {
                    min = curr;
                    minIndex = itr.previousIndex();
                }
            }
        }
        return minIndex;
    }
}
