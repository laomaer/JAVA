package com.plane;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

public class GameFrame extends JFrame {
    public static Plane plane;

    Vector<Bullet> bullets =new Vector<>();

    Vector<EnemyPlane> enemyPlanes =new Vector<>();
    GameFrame frame;
    public GameFrame(){
        frame=this;
        plane = new Plane();
        //设置窗体的宽高
        plane.start();
        this.setTitle("雷霆战机");
        this.setSize(460,760);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //
        //窗体可见
        this.setVisible(true);

        new Thread(new Runnable() {
            Random r =new Random();
            @Override
            public void run() {
                while(true) {
                    enemyPlanes.add(new EnemyPlane(r.nextInt(), 0, frame));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    repaint();
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    public void paint(Graphics g){
//        System.out.println("绘制画板");
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width,this.getSize().height);

        Graphics bi = image.getGraphics();

        bi.drawImage(new ImageIcon("img/MAP02_01.png").getImage(),0,0,null);

        bi.drawImage(plane.img,plane.x, plane.y,null);

        for(int i =0;i<bullets.size();i++){
            Bullet bullet  = bullets.get(i);
            if(bullet.y>0) {
                bi.drawImage(bullet.image, bullet.x, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
            }else{
                bullets.remove(bullet);
            }
        }
        for(int i =0;i<enemyPlanes.size();i++){
            EnemyPlane enemyPlane   = enemyPlanes.get(i);
            if(enemyPlane.y<760) {
                bi.drawImage(enemyPlane.image, enemyPlane.x, enemyPlane.y += enemyPlane.speed, enemyPlane.width, enemyPlane.height, null);
            }else{
                enemyPlanes.remove(enemyPlane);
            }
        }


        g.drawImage(image,0,0,null);

    }


    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        KeyBoard keyBoard = new KeyBoard(gameFrame);
        gameFrame.addKeyListener(keyBoard);
    }









}
