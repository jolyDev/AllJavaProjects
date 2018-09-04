package common;

/**
 * Class represents geometric figure such as rectangle or triangle. Contains
 * coordinates of figure and methods to calculate area and perimeter
 */
public class GeomFigure {
	// Class created to contain points
	public class dot {
		public int x;
		public int y;
		dot(int i ,int j) {
			this.x = i;
			this.y = j;
		}
	};

	private final double A = (Math.sqrt(5) - 1) / 2;
	final int prime = 31;
	// Trapeze fields 
	public dot[] p;
	private double perimeter;
	public double area ;
	private int hash;

	public GeomFigure() {
		
	}
	
	public GeomFigure(String[] line) {
		if (line.length == 8) {
			this.p = new dot[4];
			for (int i = 0; i < 4; i++) {
				this.p[i] = new dot(0,0);
				this.p[i].x = Integer.valueOf(line[2*i]);
				this.p[i].y = Integer.valueOf(line[2*i + 1]);
			}
			this.perimeter = (int) perimeter(this);
			this.area = area(this);
			this.hash = hashCode();
		}
	}

	/**
	 * Returns the hash code value for this geometric figure. The hash code of a
	 * figure is defined to be the sum of the hash codes of the elements in the
	 * figure, where the hash code of a null element is defined to be zero.
	 * 
	 * @return the hash code value for this object
	 */

	@Override
	public int hashCode() {
		if (hash == 0 && this.p != null) {
			hash = 1;
			for (int i = 0; i < 4; i++)
				hash += A * this.p[i].x + prime*(this.p[i].y + i);
			hash *= hash;
		}
		return hash;
	}

	/**
	 * Indicates whether some other GeomFigure object is "equal to" this one.
	 * 
	 * @param obj
	 *            - the reference GeomFigure object with which to compare.
	 * @return true if this GeomFigure object is the same as the obj argument; false
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null ||  this.getClass() != obj.getClass())
			return false;
		if (this == obj)
			return true;
		GeomFigure other = (GeomFigure) obj;
		for (int i = 0; i < 4; i++)
//			if (this.hashCode() != obj.hashCode())
			if (!(this.p[i].x == other.p[i].x && this.p[i].y == other.p[i].y))
				return false; // no need to compare hash, perimeter and area
		return true;
	}

	/**
	 * Returns a string representation of the GeomFigure that "textually represents"
	 * this object.
	 */
	@Override
	public String toString() {
		return String.format("(%d,%d) (%d,%d) (%d,%d) (%d,%d) | P = %-8f | S = %-8f | hash = %d",
				this.p[0].x, this.p[0].y,
				this.p[1].x, this.p[1].y,
				this.p[2].x, this.p[2].y,
				this.p[3].x, this.p[3].y, 
				this.perimeter, this.area, hash);
	}
	
	static public double perimeter(GeomFigure gf) {
		for (int i = 0; i < 4; i++) {
			gf.perimeter = gf.perimeter + line_segment(gf.p[i % 4], gf.p[(i + 1) % 4]);
		}
		return gf.perimeter;
	}
	
	static public double line_segment(dot p_1, dot p_2) {
		return Math.pow((Math.pow(p_2.x - p_1.x, 2) + Math.pow(p_2.y - p_1.y, 2)), 0.5);
	}
	
	static  public double area(GeomFigure gf) {
		// h = |vp x bv| / |bv|
		 int vpx = gf.p[2].x - gf.p[0].x;
		 int vpy = gf.p[2].y - gf.p[0].y; // vector from the point
		 int bvx = gf.p[3].x - gf.p[2].x;
		 int bvy = gf.p[3].y - gf.p[2].y; // base_vector
		  
//		 x	 y	z
//	  vp 1	-1	0
//	  bv-1	-1	0
//		   
		 //  i ((-1)·0 - 0·(-1)) - j (1·0 - 0·(-1)) + k (1·(-1) - (-1)·(-1))
		double s_len = Math.sqrt(Math.pow(bvx, 2) + Math.pow(bvy,2));
		double h = 0;
		if (s_len != 0)
			h = Math.abs(vpx * bvy - bvx * vpy) / s_len;
		return h * (line_segment(gf.p[0], gf.p[1]) +
				line_segment(gf.p[2], gf.p[3])) / 2.0;
	}

public void printTrap() {
	for (int i = 0; i < 10; i++) {
		System.out.println(" ");
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 4; k++) {
				if (Math.abs(this.p[k].x) == j && Math.abs(this.p[k].y) == i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
		}
	}
}
}
