package Command;

/**
 * Created by andry on 15/10/2016.
 */

class Main{
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new startCommand(comp),new stopCommand(comp),new resetCommand(comp));
        user.startComputer();
        user.resetComputer();
        user.stopComputer();
    }
}
public interface Command {
    void execute();
}
//Reciver
class Comp{
    void start(){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset()
    {
        System.out.println("Reset");
    }
}
//ConcreteCommand
class startCommand implements Command{
    Comp comp;

    public startCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.start();
    }
}
class stopCommand implements Command{
    Comp comp;

    public stopCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.stop();
    }
}
class resetCommand implements Command{
    Comp comp;

    public resetCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.reset();
    }
}
//Invoker
class User{
    Command start;
    private Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer()
    {
        reset.execute();
    }
}