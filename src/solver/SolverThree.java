package solver;

import java.util.*;

public class SolverThree {
	public int size = 10;
	public int maxNum = 10;

	private boolean isNumAllowedInRegion(int number, int row, int col, Map<String, ArrayList<Coordinates>> filledMap,
			String[][] boardReg, int[][] boardNum, Map<String, Integer> regsSize) {
		ArrayList<Coordinates> filledCords = filledMap.get(boardReg[row][col]);
		if (number <= regsSize.get(boardReg[row][col])) {
			for (Coordinates cords : filledCords) {
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

	private boolean isValidPlacement(int number, int row, int col, Map<String, ArrayList<Coordinates>> filledMap,
			String[][] boardReg, int[][] boardNum, Map<String, Integer> regsSize) {
		if (isValid(row, col) && boardNum[row][col] == 0
				&& isNumAllowedInRegion(number, row, col, filledMap, boardReg, boardNum, regsSize)) {
			if (!(isNumTooClose(number, row, col, boardNum))) {
				return true;
			}
		}
		return false;
	}

	public boolean solveBoard(int[][] board, ArrayList<ArrayList<Coordinates>> emptyRegions,
			Map<String, ArrayList<Coordinates>> filledMap, String[][] boardReg, Map<String, Integer> regsSize) {
		if (!(fillInOneEmpty(board, emptyRegions, filledMap, boardReg, regsSize))) {
			return false;
		}
		sortRegionList(emptyRegions);
		for (ArrayList<Coordinates> emptyRegs : emptyRegions) {
			if (emptyRegs.size() > 0) {
				sortCoords(emptyRegs);
				Coordinates cords = emptyRegs.getFirst();
				int row = cords.row;
				int col = cords.col;
				for (int num = 1; num <= maxNum; num++) {
					if (isValidPlacement(num, row, col, filledMap, boardReg, board, regsSize)) {
						board[row][col] = num;
						ArrayList<Coordinates> filledList = filledMap.get(boardReg[row][col]);
						filledList.add(cords);
						ArrayList<Coordinates> emptyList = null;
						for (ArrayList<Coordinates> cordList : emptyRegions) {
							for (Coordinates cord2 : cordList) {
								if (cord2.row == row && cord2.col == col) {
									emptyList = cordList;
								}
							}
						}
						emptyList.remove(cords);
						if (solveBoard(board, emptyRegions, filledMap, boardReg, regsSize)) {
							return true;
						} else {
							board[row][col] = 0;
							emptyList.add(cords);
							filledList.remove(cords);
						}
					}
				}
				return false;
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

	private boolean fillInOneEmpty(int[][] board, ArrayList<ArrayList<Coordinates>> emptyRegions,
			Map<String, ArrayList<Coordinates>> filledMap, String[][] boardReg, Map<String, Integer> regsSize) {
		sortRegionList(emptyRegions);
		for (ArrayList<Coordinates> emptyRegs : emptyRegions) {
			if (emptyRegs.size() == 1) {
				Coordinates cords = emptyRegs.getFirst();
				int row = cords.row;
				int col = cords.col;
				for (int num = 1; num <= maxNum; num++) {
					if (isValidPlacement(num, row, col, filledMap, boardReg, board, regsSize)) {
						board[row][col] = num;
						ArrayList<Coordinates> filledList = filledMap.get(boardReg[row][col]);
						filledList.add(cords);
						emptyRegions.remove(emptyRegs);
						if (solveBoard(board, emptyRegions, filledMap, boardReg, regsSize)) {
							return true;
						} else {
							board[row][col] = 0;
							emptyRegions.add(emptyRegs);
							filledList.remove(cords);
						}
					}
				}
				return false;
			} else if (emptyRegs.size() > 1) {
				break;
			}
		}
		return true;
	}

	private ArrayList<ArrayList<Coordinates>> sortRegionList(ArrayList<ArrayList<Coordinates>> emptyRegions) {
		Collections.sort(emptyRegions, new Comparator<ArrayList<Coordinates>>() {
			@Override
			public int compare(ArrayList<Coordinates> list1, ArrayList<Coordinates> list2) {
				return Integer.compare(list1.size(), list2.size());
			}
		});
		return emptyRegions;
	}

	private ArrayList<Coordinates> sortCoords(ArrayList<Coordinates> coordsList) {
		Collections.sort(coordsList);
		return coordsList;
	}
}