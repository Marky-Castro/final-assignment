/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mariamakilinggame;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 350309527
 */
public class MariaMakilingGame extends PApplet {

    // Version constant
    public static final String GAME_VERSION = "1.0.0";

    // Game track variables
    int stage = 0; 
    int reputation = 0;
    
    //AI additions for typewriter effect
    String currentStoryText = "";
    String displayedStoryText = "";
    int textCounter = 0;
    int lastStageChecked = -1;
    
    // Images and character
    Character mariaCharacter; 
    PImage bgForest;
    PImage bgDrought;
    PImage villagerImg;
    PImage deerImg;
    
    // All game buttons
    Button startButton;
    Button c1Opt1, c1Opt2;
    Button c2Opt1, c2Opt2;
    Button c3Opt1, c3Opt2;
    Button restartButton;

    public static void main(String[] args) {
        PApplet.main("mariamakilinggame.MariaMakilingGame");
    }

    // Set screen size
    @Override
    public void settings() {
        size(800, 600); 
    }

    // Load files and set up buttons
    @Override
    public void setup() {
        background(255);
        
        // Setup starting position for Maria
        mariaCharacter = new Character(this, 510, 120, "images/maria.png");
        
        // Load background and character files
        bgForest = loadImage("images/bg_forest.png");
        bgDrought = loadImage("images/bg_drought.png");
        villagerImg = loadImage("images/villager.png");
        deerImg = loadImage("images/deer.png");
        
        // Setup start button size and position
        startButton = new Button(this, 250, 460, "images/button_control.png");
        startButton.w = 300;
        startButton.h = 65;
        
        // Setup restart button size and position
        restartButton = new Button(this, 250, 470, "images/button_control.png");
        restartButton.w = 300;
        restartButton.h = 65;
        
        // Setup choice buttons for choices 1, 2, and 3
        c1Opt1 = new Button(this, 80, 470, "images/button_option.png");
        c1Opt2 = new Button(this, 420, 470, "images/button_option.png");
        
        c2Opt1 = new Button(this, 80, 470, "images/button_option.png");
        c2Opt2 = new Button(this, 420, 470, "images/button_option.png");
        
        c3Opt1 = new Button(this, 80, 470, "images/button_option.png");
        c3Opt2 = new Button(this, 420, 470, "images/button_option.png");
    }

    // Main game loop to draw everything
    @Override
    public void draw() {
        // Change background based on stage
        if (stage == 3) {
            if (bgDrought != null) image(bgDrought, 0, 0, width, height);
        } else {
            if (bgForest != null) image(bgForest, 0, 0, width, height);
        }
        
        // Main white text box container
        fill(255, 255, 255, 235); 
        stroke(34, 76, 56);
        strokeWeight(4);
        rect(50, 50, 700, 390, 15);
        
        // Show score bar during the choices
        if (stage >= 1 && stage <= 3) {
            drawKarmaHUD();
        }
        
        // Draw Maria on screen
        mariaCharacter.draw(this);
        
        // Stage 0: Main menu screen
        if (stage == 0) {
            mariaCharacter.x = 510;
            mariaCharacter.y = 120;
            
            if (villagerImg != null) {
                image(villagerImg, 90, 180, 110, 190); 
                
                // Alert if Maria walks into the villager
                if (mariaCharacter.isCollidingWith(90, 180, 110, 190)) {
                    fill(255, 235, 235);
                    stroke(200, 0, 0);
                    strokeWeight(1);
                    rect(60, 385, 380, 26, 5);
                    fill(200, 0, 0);
                    textSize(13);
                    textAlign(LEFT, CENTER);
                    text(" Touching Villager! Press Begin Journey to talk!", 70, 396); 
                }
            }
            
            fill(34, 76, 56);
            textSize(24);
            textAlign(LEFT, TOP);
            text("Welcome to Mount Makiling", 230, 85);
            
            currentStoryText = "Hello!\n\nUse your LEFT and RIGHT arrow keys to move Maria around the screen. Try walking into the villager to check your collision detection system, then click below to start.";
            runTypewriterEffect();
            
            fill(60);
            textSize(15);
            text(displayedStoryText, 230, 135, 480, 230);
            
            startButton.draw();
            fill(255);
            textSize(16);
            textAlign(CENTER, CENTER);
            text("Begin Journey", 400, 492); 
        } 
        // Stage 1: First Choice
        else if (stage == 1) {
            mariaCharacter.x = 70;
            mariaCharacter.y = 120;
            
            fill(34, 76, 56);
            textSize(22);
            textAlign(LEFT, TOP);
            text("Choice 1: The Sacred Timber", 270, 85);
            
            currentStoryText = "A wealthy merchant offers you 500 gold coins if you secretly chop down a rare, ancient tree nested up on the ridge.\n\nYour family is deeply struggling to get by this season, but this sacred tree has stood safeguarding the ecosystem for hundreds of years.";
            runTypewriterEffect();
            
            fill(50);
            textSize(15);
            text(displayedStoryText, 270, 135, 450, 230); 
            
            c1Opt1.draw();
            c1Opt2.draw();
            fill(0);
            textSize(14);
            textAlign(CENTER, CENTER);
            text("Protect the Tree", 230, 502);
            text("Chop Down for Gold", 570, 502);
        }
        // Stage 2: Second Choice
        else if (stage == 2) {
            mariaCharacter.x = 510; 
            mariaCharacter.y = 120;

            fill(34, 76, 56);
            textSize(22);
            textAlign(LEFT, TOP);
            text("Choice 2: The Wounded Creature", 80, 85);
            
            currentStoryText = "Deep along the river trail, you discover a wild forest deer crying in intense pain, its leg trapped in a wire poacher trap.\n\nTo save its life, you must sacrifice your last remaining container of precious medical herbs.";
            runTypewriterEffect();
            
            fill(50);
            textSize(15);
            text(displayedStoryText, 80, 135, 410, 230);

            if (deerImg != null) {
                image(deerImg, 510, 240, 160, 130);
                
                // Alert if Maria walks into the deer
                if (mariaCharacter.isCollidingWith(510, 240, 160, 130)) {
                    fill(255, 235, 235);
                    stroke(200, 0, 0);
                    strokeWeight(1);
                    rect(80, 385, 270, 26, 5);
                    fill(200, 0, 0);
                    textSize(13);
                    textAlign(LEFT, CENTER);
                    text("🦌 Maria is checking on the deer!", 90, 396); 
                }
            }

            c2Opt1.draw();
            c2Opt2.draw();
            fill(0);
            textSize(14);
            textAlign(CENTER, CENTER);
            text("Heal Wounded Deer", 230, 502);
            text("Ignore and Walk Away", 570, 502);
        } 
        // Stage 3: Third Choice
        else if (stage == 3) {
            mariaCharacter.x = 70;
            mariaCharacter.y = 120;

            fill(34, 76, 56);
            textSize(22);
            textAlign(LEFT, TOP);
            text("Choice 3: The Summer Drought", 270, 85);
            
            currentStoryText = "A massive heatwave strikes the valley, drying up the town water well. Families are parched and local crops are dying.\n\nYou possess a secret rain-barrel hidden safely in your cellar. Do you share it?";
            runTypewriterEffect();
            
            fill(50);
            textSize(15);
            text(displayedStoryText, 270, 135, 450, 230);
            
            c3Opt1.draw();
            c3Opt2.draw();
            fill(0);
            textSize(14);
            textAlign(CENTER, CENTER);
            text("Share Water Supply", 230, 502);
            text("Keep Resources Hidden", 570, 502);
        }
        // Stage 4: Results screen
        else if (stage == 4) {
            mariaCharacter.x = 295;
            mariaCharacter.y = 195;
            
            fill(34, 76, 56);
            textSize(24);
            textAlign(CENTER, TOP);
            text("THE FINAL JUDGMENT", width / 2, 75);
            textSize(16);
            
            // Branch to different text endings depending on score points
            if (reputation >= 2) {
                fill(20, 140, 40);
                text(" GOOD ENDING: Blessing of the Goddess ", width / 2, 115);
                currentStoryText = "Because you protected the forest, saved the weak, and shared resources, Maria Makiling reveals her true nature to bless your line. Your valley streams run clean forever.";
            } 
            else if (reputation < 0) {
                fill(200, 40, 40);
                text(" BAD ENDING: Curse of Mount Makiling ", width / 2, 115);
                currentStoryText = "Your choices favored greed over nature. Maria withdraws her presence from the valley completely. The lakes dry up, and your gold coins cannot buy water.";
            } 
            else {
                fill(160, 120, 20);
                text("️ NEUTRAL ENDING: The Difficult Middle Path ️", width / 2, 115);
                currentStoryText = "You balanced self-interest with kindness. The forest doesn't curse you, but it doesn't offer help either. Your village must labor intensely to survive.";
            }
            
            runTypewriterEffect();
            fill(60);
            textSize(15);
            text(displayedStoryText, 90, 145, 620, 100);
            
            restartButton.draw();
            fill(255);
            textSize(16);
            textAlign(CENTER, CENTER);
            text("Play Again", 400, 502);
        }
    }

    //Types out text letter by letter
    public void runTypewriterEffect() {
        if (stage != lastStageChecked) {
            displayedStoryText = "";
            textCounter = 0;
            lastStageChecked = stage;
        }
        
        if (textCounter < currentStoryText.length()) {
            if (frameCount % 2 == 0) { 
                textCounter++;
                displayedStoryText = currentStoryText.substring(0, textCounter);
            }
        }
    }

    // Draws the visual tracker UI bar at the top
    public void drawKarmaHUD() {
        stroke(180);
        strokeWeight(1);
        fill(235);
        rect(300, 405, 200, 14, 8);
        
        float fillWidth = map(reputation, -3, 3, -100, 100);
        
        if (reputation > 0) {
            fill(46, 184, 114); 
            rect(400, 405, fillWidth, 14, 0, 8, 8, 0);
        } else if (reputation < 0) {
            fill(214, 69, 65); 
            rect(400, 405, fillWidth, 14, 8, 0, 0, 8);
        }
        
        stroke(120);
        line(400, 405, 400, 419);
        
        fill(120);
        textSize(10);
        textAlign(CENTER, BOTTOM);
        text("KARMA MONITOR", 400, 402);
    }

    // Keyboard keys handler for movement controls
    @Override
    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == LEFT && mariaCharacter.x > 50) {
                mariaCharacter.x -= 20; 
            } else if (keyCode == RIGHT && mariaCharacter.x < 650) {
                mariaCharacter.x += 20; 
            }
        }
    }

    // Mouse button click tracker to handle game progression
    @Override
    public void mousePressed() {
        if (stage == 0) {
            if (startButton.isClicked(mouseX, mouseY)) {
                stage = 1; 
            }
        }
        else if (stage == 1) {
            if (c1Opt1.isClicked(mouseX, mouseY)) {
                reputation += 1;
                stage = 2;
            } else if (c1Opt2.isClicked(mouseX, mouseY)) {
                reputation -= 1;
                stage = 2;
            }
        }
        else if (stage == 2) {
            if (c2Opt1.isClicked(mouseX, mouseY)) {
                reputation += 1;
                stage = 3;
            } else if (c2Opt2.isClicked(mouseX, mouseY)) {
                reputation -= 1;
                stage = 3;
            }
        }
        else if (stage == 3) {
            if (c3Opt1.isClicked(mouseX, mouseY)) {
                reputation += 1;
                stage = 4;
                updateEndingSprite();
            } else if (c3Opt2.isClicked(mouseX, mouseY)) {
                reputation -= 1;
                stage = 4;
                updateEndingSprite();
            }
        }
        else if (stage == 4) {
            if (restartButton.isClicked(mouseX, mouseY)) {
                reputation = 0;
                stage = 0;
                mariaCharacter.updateForm("images/maria.png");
            }
        }
    }

    // Swaps character graphic form based on score points
    public void updateEndingSprite() {
        if (reputation >= 2) {
            mariaCharacter.updateForm("images/maria_good.png");
        } else if (reputation < 0) {
            mariaCharacter.updateForm("images/maria_bad.png");
        } else {
            mariaCharacter.updateForm("images/maria.png");
        }
    }
}







