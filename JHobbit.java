
package javadevelopment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Azaz
 */
class ValidateImageInvalid extends JPanel{

    public ValidateImageInvalid() {
        setSize(100,100);
    }

    Image bg = new ImageIcon("splash.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }    
}

class ValidateImageValid extends JPanel{

    public ValidateImageValid() {
        setSize(100,100);
    }

    Image bg = new ImageIcon("images.gif").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }    
}

public class JHobbit{
   private static JFrame frame;
   private static JPanel panel;
   private static ValidateImageInvalid validatepanelinvalid=new ValidateImageInvalid();
   private static ValidateImageValid validatepanelvalid=new ValidateImageValid();
   private static JTextField username_txt = new JTextField();
   private static JPasswordField password_txt = new JPasswordField();
   private static String usern;
   private static String pass;
   private static String userentered;
   private static boolean passwordok=false;

   private static Object obj;
   private static Thread t;
        
    static public void ValidateProgram(String _username,String _password) {
        
        obj = new Object();
        synchronized(obj){
        try{     
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
        frame.setSize(380,240);
        frame.setVisible(true);
        frame.setLocation((int)width/3,(int)height/3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setResizable(false);
        
        panel = new JPanel();
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
                      panel.remove(validatepanelinvalid);
                      panel.add(validatepanelvalid);
                      panel.repaint();
                      panel.revalidate();
                     // frame.setVisible(false);
                      
                  }
                  catch(Exception err){
                  }
                 // frame.dispose();
                  //System.out.println( IsUserValidated() );
              }
              else {
                    passwordok = false;
                    panel.remove(validatepanelvalid);
                    panel.add(validatepanelinvalid);
                    panel.repaint();
                    panel.revalidate();
                   // System.out.println(IsUserValidated());
                }
            }
              
            
        });
        
        // --------------------- //
        
        validatepanelinvalid.setLocation(230, 20);
        validatepanelinvalid.setBackground(Color.red);
        
        validatepanelvalid.setLocation(230, 20);
        validatepanelvalid.setBackground(Color.red);
        
        
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
   
    static int FindMaxInArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    static int FindMaxInArray(ArrayList arr) {
        int max = (int)arr.get(0);
        for (int i = 0; i < arr.size(); i++) {

            if (((int)arr.get(i)) > max) {
                max = (int)arr.get(i);
            }
        }
        return max;
    }
    
    
    static int FindMinInArray(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    static int FindMinInArray(ArrayList arr) {
        int min = (int)arr.get(0);
        for (int i = 0; i < arr.size(); i++) {

            if (((int)arr.get(i)) < min) {
                min = (int)arr.get(i);
            }
        }
        return min;
    }
    
    static public String SaveAFile(){
    JFileChooser file  = new JFileChooser();
    file.showSaveDialog(null);
    file.setFileFilter(null);
    String p = file.getSelectedFile().getPath();
    return p;
    }
    
    static public String SaveAFile(String ExtName,String Ext){
        String p = null;
        try {
            JFileChooser file = new JFileChooser();
            file.removeChoosableFileFilter(file.getFileFilter());
            FileNameExtensionFilter fext = new FileNameExtensionFilter(ExtName, Ext);
            file.setFileFilter(fext);
            file.showSaveDialog(null);

            p = file.getSelectedFile().getPath();

        } catch (Exception err) {

        }

        return p;
    }
    
    static public String OpenAFile(){
    String f=null;
    try{
    JFileChooser file = new JFileChooser();
    file.showOpenDialog(null);
    f = file.getSelectedFile().getPath();
    
    }
    catch(Exception err){
    
    }
    
    return f;
    }
    
    static public String OpenAFile(String ExtName,String Ext){
    String f=null;
    try{
    JFileChooser file = new JFileChooser();
    file.removeChoosableFileFilter(file.getFileFilter());
    FileNameExtensionFilter filter = new FileNameExtensionFilter(ExtName,Ext);
    file.addChoosableFileFilter(filter);
    file.showOpenDialog(null);
    f = file.getSelectedFile().getPath();
    
    }
    catch(HeadlessException err){
    
    }
    
    return f;
    }
   
    static public BufferedWriter CreateFile(String FileName){
       FileWriter fwrite=null;
       BufferedWriter bwrite=null; 
       try {
            fwrite = new FileWriter(FileName);
            bwrite = new BufferedWriter(fwrite);
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Unable To Create File");
        }
       return bwrite;
    }
    
    static public void WriteBufferedFile(BufferedWriter _bufferedwriter,String text){
        try {
            _bufferedwriter.write(text);
            _bufferedwriter.close();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Writing Failed");
        }
    }
    
    static public String ReadFile(String filename){
        FileReader fread=null;
        BufferedReader bread =null;
        String data="";
        String tempread=null;
        try {
            fread = new FileReader(filename);
            bread = new BufferedReader(fread);
            while((tempread=bread.readLine())!=null){
            data+=tempread;
            }
            bread.close();
        } catch (Exception err) {
        JOptionPane.showMessageDialog(null, "Unable To Read File");
        }
        
    return data;
    }
    
}

