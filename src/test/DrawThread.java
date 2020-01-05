package test;

import java.awt.*;

public class DrawThread extends Thread {
    private boolean isRunning;
    private DrawCanvas dc;

    public DrawThread(DrawCanvas dc) {
        isRunning = true;
        this.dc = dc;
    }

    @Override
    public void run() {
        while(isRunning) {
            if(dc.getIsDrawing())
                dc.render();
            try {
                Thread.sleep(0,0);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        isRunning = false;
    }
}
