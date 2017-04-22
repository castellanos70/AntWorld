package antworld.common;

import java.io.Serializable;

/**
 * The Class FoodData.
 *
 * FoodData contains all data about a food pile that the
 * server tells the client.
 * 
 */
public class FoodData extends GameObject
{
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = Constants.VERSION;


  /**
   * quantity is the number of units of this food item in the pixel.
   * The quantity can be any positive integer.
   */
  public int quantity;
  
  /**
   * Instantiates a new FoodData given values.
   *
   * @param foodType the food type
   * @param x the x
   * @param y the y
   * @param quantity the quantity
   */
  public FoodData(GameObjectType foodType, int x, int y, int quantity)
  {
    this.type = foodType;
    this.gridX = x;
    this.gridY = y;
    this.quantity = quantity;
  }



  /**
   * Instantiates a new FoodData from existing FoodData.
   *
   * @param source
   */
  public FoodData(FoodData source)
  {
    this.type =  source.type;
    this.gridX =  source.gridX;
    this.gridY =  source.gridY;
    this.quantity =  source.quantity;
  }


  public String toString()
  {
    return type + ":"+quantity;
  }
}
