package service;

import MyThread.Way;
import dao.TraceDao;
import entities.Horse;
import entities.ListOfHorse;
import entities.Trace;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Race {

    TraceDao traceDao = new TraceDao();
    static Trace trace = new Trace();
    private int countOfHorses;
    private String bet;

    public void StartRace(int countOfHorses, String bet) {

        this.bet = bet;

        for (int i = 1; i <= countOfHorses; i++) {
            new Way("Horse#" + i).start();
        }

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        showResult();
    }

    private void showResult() {
        Trace trace = new Trace();
        List<Horse> horses = new ArrayList<>(ListOfHorse.getListOfHorse());

        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).setPlace(i+1);
            trace.addToList(horses.get(i));
        }

        trace.setBetOn(bet);
        trace.setTime(String.valueOf(LocalDateTime.now()));
        traceDao.createTrace(trace);

        ListOfHorse.clearTheList();

    }

}
