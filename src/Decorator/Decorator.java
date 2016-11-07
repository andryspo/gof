package Decorator;


/**
 * Created by andry on 15/10/2016.
 */
public class Decorator {
    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new LeftBracketsDecorator(new RightBracketsDecorator(new Printer("Hello"))));
        printer.print();
    }
}

interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }
    @Override
    public void print() {
        System.out.print(value);
    }
}
abstract class AbstractDecorator implements PrinterInterface{
    PrinterInterface component;
    public AbstractDecorator(PrinterInterface component) {
        this.component = component;
    }
}

class QuotesDecorator extends AbstractDecorator{
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketsDecorator extends AbstractDecorator{
    public LeftBracketsDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketsDecorator extends AbstractDecorator{
    public RightBracketsDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}