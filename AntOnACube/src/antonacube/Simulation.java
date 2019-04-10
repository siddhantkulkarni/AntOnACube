/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antonacube;

/**
 *
 * @author siddh
 */
public class Simulation extends Thread{
    InfoTracker t;
    public Simulation(InfoTracker t){
        this.t=t;
    }
    public void run(){
        try{
            Ant a=new Ant();
            a.startTravel();
            t.updateEndOfSimulation(a.timeSpentTraveling);
            AntOnACube.threadTracker.release(); //this is acquired before starting thread execution in AntOnACube.runSimulations()
        }catch(Exception e){
            System.out.println("Exception!");
            e.printStackTrace();
        }
    }
}
