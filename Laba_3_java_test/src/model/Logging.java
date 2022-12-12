package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.*;
import java.util.ArrayList;

public class Logging {
	private static ArrayList<Exception> ErrList = new ArrayList<Exception>();
    private static Logger logger = null;
    public Logging() {
        ErrList = new ArrayList();
        //������ ���������������� ���� ����
        try {
            LogManager.getLogManager().readConfiguration(Logging.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger = Logger.getLogger(Logging.class.getName());
    }
    public static void log(String msg) throws IOException {
        logger = Logger.getLogger(Level.INFO.getClass().getName());
        logger.setUseParentHandlers(false);
        FileHandler fh;
        fh = new FileHandler("app.log", true);
        try {
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format(Level.INFO.getClass().getName().toUpperCase() + " | " + format,
                            new Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getMessage()
                    );
                }
            });
           
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        logger.log(Level.INFO, "\n\t>>"+msg);
        fh.close();
    }
    public static void log_test(String file, String msg) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.append(msg + '\n');
        fw.flush();
    }
}