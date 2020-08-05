public class SingleFamilyHouse extends Property {
    private int backyardArea;

    // default constructor
    public SingleFamilyHouse() {
        super();
        this.backyardArea = 0;
    }

    // non-default constructor
    public SingleFamilyHouse(String address, double offeredPrice,
                             int yearBuilt, int backyardArea) {
        super(address, offeredPrice, yearBuilt);
        this.backyardArea = backyardArea;
    }

    // accessor
    public int getBackyardArea() {
        return backyardArea;
    }

    // mutator
    public void setBackyardArea(int backyardArea) {
        this.backyardArea = backyardArea;
    }

    // constructs a String by invoking the super class method and adding backyardArea
    @Override
    public String toString() {
        return String.format("%s%d%s", super.toString(), backyardArea, " (sqft)");
    }

    // returns true if super class' equals() returns true and same backyard area,
    // else returns false
    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() && super.equals(o) &&
                this.backyardArea == ((SingleFamilyHouse)o).backyardArea;
    }
}
