package com.plane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter {


    GameFrame frame;

    public KeyBoard(GameFrame frame) {
        this.frame =frame;
    }

    public KeyBoard() {

    }

    public KeyBoard(Plane plane) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key =e.getKeyCode();
//        System.out.println(key);
        switch (key){
            case 37:
                frame.plane.left =true;
                break;
            case 38:
                frame.plane.up =true;
                break;
            case 39:
                frame.plane.right=true;
                break;
            case 40:
                frame.plane.down=true;
                break;
            case 32:
                addBullet();
                break;
            }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key =e.getKeyCode();
        switch (key){
            case 37:
                frame.plane.left =false;
                break;
            case 38:
                frame.plane.up =false;
                break;
            case 39:
                frame.plane.right=false;
                break;
            case 40:
                frame.plane.down=false;
                break;


        }
    }

    public void addBullet(){
        frame.bullets.add(new Bullet(frame.plane.x+30,frame.plane.y-20));
    }
}
