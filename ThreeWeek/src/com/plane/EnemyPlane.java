package com.plane;

import javax.swing.*;
import java.awt.*;

public class EnemyPlane extends Thread {
    public GameFrame gf;
    public int x=0,y=0;
    public int width=50,height=50;
    public int speed =2;
    public Image image =new ImageIcon("img/10029.png").getImage();

    public EnemyPlane(GameFrame gf, int x, int y, int width, int height) {
        this.gf = gf;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public EnemyPlane(int x, int y, GameFrame gf) {
        this.gf = gf;
        this.x = x;
        this.y = y;
    }


}
