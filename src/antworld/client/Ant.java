package antworld.client;

import antworld.client.astar.PathFinder;
import antworld.common.*;
import antworld.server.Cell;

/**
 * Created by mauricio on 11/23/16.
 */
public abstract class Ant
{
  static PathFinder pathFinder;
  static int antsUnderground;
  Direction dir, lastDir;
  AntAction action;


  protected boolean pickupWater(AntData ant, Cell[][] world)
  {
    if (lastDir != null)
    {
      if (world[ant.gridX+lastDir.deltaX()][ant.gridY+lastDir.deltaY()].getLandType() == LandType.WATER)
      {
        action.type = AntAction.AntActionType.PICKUP;
        action.direction = lastDir;
        action.quantity = ant.antType.getCarryCapacity() - 1;
        return true;
      }
    }
    return false;
  }

  protected boolean pickupFood(AntData ant, Cell[][] world)
  {
    if (lastDir != null)
    {
      if (world[ant.gridX+lastDir.deltaX()][ant.gridY+lastDir.deltaY()].getFood() != null)
      {
        action.type = AntAction.AntActionType.PICKUP;
        action.direction = lastDir;
        action.quantity = ant.antType.getCarryCapacity() - 1;
        return true;
      }
    }
    return  false;
  }

  protected boolean goToNest(AntData ant, Cell[][] world)
  {
//    if (ant.carryUnits == ant.antType.getCarryCapacity())
//    {
//      pathFinder.findPath(centerX, centerY, ant.gridX, ant.gridY);
//    }
    return false;
  }


}
