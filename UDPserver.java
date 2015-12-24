/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author luigy
 */
public class UDPserver {
    
private static modbus conn;
private static thread t;
public static ArrayList<String> vector = new ArrayList();
   
static String inmsgt, Quantidade;

/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatagramSocket socket= null;
                int count = 0;
    
                try{
                    socket = new DatagramSocket(54321);
                                      
                }catch (IOException e){
                    System.out.println(e);
                }
    
               UDPserver.conn  = new modbus();
              UDPserver.conn.connect();
               
          
            //    modbus.write (1,3);
               
//modbus.write(0,1);
  
/*int res;
res=   modbus.read(1); 
System.out.println (res);

*/


UDPserver.t  = new thread ( );
t.start();
 
//thread objeto = new thread();
  //String quantid = objeto.Quantidade;

  String quantidade="";
                    
       boolean runServer = true;
       
       while (runServer) {
           try {
              byte block[]= new byte[256];
              DatagramPacket inpacket = new DatagramPacket(block,block.length); 
              socket.receive (inpacket);
              
               int length = inpacket.getLength();
               System.out.println("Data length; " + length);
               byte inblock[]= inpacket.getData();
               
               
               String inmsg = new String (inblock, 0 , length);
               System.out.println("Server obtained: " + inmsg);
               
               
               if( Character.toString(inmsg.charAt(0)).equals(":"))
               {      
                   
                   
                     for(int i = 7; i<=8; i++)
         
         {
         
             quantidade += Character.toString(inmsg.charAt(i));
             
         }
                     System.out.println("Quantidade = " +quantidade);
                     
                     
                   for (int i = 0; i<Integer.parseInt(quantidade);i++)
                   {
                   vector.add(inmsg);
                   }
                   
                   quantidade ="";
                   inmsgt = inmsg;
       //   System.out.println("Quantidade "+ quantid);
   /*                if(thread.Quantidade != "")
                   {
                   for (int i=1; Integer.parseInt(thread.Quantidade)< i;i++)
                 { System.out.println("QUANTIDADE - "+thread.Quantidade);
                UDPserver.vector.add(inmsg);
                    }
                   }*/
                   
                   
                   System.out.println("NOVA ORDEM : TAMANHO " + vector.size());
                   
                   
                    
               }
               
            
               
                              
               count ++;
               
           } catch(IOException e) {
               
               
               e.printStackTrace();
           }
       }
    }
    
}
