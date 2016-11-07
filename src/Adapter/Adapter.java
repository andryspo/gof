package Adapter;

/**
 * Created by andry on 15/10/2016.
 */
public class Adapter {
    public static void main(String[] args) {
        VectorGraphicsInterface g = new VectorAdapterFromRaster();
        g.drawLine();
        g.drawSquare();
    }
}
interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphics{
    void drawRasterLine()
    {
        System.out.println("Draw line");
    }
    void drawRasterSquare()
    {
        System.out.println("Draw square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}