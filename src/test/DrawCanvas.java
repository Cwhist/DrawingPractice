package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

public class DrawCanvas extends Canvas implements MouseListener, MouseMotionListener {
    private int curX, curY;
    private int oldX, oldY;
    private boolean isDrawing;
    private BufferStrategy bufferCanvas;
    private static Color color;

    DrawCanvas() {
        isDrawing = false;
        addMouseMotionListener(this);
        addMouseListener(this);
        color = new Color(Color.RED.getRGB());
    }

    public void mouseDragged(MouseEvent e) {
        if(isDrawing) {
            oldX = curX;
            oldY = curY;
            curX = e.getX();
            curY = e.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        curX = e.getX();
        curY = e.getY();
        oldX = curX;
        oldY = curY;
        isDrawing = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDrawing = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    public void render() {
        bufferCanvas = getBufferStrategy();

        if(bufferCanvas == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bufferCanvas.getDrawGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,0));
        g.drawLine(curX, curY, oldX, oldY);

        g.dispose();
        bufferCanvas.show();
    }

    public boolean getIsDrawing() { return isDrawing; }

    public static void setColor(ActionEvent e) {
        System.out.println(e.getSource());
        color = new Color(Color.BLACK.getRGB());
    }
}
