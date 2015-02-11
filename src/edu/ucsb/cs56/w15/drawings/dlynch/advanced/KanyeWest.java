package edu.ucsb.cs56.w15.drawings.dlynch.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // General class for shapes

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   The face of Kanye West w/ shutter shades obviously

   @author Dylan Lynch
   @version for CS56, W15, UCSB, 02/07/2015

*/

public class KanyeWest extends GeneralPathWrapper implements Shape 
{


    public KanyeWest(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* coffee cup
        
        final double ORIG_ULX = 50.0; 
        final double ORIG_ULY = 0.0; 
        final double ORIG_HEIGHT = 200.0; 
        final double ORIG_WIDTH = 300.0; 
                
        GeneralPath leftFace = new GeneralPath();
             
        leftFace.moveTo(100,100);
	leftFace.lineTo(100,200);
	leftFace.lineTo(175,250);
	leftFace.lineTo(200,260);
	leftFace.lineTo(225,270);
	leftFace.lineTo(300,270);

        GeneralPath leftTop = new GeneralPath();
	
        leftTop.moveTo(100,100);
        leftTop.lineTo(125,75);
	leftTop.lineTo(175,50);
	leftTop.lineTo(225,35);
	leftTop.lineTo(300,30);

	GeneralPath leftShades = new GeneralPath();
	//Frame
	leftShades.moveTo(125, 125);
	leftShades.lineTo(275, 125);
	leftShades.lineTo(275, 175);
	leftShades.lineTo(125, 175);
	leftShades.lineTo(125, 125);
	//Frame Connections
	leftShades.moveTo(275, 130);
	leftShades.lineTo(300, 130);
	//Shutter Shades Lines
	leftShades.moveTo(125, 135);
	leftShades.lineTo(275, 135);
	leftShades.moveTo(125, 145);
	leftShades.lineTo(275, 145);
	leftShades.moveTo(125, 155);
	leftShades.lineTo(275, 155);
	leftShades.moveTo(125, 165);
	leftShades.lineTo(275, 165);
	leftShades.moveTo(125, 175);
	leftShades.lineTo(275, 175);
	

	GeneralPath mouth = new GeneralPath();

	mouth.moveTo(250,250);
	mouth.lineTo(400,250);

	Shape rightTop = ShapeTransforms.horizontallyFlippedCopyOf(leftTop);
        Shape rightFace = ShapeTransforms.horizontallyFlippedCopyOf(leftFace);
	Shape rightShades = ShapeTransforms.horizontallyFlippedCopyOf(leftShades);

        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 400 pixels
       
	rightTop = ShapeTransforms.translatedCopyOf(rightTop, 400.0, 0.0);
        rightFace = ShapeTransforms.translatedCopyOf(rightFace, 400.0, 0.0);
	rightShades = ShapeTransforms.translatedCopyOf(rightShades,350.0,0.0);
        // now we put the whole thing together ino a single path.
       
        GeneralPath wholeKanye = new GeneralPath ();
	wholeKanye.append(leftTop, false);
	wholeKanye.append(rightTop, false);
        wholeKanye.append(leftFace, false);
        wholeKanye.append(rightFace, false);
	wholeKanye.append(leftShades, false);
	wholeKanye.append(rightShades, false);
	wholeKanye.append(mouth, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeKanye, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
    this.set(new GeneralPath(s));
    }
}
