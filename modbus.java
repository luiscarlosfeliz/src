

import java.io.PrintStream;
import java.net.InetAddress;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadInputRegistersRequest;
import net.wimpi.modbus.msg.ReadInputRegistersResponse;
import net.wimpi.modbus.msg.WriteMultipleRegistersRequest;
import net.wimpi.modbus.net.TCPMasterConnection;
import net.wimpi.modbus.procimg.InputRegister;
import net.wimpi.modbus.procimg.Register;
import net.wimpi.modbus.procimg.SimpleRegister;

public class modbus
{
  private static final String endereco = "127.0.0.1";
  private static final int port = 502;
  static TCPMasterConnection con = null;
  static ModbusTCPTransaction trans = null;
  
  public void connect()
  {
    try
    {
      InetAddress addr = InetAddress.getByName("127.0.0.1");
      con = new TCPMasterConnection(addr);
      con.setPort(502);
      con.connect();
      System.out.println("Ligaçao feita com sucesso!");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Ligacaçao sem sucesso!");
    }
  }
  
  public static synchronized boolean write(int register, int value)
  {
    Register reg = new SimpleRegister(value);
    WriteMultipleRegistersRequest req = new WriteMultipleRegistersRequest(register, new Register[] { reg });
    
    trans = new ModbusTCPTransaction(con);
    trans.setRequest(req);
    try
    {
      trans.execute();
      
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("ERRO A ESCREVER!");
    }
    return false;
  }
  
  public static synchronized int read(int register)
  {
    ReadInputRegistersRequest req = new ReadInputRegistersRequest(register, 1);
    ReadInputRegistersResponse res = null;
    
    trans = new ModbusTCPTransaction(con);
    trans.setRequest(req);
    try
    {
      trans.execute();
      res = (ReadInputRegistersResponse)trans.getResponse();
      
      return res.getRegister(0).getValue();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("ERRO A LER!");
    }
    return 0;
  }
  
  public void disconnect()
  {
    con.close();
  }
}
