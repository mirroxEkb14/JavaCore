package AbstractClass.PracticalTask;

public abstract class Car {
    private String mark;
    private String model;
    private String color;

    public Car(String mark, String model, String color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    abstract public void ride();
}
