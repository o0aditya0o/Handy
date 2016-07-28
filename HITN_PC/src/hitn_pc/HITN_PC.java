/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitn_pc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikhil
 */
public class HITN_PC {

    Socket sock=null;
    ServerSocket sser=null;
    static HITN_PC getmeobj;
    /**
     * @param args the command line arguments
     */
    
    class Acceptcon extends Thread{
        public void run(){
            try {
                System.out.println("Yes started");
                sser=new ServerSocket(2000);
                sock=sser.accept();
              System.out.println("Connected client"+sock.getInetAddress());
              BufferedReader bfr=new BufferedReader(new InputStreamReader(sock.getInputStream()));
              String com;
              while(true){
              com=bfr.readLine();
              new ProcessIns(com);
              }
            } catch (IOException ex) {
                Logger.getLogger(HITN_PC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public HITN_PC(){
        System.out.println("const called");
        Thread acth=new Acceptcon();
        acth.start();
       // new ProcessIns("B 100");
    }
    
    public static void main(String[] args) {
        getmeobj=new HITN_PC();
        System.out.println("Main");
        // TODO code application logic here
    }
    
}
