/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohab
 */
public class MyApplet2 extends Applet implements Runnable{
            Image Picture;
            Thread th;
            boolean on;
      public void init() {  
         resize(1000, 1000);
         Picture = getImage(getDocumentBase(),"flower.jfif");
         th = new Thread(this);
         th.start();
        }
      public void RightWall(Graphics g,boolean on)
      {
         Color pink = null,gray = null,black = Color.BLACK;
         Color brown = null,whiteBrown = null;
         Color yellow = null,red = null;
         Color[] state = new Color[2];
        if(on == true)
          {
              brown = new Color(80,30,30);
              whiteBrown = new Color(220,200,200);
              yellow = Color.YELLOW;
              red = Color.RED;
              state[0] = new Color(220,100,100);
              state[1] = Color.GRAY;
          }else
          {
                state[0] = Color.GRAY;
                state[1] = new Color(220,100,100);
                brown = new Color(100,80,80);
                red = new Color(100,0,0);
                yellow = new Color(200,200,200);
                gray = new Color(80,80,80);
                whiteBrown = new Color(160,160,160);
          }
        //draw wall
        g.drawLine(450,800,450,0);
        int height = 0,width;
        for(int i=0;i<40;i++)
        {
            width=0;
            for(int r=0;r<8;r++)
            {

                if((r+i)%2==0)
                {
                    g.setColor(brown);
                }else{
                    g.setColor(whiteBrown);
                }
                
                g.fillRect(450+width, height, 100, 50);
                width+=100;
                
            }
            height+=50;
        }
        
        //draw switcher
        g.setColor(state[0]);
        g.fillRect(500, 350, 40, 30);
        g.setColor(state[1]);
        g.fillRect(500, 380, 40, 30);
        g.setColor(black);
        g.drawString("ON", 510, 370);
        g.drawString("OFF", 510, 400);
        
        //draw a picture
        g.setColor(black);
        g.fillRect(500, 100, 200, 200);
        g.drawLine(500, 100, 600, 50);
        g.drawLine(600, 50, 700, 100);
        g.fillOval(595, 50, 10, 10);   
        g.drawImage(Picture, 520, 120, 160, 160, this);
      }
      public void Lamp(Graphics g,boolean on)
      {
         Color gray = null,black = Color.BLACK;
         Color brown = null;
         Color yellow = null,red = null,lines = null;
        if(on == true)
          {
              brown = new Color(80,30,30);
              gray = Color.GRAY;
              yellow = lines = Color.YELLOW;
              lines = new Color(250,100,250);
              red = Color.RED;
          }else
          {
                brown = new Color(100,80,80);
                red = new Color(100,0,0);
                yellow = new Color(200,200,200);
                gray = new Color(80,80,80);
                lines = new Color(150,100,150);
          }
          //the lamp
        g.setColor(yellow);
        g.fillOval(220, 100, 70, 70);
        //holder
       
        g.setColor(brown);
        g.fillRect(240, 200, 30, 100);
        g.fillRect(240, 300, 200, 20);
        g.setColor(black);
        g.fillRect(440, 280, 10, 60);
        
        g.setColor(gray);
        g.fillRect(245, 170, 20, 30);
        //draw lamp body
        g.setColor(black);
        g.drawLine(150, 50, 100, 200);
        g.drawLine(350, 50, 400, 200);
        int j = 3;
        int x = 0;
        for(int i=152;i<350;i+=2)
        {
            g.setColor(lines);
            g.drawLine(i, 50, 100 + j, 200);
            if(x/30 == 1)
                x = 3;
            g.setColor(red);
            g.drawLine(100 + j, 200 + x, 100 + j, 200);//210
            j+=3;
            x+=3;
        }
        
      }
      public void LeftWall(Graphics g,boolean on)
      {
         Color brown = null;
        if(on == true)
          {
              brown = new Color(80,30,30);
          }else
          {
              brown = new Color(100,80,80);
          }
        //left wall
        int x1[] = { 0, 0, 200, 200};
        int y1[] = { 0, 800, 500, 0};
        g.setColor(brown);
        g.fillPolygon (x1, y1, 4);
      }
      public void HallWay(Graphics g,boolean on)
      {
         Color light = null;
        if(on == true)
          {
              light = new Color(220,210,80);
          }else
          {
                light = new Color(100,100,100);
          }
        int x2[] = { 450, 0, 200, 200,450};
        int y2[] = { 800, 800, 500, 0,0};
        //lightup
        g.setColor(light);
        g.fillPolygon(x2, y2, 5);
      }
    @Override
    public void paint(Graphics g){
        resize(800,800);
        
        //left wall
        LeftWall(g,on);
        HallWay(g,on);
        Lamp(g,on);
        RightWall(g,on);
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        while(true)
        {
            repaint();
            if(on == true)
            {
                on = false;
            }else
            {
                on = true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyApplet2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
