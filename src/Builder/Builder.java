package Builder;

/**
 * Created by andry on 15/10/2016.
 */
public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMark("Mercedes")
                .buildSpeed(280)
                .builTransmission(Transmission.AUTO)
                .build();
        System.out.println(car);
    }
}

enum Transmission{
    MANUAL, AUTO
}
class Car{
    private String mark;
    private int maxSpeed;
    private Transmission transmission;

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Builder.Car{" +
                "mark='" + mark + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", transmission=" + transmission +
                '}';
    }
}

class CarBuilder{
    private String mark = "Default";
    private int maxSpeed = 120;
    private Transmission transmission = Transmission.MANUAL;

    CarBuilder buildMark(String mark)
    {
        this.mark = mark;
        return this;
    }
    CarBuilder buildSpeed(int speed)
    {
        this.maxSpeed = speed;
        return this;
    }
    CarBuilder builTransmission(Transmission transmission)
    {
        this.transmission = transmission;
        return this;
    }
    Car build()
    {
        Car car = new Car();
        car.setMark(mark);
        car.setMaxSpeed(maxSpeed);
        car.setTransmission(transmission);
        return car;
    }
}