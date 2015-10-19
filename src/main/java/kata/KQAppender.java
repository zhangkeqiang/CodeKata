package kata;

import java.io.IOException;


import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class KQAppender extends RollingFileAppender {
    

    public KQAppender(){
        super();
        //fileName = "e:\\KQloginclass.log"; 
        layout = new PatternLayout("%d{ISO8601} %C %l %-4r %-5p [%t] %37c %3x - %m  %n");
    }
    
    @Override
    public boolean requiresLayout() {
        return (layout == null); 
    }
    
    public synchronized void setFile(String fileName, boolean append,  
            boolean bufferedIO, int bufferSize) throws IOException {  
        String temp;
        if(fileName == null){
            temp =  "e:\\KQloginclass.log"; 
        }else {
            temp = fileName;
        }

        super.setFile(temp, append, bufferedIO, bufferSize);  
    }  
}
