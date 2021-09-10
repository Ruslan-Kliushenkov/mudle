package MyThread;

import entities.Horse;
import entities.ListOfHorse;
import service.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Way extends Thread {

    Random random = new Random();
    Race race = new Race();
    private final int START_POINT = 0;
    private final int ALL_DISTANCE = 1000;
    private int currentPosition;
    private String name;

    public Way(String name) {
        super(name);
    }

    @Override
    public void run() {



        while (this.currentPosition < ALL_DISTANCE) {
            this.currentPosition += getRandomStep();
            try {
                Thread.sleep(getRandomSleepTime());
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
        /*race.finish(Thread.currentThread().getName());*/
        ListOfHorse.addToList(Thread.currentThread().getName());

    }



    private int getRandomStep() {
        return 100 + random.nextInt(100);
    }

    private int getRandomSleepTime() {
        return 400 + random.nextInt(100);
    }

}

