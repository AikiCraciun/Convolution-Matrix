package ie.gmit.dip;

//Class for storing all the available convolution filters program can apply.
public class Kernel {
	public final int[][] IDENTITY = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
	public final int[][] EDGE_DETECTION1 = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
	public final int[][] EDGE_DETECTION2 = {{1, 0, -1}, {0, 0, 0}, {-1, 0, 1}};
	public final int[][] LAPLACIAN = {{0, -1, 0}, {-1, 4, -1}, {0, -1, 0}};
	public final int[][] SHARPEN = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
	public final int[][] VERTICAL_LINES = {{-1, 2, -1}, {-1, 2, -1}, {-1, 2, -1}};
	public final int[][] HORIZONTAL_LINES = {{-1, -1, -1}, {2, 2, 2}, {-1, -1, -1}};
	public final int[][] DIAGONAL_45_LINES = {{-1, -1, 2}, {-1, 2, -1}, {2, -1, -1}};
	public final int[][] SOBEL_HORIZONTAL = {{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};
	public final int[][] SOBEL_VERTICAL = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
	public final double[][] BOX_BLUR = {{0.111, 0.111, 0.111}, {0.111, 0.111, 0.111}, {0.111, 0.111, 0.111}};
}
