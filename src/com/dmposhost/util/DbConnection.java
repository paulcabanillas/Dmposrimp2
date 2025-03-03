package com.dmposhost.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import javax.swing.JOptionPane;
 
/**
 * Clase que permite conectar con la base de datos
 * @author pcc
 *
 */
public class DbConnection {
   /**Parametros de conexion*/
   static String bd = "dmticket";
   static String login = "root";
   static String password = "root2";
   String ipbd = "";
   String url  = "";
   //Pruebas
   //static String url = "jdbc:mysql://10.10.33.8:3306/"+bd;
   //static String url = "jdbc:mysql://10.10.33.105:3306/"+bd;
   //static String url = "jdbc:mysql://localhost/"+bd;//
   
 
   Connection connection = null;
 
   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //Obteniendo IP de la BD
         validaConArchivoIni();
         url = "jdbc:mysql://"+ipbd+"/"+bd;
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexi�n
         connection = DriverManager.getConnection(url,login,password);
 
         if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" " +url+ " OK\n");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexi�n*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      //connection = null;
      try {
        connection.close();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexion", "Error", JOptionPane.ERROR_MESSAGE);
                //Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, sqle);
            }     
   }
   private void validaConArchivoIni(){
        //String ipbd="";
        String[] splitLine=null;
        //boolean accesoCorrecto=false;
        try{
                BufferedReader br = new BufferedReader(new FileReader("C:\\DmPosRimp\\DmPos.ini"));
                String line = br.readLine();
                while (line != null) {
                    if(line!=null && line.trim().compareTo("")!=0){
                        if(line.startsWith("IPBD")){
                           splitLine=line.split("=");
                           ipbd=splitLine[1];
                        }
                    }
                    line = br.readLine();
                }
                if ((ipbd.trim().equals(""))){
                    ipbd="localhost";
                }
               
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "NO SE PUEDE LEER ACHIVO DE CONFIGURACION DMPOS.INI");
            }
    }
}