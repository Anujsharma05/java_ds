package oops.interfaces.car;

public class Car {
    private Engine engine;
    private MusicPlayer musicPlayer;

    public Car(Engine engine, MusicPlayer musicPlayer) {
        this.engine = engine;
        this.musicPlayer = musicPlayer;
    }

    public void startEngine() {
        engine.start();
    }

    public void stopEngine() {
        engine.stop();
    }

    public void startMusic() {
        musicPlayer.start();
    }

    public void stopMusic() {
        musicPlayer.stop();
    }
}
