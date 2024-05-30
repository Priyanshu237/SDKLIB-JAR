/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SdkLib.jdbcHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priya
 */
public class DB_handler {

    private String URL,DriverClass,User,Password;
    private ResultSet rs;
    //Constructer for calss
    public DB_handler(String Driverclass,String URL,String User,String Password){
        this.DriverClass=Driverclass;
        this.Password=Password;
        this.URL=URL;
        this.User=User;
    }
    
    public  void insertData(String Table,String[] data) throws ClassNotFoundException, SQLException{
        String qu="insert into "+Table+" values(";
        for(int i=0;i<data.length;i++){
            qu=qu+data[i];
            if(i<data.length-1)
                qu=qu+",";
            else qu=qu+")";
        }
       rs=execute(qu);
    }
    
    
    
    public void  getTable(String Table) throws ClassNotFoundException, SQLException{
     rs=execute("Selet * from "+Table);
    }
    
    public void getColumn(String Table,String ColumnLabel) throws ClassNotFoundException, SQLException{
        rs=execute("select "+ColumnLabel+" from "+Table);
    }
    
    public void GetRow(String Table,String ColumnLabel,String data) throws ClassNotFoundException, SQLException{
        rs=execute("select * from "+Table+" where "+ColumnLabel+"="+data);
    }
    
    public void GetColumnItem(String Table,String ColumnLabel,String Data) throws ClassNotFoundException, SQLException{
         rs=execute("select "+ColumnLabel+" from "+Table+" where "+ColumnLabel+"="+Data);
    }
    
    public void getForignKeyTableValue(String mainTable,String subTable,String subColumnLabel,String MainColumnLabel,String value) throws ClassNotFoundException, SQLException{
        rs=execute("select * from" +subTable+" where "+subColumnLabel+"=(select * from "+ mainTable+" Where "+MainColumnLabel+"="+value);
    }
    
    public ResultSet execute(String Query) throws ClassNotFoundException, SQLException{
        Class.forName(DriverClass);  
        Connection con=DriverManager.getConnection(URL,User,Password);
        Statement stmt=con.createStatement();  
        rs=stmt.executeQuery(Query);
        con.close();
        return rs;
    }
    
    //This  methos is for getting onle putticulat column and returns 1 D array as result  
    public String[] resultSetToS1DArray(String ColumnLabel) throws SQLException
    {
         ArrayList<String> arr=new ArrayList<String>();
        while(rs.next()){  
            arr.add(rs.getString(ColumnLabel));
        }
        String[] lists=new String [arr.size()];
        for(int i=0;i<arr.size();i++){
            lists[i]=arr.get(i);
            System.out.println(lists[i]);
        }        
      return lists;
    }
    
    public String [][] resultSetTo2DArray() throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
        List<Object[]> records = new ArrayList<>();

        while (rs.next()) {
            Object[] row = new Object[numberOfColumns];
            for (int i = 0; i < numberOfColumns; i++) {
                row[i] = rs.getObject(i + 1);
            }
            records.add(row);
        }

        Object[][] tableArray = new Object[records.size()][numberOfColumns];
        for (int i = 0; i < records.size(); i++) {
            tableArray[i] = records.get(i);
        }

        return (String[][]) tableArray;
    }
    
   
    
    
}
