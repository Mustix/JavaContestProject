//* Filename: Picture.java
//* Created by: Aknan Mustafa
//* Date: 11/03/2021

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

import CSE234.SimplePicture;
import CSE234.Pixel;

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture () {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param width the width of the desired picture
     * @param height the height of the desired picture
     */
    public Picture(int width, int height) {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
         String output = "Picture, filename " + getFileName() +
        " height " + getHeight()
        + " width " + getWidth();
        return output;
    }

    /**
     * TODO: put method description and parameter descriptions here.
     * See above methods for examples
     */
    public void flipHorizontalRectangle(int x, int y, int width, int height) {
         int mirrorPt = this.getWidth()/2;
         Pixel  sourcePixel, targetPixel;
         int sourcex = 0;
         int targetx = this.getWidth() - 1 ;
         for ( ; sourcex < mirrorPt; sourcex++, targetx--) {
            for (int sourcey = 0; sourcey < this.getHeight(); sourcey++){  
                  sourcePixel = this.getPixel(sourcex, sourcey);
                  targetPixel = this.getPixel(targetx, sourcey);
                  Color sourcecolor = (sourcePixel.getColor());
                  Color targetcolor = (targetPixel.getColor());
                  targetPixel.setColor(sourcecolor);
                  sourcePixel.setColor(targetcolor);
         }
            }
}
    /**
     * TODO: put method description and parameter descriptions here.
     * See above methods for examples
     */
    public void flipVerticalRectangle(int x, int y, int width, int height) {
         int mirrorPt = this.getHeight()/2;
         Pixel  sourcePixel, targetPixel;
         int sourcey = 0;
         int targety = this.getHeight() - 1 ;
         for ( ; sourcey < mirrorPt; sourcey++, targety--) {
            for (int sourcex = 0; sourcex < this.getWidth(); sourcex++){  
                  sourcePixel = this.getPixel(sourcex, sourcey);
                  targetPixel = this.getPixel(sourcex, targety);
                 Color sourcecolor = (sourcePixel.getColor());
                  Color targetcolor = (targetPixel.getColor());
                  targetPixel.setColor(sourcecolor);
                  sourcePixel.setColor(targetcolor);
            }
         }  
   }
    /**
     * TODO: put method description and parameter descriptions here.
     * See above methods for examples
     */
   public Picture replaceAllColor(Picture background, Color replaceColor, double tolerance) {
        // TODO
      Picture copy = new Picture(this);
		Pixel pixFrom = null;
      Pixel pixTo = null; 
      for (int x = 0; x < this.getWidth() && x < background.getWidth(); x++) {
   		for (int y = 0; y < this.getHeight() && y < background.getHeight(); y++) {
                 pixFrom = background.getPixel(x,y);
                 pixTo = copy.getPixel(x,y);
                  if (pixTo.colorDistance(replaceColor) < tolerance) {
                      pixTo.setColor(pixFrom.getColor());
                      
                  }
         }
                   
      }
         return copy;
        
}
  public void scaleColor(double rScale, double gScale, double bScale) {
        //fill in
        Pixel[] pixelArray = this.getPixels();
        
       for ( int i = 0; i < pixelArray.length; i++)
       { 
         Pixel target = pixelArray[i];
         target.setRed((int) (target.getRed() * rScale ));
         target.setGreen((int) (target.getGreen() * gScale));
         target.setBlue((int) (target.getBlue() * bScale));
       }
        
    }


    /*
     * Filter negative 
     * Describe: What the method does and what the parameters mean.
     * (See writeup)
     */
    public void negative(int start, int end) {
    // So for this program we will need to do 255 - existing color for each, from int start to int end
    // 

        //fill in
        Pixel[] pixelArray = this.getPixels();
 
       for ( int u = start; u < end; u++)
       { 
         Pixel target = pixelArray[u];
         target.setRed((int) (255 - target.getRed()));
         target.setGreen((int) (255 - target.getGreen()));
         target.setBlue((int) (255 - target.getBlue()));
         }
         
       

    }

    /*
     * Filter grayscale 
     * Describe: making each bit the same by finding average for them. Parametr 
     * (See writeup)
     */
    public void grayscale(int start, int end) {
          //fill in
             Pixel[] pixelArray = this.getPixels();
 
       for ( int u = start; u < end; u++)
       { 
         Pixel target = pixelArray[u];
         int r = target.getRed();
         int b = target.getGreen();
         int g = target.getBlue();
         target.setRed((int) ((r+b+g)/3 ));
         target.setGreen((int) ((r+b+g)/3 ));
         target.setBlue((int)((r+b+g)/3 ));
         }
         
       

    
    }


    /*
     * Filter which should be a Sepia, but for some reason it was too dark, so i create my own.
     * Describe:Method set up the each pixel of the picture to the value of the filter.
     * (See writeup)
     */
    public void sepia(int start, int end) {
    Pixel[] pixelArray = this.getPixels();
                 for ( int u = start; u < end; u++)
         { 
         Pixel target = pixelArray[u];
         int r = target.getRed();
         int b = target.getGreen();
         int g = target.getBlue();
         target.setRed((int) ((r+b) * 0.44));
         target.setGreen((int) ((b+g) * 0.26 ));
         target.setBlue((int)(255 -((g) * 1.5) ));
         }
         
       
    }
public void placePicture(Picture pic, int x, int y)
	{
		for (int xPos = 0; xPos < pic.getWidth(); xPos++) {
      
            for ( int yPos = 0; yPos < pic.getHeight(); yPos++) {
            
                     //System.out.println( pic.getPixel(xPos, yPos));
                     if ( xPos+x < this.getWidth() && yPos+y < this.getHeight()) {
                       //  this.getPixel(xPos, yPos) = pic.getPixel(xPos, yPos);
                         Pixel source  = pic.getPixel(xPos, yPos);
                         Pixel target  = this.getPixel(xPos+x,yPos+y);
                         
                         target.setRed((int) (source.getRed() ));
                         target.setGreen((int) (source.getGreen() ));
                         target.setBlue((int)(source.getBlue() ));

                     //
                         
                     }
             }
       }
        
                  
    
      //DO: Complete method
	}

// 
// 	/* TODO: Add header comment and complete the method */
	public void collage(Picture [] pictures) {
   
       //  Go through each Picture obj in pictures array
       int xPos, yPos;
      // xPos = getWidth();
     //  yPos = getHeight();
       xPos = 0;
       yPos = 0;
	    for (int i = 0; i < pictures.length; i++) {
           Picture source = pictures[i]; 
           placePicture(source, xPos, yPos);
           xPos = xPos + source.getWidth();
          // yPos = yPos + source.getHeight();
          

           // Picture target = this.placePicture[i];

     	 }
	}
       public void mycollage(Picture [] pictures) {
   
       //  Go through each Picture obj in pictures array
       int xPos, yPos;
      // xPos = getWidth();
     //  yPos = getHeight();
       xPos = 0;
       yPos = 0;
       int u = 0;
	    for (int i = 0; i < pictures.length; i++) {
         System.out.println ("x " + xPos + " y " + yPos );
         
         Picture source = pictures[i]; 
         if (i == 0) { 
            this.placePicture(source, 0, 0);
            xPos = xPos + source.getWidth(); 
            yPos = yPos + source.getHeight(); 
         }  else if (i%2 == 0) {
         
            this.placePicture(source, xPos, 0);
            xPos = xPos + source.getWidth(); 
            u = u + 1;
         
         } else {
             this.placePicture(source, 0, yPos);
             yPos = yPos + source.getHeight(); 
             u = u + 1;    
         }
                                    
        System.out.println (u); 
       }
}

}
    
         
       

 // this } is the end of class Picture, put all new methods before this
