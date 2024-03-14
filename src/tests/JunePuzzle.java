package tests;
import java.util.*;
import solver.Coordinates;
import solver.SolverOne;
import solver.SolverTwo;
import solver.SolverThree;
 

public class JunePuzzle {
	
	public static void main(String[] args) {
		//Creating all of the data structures
		int[][] boardNum = {
				{0, 3, 0, 0, 0, 7, 0, 0, 0, 0} ,
				{0, 0, 0, 4, 0, 0, 0, 0, 0, 0} ,
				{0, 0, 0, 0, 0, 0, 0, 0, 2, 0} ,
				{0, 0, 0, 1, 0, 0, 0, 0, 0, 0} ,
				{6, 0, 1, 0, 0, 0, 0, 0, 0, 0} ,
				{0, 0, 0, 0, 0, 0, 0, 3, 0, 6} ,
				{0, 0, 0, 0, 0, 0, 2, 0, 0, 0} ,
				{0, 2, 0, 0, 0, 0, 0, 0, 0, 0} ,
				{0, 0, 0, 0, 0, 0, 6, 0, 0, 0} ,
				{0, 0, 0, 0, 5, 0, 0, 0, 2, 0}
		};
			
		String[][] boardReg = {
				{"A", "B", "B", "B", "C", "C", "C", "C", "C", "C"} ,
				{"A", "A", "B", "B", "B", "C", "D", "D", "C", "C"} ,
				{"A", "A", "E", "E", "F", "F", "G", "D", "H", "H"} ,
				{"A", "A", "I", "E", "J", "G", "G", "G", "H", "H"} ,
				{"A", "I", "I", "J", "J", "K", "L", "G", "G", "H"} ,
				{"A", "M", "I", "N", "O", "K", "P", "P", "H", "H"} ,
				{"A", "Q", "R", "N", "N", "N", "P", "S", "S", "S"} ,
				{"Q", "Q", "R", "T", "N", "U", "V", "W", "W", "V"} ,
				{"Q", "Q", "Q", "T", "T", "V", "V", "W", "W", "V"} ,
				{"Q", "Q", "Q", "Q", "T", "T", "V", "V", "V", "V"} ,
		};
		
		Map<String, ArrayList<Coordinates>> mapS1S2 = new HashMap<>();

		ArrayList<ArrayList<Coordinates>> emptyRegions = new ArrayList<>();
		Map<String, ArrayList<Coordinates>> filledRegions = new HashMap<>();
		Map<String, Integer> regsSize = new HashMap<>();

		ArrayList<Coordinates> a = new ArrayList<>();
		a.add(new Coordinates(0, 0));
		a.add(new Coordinates(1, 0));
		a.add(new Coordinates(1, 1));
		a.add(new Coordinates(2, 0));
		a.add(new Coordinates(2, 1));
		a.add(new Coordinates(3, 0));
		a.add(new Coordinates(3, 1));
		a.add(new Coordinates(4, 0));
		a.add(new Coordinates(5, 0));
		a.add(new Coordinates(6, 0));
		mapS1S2.put("A", a);

		ArrayList<Coordinates> aEmpty = new ArrayList<>();
		aEmpty.add(new Coordinates(0, 0));
		aEmpty.add(new Coordinates(1, 0));
		aEmpty.add(new Coordinates(1, 1));
		aEmpty.add(new Coordinates(2, 0));
		aEmpty.add(new Coordinates(2, 1));
		aEmpty.add(new Coordinates(3, 0));
		aEmpty.add(new Coordinates(3, 1));
		aEmpty.add(new Coordinates(5, 0));
		aEmpty.add(new Coordinates(6, 0));
		ArrayList<Coordinates> aFilled = new ArrayList<>();
		aFilled.add(new Coordinates(4, 0));
		emptyRegions.add(aEmpty);
		filledRegions.put("A", aFilled);
		regsSize.put("A", 10);

		ArrayList<Coordinates> b = new ArrayList<>();
		b.add(new Coordinates(0, 1));
		b.add(new Coordinates(0, 2));
		b.add(new Coordinates(0, 3));
		b.add(new Coordinates(1, 2));
		b.add(new Coordinates(1, 3));
		b.add(new Coordinates(1, 4));
		mapS1S2.put("B", b);

		ArrayList<Coordinates> bEmpty = new ArrayList<>();
		bEmpty.add(new Coordinates(0, 2));
		bEmpty.add(new Coordinates(0, 3));
		bEmpty.add(new Coordinates(1, 2));
		bEmpty.add(new Coordinates(1, 4));
		ArrayList<Coordinates> bFilled = new ArrayList<>();
		bFilled.add(new Coordinates(0, 1));
		bFilled.add(new Coordinates(1, 3));
		emptyRegions.add(bEmpty);
		filledRegions.put("B", bFilled);
		regsSize.put("B", 6);

		ArrayList<Coordinates> c = new ArrayList<>();
		c.add(new Coordinates(0, 4));
		c.add(new Coordinates(0, 5));
		c.add(new Coordinates(0, 6));
		c.add(new Coordinates(0, 7));
		c.add(new Coordinates(0, 8));
		c.add(new Coordinates(0, 9));
		c.add(new Coordinates(1, 5));
		c.add(new Coordinates(1, 8));
		c.add(new Coordinates(1, 9));
		mapS1S2.put("C", c);

		ArrayList<Coordinates> cEmpty = new ArrayList<>();
		cEmpty.add(new Coordinates(0, 4));
		cEmpty.add(new Coordinates(0, 6));
		cEmpty.add(new Coordinates(0, 7));
		cEmpty.add(new Coordinates(0, 8));
		cEmpty.add(new Coordinates(0, 9));
		cEmpty.add(new Coordinates(1, 5));
		cEmpty.add(new Coordinates(1, 8));
		cEmpty.add(new Coordinates(1, 9));
		ArrayList<Coordinates> cFilled = new ArrayList<>();
		cFilled.add(new Coordinates(0, 5));
		emptyRegions.add(cEmpty);
		filledRegions.put("C", cFilled);
		regsSize.put("C", 9);

		ArrayList<Coordinates> d = new ArrayList<>();
		d.add(new Coordinates(1, 6));
		d.add(new Coordinates(1, 7));
		d.add(new Coordinates(2, 7));
		mapS1S2.put("D", d);

		ArrayList<Coordinates> dEmpty = new ArrayList<>();
		dEmpty.add(new Coordinates(1, 6));
		dEmpty.add(new Coordinates(1, 7));
		dEmpty.add(new Coordinates(2, 7));
		ArrayList<Coordinates> dFilled = new ArrayList<>();
		emptyRegions.add(dEmpty);
		filledRegions.put("D", dFilled);
		regsSize.put("D", 3);

		ArrayList<Coordinates> e = new ArrayList<>();
		e.add(new Coordinates(2, 2));
		e.add(new Coordinates(2, 3));
		e.add(new Coordinates(3, 3));
		mapS1S2.put("E", e);

		ArrayList<Coordinates> eEmpty = new ArrayList<>();
		eEmpty.add(new Coordinates(2, 2));
		eEmpty.add(new Coordinates(2, 3));
		ArrayList<Coordinates> eFilled = new ArrayList<>();
		eFilled.add(new Coordinates(3, 3));
		emptyRegions.add(eEmpty);
		filledRegions.put("E", eFilled);
		regsSize.put("E", 3);

		ArrayList<Coordinates> f = new ArrayList<>();
		f.add(new Coordinates(2, 4));
		f.add(new Coordinates(2, 5));
		mapS1S2.put("F", f);

		ArrayList<Coordinates> fEmpty = new ArrayList<>();
		fEmpty.add(new Coordinates(2, 4));
		fEmpty.add(new Coordinates(2, 5));
		ArrayList<Coordinates> fFilled = new ArrayList<>();
		emptyRegions.add(fEmpty);
		filledRegions.put("F", fFilled);
		regsSize.put("F", 2);

		ArrayList<Coordinates> g = new ArrayList<>();
		g.add(new Coordinates(2, 6));
		g.add(new Coordinates(3, 5));
		g.add(new Coordinates(3, 6));
		g.add(new Coordinates(3, 7));
		g.add(new Coordinates(4, 7));
		g.add(new Coordinates(4, 8));
		mapS1S2.put("G", g);

		ArrayList<Coordinates> gEmpty = new ArrayList<>();
		gEmpty.add(new Coordinates(2, 6));
		gEmpty.add(new Coordinates(3, 5));
		gEmpty.add(new Coordinates(3, 6));
		gEmpty.add(new Coordinates(3, 7));
		gEmpty.add(new Coordinates(4, 7));
		gEmpty.add(new Coordinates(4, 8));
		ArrayList<Coordinates> gFilled = new ArrayList<>();
		emptyRegions.add(gEmpty);
		filledRegions.put("G", gFilled);
		regsSize.put("G", 6);

		ArrayList<Coordinates> h = new ArrayList<>();
		h.add(new Coordinates(2, 8));
		h.add(new Coordinates(2, 9));
		h.add(new Coordinates(3, 8));
		h.add(new Coordinates(3, 9));
		h.add(new Coordinates(4, 9));
		h.add(new Coordinates(5, 8));
		h.add(new Coordinates(5, 9));
		mapS1S2.put("H", h);

		ArrayList<Coordinates> hEmpty = new ArrayList<>();
		hEmpty.add(new Coordinates(2, 9));
		hEmpty.add(new Coordinates(3, 8));
		hEmpty.add(new Coordinates(3, 9));
		hEmpty.add(new Coordinates(4, 9));
		hEmpty.add(new Coordinates(5, 8));
		ArrayList<Coordinates> hFilled = new ArrayList<>();
		hFilled.add(new Coordinates(2, 8));
		hFilled.add(new Coordinates(5, 9));
		emptyRegions.add(hEmpty);
		filledRegions.put("H", hFilled);
		regsSize.put("H", 7);

		ArrayList<Coordinates> i = new ArrayList<>();
		i.add(new Coordinates(3, 2));
		i.add(new Coordinates(4, 1));
		i.add(new Coordinates(4, 2));
		i.add(new Coordinates(5, 2));
		mapS1S2.put("I", i);

		ArrayList<Coordinates> iEmpty = new ArrayList<>();
		iEmpty.add(new Coordinates(3, 2));
		iEmpty.add(new Coordinates(4, 1));
		iEmpty.add(new Coordinates(5, 2));
		ArrayList<Coordinates> iFilled = new ArrayList<>();
		iFilled.add(new Coordinates(4, 2));
		emptyRegions.add(iEmpty);
		filledRegions.put("I", iFilled);
		regsSize.put("I", 4);

		ArrayList<Coordinates> j = new ArrayList<>();
		j.add(new Coordinates(3, 4));
		j.add(new Coordinates(4, 3));
		j.add(new Coordinates(4, 4));
		mapS1S2.put("J", j);

		ArrayList<Coordinates> jEmpty = new ArrayList<>();
		jEmpty.add(new Coordinates(3, 4));
		jEmpty.add(new Coordinates(4, 3));
		jEmpty.add(new Coordinates(4, 4));
		ArrayList<Coordinates> jFilled = new ArrayList<>();
		emptyRegions.add(jEmpty);
		filledRegions.put("J", jFilled);
		regsSize.put("J", 3);

		ArrayList<Coordinates> k = new ArrayList<>();
		k.add(new Coordinates(4, 5));
		k.add(new Coordinates(5, 5));
		mapS1S2.put("K", k);

		ArrayList<Coordinates> kEmpty = new ArrayList<>();
		kEmpty.add(new Coordinates(4, 5));
		kEmpty.add(new Coordinates(5, 5));
		ArrayList<Coordinates> kFilled = new ArrayList<>();
		emptyRegions.add(kEmpty);
		filledRegions.put("K", kFilled);
		regsSize.put("K", 2);

		ArrayList<Coordinates> l = new ArrayList<>();
		l.add(new Coordinates(4, 6));
		mapS1S2.put("L", l);

		ArrayList<Coordinates> lEmpty = new ArrayList<>();
		lEmpty.add(new Coordinates(4, 6));
		ArrayList<Coordinates> lFilled = new ArrayList<>();
		emptyRegions.add(lEmpty);
		filledRegions.put("L", lFilled);
		regsSize.put("L", 1);

		ArrayList<Coordinates> m = new ArrayList<>();
		m.add(new Coordinates(5, 1));
		mapS1S2.put("M", m);

		ArrayList<Coordinates> mEmpty = new ArrayList<>();
		mEmpty.add(new Coordinates(5, 1));
		ArrayList<Coordinates> mFilled = new ArrayList<>();
		emptyRegions.add(mEmpty);
		filledRegions.put("M", mFilled);
		regsSize.put("M", 1);

		ArrayList<Coordinates> n = new ArrayList<>();
		n.add(new Coordinates(5, 3));
		n.add(new Coordinates(6, 3));
		n.add(new Coordinates(6, 4));
		n.add(new Coordinates(6, 5));
		n.add(new Coordinates(7, 4));
		mapS1S2.put("N", n);

		ArrayList<Coordinates> nEmpty = new ArrayList<>();
		nEmpty.add(new Coordinates(5, 3));
		nEmpty.add(new Coordinates(6, 3));
		nEmpty.add(new Coordinates(6, 4));
		nEmpty.add(new Coordinates(6, 5));
		nEmpty.add(new Coordinates(7, 4));
		ArrayList<Coordinates> nFilled = new ArrayList<>();
		emptyRegions.add(nEmpty);
		filledRegions.put("N", nFilled);
		regsSize.put("N", 5);

		ArrayList<Coordinates> o = new ArrayList<>();
		o.add(new Coordinates(5, 4));
		mapS1S2.put("O", o);

		ArrayList<Coordinates> oEmpty = new ArrayList<>();
		oEmpty.add(new Coordinates(5, 4));
		ArrayList<Coordinates> oFilled = new ArrayList<>();
		emptyRegions.add(oEmpty);
		filledRegions.put("O", oFilled);
		regsSize.put("O", 1);

		ArrayList<Coordinates> p = new ArrayList<>();
		p.add(new Coordinates(5, 6));
		p.add(new Coordinates(5, 7));
		p.add(new Coordinates(6, 6));
		mapS1S2.put("P", p);

		ArrayList<Coordinates> pEmpty = new ArrayList<>();
		pEmpty.add(new Coordinates(5, 6));
		ArrayList<Coordinates> pFilled = new ArrayList<>();
		pFilled.add(new Coordinates(5, 7));
		pFilled.add(new Coordinates(6, 6));
		emptyRegions.add(pEmpty);
		filledRegions.put("P", pFilled);
		regsSize.put("P", 3);

		ArrayList<Coordinates> q = new ArrayList<>();
		q.add(new Coordinates(6, 1));
		q.add(new Coordinates(7, 0));
		q.add(new Coordinates(7, 1));
		q.add(new Coordinates(8, 0));
		q.add(new Coordinates(8, 1));
		q.add(new Coordinates(8, 2));
		q.add(new Coordinates(9, 0));
		q.add(new Coordinates(9, 1));
		q.add(new Coordinates(9, 2));
		q.add(new Coordinates(9, 3));
		mapS1S2.put("Q", q);

		ArrayList<Coordinates> qEmpty = new ArrayList<>();
		qEmpty.add(new Coordinates(6, 1));
		qEmpty.add(new Coordinates(7, 0));
		qEmpty.add(new Coordinates(8, 0));
		qEmpty.add(new Coordinates(8, 1));
		qEmpty.add(new Coordinates(8, 2));
		qEmpty.add(new Coordinates(9, 0));
		qEmpty.add(new Coordinates(9, 1));
		qEmpty.add(new Coordinates(9, 2));
		qEmpty.add(new Coordinates(9, 3));
		ArrayList<Coordinates> qFilled = new ArrayList<>();
		qFilled.add(new Coordinates(7, 1));
		emptyRegions.add(qEmpty);
		filledRegions.put("Q", qFilled);
		regsSize.put("Q", 10);

		ArrayList<Coordinates> r = new ArrayList<>();
		r.add(new Coordinates(6, 2));
		r.add(new Coordinates(7, 2));
		mapS1S2.put("R", r);

		ArrayList<Coordinates> rEmpty = new ArrayList<>();
		rEmpty.add(new Coordinates(6, 2));
		rEmpty.add(new Coordinates(7, 2));
		ArrayList<Coordinates> rFilled = new ArrayList<>();
		emptyRegions.add(rEmpty);
		filledRegions.put("R", rFilled);
		regsSize.put("R", 2);

		ArrayList<Coordinates> s = new ArrayList<>();
		s.add(new Coordinates(6, 7));
		s.add(new Coordinates(6, 8));
		s.add(new Coordinates(6, 9));
		mapS1S2.put("S", s);

		ArrayList<Coordinates> sEmpty = new ArrayList<>();
		sEmpty.add(new Coordinates(6, 7));
		sEmpty.add(new Coordinates(6, 8));
		sEmpty.add(new Coordinates(6, 9));
		ArrayList<Coordinates> sFilled = new ArrayList<>();
		emptyRegions.add(sEmpty);
		filledRegions.put("S", sFilled);
		regsSize.put("S", 3);

		ArrayList<Coordinates> t = new ArrayList<>();
		t.add(new Coordinates(7, 3));
		t.add(new Coordinates(8, 3));
		t.add(new Coordinates(8, 4));
		t.add(new Coordinates(9, 4));
		t.add(new Coordinates(9, 5));
		mapS1S2.put("T", t);

		ArrayList<Coordinates> tEmpty = new ArrayList<>();
		tEmpty.add(new Coordinates(7, 3));
		tEmpty.add(new Coordinates(8, 3));
		tEmpty.add(new Coordinates(8, 4));
		tEmpty.add(new Coordinates(9, 5));
		ArrayList<Coordinates> tFilled = new ArrayList<>();
		tFilled.add(new Coordinates(9, 4));
		emptyRegions.add(tEmpty);
		filledRegions.put("T", tFilled);
		regsSize.put("T", 5);

		ArrayList<Coordinates> u = new ArrayList<>();
		u.add(new Coordinates(7, 5));
		mapS1S2.put("U", u);

		ArrayList<Coordinates> uEmpty = new ArrayList<>();
		uEmpty.add(new Coordinates(7, 5));
		ArrayList<Coordinates> uFilled = new ArrayList<>();
		emptyRegions.add(uEmpty);
		filledRegions.put("U", uFilled);
		regsSize.put("U", 1);

		ArrayList<Coordinates> v = new ArrayList<>();
		v.add(new Coordinates(7, 6));
		v.add(new Coordinates(7, 9));
		v.add(new Coordinates(8, 5));
		v.add(new Coordinates(8, 6));
		v.add(new Coordinates(8, 9));
		v.add(new Coordinates(9, 6));
		v.add(new Coordinates(9, 7));
		v.add(new Coordinates(9, 8));
		v.add(new Coordinates(9, 9));
		mapS1S2.put("V", v);

		ArrayList<Coordinates> vEmpty = new ArrayList<>();
		vEmpty.add(new Coordinates(7, 6));
		vEmpty.add(new Coordinates(7, 9));
		vEmpty.add(new Coordinates(8, 5));
		vEmpty.add(new Coordinates(8, 9));
		vEmpty.add(new Coordinates(9, 6));
		vEmpty.add(new Coordinates(9, 7));
		vEmpty.add(new Coordinates(9, 9));
		ArrayList<Coordinates> vFilled = new ArrayList<>();
		vFilled.add(new Coordinates(8, 6));
		vFilled.add(new Coordinates(9, 8));
		emptyRegions.add(vEmpty);
		filledRegions.put("V", vFilled);
		regsSize.put("V", 9);

		ArrayList<Coordinates> w = new ArrayList<>();
		w.add(new Coordinates(7, 7));
		w.add(new Coordinates(7, 8));
		w.add(new Coordinates(8, 7));
		w.add(new Coordinates(8, 8));
		mapS1S2.put("W", w);

		ArrayList<Coordinates> wEmpty = new ArrayList<>();
		wEmpty.add(new Coordinates(7, 7));
		wEmpty.add(new Coordinates(7, 8));
		wEmpty.add(new Coordinates(8, 7));
		wEmpty.add(new Coordinates(8, 8));
		ArrayList<Coordinates> wFilled = new ArrayList<>();
		emptyRegions.add(wEmpty);
		filledRegions.put("W", wFilled);
		regsSize.put("W", 4);

		// Run each solver
		System.out.print("Solver One: ");
		testSolverOne(boardNum, boardReg, mapS1S2);

		System.out.print("Solver Two: ");
		testSolverTwo(boardNum, boardReg, mapS1S2);

		System.out.print("Solver Three: ");
		testSolverThree(boardNum, boardReg, emptyRegions, filledRegions, regsSize);

		System.out.println("Solved Board: ");
		printBoard(boardNum, 10);
	}

	public static void testSolverOne(int[][] boardNum, String[][] boardReg, Map<String, ArrayList<Coordinates>> map) {
		SolverOne solver = new SolverOne();
		solver.size = 10;
		solver.maxNum = 10;
		int[][] boardNumCopy = deepCopy(boardNum);
		String[][] boardRegCopy = deepCopy(boardReg);
		Map<String, ArrayList<Coordinates>> mapCopy = deepCopyMap(map);

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
		solver.size = 10;
		solver.maxNum = 10;
		int[][] boardNumCopy = deepCopy(boardNum);
		String[][] boardRegCopy = deepCopy(boardReg);
		Map<String, ArrayList<Coordinates>> mapCopy = deepCopyMap(map);

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
		solver.size = 10;
		solver.maxNum = 10;
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

	private static Map<String, ArrayList<Coordinates>> deepCopyMap(Map<String, ArrayList<Coordinates>> original) {
		Map<String, ArrayList<Coordinates>> copy = new HashMap<>();
		for (Map.Entry<String, ArrayList<Coordinates>> entry : original.entrySet()) {
			copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
		}
		return copy;
	}

	private static void printBoard(int[][] board, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print((board[row][col] != 10 ? board[row][col] : "T") + " ");
			}
			System.out.println();
		}
	}
}

