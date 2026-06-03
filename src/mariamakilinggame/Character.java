/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mariamakilinggame;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author 350309527
 */
public class Character {
    protected float x, y;
    protected PImage img;

    public void draw(PApplet app) {
        if (img != null) {
            app.image(img, x, y);
        }
    }
}

class Maria extends Character {
    private PApplet app;

    public Maria(PApplet p, float x, float y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.img = p.loadImage(imagePath);
    }

    public void updateForm(String newImagePath) {
        this.img = app.loadImage(newImagePath);
    }
}





