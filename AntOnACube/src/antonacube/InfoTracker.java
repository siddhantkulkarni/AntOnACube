/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antonacube;

import java.util.HashMap;

/**
 *
 * @author siddh
 */
public class InfoTracker {

    private int mintime = Integer.MAX_VALUE, maxtime = Integer.MIN_VALUE;
    private double totalTimeSpent = 0, numberOfSimulationsCompleted = 0;
    //This was only used to come up with analysis of ants and steps -> private StringBuilder trackSteps=new StringBuilder();
    public synchronized void updateEndOfSimulation(int timeSpent) {
        this.totalTimeSpent += timeSpent;
        this.numberOfSimulationsCompleted++;
        //This was only used to come up with analysis of ants and steps -> this.trackSteps.append("\r\n"+timeSpent);
        if (this.mintime > timeSpent) {
            this.mintime = timeSpent;
        }
        if (this.maxtime < timeSpent) {
            this.maxtime = timeSpent;
        }
    }

    public synchronized double getNumberOfCompletedSimulations() {
        return this.numberOfSimulationsCompleted;
    }

    public String getEndResult() {
        return "\r\nNumber of simulations executed=" + this.numberOfSimulationsCompleted
                + "\r\nTotal time spent by ants=" + this.totalTimeSpent
                + "\r\nAverage time spent by ants travelling to opposite edge of the cube=" + (this.totalTimeSpent / this.numberOfSimulationsCompleted)
                + "\r\nMaximum amount of time spent by an ant=" + this.maxtime
                + "\r\nMinimum amount of time spent by an ant=" + this.mintime;
               //This was only used to come up with analysis of ants and steps-> //+this.trackSteps;

    }

}
