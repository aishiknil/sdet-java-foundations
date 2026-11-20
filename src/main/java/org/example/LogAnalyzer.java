package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogAnalyzer {

    public Map<String, Integer> countStatusCodes(List<String> statusCodes) {
        Map<String, Integer> counts = new HashMap<>();

        if (statusCodes == null) {
            return counts;
        }

        for (String code : statusCodes) {
            if (code != null) {
                counts.put(code, counts.getOrDefault(code, 0) + 1);
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        LogAnalyzer analyzer = new LogAnalyzer();
        List<String> sampleLogs = List.of("200", "404", "200", "500", "200", "404");

        Map<String, Integer> result = analyzer.countStatusCodes(sampleLogs);
        System.out.println("Status code counts: " + result);
    }
}