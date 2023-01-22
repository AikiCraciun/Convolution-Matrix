package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ApplyConvolutionMatrix {
	private ConvolutionAlgorithm convolution = new ConvolutionAlgorithm();
	
	
  //Image convolution process and output to a new file.
    public BufferedImage imageProcessOutput(int[][] filter, BufferedImage inputImage) throws IOException {
        int[][][] image = transImageToArray(inputImage);
        int[][] convFilter = filter;
        return applyConvolution(inputImage, inputImage.getWidth(),
        		inputImage.getHeight(), image, convFilter);
    }
    
    //Input image is transformed to a 3D Array
    private int[][][] transImageToArray(BufferedImage inputImage) {
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        int[][][] image = new int[3][height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = new Color(inputImage.getRGB(j, i));
                image[0][i][j] = color.getRed();
                image[1][i][j] = color.getGreen();
                image[2][i][j] = color.getBlue();
            }
        }
        return image;
    }
    
    /*Apply the Convolution alghorithm for each red, green and blue 2D arrays of the 
    transformed original image. 
    After each of the red, green and blue arrays have been convoluted, the pixel rgb int colours 
    are verified and those out of bounds [0-255] are normalized. 
    */
    private BufferedImage applyConvolution(BufferedImage inputImage, 
    							  int width, int height, int[][][] image, 
    							  int[][] filter) throws IOException {
        int[][] redConv = convolution.convolutionType2(image[0], height, width, filter, 3, 3, 1);
        int[][] greenConv = convolution.convolutionType2(image[1], height, width, filter, 3, 3, 1);
        int[][] blueConv = convolution.convolutionType2(image[2], height, width, filter, 3, 3, 1);
       
        BufferedImage tempImage = iterateOverOutRangeColors(inputImage, redConv, greenConv, blueConv);
        
        int[][][] tempConvRGB = transImageToArray(tempImage);
        int[][][] finalImageArray = new int[3][height][width];
        
        normalizeRGBColors(image, tempConvRGB, finalImageArray);
        
        int[][] redConvFinal = finalImageArray[0];
        int[][] greenConvFinal = finalImageArray[1];
        int[][] blueConvFinal = finalImageArray[2];
        
        BufferedImage writeBackImage = iterateOverOutRangeColors(inputImage, redConvFinal, greenConvFinal, blueConvFinal);
        return writeBackImage;
    }
    
    //The function restores the int values out of bounds [0-255] for rgb values.
    private int fixOutOfRangeRGBValues(int value) {
    	if (value < 0.0) {
    		return value = 255;
        }else if (value == 0){
        	return value = 255;
        }else if (value > 255) {
            return 255;
        }else {
            return value;
        }
    }
    
    //The function gives the output convoluted image the colors original image had.
    private void normalizeRGBColors(int[][][] image, int[][][] tempRGB, int[][][] finalImageArray) {
    	for (int i = 0; i < image.length; i++) {
        	if (i == 0) {
        		normalizeColor(image, tempRGB, finalImageArray, "red");
        	} else if (i == 1) {
        		normalizeColor(image, tempRGB, finalImageArray, "green");
        	}else if (i == 2) {
        		normalizeColor(image, tempRGB, finalImageArray, "blue");
        	}
        }
    }
    
    //Function to normalize colors for convoluted image.
    //Main scope of the function is to restore the initial colors the image had before applying convolution.
    private void normalizeColor(int[][][] image, int[][][] tempRGB, int[][][] finalImageArray, String color) {
    	int colorArray = 0;
    	if (color == "red") {
    		colorArray = 0;
    	}else if (color == "green") {
    		colorArray = 1;
    	}else {
    		colorArray = 2;
    	}
    	for (int j = 0; j < image[colorArray].length; j++) {
			for (int y = 0; y < image[colorArray][j].length; y++) {
				if (image[colorArray][j][y] > tempRGB[colorArray][j][y]) {
					finalImageArray[0][j][y] = image[0][j][y];
					finalImageArray[1][j][y] = image[1][j][y];
					finalImageArray[2][j][y] = image[2][j][y];
				} else {
					finalImageArray[colorArray][j][y] = tempRGB[colorArray][j][y];
				}
			}
		}
    }
    
    //Function to iterate over each pizel and fix the out of range [0-255] color values.
    private BufferedImage iterateOverOutRangeColors(BufferedImage inputImage, int[][] red, int[][] green, int[][] blue) {
    	BufferedImage image = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < red.length; i++) {
            for (int j = 0; j < red[i].length; j++) {
            	//Normalization of the out of bounds [0-255] int colors is happening here.
            	Color color = new Color(fixOutOfRangeRGBValues(red[i][j]),
            							fixOutOfRangeRGBValues(green[i][j]),
            							fixOutOfRangeRGBValues(blue[i][j]));   
                image.setRGB(j, i, color.getRGB());
            }
        }
        return image;
    }
 }
