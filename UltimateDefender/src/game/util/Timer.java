/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.util;

/**
 *
 * @author Lucas
 */
public class Timer extends Thread {

    private boolean run = true;
    private long time;
    private TimerListener listener;

    public Timer(TimerListener listener, long time) {
        this.listener = listener;
        this.time = time;
    }

    @Override
    public void run() {
        while (run) {
            try {
                Thread.sleep(time);
                listener.update(this);
            } catch (InterruptedException ex) {
            }
        }
    }
}
