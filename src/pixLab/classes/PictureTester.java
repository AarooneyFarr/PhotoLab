package pixLab.classes;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Aaron Farr
 */
public class PictureTester
	{
		/** Method to test zeroBlue */
		public static void testZeroBlue()
			{
				Picture beach = new Picture("beach.jpg");
				beach.explore();
				beach.zeroBlue();
				beach.explore();
			}

		/** Method to test mirrorVertical */
		public static void testMirrorVertical()
			{
				Picture caterpillar = new Picture("caterpillar.jpg");
				caterpillar.explore();
				caterpillar.mirrorVertical();
				caterpillar.explore();
			}

		public static void testMirrorVerticalRightToLeft()
			{
				Picture koala = new Picture("koala.jpg");
				koala.explore();
				koala.mirrorVerticalRightToLeft();
				koala.explore();

			}

		public static void testMirrorDiagonal()
			{
				Picture koala = new Picture("koala.jpg");
				koala.explore();
				koala.mirrorDiagonal();
				koala.explore();
			}

		public static void testMirrorDiagonalBottomToLeft()
			{
				Picture koala = new Picture("koala.jpg");
				koala.explore();
				koala.mirrorDiagonalTopLeftToBottomRight();
				koala.explore();
			}

		public static void testMirrorHorizontalBottomToTop()
			{
				Picture koala = new Picture("koala.jpg");
				koala.explore();
				koala.mirrorHorizontalBottomToTop();
				koala.explore();

			}

		/** Method to test mirrorTemple */
		public static void testMirrorTemple()
			{
				Picture temple = new Picture("temple.jpg");
				temple.explore();
				temple.mirrorTemple();
				temple.explore();
			}

		/** Method to test the collage method */
		public static void testCollage()
			{
				Picture canvas = new Picture("640x480.jpg");
				canvas.createCollage();
				canvas.explore();
			}

		/** Method to test edgeDetection */
		public static void testEdgeDetection()
			{
				Picture swan = new Picture("swan.jpg");
				swan.edgeDetection(15);
				swan.explore();
			}

		public static void testRandomPixel()
			{
				Picture koala = new Picture("CumberlandIsland.jpg");
				koala.explore();
				koala.randomPixel();
				koala.explore();
			}
		
		public static void testGlitchArt()
			{
				Picture koala = new Picture("CumberlandIsland.jpg");
				koala.explore();
				koala.glitchArt(koala);
				koala.explore();
			}

		public static void testNegate()
			{
				Picture motorcycle = new Picture("blueMotorcycle.jpg");
				motorcycle.explore();
				motorcycle.negate();

				motorcycle.explore();
			}

		public static void testGrayscale()
			{
				Picture motorcycle = new Picture("blueMotorcycle.jpg");
				motorcycle.explore();
				motorcycle.grayScale();

				motorcycle.explore();
			}

		public static void testFunky()
			{
				Picture motorcycle = new Picture("blueMotorcycle.jpg");
				motorcycle.explore();
				motorcycle.funky2();

				motorcycle.explore();
				motorcycle.funky();

				motorcycle.explore();

			}

		public static void testEdgeDetection2()
			{
				Picture swan = new Picture("wall.jpg");
				swan.edgeDetection2(15);
				swan.explore();
			}
		
		public static void testCopy()
			{
				Picture swan = new Picture("swan.jpg");
				Picture gull = new Picture("seagull.jpg");
				swan.copy(gull,200,0,1000,1000);
				swan.explore();
			}
		
		

		/**
		 * Main method for testing. Every class can have a main method in Java
		 */
		public static void main(String[] args)
			{
				// uncomment a call here to run a test
				// and comment out the ones you don't want
				// to run
				// testZeroBlue();
				// testKeepOnlyBlue();
				// testKeepOnlyRed();
				// testKeepOnlyGreen();
				// testNegate();
				// testGrayscale();
				// testFixUnderwater();
				// testMirrorVertical();
				// testMirrorTemple();
				// testMirrorArms();
				// testMirrorGull();
				// testMirrorDiagonal();
				// testCollage();
				// testCopy();
				// testEdgeDetection();
				// testEdgeDetection2();
				// testChromakey();
				// testEncodeAndDecode();
				// testGetCountRedOverValue(250);
				// testSetRedToHalfValueInTopHalf();
				// testClearBlueOverValue(200);
				// testGetAverageForColumn(0);
				// testMirrorVerticalRightToLeft();
				// testMirrorHorizontalBottomToTop();
				// testMirrorDiagonal();
				// testMirrorDiagonalBottomToLeft();
				// testRandomPixel();
				// testFunky();
				testGlitchArt();
			}
	}
