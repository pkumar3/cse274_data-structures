/**
 * This class asks the user for a filename (of a ppm image ) and writes modified images
 * by applying filters using the Ppm class.
 * 
 * Filters working correctly
 * 1. darken()
 * 2. lighten()
 * 3. greyscale()
 * 4. invert()
 * 5. flipVertical()
 * 6. flipHorizontal()
 * 7. addNoise()
 * 8. posterize()
 * 9. surprise()
 * 
 * Filters not working correctly
 * 1. soften() - The number of cases could not be optimized and code was becoming too
 * inefficient.
 * 2. addFrame() - The placing of the frame caused an OutOfBoundsException since the
 * 2D array was not being resized correctly.
 * 
 * @author Pranshu Kumar
 * @version 1.0
 */

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PpmDriver {
	
	public static String fileName = "";
	public static Color[][] inputData;

	public static void main(String[] args) throws IOException {
		
		read();

		// Create object to darken
		Ppm darkObj = new Ppm(inputData);
		darkObj.darken();
		write(darkObj, "darken");
		
		// Create object to lighten
		Ppm lightObj = new Ppm(inputData);
		lightObj.lighten();
		write(lightObj, "lighten");
		
		// Create object to convert to greyscale
		Ppm greyObj = new Ppm(inputData);
		greyObj.greyscale();
		write(greyObj, "greyscale");
		
		// Create object to invert
		Ppm invertObj = new Ppm(inputData);
		invertObj.invert();
		write(invertObj, "invert");
		
		// Create object to flip horizontally
		Ppm flipHObj = new Ppm(inputData);
		flipHObj.flipHorizontal();
		write(flipHObj, "flipHorizontal");
		
		// Create object to flip vertically
		Ppm flipVObj = new Ppm(inputData);
		flipVObj.flipVertical();
		write(flipVObj, "flipVertical");
		
		// Create object to add noise
		Ppm noiseObj = new Ppm(inputData);
		noiseObj.addNoise();
		write(noiseObj, "addNoise");
		
		// Create object to posterize
		Ppm posterizeObj = new Ppm(inputData);
		posterizeObj.posterize();
		write(posterizeObj, "posterize");
		
		// Create object to add grid lines
		Ppm surpriseObj = new Ppm(inputData);
		surpriseObj.surprise();
		write(surpriseObj, "surprise");
		

	}
	
	// Ask the user for input file and read the ppm file
	public static void read() {
		String s = "";
		int width = 0;
		int height = 0;
		int maxVal = 0;
		Scanner in = new Scanner(System.in);
		Scanner fin = null;
		
		try {
			
			System.out.println("Please enter the name of the ppm file: -");
			fileName = in.nextLine();
			File file = new File("src/" + fileName);
			
			fin = new Scanner(file);
			while(fin.hasNext()) {
				while(!(fin.hasNextInt())) { // Search for the width and height
					s = fin.nextLine();
					System.out.println(s);
				}
				
				width = fin.nextInt();
				System.out.println("width = " + width);
				height = fin.nextInt();
				System.out.println("height = " + height);
				maxVal = fin.nextInt();
				System.out.println("Max = " + maxVal);
				
				inputData = new Color[height][width]; // Create the Color array
				
				// Populate the Color array
				for(int row = 0; row < height; row++) {
					for(int col = 0; col < width; col++) {
						inputData[row][col] = new Color(fin.nextInt(), fin.nextInt(), fin.nextInt());
					}
				}
				
			}
			
			fin.close();
			
		} catch (Exception e) {
			System.out.println("An exception was thrown.. Exiting");
		}
	}
	
	// Write the modified image files based on the type of filter applied
	public static void write(Ppm obj, String type) {
		
		try {
			
			// Match the file name to original plus the type of filter
			String fileNameBeforeExt = fileName.substring(0, fileName.indexOf('.'));
			PrintWriter pw = new PrintWriter(new File("src/" + fileNameBeforeExt + "_" + type + ".ppm"));
			
			pw.println("P3");
			pw.println(obj.getData()[0].length);
			pw.println(obj.getData().length);
			pw.println("255");
			
			// Write the RGB values
			for(int row = 0; row < obj.getData().length; row++) {
				for(int col = 0; col < obj.getData()[0].length; col++) {
					pw.print(obj.getData()[row][col].getRed() + " ");
					pw.print(obj.getData()[row][col].getGreen() + " ");
					pw.print(obj.getData()[row][col].getBlue() + " ");
					pw.println();
				}
			}
			
			pw.close();
			
			System.out.println();
			System.out.println(type + " file written! \n");
			
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found!");
		}
	}

}
