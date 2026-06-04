import processing.core.PApplet;

public class Bullet {
    int x;
    int y;

    PApplet screen;

    public Bullet(int x, int y, PApplet screen) {
        this.x = 370;
        this.y = 700;
        this.screen = screen;
    }

    public void display() {

        screen.fill(255, 255, 0);

        screen.circle(x, y, 10);
    }
}
