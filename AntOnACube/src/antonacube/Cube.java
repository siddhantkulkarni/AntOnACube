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
public class Cube{
    public static CubeEdge[] getAdjacentEdges(CubeEdge e){
        switch(e){
            case One:
                return new CubeEdge[]{CubeEdge.Two,CubeEdge.Three,CubeEdge.Five};
            case Two:
                return new CubeEdge[]{CubeEdge.One,CubeEdge.Four,CubeEdge.Six};
            case Three:
                return new CubeEdge[]{CubeEdge.One,CubeEdge.Four,CubeEdge.Seven};
            case Four:
                return new CubeEdge[]{CubeEdge.Two,CubeEdge.Three,CubeEdge.Eight};
            case Five:
                return new CubeEdge[]{CubeEdge.One,CubeEdge.Six,CubeEdge.Seven};
            case Six:
                return new CubeEdge[]{CubeEdge.Two,CubeEdge.Five,CubeEdge.Eight};
            case Seven:
                return new CubeEdge[]{CubeEdge.Three,CubeEdge.Five,CubeEdge.Eight};
            case Eight:
                return new CubeEdge[]{CubeEdge.Four,CubeEdge.Six,CubeEdge.Seven};     
            default:
                return null;
        }
    }
    
    public static CubeEdge getOppositeEdge(CubeEdge e){
        switch(e){
             case One:
                return CubeEdge.Eight;
            case Two:
                return CubeEdge.Seven;
            case Three:
                return CubeEdge.Six;
            case Four:
                return CubeEdge.Five;
            case Five:
                return CubeEdge.Four;
            case Six:
                return CubeEdge.Three;
            case Seven:
                return CubeEdge.Two;
            case Eight:
                return CubeEdge.One;
            default:
                return null;
        }
    }
     
    public static CubeEdge getRandomStartingEdge(){
        CubeEdge[] all= new CubeEdge[]{CubeEdge.One,CubeEdge.Two,CubeEdge.Three,CubeEdge.Four,CubeEdge.Five,CubeEdge.Six,CubeEdge.Seven,CubeEdge.Eight};
        return all[ThreadLocalRandom.current().nextInt(0,8)];
    }
    
}
