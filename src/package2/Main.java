package package2;

import package1.Animal;
import package1.Dog;

public class Main {
    public static void main(String [] args) {
        Animal animal = new Animal();
        animal.xyz();
        // animal.doSomething(); -> Not available (since default method)
        
        Dog aDog = new Dog();
        aDog.bark();
    }
}
