package Delegate;

/**
 * Created by andry on 28/09/2016.
 */
public class Delegate {
    public static void main(String[] args) {
        Triangele triangele = new Triangele();
        Ring ring = new Ring();
        Cyrcle cyrcle = new Cyrcle();
        Painter painter = new Painter();
        painter.paint(triangele);
        painter.paint(ring);
        painter.paint(cyrcle);
    }
}
interface Graphics{
    void draw();
}

class Triangele implements Graphics{
    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }
}
class Cyrcle implements Graphics{
    @Override
    public void draw() {
        System.out.println("Draw circle");
    }
}

class Ring implements Graphics{
    @Override
    public void draw() {
        System.out.println("Draw ring");
    }
}
class Painter{
    public void paint(Graphics g)
    {
        g.draw();
    }
}