package com.example.demo.challenges.parenthesis;


import java.util.Scanner;

/**
 * Problem Statement
 * You should choose P = 2, so that exactly 4 animals with energy levels (2, 3, 4 and 5) can be saved as these have energies greater than or equal to P.
 * Input Format
 * The first line of input consists of two space-separated integers, N (number of animals) and X (available capacity for animals that can be transported).
 * The second line of input consists of N space-separated integers, representing the energy of all the animals.
 * <p>
 * Constraints
 * 1<= N <=10^5
 * 1<= X <=N
 * 1<= arr[i] <=10^12
 * <p>
 * Arr[i] represents the energy level of the ith animal.
 * <p>
 * Output Format
 * Print the minimum energy level P such that exactly X animals can be saved or transported. If it is not possible to save exactly X animals, then print -1.
 * <p>
 * Sample TestCase 1
 * Input
 * 5 4
 * 1 3 2 4 5
 * Output
 * 2
 */
public class MaxAnimalByEnergyLevels {

    public static void main(String args[]) throws Exception {

        int firstNum, secondNum, result;
        Scanner scanner = new Scanner(System.in);

        // scanner.hasNextLine();
        String inputStrArr = scanner.nextLine();
        System.out.println(" inputStrArr :" + inputStrArr);
        String[] arrOfStr = inputStrArr.split(" ");
        int numOfAnimals = Integer.parseInt(arrOfStr[0]);
        int capacity = Integer.parseInt(arrOfStr[1]);
        System.out.println(" numOfAnimals : " + numOfAnimals);
        System.out.println(" capacity : " + capacity);

        String energyStr = scanner.nextLine();
        System.out.println(" energyStr : " + energyStr);
        String[] arrOfEnergyStr = energyStr.split(" ");
        for(String str : arrOfEnergyStr){
            
        }


    }
}
