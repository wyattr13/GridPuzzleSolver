package solver;

import java.util.*;

public class SolverTwo {
	public int size = 10;
	public int maxNum = 10;

	private boolean isNumAllowedInRegion(int number, int row, int col, Map<String, ArrayList<Coordinates>> map,
			String[][] boardReg, int[][] boardNum) {
		if (number <= map.get(boardReg[row][col]).size()) {
			for (Coordinates cords : map.get(boardReg[row][col])) {
				if (number == boardNum[cords.row][cords.col]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean numDistChecker(int number, int row, int col, int[][] boardNum, int distance) {
		for (int i = -distance; i <= distance; i++) {
			if (i % distance == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - distance) && boardNum[row][col - distance] == number) {
						return true;
					}
					if (isValid(row, col + distance) && boardNum[row][col + distance] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + distance;
				} else {
					x = distance - i;
				}
				if (isValid(row + i, col - x) && boardNum[row + i][col - x] == number) {
					return true;
				}
				if (isValid(row + i, col + x) && boardNum[row + i][col + x] == number) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValid(int row, int col) {
		if (row >= 0 && row <= (size - 1) && col >= 0 && col <= (size - 1)) {
			return true;
		}
		return false;
	}

	private boolean isNumTooClose(int number, int row, int col, int[][] boardNum) {
		for (int i = 1; i < number; i++) {
			if (numDistChecker(number, row, col, boardNum, i)) {
				return true;
			}
		}
		return false;
	}

	private boolean isNumCloseEnough(int number, int row, int col, int[][] boardNum) {
		if (numDistChecker(number, row, col, boardNum, number)) {
			return true;
		}
		return false;
	}

	private boolean isValidPlacement(int number, int row, int col, Map<String, ArrayList<Coordinates>> map,
			String[][] boardReg, int[][] boardNum) {
		if (!(isNumTooClose(number, row, col, boardNum))
				&& isNumAllowedInRegion(number, row, col, map, boardReg, boardNum)) {
			return true;
		}
		return false;
	}

	public boolean solveBoard(int[][] board, Map<String, ArrayList<Coordinates>> map, String[][] boardReg) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (board[row][col] == 0) {
					for (int numToTry = 1; numToTry <= maxNum; numToTry++) {
						if (isValidPlacement(numToTry, row, col, map, boardReg, board)) {
							board[row][col] = numToTry;

							if (solveBoard(board, map, boardReg)) {
								return true;
							} else {
								board[row][col] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (!(isNumCloseEnough(board[row][col], row, col, board))) {
					return false;
				}
			}
		}
		return true;
	}
}