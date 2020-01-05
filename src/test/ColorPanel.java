package test;

import java.awt.*;

public class ColorPanel extends Panel {
    private Button blackBtn;
    private Button blueBtn;
    private Button redBtn;
    private Button yellowBtn;

    public ColorPanel() {
        setLayout(new GridLayout(2,2));
        setBackground(Color.GRAY);

        blackBtn = new Button();
        blackBtn.setBackground(Color.BLACK);
        blackBtn.addActionListener(DrawCanvas::setColor);

        blueBtn = new Button();
        blueBtn.setBackground(Color.BLUE);
        blueBtn.addActionListener(DrawCanvas::setColor);

        redBtn = new Button();
        redBtn.setBackground(Color.RED);
        redBtn.addActionListener(DrawCanvas::setColor);

        yellowBtn = new Button();
        yellowBtn.setBackground(Color.YELLOW);
        yellowBtn.addActionListener(DrawCanvas::setColor);

        add(blackBtn);
        add(blueBtn);
        add(redBtn);
        add(yellowBtn);
    }

    public Button getBlackBtn() { return blackBtn; }
    public Button getBlueBtn() { return blueBtn; }
    public Button getRedBtn() { return redBtn; }
    public Button getYellowBtn() { return yellowBtn; }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }
}
