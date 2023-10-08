package org.example.jsonParsing.testClasses;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Person {
    private LocalTime time;
    private BigDecimal age;
    private String name;
    private Duration durationTime;


    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Duration durationTime) {
        this.durationTime = durationTime;
    }
}
