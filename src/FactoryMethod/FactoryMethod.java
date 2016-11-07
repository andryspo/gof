package FactoryMethod;

import java.util.Date;

/**
 * Created by andry on 30/09/2016.
 */
public class FactoryMethod {
    public static void main(String[] args) {
        WatchCreator watchCreator = getMakerByName("Rome");
        Watch watch = watchCreator.createWatch();
        watch.showTime();
    }

    public static WatchCreator getMakerByName(String name){
        if(name.equals("Digital"))
            return new DigitalWatchCreator();
        else if(name.equals("Rome"))
            return new RomeWatchCreator();
        throw new RuntimeException("unsupported watch name");
    }
}

interface Watch{
    void showTime();
}
class DigitalWatch implements  Watch{

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println("V|| XX");
    }
}

interface WatchCreator{
    Watch createWatch();
}

class DigitalWatchCreator implements WatchCreator{

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchCreator implements WatchCreator{

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}