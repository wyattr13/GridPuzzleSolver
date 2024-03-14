package tests;
import java.util.*;
import solver.Coordinates;
import solver.SolverOne;
import solver.SolverTwo;
import solver.SolverThree;
 

public class ExamplePuzzle {
	
	public static void main(String[] args) {
		//Creating all of the data structures
		int[][] boardNum = {
				{0, 0, 0, 0, 0} ,
				{0, 0, 0, 0, 2} ,
				{0, 0, 4, 0, 0} ,
				{3, 0, 0, 0, 0} ,
				{0, 0, 0, 0, 0}
		};
			
		String[][] boardReg = {
				{"A", "A", "B", "B", "B"} ,
				{"C", "A", "A", "D", "B"} ,
				{"C", "E", "A", "F", "B"} ,
				{"C", "G", "G", "F", "F"} ,
				{"C", "C", "G", "H", "F"} ,
		};
		
		Map<String, ArrayList<Coordinates>> mapS1S2 = new HashMap<>();

		ArrayList<ArrayList<Coordinates>> emptyRegions = new ArrayList<>();
		Map<String, ArrayList<Coordinates>> filledRegions = new HashMap<>();
		Map<String, Integer> regsSize = new HashMap<>();

		ArrayList<Coordinates> a = new ArrayList<>();
		a.add(new Coordinates(0, 0));
		a.add(new Coordinates(0, 1));
		a.add(new Coordinates(1, 1));
		a.add(new Coordinates(1, 2));
		a.add(new Coordinates(2, 2));
		mapS1S2.put("A", a);

		ArrayList<Coordinates> aEmpty = new ArrayList<>();
		aEmpty.add(new Coordinates(0, 0));
		aEmpty.add(new Coordinates(0, 1));
		aEmpty.add(new Coordinates(1, 1));
		aEmpty.add(new Coordinates(1, 2));
		ArrayList<Coordinates> aFilled = new ArrayList<>();
		aFilled.add(new Coordinates(2, 2));
		emptyRegions.add(aEmpty);
		filledRegions.put("A", aFilled);
		regsSize.put("A", 5);

		ArrayList<Coordinates> b = new ArrayList<>();
		b.add(new Coordinates(0, 2));
		b.add(new Coordinates(0, 3));
		b.add(new Coordinates(0, 4));
		b.add(new Coordinates(1, 4));
		b.add(new Coordinates(2, 4));
		mapS1S2.put("B", b);

		ArrayList<Coordinates> bEmpty = new ArrayList<>();
		bEmpty.add(new Coordinates(0, 2));
		bEmpty.add(new Coordinates(0, 3));
		bEmpty.add(new Coordinates(0, 4));
		bEmpty.add(new Coordinates(2, 4));
		ArrayList<Coordinates> bFilled = new ArrayList<>();
		bFilled.add(new Coordinates(1, 4));
		emptyRegions.add(bEmpty);
		filledRegions.put("B", bFilled);
		regsSize.put("B", 5);

		ArrayList<Coordinates> c = new ArrayList<>();
		c.add(new Coordinates(1, 0));
		c.add(new Coordinates(2, 0));
		c.add(new Coordinates(3, 0));
		c.add(new Coordinates(4, 0));
		c.add(new Coordinates(4, 1));
		mapS1S2.put("C", c);

		ArrayList<Coordinates> cEmpty = new ArrayList<>();
		cEmpty.add(new Coordinates(1, 0));
		cEmpty.add(new Coordinates(2, 0));
		cEmpty.add(new Coordinates(4, 0));
		cEmpty.add(new Coordinates(4, 1));
		ArrayList<Coordinates> cFilled = new ArrayList<>();
		cFilled.add(new Coordinates(3, 0));
		emptyRegions.add(cEmpty);
		filledRegions.put("C", cFilled);
		regsSize.put("C", 5);

		ArrayList<Coordinates> d = new ArrayList<>();
		d.add(new Coordinates(1, 3));
		mapS1S2.put("D", d);

		ArrayList<Coordinates> dEmpty = new ArrayList<>();
		dEmpty.add(new Coordinates(1, 3));
		ArrayList<Coordinates> dFilled = new ArrayList<>();
		emptyRegions.add(dEmpty);
		filledRegions.put("D", dFilled);
		regsSize.put("D", 1);

		ArrayList<Coordinates> e = new ArrayList<>();
		e.add(new Coordinates(2, 1));
		mapS1S2.put("E", e);

		ArrayList<Coordinates> eEmpty = new ArrayList<>();
		eEmpty.add(new Coordinates(2, 1));
		ArrayList<Coordinates> eFilled = new ArrayList<>();
		emptyRegions.add(eEmpty);
		filledRegions.put("E", eFilled);
		regsSize.put("E", 1);

		ArrayList<Coordinates> f = new ArrayList<>();
		f.add(new Coordinates(2, 3));
		f.add(new Coordinates(3, 3));
		f.add(new Coordinates(3, 4));
		f.add(new Coordinates(4, 4));
		mapS1S2.put("F", f);

		ArrayList<Coordinates> fEmpty = new ArrayList<>();
		fEmpty.add(new Coordinates(2, 3));
		fEmpty.add(new Coordinates(3, 3));
		fEmpty.add(new Coordinates(3, 4));
		fEmpty.add(new Coordinates(4, 4));
		ArrayList<Coordinates> fFilled = new ArrayList<>();
		emptyRegions.add(fEmpty);
		filledRegions.put("F", fFilled);
		regsSize.put("F", 4);

		ArrayList<Coordinates> g = new ArrayList<>();
		g.add(new Coordinates(3, 1));
		g.add(new Coordinates(3, 2));
		g.add(new Coordinates(4, 2));
		mapS1S2.put("G", g);

		ArrayList<Coordinates> gEmpty = new ArrayList<>();
		gEmpty.add(new Coordinates(3, 1));
		gEmpty.add(new Coordinates(3, 2));
		gEmpty.add(new Coordinates(4, 2));
		ArrayList<Coordinates> gFilled = new ArrayList<>();
		emptyRegions.add(gEmpty);
		filledRegions.put("G", gFilled);
		regsSize.put("G", 3);

		ArrayList<Coordinates> h = new ArrayList<>();
		h.add(new Coordinates(4, 3));
		mapS1S2.put("H", h);

		ArrayList<Coordinates> hEmpty = new ArrayList<>();
		hEmpty.add(new Coordinates(4, 3));
		ArrayList<Coordinates> hFilled = new ArrayList<>();
		emptyRegions.add(hEmpty);
		filledRegions.put("H", hFilled);
		regsSize.put("H", 1);

		// Run each solver
		System.out.print("Solver One: ");
		testSolverOne(boardNum, boardReg, mapS1S2);

		System.out.print("Solver Two: ");
		testSolverTwo(boardNum, boardReg, mapS1S2);

		System.out.print("Solver Three: ");
		testSolverThree(boardNum, boardReg, emptyRegions, filledRegions, regsSize);

		System.out.println("Solved Board: ");
		printBoard(boardNum, 5);
	}

	public static void testSolverOne(int[][] boardNum, String[][] boardReg, Map<String, ArrayList<Coordinates>> map) {
		SolverOne solver = new SolverOne();
		solver.size = 5;
		solver.maxNum = 5;
		int[][] boardNumCopy = deepCopy(boardNum);
		String[][] boardRegCopy = deepCopy(boardReg);
		Map<String, ArrayList<Coordinates>> mapCopy = deepCopyMapS1S2(map);

		long solverStartTime = System.currentTimeMillis();
		if (solver.solveBoard(boardNumCopy, mapCopy, boardRegCopy)) {
			int sum = 0;
			for (int row = 0; row < solver.size; row++) {
				int rowTotal = 1;
				for (int col = 0; col < solver.size; col++) {
					rowTotal *= boardNumCopy[row][col];
				}
				sum += rowTotal;
			}
			long solverEndTime = System.currentTimeMillis();
			long solverExecutionTime = solverEndTime - solverStartTime;
			System.out.println("Solved in " + solverExecutionTime + " milliseconds, " + sum);
		} else {
			System.out.println("Failed");
		}
	}

	public static void testSolverTwo(int[][] boardNum, String[][] boardReg, Map<String, ArrayList<Coordinates>> map) {
		SolverTwo solver = new SolverTwo();
		solver.size = 5;
		solver.maxNum = 5;
		int[][] boardNumCopy = deepCopy(boardNum);
		String[][] boardRegCopy = deepCopy(boardReg);
		Map<String, ArrayList<Coordinates>> mapCopy = deepCopyMapS1S2(map);

		long solverStartTime = System.currentTimeMillis();
		if (solver.solveBoard(boardNumCopy, mapCopy, boardRegCopy)) {
			int sum = 0;
			for (int row = 0; row < solver.size; row++) {
				int rowTotal = 1;
				for (int col = 0; col < solver.size; col++) {
					rowTotal *= boardNumCopy[row][col];
				}
				sum += rowTotal;
			}
			long solverEndTime = System.currentTimeMillis();
			long solverExecutionTime = solverEndTime - solverStartTime;
			System.out.println("Solved in " + solverExecutionTime + " milliseconds, " + sum);
		} else {
			System.out.println("Failed");
		}
	}

	public static void testSolverThree(int[][] boardNum, String[][] boardReg,
			ArrayList<ArrayList<Coordinates>> emptyRegions, Map<String, ArrayList<Coordinates>> filledMap,
			Map<String, Integer> regsSize) {
		SolverThree solver = new SolverThree();
		solver.size = 5;
		solver.maxNum = 5;
		int[][] boardNumCopy = boardNum;
		String[][] boardRegCopy = deepCopy(boardReg);

		long solverStartTime = System.currentTimeMillis();

		if (solver.solveBoard(boardNumCopy, emptyRegions, filledMap, boardRegCopy, regsSize)) {
			int sum = 0;
			for (int row = 0; row < solver.size; row++) {
				int rowTotal = 1;
				for (int col = 0; col < solver.size; col++) {
					rowTotal *= boardNumCopy[row][col];
				}
				sum += rowTotal;
			}
			long solverEndTime = System.currentTimeMillis();
			long solverExecutionTime = solverEndTime - solverStartTime;
			System.out.println("Solved in " + solverExecutionTime + " milliseconds, " + sum);
		} else {
			System.out.println("Failed");
		}
	}

	private static int[][] deepCopy(int[][] original) {
		int[][] copy = new int[original.length][];
		for (int i = 0; i < original.length; i++) {
			copy[i] = original[i].clone();
		}
		return copy;
	}

	private static String[][] deepCopy(String[][] original) {
		String[][] copy = new String[original.length][];
		for (int i = 0; i < original.length; i++) {
			copy[i] = original[i].clone();
		}
		return copy;
	}

	private static Map<String, ArrayList<Coordinates>> deepCopyMapS1S2(Map<String, ArrayList<Coordinates>> original) {
		Map<String, ArrayList<Coordinates>> copy = new HashMap<>();
		for (Map.Entry<String, ArrayList<Coordinates>> entry : original.entrySet()) {
			copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
		}
		return copy;
	}

	private static void printBoard(int[][] board, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}
}

