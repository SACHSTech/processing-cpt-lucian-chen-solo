import processing.core.PApplet;

/**
 * Main class to execute sketch
 * @author L. Chen
 */
class Main {
  public static void main(String[] args) {
    
    String[] processingArgs = {"MySketch"};
	  Sketch mySketch = new Sketch();  
	  
	  PApplet.runSketch(processingArgs, mySketch);
  }
  
}
