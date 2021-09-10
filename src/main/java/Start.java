import dao.TraceDao;
import service.Race;

public class Start {
    public static void main(String[] args) {

        Race race = new Race();
        race.StartRace(3, "2");
        race.StartRace(4, "3");

        TraceDao traceDao = new TraceDao();
        traceDao.getTraces().forEach(System.out::println);
        System.out.println(traceDao.getTraceById(1));
    }

}
