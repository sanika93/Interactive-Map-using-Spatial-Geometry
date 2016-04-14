/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanika
 */
public class spatialMap extends JFrame{
    
        private JPanel draw;
        public spatialMap() {
        this.setTitle("Simple DRAW");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        draw=new draw();
        
        JPanel UIPanel=new JPanel();
        JCheckBox selectRegion=new JCheckBox();
        selectRegion.setText("Show all lions and ponds in the selected region");
        UIPanel.add(selectRegion);
        
        
        
        mainPanel.add(draw);
        mainPanel.add(UIPanel);
        
        this.setContentPane(mainPanel);
    }
    

    
    
   public static void main(String[] args){
    
        spatialMap frame = new spatialMap();
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700,600);
        
    }
}
