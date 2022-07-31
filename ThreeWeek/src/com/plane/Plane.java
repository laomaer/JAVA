package com.plane;

import javax.swing.*;
import java.awt.*;

public class Plane extends Thread{
    int x=230;
    int y=600;
    int width =50;
    int height =50;

    int speed =10;

    boolean up,down,left,right;
    Image img =new ImageIcon("img/10011.png").getImage();

    public Plane(int x,int y,int width,int height){
        this.height=height;
        this.width=width;
        this.x=x;
        this.y=y;
    }
    public Plane(){
        
    }

    @Override
    public void run() {
        while(true){
            if(up){
                y=y-speed;
            }
            if(down){
                y+=speed;
            }
            if(right){
                x+=speed;
            }
            if(left){
                x-=speed;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
