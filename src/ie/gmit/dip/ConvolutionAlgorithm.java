package ie.gmit.dip;

public class ConvolutionAlgorithm {

		//Function to apply the convolution matrix over each pixel of the original image.
		private static int singlePixelConvolution(int[][] input, int x, int y, int[][] k, int kernelWidth,
				int kernelHeight) {
			int output = 0;
			for (int i = 0; i < kernelWidth; ++i) {
				for (int j = 0; j < kernelHeight; ++j) {
					output = output + (input[x + i][y + j] * k[i][j]);
				}
			}
			return output;
		}

		
		//Function to iterate over all pixels of the original image and apply convolution matrix.
		private static int[][] convolution2D(int[][] input, int width, int height, int[][] kernel, int kernelWidth,
	        int kernelHeight) {
			
			int smallWidth = width - kernelWidth + 1;
			int smallHeight = height - kernelHeight + 1;
			int[][] output = new int[smallWidth][smallHeight];
			for (int i = 0; i < smallWidth; ++i) {
				for (int j = 0; j < smallHeight; ++j) {
					output[i][j] = 0;
				}
			}
			for (int i = 0; i < smallWidth; ++i) {
				for (int j = 0; j < smallHeight; ++j) {
					output[i][j] = singlePixelConvolution(input, i, j, kernel,
					kernelWidth, kernelHeight);
				}
			}
			return output;
			}
		
		//Function to fix the convolution process by ignoring the border pixels around the image.
		private static int[][] convolution2DPadded(int[][] input,
	            int width, int height,
	            int[][] kernel,
	            int kernelWidth,
	            int kernelHeight) {
			
			int smallWidth = width - kernelWidth + 1;
			int smallHeight = height - kernelHeight + 1;
			int top = kernelHeight / 2;
			int left = kernelWidth / 2;
			
			int[][] small = convolution2D(input, width, height, kernel, kernelWidth, kernelHeight);
			int large[][] = new int[width][height];
			for (int j = 0; j < height; ++j) {
				for (int i = 0; i < width; ++i) {
					large[i][j] = 0;
				}
			}
			for (int j = 0; j < smallHeight; ++j) {
				for (int i = 0; i < smallWidth; ++i) {
					large[i + left][j + top] = small[i][j];
				}
			}
			return large;
			}
		
		
		public int[][] convolutionType2(int[][] input,
	            int width, int height,
	            int[][] kernel,
	            int kernelWidth, int kernelHeight,
	            int iterations) {
			
			int[][] newInput = input.clone();
			int[][] output = input.clone();
			
			for (int i = 0; i < iterations; ++i) {
				output = convolution2DPadded(newInput, width, height, kernel, kernelWidth, kernelHeight);
				newInput = output.clone();
			}
			return output;
			}

	}

