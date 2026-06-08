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

    // --- DAY 1 & 2: VARIABLE DECLARATIONS & GAME STATE SYSTEM ---
    int stage = 0; 
    int reputation = 0;
    
    Character mariaCharacter; 
    
    PImage bgForest;
    PImage bgDrought;
    PImage villagerImg;
    PImage deerImg;
    
    Button startButton;
    Button c1Opt1, c1Opt2;
    Button c2Opt1, c2Opt2;
    Button c3Opt1, c3Opt2;
    Button restartButton;

    public static void main(String[] args) {
        PApplet.main("mariamakilinggame.MariaMakilingGame");
    }

    public void settings() {
        size(800, 600); 
    }

    public void setup() {
        background(255);
        
        mariaCharacter = new Character(this, 510, 120, "images/maria.png");
        
        bgForest = loadImage("images/bg_forest.png");
        bgDrought = loadImage("images/bg_drought.png");
        villagerImg = loadImage("images/villager.png");
        deerImg = loadImage("images/deer.png");
        
        startButton = new Button(this, 250, 450, "images/button_control.png");
        startButton.w = 300;
        startButton.h = 70;
        
        c1Opt1 = new Button(this, 80, 460, "images/button_option.png");
        c1Opt2 = new Button(this, 420, 460, "images/button_option.png");
        
        c2Opt1 = new Button(this, 80, 460, "images/button_option.png");
        c2Opt2 = new Button(this, 420, 460, "images/button_option.png");
        
        c3Opt1 = new Button(this, 80, 460, "images/button_option.png");
        c3Opt2 = new Button(this, 420, 460, "images/button_option.png");
        
        restartButton = new Button(this, 250, 470, "images/button_control.png");
        restartButton.w = 300;
        restartButton.h = 70;
    }

    public void draw() {
        if (stage == 3) {
            if (bgDrought != null) image(bgDrought, 0, 0, width, height);
        } else {
            if (bgForest != null) image(bgForest, 0, 0, width, height);
        }
        
        fill(255, 255, 255, 230); 
        stroke(34, 76, 56);
        strokeWeight(3);
        rect(50, 50, 700, 380, 15);
        
        mariaCharacter.draw(this);
        
        if (stage == 0) {
            mariaCharacter.x = 510;
            mariaCharacter.y = 120;
            
            if (villagerImg != null) {
                image(villagerImg, 90, 180, 110, 190); 
                
                if (mariaCharacter.isCollidingWith(90, 180, 110, 190)) {
                    fill(255, 0, 0);
                    textSize(14);
                    textAlign(LEFT, TOP);
                    text(" Touching Villager! Press Begin Journey to talk!", mouseX, mouseY); //
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
    }

    @Override
    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == LEFT) {
                if (mariaCharacter.x > 50) mariaCharacter.x -= 20; 
            } else if (keyCode == RIGHT) {
                if (mariaCharacter.x < 650) mariaCharacter.x += 20; 
            }
        }
    }

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
            } else if (c1Opt2.isClicked(mouseX, mouseY)) {
                reputation -= 1;
            }
        }
    }
}

