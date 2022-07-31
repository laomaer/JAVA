package com.plane;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    int x,y;
    int width=50,height=50;
    int speed=10;
    Image image  = new ImageIcon("img/300340.png").getImage();

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Bullet(int x, int y) {
        this.x =x;
        this.y=y;
    }
}
