package antworld.client;

import antworld.common.LandType;
import antworld.server.Cell;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Reads a map and creates an array of Cells to represent the world
 * The server creates a Cell array, this will create a copy for the client
 * Used for terrain/elevation checking when path finding.
 * Created by John on 11/23/2016.
 */
public class MapReader
{

  private String imagePath = null;  //"resources/AntTestWorld4.png"
  private BufferedImage map = null;
  private Cell[][] world;
  private int mapWidth;
  private int mapHeight;

  public MapReader(String mapPath)
  {
    this.imagePath = mapPath;
    map = loadMap(imagePath);
    world = readMap(map);
  }

  private BufferedImage loadMap(String imagePath)
  {
    BufferedImage map = null;

    try
    {
      URL fileURL = new URL("file:" + imagePath);
      map = ImageIO.read(fileURL);
    }
    catch (IOException e)
    {
      System.out.println("Cannot Open image: " + imagePath);
      e.printStackTrace();
      System.exit(0);
    }

    return map;
  }

  private Cell[][] readMap(BufferedImage map)
  {
    mapWidth = map.getWidth();
    mapHeight = map.getHeight();
    Cell[][] world = new Cell[mapWidth][mapHeight];
    for (int x = 0; x < mapWidth; x++)
    {
      for (int y = 0; y < mapHeight; y++)
      {
        int rgb = (map.getRGB(x, y) & 0x00FFFFFF);
        LandType landType = LandType.GRASS;
        int height = 0;
        if (rgb == 0x0)
        {
          landType = LandType.NEST;
        }
        if (rgb == 0xF0E68C)
        {
          landType = LandType.NEST;
        }
        else if (rgb == 0x1E90FF)
        {
          landType = LandType.WATER;
        }
        else
        {
          int g = (rgb & 0x0000FF00) >> 8;

          height = g - 55;
        }
        // System.out.println("("+x+","+y+") rgb="+rgb +
        // ", landType="+landType
        // +" height="+height);
        world[x][y] = new Cell(landType, height, x, y);
      }
    }
    return world;
  }

  public Cell[][] getWorld()
  {
    return world;
  }

  public int getMapWidth()
  {
    return mapWidth;
  }

  public int getMapHeight()
  {
    return mapHeight;
  }
}
