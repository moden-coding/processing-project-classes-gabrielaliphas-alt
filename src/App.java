import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {

    ArrayList<Asteroid> asteroids;

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
    }

    public void settings() {
        size(800, 800);

    }

    public void draw() {
        background(20);
        ship.display();
        fill(100);

        for (int i = 0; i < 5; i++) {
            Asteroid a = new Asteroid;
                    
            asteroids.add(a);
        }

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
