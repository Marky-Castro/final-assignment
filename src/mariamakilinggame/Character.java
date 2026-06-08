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
    public float x;
    public float y;
    protected PImage img;
    protected PApplet p;

    public Character(PApplet p, float x, float y, String imagePath) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.img = p.loadImage(imagePath);
    }

    public void draw(PApplet p) {
        if (img != null) {
            p.image(img, x, y);
        }
    }

    public void updateForm(String newImagePath) {
        this.img = p.loadImage(newImagePath);
    }

    public boolean isCollidingWith(float otherX, float otherY, float otherWidth, float otherHeight) {
        boolean isLeftOfOtherRight = this.x < otherX + otherWidth;
        boolean isRightOfOtherLeft = this.x + (img != null ? img.width : 100) > otherX;
        boolean isAboveOtherBottom = this.y < otherY + otherHeight;
        boolean isBelowOtherTop = this.y + (img != null ? img.height : 180) > otherY;

        return isLeftOfOtherRight && isRightOfOtherLeft && isAboveOtherBottom && isBelowOtherTop;
    }
}






