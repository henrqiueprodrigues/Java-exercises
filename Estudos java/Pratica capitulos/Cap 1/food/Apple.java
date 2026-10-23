package food;

class apple extends Fruit {

    public apple(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println("comendo maça");
    }
}

