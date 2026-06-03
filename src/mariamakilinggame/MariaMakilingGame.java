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

    int stage = 0; 
    int reputation = 0;
    
    Maria mariaCharacter;
    
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
        
        mariaCharacter = new Maria(this, 510, 120, "images/maria.png");
        
        bgForest = loadImage("images/bg_forest.png");
        bgDrought = loadImage("images/bg_drought.png");
        villagerImg = loadImage("images/villager.png");
        deerImg = loadImage("images/deer.png");
        
        startButton = new Button(this, 300, 470, "images/button_control.png");
        
        c1Opt1 = new Button(this, 60, 460, "images/button_option.png");
        c1Opt2 = new Button(this, 440, 460, "images/button_option.png");
        
        c2Opt1 = new Button(this, 60, 460, "images/button_option.png");
        c2Opt2 = new Button(this, 440, 460, "images/button_option.png");
        
        c3Opt1 = new Button(this, 60, 460, "images/button_option.png");
        c3Opt2 = new Button(this, 440, 460, "images/button_option.png");
        
        restartButton = new Button(this, 300, 500, "images/button_control.png");
    }

    public void draw() {
        if (stage == 3) {
            if (bgDrought != null) image(bgDrought, 0, 0, width, height);
        } else {
            if (bgForest != null) image(bgForest, 0, 0, width, height);
        }
        
        fill(255, 255, 255, 220); 
        stroke(34, 76, 56);
        strokeWeight(2);
        rect(50, 90, 700, 320, 10);
        
        mariaCharacter.draw(this);
        
        if (stage == 0) {
            if (villagerImg != null) {
                image(villagerImg, 80, 200, 100, 180); 
            }
            
            fill(45);
            textSize(20);
            text("Welcome to Mount Makiling", 200, 110);
            
            textSize(15);
            String intro = "Marky";
            text(intro, 200, 150, 290, 240);
            
            startButton.draw();
            fill(255);
            textSize(14);
            textAlign(CENTER, CENTER);
            text("Begin Journey", 400, 495);
        } 
        else if (stage == 1) {
        } 
        else if (stage == 2) {
        } 
        else if (stage == 3) {
        } 
        else if (stage == 4) {
        }
    }

    @Override
    public void mousePressed() {
        if (stage == 0) {
            if (startButton.isClicked(mouseX, mouseY)) {
                stage = 1; 
            }
        }
    }
}



