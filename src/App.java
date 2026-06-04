import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {

    ArrayList<Asteroid> asteroids;
    ArrayList<Bullet> bullets;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    Spaceship ship;
    int lives;
    int score;
    int scene;
    // int gameStart;

    public void setup() {
        asteroids = new ArrayList<>();
        ship = new Spaceship(width / 2, height - 100, this);
        for (int i = 0; i < 100; i++) {

            // i.display()
            // asteroids.add(a);

        }
    }

    public void settings() {
        size(800, 800);

    }

    public void draw() {
        background(20);
        ship.display();
        fill(100);
        if (frameCount % 30 == 0) {
            System.out.println(frameCount);
            System.out.println("make an asteroid");
            Asteroid a = new Asteroid(this);
            asteroids.add(a);
        }

        for (Asteroid a : asteroids) {
            a.display();
            a.move();
        }
        fill(255);
        textSize(30);
        text("Lives: " + lives, 20, 50);
        text("Score: " + score, 20, 100);

    }

    public void keyPressed() {

        if (keyCode == LEFT) {
            ship.moveLeft();
        }

        if (keyCode == RIGHT) {
            ship.moveRight();
        }
    }
}
