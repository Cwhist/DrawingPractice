package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CanvasFrame extends Frame {
    Panel leftPanel, rightPanel;

    public CanvasFrame() {
        leftPanel = new Panel(new BorderLayout());
        leftPanel.setBackground(Color.lightGray);
        add(leftPanel, "West");
        leftPanel.add(new ColorPanel(), "North");

        rightPanel = new Panel() {
            @Override
            public Insets getInsets() {
                return new Insets(70,20,20,20);
            }
        };
        rightPanel.setBackground(Color.GRAY);
        add(rightPanel, "Center");
        DrawCanvas drawCanvas = new DrawCanvas();
        drawCanvas.setSize(600,400);
        drawCanvas.setBackground(Color.white);
        rightPanel.add(drawCanvas, "Center");

        DrawThread drawThread = new DrawThread(drawCanvas);
        drawThread.start();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                drawThread.shutdown();
                System.exit(0);
            }
        });
    };

}

