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

/**
 *
 * @author Mohab
 */
public class MyApplet2 extends Applet{
            Image Picture;
      public void init() {  
         resize(1000, 1000);
         Picture = getImage(getDocumentBase(),"flower.jfif");  
        } 
      public void lightUp(Graphics g,boolean S)
      {
        //light up
          Color c1,c  = Color.BLACK ,c3 = Color.BLACK;
        if(S == true)
        {
            c1 = Color.YELLOW;
            c = new Color(220,210,80);
            c3 = Color.RED;
        }else
        {
            c3 = c = c1 = Color.GRAY;
            
            
        }
        int x2[] = { 450, 0, 200, 200,450};
        int y2[] = { 800, 800, 500, 0,0};
        
        g.setColor(c);
        g.fillPolygon (x2, y2, 5);
        //the lamp
        g.setColor(c1);
        g.fillOval(220, 100, 70, 70);
                int j = 3;
        int x = 0;
        for(int i=152;i<350;i+=2)
        {
            g.setColor(c1);
            g.drawLine(i, 50, 100 + j, 200);
            if(x/30 == 1)
                x = 3;
            g.setColor(c3);
            g.drawLine(100 + j, 200 + x, 100 + j, 200);//210
            j+=3;
            x+=3;
        }
      }
    @Override
    public void paint(Graphics g){
        resize(800,800);
        
        Color c = new Color(85,30,30);
        //left wall
        int x1[] = { 0, 0, 200, 200};
        int y1[] = { 0, 800, 500, 0};
        g.setColor(c);
        g.fillPolygon (x1, y1, 4);
        
        
        lightUp(g,true);
        //draw lamp 
        g.setColor(Color.BLACK);
        g.drawLine(150, 50, 100, 200);
        g.drawLine(350, 50, 400, 200);
        c = new Color(140,60,60);
        //holder
        g.setColor(c);
        g.fillRect(240, 200, 30, 100);
        g.fillRect(240, 300, 200, 20);
        g.setColor(Color.BLACK);
        g.fillRect(440, 280, 10, 60);
        
        g.setColor(Color.GRAY);
        g.fillRect(245, 170, 20, 30);

        //draw wall
        Color c1 = new Color(85,30,30);
        Color c2 = new Color(220,200,200);
        g.drawLine(450,800,450,0);
        //g.drawLine(0, 700, 200, 500);
        //g.drawLine(200, 0, 200, 500);
        int height = 0,width;
        for(int i=0;i<40;i++)
        {
            width=0;
            for(int r=0;r<8;r++)
            {

                if((r+i)%2==0)
                {
                    g.setColor(c1);
                }else{
                    g.setColor(c2);
                }
                
                g.fillRect(450+width, height, 100, 50);
                width+=100;
                
            }
            height+=50;
        }
        
        //draw switcher
        g.setColor(Color.PINK);
        g.fillRect(500, 350, 40, 30);
        g.setColor(Color.GRAY);
        g.fillRect(500, 380, 40, 30);
        g.setColor(Color.BLACK);
        g.drawString("ON", 510, 370);
        g.drawString("OFF", 510, 400);
        
        //draw a picture
        g.setColor(Color.BLACK);
        g.fillRect(500, 100, 200, 200);
        g.drawLine(500, 100, 600, 50);
        g.drawLine(600, 50, 700, 100);
        g.fillOval(595, 50, 10, 10);   
        g.drawImage(Picture, 520, 120, 160, 160, this);
        
    }
}
