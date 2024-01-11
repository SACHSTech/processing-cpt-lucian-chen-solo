import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  PImage imgBackground;

  PImage imgMenu;
  PImage imgStart;
  PImage imgTut;
  PImage imgGal;

  PImage imgGameOver;
  PImage imgOverMenu;
  PImage imgOverRestart;

  PImage imgPause;
  PImage imgRestart;
  PImage imgResume;
  PImage imgPMenu;

  PImage imgHeart;

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

  float fltCharJumpX;
  float fltCharJumpY;

  float fltAngle = 0;

  int intLives = 10;

  boolean blnRight = false;
  boolean blnLeft = false;
  boolean blnJump = false;

  boolean blnAtk = false;

  PImage[] imgRightWalking = new PImage[4];
  PImage[] imgLeftWalking = new PImage[4];

  PImage[] imgRightAttack = new PImage[9];
  PImage[] imgLeftAttack = new PImage[9];

  float[] pruneArmyX = new float[5];
  float[] pruneArmyY = new float[5];
  int[] pruneSpeed = new int[5];
  float[] pruneHealth = new float[5];
  boolean[] blnDrawPrune = new boolean[5];

  PImage[] imgPruneLeftMove = new PImage[9];
  PImage[] imgPruneRightMove = new PImage[9];

  float[] fltSpawn = new float[5];

  int intFrame = 0;
  int intAtkFrame = 0;
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

    imgGameOver = loadImage("game over.png");

    imgOverMenu = loadImage("over menu select.png");

    imgOverRestart = loadImage("over restart select.png");

    imgPause = loadImage("paused.png");

    imgResume = loadImage("resume select.png");

    imgRestart = loadImage("restart select.png");

    imgPMenu = loadImage("menu select.png");

    imgHeart = loadImage("heart.png");
    imgHeart.resize(50, 50);

    // Prune
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

    // Right
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

    // Character
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

    // Sets the starting location, speed, and health of all prunes
    for (int i = 0; i < pruneArmyX.length; i++) {
      pruneArmyX[i] = -1000;
      pruneArmyY[i] = 550;
      pruneSpeed[i] = 10;
      pruneHealth[i] = 100;
      blnDrawPrune[i] = false;
    }
  }

  public void draw() {  
    if(intLvl == 0){
      startMenu();
    }

    else if(intLvl == 1){
      gameLvl();

      intClickX.add(0);
      intClickY.add(0);
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

    if(intLives <= 0){
      gameOver();
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

    if(key == 'j'){
      blnJump = true;
      blnAtk = false;
    }

    // Return to menu
    if((intLvl == 2 || intLvl == 3) && key == 'x'){
      intLvl = 0;
      intClickX.add(0);
      intClickY.add(0);
    }

    // Pause
    if(intLvl == 1 && key == 'x'){
      intLvl = 4;
      intClickX.add(0);
      intClickY.add(0);
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

    if(key == 'j'){
      blnJump = false;
      blnAtk = false;
    }
  }

  public void mousePressed(){
    if(intLvl == 1){
      blnAtk = true;
    }

    intClickX.add(mouseX);
    intClickY.add(mouseY);
  }

  public void startMenu(){
    image(imgMenu, 0, 0);

    // Start
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

    // Tutorial 
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

    // Gallery 
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

  public void gameLvl(){
    image(imgBackground, 0, 0);

    for(int i = 0; i < intLives; i++){
      image(imgHeart, 10 + (60 * i), 10);
    }

    // Character movement
    if(blnRight && intCharX <= 1350){
      intFrame++;
      intFrame %= imgRightWalking.length;
      
      if(!blnAtk){
        image(imgScytheRestRight, intCharX - 80, intCharY);
        intAtkFrame = 0;
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
        intAtkFrame = 0;
      }

      image(imgLeftWalking[intFrame], intCharX, intCharY);
      intCharX -= intSpeedX;
      blnAtk = false;

      charKeys.add('a');
    }

    else if(blnJump){
      System.out.println(intCharY);
      System.out.println(fltAngle);

      image(imgStandRight, intCharX, intCharY);
      fltCharJumpX = fltAngle; 
      fltCharJumpY = (float) (Math.pow(fltAngle, 2) - (3 * fltAngle));

      intCharX += fltCharJumpX;
      intCharY += fltCharJumpY;

      fltAngle += 0.1;

      if(fltAngle > 4.7){
        fltAngle = 0;
      }
    }

    // Character resting
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

    // prune();

    // Attack animation
    if(blnAtk){
      if(charKeys.get(charKeys.size() - 1) == 'd'){
        intAtkFrame++;
        intAtkFrame %= imgRightAttack.length;
        image(imgRightAttack[intAtkFrame], intCharX - 10, intCharY - 30);

        if(intAtkFrame == 8){
          blnAtk = false;
        }
      }

      else if(charKeys.get(charKeys.size() - 1) == 'a'){
        intAtkFrame++;
        intAtkFrame %= imgLeftAttack.length;
        image(imgLeftAttack[intAtkFrame], intCharX - 90, intCharY - 30);

        if(intAtkFrame == 8){
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
    image(imgPause, 0, 0);

    // Resume
    if(mouseX >= 615 && mouseX <= 885){
      if(mouseY >= 370 && mouseY <= 450){
        image(imgResume, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 615 && intClickX.get(intClickX.size() - 1) <= 885){
          if(intClickY.get(intClickY.size() - 1) >= 370 && intClickY.get(intClickY.size() - 1) <= 450){
            intLvl = 1;
          }
        }
      }
    }

    // Restart
    if(mouseX >= 620 && mouseX <= 880){
      if(mouseY >= 500 && mouseY <= 580){
        image(imgRestart, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 620 && intClickX.get(intClickX.size() - 1) <= 880){
          if(intClickY.get(intClickY.size() - 1) >= 500 && intClickY.get(intClickY.size() - 1) <= 580){
            intCharX = 50;
            intLives = 10;
            intLvl = 1;

            charKeys.add('d');

            for (int i = 0; i < pruneArmyX.length; i++) {
              pruneArmyX[i] = -1000;
              pruneHealth[i] = 100;
              blnDrawPrune[i] = false;

              fltSpawn[i] = random(2);

              if(fltSpawn[i] < 0.05){
                blnDrawPrune[i] = true;
                pruneArmyX[i] = random(1000, 1500);
              }
            }
          }
        }
      }
    }

    // Menu
    if(mouseX >= 640 && mouseX <= 860){
      if(mouseY >= 630 && mouseY <= 710){
        image(imgPMenu, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 640 && intClickX.get(intClickX.size() - 1) <= 860){
          if(intClickY.get(intClickY.size() - 1) >= 630 && intClickY.get(intClickY.size() - 1) <= 710){
            intLives = 10;
            intCharX = 50;            
            intLvl = 0;

            charKeys.add('d');

            intClickX.add(0);
            intClickY.add(0);

            for (int i = 0; i < pruneArmyX.length; i++) {
              pruneArmyX[i] = -1000;
              pruneHealth[i] = 100;
              blnDrawPrune[i] = false;

              fltSpawn[i] = random(2);

              if(fltSpawn[i] < 0.05){
                blnDrawPrune[i] = true;
                pruneArmyX[i] = random(1000, 1500);
              }
            }
          }
        }
      }
    }
  }

  public void gameOver(){
    intLvl = 5;
    
    image(imgGameOver, 0 , 0);
  
    // Restart
    if(mouseX >= 620 && mouseX <= 880){
      if(mouseY >= 440 && mouseY <= 520){
        image(imgOverRestart, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 620 && intClickX.get(intClickX.size() - 1) <= 880){
          if(intClickY.get(intClickY.size() - 1) >= 440 && intClickY.get(intClickY.size() - 1) <= 520){            
            intLives = 10;
            intCharX = 50;            
            intLvl = 1;

            charKeys.add('d');

            for (int i = 0; i < pruneArmyX.length; i++) {
              pruneArmyX[i] = -1000;
              pruneHealth[i] = 100;
              blnDrawPrune[i] = false;

              fltSpawn[i] = random(2);

              if(fltSpawn[i] < 0.05){
                blnDrawPrune[i] = true;
                pruneArmyX[i] = random(1000, 1500);
              }
            }
          }
        }
      }
    }

    // Menu
    if(mouseX >= 640 && mouseX <= 860){
      if(mouseY >= 570 && mouseY <= 650){
        image(imgOverMenu, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 640 && intClickX.get(intClickX.size() - 1) <= 860){
          if(intClickY.get(intClickY.size() - 1) >= 570 && intClickY.get(intClickY.size() - 1) <= 650){
            intLives = 10;
            intCharX = 50;            
            intLvl = 0;

            charKeys.add('d');

            intClickX.add(0);
            intClickY.add(0);

            for (int i = 0; i < pruneArmyX.length; i++) {
              pruneArmyX[i] = -1000;
              pruneHealth[i] = 100;
              blnDrawPrune[i] = false;

              fltSpawn[i] = random(2);

              if(fltSpawn[i] < 0.05){
                blnDrawPrune[i] = true;
                pruneArmyX[i] = random(1000, 1500);
              }
            }
          }
        }
      }
    }
  }

  // All interactions with prunes
  public void prune(){
    intPruneFrame++;
    intPruneFrame %= imgPruneLeftMove.length;

    for(int i = 0; i < pruneArmyX.length; i++){
      // Prune healthbar
      stroke(255);
      fill(135, 219, 121);

      if(pruneHealth[i] == 0){
        noStroke();
      }

      rect(pruneArmyX[i] + 15, pruneArmyY[i], 1 * pruneHealth[i], 25);

      // Prune health lose
      if(charKeys.get(charKeys.size() - 1) == 'd' && blnAtk){
        if(((intCharX + 200 >= pruneArmyX[i] - 10) && (intCharX + 250 <= pruneArmyX[i] + 140)) && pruneHealth[i] > 0 && intAtkFrame == 1){
          pruneHealth[i] = pruneHealth[i] - 10;
          pruneArmyX[i] = pruneArmyX[i] + 70;
        }
      }

      if(charKeys.get(charKeys.size() - 1) == 'a' && blnAtk){
        if(((intCharX - 50 >= pruneArmyX[i] - 10) && (intCharX <= pruneArmyX[i] + 140)) && pruneHealth[i] > 0 && intAtkFrame == 1){
          pruneHealth[i] = pruneHealth[i] - 10;
          pruneArmyX[i] = pruneArmyX[i] - 70;
        }
      }

      if(pruneHealth[i] <= 0){
        blnDrawPrune[i] = false;
      }

      // Checks to see if prune should be drawm
      if(blnDrawPrune[i]){
        // Left or right facing
        if(pruneSpeed[i] > 0){
          image(imgPruneLeftMove[intPruneFrame], pruneArmyX[i], pruneArmyY[i]);
          pruneArmyX[i] -= pruneSpeed[i];
        }

        else{
          image(imgPruneRightMove[intPruneFrame], pruneArmyX[i], pruneArmyY[i]);
          pruneArmyX[i] -= pruneSpeed[i];
        }
      
        // Left or right animation
        if(pruneArmyX[i] >= intCharX + 20 && pruneArmyX[i] <= intCharX + 100 && pruneSpeed[i] > 0){
          image(imgPruneLeftAtk, pruneArmyX[i], pruneArmyY[i]);
        }

        else if(pruneArmyX[i] >= intCharX - 50 && pruneArmyX[i] <= intCharX + 50 && pruneSpeed[i] < 0){
          image(imgPruneRightAtk, pruneArmyX[i], pruneArmyY[i]);
        }
      }

      // Draws prune by chance
      else{
        fltSpawn[i] = random(2);

        if(fltSpawn[i] < 0.05){
          blnDrawPrune[i] = true;
          pruneArmyX[i] = random(1000, 1500);
        }

        else{
          pruneArmyX[i] = -1000;
        }
      }

      // Keeps prune in bounds and hones the player
      if(pruneArmyX[i] <= -20 || pruneArmyX[i] >= 1400){
        pruneSpeed[i] = pruneSpeed[i] * -1;
      }

      if(pruneArmyX[i] <= intCharX - 100){
        pruneSpeed[i] = -10;
      }

      if(pruneArmyX[i] >= intCharX + 150){
        pruneSpeed[i] = 10;
      }
      
      // Losing hearts
      if((pruneArmyX[i] + 70) >= intCharX + 90 && (pruneArmyX[i] + 70) <= intCharX + 100){
        intLives--; 
      }
    }
  }
}
