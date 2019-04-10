/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antonacube;

import java.util.concurrent.Semaphore;

/**
 *
 * @author siddh
 */
public class AntOnACube {

    public static Semaphore threadTracker = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DisplayWindow d = new DisplayWindow();
        d.setVisible(true);
    }

    public static InfoTracker runSimulations(int numberOfThreads, int numberOfSimulations) {
        InfoTracker t = new InfoTracker();
        threadTracker = new Semaphore(numberOfThreads);
        try {
            for (int i = 0; i < numberOfSimulations; i++) {
                threadTracker.acquire();//this is released at the end of thread execution in Simulation.run()
                new Simulation(t).start();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            return null;
        }
        return t;
    }

}
