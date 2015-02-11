import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by romanwendelboe on 9/21/14.
 */
public class Pizza extends JFrame implements ItemListener, ActionListener {
    private final int WIDTH = 600, LENGTH = 500;

    private JCheckBox cheese, olives, mushrooms, tomatoes, pepperoni, sausage, onions;
    private JRadioButton small, medium, large, original, withCheese, withGarlic;
    private ButtonGroup sizeGroup, breadstickGroup;
    private JButton calcButton;
    private JButton resetButton;
    private JTextArea textArea;
    private JLabel pizzaSize, toppings, breadstick;
    private double total = 0;
    private String pSize = "";
    private String yourBreadstick = "";
    private String yourPrice = "Your Total: $";
    private String toppingsPamf = "Your Toppings: ";

    public Pizza() {
        this.setLayout(null);

        pizzaSize = new JLabel("Size");
        toppings = new JLabel("Toppings");
        breadstick = new JLabel("Bread Stick");

        cheese = new JCheckBox("Cheese: $.50");
        olives = new JCheckBox("Olives: $.50");
        mushrooms = new JCheckBox("Mushrooms: $.50");
        tomatoes = new JCheckBox("Tomatoes: $.50");
        onions = new JCheckBox("Onions: $.50");
        pepperoni = new JCheckBox("Pepperoni: $.50");
        sausage = new JCheckBox("Sausage: $.50");

        small = new JRadioButton("Small: $5.00");
        small.addItemListener(this);
        small.setSelected(false);
        medium = new JRadioButton("Medium: $7.00");
        medium.addItemListener(this);
        large = new JRadioButton("Large: $10.00");
        large.addItemListener(this);

        original = new JRadioButton("Original: $2.00");
        original.addItemListener(this);
        original.setSelected(false);
        withCheese = new JRadioButton("With Cheese: $3.00");
        withCheese.addItemListener(this);
        withGarlic = new JRadioButton("With Garlic: $3.00");
        withGarlic.addItemListener(this);

        calcButton = new JButton("Calculate Order");
        calcButton.addActionListener(this);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                sizeGroup.clearSelection();
                breadstickGroup.clearSelection();
                olives.setSelected(false);
                tomatoes.setSelected(false);
                pepperoni.setSelected(false);
                onions.setSelected(false);
                sausage.setSelected(false);
                mushrooms.setSelected(false);
                cheese.setSelected(false);
            }
        });

        sizeGroup = new ButtonGroup();
        breadstickGroup = new ButtonGroup();
        textArea = new JTextArea();
        textArea.setForeground(Color.blue);
        textArea.setEditable(false);

        cheese.setSize(120, 50);
        cheese.setLocation(40, 60);

        olives.setSize(120, 50);
        olives.setLocation(40, 90);

        onions.setSize(120, 50);
        onions.setLocation(40, 120);

        mushrooms.setSize(150, 50);
        mushrooms.setLocation(40, 150);

        tomatoes.setSize(130, 50);
        tomatoes.setLocation(40, 180);

        pepperoni.setSize(130, 50);
        pepperoni.setLocation(40, 210);

        sausage.setSize(120, 50);
        sausage.setLocation(40, 240);

        small.setSize(110, 50);
        small.setLocation(250, 60);

        medium.setSize(130, 50);
        medium.setLocation(250, 90);

        large.setSize(150, 50);
        large.setLocation(250, 120);

        original.setSize(140, 50);
        original.setLocation(390, 60);

        withCheese.setSize(170, 50);
        withCheese.setLocation(390, 90);

        withGarlic.setSize(150, 50);
        withGarlic.setLocation(390, 120);

        pizzaSize.setSize(100, 100);
        pizzaSize.setLocation(260, 0);

        breadstick.setSize(100, 100);
        breadstick.setLocation(400, 0);

        toppings.setSize(100, 100);
        toppings.setLocation(50, 0);

        calcButton.setSize(180, 70);
        calcButton.setLocation(250, 200);

        resetButton.setSize(100, 70);
        resetButton.setLocation(460, 200);

        textArea.setSize(510, 150);
        textArea.setLocation(45, 300);

        Container pane = getContentPane();
        pane.setBackground(Color.orange);
        pane.add(calcButton);
        pane.add(resetButton);
        pane.add(cheese);
        pane.add(olives);
        pane.add(small);
        pane.add(medium);
        pane.add(large);
        pane.add(original);
        pane.add(withCheese);
        pane.add(withGarlic);
        pane.add(textArea);
        pane.add(pizzaSize);
        pane.add(toppings);
        pane.add(breadstick);
        pane.add(onions);
        pane.add(tomatoes);
        pane.add(pepperoni);
        pane.add(sausage);
        pane.add(mushrooms);

        sizeGroup.add(small);
        sizeGroup.add(medium);
        sizeGroup.add(large);
        breadstickGroup.add(original);
        breadstickGroup.add(withCheese);
        breadstickGroup.add(withGarlic);

        setTitle("Romano's Pizza");
        setVisible(true);
        setSize(WIDTH, LENGTH);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getItem().equals(small)) {
            if (small.isSelected()) {
                System.out.println("You selected small size");
            } else {

                System.out.println("You selected small size");
            }
        } else if (e.getItem().equals(medium)) {
            if (medium.isSelected()) {

                System.out.println("You selected medium size!");
            } else {

                System.out.println("You deselected medium size!");
            }

        } else if (e.getItem().equals(large)) {
            if (large.isSelected()) {

                System.out.println("You selected large size!");
            } else {

                System.out.println("You deselected large size!");
            }
        } else if (e.getItem().equals(original)) {
            if (original.isSelected()) {
                System.out.println("You selected original breadstick!");
            } else {
                System.out.println("You deselected original breadstick!");
            }
        } else if (e.getItem().equals(withCheese)) {
            if (withCheese.isSelected()) {
                System.out.println("You selected breadstick with cheese!");
            } else {
                System.out.println("You deselected breadstick with cheese!");
            }
        } else if (e.getItem().equals(withGarlic)) {
            if (withGarlic.isSelected()) {
                System.out.println("You selected breadstick with garlic!");
            } else {
                System.out.println("You deselected breadstick with garlic!");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(large.isSelected()){
            total = total + 10.00;
            pSize = "Your Size: Large";
        } else {
           total = total;
        }
        if(medium.isSelected()){
            total = total + 7.00;
            pSize = "Your Size: Medium";
        } else {
            total = total;
        }
        if(small.isSelected()){
            total = total + 5.00;
            pSize = "Your Size: Small";
        } else {
            total = total;
        }
        if(onions.isSelected()){
            total = total + .50;
            toppingsPamf += "Onions,";
        } else {
            total = total;
        }
        if(olives.isSelected()){
            total = total + .50;
            toppingsPamf += "Olives,";
        } else {
            total = total;
        }
        if(tomatoes.isSelected()){
            total = total + .50;
            toppingsPamf += "Tomatoes,";
        } else {
            total = total;
        }
        if(cheese.isSelected()){
            total = total + .50;
            toppingsPamf += "Cheese,";
        } else {
            total = total;
        }
        if(sausage.isSelected()){
            total = total + .50;
            toppingsPamf += "Sausage,";
        } else {
            total = total;
        }

        if(mushrooms.isSelected()){
            total = total + .50;
            toppingsPamf += "Mushrooms,";
        } else {
           total = total;
        }
        if(pepperoni.isSelected()){
            total = total + .50;
            toppingsPamf += "Pepperoni,";
        } else {
           total = total;
        }
        if(original.isSelected()){
            total = total + 3.00;
            yourBreadstick = "Your Breadstick: Original";
        } else {
            total = total;
        }
        if(withCheese.isSelected()){
            total = total + 3.00;
            yourBreadstick = "Your Breadstick: With Cheese";
        } else {
           total = total;
        }
        if(withGarlic.isSelected()){
            total = total + 3.00;
            yourBreadstick = "Your Breadstick: With Garlic";
        } else {
            total = total;
        }
        textArea.append(pSize + "\n" + toppingsPamf + "\n" + yourBreadstick + "\n" + yourPrice + total + "\n" + "Thank you! Come Again!!!");
    }
}


