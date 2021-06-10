package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeWithAI {

    private static final char ZERO = 'O';
    private static final char CROSS = 'X';
    private static final int SIZE_GAME_FIELD = 3;
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        startGame();
    }

    //TODO запуск игры: создание игрового поля и вызов меню игры (menuGame)
    public static void startGame() {
        char[][] gameField = createGameField();
        menuGame(gameField);
    }
    //TODO меню игры вызов
    private static void menuGame(char[][] gameField) {
        while (true) {
            int positionMenu = checkInputUser();
            if (positionMenu == 0) {
                break;
            }
            switch (positionMenu) {
                case (1):
                    easyVsUser(gameField);
                    clearGameField(gameField);
                    break;
                case 2:
                    userVsEasy(gameField);
                    clearGameField(gameField);
                    break;
                case 3:
                    easyVsEasy(gameField);
                    clearGameField(gameField);
                    break;
                case 4:
                    mediumVsUser(gameField);
                    clearGameField(gameField);
                    break;
                case 5:
                    userVsMedium(gameField);
                    clearGameField(gameField);
                    break;
                case 6:
                    mediumVsEasy(gameField);
                    clearGameField(gameField);
                    break;
                case 7:
                    easyVsMedium(gameField);
                    clearGameField(gameField);
                    break;
                case 8:
                    userVsHard(gameField);
                    clearGameField(gameField);
                    break;
                case 9:
                    hardVsUser(gameField);
                    clearGameField(gameField);
                    break;
            }
        }
    }

    private static int checkInputUser() {
        boolean flag = false;

        while (true) {
            if (flag) {
                System.out.println("Bad parameters!");
            }
            System.out.print("Input command: ");
            String[] commandUser = sc.nextLine().split(" ");
            switch (commandUser.length) {
                case 1:
                    if ("exit".equals(commandUser[0])) {
                        return 0;
                    }
                    break;
                case 3:
                    if ("start".equals(commandUser[0]) && "easy".equals(commandUser[1]) && "user".equals(commandUser[2])) {
                        return 1;
                    }
                    if ("start".equals(commandUser[0]) && "user".equals(commandUser[1]) && "easy".equals(commandUser[2])) {
                        return 2;
                    }
                    if ("start".equals(commandUser[0]) && "easy".equals(commandUser[1]) && "easy".equals(commandUser[2])) {
                        return 3;
                    }
                    if ("start".equals(commandUser[0]) && "medium".equals(commandUser[1]) && "user".equals(commandUser[2])) {
                        return 4;
                    }
                    if ("start".equals(commandUser[0]) && "user".equals(commandUser[1]) && "medium".equals(commandUser[2])) {
                        return 5;
                    }
                    if ("start".equals(commandUser[0]) && "medium".equals(commandUser[1]) && "easy".equals(commandUser[2])) {
                        return 6;
                    }
                    if ("start".equals(commandUser[0]) && "easy".equals(commandUser[1]) && "medium".equals(commandUser[2])) {
                        return 7;
                    }
                    if ("start".equals(commandUser[0]) && "user".equals(commandUser[1]) && "hard".equals(commandUser[2])) {
                        return 8;
                    }
                    if ("start".equals(commandUser[0]) && "hard".equals(commandUser[1]) && "user".equals(commandUser[2])) {
                        return 9;
                    }
                    break;
            }
            flag = true;
        }
    }

    private static void easyVsUser(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveEasy(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveUser(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static void userVsEasy(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveUser(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveEasy(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static void easyVsEasy(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveEasy(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveEasy(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static void mediumVsUser(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveMedium(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveUser(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static void mediumVsEasy(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveMedium(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveEasy(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static void userVsMedium(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveUser(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveMedium(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }

        }
    }

    private static void easyVsMedium(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveEasy(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveMedium(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static void hardVsUser(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveHard(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveUser(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static void userVsHard(char[][] gemaField) {
        printGameField(gemaField);
        while (true) {
            moveUser(gemaField, 1);
            printGameField(gemaField);
            if (checkPlayerX(gemaField)) {
                System.out.println(CROSS + " wins");
                break;
            }
            if (!checkDraw(gemaField)) {
                System.out.println("Draw");
                break;
            }
            moveHard(gemaField, 2);
            printGameField(gemaField);
            if (checkPlayerO(gemaField)) {
                System.out.println(ZERO + " wins");
                break;
            }
        }
    }

    private static char[][] createGameField() {
        char[][] arrayPlayField = new char[SIZE_GAME_FIELD][SIZE_GAME_FIELD];
        for (int i = 0; i < SIZE_GAME_FIELD; i++) {
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                arrayPlayField[i][j] = ' ';
            }
        }
        return arrayPlayField;
    }

    private static char[][] clearGameField(char[][] arrayPlayField) {
        for (int i = 0; i < SIZE_GAME_FIELD; i++) {
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                arrayPlayField[i][j] = ' ';
            }
        }
        return arrayPlayField;
    }


    private static void moveUser(char[][] arrayPlayField, int startMoveUser) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String coordinate1 = sc.next();
            String coordinate2 = sc.next();
            if (!checkOnIntField(coordinate1) && !checkOnIntField(coordinate2)) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int coordinate1Int = Integer.parseInt(coordinate1);
            int coordinate2Int = Integer.parseInt(coordinate2);

            if (!checkRangeCoordinate(coordinate1Int) || !checkRangeCoordinate(coordinate2Int)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (checkOccupiedField(arrayPlayField, coordinate1Int, coordinate2Int)) {
                    arrayPlayField[coordinate1Int - 1][coordinate2Int - 1] = (startMoveUser == 1 ) ? CROSS : ZERO;
                    break;
            } else
                System.out.println("This cell is occupied! Choose another one!");
        }
    }

    private static void moveEasy(char[][] arrayPlayField, int  startMoveEasy) {
        while (true) {
            int coordinate1 = random.nextInt(3) + 1;
            int coordinate2 = random.nextInt(3) + 1;

            if (checkOccupiedField(arrayPlayField, coordinate1, coordinate2)) {
                    arrayPlayField[coordinate1 - 1][coordinate2 - 1] = (startMoveEasy == 1 ) ? CROSS : ZERO;
                System.out.print("Making move level \"easy\"\n");
                    break;
            }
        }
    }

    private static void moveMedium(char[][] arrayPlayField, int  startMoveEasy) {
        int coordinate1;
        int coordinate2;
        boolean flag = true;
        while (true) {
            if ((checkPossibilityWin(arrayPlayField,startMoveEasy == 1 ? CROSS : ZERO)[0]) != 0 && (checkPossibilityWin(arrayPlayField,startMoveEasy == 1  ? CROSS : ZERO)[1]) != 0) {
                coordinate1 = checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[0];
                coordinate2 = checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[1];
                flag = false;
            } else {
                coordinate1 = random.nextInt(3) + 1;
                coordinate2 = random.nextInt(3) + 1;
            }

            if ((checkPossibilityWin(arrayPlayField,startMoveEasy == 1 ? ZERO : CROSS)[0]) != 0 && (checkPossibilityWin(arrayPlayField,startMoveEasy == 1 ? ZERO : CROSS)[1]) != 0 && flag) {
                coordinate1 = (checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? ZERO : CROSS))[0];
                coordinate2 = (checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? ZERO : CROSS))[1];
            }

            if (checkOccupiedField(arrayPlayField, coordinate1, coordinate2)) {
                arrayPlayField[coordinate1 - 1][coordinate2 - 1] = startMoveEasy == 1  ? CROSS : ZERO;
                System.out.print("Making move level \"medium\"\n");
                break;
            }
        }
    }

    private static void moveHard(char[][] arrayPlayField, int  startMoveEasy) {
        int coordinate1;
        int coordinate2;
        boolean flag1 = true;
        boolean flag2 = true;
        while (true) {
            if ((checkPossibilityWin(arrayPlayField,startMoveEasy == 1 ? CROSS : ZERO)[0]) != 0 && (checkPossibilityWin(arrayPlayField,startMoveEasy == 1  ? CROSS : ZERO)[1]) != 0) {
                coordinate1 = checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[0];
                coordinate2 = checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[1];
                flag1 = false;
            } else {
                coordinate1 = random.nextInt(3) + 1;
                coordinate2 = random.nextInt(3) + 1;
            }

            if ((checkPossibilityWin(arrayPlayField,startMoveEasy == 1 ? ZERO : CROSS)[0]) != 0 && (checkPossibilityWin(arrayPlayField,startMoveEasy == 1 ? ZERO : CROSS)[1]) != 0 && flag1) {
                coordinate1 = (checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? ZERO : CROSS))[0];
                coordinate2 = (checkPossibilityWin(arrayPlayField, startMoveEasy == 1 ? ZERO : CROSS))[1];
                flag2 = false;
            }
            if (movesHard(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[0] != -1 && movesHard(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[1] != -1&& flag1 && flag2) {
                coordinate1 = movesHard(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[0];
                coordinate2 = movesHard(arrayPlayField, startMoveEasy == 1 ? CROSS : ZERO)[1];
            }
            if (checkOccupiedField(arrayPlayField, coordinate1, coordinate2)) {
                arrayPlayField[coordinate1 - 1][coordinate2 - 1] = startMoveEasy == 1  ? CROSS : ZERO;
                System.out.print("Making move level \"hard\"\n");
                break;
            }
        }
    }

    private static boolean checkOccupiedField(char[][] arrayPlayField, int coordinate1, int coordinate2) {
        return arrayPlayField[coordinate1 - 1][coordinate2 - 1] == ' ';
    }

    private static boolean checkOnIntField(String coordinate) {
        return coordinate.matches("\\d+");
    }

    private static boolean checkRangeCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 4;
    }

    private static void printGameField(char[][] arrayPlayField) {
        System.out.println("---------");
        for (int i = 0; i < SIZE_GAME_FIELD; i++) {
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                if (j == 0) {
                    System.out.print("| " + arrayPlayField[i][j] + " ");
                } else if (j == SIZE_GAME_FIELD - 1) {
                    System.out.print(arrayPlayField[i][j] + " |");
                } else {
                    System.out.print(arrayPlayField[i][j] + " ");
                }

            }
            System.out.println("");
            if (i == SIZE_GAME_FIELD - 1) {
                System.out.print("---------\n");
            }
        }

    }

    private static boolean checkPlayerX(char[][] arrayPlayField) {
        return checkWin(arrayPlayField, CROSS) && !checkWin(arrayPlayField, ZERO);
    }

    private static boolean checkPlayerO(char[][] arrayPlayField) {
        return (checkWin(arrayPlayField, ZERO) && !checkWin(arrayPlayField, CROSS));
    }
    private static boolean checkDraw(char[][] arrayPlayField) {
        boolean flag = false;
        for (int i = 0; i < SIZE_GAME_FIELD && !flag; i++) {
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                if (arrayPlayField[i][j] == ' ') {
                    flag = true;

                }
            }
        }
        return flag;
    }

    private static boolean checkWin(char[][] arrayPlayField, char symbol) {
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        boolean cols = false;
        boolean rows = false;

        for (int i = 0; i < SIZE_GAME_FIELD; i++) {
            diagonal1 = diagonal1 && arrayPlayField[i][i] == symbol;
            diagonal2 = diagonal2 && arrayPlayField[SIZE_GAME_FIELD - 1 - i][i] == symbol;
        }

        for (int i = 0; i < SIZE_GAME_FIELD; i++) {
            cols = true;
            rows = true;
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                cols = cols && arrayPlayField[i][j] == symbol;
                rows = rows && arrayPlayField[j][i] == symbol;
            }
            if (cols || rows) {
                break;
            }
        }

        if (diagonal1 || diagonal2 || rows || cols) {
            return true;
        }
        return false;
    }

    private static int[] checkPossibilityWin(char[][] arrayPlayField, char symbol) {
        int col = -1;
        int row = -1;
        int counter1 = 0;
        boolean flag = true;

        for (int i = 0; i < SIZE_GAME_FIELD && flag; i++) {
            if (arrayPlayField[i][i] == symbol) {
                counter1++;
            }
            if (arrayPlayField[i][i] == ' ') {
                col = i;
                row = i;
            }
        }

        if (counter1 != 2 && flag) {
            col = -1;
            row = -1;
        }
        if (row != -1 && col != -1) {
            flag = false;
        }

        counter1 = 0;

        for (int i = 0; i < SIZE_GAME_FIELD && flag; i++) {
            if (arrayPlayField[SIZE_GAME_FIELD - i - 1][i] == symbol) {
                counter1++;
            }
            if (arrayPlayField[SIZE_GAME_FIELD - i - 1][i] == ' ') {
                col = i;
                row = SIZE_GAME_FIELD - i - 1;
            }
        }

        if (counter1 != 2 && flag) {
            col = -1;
            row = -1;
        }
        if (row != -1 && col != -1) {
            flag = false;
        }
        counter1 = 0;

        for (int i = 0; i < SIZE_GAME_FIELD && flag; i++) {
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                if (arrayPlayField[i][j] == symbol) {
                    counter1++;
                }
                if (arrayPlayField[i][j] == ' ') {
                    col = j;
                    row = i;
                }
            }
            if (counter1 != 2 && flag) {
                col = -1;
                row = -1;
                counter1 = 0;
            }
            if (row != -1 && col != -1) {
                flag = false;
            } else {
                counter1 = 0;
            }

        }

        for (int i = 0; i < SIZE_GAME_FIELD && flag; i++) {
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                if (arrayPlayField[j][i] == symbol) {
                    counter1++;
                }
                if (arrayPlayField[j][i] == ' ') {
                    col = i;
                    row = j;
                }
            }
            if (counter1 != 2) {
                col = -1;
                row = -1;
                counter1 = 0;
            }
            if (row != -1 && col != -1 && flag) {
                flag = false;
            } else {
                counter1 = 0;
            }
        }
        return new int[]{row + 1, col + 1};
    }
    private static int[] movesHard(char[][] arrayPlayField, char symbol) {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        int[] moveHard1 = {-1, -1};

        for (int i = 0; i < SIZE_GAME_FIELD; i++) {
            for (int j = 0; j < (i == 0 ? SIZE_GAME_FIELD: 1); j++) {
                flag1 = flag1 && arrayPlayField[i][j] == ' ' || arrayPlayField[i][j] == symbol;
            }
        }
        if (flag1) {
            if (arrayPlayField[1][0] == ' ') {
                moveHard1[0] = 2;
                moveHard1[1] = 1;
                return  moveHard1;
            }
            else if (arrayPlayField[0][1] == ' ') {
                moveHard1[0] = 1;
                moveHard1[1] = 2;
                return moveHard1;
            }
            else if (arrayPlayField[0][0] == ' ') {
                moveHard1[0] = 1;
                moveHard1[1] = 1;
                return moveHard1;
            }
        }

        for (int i = 0; i < SIZE_GAME_FIELD && !flag1; i++) {
            for (int j = (i != 0 ? SIZE_GAME_FIELD - 1 : 0); j < SIZE_GAME_FIELD; j++) {
                flag2 = flag2 && arrayPlayField[i][j] == ' ' || arrayPlayField[i][j] == symbol;
            }
        }
        if (flag2) {
            if (arrayPlayField[1][0] == ' ') {
                moveHard1[0] = 1;
                moveHard1[1] = 2;
                return  moveHard1;
            }
            else if (arrayPlayField[0][1] == ' ') {
                moveHard1[0] = 2;
                moveHard1[1] = 3;
                return moveHard1;
            }
            else if (arrayPlayField[0][0] == ' ') {
                moveHard1[0] = 1;
                moveHard1[1] = 3;
                return moveHard1;
            }
        }

        for (int i = 0; i < SIZE_GAME_FIELD && !flag1 && !flag2; i++) {
            for (int j = (i != 2 ? SIZE_GAME_FIELD - 1 : 0); j < SIZE_GAME_FIELD; j++) {
                flag3 = flag3 && arrayPlayField[i][j] == ' ' || arrayPlayField[i][j] == symbol;
            }
        }

        if (flag3) {
            if (arrayPlayField[1][0] == ' ') {
                moveHard1[0] = 3;
                moveHard1[1] = 2;
                return  moveHard1;
            }
            else if (arrayPlayField[0][1] == ' ') {
                moveHard1[0] = 2;
                moveHard1[1] = 3;
                return moveHard1;
            }
            else if (arrayPlayField[0][0] == ' ') {
                moveHard1[0] = 3;
                moveHard1[1] = 3;
                return moveHard1;
            }
        }

        for (int i = 0; i < SIZE_GAME_FIELD && !flag1 && !flag2 && !flag3 ; i++) {
            for (int j = 0; j < (i == 2 ? SIZE_GAME_FIELD: 1); j++) {
                flag4 = flag4 && arrayPlayField[i][j] == ' ' || arrayPlayField[i][j] == symbol;
            }
        }
        if (flag4) {
            if (arrayPlayField[1][0] == ' ') {
                moveHard1[0] = 2;
                moveHard1[1] = 1;
                return  moveHard1;
            }
            else if (arrayPlayField[0][1] == ' ') {
                moveHard1[0] = 3;
                moveHard1[1] = 2;
                return moveHard1;
            }
            else if (arrayPlayField[0][0] == ' ') {
                moveHard1[0] = 3;
                moveHard1[1] = 0;
                return moveHard1;
            }
        }
        return moveHard1;
    }
}