package oops.interfaces.car;

public class CdPlayer implements MusicPlayer{

    @Override
    public void start() {
        System.out.println("start music");
    }

    @Override
    public void stop() {
        System.out.println("stop music");
    }
}
