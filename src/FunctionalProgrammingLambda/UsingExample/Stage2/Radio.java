package FunctionalProgrammingLambda.UsingExample.Stage2;

public class Radio implements ElectricityConsumer {

    public void playMusic() {
        System.out.println("Radio is playing music");
    }

    @Override
    public void electricityOn() {
        playMusic();
    }
}
