/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitn_pc;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikhil
 */
public class ProcessIns {
    String ins=null;
    Robot ro;
    void princha(char c){
                    if (Character.isUpperCase(c)) {
                    ro.keyPress(KeyEvent.VK_SHIFT);
                }
                    ro.keyPress(Character.toUpperCase(c));
                    ro.keyRelease(Character.toUpperCase(c));

                if (Character.isUpperCase(c)) {
                    ro.keyRelease(KeyEvent.VK_SHIFT);
                }
    }
    
    
    void proc(String ins){
        try{
        ro=new Robot();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        if(ins.charAt(0)=='M'){
            if(ins.charAt(1)=='m'){
                int x1=Integer.parseInt(ins.substring(3, 8));
                int y1=Integer.parseInt(ins.substring(9, 14));
                //System.out.println(x1+"Mouse moved "+ins.substring(3, 8)+" "+ins.substring(9,14));
                ro.mouseMove(x+x1/10,y-y1/10);
            }
            else if(ins.charAt(1)=='c'){
                if(ins.charAt(3)=='r'){
                    // RIGHT CLICK
                    ro.mousePress(InputEvent.BUTTON3_MASK);
                    ro.mouseRelease(InputEvent.BUTTON3_MASK);
                }
                else if(ins.charAt(3)=='l')
                {
                     // LEFT CLICK
                    ro.mousePress(InputEvent.BUTTON1_MASK);
                    ro.mouseRelease(InputEvent.BUTTON1_MASK);
                    
                }
                else if(ins.charAt(3)=='m'){
                        // MIDDLE WHEEL CLICK
                    ro.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    ro.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                        }
            }
        }
        else if(ins.charAt(0)=='B'){
            
            int bright=Integer.parseInt(ins.substring(2));
            bright=(int)(9.37*bright);
            String s[]={"/bin/sh","-c","echo "+bright+" > /sys/class/backlight/intel_backlight/brightness"};
            System.out.println(s[2]);
            try {
                Runtime.getRuntime().exec(s);
            } catch (IOException ex) {
                Logger.getLogger(ProcessIns.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ins.charAt(0)=='S'){
            int volume=Integer.parseInt(ins.substring(2));
            String s[]={"/bin/sh","-c","amixer -D pulse sset Master "+volume+"%"};
            try {
                Runtime.getRuntime().exec(s);
            } catch (IOException ex) {
                Logger.getLogger(ProcessIns.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ins.charAt(0)=='P'){
            String s[]={"/bin/sh","-c","gedit"};
            try {
                Runtime.getRuntime().exec(s);
            } catch (IOException ex) {
                Logger.getLogger(ProcessIns.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ins.charAt(0)=='L'){
            String s[]={"/bin/sh","-c","sudo pkill -u "+ins.substring(2)};
            try {
                Runtime.getRuntime().exec(s);
            } catch (IOException ex) {
                Logger.getLogger(ProcessIns.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public ProcessIns(String s){
        ins=s;
        proc(ins);
    }
}
