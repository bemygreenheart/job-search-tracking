package uz.jaxathon.jobsearchtracking.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobOpeningTest {
    private JobOpening jobOpening;
    private final int ANNUAL_WORKING_HOURS = 2080;

    @BeforeEach
    void setUp() {
        jobOpening = new JobOpening();
    }

    @Test
    void getHourlySalaryTest() {
        final double SALARY = 120000;
        jobOpening.setSalary(SALARY);
        assertEquals(SALARY/ANNUAL_WORKING_HOURS, jobOpening.getHourlySalary());
    }

    @Test
    void setSalaryWithPerHourRateTest() {
        final double HOURLY_RATE = 60;
        jobOpening.setSalaryWithPerHourRate(HOURLY_RATE);
        assertEquals(ANNUAL_WORKING_HOURS * HOURLY_RATE, jobOpening.getSalary());
    }
}
