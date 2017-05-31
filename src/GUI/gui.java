package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class gui{
        JFrame jf;
        JPanel jp;
        JTextArea jt;
        static int count =0;
        public gui(){
            jf  = new JFrame("Output");
            jp = new JPanel();
            jt = new JTextArea(20,20);
            jp.add(jt);
            jf.getContentPane().add(BorderLayout.CENTER,jp);
            jf.setSize(300,600);
            jf.setVisible(true);
        }

        public void showP(int i){
            jt.append(i + "-->");
            count ++;
            if(count %5 ==0){
                jt.append("\r\n");
            }
        }
        /*public static void main(String[] args){
            gui g = new gui();
        }*/
}