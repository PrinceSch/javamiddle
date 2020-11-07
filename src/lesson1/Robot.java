package lesson1;

public class Robot implements challenger{

    private String name;
    private int maxRun = 2000;
    private int maxJump = 1;
    private boolean inChallenge = true;

    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run(int length) {
        if (maxRun > length){
            System.out.printf("Робот %s пробежал дорожку длиной %d метров!\n", this.name, length);
        } else {
            System.out.printf("Робот %s не может дальше участовать в соревновании...\n",this.name);
            inChallenge = false;
        }
    }

    @Override
    public void jump(int height) {
        if (maxJump>height){
            System.out.printf("Робот %s перепрыгнул стену высотой %d метров!\n", this.name, height);
        } else {
            System.out.printf("Робот %s не может дальше участовать в соревновании...\n",this.name);
            inChallenge = false;
        }
    }

    @Override
    public boolean isInChallenge() {
        return inChallenge;
    }

    @Override
    public void info() {
        System.out.printf("Робот %s",name);
    }
}
