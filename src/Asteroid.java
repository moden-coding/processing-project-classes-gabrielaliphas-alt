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
        // astroid shows on screen
        screen.fill(150);
        screen.circle(x, y, 40);

        screen.fill(100);
        screen.circle(x - 10, y - 5, 8);
        screen.circle(x + 8, y + 10, 10);           // I used chat to help me make astroids look realistic
        screen.circle(x + 5, y - 12, 6);
    }

    public void move() {

        y += 8; // speed
    }

    public boolean collide(float otherX, float otherY) {

        double distanceBetweenObjects = // collision
                screen.dist(x, y, otherX, otherY);

        if (distanceBetweenObjects <= 25) {
            return true;
        }

        return false;
    }
}
