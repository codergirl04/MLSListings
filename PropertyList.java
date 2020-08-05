import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class PropertyList {

    private Property head;
    private static String textFileLocation = "src/DataFile.txt";

    // default constructor
    public PropertyList() {
        this.head = null;
    }

    // adds a Property object (Single Family House or Condo) to the front of the linked list
    private void insert(Property property) {
        property.setNext(this.head);
        this.head = property;
    }

    // reads each line of a data file
    public void initialize() {
        BufferedReader reader;
        String line;
        Path inputFilePath = Paths.get(textFileLocation);
        int index = 0;
        try {
            reader =  Files.newBufferedReader(inputFilePath, StandardCharsets.US_ASCII);
            while ((line = reader.readLine()) != null) {
                instantiateProperty(line, index++);
            }
            reader.close ();
        } catch (IOException e)  {
            e.printStackTrace ();
        }
    }

    // instantiates a SingleFamilyHouse or Condo object depending on the data read
    // from the data file
    public void instantiateProperty(String line, int index) {
        String property_type;
        String address;
        double offer_price;
        int year_built;

        String[] data = line.split(";");
        property_type = data[0].toLowerCase();
        address = data[1];
        offer_price = Double.parseDouble(data[2]);
        year_built = Integer.parseInt(data[3]);

        if (property_type.equals("sfh")) {
            int backyardArea = Integer.parseInt(data[4]);
            this.insert(new SingleFamilyHouse(address, offer_price,
                    year_built, backyardArea));
        }
        else if (property_type.equals("condo")) {
            double hoaFee = Double.parseDouble(data[4]);
            this.insert(new Condo(address, offer_price, year_built, hoaFee));
        }
    }

    // navigates through the entire linked list to combine all the nodes'
    // Strings into a single String and returns it
    public String getAllProperties() {
        Property property = this.head;
        StringBuilder propertiesString = new StringBuilder();
        propertiesString.append(String.format("%-50s%-15s%-10s%-10s", "Address",
                "Price", "Year", "Other info"));
        while (property.getNext() != null) {
            propertiesString.append("\n").append(property.toString());
            property = property.getNext();
        }
        return propertiesString.toString();
    }

    // navigates through the entire linked list to combine all the
    // SingleFamilyHouse objects' Strings into a single String and returns it
    public String getSingleFamilyHouse() {
        Property property = this.head;
        StringBuilder propertiesString = new StringBuilder();
        propertiesString.append(String.format("%-50s%-15s%-10s%-10s", "Address",
                "Price", "Year", "Other info"));
        while(property.getNext() != null) {
            if (property instanceof SingleFamilyHouse) {
                propertiesString.append("\n").append(property.toString());
            }
            property = property.getNext();
        }
        return propertiesString.toString();
    }

    // navigates through the entire linked list to combine all the
    // Condo objects' Strings into a single String and returns it
    public String getCondo() {
        Property property = this.head;
        StringBuilder propertiesString = new StringBuilder();
        propertiesString.append(String.format("%-50s%-15s%-10s%-10s", "Address",
                "Price", "Year", "Other info"));
        while(property.getNext() != null) {
            if (property instanceof Condo) {
                propertiesString.append("\n").append(property.toString());
            }
            property = property.getNext();
        }
        return propertiesString.toString();
    }

    // navigates through the entire linked list to combine all the nodes
    // with prices falling within the range min-max into a String
    public String searchByPriceRange(double min, double max) {
        // ** pass max as 0 to search for all properties whose price is greater
        // than the minimum value **
        Property property = this.head;
        StringBuilder propertiesString = new StringBuilder();
        propertiesString.append(String.format("%-50s%-15s%-10s%-10s", "Address",
                "Price", "Year", "Other info"));
        if (max == 0) {
            while(property.getNext() != null) {
                if (property.getOfferedPrice() >= min) {
                    propertiesString.append("\n").append(property.toString());
                }
                property = property.getNext();
            }
        }
        else {
            while (property.getNext() != null) {
                if (property.getOfferedPrice() >= min && property.getOfferedPrice() < max) {
                    propertiesString.append("\n").append(property.toString());
                }
                property = property.getNext();
            }
        }
        return propertiesString.toString();
    }
}
