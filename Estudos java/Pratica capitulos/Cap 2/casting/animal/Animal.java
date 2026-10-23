package animal;

public abstract class Animal {

    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void doNoise(){
        System.out.println("Noise");
    }


}
