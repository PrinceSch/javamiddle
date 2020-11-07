package lesson1;

public class main {

    public static void main(String[] args) {

        challenger[] champions = {
                new Cat("Огонёк"),
                new Human ("Энакин",500,3),
                new Robot("C3-PO"),
                new Human("Лея"),
                new Cat ("Депресняк",2000,3)
        };

        tour[] tours = {
                new wall(1),
                new runningRoad(400),
                new wall (2),
                new runningRoad(800)
        };

        for (challenger c: champions) {
            for (tour t: tours){
                t.takeIt(c);
                if (!c.isInChallenge()){
                    break;
                }
            }
        }

        for (challenger c: champions) {
            if (c.isInChallenge()){
                c.info();
                System.out.println(" прошел соревнование");
            } else {
                c.info();
                System.out.println(" не прошел соревнование");
            }
        }
    }

}
