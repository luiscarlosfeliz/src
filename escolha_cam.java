/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luigy
 */
public class escolha_cam {
   
    private static int tarefa;
    
         public static int escolha_caminho(int p1,int p2) {
             
if (p1==2 && p2==3)  //(* p2 ->p3*)

tarefa = 1;

else if (p1==1 && p2==5)  

tarefa =2;
        
else  if( p1==6 && p2==7) 

tarefa =3;

else if (p1==5 && p2==6) 

tarefa =4;

else if (p1==5 && p2==8)  

tarefa =5;

else if (p1==8 && p2==9) 

tarefa =6;

else if (p1==1 && p2==2) 

tarefa =7;

else if (p1==3 && p2==4)  

tarefa =8;

else if (p1==8 && p2==7) 

tarefa =9;

else if (p1==1 && p2==6) // (*caminho especial*)

tarefa =10;

else if  (p1==1 && p2==8)// (*caminho especial*)

tarefa = 11;



         


int c=0;

switch( tarefa ){ 

    case 1: 
       /* exp.caminho_livre(1);
        exp.caminho_livre(3);
        exp.caminho_livre(5);
        exp.caminho_livre(7);        */
        
        
        if( modbus.read(11) == 0) //se cam[1] ==0     //(*se caminho 1 esta livre, então o caminho 1 será escolhido e guardado na variavel C *)

    {modbus.write(5,1);   c=1;}
    
    else if (modbus.read(13) == 0) 

    {modbus.write(5,3);   c=3;}
  
   
    else if (modbus.read(15) == 0) 

    {modbus.write(5,5);   c=5;}

   else if (modbus.read(17) == 0) 

   {modbus.write(5,7);   c=7;}

    break;

    
    
    
    
    
    case 2:     
        
    /*    exp.caminho_livre(3);
        exp.caminho_livre(5);
        exp.caminho_livre(7);*/
        
        
        if (modbus.read(11) == 0) 

    {modbus.write(5,1);  
    c=1;}
    else if (modbus.read(13) == 0) 

    {modbus.write(5,3);   c=3;}
  
   
   else if (modbus.read(15) == 0) 

   {modbus.write(5,5);   c=5;}

   else if (modbus.read(17) == 0) 

   {modbus.write(5,7);   c=7;}

    break;

    
    
    
    
    
    
    case 3:  
        
        /*exp.caminho_livre(1);
        exp.caminho_livre(3);
        exp.caminho_livre(5);
        exp.caminho_livre(7);*/
        
        
        
       
        if (modbus.read(11) == 0) 

    {modbus.write(5,1);  c=1;}
    
    else if (modbus.read(13) == 0) 

    {modbus.write(5,3);   c=3;}
  
   
   else if (modbus.read(15) == 0) 

   {modbus.write(5,5);   c=5;}

   else if (modbus.read(17) == 0) 

   {modbus.write(5,7);   c=7;}

    break;


    
    
    
    case 4:  
        
    /*    exp.caminho_livre(4);
        exp.caminho_livre(6);
        exp.caminho_livre(8);*/
        
        
        
        
        if (modbus.read(14) == 0) 

    {modbus.write(5,4);   c=4;}

   else if (modbus.read(16) == 0) 

   {modbus.write(5,6);   c=6;}
   
   else if (modbus.read(18) == 0) 

   {modbus.write(5,8);   c=8;}

break;
   





    case 5: 
        
    /*    exp.caminho_livre(4);
        exp.caminho_livre(6);
        exp.caminho_livre(8);*/
        
        
        if (modbus.read(14) == 0) 

    {modbus.write(5,4);   c=4;}

   else if (modbus.read(16) == 0) 

   {modbus.write(5,6);   c=6;}
   
   else if (modbus.read(18) == 0) 

   {modbus.write(5,8);  c=8;}

break;






    case 6: 
        
       /* exp.caminho_livre(4);
        exp.caminho_livre(6);
        exp.caminho_livre(8);
        */
        
        
        if (modbus.read(14) == 0) 

    {modbus.write(5,4);   c=4;}

   else if (modbus.read(16) == 0) 

   {modbus.write(5,6);   c=6;}
   
   else if (modbus.read(18) == 0) 

   {modbus.write(5,8);  c=8;}

break;



    case 7: 
        
     //   exp.caminho_livre(2);
        
        if (modbus.read(12) == 0) 

    {modbus.write(5,2);   c=2;}

            break;


    case 8:  
        
   //     exp.caminho_livre(2);
        
        if (modbus.read(12) == 0) 

   {modbus.write(5,2);   c=2;}
            break;




    case 9: 
  //      exp.caminho_livre(2);
        
        if (modbus.read(12) == 0) 

   {modbus.write(5,2);   c=2;}
            break;

 

    case 10: 
       /* 
        exp.caminho_livre(11);
        exp.caminho_livre(10);
        exp.caminho_livre(9);*/
        
        
        
        if(modbus.read(21) ==0)   //(*caminho 8 = 0 equivale a caminho  11 =0*) 

    {modbus.write(5,11); c=11;}

    else if    (modbus.read(20) ==0)
	
    {modbus.write(5,10); c=10;}
    
    else if (modbus.read(1) ==0)

            {modbus.write(5,9); c=9;}

break;



    case 11: 
        
       /* exp.caminho_livre(11);
        exp.caminho_livre(10);
        exp.caminho_livre(9);
        */
        
        
        if(modbus.read(21) ==0)   //(*caminho 8 = 0 equivale a caminho  11 =0*) 

    {modbus.write(5,11); c=11;}

    else if    (modbus.read(20) ==0)
	
    {modbus.write(5,10); c=10;}
    
    else if (modbus.read(19) ==0)

            {modbus.write(5,9); c=9;}

break;




}

switch (c) {
 
    case 1: if (tarefa == 1)  

	modbus.write(31,1);

    else if (tarefa ==2) 
    modbus.write(31,2);
    
    else if (tarefa ==3)
    modbus.write(31,3); //ToolAc1
break;

    case 2: if (tarefa ==7)  
        modbus.write(38,1);//toolC_c1


    else if (tarefa ==8)

    modbus.write(38,2); //toolC_c1

    else if( tarefa ==9)
    modbus.write(38,3); //toolC_c1

 break;


    case 3: if (tarefa == 1) 

	 modbus.write(32,1); //toolA_c2

    else if( tarefa ==2)
	 modbus.write(32,2); //toolA_c2  

    else if (tarefa ==3)
 modbus.write(32,3); //toolA_c2
	break;

    case 4: if (tarefa==4)   

	 modbus.write(35,1); //toolB_c2

    else if (tarefa==5)   

	 modbus.write(35,2); //toolB_c2

   else if (tarefa==6)   

	 modbus.write(35,3); //toolB_c2
break;



    case 5: if (tarefa == 1) 

	modbus.write(33,1); //toolA_c3

    else if (tarefa ==2)
        modbus.write(33,2); //toolA_c3
  

   else if (tarefa ==3)
        modbus.write(33,3); //toolA_c3

	break;

        
        
    case 6: if (tarefa==4) 

	 modbus.write(36,1) ;//toolB_c3

    else if( tarefa ==5)  
	
	modbus.write(36,2) ;//toolB_c3

    else if( tarefa ==6)  
	
	modbus.write(36,3) ;//toolB_c3
   break;

    case 7:  if( tarefa ==1) 

	modbus.write(34,1); //toolA_c4

    else if( tarefa ==2) 

	modbus.write(34,2); //toolA_c4 

  else if( tarefa ==3) 

	modbus.write(34,3); //toolA_c4  
break;


    case 8: if( tarefa ==4) 

	modbus.write(37,1); //toolB_c4  

    else  if( tarefa ==5) 

	modbus.write(37,2); //toolB_c4 

   else  if( tarefa ==6) 

	modbus.write(37,3); //toolB_c4 

    
    break;
            
           
    case 9: if (tarefa==10) 
    {
	modbus.write(32,2);//ToolA_celula2 := 2;
	modbus.write(35,1);//ToolB_celula2 := 1;
    }
    else if (tarefa == 11)  
    {
	modbus.write(32,2);//ToolA_celula2 := 2;
	modbus.write(35,2);//ToolB_celula2 := 2;
    }
break; 

    case 10: if (tarefa==10) 
    {
	modbus.write(33,2);//ToolA_celula3 := 2;
	modbus.write(36,1);//ToolB_celula3 := 1;
    }
    else if (tarefa == 11)  
    {
	modbus.write(33,2);//ToolA_celula3 := 2;
	modbus.write(36,2);//ToolB_celula3 := 2;
    }
break; 


    case 11: if (tarefa==10) 
    {
	modbus.write(34,2);//ToolA_celula3 := 2;
	modbus.write(37,1);//ToolB_celula3 := 1;
    }
    else if (tarefa == 11)  
    {
	modbus.write(34,2);//ToolA_celula3 := 2;
	modbus.write(37,2);//ToolB_celula3 := 2;
    }
break; 

 

}

return c;
         }

    
}
