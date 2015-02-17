import java.util.ArrayList;

public class FirstComeFirstServed extends AlgStrategies {

    public static ArrayList<Process> FirstComeFirstServed(ArrayList<Process> list) {

        Process process;
        int maxQuanta = 0;
        ArrayList<Process> processList = new ArrayList<>(list);
        ArrayList<Process> processResult = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            if (!processList.isEmpty()) {
                process = processList.get(processList.size() - 1);
                if (process.getArrivalTime() <= i) {
                    if (!process.isResponseTimeSet()) {
                        process.setResponseTime(i);
                    }
                    process.decreaseRunTime();
                    if (process.isDone()) {
                        process.setCompleteTime(i);
                        processList.remove(processList.size() - 1);
                        processResult.add(process);
                    }
                    maxQuanta = 0;
                } else {
                    maxQuanta++;
                }
            } else {
                break;
            }
        }
        return processResult;
    }
}
