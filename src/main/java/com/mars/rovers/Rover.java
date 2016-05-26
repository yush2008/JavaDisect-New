
package com.mars.rovers;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author abhinaba
 *
 */
public class Rover
{

    public Rover(String inputs)
    {
        extractInputs(inputs.toUpperCase());
    }

    private void extractInputs(String inputs)
    {
        String inputArray[] = inputs.split(" ");
        if(inputArray.length != 3)
            throw new RoversException("Invalid input, please provide input as \"x_axis y_axis face (N,S,E,W)\"");
        posX = Integer.valueOf(inputArray[0]).intValue();
        posY = Integer.valueOf(inputArray[1]).intValue();
        if(!DIRECTION_STRING_TO_INT.containsKey(inputArray[2].toUpperCase()))
        {
            throw new RoversException("Wrong direction (N,S,E,W)\"");
        } else
        {
            direction = ((Integer)DIRECTION_STRING_TO_INT.get(inputArray[2].toUpperCase())).intValue();
            return;
        }
    }

    public String move(String moversString)
    {
    	moversString = moversString.toUpperCase();
        for(int index = 0; index < moversString.length(); index++)
        {
            char c = moversString.charAt(index);
            move(c);
        }

        return (posX + " " + posY + " " + DIRECTION_INT_TO_STRING.get(Integer.valueOf(direction)));
    }

    private void move(char c)
    {
        switch(c)
        {
        case 'L':
        	changeDirection(c);
            break;
        case 'R':
            changeDirection(c);
            break;

        case 'M':
            move();
            break;
        }
    }

    private void move()
    {
        switch(direction)
        {
        default:
            break;

        case 1:
        	if(posY+1>Plateau.getInstance("").getUpperRightY()){
        		throw new RoversException("Out of Rover...");
        	}
            posY++;
            break;

        case 2:
        	if(posX + 1 > Plateau.getInstance("").getUpperRightX()){
        		throw new RoversException("Out of Rover...");
        	}
            posX++;
            break;

        case 3:
        	if(posY - 1 < 0){
        		throw new RoversException("Out of Rover...");
        	}
            posY--;
            break;

        case 4:
        	if(posX - 1 < 0){
        		throw new RoversException("Out of Rover...");
        	}
            posX--;
            break;
        }
    }

    private void changeDirection(char c)
    {
        if(c == 'L')
            direction--;
        if(c == 'R')
            direction++;
        if(direction == 0)
            direction = 4;
        if(direction == 5)
            direction = 1;
    }

    private static final Map <String, Integer> DIRECTION_STRING_TO_INT;
    private static final Map <Integer, String> DIRECTION_INT_TO_STRING;
    private int posX;
    private int posY;
    private int direction;

    static 
    {
        DIRECTION_STRING_TO_INT = new HashMap <String, Integer>();
        DIRECTION_INT_TO_STRING = new HashMap <Integer, String>();
        DIRECTION_STRING_TO_INT.put("N", Integer.valueOf(1));
        DIRECTION_STRING_TO_INT.put("E", Integer.valueOf(2));
        DIRECTION_STRING_TO_INT.put("W", Integer.valueOf(4));
        DIRECTION_STRING_TO_INT.put("S", Integer.valueOf(3));
        DIRECTION_INT_TO_STRING.put(Integer.valueOf(1), "N");
        DIRECTION_INT_TO_STRING.put(Integer.valueOf(2), "E");
        DIRECTION_INT_TO_STRING.put(Integer.valueOf(4), "W");
        DIRECTION_INT_TO_STRING.put(Integer.valueOf(3), "S");
    }
}