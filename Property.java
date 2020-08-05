
public class Property {

    // private instance fields
    private String address;
    private double offeredPrice;
    private int yearBuilt;
    private Property next;

    // default constructor
    public Property() {
        this.address = "";
        this.offeredPrice = 0;
        this.yearBuilt = 0;
        this.next = null;
    }

    // non-default constructor
    public Property(String address, double offeredPrice, int yearBuilt) {
        this.address = address;
        this.offeredPrice = offeredPrice;
        this.yearBuilt = yearBuilt;
        this.next = null;
    }

    // accessor methods
    public String getAddress() {
        return address;
    }

    public double getOfferedPrice() {
        return offeredPrice;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public Property getNext() {
        return next;
    }

    // mutator methods
    public void setAddress(String address) {
        this.address = address;
    }

    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void setNext(Property next) {
        this.next = next;
    }

    // constructs a String to show address, price, and year built
    @Override
    public String toString() {
        return String.format("%-50s%s%-15.2f%-10d",
                this.address, "$", this.offeredPrice, this.yearBuilt);
    }

    // returns true if same year built and address, else returns false
    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() &&
                ((Property)o).yearBuilt == this.yearBuilt &&
                ((Property) o).address.equals(this.address);
    }
}
