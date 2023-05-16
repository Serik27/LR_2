package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;

    private int[][] matrix;
    private int width;
    private int height;

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    public void run() {
        inputMatrixSize();
        createMatrix();
        printMatrix();
        findMinMax();
        calculateAverage();
    }

    private void inputMatrixSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the width of the matrix (1-" + MAX_SIZE + "): ");
        width = scanner.nextInt();
        width = Math.min(Math.max(width, 1), MAX_SIZE);

        System.out.print("Enter the height of the matrix (1-" + MAX_SIZE + "): ");
        height = scanner.nextInt();
        height = Math.min(Math.max(height, 1), MAX_SIZE);
    }

    private void createMatrix() {
        matrix = new int[height][width];

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Choose how to create the matrix:");
        System.out.println("1. Manual input");
        System.out.println("2. Random values");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                manualInput(scanner);
                break;
            case 2:
                randomInput(random);
                break;
            default:
                System.out.println("Invalid choice. Using random input.");
                randomInput(random);
                break;
        }
    }

    private void manualInput(Scanner scanner) {
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private void randomInput(Random random) {
        System.out.println("Generating random matrix...");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
            }
        }
    }

    private void printMatrix() {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private void findMinMax() {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
        }

        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    private void calculateAverage() {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }

        double average = (double) sum / count;
        System.out.println("Average: " + average);
    }
}
