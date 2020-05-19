package librarymanagementsystem.Toolkit;

import java.io.InputStream;
import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;

public class SerialConnection {
    static private String port = "COM3"; // Cổng phổ biến của arduino uno
    private SerialPort sp;
    static String current_ID = "";
    
    public SerialConnection(){
        sp = SerialPort.getCommPort(port);
        sp.setComPortParameters(9600, 8, 1, 0); // Cái này mặc định cho arduino
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
    }
    
    public Boolean kiemTraPort(){
        return sp.openPort();
    }
    
    public String readData(){
        if (sp.openPort()) {
            System.out.println("Port is open :)");
            InputStream in = sp.getInputStream();
            String data_in = "";
            try{
                for (int j = 0; j < 12; j++){
                    data_in += (char)in.read();
                }
                data_in = data_in.substring(1, data_in.length());
                //System.out.println(data_in);
                in.close();
            } 
            catch (Exception e){
                e.printStackTrace(); 
            }
            
            sp.closePort();
            current_ID = data_in;
            return data_in;
        }
        else {
            //Thread.sleep(10000);
            System.out.println("Failed to open port :(");
            current_ID = "";
            return "";
        }     
        
    }
    
    public static String getCurrent_ID() {
        return current_ID;
    }
    
    // This for testing
    /*public static void main(String[] args)  throws IOException, InterruptedException{
        SerialPort sp = SerialPort.getCommPort(port);
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        
        if (sp.openPort()) {
            System.out.println("Port is open :)");
            InputStream in = sp.getInputStream();
            String data_in = "";
            try
            {
               for (int j = 0; j < 12; ++j)
                  //System.out.print((char)in.read());
                  data_in += (char)in.read();
                  //in.read(data_in, 0, 12);
                  //for (byte o : data_in){
                    //System.out.print(o + " ");
                  //}
                data_in = data_in.substring(1, data_in.length());
                System.out.println(data_in);
               in.close();
            } catch (Exception e) { e.printStackTrace(); }
        } else {
          System.out.println("Failed to open port :(");
          return;
        }        
        sp.closePort();
    
        System.out.print(new SerialConnection().readData());
    }*/

}
