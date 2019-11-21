//package uk.ac.ed.bikerental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.function.BooleanSupplier;

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
        // one range is in other range
        else if (this.start.compareTo(other.getStart())>0
                    && this.end.compareTo(other.getEnd())<0) {
            return true;
        }
        else if (other.getStart().compareTo(other.getStart())>0
                    && other.getEnd().compareTo(this.end)<0) {
            return true;
        }
        // part of them is overlap
        else if (other.getStart().compareTo(this.end)<0 
                    && other.getStart().compareTo(this.start)>0) {
            return true;
        }
        else if (this.start.compareTo(other.getEnd())<0
                    && this.start.compareTo(other.getStart())>0) {
            return true;
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
        return this.start.toString() + " ~ " + this.end.toString();
    }
}
