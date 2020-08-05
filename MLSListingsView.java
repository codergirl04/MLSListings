import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MLSListingsView extends JFrame {

    private static final int viewWidth = 720;
    private static final int viewHeight = 450;
    private static final int listingsRows = 20;
    private static final int listingsColumns = 60;
    private PropertyList propertyList;
    private String priceRange = "Under 400K";

    // UI Components
    private JTextArea listings;
    private JButton showAll;
    private JButton showSFH;
    private JButton showCondos;
    private JButton clear;

    public MLSListingsView() {
        // frame setup
        setTitle("MLSListings");
        setSize(MLSListingsView.viewWidth, MLSListingsView.viewHeight);
        setLocationRelativeTo(null);

        // 1. Create panels
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // (must be adding components left justified)
        JPanel displayPanel = new JPanel();
        JPanel actionPanel = new JPanel();

        // 2. Create individual UI components for the panels and add them to the panels

        // 2a. searchPanel
        String[] options = {"Under 400K", "400K - <600K", "600K - <800K",
                "800K - <1M", "1M or more"};
        JLabel label = new JLabel ("Search Properties: ");
        JComboBox<String> comboBox = new JComboBox<String> (options);
        JButton go = new JButton("Go");
        searchPanel.add(label);
        searchPanel.add(comboBox);
        searchPanel.add(go);

        // 2b. displayPanel - only contains the textArea
        listings = new JTextArea(MLSListingsView.listingsRows, MLSListingsView.listingsColumns);
        listings.setFont(new Font("monospaced", Font.PLAIN, 12));
        listings.setBorder(BorderFactory.createEtchedBorder());
        displayPanel.add(listings);

        // 2c. actionPanel
        showAll = new JButton("Show All");
        showSFH = new JButton(("Show SFH"));
        showCondos = new JButton("Show Condos");
        clear = new JButton(("Clear"));
        actionPanel.add(showAll);
        actionPanel.add(showSFH);
        actionPanel.add(showCondos);
        actionPanel.add(clear);

        // 3. Add panels to the frame
        add(searchPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        // 4. Provide event handlers for UI components (buttons in the GUI)
        showAll.addActionListener(e ->
                listings.setText(propertyList.getAllProperties()));

        showSFH.addActionListener(e ->
                listings.setText(propertyList.getSingleFamilyHouse()));

        showCondos.addActionListener(e ->
                listings.setText(propertyList.getCondo()));

        comboBox.addActionListener (e ->
                priceRange = (String) ((JComboBox<String>) e.getSource ()).getSelectedItem ());

        go.addActionListener(e -> {
            switch (priceRange) {
                case "Under 400K" -> listings.setText(propertyList.searchByPriceRange(0, 400000));
                case "400K - <600K" -> listings.setText(propertyList.searchByPriceRange(400000, 600000));
                case "600K - <800K" -> listings.setText(propertyList.searchByPriceRange(600000, 800000));
                case "800K - <1M" -> listings.setText(propertyList.searchByPriceRange(800000, 1000000));
                case "1M or more" -> listings.setText(propertyList.searchByPriceRange(1000000, 0));
            }
        });

        clear.addActionListener (e -> listings.setText(""));

        // 5. System.exit when users close the frame
        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void setProperties(PropertyList propertyList) {
        this.propertyList = propertyList;
    }
}
