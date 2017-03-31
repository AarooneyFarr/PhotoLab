package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture

	{
		///////////////////// constructors //////////////////////////////////

		/**
		 * Constructor that takes no arguments
		 */
		public Picture()
			{
				/*
				 * not needed but use it to show students the implicit call to
				 * super() child constructors always call a parent constructor
				 */
				super();
			}

		/**
		 * Constructor that takes a file name and creates the picture
		 * 
		 * @param fileName
		 *            the name of the file to create the picture from
		 */
		public Picture(String fileName)
			{
				// let the parent class handle this fileName
				super(fileName);
			}

		/**
		 * Constructor that takes the width and height
		 * 
		 * @param height
		 *            the height of the desired picture
		 * @param width
		 *            the width of the desired picture
		 */
		public Picture(int height, int width)
			{
				// let the parent class handle this width and height
				super(width, height);
			}

		/**
		 * Constructor that takes a picture and creates a copy of that picture
		 * 
		 * @param copyPicture
		 *            the picture to copy
		 */
		public Picture(Picture copyPicture)
			{
				// let the parent class do the copy
				super(copyPicture);
			}

		/**
		 * Constructor that takes a buffered image
		 * 
		 * @param image
		 *            the buffered image to use
		 */
		public Picture(BufferedImage image)
			{
				super(image);
			}

		////////////////////// methods ///////////////////////////////////////

		/**
		 * Method to return a string with information about this picture.
		 * 
		 * @return a string with information about the picture such as fileName,
		 *         height and width.
		 */
		public String toString()
			{
				String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
				return output;

			}

		/** Method to set the blue to 0 */
		public void zeroBlue()
			{

				Pixel[][] pixels = this.getPixels2D();
				for (Pixel[] rowArray : pixels)
					{
						for (Pixel pixelObj : rowArray)
							{
								pixelObj.setBlue(0);
							}
					}
			}

		public void keepOnlyBlue()
			{

			}

		/**
		 * Method that mirrors the picture around a vertical mirror in the
		 * center of the picture from left to right
		 */
		public void mirrorVertical()
			{
				Pixel[][] pixels = this.getPixels2D();
				Pixel leftPixel = null;
				Pixel rightPixel = null;
				int width = pixels[0].length;
				for (int row = 0; row < pixels.length; row++)
					{
						for (int col = 0; col < width / 2; col++)
							{
								leftPixel = pixels[row][col];
								rightPixel = pixels[row][width - 1 - col];
								rightPixel.setColor(leftPixel.getColor());
							}
					}
			}

		public void mirrorVerticalRightToLeft()
			{
				Pixel[][] pixels = this.getPixels2D();
				Pixel leftPixel = null;
				Pixel rightPixel = null;
				int width = pixels[0].length;

				for (int row = pixels.length - 1; row >= 0; row--)
					{
						for (int col = width / 2 - 1; col >= 0; col--)
							{
								leftPixel = pixels[row][col];
								rightPixel = pixels[row][width - 1 - col];
								leftPixel.setColor(rightPixel.getColor());
							}
					}

			}

		public void mirrorDiagonal()
			{
				Pixel topRight = null;
				Pixel bottomLeft = null;
				Pixel[][] pixels = this.getPixels2D();

				for (int row = 0; row < pixels.length; row++)
					{
						for (int col = 0; col < pixels[0].length; col++)
							{

								if (row != col && row < pixels[0].length && col < pixels.length)
									{
										topRight = pixels[row][col];
										bottomLeft = pixels[col][row];

										bottomLeft.setColor(topRight.getColor());

									}
							}
					}
			}

		public void mirrorDiagonalTopLeftToBottomRight()
			{
				Pixel topLeft = null;
				Pixel bottomRight = null;

				Pixel[][] pixels = this.getPixels2D();
				int mirrorPoint = Math.min(pixels.length, pixels[0].length) - 1;

				for (int row = 0; row < pixels.length; row++)
					{
						for (int col = 0; col < pixels[0].length; col++)
							{

								if (row + col != mirrorPoint && row < pixels[0].length && col < pixels.length)
									{
										topLeft = pixels[mirrorPoint - col][mirrorPoint - row];
										bottomRight = pixels[row][col];

										bottomRight.setColor(topLeft.getColor());

									}
							}
					}

			}

		public void mirrorHorizontalBottomToTop()
			{
				Pixel[][] pixels = this.getPixels2D();
				Pixel topPixel = null;
				Pixel bottomPixel = null;
				int height = pixels.length;

				for (int col = 0; col < pixels[0].length; col++)
					{
						for (int row = height / 2 - 1; row >= 0; row--)
							{
								topPixel = pixels[row][col];
								bottomPixel = pixels[height - 1 - row][col];
								topPixel.setColor(bottomPixel.getColor());
							}
					}

			}

		/** Mirror just part of a picture of a temple */
		public void mirrorTemple()
			{
				int mirrorPoint = 276;
				Pixel leftPixel = null;
				Pixel rightPixel = null;
				int count = 0;
				Pixel[][] pixels = this.getPixels2D();

				// loop through the rows
				for (int row = 27; row < 97; row++)
					{
						// loop from 13 to just before the mirror point
						for (int col = 13; col < mirrorPoint; col++)
							{

								leftPixel = pixels[row][col];
								rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
								rightPixel.setColor(leftPixel.getColor());
							}
					}
			}

		/** Mirror just part of a snowman */
		public void mirrorArms()
			{
				int mirrorPoint = 195;
				Pixel topPixel = null;
				Pixel bottomPixel = null;
				
				Pixel[][] pixels = this.getPixels2D();

				// loop through the rows
				for (int row = 162; row < mirrorPoint; row++)
					{
						// loop from 13 to just before the mirror point
						for (int col = 100; col < 298; col++)
							{

								topPixel = pixels[row][col];
								bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
								bottomPixel.setColor(topPixel.getColor());
							}
					}

			}

		/** Mirror one gull into two */
		public void mirrorGull()
			{
				int mirrorPoint = 355;
				Pixel leftPixel = null;
				Pixel rightPixel = null;
				int count = 0;
				Pixel[][] pixels = this.getPixels2D();

				// loop through the rows
				for (int row = 227; row < 324; row++)
					{
						// loop from 13 to just before the mirror point
						for (int col = 235; col < mirrorPoint; col++)
							{

								leftPixel = pixels[row][col];
								rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
								rightPixel.setColor(leftPixel.getColor());
							}
					}

			}

		/**
		 * copy from the passed fromPic to the specified startRow and startCol
		 * in the current picture
		 * 
		 * @param fromPic
		 *            the picture to copy from
		 * @param startRow
		 *            the start row to copy to
		 * @param startCol
		 *            the start col to copy to
		 */
		public void copy(Picture fromPic, int startRow, int startCol)
			{
				Pixel fromPixel = null;
				Pixel toPixel = null;
				Pixel[][] toPixels = this.getPixels2D();
				Pixel[][] fromPixels = fromPic.getPixels2D();
				for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++)
					{
						for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++)
							{
								fromPixel = fromPixels[fromRow][fromCol];
								toPixel = toPixels[toRow][toCol];
								toPixel.setColor(fromPixel.getColor());
							}
					}
			}
		
		public void copy(Picture fromPic, int startRow, int startCol, int endRow, int endCol)
			{
				Pixel fromPixel = null;
				Pixel toPixel = null;
				Pixel[][] toPixels = this.getPixels2D();
				Pixel[][] fromPixels = fromPic.getPixels2D();
				for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length && toRow <= endRow; fromRow++, toRow++)
					{
						for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length && toCol <= endCol; fromCol++, toCol++)
							{
								fromPixel = fromPixels[fromRow][fromCol];
								toPixel = toPixels[toRow][toCol];
								toPixel.setColor(fromPixel.getColor());
							}
					}
			}

		/** Method to create a collage of several pictures */
		public void createCollage()
			{
				Picture flower1 = new Picture("coolpic1.jpg");
				Picture flower2 = new Picture("coolpic2.jpg");
				this.copy(flower1, 0, 0);
				this.copy(flower2, 176, 0);
				this.copy(flower1, 344, 0);
				Picture flowerNoBlue = new Picture(flower2);
				flowerNoBlue.randomPixel();
				this.copy(flowerNoBlue, 344, 0);
				
				this.mirrorVertical();
				this.write("collage.jpg");
			}

		/**
		 * Method to show large changes in color
		 * 
		 * @param edgeDist
		 *            the distance for finding edges
		 */
		public void edgeDetection(int edgeDist)
			{
				Pixel leftPixel = null;
				Pixel rightPixel = null;
				Pixel[][] pixels = this.getPixels2D();
				Color rightColor = null;
				for (int row = 0; row < pixels.length; row++)
					{
						for (int col = 0; col < pixels[0].length - 1; col++)
							{
								leftPixel = pixels[row][col];
								rightPixel = pixels[row][col + 1];
								rightColor = rightPixel.getColor();
								if (leftPixel.colorDistance(rightColor) > edgeDist)
									leftPixel.setColor(Color.BLACK);
								else
									leftPixel.setColor(Color.WHITE);
							}
					}
			}

		public void edgeDetection2(int edgeDist)
			{
				Pixel leftPixel = null;
				Pixel rightPixel = null;
				Pixel bottomPixel = null;
				Pixel brPixel = null;
				Pixel[][] pixels = this.getPixels2D();
				Color rightColor = null;
				Color bottomColor = null;
				Color brColor = null;
				for (int row = 0; row < pixels.length - 1; row++)
					{
						for (int col = 0; col < pixels[0].length - 1; col++)
							{
								leftPixel = pixels[row][col];
								rightPixel = pixels[row][col + 1];
								bottomPixel = pixels[row + 1][col];
								brPixel = pixels[row + 1][col + 1];
								rightColor = rightPixel.getColor();
								bottomColor = bottomPixel.getColor();
								brColor = brPixel.getColor();
								if ((leftPixel.colorDistance(rightColor) > edgeDist) || (leftPixel.colorDistance(bottomColor) > edgeDist) || (leftPixel.colorDistance(brColor) > edgeDist))
									leftPixel.setColor(Color.BLACK);
								else
									leftPixel.setColor(Color.WHITE);
							}
					}
			}

		public void fullRandom()
			{
				Pixel[][] currentPicture = this.getPixels2D();
				for (Pixel[] row : currentPicture)
					{
						for (Pixel currentPixel : row)
							{
								int red = (int) (Math.random() * 256);
								int blue = (int) (Math.random() * 256);
								int green = (int) (Math.random() * 256);

								currentPixel.setColor(new Color(red, green, blue));
							}
					}
			}
		
		public void glitchArt(Picture pic)
		{
			pic.randomPixel();
			pic.negate();
			pic.funky();
			pic.mirrorHorizontalBottomToTop();
			
		}

		public void randomPixel()
			{
				Pixel[][] currentPicture = this.getPixels2D();

				for (Pixel[] row : currentPicture)
					{
						for (Pixel currentPixel : row)
							{
								int rand = (int) (Math.random() * 100);
								int red = ((int) (Math.random() * rand) + currentPixel.getRed()) % 256;
								int blue = ((int) (Math.random() * rand) + currentPixel.getBlue()) % 256;
								int green = ((int) (Math.random() * rand) + currentPixel.getGreen()) % 256;

								currentPixel.setColor(new Color(red, green, blue));
							}
					}
			}

		public void negate()
			{
				Pixel[][] currentPicture = this.getPixels2D();

				for (Pixel[] row : currentPicture)
					{
						for (Pixel currentPixel : row)
							{

								currentPixel.setColor(new Color(255 - currentPixel.getRed(), 255 - currentPixel.getGreen(), 255 - currentPixel.getBlue()));
							}
					}
			}

		public void grayScale()
			{
				Pixel[][] currentPicture = this.getPixels2D();

				for (Pixel[] row : currentPicture)
					{
						for (Pixel currentPixel : row)
							{
								int average = (currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen()) / 3;

								currentPixel.setColor(new Color(average, average, average, 255));
							}
					}

			}
		
		public void funky()
			{
				Pixel[][] currentPicture = this.getPixels2D();

				for (Pixel[] row : currentPicture)
					{
						for (Pixel currentPixel : row)
							{
								

								currentPixel.setColor(new Color(currentPixel.getGreen(), currentPixel.getBlue(), currentPixel.getRed(), 255));
							}
					}

			}
		
		public void funky2()
			{
				Pixel[][] currentPicture = this.getPixels2D();

				for (Pixel[] row : currentPicture)
					{
						for (Pixel currentPixel : row)
							{
								

								currentPixel.setColor(new Color(currentPixel.getBlue(), currentPixel.getRed(), currentPixel.getGreen(), 255));
							}
					}

			}
		
		public void valentinesMeme()
		{
			Picture canvas = new Picture("blackCanvas.png");
			Picture happyGroup = new Picture("welcome.jpeg");
			Picture condescending = new Picture("condescending.jpeg");
			canvas.addMessage("When you tell your friends", 10, 245, Color.WHITE, 20);
			canvas.addMessage("When you tell your family", 10, 450, Color.WHITE, 20);
			canvas.addMessage("Finally got a Valentine", 30, 30, Color.WHITE, 20);
			
			canvas.copy(happyGroup,40,10);
			canvas.copy(condescending, 250, 0);
			
			canvas.explore();
			canvas.write("valentines.png");
		}
		
		public void encode(Picture hiddenPicture)
		{
			Pixel [][] currentPicture = this.getPixels2D();
			Pixel [][] hiddenData = hiddenPicture.getPixels2D();
			
				Pixel hiddenPixel = null;
				Pixel currentPixel = null;
				
				for(int row = 0; row < currentPicture.length; row++)
					{
						for(int col = 0; col < currentPicture[0].length; col++)
							{
								hiddenPixel = hiddenData[row][col];
								currentPixel = currentPicture[row][col];
								
								if(hiddenPixel.getRed() == 255 && hiddenPixel.getBlue() == 255 && hiddenPixel.getGreen() == 255)
									{
										int currentRed = currentPixel.getRed();
										if(currentRed % 2 == 0)
											{
												currentPixel.setRed(currentRed + 1);
											}
									}
								else
									{
										int currentRed = currentPixel.getRed();
										if(currentRed % 2 != 0 )
											{
												currentPixel.setRed(currentRed - 1);
												
												
											}
										
										
									}
								
							}
						
					}
				
		}


		public void decode()
		{
			Pixel[][] decoded = this.getPixels2D();
			Pixel currentPixel = null;
			
			for(int row = 0; row < decoded.length; row++)
				{
					for(int col = 0; col < decoded[0].length; col++)
						{
							
							currentPixel = decoded[row][col];
							int currentRed = currentPixel.getRed();
							if(currentRed % 2 == 0)
								{
									currentPixel.setColor(new Color(127,255,0));
								}
							else
								{
									currentPixel.setColor(Color.WHITE);
									
									
								}
							
						}
					
				}
			
			
		}
		
		public void chromakey(Picture background)
		{
			Pixel[][] base = this.getPixels2D();
			Pixel[][] backgroundPic = background.getPixels2D();
			Pixel currentPixel = null;
			
			for(int row = 0; row < base.length; row++)
				{
					for(int col = 0; col < base[0].length; col++)
						{
							currentPixel = base[row][col];
							
							if(currentPixel.getGreen() > currentPixel.getBlue() && currentPixel.getGreen() > currentPixel.getRed())
								{
									try{
										
									
									base[row][col].setColor(backgroundPic[row][col].getColor());
									}
									catch(ArrayIndexOutOfBoundsException e)
										{
											
											
										}
									
								}
							
						}
					
				}
			
		}

		/*
		 * Main method for testing - each class in Java can have a main method
		 */
		public static void main(String[] args)
			{
				Picture base = new Picture("greenscreen.jpg");
				Picture hidden = new Picture("quote.jpg");
				
				base.explore();
				base.chromakey(hidden);
				base.explore();
				
				
			}

	} // this } is the end of class Picture, put all new methods before this
