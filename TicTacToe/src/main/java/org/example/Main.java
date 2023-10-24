package org.example;

import service.TicTacToeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        TicTacToeService ticTacToeService = TicTacToeService.getInstance();
        System.out.println("Game started. Player X starts");
        while (!ticTacToeService.isGameFinished())
        {

            System.out.println("Give me Your x: ");
            BufferedReader readerX =
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Give me Your y: ");
            BufferedReader readerY =
                    new BufferedReader(new InputStreamReader(System.in));
            try {
                String [][] array = ticTacToeService.setCharacterOnPosition(Integer.parseInt(readerX.readLine()), Integer.parseInt(readerY.readLine()));
                drawMeCuteArray(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void drawMeCuteArray(String [][] array)
    {
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                System.out.print(array[x][y]+ " | ");
            }
            System.out.println("");
        }
    }
}