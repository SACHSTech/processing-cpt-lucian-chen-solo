import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Backgrounds
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
  PImage imgPauseMenu;

  PImage imgPauseText;

  PImage imgWin;
  PImage imgAgain;
  PImage imgWinMenu;

  // Tutorial text
  PImage imgTutText1;
  PImage imgTutText2;
  PImage imgTutText3;
  PImage imgTutText4;
  PImage imgTutText5;
  PImage imgTutText6;
  PImage imgTutText7;
  PImage imgTutText8;
  PImage imgTutText9;
  PImage imgTutText10;
  PImage imgTutText11;

  PImage imgXReturn;
  PImage imgClickCont;

  // Gallery 
  PImage imgGallery1;
  PImage imgGallery2;
  PImage imgGallery3;

  // Lives
  PImage imgHeart;

  // Prune
  PImage imgPruneLeft1;
  PImage imgPruneLeft2;
  PImage imgPruneLeftAtk;

  PImage imgPruneRight1;
  PImage imgPruneRight2;
  PImage imgPruneRightAtk;

  // Jelly
  PImage imgJellyBody;
  PImage imgJellyLegs1;
  PImage imgJellyLegs2;
  PImage imgJellyAtk;

  // Bird and egg
  PImage imgBirdRight1;
  PImage imgBirdRight2; 
  PImage imgBirdLeft1;
  PImage imgBirdLeft2;
  PImage imgEgg;

  // Scythe
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

  // Character movement
	PImage imgStandRight;
  PImage imgWalkRight1;
  PImage imgWalkRight2;

  PImage imgStandLeft;
  PImage imgWalkLeft1;
  PImage imgWalkLeft2;

  // Character variables
  int intCharX = 50;
  int intCharY = 500;
  int intSpeedX = 15;

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
   
  // Prune variables
  int intNumPrune = 2;

  float[] fltPruneArmyX = new float[intNumPrune];
  float[] fltPruneArmyY = new float[intNumPrune];
  int[] intPruneSpeed = new int[intNumPrune];
  int[] intPruneHealth = new int[intNumPrune];
  boolean[] blnDrawPrune = new boolean[intNumPrune];
  boolean blnPruneDone = false;

  PImage[] imgPruneLeftMove = new PImage[9];
  PImage[] imgPruneRightMove = new PImage[9];

  int[] pruneAtkCooldown = new int[intNumPrune];
  int[] pruneAtkInterval = new int [intNumPrune];

  int[] pruneSpawnCooldown = new int[intNumPrune];
  int pruneSpawnInterval = 1000;

  int intPrunesKilled = 0;

  float fltTutPruneX = 1100;

  // Jelly variables
  int intNumJelly = 3;

  float[] fltJellyArmyX = new float[intNumJelly];
  float[] fltJellyArmyY = new float[intNumJelly];
  int[] intJellySpeed = new int[intNumJelly];
  int[] intJellyHealth = new int[intNumJelly];
  boolean[] blnDrawJelly = new boolean[intNumJelly];
  boolean blnJellyDone = false;

  PImage[] imgJellyMove = new PImage[9];

  int[] jellyAtkCooldown = new int[intNumJelly];
  int[] jellyAtkInterval = new int [intNumJelly];

  int[] jellySpawnCooldown = new int[intNumJelly];
  int jellySpawnInterval = 1500;

  int intJelliesKilled = 0;

  float fltTutJellyX = 1350;

  // Bird & egg variables
  float fltBirdX = 1500;
  float fltBirdY = 120;

  float fltBirdAngle = -3;

  PImage[] imgBirdRightMove = new PImage[9];
  PImage[] imgBirdLeftMove = new PImage[9];

  int intEggY = 200;

  int eggAtkCooldown = 1000;
  int eggAtkInterval = 0;

  // Frames
  int intCharFrame = 0;
  int intAtkFrame = 0;
  int intPruneFrame = 0;
  int intJellyFrame = 0;
  int intBirdFrame = 0;

  // Arraylists
  ArrayList<Character> charKeys = new ArrayList<Character>();
  ArrayList<Integer> intClickX = new ArrayList<Integer>();
  ArrayList<Integer> intClickY = new ArrayList<Integer>();

  // Level
  int intLvl = 0;
  int intTextNum = 0;
  int intGalleryPage = 0;

  public void settings() {
    size(1500, 750);
  }

  public void setup() {
    // Backgrounds
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

    imgPauseMenu = loadImage("menu select.png");

    imgWin = loadImage("win.png");

    imgAgain = loadImage("win again select.png");

    imgWinMenu = loadImage("win menu select.png");

    imgPauseText = loadImage("pauseText.png");

    // Tutorial
    imgTutText1 = loadImage("tutorialText1.png");

    imgTutText2 = loadImage("tutorialText2.png");

    imgTutText3 = loadImage("tutorialText3.png");

    imgTutText4 = loadImage("tutorialText4.png");

    imgTutText5 = loadImage("tutorialText5.png");

    imgTutText6 = loadImage("tutorialText6.png");

    imgTutText7 = loadImage("tutorialText7.png");

    imgTutText8 = loadImage("tutorialText8.png");

    imgTutText9 = loadImage("tutorialText9.png");

    imgTutText10 = loadImage("tutorialText10.png");

    imgTutText11 = loadImage("tutorialText11.png");

    imgClickCont = loadImage("clickContinue.png");

    imgXReturn = loadImage("XReturn.png");

    // Gallery
    imgGallery1 = loadImage("gallery1.png");

    imgGallery2 = loadImage("gallery2.png");

    imgGallery3 = loadImage("gallery3.png");

    // Lives
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

    // Jelly
    imgJellyBody = loadImage("jelly body.png");
    imgJellyBody.resize(150, 150);

    imgJellyLegs1 = loadImage("jelly legs1.png");
    imgJellyLegs1.resize(150, 150);

    imgJellyLegs2 = loadImage("jelly legs2.png");
    imgJellyLegs2.resize(150, 150);

    imgJellyAtk = loadImage("jellyAtk.png");
    imgJellyAtk.resize(150, 150);

    // Bird
    imgBirdRight1 = loadImage("birdRight1.png");
    imgBirdRight1.resize(150, 150);

    imgBirdRight2 = loadImage("birdRight2.png");
    imgBirdRight2.resize(150, 150);

    imgBirdLeft1 = loadImage("birdLeft1.png");
    imgBirdLeft1.resize(150, 150);

    imgBirdLeft2 = loadImage("birdLeft2.png");
    imgBirdLeft2.resize(150, 150);

    imgEgg = loadImage("egg.png");
    imgEgg.resize(50, 50);

    // Scythe rest
    imgScytheRestRight = loadImage("scythe rest right.png");
    imgScytheRestRight.resize(200, 200);

    imgScytheRestLeft = loadImage("scythe rest left.png");
    imgScytheRestLeft.resize(200, 200);

    // Scythe right
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

    // Scythe left
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
    // Character
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

    // Prune
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

    // Jelly
    imgJellyMove[0] = imgJellyLegs1;
    imgJellyMove[1] = imgJellyLegs2;
    imgJellyMove[2] = imgJellyLegs1;
    imgJellyMove[3] = imgJellyLegs2;
    imgJellyMove[4] = imgJellyLegs1;
    imgJellyMove[5] = imgJellyLegs2;
    imgJellyMove[6] = imgJellyLegs1;
    imgJellyMove[7] = imgJellyLegs2;
    imgJellyMove[8] = imgJellyLegs1;

    // Bird
    imgBirdRightMove[0] = imgBirdRight1;
    imgBirdRightMove[1] = imgBirdRight2;
    imgBirdRightMove[2] = imgBirdRight1;
    imgBirdRightMove[3] = imgBirdRight2;
    imgBirdRightMove[4] = imgBirdRight1;
    imgBirdRightMove[5] = imgBirdRight2;
    imgBirdRightMove[6] = imgBirdRight1;
    imgBirdRightMove[7] = imgBirdRight2;
    imgBirdRightMove[8] = imgBirdRight1;

    imgBirdLeftMove[0] = imgBirdLeft1;
    imgBirdLeftMove[1] = imgBirdLeft2;
    imgBirdLeftMove[2] = imgBirdLeft1;
    imgBirdLeftMove[3] = imgBirdLeft2;
    imgBirdLeftMove[4] = imgBirdLeft1;
    imgBirdLeftMove[5] = imgBirdLeft2;
    imgBirdLeftMove[6] = imgBirdLeft1;
    imgBirdLeftMove[7] = imgBirdLeft2;
    imgBirdLeftMove[8] = imgBirdLeft1;
    
    frameRate(9);

    // Initializing arraylists
    charKeys.add('d');

    intClickX.add(0);
    intClickY.add(0);

    // Sets the starting location, speed, and health of all prunes
    for (int i = 0; i < fltPruneArmyX.length; i++) {
      fltPruneArmyX[i] = -1000;
      fltPruneArmyY[i] = 550;
      intPruneSpeed[i] = 10;
      intPruneHealth[i] = 100;

      pruneAtkCooldown[i] = 1500;
      pruneAtkInterval[i] = 0;

      pruneSpawnCooldown[i] = 4000;

      blnDrawPrune[i] = false;
    }

    // Sets the starting location, speed, and health of all jellies
    for (int i = 0; i < fltJellyArmyX.length; i++) {
      fltJellyArmyX[i] = -1000;
      fltJellyArmyY[i] = 550;
      intJellySpeed[i] = 15;
      intJellyHealth[i] = 70;

      jellyAtkCooldown[i] = 1500;
      jellyAtkInterval[i] = 0;

      jellySpawnCooldown[i] = 3000;

      blnDrawJelly[i] = false;
    }
  }

  /**
   * Method that calls other methods based on the level
   * @author: L. Chen
   */
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

    if(intLives <= 0 && (intLvl == 1 || intLvl == 5)){
      gameOver();
    }

    if(blnPruneDone && blnJellyDone){
      youWin();
    }
  }

  /**
   * Method that determines what happens when keys are pressed
   * @author: L. Chen
   */
  public void keyPressed(){
    if(key == 'a'){
      blnLeft = true;
      blnAtk = false;
      blnJump = false;
    }

    if(key == 'd'){
      blnRight = true;
      blnAtk = false;
      blnJump = false;
    }

    if(key == ' '){
      blnJump = true;
      blnAtk = false;
    }

    // Return to menu
    if((intLvl == 2 || intLvl == 3) && key == 'x'){
      intLvl = 0;
      reset(); 

      intClickX.add(0);
      intClickY.add(0);
    }

    // Pause
    if(intLvl == 1 && key == 'x'){
      intLvl = 4;
      intClickX.add(0);
      intClickY.add(0);
    }

    // Gallery
    if(keyCode == RIGHT && intGalleryPage == 0){
      intGalleryPage = 1;
    }

    else if(keyCode == RIGHT && intGalleryPage == 1){
      intGalleryPage = 2;
    }

    if(keyCode == LEFT && intGalleryPage == 2){
      intGalleryPage = 1;
    }

    else if(keyCode == LEFT && intGalleryPage == 1){
      intGalleryPage = 0;
    }
  }

  /**
   * Method that determines what happens when keys are released
   * @author: L. Chen
   */
  public void keyReleased(){
    if(key == 'a'){
      blnLeft = false;
      blnAtk = false;
    }

    if(key == 'd'){
      blnRight = false;
      blnAtk = false;
    }
  }

  /**
   * Method that determines what happens when mouse is pressed
   * @author: L. Chen
   */
  public void mousePressed(){
    if(intLvl == 1 || intLvl == 2){
      blnAtk = true;
    }

    intClickX.add(mouseX);
    intClickY.add(mouseY);

    if(intTextNum == 2){
      intTextNum = 3;
    }

    else if(intTextNum == 3){
      intTextNum = 4;
    }

    else if(intTextNum == 4){
      intTextNum = 5;
    }

    else if(intTextNum == 5){
      intTextNum = 6;
    }

    else if(intTextNum == 9){
      intTextNum = 6;
      intLives = 10;
    }
  }

  /**
   * Method that runs the start menu
   * @author: L. Chen
   */
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

  /**
   * Method that runs the game level
   * @author: L. Chen
   */
  public void gameLvl(){
    image(imgBackground, 0, 0);

    for(int i = 0; i < intLives; i++){
      image(imgHeart, 10 + (60 * i), 10);
    }
 
    // Character movement
    if(blnRight && intCharX <= 1350){
      intCharFrame++;
      intCharFrame %= imgRightWalking.length;
      
      if(!blnAtk){
        image(imgScytheRestRight, intCharX - 80, intCharY);
        intAtkFrame = 0;
      }

      image(imgRightWalking[intCharFrame], intCharX, intCharY);
      intCharX += intSpeedX;
      blnAtk = false;

      fltAngle = 0;
      intCharY = 500;

      charKeys.add('d');
    }

    else if(blnLeft && intCharX >= -50){
      intCharFrame++;
      intCharFrame %= imgLeftWalking.length;

      if(!blnAtk){
        image(imgScytheRestLeft, intCharX + 80, intCharY);
        intAtkFrame = 0;
      }

      image(imgLeftWalking[intCharFrame], intCharX, intCharY);
      intCharX -= intSpeedX;
      blnAtk = false;

      fltAngle = 0;
      intCharY = 500;

      charKeys.add('a');
    }

    else if(blnJump){
      if(charKeys.get(charKeys.size() - 1) == 'd'){
        image(imgScytheRestRight, intCharX - 80, intCharY);
        image(imgStandRight, intCharX, intCharY);

        fltCharJumpX = fltAngle + 5; 
        fltCharJumpY = (float) (Math.pow(fltAngle, 2) - (4 * fltAngle)) - 20;

        intCharX += fltCharJumpX;
        intCharY += fltCharJumpY;
      }

      else if(charKeys.get(charKeys.size() - 1) == 'a'){
        image(imgScytheRestLeft, intCharX + 80, intCharY);
        image(imgStandLeft, intCharX, intCharY);

        fltCharJumpX = fltAngle + 5; 
        fltCharJumpY = (float) (Math.pow(fltAngle, 2) - (4 * fltAngle)) - 20;

        intCharX -= fltCharJumpX;
        intCharY += fltCharJumpY;
      }

      fltAngle += 1;
      blnAtk = false;

      // Resets jump
      if(fltAngle > 11){
        intCharY = 500;
        fltAngle = 0;
        blnJump = false;
      }

      // Keeps character in bounds when jumping
      if(intCharX <= -50 || intCharX >= 1350){
        intCharY = 500;
        fltAngle = 0;
        blnJump = false;
      }
    }

    // Character resting
    else{
      intCharY = 500; 
      fltAngle = 0;
      blnJump = false;

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

    // Enemies
    if(intPrunesKilled < 7){
      prune();
    }

    else{
      blnPruneDone = true;
    }

    if(intJelliesKilled < 9){
      jelly();
    }

    else{
      blnJellyDone = true;
    }
    
    egg();
    bird();
    
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

    image(imgPauseText, 0, 0);
  }

  /**
   * Method that runs the tutorial
   * @author: L. Chen
   */
  public void tutLvl(){
    image(imgBackground, 0, 0);
    image(imgXReturn, 0, 0);

    // Character movement
    if(blnRight && intCharX <= 1350){
      intCharFrame++;
      intCharFrame %= imgRightWalking.length;
      
      if(!blnAtk){
        image(imgScytheRestRight, intCharX - 80, intCharY);
        intAtkFrame = 0;
      }

      image(imgRightWalking[intCharFrame], intCharX, intCharY);
      intCharX += intSpeedX;
      blnAtk = false;

      fltAngle = 0;
      intCharY = 500;

      charKeys.add('d');
    }

    else if(blnLeft && intCharX >= -50){
      intCharFrame++;
      intCharFrame %= imgLeftWalking.length;

      if(!blnAtk){
        image(imgScytheRestLeft, intCharX + 80, intCharY);
        intAtkFrame = 0;
      }

      image(imgLeftWalking[intCharFrame], intCharX, intCharY);
      intCharX -= intSpeedX;
      blnAtk = false;

      fltAngle = 0;
      intCharY = 500;

      charKeys.add('a');
    }

    else if(blnJump){
      if(charKeys.get(charKeys.size() - 1) == 'd'){
        image(imgScytheRestRight, intCharX - 80, intCharY);
        image(imgStandRight, intCharX, intCharY);

        fltCharJumpX = fltAngle + 5; 
        fltCharJumpY = (float) (Math.pow(fltAngle, 2) - (4 * fltAngle)) - 20;

        intCharX += fltCharJumpX;
        intCharY += fltCharJumpY;
      }

      else if(charKeys.get(charKeys.size() - 1) == 'a'){
        image(imgScytheRestLeft, intCharX + 80, intCharY);
        image(imgStandLeft, intCharX, intCharY);

        fltCharJumpX = fltAngle + 5; 
        fltCharJumpY = (float) (Math.pow(fltAngle, 2) - (4 * fltAngle)) - 20;

        intCharX -= fltCharJumpX;
        intCharY += fltCharJumpY;
      }

      fltAngle += 1;
      blnAtk = false;

      // Resets jump
      if(fltAngle > 11){
        intCharY = 500;
        fltAngle = 0;
        blnJump = false;
      }

      // Keeps character in bounds when jumping
      if(intCharX <= -50 || intCharX >= 1350){
        intCharY = 500;
        fltAngle = 0;
        blnJump = false;
      }
    }

    // Character resting
    else{
      intCharY = 500; 
      fltAngle = 0;
      blnJump = false;

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

    if(intTextNum == 0){
      image(imgTutText2, 0, 0);

      if(blnRight || blnLeft){
        intTextNum = 1;
      }
    }

    else if(intTextNum == 1){
      image(imgTutText3, 0, 0);
      if(blnJump){
        intTextNum = 2;
      }
    }

    else if(intTextNum == 2){
      image(imgTutText4, 0, 0);
    }

    else if(intTextNum == 3){
      image(imgTutText5, 0, 0);
      image(imgClickCont, 0, 0);
    }

    else if(intTextNum == 4){
      image(imgTutText6, 0, 0);
      image(imgClickCont, 0, 0);
    }

    else if(intTextNum == 5){
      image(imgTutText7, 0, 0);
      image(imgClickCont, 0, 0);
      
      image(imgPruneLeft1, 1100, 550);
      image(imgJellyLegs1, 1350, 550);
      image(imgJellyBody, 1350, 550);
    }

    else if(intTextNum == 6){
      image(imgTutText8, 0, 0);
      tutPrune();
      tutJelly();

      if(blnRight || blnLeft){
        intTextNum = 7;
      }
    }

    else if(intTextNum == 7){
      if(intPruneHealth[0] == 100 && intJellyHealth[0] == 70){
        image(imgTutText9, 0, 0);
      }

      tutPrune();
      tutJelly();

      if(intPruneHealth[0] <= 0 && intJellyHealth[0] <= 0){
        intTextNum = 8;
      }
    }

    else if(intTextNum == 8){
      image(imgTutText10, 0, 0);

      tutPrune();
      tutJelly();
    }

    // Resets if plater died in tutorial
    if(intLives == 0){
      intTextNum = 9;

      image(imgTutText11, 0, 0);
      image(imgClickCont, 0, 0);

      intCharX = 50;
      intCharY = 500;
      blnAtk = false;
      blnJump = false;

      fltTutPruneX = 1100;
      fltTutJellyX = 1350;
      
      charKeys.add('d');

      for (int i = 0; i < fltPruneArmyX.length; i++) {
        intPruneHealth[i] = 100;
        blnDrawPrune[i] = false;
      }

      for (int i = 0; i < fltJellyArmyX.length; i++) {
        intJellyHealth[i] = 70;
        blnDrawJelly[i] = false;
      }
    }

    image(imgTutText1, 0, 0);


    for(int i = 0; i < intLives; i++){
      image(imgHeart, 10 + (60 * i), 10);
    }
  }

  /**
   * Method that runs the gallery
   * @author: L. Chen
   */
  public void galleryLvl(){
    if(intGalleryPage == 0){
      image(imgGallery1, 0, 0);
    }

    else if(intGalleryPage == 1){
      image(imgGallery2, 0, 0);
    }

    else if(intGalleryPage == 2){
      image(imgGallery3, 0, 0);
    }

    image(imgXReturn, 0, 0);
  }

  /**
   * Method that runs the pause screen
   * @author: L. Chen
   */
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
            reset();
            intLvl = 1;
          }
        }
      }
    }

    // Menu
    if(mouseX >= 640 && mouseX <= 860){
      if(mouseY >= 630 && mouseY <= 710){
        image(imgPauseMenu, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 640 && intClickX.get(intClickX.size() - 1) <= 860){
          if(intClickY.get(intClickY.size() - 1) >= 630 && intClickY.get(intClickY.size() - 1) <= 710){
            reset();   
               
            intLvl = 0;
            intClickX.add(0);
            intClickY.add(0);
          }
        }
      }
    }
  }

  /**
   * Method that runs the game over screen
   * @author: L. Chen
   */
  public void gameOver(){
    intLvl = 5;

    image(imgGameOver, 0 , 0);
  
    // Restart
    if(mouseX >= 620 && mouseX <= 880){
      if(mouseY >= 440 && mouseY <= 520){
        image(imgOverRestart, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 620 && intClickX.get(intClickX.size() - 1) <= 880){
          if(intClickY.get(intClickY.size() - 1) >= 440 && intClickY.get(intClickY.size() - 1) <= 520){            
            reset();
            intLvl = 1;
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
            reset();   

            intLvl = 0;
            intClickX.add(0);
            intClickY.add(0);
          }
        }
      }
    }
  }

  /**
   * Method that runs the win screen
   * @author: L. Chen
   */
  public void youWin(){
    intLvl = 6;

    image(imgWin, 0, 0);

    // Play again
    if(mouseX >= 555 && mouseX <= 945){
      if(mouseY >= 440 && mouseY <= 550){
        image(imgAgain, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 555 && intClickX.get(intClickX.size() - 1) <= 945){
          if(intClickY.get(intClickY.size() - 1) >= 440 && intClickY.get(intClickY.size() - 1) <= 550){            
            reset();
            intLvl = 1;
          }
        }
      }
    }

    // Menu
    if(mouseX >= 640 && mouseX <= 860){
      if(mouseY >= 570 && mouseY <= 650){
        image(imgWinMenu, 0, 0);

        if(intClickX.get(intClickX.size() - 1) >= 640 && intClickX.get(intClickX.size() - 1) <= 860){
          if(intClickY.get(intClickY.size() - 1) >= 570 && intClickY.get(intClickY.size() - 1) <= 650){
            reset();   
               
            intLvl = 0;
            intClickX.add(0);
            intClickY.add(0);
          }
        }
      }
    }
  }

  /**
   * Method that resets levels and variables
   * @author: L. Chen
   */
  public void reset(){
    intLives = 10;
    intCharX = 50;
    intCharY = 500;
    blnAtk = false;
    blnJump = false;

    intPrunesKilled = 0;
    intJelliesKilled = 0;

    blnPruneDone = false;
    blnJellyDone = false;

    fltBirdAngle = -3;
    intEggY = 1000;

    intTextNum = 0;
    fltTutPruneX = 1100;
    fltTutJellyX = 1350;
    
    charKeys.add('d');

    for (int i = 0; i < fltPruneArmyX.length; i++) {
      fltPruneArmyX[i] = -1000;
      intPruneHealth[i] = 100;
      blnDrawPrune[i] = false;
    }

    for (int i = 0; i < fltJellyArmyX.length; i++) {
      fltJellyArmyX[i] = -1000;
      intJellyHealth[i] = 70;
      blnDrawJelly[i] = false;
    }

    intGalleryPage = 0;
  }

  /**
   * Method that contains all interactions with prunes 
   * @author: L. Chen
   */
  public void prune(){
    // Determines the frame of animation
    intPruneFrame++;
    intPruneFrame %= imgPruneLeftMove.length;

    for(int i = 0; i < fltPruneArmyX.length; i++){
      // Prune healthbar
      stroke(255);
      fill(135, 219, 121);

      if(intPruneHealth[i] == 0){
        noStroke();
      }

      rect(fltPruneArmyX[i] + 15, fltPruneArmyY[i], 1 * intPruneHealth[i], 25);

      // Prune health lose
      if(charKeys.get(charKeys.size() - 1) == 'd' && blnAtk){
        if(((intCharX + 200 >= fltPruneArmyX[i] - 10) && (intCharX + 250 <= fltPruneArmyX[i] + 140)) && intPruneHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          intPruneHealth[i] = intPruneHealth[i] - 10;
          fltPruneArmyX[i] = fltPruneArmyX[i] + 70;
        }
      }

      if(charKeys.get(charKeys.size() - 1) == 'a' && blnAtk){
        if(((intCharX - 50 >= fltPruneArmyX[i] - 10) && (intCharX <= fltPruneArmyX[i] + 140)) && intPruneHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          intPruneHealth[i] = intPruneHealth[i] - 10;
          fltPruneArmyX[i] = fltPruneArmyX[i] - 70;
        }
      }

      if(intPruneHealth[i] <= 0){
        blnDrawPrune[i] = false;

        if(millis() - pruneSpawnInterval > pruneSpawnCooldown[i]){
          intPrunesKilled++;
        }
      }

      // Checks to see if prune is drawn
      if(blnDrawPrune[i]){
        // Left or right facing
        if(intPruneSpeed[i] > 0){
          image(imgPruneLeftMove[intPruneFrame], fltPruneArmyX[i], fltPruneArmyY[i]);
          fltPruneArmyX[i] -= intPruneSpeed[i];
        }

        else{
          image(imgPruneRightMove[intPruneFrame], fltPruneArmyX[i], fltPruneArmyY[i]);
          fltPruneArmyX[i] -= intPruneSpeed[i];
        }
      
        // Left or right animation
        if(fltPruneArmyX[i] >= intCharX + 20 && fltPruneArmyX[i] <= intCharX + 100 && intPruneSpeed[i] > 0){
          image(imgPruneLeftAtk, fltPruneArmyX[i], fltPruneArmyY[i]);
        }

        else if(fltPruneArmyX[i] >= intCharX - 50 && fltPruneArmyX[i] <= intCharX + 50 && intPruneSpeed[i] < 0){
          image(imgPruneRightAtk, fltPruneArmyX[i], fltPruneArmyY[i]);
        }
      }

      // Spawns prunes in intervals
      else{
        fltPruneArmyX[i] = -1000;

        if(millis() - pruneSpawnInterval > pruneSpawnCooldown[i]){
          blnDrawPrune[i] = true;
          fltPruneArmyX[i] = random(1100, 1350);
          intPruneHealth[i] = 100;

          pruneSpawnInterval = millis();
        }

        if(intPrunesKilled >= 6){
          fltPruneArmyX[i] = -1000;
          intPruneSpeed[i] = 0;
        }
      }

      // Keeps prune in bounds and hones the player
      if(fltPruneArmyX[i] <= -20 || fltPruneArmyX[i] >= 1400){
        intPruneSpeed[i] = intPruneSpeed[i] * -1;
      }

      if(fltPruneArmyX[i] <= intCharX - 100){
        intPruneSpeed[i] = -10;
      }

      if(fltPruneArmyX[i] >= intCharX + 150){
        intPruneSpeed[i] = 10;
      }

      if(fltPruneArmyX[i] < -400){
        intPruneSpeed[i] = 0;
      }

      // Losing hearts
      if(fltPruneArmyX[i] + 70 >= intCharX + 50 && fltPruneArmyX[i] + 70 <= intCharX + 150){
        if(fltPruneArmyY[i] + 70 >= intCharY + 110 && fltPruneArmyY[i] + 70 <= intCharY + 180){
          if(millis() - pruneAtkInterval[i] > pruneAtkCooldown[i]){
            intLives--;
            pruneAtkInterval[i] = millis();
          }
        }
      }
    }
  }

  /**
   * Method that contains all interactions with jellies 
   * @author: L. Chen
   */
  public void jelly(){
    // Determines the frame of animation
    intJellyFrame++;
    intJellyFrame %= imgJellyMove.length;

    for(int i = 0; i < fltJellyArmyX.length; i++){
      // Jelly healthbar
      stroke(255);
      fill(135, 219, 121);

      if(intJellyHealth[i] == 0){
        noStroke();
      }

      rect(fltJellyArmyX[i] + 25, fltJellyArmyY[i], 1 * intJellyHealth[i], 25);

      // Jelly health lose
      if(charKeys.get(charKeys.size() - 1) == 'd' && blnAtk){
        if(((intCharX + 200 >= fltJellyArmyX[i] - 10) && (intCharX + 250 <= fltJellyArmyX[i] + 140)) && intJellyHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          intJellyHealth[i] = intJellyHealth[i] - 10;
          fltJellyArmyX[i] = fltJellyArmyX[i] + 70;
        }
      }

      if(charKeys.get(charKeys.size() - 1) == 'a' && blnAtk){
        if(((intCharX - 50 >= fltJellyArmyX[i] - 10) && (intCharX <= fltJellyArmyX[i] + 140)) && intJellyHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          intJellyHealth[i] = intJellyHealth[i] - 10;
          fltJellyArmyX[i] = fltJellyArmyX[i] - 70;
        }
      }

      if(intJellyHealth[i] <= 0){
        blnDrawJelly[i] = false;

        if(millis() - jellySpawnInterval > jellySpawnCooldown[i]){
          intJelliesKilled++;
        }
      }

      // Checks to see if jelly is drawn
      if(blnDrawJelly[i]){
        if(intJellySpeed[i] > 0){
          image(imgJellyMove[intJellyFrame], fltJellyArmyX[i] - 10, fltJellyArmyY[i]);
        }

        else if(intJellySpeed[i] < 0){
          image(imgJellyMove[intJellyFrame], fltJellyArmyX[i] + 10, fltJellyArmyY[i]);
        }
        
        fltJellyArmyX[i] -= intJellySpeed[i];

        if(fltJellyArmyX[i] >= intCharX + 20 && fltJellyArmyX[i] <= intCharX + 100 && intJellySpeed[i] > 0){
          image(imgJellyAtk, fltJellyArmyX[i], fltJellyArmyY[i]);
        }

        else if(fltJellyArmyX[i] >= intCharX - 50 && fltJellyArmyX[i] <= intCharX + 50 && intJellySpeed[i] < 0){
          image(imgJellyAtk, fltJellyArmyX[i], fltJellyArmyY[i]);
        }

        else{
          image(imgJellyBody, fltJellyArmyX[i], fltJellyArmyY[i]);
        }
      }

      // Spawns jellies in intervals
      else{
        fltJellyArmyX[i] = -1000;

        if(millis() - jellySpawnInterval > jellySpawnCooldown[i]){
          blnDrawJelly[i] = true;
          fltJellyArmyX[i] = random(1100, 1350);
          intJellyHealth[i] = 70;

          jellySpawnInterval = millis();
        }

        if(intJelliesKilled >= 8){
          fltJellyArmyX[i] = -1000;
          intJellySpeed[i] = 0;
        }
      }

      // Keeps jelly in bounds and hones the player
      if(fltJellyArmyX[i] <= -20 || fltJellyArmyX[i] >= 1400){
        intJellySpeed[i] = intJellySpeed[i] * -1;
      }
      
      if(fltJellyArmyX[i] <= intCharX - 100){
        intJellySpeed[i] = -10;
      }

      if(fltJellyArmyX[i] >= intCharX + 150){
        intJellySpeed[i] = 10;
      }

      if(fltJellyArmyX[i] < -400){
        intJellySpeed[i] = 0;
      }

      // Losing hearts
      if(fltJellyArmyX[i] + 70 >= intCharX + 50 && fltJellyArmyX[i] + 70 <= intCharX + 150){
        if(fltJellyArmyY[i] + 70 >= intCharY + 110 && fltJellyArmyY[i] + 70 <= intCharY + 180){
          if(millis() - jellyAtkInterval[i] > jellyAtkCooldown[i]){
            intLives--;
            jellyAtkInterval[i] = millis();
          }
        }
      }
    }
  }

  /**
   * Method that determines bird movement 
   * @author: L. Chen
   */
  public void bird(){
    // Determines the frame of animation
    intBirdFrame++;
    intBirdFrame %= imgBirdLeftMove.length;

    // Moves in a sin wave
    fltBirdX = (fltBirdAngle) * 90; 
    fltBirdY = 150 + sin(fltBirdAngle) * 60;

    fltBirdAngle += 0.2;

    // Turns the bird around
    if(fltBirdX >= 1550){
      fltBirdX = 3100 - ((fltBirdAngle) * 90); 
      image(imgBirdLeftMove[intBirdFrame], fltBirdX, fltBirdY);
    }

    else{ 
      image(imgBirdRightMove[intBirdFrame], fltBirdX, fltBirdY);  
    }
    
    // Resets the wave
    if(fltBirdAngle > 36){
      fltBirdAngle = -3;
    }
  }

  /**
   * Method that determines egg movement 
   * @author: L. Chen
   */
  public void egg(){
    // Falling eggs
    image(imgEgg, fltBirdX + 55, intEggY);

    if(intEggY < 780){
      intEggY += 60;
    }
    
    else{
      intEggY = (int) fltBirdY + 50;
    }

    // Losing hearts
    if(fltBirdX + 70 >= intCharX + 50 && fltBirdX + 70 <= intCharX + 150){
      if(intEggY - 50 >= intCharY + 10 && intEggY - 50 <= intCharY + 200){
        if(millis() - eggAtkInterval > eggAtkCooldown){
          intLives--;
          eggAtkInterval = millis();

          intEggY = (int) fltBirdY + 50;
        }
      }
    }
  }

  /**
   * Method that contains all interactions with the prune in the tutorial level
   * @author: L. Chen
   */
  public void tutPrune(){
    // Determines the frame of animation
    intPruneFrame++;
    intPruneFrame %= imgPruneLeftMove.length;

    // Prune healthbar
    stroke(255);
    fill(135, 219, 121);

    if(intPruneHealth[0] == 0){
      noStroke();
    }

    rect(fltTutPruneX + 15, fltPruneArmyY[0], 1 * intPruneHealth[0], 25);

    // Prune health lose
    if(charKeys.get(charKeys.size() - 1) == 'd' && blnAtk){
      if(((intCharX + 200 >= fltTutPruneX - 10) && (intCharX + 250 <= fltTutPruneX + 140)) && intPruneHealth[0] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
        intPruneHealth[0] = intPruneHealth[0] - 10;
        fltTutPruneX = fltTutPruneX + 70;
      }
    }

    if(charKeys.get(charKeys.size() - 1) == 'a' && blnAtk){
      if(((intCharX - 50 >= fltTutPruneX - 10) && (intCharX <= fltTutPruneX + 140)) && intPruneHealth[0] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
        intPruneHealth[0] = intPruneHealth[0] - 10;
        fltTutPruneX = fltTutPruneX - 70;
      }
    }

    if(intPruneHealth[0] <= 0){
      fltTutPruneX = -1000;
    }

    // Checks to see if prune is drawn
    if(blnDrawPrune[0]){
      // Left or right facing
      if(intPruneSpeed[0] > 0){
        image(imgPruneLeftMove[intPruneFrame], fltTutPruneX, fltPruneArmyY[0]);
        fltTutPruneX -= intPruneSpeed[0];
      }

      else{
        image(imgPruneRightMove[intPruneFrame], fltTutPruneX, fltPruneArmyY[0]);
        fltTutPruneX -= intPruneSpeed[0];
      }
    
      // Left or right animation
      if(fltTutPruneX >= intCharX + 20 && fltTutPruneX <= intCharX + 100 && intPruneSpeed[0] > 0){
        image(imgPruneLeftAtk, fltTutPruneX, fltPruneArmyY[0]);
      }

      else if(fltTutPruneX >= intCharX - 50 && fltTutPruneX <= intCharX + 50 && intPruneSpeed[0] < 0){
        image(imgPruneRightAtk, fltTutPruneX, fltPruneArmyY[0]);
      }
    }   
    
    // Spawns prune
    else{
      if(millis() - pruneSpawnInterval > pruneSpawnCooldown[0]){
        blnDrawPrune[0] = true;
      }
    }

    // Keeps prune in bounds and hones the player
    if(fltTutPruneX <= -20 || fltTutPruneX >= 1400){
      intPruneSpeed[0] = intPruneSpeed[0] * -1;
    }

    if(fltTutPruneX <= intCharX - 100){
      intPruneSpeed[0] = -10;
    }

    if(fltTutPruneX >= intCharX + 150){
      intPruneSpeed[0] = 10;
    }

    if(fltTutPruneX < -400){
      intPruneSpeed[0] = 0;
    }

    // Losing hearts
    if(fltTutPruneX + 70 >= intCharX + 50 && fltTutPruneX + 70 <= intCharX + 150){
      if(fltPruneArmyY[0] + 70 >= intCharY + 110 && fltPruneArmyY[0] + 70 <= intCharY + 180){
        if(millis() - pruneAtkInterval[0] > pruneAtkCooldown[0]){
          intLives--;
          pruneAtkInterval[0] = millis();
        }
      }
    }
  }

  /**
   * Method that contains all interactions with the jelly in the tutorial level
   * @author: L. Chen
   */
  public void tutJelly(){
    // Determines the frame of animation
    intJellyFrame++;
    intJellyFrame %= imgJellyMove.length;

    // Jelly healthbar
    stroke(255);
    fill(135, 219, 121);

    if(intJellyHealth[0] == 0){
      noStroke();
    }

    rect(fltTutJellyX + 25, fltJellyArmyY[0], 1 * intJellyHealth[0], 25);

    // Jelly health lose
    if(charKeys.get(charKeys.size() - 1) == 'd' && blnAtk){
      if(((intCharX + 200 >= fltTutJellyX - 10) && (intCharX + 250 <= fltTutJellyX + 140)) && intJellyHealth[0] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
        intJellyHealth[0] = intJellyHealth[0] - 10;
        fltTutJellyX = fltTutJellyX + 70;
      }
    }

    if(charKeys.get(charKeys.size() - 1) == 'a' && blnAtk){
      if(((intCharX - 50 >= fltTutJellyX - 10) && (intCharX <= fltTutJellyX + 140)) && intJellyHealth[0] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
        intJellyHealth[0] = intJellyHealth[0] - 10;
        fltTutJellyX = fltTutJellyX - 70;
      }
    }

    if(intJellyHealth[0] <= 0){
      fltTutJellyX = -1000;
    }

    // Checks to see if jelly is drawn
    if(blnDrawJelly[0]){
      if(intJellySpeed[0] > 0){
        image(imgJellyMove[intJellyFrame], fltTutJellyX - 10, fltJellyArmyY[0]);
      }

      else if(intJellySpeed[0] < 0){
        image(imgJellyMove[intJellyFrame], fltTutJellyX + 10, fltJellyArmyY[0]);
      }
      
      fltTutJellyX -= intJellySpeed[0];

      if(fltTutJellyX >= intCharX + 20 && fltTutJellyX <= intCharX + 100 && intJellySpeed[0] > 0){
        image(imgJellyAtk, fltTutJellyX, fltJellyArmyY[0]);
      }

      else if(fltTutJellyX >= intCharX - 50 && fltTutJellyX <= intCharX + 50 && intJellySpeed[0] < 0){
        image(imgJellyAtk, fltTutJellyX, fltJellyArmyY[0]);
      }

      else{
        image(imgJellyBody, fltTutJellyX, fltJellyArmyY[0]);
      }
    }

    // Spawns jellies 
    else{
      if(millis() - jellySpawnInterval > jellySpawnCooldown[0]){
        blnDrawJelly[0] = true;
      }
    }

    // Keeps jelly in bounds and hones the player
    if(fltTutJellyX <= -20 || fltTutJellyX >= 1400){
      intJellySpeed[0] = intJellySpeed[0] * -1;
    }
    
    if(fltTutJellyX <= intCharX - 100){
      intJellySpeed[0] = -10;
    }

    if(fltTutJellyX >= intCharX + 150){
      intJellySpeed[0] = 10;
    }

    if(fltTutJellyX < -400){
      intJellySpeed[0] = 0;
    }

    // Losing hearts
    if(fltTutJellyX + 70 >= intCharX + 50 && fltTutJellyX + 70 <= intCharX + 150){
      if(fltJellyArmyY[0] + 70 >= intCharY + 110 && fltJellyArmyY[0] + 70 <= intCharY + 180){
        if(millis() - jellyAtkInterval[0] > jellyAtkCooldown[0]){
          intLives--;
          jellyAtkInterval[0] = millis();
        }
      }
    }
  }
}