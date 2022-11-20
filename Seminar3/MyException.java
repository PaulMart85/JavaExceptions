package Seminar3;

import java.io.IOException;

public class MyException extends Exception {
    
    public MyException(ErrorCode errCode) {
        super(errCode.getErrorStr());
    }

    public MyException(ErrorCode wrongFile, IOException ex) {
        super(wrongFile.getErrorStr() + ex.fillInStackTrace());
    }


}
