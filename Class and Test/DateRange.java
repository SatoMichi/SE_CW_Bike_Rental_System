//package uk.ac.ed.bikerental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * This class is used to represent DateRange.
 * It includes method to check whether two DateRange is overlapped or not.
 * 
 * @param start starting of date range
 * @param end of starting of date range
 *
 */
public class DateRange {
    private LocalDate start, end;
    
    public DateRange(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }
    
    public LocalDate getStart() {
        return this.start;
    }
    
    public LocalDate getEnd() {
        return this.end;
    }

    public long toYears() {
        return ChronoUnit.YEARS.between(this.getStart(), this.getEnd());
    }

    public long toDays() {
        return ChronoUnit.DAYS.between(this.getStart(), this.getEnd());
    }

    /**
     * This method check whether this DateRange and other DateRange have overlaps.
     * @param other DateRage to compare with 
     * @return return true if there is overlap, else return false
     */
    public Boolean overlaps(DateRange other) {
        // two range are equal
        if (this.equals(other)) {
            return true;
        }
        else if (!other.getEnd().isAfter(this.end)) {
            return !this.start.isAfter(other.getEnd());
        }
        else if (!this.end.isAfter(other.getEnd())) {
            return !other.getStart().isAfter(this.end);
        }
        // else
        return false;
    }

    @Override
    public int hashCode() {
        // hashCode method allowing use in collections
        return Objects.hash(end, start);
    }

    @Override
    public boolean equals(Object obj) {
        // equals method for testing equality in tests
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DateRange other = (DateRange) obj;
        return Objects.equals(end, other.end) && Objects.equals(start, other.start);
    }
    
    public String toString() {
        return this.start.toString() + " - " + this.end.toString();
    }
}