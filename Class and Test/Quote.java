package uk.ac.ed.bikerental;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Quote {
    private Bike bike;
    private BigDecimal deposit;

    public Quote(Bike bike) {
        this.setBike(bike);
        setDeposit("");
    }

    public Quote(Bike bike, String n) {
        this.setBike(bike);
        setDeposit(n);
    }

    private void setDeposit(String n) {
        switch (n) {
            case "LinearDepreciation":
                this.deposit = new LinearDepreciation().calculateValue(this.bike, LocalDate.now());
                break;
            case "DoubleDecliningBalanceDepreciation":
                this.deposit = new DoubleDecliningBalanceDepreciation().calculateValue(this.bike, LocalDate.now());
                break;
            default:
                this.deposit = bike.getProvider().getRate().multiply(bike.getType().getReplacementValue());
        }
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposite) {
        this.deposit = deposite;
    }
    @Override
    public int hashCode() {
        return bike.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

}
