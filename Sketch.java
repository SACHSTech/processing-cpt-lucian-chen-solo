import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	PImage imgStandRight;
  PImage imgWalkRight1;
  PImage imgWalkRight2;

  PImage imgStandLeft;
  PImage imgWalkLeft1;
  PImage imgWalkLeft2;

  int intCharX = 50;
  int intCharY = 500;
  int intSpeedX = 8;
  int intSpeedY = 40;

  boolean blnRight = false;
  boolean blnLeft = false;
  boolean blnJump = false;

  PImage[] imgRightWalking = new PImage[4];
  PImage[] imgLeftWalking = new PImage[4];
  int intFrame = 0;

  ArrayList<Character> charKeys = new ArrayList<Character>();
  ArrayList<Integer> intClickX = new ArrayList<Integer>();
  ArrayList<Integer> intClickY = new ArrayList<Integer>();

  public void settings() {
    size(1500, 750);
  }

  public void setup() {
    imgStandRight = loadImage("stand right.png");
    imgStandRight.resize(200, 200);

    imgWalkRight1 = loadImage("walk right 1.png");
    imgWalkRight1.resize(200, 200);

    imgWalkRight2 = loadImage("walk right 2.png");
    imgWalkRight2.resize(200, 200);

    imgStandLeft = loadImage("stand left.png");
    imgStandLeft.resize(200, 200);

    imgWalkLeft1 = loadImage("walk left 1.png");
    imgWalkLeft1.resize(200, 200);

    imgWalkLeft2 = loadImage("walk left 2.png");
    imgWalkLeft2.resize(200, 200);

    imgRightWalking[0] = imgWalkRight1;
    imgRightWalking[1] = imgWalkRight1;
    imgRightWalking[2] = imgWalkRight2;
    imgRightWalking[3] = imgWalkRight2;

    imgLeftWalking[0] = imgWalkLeft1;
    imgLeftWalking[1] = imgWalkLeft1;
    imgLeftWalking[2] = imgWalkLeft2;
    imgLeftWalking[3] = imgWalkLeft2;
    
    frameRate(9);

    charKeys.add('d');
  }

  public void draw() {
    background(210, 255, 173);

    if(blnRight && intCharX <= 1350){
      intFrame++;
      intFrame %= imgRightWalking.length;
      image(imgRightWalking[intFrame], intCharX, intCharY);
      intCharX += intSpeedX;

      charKeys.add('d');
    }

    else if(blnLeft && intCharX >= -50){
      intFrame++;
      intFrame %= imgRightWalking.length;
      image(imgLeftWalking[intFrame], intCharX, intCharY);
      intCharX -= intSpeedX;

      charKeys.add('a');
    }

    // else if(blnJump){
    //   if(charKeys.get(charKeys.size() - 1) == 'd'){
    //     image(imgStandRight, intCharX, intCharY);
    //   }

    //   else if(charKeys.get(charKeys.size() - 1) == 'a'){
    //     image(imgStandLeft, intCharX, intCharY);
    //   }

    //   intCharY -= intSpeedY;
    // }

    else{
      if(charKeys.get(charKeys.size() - 1) == 'd'){
        image(imgStandRight, intCharX, intCharY);
      }
      
      else if(charKeys.get(charKeys.size() - 1) == 'a'){
        image(imgStandLeft, intCharX, intCharY);
      }
    }
  }

  public void keyPressed(){
    if(key == 'a'){
      blnLeft = true;
    }

    if(key == 'd'){
      blnRight = true;
    }

    if(key == ' '){
      blnJump = true;
    }
  }

  public void keyReleased(){
    if(key == 'a'){
      blnLeft = false;
    }

    if(key == 'd'){
      blnRight = false;
    }

    if(key == ' '){
      blnJump = false;
    }
  }
}