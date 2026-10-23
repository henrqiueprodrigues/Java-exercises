package animal;
import animal.Animal;
import interfaces.HasOwner;

public class Dog extends Animal implements HasOwner{

    public String ownerInfo(){
        return "Owner personal info";
    }

    @Override
    public void doNoise(){
        System.out.println("Bark");
    }

    public void play(){
        System.out.println("Roll over");
    }

    
}