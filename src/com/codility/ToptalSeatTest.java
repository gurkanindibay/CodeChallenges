package com.codility;

public class ToptalSeatTest {
    public int solution(int rowCount, String seatNumbers) {

        int[][] reservedSeats = getSeatNumbersArray(seatNumbers);
        for (int i = 0; i < reservedSeats.length; i++) {
            for (int j = 0; j < reservedSeats[i].length; j++)
                System.out.println(reservedSeats[i][j]);
        }
        int[][] seatMatrix = new int[rowCount][10];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 10; j++) {
                if (isSeatNumberInReservedSeats(i, j, reservedSeats)) seatMatrix[i][j] = 1;
                else seatMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < seatMatrix.length; i++) {
            for (int j = 0; j < seatMatrix[i].length; j++)
                System.out.print(seatMatrix[i][j]);
            System.out.println("\n");
        }

        String[] seatStrings = new String[rowCount];

        for (int i = 0; i < rowCount; i++) {
            seatStrings[i] = "";
            for (int j = 0; j < 10; j++) {
                seatStrings[i] += String.valueOf(seatMatrix[i][j]);
            }
        }

        int fourInARowCount = 0;
        for (int i = 0; i < seatMatrix.length; i++) {
            int count = 0;
            for (int j = 0; j < seatMatrix[i].length; j++){
                if(seatMatrix[i][j]==0) count=count+1;
                else count=0;
                if(count==4){
                    fourInARowCount+=1;
                    count=0;
                }
            }
        }

        return fourInARowCount;

    }

    private boolean isSeatNumberInReservedSeats(int rowIndex, int seatIndex, int[][] reservedSeats) {
        for (int i = 0; i < reservedSeats.length; i++) {
            if (reservedSeats[i][0] - 1 == rowIndex && reservedSeats[i][1] - 1 == seatIndex) {
                return true;
            }
        }
        return false;
    }

    private int[][] getSeatNumbersArray(String seatNumbers) {

        String[] seatNumbersArray = seatNumbers.split(" ");
        int[][] seats = new int[seatNumbersArray.length][2];
        for (int i = 0; i < seatNumbersArray.length; i++) {
            String seatNumber = seatNumbersArray[i];
            int temp = (int) seatNumber.charAt(1);
            int temp_integer = 64;
            int index = temp - temp_integer;
            seats[i][0] = Integer.valueOf(seatNumber.substring(0, 1));
            seats[i][1] = index;
        }
        return seats;
    }

    public static void main(String args[]) {


        ToptalSeatTest toptalSeatTest = new ToptalSeatTest();
        int count = toptalSeatTest.solution(2, "1A 2F 1C");

        System.out.println("Count:" + count);
    }
}
