import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 10; 
private double branchAngle = .3f;  
public void setup() 
{   
	size(640,480);    
	noLoop(); 
} 
public void draw() 
{   
	background(0);   
	stroke(0,255,0);   
	line(320,480,320,380);   
	drawBranches(320,380,100,3*Math.PI/2);  //will add later 
} 
public void drawBranches(int x,int y, double branchLength, double angle) 
{   
	double pagan=angle+branchAngle;
	double diMaria=angle-branchAngle;
	branchLength = branchLength*fractionLength;
	int endX1 = (int)(branchLength*Math.cos(pagan) + x);
	int endY1 = (int)(branchLength*Math.sin(pagan) + y); 
	int endX2 = (int)(branchLength*Math.cos(diMaria) + x);
	int endY2 = (int)(branchLength*Math.sin(diMaria) + y); 
	line(x,y,endX1,endY1);
	line(x,y,endX2,endY2);
	if (branchLength>smallestBranch)
	{
		drawBranches(endX1, endY1, branchLength, pagan);
		drawBranches(endX2, endY2, branchLength, diMaria);
	}
} 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
