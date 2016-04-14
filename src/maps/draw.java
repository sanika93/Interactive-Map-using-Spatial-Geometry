/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;
import javax.swing.*;
import java.awt.*;
import oracle.spatial.geometry.*;
import java.awt.geom.Point2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics2D;
/**
 *
 * @author sanika
 */
public class draw extends JPanel {
    
    draw() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(700,600));
            
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            DataHandler data=new DataHandler();
            JGeometry[] arrayNew=new JGeometry[20];
        try {
            arrayNew=data.getPoints();
        } catch (SQLException ex) {
            Logger.getLogger(draw.class.getName()).log(Level.SEVERE, null, ex);
        }
            int[] xPoints=new int[4];
            int[] yPoints=new int[4];
            Graphics2D g2 = (Graphics2D) g;
            for(int p=0;p<16;p++){
            double[] getCoordinates=arrayNew[p].getOrdinatesArray();
            xPoints[0]=(int)Math.round(getCoordinates[0]);
            xPoints[1]=(int)Math.round(getCoordinates[2]);
            xPoints[2]=(int)Math.round(getCoordinates[4]);
            xPoints[3]=(int)Math.round(getCoordinates[6]);
            
            yPoints[0]=(int)Math.round(getCoordinates[1]);
            yPoints[1]=(int)Math.round(getCoordinates[3]);
            yPoints[2]=(int)Math.round(getCoordinates[5]);
            yPoints[3]=(int)Math.round(getCoordinates[7]);
            
            g2.setPaint(Color.white);
            g2.fillPolygon(xPoints, yPoints, 4);
            g2.setPaint(Color.black);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawPolygon(xPoints,yPoints,4);
            }
            
           JGeometry[] arrayPond=new JGeometry[20];
        try {
            arrayPond=data.getPondPoints();
        } catch (SQLException ex) {
            Logger.getLogger(draw.class.getName()).log(Level.SEVERE, null, ex);
        }
            Graphics2D g3 = (Graphics2D) g;
            int xLeft=0;
            int yLeft=0;
            int rad=0;
            for(int q=0;q<8;q++){
            
                double[] getCirclePoints=arrayPond[q].getOrdinatesArray();
                xLeft=(int)Math.round(getCirclePoints[0]);
                yLeft=(int)Math.round(getCirclePoints[3]);
                rad=(int)Math.round(getCirclePoints[2]-getCirclePoints[0]);
                
                g3.setPaint(Color.blue);
                g3.fillOval(xLeft, yLeft, rad*2, rad*2);
                g3.setPaint(Color.black);
                g3.setStroke(new BasicStroke(1.5f));
                g3.drawOval(xLeft, yLeft, rad*2, rad*2);

            
            
            }
            
             JGeometry[] arrayLion=new JGeometry[15];
             
             try {
            arrayLion=data.getLionPoints();
        } catch (SQLException ex) {
            Logger.getLogger(draw.class.getName()).log(Level.SEVERE, null, ex);
        }
             
             Graphics2D g4 = (Graphics2D) g;
             int x=0;
             int y=0;
             for(int m=0;m<14;m++){
                 
                 double[] getLionPoints=arrayLion[m].getOrdinatesArray();
                 x=(int)Math.round(getLionPoints[0]);
                 y=(int)Math.round(getLionPoints[1]);
                 
                 g4.setColor(Color.GREEN);
                 g4.fillOval(x, y, 8, 8);
                 
             }
        }
    
}
