package OOP.Encapsulation;

class Animal {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 1) { // check the ID
            throw new IllegalArgumentException();
        }
        this.id = id;
    }
}
