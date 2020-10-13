package com.company;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
//    private LoggerType loggerType;

    ColoredPrinter coloredPrinter = new ColoredPrinter.Builder(1, false)
            .foreground(Ansi.FColor.WHITE)
            .background(Ansi.BColor.BLUE)
            .build();

    private Logger() {
        System.out.println("Initializing Logger object");
    }

    public static Logger getInstance() {
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
        }
        return instance;
    }

    public void show(String content, LoggerType loggerType) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss ");
        LocalDateTime now = LocalDateTime.now();
        String strDate = dtf.format(now);

        switch (loggerType) {
            case WARNING:
                coloredPrinter.print("\n" + strDate + content,
                        Ansi.Attribute.BOLD,
                        Ansi.FColor.YELLOW,
                        Ansi.BColor.BLACK);
            case ERROR:
                coloredPrinter.print("\n" + strDate + content,
                        Ansi.Attribute.BOLD,
                        Ansi.FColor.RED,
                        Ansi.BColor.BLACK);
            case INFO:
                coloredPrinter.print("\n" + strDate + content,
                        Ansi.Attribute.NONE,
                        Ansi.FColor.GREEN,
                        Ansi.BColor.BLACK);
        }
    }
}
