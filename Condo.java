public class Condo extends Property {

    private double hoaFee;

    // default constructor
    public Condo() {
        super();
        this.hoaFee = 175.00;
    }

    // non-default constructor
    public Condo(String address, double offeredPrice,
                 int yearBuilt, double hoaFee) {
        super(address, offeredPrice, yearBuilt);
        this.hoaFee = hoaFee;
    }

    // accessor
    public double getHoaFee() {
        return hoaFee;
    }

    // mutator
    public void setHoaFee(double hoaFee) {
        this.hoaFee = hoaFee;
    }

    // constructs a String by invoking the super class method and adding hoaFee
    @Override
    public String toString() {
        return String.format("%s%s%-10.2f", super.toString(), "HOA fee: $", hoaFee);
    }

    // returns true if super class' equals() returns true and same hoaFee,
    // else returns false
    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() && super.equals(o) &&
                this.hoaFee == ((Condo)o).hoaFee;
    }
}
