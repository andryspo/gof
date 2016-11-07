package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andry on 15/10/2016.
 */
public class Composite {
    public static void main(String[] args) {
        Shape sq1 = new Square();
        Shape sq2 = new Square();

        Shape rect1 = new Rectangle();

        Shape tr1 = new Triangle();
        Shape tr2 = new Triangle();
        Shape tr3 = new Triangle();

        Compositor csq = new Compositor();
        Compositor crect = new Compositor();
        Compositor ctr = new Compositor();
        Compositor c = new Compositor();

        csq.addComponent(sq1);
        csq.addComponent(sq2);

        crect.addComponent(rect1);

        ctr.addComponent(tr1);
        ctr.addComponent(tr2);
        ctr.addComponent(tr3);
        c.addComponent(csq);
        c.addComponent(ctr);
        c.addComponent(crect);
        c.draw();
    }
}
interface Shape{
    void draw();
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw square");
    }
}
class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw rectangle");
    }
}
class Compositor implements Shape{
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component)
    {
        components.add(component);
    }
    public void removeComponetnt(Shape component)
    {
        components.remove(component);
    }
    @Override
    public void draw()
    {
        for (Shape s : components) {
            s.draw();
        }
    }
}