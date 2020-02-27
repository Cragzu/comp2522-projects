package ca.bcit.comp2522.labs.lab04;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class BlueWhale implements Aquatic {
    @Override
    public void swim() {
        System.out.println("splish splash");
    }

    interface FilterFeeder {
        void strain();
    }

    public static void main(String[] args) {
        Aquatic mobyDick = new BlueWhale();
        mobyDick.swim();
    }


}
