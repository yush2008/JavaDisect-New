package patterns.Creational;

public class PrototypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        Engine diesel_40 = new Engine("Diesel");
        diesel_40.setCost(40);
        Bike honda = new Bike(5, "Unicorn", diesel_40);

        //Sallow cloning
        Bike honda1 = honda.clone();
        System.out.println(honda1.getEngine().getCost());
        diesel_40.setCost(60);
        System.out.println(honda1.getEngine().getCost());
    }

}

class Bike implements Cloneable {

    private Integer gear;
    private String model;
    private Engine engine;

    public Bike(Integer gear, String model, Engine engine) {
        this.gear = gear;
        this.model = model;
        this.engine = engine;
    }

    public Bike clone() throws CloneNotSupportedException {
        Bike obj = (Bike) super.clone();
        Engine eng = obj.getEngine().clone();
        obj.setEngine(eng);
        return obj;

    }

    public Integer getGear() {
        return gear;
    }

    public void setGear(Integer gear) {
        this.gear = gear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


}

class Engine implements Cloneable {

    private Integer cost;
    private String fuel;

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Engine(String fuel) {
        this.fuel = fuel;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public Engine clone() throws CloneNotSupportedException {
        return (Engine) super.clone();
    }

}