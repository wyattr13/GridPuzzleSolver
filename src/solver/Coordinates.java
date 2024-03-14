package solver;

public class Coordinates implements Cloneable, Comparable<Coordinates> {
	public int row;
	public int col;

	public Coordinates(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public Coordinates clone() {
		try {
			return (Coordinates) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e);
		}
	}

	@Override
	public int compareTo(Coordinates other) {
		int rowComparison = Integer.compare(this.row, other.row);
		if (rowComparison == 0) {
			return Integer.compare(this.col, other.col);
		}
		return rowComparison;
	}
}
