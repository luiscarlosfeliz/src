                                                    
import static java.lang.Boolean.TRUE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luigy - POR ACASO ESTE FOI O NUNO!
 */
public class caminho {

     public static boolean caminho_livre(int a) {
 System.out.println(" a testar caminho: " + a);
        switch (a) {
            
           
                        case 1:     if( modbus.read(70) == 0 && modbus.read(80) == 0 ) //verificação de caminho 1 livre:vê se celula1 está livre (70) e o caminho até lá também está livre (50 e 51)
                                    {
                                        modbus.write(11,0);

                                  //      return TRUE;
                                    }

                                    else {
                                        modbus.write(11,1);

                                      //  return TRUE;
                                    }
                        break;
                                     
                        case 2:     if (modbus.read(70) == 0 && modbus.read(80) == 0 )//mesma verificação só que para caminho 2
                                    {
                                        modbus.write(12,0);
                                       // return TRUE;
                                    }

                                    else  {
                                        modbus.write(12, 1);
                                        //return TRUE;
                                    }
                        break;

                        case 3:   if (modbus.read(71)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(13,0);
                                        
                                     //   return TRUE;
                                    }

                                   else {
                                            modbus.write(13,1);
                                         //   return TRUE;
                                        }

                                         break;
                        case 4:   if (modbus.read(71)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(14,0);
                                        
                                    //    return TRUE;
                                    }

                                   else {
                                            modbus.write(14,1);
                                      //      return TRUE;
                                        }         
                                             break;
                        case 5:   if (modbus.read(72)== 0 &&  modbus.read(80) == 0 )
                                    {
                                        modbus.write(15,0);
                                        
                                   //     return TRUE;
                                    }

                                   else {
                                            modbus.write(15,1);
                                          //  return TRUE;
                                        }             
                     break;
        
                        case 6:   if (modbus.read(72)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(16,0);
                                        
                                       // return TRUE;
                                    }

                                   else {
                                            modbus.write(16,1);
                                       //     return TRUE;
                                        }
                                         break;
                        case 7:   if (modbus.read(73)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(17,0);
                                        
                                      //  return TRUE;
                                    }
                                    
                                   else {
                                            modbus.write(17,1);
                                      //      return TRUE;
                                        }
                                    break;
                        case 8:   if (modbus.read(73)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(18,0);
                                        
                                     //   return TRUE;
                                    }

                                   else {
                                            modbus.write(18,1);
                                  //          return TRUE;
                                        }
                                       break;
                        case 9:   if (modbus.read(71)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(19,0);
                                        
                                     //   return TRUE;
                                    }

                                   else {
                                            modbus.write(19,1);
                                       //     return TRUE;
                                        }    
                                             break;
                        case 10:   if (modbus.read(72)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(20,0);
                                        
                                    //    return TRUE;
                                    }

                                   else {
                                            modbus.write(20,1);
                                     //       return TRUE;
                                        }
                                         break;
                        case 11:   if (modbus.read(73)== 0 && modbus.read(80) == 0 )
                                    {
                                        modbus.write(21,0);
                                        
                                     //   return TRUE;
                                    }

                                   else {
                                            modbus.write(21,1);
                                           // return TRUE;
                                        }
                                         break;
                        case 12:   if (modbus.read(74)== 0 && modbus.read(80) == 0)
                                    {
                                        modbus.write(22,0);
                                        
                                      //  return TRUE;
                                    }

                                   else {
                                            modbus.write(22,1);
                                         //   return TRUE;
                                        }
        
                        case 13:   if (modbus.read(74)== 0 && modbus.read(80) == 0)
                                    {
                                        modbus.write(23,0);
                                        
                                        //return TRUE;
                                    }

                                   else {
                                            modbus.write(23,1);
                                       //     return TRUE;
                                        }
        
                        case 14:   if ((modbus.read(75)== 0 && modbus.read(80) == 0) ==true || (modbus.read(80)==0 && modbus.read(42)==1) == true) //sensor pusher 2
                                    {
                                        modbus.write(24,0);
                                        
                                     //   return TRUE;
                                    }

                                   else {
                                            modbus.write(24,1);
                                          //  return TRUE;
                                        }
        
                        case 15:   if (modbus.read(75)== 0 && modbus.read(80) == 0)
                                    {
                                        modbus.write(25,0);
                                        
                                       // return TRUE;
                                    }

                                   else {
                                            modbus.write(25,1);
                                         //   return TRUE;
                                        }
                        
     
        
                    }


                       return TRUE;


                                                }

   
     
  

}



