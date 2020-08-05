// @version1.0 07-28-2020
// @author Maya Itty
//  File name: TransactionAnalyzer.java
//  Program purpose: GUI application: simplified version of MLS (Listings of properties on sales).
//  Displays condos or single family homes based on what the user selects.
//  Revision history:
//   Date                  Programmer          Change ID      Description
//   07/28/2020            Maya Itty           0000           Initial implementation

import java.awt.*;

public class MLSListingsApp {
    public static void main(String[] args) {
        PropertyList propertyList = new PropertyList();
        propertyList.initialize();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MLSListingsView mlsView = new MLSListingsView();
                mlsView.setProperties(propertyList);
                mlsView.setVisible(true);
            }
        });
    }
}
