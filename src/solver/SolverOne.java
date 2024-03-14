package solver;

import java.util.*;

public class SolverOne {
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

	private boolean isNumOneAway(int number, int row, int col, int[][] boardNum) {
		if (isValid(row - 1, col) && boardNum[row - 1][col] == number) {
			return true;
		}
		if (isValid(row + 1, col) && boardNum[row + 1][col] == number) {
			return true;
		}
		if (isValid(row, col - 1) && boardNum[row][col - 1] == number) {
			return true;
		}
		if (isValid(row, col + 1) && boardNum[row][col + 1] == number) {
			return true;
		}
		return false;
	}

	private boolean isNumTwoAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -2; i <= 2; i++) {
			if (i % 2 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 2) && boardNum[row][col - 2] == number) {
						return true;
					}
					if (isValid(row, col + 2) && boardNum[row][col + 2] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 2;
				} else {
					x = 2 - i;
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

	private boolean isNumThreeAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -3; i <= 3; i++) {
			if (i % 3 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 3) && boardNum[row][col - 3] == number) {
						return true;
					}
					if (isValid(row, col + 3) && boardNum[row][col + 3] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 3;
				} else {
					x = 3 - i;
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

	private boolean isNumFourAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -4; i <= 4; i++) {
			if (i % 4 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 4) && boardNum[row][col - 4] == number) {
						return true;
					}
					if (isValid(row, col + 4) && boardNum[row][col + 4] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 4;
				} else {
					x = 4 - i;
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

	private boolean isNumFiveAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -5; i <= 5; i++) {
			if (i % 5 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 5) && boardNum[row][col - 5] == number) {
						return true;
					}
					if (isValid(row, col + 5) && boardNum[row][col + 5] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 5;
				} else {
					x = 5 - i;
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

	private boolean isNumSixAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -6; i <= 6; i++) {
			if (i % 6 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 6) && boardNum[row][col - 6] == number) {
						return true;
					}
					if (isValid(row, col + 6) && boardNum[row][col + 6] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 6;
				} else {
					x = 6 - i;
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

	private boolean isNumSevenAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -7; i <= 7; i++) {
			if (i % 7 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 7) && boardNum[row][col - 7] == number) {
						return true;
					}
					if (isValid(row, col + 7) && boardNum[row][col + 7] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 7;
				} else {
					x = 7 - i;
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

	private boolean isNumEightAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -8; i <= 8; i++) {
			if (i % 8 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 8) && boardNum[row][col - 8] == number) {
						return true;
					}
					if (isValid(row, col + 8) && boardNum[row][col + 8] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 8;
				} else {
					x = 8 - i;
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

	private boolean isNumNineAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -9; i <= 9; i++) {
			if (i % 9 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 9) && boardNum[row][col - 9] == number) {
						return true;
					}
					if (isValid(row, col + 9) && boardNum[row][col + 9] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 9;
				} else {
					x = 9 - i;
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

	private boolean isNumTenAway(int number, int row, int col, int[][] boardNum) {
		for (int i = -10; i <= 10; i++) {
			if (i % 10 == 0) {
				if (i != 0) {
					if (isValid(row + i, col) && boardNum[row + i][col] == number) {
						return true;
					}
				} else {
					if (isValid(row, col - 10) && boardNum[row][col - 10] == number) {
						return true;
					}
					if (isValid(row, col + 10) && boardNum[row][col + 10] == number) {
						return true;
					}
				}
			} else {
				int x = 0;
				if (i < 0) {
					x = i + 10;
				} else {
					x = 10 - i;
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
		if (number == 2) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 3) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 4) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 5) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFourAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 6) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFourAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFiveAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 7) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFourAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFiveAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumSixAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 8) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFourAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFiveAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumSixAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumSevenAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 9) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFourAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFiveAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumSixAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumSevenAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumEightAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 10) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFourAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumFiveAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumSixAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumSevenAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumEightAway(number, row, col, boardNum)) {
				return true;
			}
			if (isNumNineAway(number, row, col, boardNum)) {
				return true;
			}
		}
		return false;
	}

	private boolean isNumCloseEnough(int number, int row, int col, int[][] boardNum) {
		if (number == 1) {
			if (isNumOneAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 2) {
			if (isNumTwoAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 3) {
			if (isNumThreeAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 4) {
			if (isNumFourAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 5) {
			if (isNumFiveAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 6) {
			if (isNumSixAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 7) {
			if (isNumSevenAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 8) {
			if (isNumEightAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 9) {
			if (isNumNineAway(number, row, col, boardNum)) {
				return true;
			}
		}
		if (number == 10) {
			if (isNumTenAway(number, row, col, boardNum)) {
				return true;
			}
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