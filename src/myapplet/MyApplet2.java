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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohab
 */
public class MyApplet2 extends Applet{
            Image Picture;
            boolean on = true,windowon = false;
            int x = 0,y = 0;
            int minuts ;
            int hours ;
            int sec ;
            boolean onwatch =false;
      public void init() {  
         resize(1000, 1000);
         //Picture = getImage(getDocumentBase(),"flower.jfif");
         Picture = getImage(getDocumentBase(),"up.jpg");
         this.addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 
             }

             @Override
             public void mousePressed(MouseEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 x = e.getX();
                 y = e.getY();
                 if((x>=500 && x<=540) && (y>=350 && y<=380))
                 {
                     on = true;
                     windowon =false;
                 }else if((x>=500 && x<=540) && (y>=380 && y<=410))
                 {
                     on = false;
                     windowon = true;
                 }
                 repaint();
                 System.out.println("("+x+" "+y +")");
             }

             @Override
             public void mouseReleased(MouseEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
         });
         Thread th = new Thread(new Runnable(){
             @Override
             public void run() {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 while(true)
                 {
                     repaint();
                     if(onwatch == false)
                     {
                         onwatch = true;
                     }else
                     {
                         onwatch =false;
                        }
                     try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MyApplet2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
                     
                 }
             }
         });
         th.start();
        }
      public void RightWall(Graphics g,boolean on)
      {
         Color pink = null,gray = null,black = Color.BLACK;
         Color brown = null,whiteBrown = null;
         Color yellow = null,red = null,disk1 = null,disk2 = null;
         Color[] state = new Color[2];
        if(on == true)
          {
              brown = new Color(80,30,30);
              whiteBrown = new Color(220,200,200);
              yellow = Color.YELLOW;
              red = Color.RED;
              state[0] = new Color(220,100,100);
              state[1] = Color.GRAY;
              disk1 = new Color(60,30,150);
              disk2 = new Color(120,60,140);
          }else
          {
                state[0] = Color.GRAY;
                state[1] = new Color(220,100,100);
                brown = new Color(100,80,80);
                red = new Color(100,0,0);
                yellow = new Color(200,200,200);
                gray = new Color(80,80,80);
                whiteBrown = new Color(160,160,160);
                disk1 = new Color(50,13,140);
                disk2 = new Color(70,30,80);
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
        //drawDisk
        
        g.setColor(disk1);
        g.fillRect(470,550,300,20); //first line =======================
        
        g.setColor(disk2);
        g.fillRect(500,570,240,80); //second line
        g.fillRect(540,650,40,100); //left leg
        g.fillRect(660,650,40,100); //Right leg
        //dowar
        g.setColor(Color.BLACK);
        g.drawRect(520,590,200,40);
        g.fillOval(610,600,20,20);
        
        //Timer
        g.fillRect(500,500,180,50);
        
        Font f =new Font("Dialog",Font.ITALIC,35);
        g.setFont(f);
        g.setColor(Color.GREEN);
        LocalDateTime now = LocalDateTime.now();
        minuts = now.getMinute();
        hours = now.getHour();
        sec = now.getSecond();
        String m;
        if(hours>12)
        {
            hours = hours - 12;
            m = new String("pm");
        }else
        {
            m = new String("am");
        }
        g.drawString( hours + "   " + minuts + "  " + m, 510 , 540 );
        if(onwatch == true)
        {
            g.drawString( ":", 540 , 538 );
        }else
        {
            g.drawString( "  ", 540 , 538 );
        }
        
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
        g.fillOval(325, 100, 30, 30);

        //holder       
        g.setColor(brown);
        g.fillRect(330, 160, 20, 70);
        g.fillRect(330, 230, 200, 20);
        g.setColor(black);
        g.fillRect(440, 210, 10, 60);
        
        g.setColor(gray);
        g.fillRect(330, 130, 20, 30);
        //draw lamp body
        g.setColor(black);
        //g.drawLine(150, 50, 100, 200);
        //g.drawLine(350, 50, 400, 200);
        g.drawLine(290, 50, 240, 150);
        g.drawLine(390, 50, 440, 150);
        int j = 4;
        int x = 0;
        for(int i=292;i<390;i+=2)
        {
            g.setColor(lines);
            g.drawLine(i, 50,240+ j, 150);
            g.setColor(red);
            g.drawLine(i , 130 ,240+ j, 150);//210
            j+=4;
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
        window(g,on);
      }
      public void HallWay(Graphics g,boolean on)
      {
         Color light = null,backRoom =null,carpet = null,snow = null;
         
          Random R = new Random();
          int num = 7;
          int max = R.nextInt(num);
          int num2 = R.nextInt(40);
        if(on == true)
          {
              light = new Color(220,210,80);
              backRoom = new Color(70,10,200);
              carpet = new Color(215,50,50);
          }else
          {
                light = new Color(100,100,100);
                backRoom = new Color(70,100,150);
                carpet = new Color(120,30,30);
                snow = Color.white;
          }
        if(18 <= hours && hours >= 6)
        {
            snow = new Color(150,150,200);
        }
        int x2[] = { 450, 0, 200, 200,450};
        int y2[] = { 800, 800, 500, 0,0};
        //lightup
        g.setColor(light);
        g.fillPolygon(x2, y2, 5);
        int x1[] = { 200, 450, 450, 200};
        int y1[] = { 300, 300, 320, 320};
        //backroom line
        g.setColor(Color.BLACK);
        g.fillPolygon(x1, y1, 4);
        
        int x3[] = { 200, 450,450,200};
        int y3[] = { 300, 300,0,0};
        //back room wall
        g.setColor(backRoom);
        g.fillPolygon(x3, y3, 4);
        
        int x4[] = { 150 , 450, 450,330};
        int y4[] = { 700 , 700, 400,400};
        //carpet
        g.setColor(carpet);
        g.fillPolygon(x4, y4, 4);
        //Ice Fall
        if(windowon == true)
        {
            
            g.setColor(snow);
            for(int i=0;i<max;i++)
            {
                g.fillOval(40 + (i*20) -5 , 320 -(i*16)-20+num2/2, 5, 5); 
            }
            num2 = R.nextInt(num*5);
            max = max = R.nextInt(num);
            for(int i=0;i<max;i++)
            {
                g.fillOval(40 + (i*20) +num2, 320 -(i*16)+num2/2, 5, 5); 
            }
            num2 = R.nextInt(num*5);
            max = max = R.nextInt(num);
            for(int i=0;i<max;i++)
            {
                g.fillOval(40 + (i*20) -5+num2, 320 -(i*16) +20 +num2/2, 5, 5); 
            }
            num2 = R.nextInt(num*5);
            max = max = R.nextInt(num);
            for(int i=0;i<max;i++)
            {
                g.fillOval(40 + (i*20) +num2, 320 -(i*16)+40 + num2/2, 5, 5);
            }
            num2 = R.nextInt(num * 5);
            max = max = R.nextInt(num);
            for(int i=0;i<max;i++)
            {
                g.fillOval(40 + (i*20) -5 + num2, 320 -(i*16)+60 +num2/2, 5, 5); 
            }
            
            
        }
      }
      public void window(Graphics g,boolean on)
      {
          Color ground = null,sky = null,lines = null;
        if(on == true)
          {
              ground = new Color(150,170,170);
              lines = Color.WHITE;
          }else
          {
              ground = new Color(150,170,170);
              lines = Color.WHITE;
          }
        if(18 <= hours && hours >= 6)
        {
            sky = new Color(60,220,220);
        }else
        {
            sky = new Color(18,23,84);
            
        }
        //ground
        int x[] = { 30, 150, 150, 30};
        int y[] = { 430, 300, 200, 300};
        g.setColor(ground);
        g.fillPolygon(x, y, 4);
        
        //sky
        int x1[] = { 30, 150, 150, 110, 90, 60 , 30};
        int y1[] = { 300, 200, 260, 270, 280, 290,360};
        g.setColor(sky);
        g.fillPolygon(x1, y1, 7);
        g.setColor(lines);
        //ice lines
        g.drawLine(70, 300, 110, 290);
        g.drawLine(60, 330, 110, 320);
        g.drawLine(60, 310, 110, 310);
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
}
