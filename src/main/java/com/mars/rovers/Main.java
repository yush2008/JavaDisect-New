
package com.mars.rovers;

import java.util.Scanner;


public class Main
{

    public Main()
    {
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Upper Right Coordinates of (e.g. x y)");
        String upperRightCoords = scanner.nextLine();//read the user input
        Plateau.getInstance(upperRightCoords);
        String answer;
        do
        {
            System.out.println("Enter Rover's current position (e.g. 1 2 N x_axis, y_axis, face_direction)");
            String roverInputs = scanner.nextLine();
            Rover rover = new Rover(roverInputs.toUpperCase());
            System.out.println("Enter movments:");
            String currentPos = rover.move(scanner.nextLine().toUpperCase());
            System.out.println(currentPos);
            System.out.println("=================================");
            System.out.println();
            System.out.println("Do u want to change another Rover position (Y/N)");
            answer = scanner.nextLine();
        } while("Y".equalsIgnoreCase(answer));
    }
}