package Facade;

/**
 * Created by andry on 29/09/2016.
 */
public class Facade
{
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

//example of facade class
class Computer{
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();
    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}
class Power{
    void on(){
        System.out.println("Facade.Power on");
    }
    void off(){
        System.out.println("Facade.Power off");
    }
}

class DVDRom{
    private boolean data = false;

    public boolean hasData() {
        return data;
    }
    void load ()
    {
        data = true;
    }
    void unload()
    {
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvdRom)
    {
        if(dvdRom.hasData()) {
            System.out.println("copy the data");
        } else{
            System.out.println("turn on the dvd");
        }
    }
}