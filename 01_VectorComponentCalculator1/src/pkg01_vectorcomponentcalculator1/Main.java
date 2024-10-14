package pkg01_vectorcomponentcalculator1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double magnitude, angle, angleInRadians, Fx, Fy, calculatedMagnitude, calculatedAngle;
        int numberOfVectors;

        System.out.print("Enter the number of vectors: ");
        numberOfVectors = sc.nextInt();

        if (numberOfVectors <= 0) {
            System.out.println("The number of vectors must be greater than zero.");
            return;  // End program if invalid input
        }

        for (int i = 1; i <= numberOfVectors; i++) {
            System.out.print("Enter the magnitude of vector " + i + ": ");
            magnitude = sc.nextDouble();

            if (magnitude < 0) {
                System.out.println("Magnitude must be a positive value.");
                return;  // End program if invalid input
            }

            System.out.print("Enter the angle (in degrees) of vector " + i + ": ");
            angle = sc.nextDouble();

            // Convert angle to radians
            angleInRadians = Math.toRadians(angle);

            // Calculate components
            Fx = magnitude * Math.cos(angleInRadians);
            Fy = magnitude * Math.sin(angleInRadians);

            // Display Fx and Fy
            System.out.println("Fx = " + Fx);
            System.out.println("Fy = " + Fy);

            // Calculate magnitude using Pythagoras theorem
            calculatedMagnitude = Math.sqrt(Fx * Fx + Fy * Fy);
            System.out.println("Calculated magnitude using Pythagoras = " + calculatedMagnitude);

            // Ensure no division by zero when calculating angle
            if (Fx == 0) {
                if (Fy > 0) {
                    calculatedAngle = 90.0;
                } else if (Fy < 0) {
                    calculatedAngle = -90.0;
                } else {
                    calculatedAngle = 0.0;  // For zero vector
                }
            } else {
                calculatedAngle = Math.toDegrees(Math.atan(Fy / Fx));
            }

            System.out.println("Calculated angle using tan⁻¹(Fy / Fx) = " + calculatedAngle);
        }
    }
}
