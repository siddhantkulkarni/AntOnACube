/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antonacube;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author siddh
 */
public class Ant {

    CubeEdge startingEdge, endingEdge;
    int timeSpentTraveling;

    public Ant() {     
        this.startingEdge = Cube.getRandomStartingEdge();
        this.endingEdge = Cube.getOppositeEdge(startingEdge);
        this.timeSpentTraveling = 0;
    }

    public void startTravel() {
        //System.out.println("Starting from= " + this.startingEdge);
        travel(this.startingEdge);
    }

    private void travel(CubeEdge currentEdge) {
        if (currentEdge == this.endingEdge) //Stop travelling if you have reached the opposite edge
        {
            //System.out.println("Reached edge "+this.endingEdge);
            return;
        }
        this.timeSpentTraveling++;
        CubeEdge[] adjacent = Cube.getAdjacentEdges(currentEdge);
        int nextEdgeToTravelTo = ThreadLocalRandom.current().nextInt(0, 3);
       // System.out.println("Time spent travelling so far=" + this.timeSpentTraveling + " Next edge=" + adjacent[nextEdgeToTravelTo]);
        travel(adjacent[nextEdgeToTravelTo]);
    }
}
