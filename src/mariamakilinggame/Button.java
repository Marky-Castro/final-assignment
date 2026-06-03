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
    private PApplet p;
    private float x, y;
    private PImage img;

    public Button(PApplet p, float x, float y, String imagePath) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.img = p.loadImage(imagePath);
    }

    public void draw() {
        p.image(img, x, y);
    }

    public boolean isClicked(float mx, float my) {
        return (mx >= x && mx <= x + img.width && my >= y && my <= y + img.height);
    }
}

