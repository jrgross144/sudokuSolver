package com.grossj.sudokusolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudokusolverApplication {

	public static void main(String[] args) {
	    //TODO: How do we do this portion of this?
		SpringApplication.run(SudokusolverApplication.class, args);

        int[][][] array = {{{1,2,3},{4,5,6},{7,8,9}},
                {{4,5,6},{7,8,9},{1,2,3}},
                {{7,8,9},{1,2,3},{4,5,6}},
                {{2,3,1},{5,6,4},{8,9,7}},
                {{5,6,4},{8,9,7},{2,3,1}},
                {{8,9,7},{2,3,1},{5,6,4}},
                {{3,1,2},{6,4,5},{9,7,8}},
                {{6,4,5},{9,7,8},{3,1,2}},
                {{9,7,8},{3,1,2},{6,4,5}}
        };

        for (int x = 1; x <= 9; x++) {
            if(!verifyColumn(array, x)){
                System.out.println("Duplicate in column found. Bad, bad, bad");
                return;
            }
            if(!verifySection(array, x)){
                System.out.println("Duplicate in section found. Bad, bad, bad");
                return;
            }
            for(int row=0; row< array.length; row++) {
                if (!verifyRow(array[row], x)) {
                    System.out.println("Duplicate in row found. Bad, bad, bad");
                    return;
                }
            }
        }
        System.out.println("No Duplicate found in section");
    }

    public static boolean verifyRow(int[][] array, int x){
        int temp = 0;
        for (int section = 0; section < array.length; section++) {
            for (int column = 0; column < array[section].length; column++) {
                int cell = array[section][column];
                if(cell==x){
                    temp++;
                    if(temp > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean verifyColumn(int[][][] array, int x){
        for (int section = 0; section < array[0].length; section++) {
            for(int column = 0; column < array[0][section].length; column++) {
                int temp = 0;
                for (int row = 0; row < array[section].length; row++) {
                    int cell = array[row][section][column];
                    if (cell == x) {
                        temp++;
                        if(temp > 1){
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }

    public static boolean verifySection(int[][][] array, int x){
        for (int section = 0; section < array[0].length; section++) {
            for(int grouping = 0; grouping < 3; grouping++) {
                int temp = 0;
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < array[0][section].length; column++) {
                        int cell = array[row+(grouping*3)][section][column];
                        if (cell == x) {
                            temp++;
                            if (temp > 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;

    }

}
