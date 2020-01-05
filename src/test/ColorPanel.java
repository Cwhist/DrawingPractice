package test;

import java.awt.*;

public class ColorPanel extends Panel {
    private Button black;
    private Button blue;
    private Button red;
    private Button yellow;

    public ColorPanel() {
        setLayout(new GridLayout(2,2));
        setBackground(Color.GRAY);

        black = new Button();
        black.setBackground(Color.BLACK);

        blue = new Button();
        blue.setBackground(Color.BLUE);

        red = new Button();
        red.setBackground(Color.RED);

        yellow = new Button();
        yellow.setBackground(Color.YELLOW);

        add(black);
        add(blue);
        add(red);
        add(yellow);
    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }
}
