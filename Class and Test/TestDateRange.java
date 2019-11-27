package uk.ac.ed.bikerental;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDateRange {
    private DateRange dateRange1, dateRange2, dateRange3;

    @BeforeEach
    void setUp() throws Exception {
        // Setup resources before each test
        this.dateRange1 = new DateRange(LocalDate.of(2019, 1, 7),
                                        LocalDate.of(2019, 1, 10));

        this.dateRange2 = new DateRange(LocalDate.of(2019, 1, 5),
                                        LocalDate.of(2019, 1, 23));

        this.dateRange3 = new DateRange(LocalDate.of(2015, 1, 7),
                                        LocalDate.of(2018, 1, 10));
    }

    // Sample JUnit tests checking toYears works
    @Test
    void testToYears1() {
        assertEquals(0, this.dateRange1.toYears());
    }

    @Test
    void testToYears3() {
        assertEquals(3, this.dateRange3.toYears());
    }

    @Test
    void testOverlapsTrue() {
        assert(dateRange1.overlaps(dateRange2) == true);
    }

    @Test
    void testOverlapsFalse() {
        assert(dateRange1.overlaps(dateRange3) == false);
    }

    @Test
    void testOverlapsInside() {
        DateRange dateRange4 = new DateRange(LocalDate.of(2019, 1, 8),
                                             LocalDate.of(2019, 1, 9));
        assert(dateRange1.overlaps(dateRange4) == true);
    }

    @Test
    void testPrint() {
        //System.out.println(dateRange1.toString());
        assert(dateRange1.toString().equals("2019-01-07 - 2019-01-10"));
    }
}
