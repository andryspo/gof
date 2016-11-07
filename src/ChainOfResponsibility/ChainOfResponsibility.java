package ChainOfResponsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        FileLogger logger1 = new FileLogger(Level.DEBUG);
        SMSLogger logger0 = new SMSLogger(Level.ERROR);
        logger0.setNext(logger1);
        logger0.writeMessage("Error message", Level.ERROR);
        logger0.writeMessage("Debug message", Level.DEBUG);
        logger0.writeMessage("Info message", Level.INFO);
    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger{
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger{
    int priority;
    Logger next;

    public SMSLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if(priority >= level)
        {
            System.out.println("sms: " + message);
        }
        if(next != null)
        {
            next.writeMessage(message, level);
        }
    }
}
class FileLogger implements Logger{
    int priority;
    Logger next;

    public FileLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if(priority >= level)
        {
            System.out.println("File: " + message);
        }
        if(next != null)
        {
            next.writeMessage(message, level);
        }
    }
}