package lesson1;

public class Human  implements challenger{
    private String name;
    private int maxRun = 1000;
    private int maxJump = 2;
    private boolean inChallenge = true;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run(int length) {
        if (maxRun > length){
            System.out.printf("Человек %s пробежал дорожку длиной %d метров!\n", this.name, length);
        } else {
            System.out.printf("Человек %s не может дальше участовать в соревновании...\n",this.name);
            inChallenge = false;
        }
    }

    @Override
    public void jump(int height) {
        if (maxJump>height){
            System.out.printf("Человек %s перепрыгнул стену высотой %d метров!\n", this.name, height);
        } else {
            System.out.printf("Человек %s не может дальше участовать в соревновании...\n",this.name);
            inChallenge = false;
        }
    }

    @Override
    public boolean isInChallenge() {
        return inChallenge;
    }

    @Override
    public void info() {
        System.out.printf("Человек %s",name);
    }

}
