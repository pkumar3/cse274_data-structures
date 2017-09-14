/**
 * This class contains methods that modify images by manipulating the RGB values
 * of each pixel.
 * 
 * @author Pranshu Kumar
 * @version 1.0
 */

import java.awt.Color;


public class Ppm {
	
	private Color[][] data;
	private Color[][] newData;
	public static int row = 0;
	public static int  col = 0;
	public static final int MArow = 255;

	/**
	 * @param inputData A 2D Color array passed in from the PpmDriver class
	 */
	public Ppm(Color[][] inputData) {
		
		this.data = inputData;
		
	}
	
	/**
	 * Gets the new Color array with the modified image data
	 * 
	 * @return The Color array with the modified image data
	 */
	public Color[][] getData() {
		return newData;
	}
	
	/**
	 * Darkens the image by diving each of the RGB components in half.
	 * 
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm darken() {
		newData = new Color[data.length][data[0].length];
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[row].length; col++) {
				newData[row][col] = new Color(data[row][col].getRed()/2, data[row][col].getGreen()/2, data[row][col].getBlue()/2);
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Brightens the image by multiplying each of the RGB components in half.
	 * If the values go over 255, it caps them at 255.
	 * 
	 * @param red This is the Red component of the pixel.
	 * @param green This is the Green component of the pixel.
	 * @param blue This is the Blue component of the pixel.
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm lighten() {
		newData = new Color[data.length][data[0].length];
		int red = 0;
		int green = 0;
		int blue = 0;
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[row].length; col++) {
				red = data[row][col].getRed();
				red = red * 2 > 255 ? 255 : data[row][col].getRed() * 2;
				green = data[row][col].getGreen();
				green = green * 2 > 255 ? 255 : data[row][col].getGreen() * 2;
				blue = data[row][col].getBlue();
				blue = blue * 2 > 255 ? 255 : data[row][col].getBlue() * 2;
				newData[row][col] = new Color(red, green, blue);
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Converts the image into greyscale by setting each color component to the
	 * average of the red, green and blue components of that pixel.
	 * 
	 * @param avg This is the average of the red, green and blue components of a pixel.
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm greyscale() {
		newData = new Color[data.length][data[0].length];
		int avg = 0;
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[row].length; col++) {
				avg = (data[row][col].getRed() + data[row][col].getGreen() + data[row][col].getBlue()) / 3;
				newData[row][col] = new Color(avg, avg, avg);
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Inverts the colors of the image by subtracting each color component from 255.
	 * 
	 * @param red This is the Red component of the pixel.
	 * @param green This is the Green component of the pixel.
	 * @param blue This is the Blue component of the pixel.
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm invert() {
		newData = new Color[data.length][data[0].length];
		int red = 0;
		int green = 0;
		int blue = 0;
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[row].length; col++) {
				red = 255 - data[row][col].getRed();
				green = 255 -data[row][col].getGreen();
				blue = 255 - data[row][col].getBlue();
				newData[row][col] = new Color(red, green, blue);
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Flips the image left to right, i.e. along the vertical axis.
	 * 
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm flipHorizontal() {
		newData = new Color[data.length][data[0].length];
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[0].length; col++) {
				newData[row][data[0].length - 1 - col] = new Color(data[row][col].getRed(), data[row][col].getGreen(), data[row][col].getBlue());
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Flips the image top to bottom, i.e. along the horizontal axis.
	 * 
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm flipVertical() {
		newData = new Color[data.length][data[0].length];
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[0].length; col++) {
				newData[data.length - row - 1][col] = new Color(data[row][col].getRed(), data[row][col].getGreen(), data[row][col].getBlue());
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Adds noise to the image by adding a random value if a color component is
	 * lesser than 125 or subtracting a random value if a color component is greater
	 * than 125.
	 * 
	 * @param red This is the Red component of the pixel.
	 * @param green This is the Green component of the pixel.
	 * @param blue This is the Blue component of the pixel.
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm addNoise() {
		newData = new Color[data.length][data[0].length];
		int red = 0;
		int green = 0;
		int blue = 0;
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[row].length; col++) {
				red = data[row][col].getRed();
				green = data[row][col].getGreen();
				blue = data[row][col].getBlue();
				red = red > 125 ? red - (int)(Math.random() * 50) : red + (int)(Math.random() * 50);
				green = green > 125 ? green - (int)(Math.random() * 50) : green + (int)(Math.random() * 50);
				blue = blue > 125 ? blue - (int)(Math.random() * 50) : blue + (int)(Math.random() * 50);
				newData[row][col] = new Color(red, green, blue);
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Reduces the number of colors in the image to produce sudden changes in color
	 * tones where there were subtle changes in color tones.
	 * 
	 * @param red This is the Red component of the pixel.
	 * @param green This is the Green component of the pixel.
	 * @param blue This is the Blue component of the pixel.
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm posterize() {
		newData = new Color[data.length][data[0].length];
		int red = 0;
		int green = 0;
		int blue = 0;
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[row].length; col++) {
				red = data[row][col].getRed() / 29 * 29;
				green = data[row][col].getGreen() / 29 * 29;
				blue = data[row][col].getBlue() / 29 * 29;
				newData[row][col] = new Color(red, green, blue);
			}
		}
		return new Ppm(newData);
	}
	
	/**
	 * Adds white grid lines to the image
	 * 
	 * @param red This is the Red component of the pixel.
	 * @param green This is the Green component of the pixel.
	 * @param blue This is the Blue component of the pixel.
	 * @return An object of this Ppm class which has the data for the modified image.
	 */
	public Ppm surprise() {
		newData = new Color[data.length][data[0].length];
		int gridSplitRow = data.length / 4;
		int gridSplitCol = data[0].length / 4;
		for(row = 0; row < data.length; row++) {
			for(col = 0; col < data[row].length; col++) {
				if(col == gridSplitCol || col == gridSplitCol * 2 || col == gridSplitCol * 3)
					newData[row][col] = Color.WHITE;
				else if(row == gridSplitRow || row == gridSplitRow * 2 || row == gridSplitRow * 3)
					newData[row][col] = Color.WHITE;
				else
					newData[row][col] = new Color(data[row][col].getRed(), data[row][col].getGreen(), data[row][col].getBlue());
			}
		}
		return new Ppm(newData);
	}

}
