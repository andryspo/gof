package AbstractFactory;

/**
 * Created by andry on 15/10/2016.
 */
public class AbstractFactory     {
    public static void main(String[] args) {
        DeviceFactory factory = getFactory("en");
        Mouse mouse = factory.getMouse();
        Touchpad touchpad = factory.getTouchpad();
        Keyboard keyboard = factory.getKeyboard();
        mouse.click();
        touchpad.track();
        keyboard.print();
    }
    static DeviceFactory getFactory(String lang)
    {
        switch (lang)
        {
            case "ukr": return new UkrDeviceFactory();
            case "en" : return new EnDeviceFactory();
            default: throw new RuntimeException("Unsupported language");
        }
    }
}
interface Mouse{
    void click();
}
interface Keyboard
{
    void print();
}
interface Touchpad
{
    void track();
}
interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class UkrMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Клік миші ");
    }

}

class UkrTouchpad implements Touchpad{
    @Override
    public void track() {
        System.out.println("Український тачпад");
    }
}
class UkrKeyboard implements Keyboard{

    @Override
    public void print() {
        System.out.println("Клава");
    }
}
class EnMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("AbstractFactory.Mouse click");
    }

}

class EnTouchpad implements Touchpad{
    @Override
    public void track() {
        System.out.println("AbstractFactory.Touchpad");
    }
}
class EnKeyboard implements Keyboard{

    @Override
    public void print() {
        System.out.println("AbstractFactory.Keyboard");
    }
}
class UkrDeviceFactory implements DeviceFactory
{
    @Override
    public Mouse getMouse() {
        return new UkrMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new UkrKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new UkrTouchpad();
    }
}

class EnDeviceFactory implements DeviceFactory{
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}
