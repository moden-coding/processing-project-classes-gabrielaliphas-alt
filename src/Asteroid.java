import processing.core.PApplet;

public class Asteroid {

    int x;
    int y;
    int speed;

    PApplet screen;

    public Asteroid(int x, int y, PApplet screen) {
        this.x = x;
        this.y = y;
        speed = 5;

        this.screen = screen;
    }

    public void display() {

        screen.fill(200);

        screen.circle(x, y, 40);

    }


}