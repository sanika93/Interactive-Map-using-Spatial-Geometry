/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleResultSet;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;





/**
 *
 * @author sanika
 */
public class DataHandler {
    public DataHandler(){
    
    }
   
    Connection conn;
    Statement stmt;
    String regionID=null;
    String query;
    String sqlString;
    ResultSet rs=null;
    JGeometry[] j_geom=new JGeometry[20];
    int i=0;
    
    
    
    
    public JGeometry[] getPoints() throws SQLException{
        conn = DriverManager.getConnection
                ("jdbc:oracle:thin:sanika/sanika@localhost:1521:XE");
        stmt = conn.createStatement();
        query = "SELECT REGIONSHAPE FROM REGION";
        rs = stmt.executeQuery(query);
        while(rs.next()){
         
         
        STRUCT st = (oracle.sql.STRUCT) rs.getObject("REGIONSHAPE");
        //convert STRUCT into geometry
         j_geom[i] = JGeometry.load(st);
         i++;
        }
        
        return j_geom;
    
}
    
    public JGeometry[] getPondPoints() throws SQLException{
        int p=0;
        JGeometry[] jgeom_pond=new JGeometry[10];
        conn = DriverManager.getConnection
                ("jdbc:oracle:thin:sanika/sanika@localhost:1521:XE");
        stmt = conn.createStatement();
        query = "SELECT CIRCLEPOINT FROM POND";
        rs = stmt.executeQuery(query);
        while(rs.next()){
         
         
        STRUCT st = (oracle.sql.STRUCT) rs.getObject("CIRCLEPOINT");
        //convert STRUCT into geometry
         jgeom_pond[p] = JGeometry.load(st);
         p++;
        }
        
        return jgeom_pond;
    
}
    
    
    public JGeometry[] getLionPoints() throws SQLException{
        int t=0;
        JGeometry[] jgeom_lion=new JGeometry[15];
        conn = DriverManager.getConnection
                ("jdbc:oracle:thin:sanika/sanika@localhost:1521:XE");
        stmt = conn.createStatement();
        query = "SELECT LIONPOINT FROM LION";
        rs = stmt.executeQuery(query);
        while(rs.next()){
         
         
        STRUCT st = (oracle.sql.STRUCT) rs.getObject("LIONPOINT");
        //convert STRUCT into geometry
         jgeom_lion[t] = JGeometry.load(st);
         t++;
        }
        
        return jgeom_lion;
    
}
}
