import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  PImage imgBackground;
  PImage imgMenu;
  PImage imgStart;
  PImage imgTut;
  PImage imgGal;

  PImage imgHeart;
  PImage imgLostHeart;

  PImage imgPruneLeft1;
  PImage imgPruneLeft2;
  PImage imgPruneLeftAtk;

  PImage imgPruneRight1;
  PImage imgPruneRight2;
  PImage imgPruneRightAtk;

  PImage imgScytheRestRight;
  PImage imgScytheRestLeft;

  PImage imgScytheAR1;
  PImage imgScytheAR2;
  PImage imgScytheAR3;
  PImage imgScytheAR4;
  PImage imgScytheAR5;
  PImage imgScytheAR6;
  PImage imgScytheAR7;
  PImage imgScytheAR8;

  PImage imgScytheAL1;
  PImage imgScytheAL2;
  PImage imgScytheAL3;
  PImage imgScytheAL4;
  PImage imgScytheAL5;
  PImage imgScytheAL6;
  PImage imgScytheAL7;
  PImage imgScytheAL8;

	PImage imgStandRight;
  PImage imgWalkRight1;
  PImage imgWalkRight2;

  PImage imgStandLeft;
  PImage imgWalkLeft1;
  PImage imgWalkLeft2;

  int intCharX = 50;
  int intCharY = 500;
  int intSpeedX = 15;
  int intSpeedY = 40;

  int intLives = 10;

  int intPruneX = 1300;

  boolean blnRight = false;
  boolean blnLeft = false;
  boolean blnJump = false;

  boolean blnAtk = false;

  float[] pruneArmyX = new float[1];
  int[] pruneSpeed = new int[5];
  int[] pruneHealth = new int[5];

  PImage[] imgRightWalking = new PImage[4];
  PImage[] imgLeftWalking = new PImage[4];

  PImage[] imgRightAttack = new PImage[9];
  PImage[] imgLeftAttack = new PImage[9];

  PImage[] imgPruneLeftMove = new PImage[9];
  PImage[] imgPruneRightMove = new PImage[9];

  int intFrame = 0;
  int intPruneFrame = 0;

  ArrayList<Character> charKeys = new ArrayList<Character>();
  ArrayList<Integer> intClickX = new ArrayList<Integer>();
  ArrayList<Integer> intClickY = new ArrayList<Integer>();

  int intLvl = 0;

  public void settings() {
    size(1500, 750);
  }

  public void setup() {
    imgBackground = loadImage("background.png");

    imgMenu = loadImage("menu.png");

    imgStart = loadImage("start select.png");

    imgTut = loadImage("tut select.png");

    imgGal = loadImage("gallery select.png");

    imgHeart = loadImage("heart.png");
    imgHeart.resize(50, 50);

    imgLostHeart = loadImage("lost heart.png");
    imgLostHeart.resize(50, 50);

    imgPruneLeft1 = loadImage("pruneLeft1.png");
    imgPruneLeft1.resize(150, 150);

    imgPruneLeft2 = loadImage("pruneLeft2.png");
    imgPruneLeft2.resize(150, 150);

    imgPruneLeftAtk = loadImage("pruneLeftAtk.png");
    imgPruneLeftAtk.resize(150, 150);

    imgPruneRight1 = loadImage("pruneRight1.png");
    imgPruneRight1.resize(150, 150);

    imgPruneRight2 = loadImage("pruneRight2.png");
    imgPruneRight2.resize(150, 150);

    imgPruneRightAtk = loadImage("pruneRightAtk.png");
    imgPruneRightAtk.resize(150, 150);

    imgScytheRestRight = loadImage("scythe rest right.png");
    imgScytheRestRight.resize(200, 200);

    imgScytheRestLeft = loadImage("scythe rest left.png");
    imgScytheRestLeft.resize(200, 200);

    imgScytheAR1 = loadImage("scythe attack 1r.png");
    imgScytheAR1.resize(300, 300);

    imgScytheAR2 = loadImage("scythe attack 2r.png");
    imgScytheAR2.resize(300, 300);

    imgScytheAR3 = loadImage("scythe attack 3r.png");
    imgScytheAR3.resize(300, 300);

    imgScytheAR4 = loadImage("scythe attack 4r.png");
    imgScytheAR4.resize(300, 300);

    imgScytheAR5 = loadImage("scythe attack 5r.png");
    imgScytheAR5.resize(300, 300);

    imgScytheAR6 = loadImage("scythe attack 6r.png");
    imgScytheAR6.resize(300, 300);

    imgScytheAR7 = loadImage("scythe attack 7r.png");
    imgScytheAR7.resize(300, 300);
    
    imgScytheAR8 = loadImage("scythe attack 8r.png");
    imgScytheAR8.resize(300, 300);

    // Left
    imgScytheAL1 = loadImage("scythe attack 1l.png");
    imgScytheAL1.resize(300, 300);

    imgScytheAL2 = loadImage("scythe attack 2l.png");
    imgScytheAL2.resize(300, 300);

    imgScytheAL3 = loadImage("scythe attack 3l.png");
    imgScytheAL3.resize(300, 300);

    imgScytheAL4 = loadImage("scythe attack 4l.png");
    imgScytheAL4.resize(300, 300);

    imgScytheAL5 = loadImage("scythe attack 5l.png");
    imgScytheAL5.resize(300, 300);

    imgScytheAL6 = loadImage("scythe attack 6l.png");
    imgScytheAL6.resize(300, 300);

    imgScytheAL7 = loadImage("scythe attack 7l.png");
    imgScytheAL7.resize(300, 300);
    
    imgScytheAL8 = loadImage("scythe attack 8l.png");
    imgScytheAL8.resize(300, 300);

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

    // Animations
    imgRightWalking[0] = imgWalkRight1;
    imgRightWalking[1] = imgWalkRight1;
    imgRightWalking[2] = imgWalkRight2;
    imgRightWalking[3] = imgWalkRight2;

    imgLeftWalking[0] = imgWalkLeft1;
    imgLeftWalking[1] = imgWalkLeft1;
    imgLeftWalking[2] = imgWalkLeft2;
    imgLeftWalking[3] = imgWalkLeft2;

    imgRightAttack[0] = imgScytheAR1;
    imgRightAttack[1] = imgScytheAR2;
    imgRightAttack[2] = imgScytheAR3;
    imgRightAttack[3] = imgScytheAR4;
    imgRightAttack[4] = imgScytheAR5;
    imgRightAttack[5] = imgScytheAR6;
    imgRightAttack[6] = imgScytheAR7;
    imgRightAttack[7] = imgScytheAR8;
    imgRightAttack[8] = imgScytheAR8;

    imgLeftAttack[0] = imgScytheAL1;
    imgLeftAttack[1] = imgScytheAL2;
    imgLeftAttack[2] = imgScytheAL3;
    imgLeftAttack[3] = imgScytheAL4;
    imgLeftAttack[4] = imgScytheAL5;
    imgLeftAttack[5] = imgScytheAL6;
    imgLeftAttack[6] = imgScytheAL7;
    imgLeftAttack[7] = imgScytheAL8;
    imgLeftAttack[8] = imgScytheAL8;

    imgPruneLeftMove[0] = imgPruneLeft1;
    imgPruneLeftMove[1] = imgPruneLeft2;
    imgPruneLeftMove[2] = imgPruneLeft1;
    imgPruneLeftMove[3] = imgPruneLeft2;
    imgPruneLeftMove[4] = imgPruneLeft1;
    imgPruneLeftMove[5] = imgPruneLeft2;
    imgPruneLeftMove[6] = imgPruneLeft1;
    imgPruneLeftMove[7] = imgPruneLeft2;
    imgPruneLeftMove[8] = imgPruneLeft1;

    imgPruneRightMove[0] = imgPruneRight1;
    imgPruneRightMove[1] = imgPruneRight2;
    imgPruneRightMove[2] = imgPruneRight1;
    imgPruneRightMove[3] = imgPruneRight2;
    imgPruneRightMove[4] = imgPruneRight1;
    imgPruneRightMove[5] = imgPruneRight2;
    imgPruneRightMove[6] = imgPruneRight1;
    imgPruneRightMove[7] = imgPruneRight2;
    imgPruneRightMove[8] = imgPruneRight1;
    
    frameRate(9);

    charKeys.add('d');

    intClickX.add(0);
    intClickY.add(0);

    for (int i = 0; i < pruneArmyX.length; i++) {
      pruneArmyX[i] = random(1000, 1400);
      pruneSpeed[i] = 10;
      pruneHealth[i] = 50;
    }
  }

  public void draw() {

    if(intLvl == 0){
      startMenu();
    }

    else if(intLvl == 1){
      firstLvl();
    }

    else if(intLvl == 2){
      tutLvl();
    }

    else if(intLvl == 3){
      galleryLvl();
    }

    else if(intLvl == 4){
      pauseMenu();
    }
  }

  public void keyPressed(){
    if(key == 'a'){
      blnLeft = true;
      blnAtk = false;
    }

    if(key == 'd'){
      blnRight = true;
      blnAtk = false;
    }

    if(key == ' '){
      blnJump = true;
    }
  }

  public void keyReleased(){
    if(key == 'a'){
      blnLeft = false;
      blnAtk = false;
    }

    if(key == 'd'){
      blnRight = false;
      blnAtk = false;
    }

    if(key == ' '){
      blnJump = false;
    }
  }

  public void mousePressed(){
    if(intLvl > 0){
      blnAtk = true;
    }

    intClickX.add(mouseX);
    intClickY.add(mouseY);
  }

  public void startMenu(){
    image(imgMenu, 0, 0);

    if(mouseX >= 660 && mouseX <= 840){
      if(mouseY >= 320 && mouseY <= 400){
        image(imgStart, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 660 && intClickX.get(intClickX.size() - 1) <= 840){
          if(intClickY.get(intClickY.size() - 1) >= 320 && intClickY.get(intClickY.size() - 1) <= 400){
            intLvl = 1;
          }
        }
      }
    }

    if(mouseX >= 620 && mouseX <= 890){
      if(mouseY >= 460 && mouseY <= 540){
        image(imgTut, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 620 && intClickX.get(intClickX.size() - 1) <= 890){
          if(intClickY.get(intClickY.size() - 1) >= 460 && intClickY.get(intClickY.size() - 1) <= 540){
            intLvl = 2;
          }
        }
      }
    }

    if(mouseX >= 630 && mouseX <= 870){
      if(mouseY >= 600 && mouseY <= 680){
        image(imgGal, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 630 && intClickX.get(intClickX.size() - 1) <= 870){
          if(intClickY.get(intClickY.size() - 1) >= 600 && intClickY.get(intClickY.size() - 1) <= 680){
            intLvl = 3;
          }
        }
      }
    }
  }

  public void firstLvl(){
    image(imgBackground, 0, 0);

    for(int i = 0; i < 10; i++){
      image(imgHeart, 10 + (60 * i), 10);
    }

    if(blnRight && intCharX <= 1350){
      intFrame++;
      intFrame %= imgRightWalking.length;
      
      if(!blnAtk){
        image(imgScytheRestRight, intCharX - 80, intCharY);
      }

      image(imgRightWalking[intFrame], intCharX, intCharY);
      intCharX += intSpeedX;
      blnAtk = false;

      charKeys.add('d');
    }

    else if(blnLeft && intCharX >= -50){
      intFrame++;
      intFrame %= imgLeftWalking.length;

      if(!blnAtk){
        image(imgScytheRestLeft, intCharX + 80, intCharY);
      }

      image(imgLeftWalking[intFrame], intCharX, intCharY);
      intCharX -= intSpeedX;
      blnAtk = false;

      charKeys.add('a');
    }

    else{
      if(charKeys.get(charKeys.size() - 1) == 'd'){
        if(!blnAtk){
          image(imgScytheRestRight, intCharX - 80, intCharY);
        }

        image(imgStandRight, intCharX, intCharY); 
      }
      
      else if(charKeys.get(charKeys.size() - 1) == 'a'){
        if(!blnAtk){
          image(imgScytheRestLeft, intCharX + 80, intCharY);
        }

        image(imgStandLeft, intCharX, intCharY);
      }
    }

    prune();

    if(blnAtk){
      if(charKeys.get(charKeys.size() - 1) == 'd'){
        intFrame++;
        intFrame %= imgRightAttack.length;
        image(imgRightAttack[intFrame], intCharX - 10, intCharY - 30);

        if(intFrame == 8){
          blnAtk = false;
        }
      }

      else if(charKeys.get(charKeys.size() - 1) == 'a'){
        intFrame++;
        intFrame %= imgLeftAttack.length;
        image(imgLeftAttack[intFrame], intCharX - 90, intCharY - 30);

        if(intFrame == 8){
          blnAtk = false;
        }
      }
    }
  }

  public void tutLvl(){
    image(imgBackground, 0, 0);
  }

  public void galleryLvl(){
    image(imgBackground, 0, 0);
  }

  public void pauseMenu(){

  }

  public void prune(){
    intPruneFrame++;
    intPruneFrame %= imgPruneLeftMove.length;

    for(int i = 0; i < pruneArmyX.length; i++){
      // Left or right facing
      if(pruneSpeed[i] > 0){
        image(imgPruneLeftMove[intPruneFrame], pruneArmyX[i], 550);
        pruneArmyX[i] -= pruneSpeed[i];
      }

      else{
        image(imgPruneRightMove[intPruneFrame], pruneArmyX[i], 550);
        pruneArmyX[i] -= pruneSpeed[i];
      }

      // Keeps prune in bounds
      if(pruneArmyX[i] <= -10 || pruneArmyX[i] >= 1400){
        pruneSpeed[i] = pruneSpeed[i] * -1;
      }

      // Left or right animation
      if(pruneArmyX[i] >= intCharX + 20 && pruneArmyX[i] <= intCharX + 100 && pruneSpeed[i] > 0){
        image(imgPruneLeftAtk, pruneArmyX[i], 550);
      }

      else if(pruneArmyX[i] >= intCharX - 50 && pruneArmyX[i] <= intCharX + 50 && pruneSpeed[i] < 0){
        image(imgPruneRightAtk, pruneArmyX[i], 550);
      }

      // Losing hearts
      if(pruneArmyX[i] >= intCharX + 15 && pruneArmyX[i] <= intCharX + 20 || pruneArmyX[i] >= intCharX - 15 && pruneArmyX[i] <= intCharX - 20){
        intLives--; 
      }

      image(imgLostHeart, 10 + (60 * (1 + intLives)), 10);
    }
  }
}
