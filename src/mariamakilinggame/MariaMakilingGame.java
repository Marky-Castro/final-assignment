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

    // Global version constant
    public static final String GAME_VERSION = "1.0.0";

    // Game state variables
    int stage = 0; 
    int reputation = 0;
    
    // Character and image objects
    Character mariaCharacter; 
    PImage bgForest;
    PImage bgDrought;
    PImage villagerImg;
    PImage deerImg;
    
    // Game buttons
    Button startButton;
    Button c1Opt1, c1Opt2;
    Button c2Opt1, c2Opt2;
    Button c3Opt1, c3Opt2;
    Button restartButton;

    public static void main(String[] args) {
        PApplet.main("mariamakilinggame.MariaMakilingGame");
    }

    // Set window size
    @Override
    public void settings() {
        size(800, 600); 
    }

    // Load images and setup buttons
    @Override
    public void setup() {
        background(255);
        
        // Setup starting position for Maria
        mariaCharacter = new Character(this, 510, 120, "images/maria.png");
        
        // Load background and character images
        bgForest = loadImage("images/bg_forest.png");
        bgDrought = loadImage("images/bg_drought.png");
        villagerImg = loadImage("images/villager.png");
        deerImg = loadImage("images/deer.png");
        
        // Setup start button size and position
        startButton = new Button(this, 250, 450, "images/button_control.png");
        startButton.w = 300;
        startButton.h = 70;
        
        // Setup choice buttons for all stages
        c1Opt1 = new Button(this, 80, 460, "images/button_option.png");
        c1Opt2 = new Button(this, 420, 460, "images/button_option.png");
        
        c2Opt1 = new Button(this, 80, 460, "images/button_option.png");
        c2Opt2 = new Button(this, 420, 460, "images/button_option.png");
        
        c3Opt1 = new Button(this, 80, 460, "images/button_option.png");
        c3Opt2 = new Button(this, 420, 460, "images/button_option.png");
        
        // Setup restart button
        restartButton = new Button(this, 250, 470, "images/button_control.png");
        restartButton.w = 300;
        restartButton.h = 70;
    }

    // Main draw loop to render graphics
    @Override
    public void draw() {
        // Change background based on the current stage
        if (stage == 3) {
            if (bgDrought != null) image(bgDrought, 0, 0, width, height);
        } else {
            if (bgForest != null) image(bgForest, 0, 0, width, height);
        }
        
        // Draw the text box frame
        fill(255, 255, 255, 230); 
        stroke(34, 76, 56);
        strokeWeight(3);
        rect(50, 50, 700, 380, 15);
        
        // Draw Maria character
        mariaCharacter.draw(this);
        
        // Stage 0: Intro Screen
        if (stage == 0) {
            mariaCharacter.x = 510;
            mariaCharacter.y = 120;
            
            if (villagerImg != null) {
                image(villagerImg, 90, 180, 110, 190); 
                
                // Villager collision detection check
                if (mariaCharacter.isCollidingWith(90, 180, 110, 190)) {
                    fill(255, 0, 0);
                    textSize(14);
                    textAlign(LEFT, TOP);
                    text("💥 Touching Villager! Press Begin Journey to talk!", mouseX, mouseY); 
                }
            }
            
            fill(34, 76, 56);
            textSize(24);
            textAlign(LEFT, TOP);
            text("Welcome to Mount Makiling", 230, 90);
            
            fill(60);
            textSize(16);
            String intro = "Hello, Marky!\n\nUse your LEFT and RIGHT arrow keys to move Maria around the screen. Try walking into the villager to check your collision detection system, then click below to start.";
            text(intro, 230, 140, 480, 240);
            
            startButton.draw();
            fill(255);
            textSize(16);
            textAlign(CENTER, CENTER);
            text("Begin Journey", 400, 485); 
        } 
        // Stage 1: First Choice (Sacred Timber)
        else if (stage == 1) {
            mariaCharacter.x = 80;
            mariaCharacter.y = 130;
            
            fill(34, 76, 56);
            textSize(22);
            textAlign(LEFT, TOP);
            text("Choice 1: The Sacred Timber", 240, 80);
            
            fill(50);
            textSize(15);
            String textC1 = "A wealthy merchant offers you 500 gold coins if you secretly chop down a rare, ancient tree nested up on the ridge.\n\nYour family is deeply struggling to get by this season, but this sacred tree has stood safeguarding the ecosystem for hundreds of years.";
            text(textC1, 240, 130, 470, 260); 
            
            c1Opt1.draw();
            c1Opt2.draw();
            
            fill(0);
            textSize(14);
            textAlign(CENTER, CENTER);
            text("Protect the Tree", 230, 492);
            text("Chop Down for Gold", 570, 492);
        }
        // Stage 2: Second Choice (Wounded Deer)
        else if (stage == 2) {
            mariaCharacter.x = 510; 
            mariaCharacter.y = 120;

            fill(34, 76, 56);
            textSize(22);
            textAlign(LEFT, TOP);
            text("Choice 2: The Wounded Creature", 80, 80);
            
            fill(50);
            textSize(15);
            String textC2 = "Deep along the river trail, you discover a wild forest deer crying in intense pain, its leg trapped in a wire poacher trap.\n\nTo save its life, you must sacrifice your last remaining container of precious medical herbs.";
            text(textC2, 80, 130, 400, 260);

            if (deerImg != null) {
                image(deerImg, 510, 230, 160, 130);
                
                // Deer collision detection check
                if (mariaCharacter.isCollidingWith(510, 230, 160, 130)) {
                    fill(255, 0, 0);
                    textSize(14);
                    textAlign(LEFT, TOP);
                    text("? Maria is checking on the deer!", mouseX, mouseY); 
                }
            }

            c2Opt1.draw();
            c2Opt2.draw();
            
            fill(0);
            textSize(14);
            textAlign(CENTER, CENTER);
            text("Heal Wounded Deer", 230, 492);
            text("Ignore and Walk Away", 570, 492);
        } 
        // Stage 3: Third Choice (Summer Drought)
        else if (stage == 3) {
            mariaCharacter.x = 80;
            mariaCharacter.y = 130;

            fill(34, 76, 56);
            textSize(22);
            textAlign(LEFT, TOP);
            text("Choice 3: The Summer Drought", 240, 80);
            
            fill(50);
            textSize(15);
            String textC3 = "A massive heatwave strikes the valley, drying up the town water well. Families are parched and local crops are dying.\n\nYou possess a secret rain-barrel hidden safely in your cellar. Do you share it?";
            text(textC3, 240, 130, 470, 260);
            
            c3Opt1.draw();
            c3Opt2.draw();
            
            fill(0);
            textSize(14);
            textAlign(CENTER, CENTER);
            text("Share Water Supply", 230, 492);
            text("Keep Resources Hidden", 570, 492);
        }
        // Stage 4: Results screen and endings
        else if (stage == 4) {
            fill(34, 76, 56);
            textSize(24);
            textAlign(CENTER, TOP);
            text("THE FINAL JUDGMENT", width / 2, 80);
            textSize(16);
            
            // Check points to display good, bad, or neutral ending
            if (reputation >= 2) {
                fill(20, 140, 40);
                text(" GOOD ENDING: Blessing of the Goddess 🌟", width / 2, 130);
                fill(60);
                String goodEnding = "Because you protected the forest, saved the weak, and shared resources, Maria Makiling reveals her true nature to bless your line.\n\nYour valley streams run clean forever.";
                text(goodEnding, 100, 180, 600, 200);
            } 
            else if (reputation < 0) {
                fill(200, 40, 40);
                text(" BAD ENDING: Curse of Mount Makiling 💀", width / 2, 130);
                fill(60);
                String badEnding = "Your choices favored greed over nature. Maria withdraws her presence from the valley completely.\n\nThe lakes dry up, and your gold coins cannot buy water.";
                text(badEnding, 100, 180, 600, 200);
            } 
            else {
                fill(160, 120, 20);
                text("️ NEUTRAL ENDING: The Difficult Middle Path ⚖️", width / 2, 130);
                fill(60);
                String neutralEnding = "You balanced self-interest with kindness. The forest doesn't curse you, but it doesn't offer help either.\n\nYour village must labor intensely to survive.";
                text(neutralEnding, 100, 180, 600, 200);
            }
            
            restartButton.draw();
            fill(255);
            textSize(16);
            textAlign(CENTER, CENTER);
            text("Play Again", 400, 505);
        }
    }

    // Handles arrow key presses for movement with screen boundaries
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

    // Handles button click detection for choice tracking and switching stages
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

    // Swaps character model variant based on final reputation score
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





