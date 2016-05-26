
package com.mars.rovers;

/**
 * 
 * @author abhinaba
 *
 */

public class Plateau
{

    private Plateau(String coords)
    {
        populateInput(coords);
    }

    private void populateInput(String coords)
    {
        String upperArrayCoords[] = coords.split(" ");
        if(upperArrayCoords.length!=2){
            throw new RoversException("Invalid input, please provide input as \"x_axis y_axis\"");
        }
        upperRightX = Integer.valueOf(upperArrayCoords[0]).intValue();
        upperRightY = Integer.valueOf(upperArrayCoords[1]).intValue();
    }

    public static Plateau getInstance(String coords)
    {
        synchronized (Plateau.class) {
        	if(plateau == null)
                plateau = new Plateau(coords);
		}
        return plateau;
    }


    public int getUpperRightX()
    {
        return upperRightX;
    }

    public int getUpperRightY()
    {
        return upperRightY;
    }

    private static Plateau plateau = null;
    public static final int LOWER_LEFT_X = 0;
    public static final int LOWER_LEFT_Y = 0;
    private int upperRightX;
    private int upperRightY;

}