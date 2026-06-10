import processing.core.PApplet;

public class Asteroid {

    int x;
    int y;
    int speed;

    PApplet screen;

    public Asteroid(PApplet screen) {

        this.y = 0;
        speed = 7;

        this.screen = screen;
        this.x = (int) screen.random(screen.width);
    }

    public void display() {

        screen.fill(200);

        screen.circle(x, y, 40);

    }

    public void move() {

        y += 8;
    }

   
    public boolean collide(float otherX, float otherY) {

        double distanceBetweenObjects =
                screen.dist(x, y, otherX, otherY);

        if (distanceBetweenObjects <= 25) {
            return true;
        }

        return false;
    }
}
