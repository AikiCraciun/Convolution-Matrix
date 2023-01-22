package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Menu {
	private Scanner s;
	//Variable to control the running of the application.
	private boolean keepRunning = true;
	private ApplyConvolutionMatrix applyConvolutionMatrix = new ApplyConvolutionMatrix();
	private Kernel kernel = new Kernel();
	
	public Menu() {
		s = new Scanner(System.in);
	}
	
	//start() function which is called in the Runner main function.
 	public void start() throws IOException {
		String inputImageName = null;
		int filterChoice = 0;

		//Buffered Image instance.
		BufferedImage bufferedImage = null;
		
		//While loop which is controling the display of the application menu.
		while(keepRunning) {
			showOptions();
			int choice = Integer.parseInt(s.next()); //Blocking statement;
					
			if (choice == 1) {
				System.out.println("\nEnter image name (i.e bridge-rgb) >");
				inputImageName = s.next();
				bufferedImage = ImageIO.read(new File("./" + inputImageName + ".png"));
				System.out.println("\nImage chosen is " + inputImageName + "\n");
			}else if (choice == 2) {
				showFilters();
				
				//User input of Convolution Filter chosen below:
				filterChoice = Integer.parseInt(s.next());
				System.out.println("\nKernel chosen is " + filterChoice + "\n");
				 
				BufferedImage writeBackImage = applyChosenFilter(filterChoice, bufferedImage);
				
				String chosenKernel = mapFilterChoiceToKernel(filterChoice);
				File outputFile = new File("./" + inputImageName + "[" + chosenKernel +"].png");
		        ImageIO.write(writeBackImage, "png", outputFile);
		        //return outputFile;
				
				keepRunning = false;
				System.out.println("Program runned fine!!");
				
			}else if (choice == 3) {
				System.out.println("\n[INFO] Shuting down...please wait...\n");
				keepRunning = false;
			}else {
				System.out.println("\n[ERROR] Invalid input.\n");
			}
		}
	}
	
	
	
	//Function for showing the user menu options.
	private void showOptions() {
		System.out.println("#################################");
		System.out.println("#     Image Filtering System    #");
		System.out.println("#################################");
		System.out.println("(1) Enter Image Name");
		System.out.println("(2) Select a Filter");
		System.out.println("(3) Quit");
		System.out.println("Select an option [1-3]");
	}
	
	//Function for showing the available convolution filters.
	private void showFilters() {
		System.out.println("#################################");
		System.out.println("#  Select a Convolution Kernel  #");
		System.out.println("#################################");
		System.out.println("(1)  IDENTITY");
		System.out.println("(2)  EDGE_DETECTION1");
		System.out.println("(3)  EDGE_DETECTION2");
		System.out.println("(4)  LAPLACIAN");
		System.out.println("(5)  SHARPEN");
		System.out.println("(6)  VERTICAL_LINES");
		System.out.println("(7)  HORIZONTAL_LINES");
		System.out.println("(8)  DIAGONAL_45_LINES");
		System.out.println("(9)  SOBEL_HORIZONTAL");
		System.out.println("(10) SOBEL_VERTICAL");
		System.out.println("(11) BOX_BLUR");
		System.out.println("Select an option [1-11]");
	}
	
	//Function to call the convolution processing based on the filter user has chosen.
	private BufferedImage applyChosenFilter(int filterChoice, BufferedImage bufferedImage) throws IOException {
		BufferedImage outputBufferedImage = null;
		if (filterChoice == 1) {
			outputBufferedImage = applyConvolutionMatrix.imageProcessOutput(kernel.IDENTITY, bufferedImage);
		} else if (filterChoice == 2) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.EDGE_DETECTION1, bufferedImage);
		}else if (filterChoice == 3) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.EDGE_DETECTION2, bufferedImage);
		}else if (filterChoice == 4) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.LAPLACIAN, bufferedImage);
		}else if (filterChoice == 5) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.SHARPEN, bufferedImage);
		}else if (filterChoice == 6) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.VERTICAL_LINES, bufferedImage);
		}else if (filterChoice == 7) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.HORIZONTAL_LINES, bufferedImage);
		}else if (filterChoice == 8) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.DIAGONAL_45_LINES, bufferedImage);
		}else if (filterChoice == 9) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.SOBEL_HORIZONTAL, bufferedImage);
		}else if (filterChoice == 10) {
			outputBufferedImage =  applyConvolutionMatrix.imageProcessOutput(kernel.SOBEL_VERTICAL, bufferedImage);
		}else if (filterChoice == 11) {
			//outputBufferedImge =  applyConvolutionMatrix.imageProcessOutput(filter.BOX_BLUR, bufferedImage);
		}else {
			throw new IllegalStateException("applyChosenFilter() Invalid filter: " + filterChoice);
		}
		return outputBufferedImage;
	}
	
	//Function to map the [1-11] option user has chosen to the Filter name.
	private String mapFilterChoiceToKernel(int filterChoice) {
		String outputKernel = null;
		if (filterChoice == 1) {
			outputKernel = "IDENTITY";
		}else if (filterChoice == 2) {
			outputKernel = "EDGE_DETECTION1";;
		}else if (filterChoice == 3) {
			outputKernel = "EDGE_DETECTION2";
		}else if (filterChoice == 4) {
			outputKernel = "LAPLACIAN";
		}else if (filterChoice == 5) {
			outputKernel = "SHARPEN";
		}else if (filterChoice == 6) {
			outputKernel = "VERTICAL_LINES";
		}else if (filterChoice == 7) {
			outputKernel = "HORIZONTAL_LINES";
		}else if (filterChoice == 8) {
			outputKernel = "DIAGONAL_45_LINES";
		}else if (filterChoice == 9) {
			outputKernel = "SOBEL_HORIZONTAL";
		}else if (filterChoice == 10) {
			outputKernel = "SOBEL_VERTICAL";
		}else if (filterChoice == 11) {
			outputKernel = "BOX_BLUR";
		}else {
			throw new IllegalArgumentException("mapFilterChoiceToKernel() Unexpected value: " + filterChoice);
		}
		return outputKernel;
	}
	
}
