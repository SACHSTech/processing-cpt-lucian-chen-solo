import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Images
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

  PImage imgWin;
  PImage imgAgain;
  PImage imgWinMenu;

  PImage imgHeart;

  PImage imgPruneLeft1;
  PImage imgPruneLeft2;
  PImage imgPruneLeftAtk;

  PImage imgPruneRight1;
  PImage imgPruneRight2;
  PImage imgPruneRightAtk;

  PImage imgJellyBody;
  PImage imgJellyLegs1;
  PImage imgJellyLegs2;
  PImage imgJellyAtk;

  PImage imgBirdRight1;
  PImage imgBirdRight2; 
  PImage imgBirdLeft1;
  PImage imgBirdLeft2;
  PImage imgEgg;

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

  // Gallery images
  PImage imgBackgroundSketch;
  PImage imgBackgroundFlat;
  PImage imgBackgroundLineart;

  PImage imgCharSketch;
  PImage imgCharLineart;

  PImage imgAttackSketch;

  PImage imgCreatureConcept;

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
  float[] fltPruneHealth = new float[intNumPrune];
  boolean[] blnDrawPrune = new boolean[intNumPrune];
  boolean blnPruneDone = false;

  PImage[] imgPruneLeftMove = new PImage[9];
  PImage[] imgPruneRightMove = new PImage[9];

  int[] pruneSpawnCooldown = new int[intNumPrune];

  int[] pruneAtkCooldown = new int[intNumPrune];
  int[] pruneAtkInterval = new int [intNumPrune];

  int intPruneSpawn = 1000;
  int intPrunesKilled = 0;

  // Jelly variables
  int intNumJelly = 3;
  float[] jellyArmyX = new float[intNumJelly];
  float[] jellyArmyY = new float[intNumJelly];
  int[] jellySpeed = new int[intNumJelly];
  float[] jellyHealth = new float[intNumJelly];
  boolean[] blnDrawJelly = new boolean[intNumJelly];
  boolean blnJellyDone = false;

  PImage[] imgJellyMove = new PImage[9];

  int[] jellySpawnCooldown = new int[intNumJelly];

  int[] jellyAtkCooldown = new int[intNumJelly];
  int[] jellyAtkInterval = new int [intNumJelly];

  int intJellySpawn = 1500;
  int intJelliesKilled = 0;

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
    
    // Gallery
    imgBackgroundSketch = loadImage("background sketch.png");

    imgBackgroundFlat = loadImage("background flat.png");

    imgBackgroundLineart = loadImage("background lineart.png");
    
    imgCharSketch = loadImage("character sketch.jpg");
    
    imgCharLineart = loadImage("character lineart.jpg");

    imgAttackSketch = loadImage("scythe concept.jpg");

    imgCreatureConcept = loadImage("creature concept.jpg");

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

    imgJellyMove[0] = imgJellyLegs1;
    imgJellyMove[1] = imgJellyLegs2;
    imgJellyMove[2] = imgJellyLegs1;
    imgJellyMove[3] = imgJellyLegs2;
    imgJellyMove[4] = imgJellyLegs1;
    imgJellyMove[5] = imgJellyLegs2;
    imgJellyMove[6] = imgJellyLegs1;
    imgJellyMove[7] = imgJellyLegs2;
    imgJellyMove[8] = imgJellyLegs1;

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
      fltPruneHealth[i] = 100;

      pruneAtkCooldown[i] = 1500;
      pruneAtkInterval[i] = 0;

      pruneSpawnCooldown[i] = 4000;

      blnDrawPrune[i] = false;
    }

    // Sets the starting location, speed, and health of all jellies
    for (int i = 0; i < jellyArmyX.length; i++) {
      jellyArmyX[i] = -1000;
      jellyArmyY[i] = 550;
      jellySpeed[i] = 15;
      jellyHealth[i] = 70;

      jellyAtkCooldown[i] = 1500;
      jellyAtkInterval[i] = 0;

      jellySpawnCooldown[i] = 3000;

      blnDrawJelly[i] = false;
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

    if(blnPruneDone && blnJellyDone){
      youWin();
    }
  }

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
  }

  public void mousePressed(){
    if(intLvl == 1 || intLvl == 2){
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
  }

  public void tutLvl(){
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

    // if(intPrunesKilled < 7){
    //   prune();
    // }

    // else{
    //   blnPruneDone = true;
    // }

    // if(intJelliesKilled < 9){
    //   jelly();
    // }

    // else{
    //   blnJellyDone = true;
    // }
    
    // egg();
    // bird();
    
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

  public void youWin(){
    intLvl = 5;

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
    
    charKeys.add('d');

    for (int i = 0; i < fltPruneArmyX.length; i++) {
      fltPruneArmyX[i] = -1000;
      fltPruneHealth[i] = 100;
      blnDrawPrune[i] = false;
    }

    for (int i = 0; i < jellyArmyX.length; i++) {
      jellyArmyX[i] = -1000;
      jellyHealth[i] = 70;
      blnDrawJelly[i] = false;
    }
  }

  // All interactions with prunes
  public void prune(){
    intPruneFrame++;
    intPruneFrame %= imgPruneLeftMove.length;

    for(int i = 0; i < fltPruneArmyX.length; i++){
      // Prune healthbar
      stroke(255);
      fill(135, 219, 121);

      if(fltPruneHealth[i] == 0){
        noStroke();
      }

      rect(fltPruneArmyX[i] + 15, fltPruneArmyY[i], 1 * fltPruneHealth[i], 25);

      // Prune health lose
      if(charKeys.get(charKeys.size() - 1) == 'd' && blnAtk){
        if(((intCharX + 200 >= fltPruneArmyX[i] - 10) && (intCharX + 250 <= fltPruneArmyX[i] + 140)) && fltPruneHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          fltPruneHealth[i] = fltPruneHealth[i] - 10;
          fltPruneArmyX[i] = fltPruneArmyX[i] + 70;
        }
      }

      if(charKeys.get(charKeys.size() - 1) == 'a' && blnAtk){
        if(((intCharX - 50 >= fltPruneArmyX[i] - 10) && (intCharX <= fltPruneArmyX[i] + 140)) && fltPruneHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          fltPruneHealth[i] = fltPruneHealth[i] - 10;
          fltPruneArmyX[i] = fltPruneArmyX[i] - 70;
        }
      }

      if(fltPruneHealth[i] <= 0){
        blnDrawPrune[i] = false;

        if(millis() - intPruneSpawn > pruneSpawnCooldown[i]){
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

        if(millis() - intPruneSpawn > pruneSpawnCooldown[i]){
          blnDrawPrune[i] = true;
          fltPruneArmyX[i] = random(1100, 1350);
          fltPruneHealth[i] = 100;

          intPruneSpawn = millis();
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

  // All interactions with jellies
  public void jelly(){
    intJellyFrame++;
    intJellyFrame %= imgJellyMove.length;

    for(int i = 0; i < jellyArmyX.length; i++){
      // Jelly healthbar
      stroke(255);
      fill(135, 219, 121);

      if(jellyHealth[i] == 0){
        noStroke();
      }

      rect(jellyArmyX[i] + 25, jellyArmyY[i], 1 * jellyHealth[i], 25);

      // Jelly health lose
      if(charKeys.get(charKeys.size() - 1) == 'd' && blnAtk){
        if(((intCharX + 200 >= jellyArmyX[i] - 10) && (intCharX + 250 <= jellyArmyX[i] + 140)) && jellyHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          jellyHealth[i] = jellyHealth[i] - 10;
          jellyArmyX[i] = jellyArmyX[i] + 70;
        }
      }

      if(charKeys.get(charKeys.size() - 1) == 'a' && blnAtk){
        if(((intCharX - 50 >= jellyArmyX[i] - 10) && (intCharX <= jellyArmyX[i] + 140)) && jellyHealth[i] > 0 && (intAtkFrame == 1 || intAtkFrame == 3)){
          jellyHealth[i] = jellyHealth[i] - 10;
          jellyArmyX[i] = jellyArmyX[i] - 70;
        }
      }

      if(jellyHealth[i] <= 0){
        blnDrawJelly[i] = false;

        if(millis() - intJellySpawn > jellySpawnCooldown[i]){
          intJelliesKilled++;
        }
      }

      // Checks to see if jelly is drawn
      if(blnDrawJelly[i]){
        if(jellySpeed[i] > 0){
          image(imgJellyMove[intJellyFrame], jellyArmyX[i] - 10, jellyArmyY[i]);
        }

        else if(jellySpeed[i] < 0){
          image(imgJellyMove[intJellyFrame], jellyArmyX[i] + 10, jellyArmyY[i]);
        }
        
        jellyArmyX[i] -= jellySpeed[i];

        if(jellyArmyX[i] >= intCharX + 20 && jellyArmyX[i] <= intCharX + 100 && jellySpeed[i] > 0){
          image(imgJellyAtk, jellyArmyX[i], jellyArmyY[i]);
        }

        else if(jellyArmyX[i] >= intCharX - 50 && jellyArmyX[i] <= intCharX + 50 && jellySpeed[i] < 0){
          image(imgJellyAtk, jellyArmyX[i], jellyArmyY[i]);
        }

        else{
          image(imgJellyBody, jellyArmyX[i], jellyArmyY[i]);
        }
      }

      // Spawns jellies in intervals
      else{
        jellyArmyX[i] = -1000;

        if(millis() - intJellySpawn > jellySpawnCooldown[i]){
          blnDrawJelly[i] = true;
          jellyArmyX[i] = random(1100, 1350);
          jellyHealth[i] = 70;

          intJellySpawn = millis();
        }

        if(intJelliesKilled >= 8){
          jellyArmyX[i] = -1000;
          jellySpeed[i] = 0;
        }
      }

      // Keeps jelly in bounds and hones the player
      if(jellyArmyX[i] <= -20 || jellyArmyX[i] >= 1400){
        jellySpeed[i] = jellySpeed[i] * -1;
      }
      
      if(jellyArmyX[i] <= intCharX - 100){
        jellySpeed[i] = -10;
      }

      if(jellyArmyX[i] >= intCharX + 150){
        jellySpeed[i] = 10;
      }

      if(jellyArmyX[i] < -400){
        jellySpeed[i] = 0;
      }

      // Losing hearts
      if(jellyArmyX[i] + 70 >= intCharX + 50 && jellyArmyX[i] + 70 <= intCharX + 150){
        if(jellyArmyY[i] + 70 >= intCharY + 110 && jellyArmyY[i] + 70 <= intCharY + 180){
          if(millis() - jellyAtkInterval[i] > jellyAtkCooldown[i]){
            intLives--;
            jellyAtkInterval[i] = millis();
          }
        }
      }
    }
  }

  // Bird movement
  public void bird(){
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
}