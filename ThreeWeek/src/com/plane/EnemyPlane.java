package com.plane;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.RecursiveTask;

public class EnemyPlane extends Thread{
    public GameFrame gf;
    public int x=0,y=0;
    public int width=50,height=50;
    public int speed =2;
    public Image image =new ImageIcon("img/10027.png").getImage();

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

    public boolean hit(){
        Rectangle rectangle = new Rectangle(this.x,this.y,this.width,this.height);

        Rectangle rect =null;
        for(int i=0;i<gf.bullets.size();i++) {
            Bullet bullet = gf.bullets.get(i);
            System.out.println("test hit");
            rect = new Rectangle(bullet.x, bullet.y - 1, bullet.width, bullet.height);
            if (rectangle.intersects(rect)) {
                return true;
            }
        }
            return false;
    }

    @Override
    public void run() {
        while(true){
            if(hit()){
                this.speed=0;
                this.image =new ImageIcon("img/JieSuan0.png").getImage();

            }
            try {
                this.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gf.enemyPlanes.remove(this);
            if(this.y>760){
                break;
            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
