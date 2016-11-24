package antworld.client;

import antworld.common.*;

/**
 * Created by mauricio on 11/23/16.
 */
public abstract class Ant
{
  static int antsUnderground;
  Direction lastDirection;
  AntAction nextAction;

  protected boolean pickupWater(AntData ant)
  {
    if(LandType.WATER)
    {
      nextAction.type = AntAction.AntActionType.PICKUP;
      nextAction.direction = direction;
    }
    return false;
  }

  protected boolean pickupFood(AntData ant, Direction direction)
  {
    if()
  }


}
