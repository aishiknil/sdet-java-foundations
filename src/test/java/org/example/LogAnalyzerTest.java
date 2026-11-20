package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {

    private LogAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new LogAnalyzer();
    }

    @Test
    void countStatusCodes_validLogs_returnsAccurateCounts() {
        List<String> logs = List.of("200", "404", "200", "500", "200", "404");

        Map<String, Integer> result = analyzer.countStatusCodes(logs);

        assertEquals(3, result.size());
        assertEquals(3, result.get("200"));
        assertEquals(2, result.get("404"));
        assertEquals(1, result.get("500"));
    }

    @Test
    void countStatusCodes_nullOrEmptyList_returnsEmptyMap() {
        assertTrue(analyzer.countStatusCodes(null).isEmpty());
        assertTrue(analyzer.countStatusCodes(Collections.emptyList()).isEmpty());
    }

    @Test
    void countStatusCodes_listWithNullElements_ignoresNulls() {
        List<String> logs = Arrays.asList("200", null, "404", null, "200");

        Map<String, Integer> result = analyzer.countStatusCodes(logs);

        assertEquals(2, result.size());
        assertEquals(2, result.get("200"));
        assertEquals(1, result.get("404"));
    }

    @Test
    void getMostFrequentStatus_validLogs_returnsHighestFrequencyCode() {
        List<String> logs = List.of("200", "404", "200", "500", "200", "404");

        assertEquals("200", analyzer.getMostFrequentStatus(logs));
    }

    @Test
    void getMostFrequentStatus_nullOrEmptyList_returnsNull() {
        assertNull(analyzer.getMostFrequentStatus(null));
        assertNull(analyzer.getMostFrequentStatus(Collections.emptyList()));
    }
}