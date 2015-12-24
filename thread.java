import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class thread implements Runnable {
    
    caminho exp = new caminho();
    
    escolha_cam ext = new escolha_cam();
     int a= -1;

    
private final Lock _mutex = new ReentrantLock(true);

                Thread t; 
                String threadname;
                String operacao="";
                String NumOrdem="";
                String PeçaOrigem="";
                String PeçaFinal="";
            public    String Quantidade="";
                int m = 0;
                int aux=0;
                  int tarefa=0;
        
                public void run() {
              
        while (true){
             
        /*    try {
                 Thread.sleep(4000);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
             } */
            
            
        for(int n=m ; n < UDPserver.vector.size()  ; n++){
          System.out.println( Arrays.toString( UDPserver.vector.toArray() ) );
          
        operacao = Character.toString(UDPserver.vector.get(n).charAt(1));
      
        for(int i = 2; i <= 4; i++){
            
              NumOrdem += Character.toString(UDPserver.vector.get(n).charAt(i));
           
        }
        
         PeçaOrigem = Character.toString(UDPserver.vector.get(n).charAt(5));
         PeçaFinal = Character.toString(UDPserver.vector.get(n).charAt(6));
        
         for(int i = 7; i<=8; i++)
         {
            Quantidade += Character.toString(UDPserver.vector.get(n).charAt(i));
             
         }
         
         int p1= Integer.parseInt(PeçaOrigem);
         int p2 = Integer.parseInt(PeçaFinal);
         
       // System.out.println("QUANTIDAE NA THREAD _ : "+this.Quantidade);
    
            
         
         
         aux=0;
         
   //  System.out.println("ANTES : aUX : "+aux+" TAMANHO : "+UDPserver.vector.size());
         
       while (aux==0)  {
              try {
                 Thread.sleep(2000);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
             } 
              
              
              
                  //  System.out.println("aUX : "+aux+" TAMANHO : "+UDPserver.vector.size());

   
              /*for(int i= 1; i<=11;i++)
              {
                  modbus.write(i,1);
                  
              }*/
            
             
            
             for(int p=1; p<=11;p++){
                 
             exp.caminho_livre(p);
             
             }
            
         if ( operacao.equals("T") && (modbus.read(9)) == 0 && (modbus.read(80)==0) )   //variavel OCUPADO do isagraf  = 0 
         {   
             
          
             
          
             
             for(int p=1; p<=11;p++){
                 
             exp.caminho_livre(p);
             
             }       
             
             
                System.out.println("Operação de Transformação" );
                modbus.write(1,0);   
                
                //este registo vai ser igualado ao warehouse no isagraf
              
               /* for(int j=11; j<=25;j++)
                {
                    if (modbus.read(j)==0)  // se os caminhos estiverem todos ocupados o programa fica À espera
                       break ; 
                   dfgfadsfas 
                }*/
                GITHUB
             int nigga =  ext.escolha_caminho(p1,p2); 
             
                
             while(nigga==0)
                 
             {
                 System.out.println("Sem caminho disponivel! - Aguarde");
                 nigga= ext.escolha_caminho(p1,p2); 
                 
                 for(int p=1; p<=11;p++){
                 
             exp.caminho_livre(p); //vai actualizando os caminhos para não ficar preso neste ciclo
             
             }
                 
                 
             }



	

                
                
                aux ++;
                
              /*  if (aux>Integer.parseInt(Quantidade))
                {
                    System.out.println("Ordem Concluída");
                    Quantidade ="";
                 PeçaOrigem="";
               PeçaFinal="";
                    break;
                    
                }*/
                
              //  System.out.println("aux " + aux+"  Quantidade " +Integer.parseInt(Quantidade) );
                modbus.write(1,0);
                modbus.write(1,Integer.parseInt(PeçaOrigem));
                
                
               while ((modbus.read(9))!=1)  //enquanto nao receber a peça, o programa fica preso
                {
               System.out.println("aguar dachega de peça");
                    try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
               }
               
                modbus.write(5,0);
               
               while(modbus.read(80) == 1)
               {    //falling edge
                   
                   System.out.println("aguarda falling edge tapete cima");
                   try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
               
               }
               }
               modbus.write(5,0);
 
               
               /*   try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
             } */
            
               // modbus.write(5,0);
                //modbus.write(0,0);
                modbus.write(1,0);
                //modbus.write(2,0);
                
                
                
              

                              
         }
         
         
         
         else  if ( operacao.equals("U") && (modbus.read(9)) == 0 && (modbus.read(80)==0) )  //Descarga
         {
            for (int i=15; i<=16;i++)
                 {exp.caminho_livre(i);}
             
             while((modbus.read(24) == 1 && modbus.read(25)== 1) ==true ||( modbus.read(24)==1))  //2 caminhos dos pushers ocupados
                 
             {   
                 System.out.println("Sem dinspobilidade nos pushers -  Aguarde ou remova uma peça");
                 for (int i=15; i<=16;i++)
                 {exp.caminho_livre(i);}

                 
             }
             
             modbus.write(1,0); 
             modbus.write(0,1);
             
              System.out.println("Operação de Descarga" );
           
             
             
             aux ++;
             
           //  modbus.write(1,Integer.parseInt(PeçaOrigem));
             //modbus.write(2,Integer.parseInt(PeçaFinal)); //que neste caso reperesenta o destino da peça, ou é 1 ou 2
             
             if (Integer.parseInt(PeçaFinal) == 1)
        {
                 
             while(modbus.read(40)==1 )  // pm1
                 
             {
                System.out.println("ROLLER 1 CHEIO - RETIRE UMA PEÇA");
                  
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
             }
             }
             
             modbus.write(5,14);
             
             
         }
             else if (Integer.parseInt(PeçaFinal) == 2)
             {
                 while(modbus.read(41)==1 )  //pm2
                 
             {
                System.out.println("ROLLER 2 CHEIO - RETIRE UMA PEÇA");
                  
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
             }
             }
                 modbus.write(5,15);
                 
         }
             
             modbus.write(1,0);
             modbus.write(1,Integer.parseInt(PeçaOrigem));
             int cont_tempo=0;
             while ((modbus.read(9))!=1)  //enquanto nao receber a peça, o programa fica preso
                {
               cont_tempo++;
                 System.out.println("aguarda chegada de peça");
                    
               try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                    
                    if (cont_tempo >15) //a peça nao quer sair, tenta tirar outra vez
                    {
                        modbus.write(1,0);
                        try {
                 Thread.sleep(100);
             } catch (InterruptedException ex) {
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
             }
                        
                         modbus.write(1,Integer.parseInt(PeçaOrigem));
                        while ((modbus.read(9))!=1)
                        {  System.out.println(" A peça não quis sair, Vai ser feita uma nova tenativa");
                        
                           try {
                        Thread.sleep(1000);
                         } catch (InterruptedException ex) {
                         Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
                          }
                               ///////////////////espera pela peça
                        }
                        
                    }
                        
               }
             
             
             
               
               while(modbus.read(80) == 1)
               {    //falling edge
                   
                   System.out.println("Aguarda falling edge tapete cima");
                   
                   
                   try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
               
               }
               }
               
                           
               
               
               
               
               modbus.write(5,0);

               
             
             //modbus.write(1,0);
    
             
             
             
       /*     try {
                 Thread.sleep(9000);
             } catch (InterruptedException ex) {  //pausa durante 9 segundos para dar tempo de resposta ao isagraf
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
             }*/
       
       
       
       
       
         
         }  
         
         
         
         else  if ( operacao.equals("M") && (modbus.read(9)) == 0 && (modbus.read(80)==0)) //montagem
         {
             modbus.write(1,0); 
             
               System.out.println("Operação de Montagem" );
             
                for (int i=12; i<=13;i++)
                 {exp.caminho_livre(i);
                 System.out.println("Caminho "+i+"  "+modbus.read(i+10));}
             
             aux ++;
             
             
             
             
             if (modbus.read(22) == 0 && modbus.read(80)==0) // POR ISTO A VERIFICAR TBM O SENSOR
             {
                              modbus.write(1,0); 
 System.out.println("Primeira PEÇA");
                 modbus.write(5,12);
                 modbus.write(1,Integer.parseInt(PeçaOrigem));
             modbus.write(2,Integer.parseInt(PeçaFinal));
             }
             else
             {
                 while(modbus.read(22)==1 || modbus.read(80)==1)
                 {
                  for (int i=12; i<=13;i++)
                 {exp.caminho_livre(i);}  
                  
                                        try {
                                       Thread.sleep(1000);   
                                   } catch (InterruptedException ex) {
                                       Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
                                   }
                                        
                  System.out.println("AGUARDE- CAMINHO OCUPADO - robot");
                    
                  
                  
                 }
                 
                 modbus.write(1,0);
                 modbus.write(1,Integer.parseInt(PeçaOrigem));
                 modbus.write(2,Integer.parseInt(PeçaFinal));
                 
             }
             
             
             while(modbus.read(9)==0)
             {
                 
              System.out.println("Aguarda chegada de peça");
         try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
               
               }
             }
             
             modbus.write(5,0);
             
              while(modbus.read(80) == 1)
               {    //falling edge
                   
                   System.out.println("Aguarda falling edge tapete cima");
                   
                   
                   try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
               
               }
               }
              
              
              
              
             
              
              if (modbus.read(80) == 0)
             {
                 
                 System.out.println("SEGUNDA PEÇA");
                              modbus.write(1,0); 

                 modbus.write(5,13);
                // modbus.write(1,Integer.parseInt(PeçaOrigem));
             modbus.write(1,Integer.parseInt(PeçaFinal));
             }
             else
             {
                 while(modbus.read(80)==1)
                 {
                  for (int i=12; i<=13;i++)
                 {exp.caminho_livre(i);}  
                  
                                        try {
                                       Thread.sleep(1000);   
                                   } catch (InterruptedException ex) {
                                       Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
                                   }
                                        
                  System.out.println("AGUARDE- CAMINHO OCUPADO - robot");
                    
                  
                  
                 }
                 
                 
                 
                 modbus.write(1,0);
               //  modbus.write(1,Integer.parseInt(PeçaOrigem));
                 modbus.write(1,Integer.parseInt(PeçaFinal));
                 
             }
             
             
              while(modbus.read(9)==0)
             {
                 
              System.out.println("Aguarda chegada de peça");
         try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
               
               }
             }
              
              modbus.write(5,0);
             
              while(modbus.read(80) == 1)
               {    //falling edge
                   
                   System.out.println("Aguarda falling edge tapete cima");
                   
                   
                   try {
                 Thread.sleep(500);
             } catch (InterruptedException ex) {  
                 Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
               
               }
               }
              
             
                modbus.write(1,0); 
         }
         
         } 
         
         m=n+1;
        }
        
        
        
         
         
        
         
         
    
        }
         
        }
    
     public void start ()
   {
      System.out.println("Starting ");
      if (t == null)
      {
         t = new Thread (this, "1");
         t.start ();
      }
   }

}
    

