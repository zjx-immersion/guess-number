package com.hw.domain;

public class Record {

    private final Integer[] record;

    public Record() {
        record = new Integer[]{0, 0};
    }

    public void increateCorrectCount() {
        this.record[0]++;
    }

    public void increateIncludeOnlyCount() {
        this.record[1]++;
    }

    public String getValue() {
        return String.format("%1$sA%2$sB", record[0], record[1]);
    }
}
