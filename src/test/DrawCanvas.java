package test;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawCanvas extends Canvas implements MouseListener, MouseMotionListener {
    private int curX, curY;
    private int oldX, oldY;
    private boolean isDrawing;

    DrawCanvas() {
        isDrawing = false;
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public void mouseDragged(MouseEvent e) {
        if(isDrawing) {
            curX = e.getX();
            curY = e.getY();
            Graphics g = this.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,0));
            g2.drawLine(curX, curY, oldX, oldY);
            oldX = curX;
            oldY = curY;
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

    public void setColor() {

    }
}
