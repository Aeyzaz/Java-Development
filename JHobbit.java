/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javadevelopment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import javax.swing.*;
/**
 *
 * @author Azaz
 */
class ValidateImage extends JPanel{

    public ValidateImage() {
        setSize(100,100);
    }

    Image bg = new ImageIcon("splash.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }    
}

public class Functions{
    static JFrame frame;
    static ValidateImage validatepanel=new ValidateImage();
    
    static JTextField username_txt = new JTextField();
    static JPasswordField password_txt = new JPasswordField();
    static String usern;
    static String pass;
    static String userentered;
    static boolean passwordok=false;

    static Object obj;
    static Thread t;
    static Semaphore semaphore;
        
    static public void ValidateProgram(String _username,String _password) {
        
        semaphore = new Semaphore(1,true);
        
        obj = new Object();
        synchronized(obj){
        try{
            semaphore.acquire();
            
        usern = _username;
        pass = _password;
        
        JLabel username_label = new JLabel("Username");      
        JLabel password_label = new JLabel("Password");
        
        JButton button_login = new JButton("Login");
        button_login.setBackground(Color.LIGHT_GRAY);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
    
        frame = new JFrame("Validate");
        frame.setLayout(null);
        frame.setSize(390,250);
        frame.setVisible(true);
        frame.setLocation((int)width/3,(int)height/3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
        JPanel panel = new JPanel();
        //panel.setBackground(Color.red);
        panel.setLocation(5,5);
        panel.setSize(365,200);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.lightGray);
        
        frame.add(panel);
        
        username_label.setLocation(12,10);
        username_label.setSize(100,20);
        //username_label.setFont(new Font("Serif", Font.BOLD, 20));
        
        username_txt.setLocation(12,30);
        username_txt.setSize(200,30);
        
        password_label.setLocation(12,70);
        password_label.setSize(100,20);
        
        password_txt.setLocation(12,90);
        password_txt.setSize(200,30);
        
        button_login.setLocation(15, 150);
        button_login.setSize(100, 30);
        button_login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              int validateuser= username_txt.getText().compareTo(usern);
              userentered =new String( password_txt.getPassword());
              int validatepass = pass.compareTo(userentered);
              
                  
              if(validateuser==0 && validatepass==0){
                  
                  try{ 
                      passwordok=true;
                      frame.setVisible(false);
                      semaphore.release();
                  }
                  catch(Exception err){
                  }
                  frame.dispose();
                  //System.out.println( IsUserValidated() );
              }
              else {
                    passwordok = false;
                   // System.out.println(IsUserValidated());
                }
            }
              
            
        });
        
        // --------------------- //
        
        validatepanel.setLocation(230, 20);
        validatepanel.setBackground(Color.red);
        
        panel.add(validatepanel);
        
        //----------------------//
        
        panel.add(username_label);
        panel.add(username_txt);
        
        panel.add(password_label);
        panel.add(password_txt);
        
        panel.add(button_login);
               
        
        }
        catch(Exception Err){
        
        }
        
    }
        
    }
    
   static boolean IsUserValidated(){
   return passwordok;
   }
   
   
    
}

