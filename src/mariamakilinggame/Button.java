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
public class Button {
    PApplet p;
    float x, y, w, h;
    PImage img;

    public Button(PApplet p, float x, float y, String imagePath) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.img = p.loadImage(imagePath);
        this.w = 300;
        this.h = 65;
    }

    public void draw() {
        if (img != null) {
            p.image(img, x, y, w, h);
        }
    }

    public boolean isClicked(float mx, float my) {
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }
}


