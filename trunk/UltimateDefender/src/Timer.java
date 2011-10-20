/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ishibers
 */

/**
 *
 * @author paulovich
 */
public class Timer extends Thread {

    public Timer(TimerListener listener, long millis) {
        this.listener = listener;
        this.millis = millis;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(millis);
                listener.update();
            } catch (InterruptedException ex) {
            }
        }
    }

    private long millis;
    private TimerListener listener;
}


