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
    boolean leftPressed;
    boolean rightPressed;

    public void setup() {
        
        lives = 3;
        scene = 0;
        
        score = 0;

        asteroids = new ArrayList<>();
        bullets = new ArrayList<>();
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
        if (scene == 0) {
            background(0);
            fill(255);
            textSize(80);
            text("ASTEROIDS GAME", 130, 250);
            textSize(30);
            text("Arrow Keys to Move", 240, 400);
            text("Press SPACE to Start", 240, 500);

        } else if (scene == 1) {

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

            if (frameCount % 30 == 0) {
                System.out.println(frameCount);
                System.out.println("make an asteroid");
                Bullet b = new Bullet(ship.x, ship.y - 30, this);
                bullets.add(b);
            }
            for (Bullet i : bullets) {
                i.display();
                i.move();

            }

            for (int i = 0; i < asteroids.size(); i++) {
                Asteroid a = asteroids.get(i);
                if (a.collide(ship.x, ship.y)) {
                    lives--;
                    asteroids.remove(i);
                    i--;

                }

                // for(Bullet b : bullets){
                for (int j = 0; j < bullets.size(); j++) {
                    Bullet b = bullets.get(j);

                    if (a.collide(b.getX(), b.getY())) {
                        asteroids.remove(a);
                        bullets.remove(b);
                        score++;
                    }
                }

            }
            if (leftPressed) {
                ship.moveLeft();
            }

            if (rightPressed) {
                ship.moveRight();
            }

            fill(255);
            textSize(30);
            text("Lives: " + lives, 20, 50);
            text("Score: " + score, 20, 100);

            if (lives <= 0) {
                scene = 2;
            }
        } else {

            textSize(60);
            text("game over!", 250, 400);
            text("Press R to Restart", 220, 500);

        }

    }

    public void keyPressed() {

        if (scene == 0 && key == ' ') {
            scene = 1;
        }

        if (keyCode == LEFT) {
            leftPressed = true;
        }

        if (keyCode == RIGHT) {
            rightPressed = true;
        }
        if (key == 'r' && scene == 2) {
            setup();
        }
    }

    public void keyReleased() {

        if (keyCode == LEFT) {
            leftPressed = false;
        }

        if (keyCode == RIGHT) {
            rightPressed = false;
        }
    }

}
