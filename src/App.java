import java.util.ArrayList;
import java.nio.file.Paths;
import processing.core.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class App extends PApplet {

    ArrayList<Asteroid> asteroids;
    ArrayList<Bullet> bullets;              //array lists for bullets and astroids

    public static void main(String[] args) {
        PApplet.main("App");
    }

    Spaceship ship;
    int lives;  //variables
    int score;
    int scene;      
    int highScore;

    // int gameStart;
    boolean leftPressed;
    boolean rightPressed; // movement

    public void setup() {

        readHighScore(); // load saved scores
        text("Score: " + score, 20, 100);
        text("High Score: " + highScore, 20, 150);
        lives = 3;
        scene = 0;

        score = 0;

        asteroids = new ArrayList<>();
        bullets = new ArrayList<>();
        ship = new Spaceship(width / 2, height - 100, this);
    }

    public void settings() {
        size(800, 800);     //backround size

    }

    public void draw() {
        if (scene == 0) { // all for if on scene 0
            background(0);
            fill(255);
            textSize(80);
            text("ASTEROIDS GAME", 130, 250);
            textSize(30);
            text("Arrow Keys to Move", 240, 400);
            text("Press SPACE to Start", 240, 500);

        } else if (scene == 1) {

            background(20);
            ship.display();     // if scene one then main game
            fill(100);

            if (frameCount % 30 == 0) {     //SPAWN ASTROIDS
                System.out.println(frameCount);
                System.out.println("make an asteroid");
                Asteroid a = new Asteroid(this);
                asteroids.add(a);

            }

            for (Asteroid a : asteroids) {
                a.display();
                a.move();
            }
                // SPAWN BULLETS
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
                //collisions
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
                                            // movement
            if (rightPressed) {
                ship.moveRight();
            }

            fill(255);
            textSize(30);
            text("Lives: " + lives, 20, 50);
            text("Score: " + score, 20, 100);
            if (lives <= 0) {                   // game over check
                if (score > highScore) {
                    highScore = score;
                    saveHighScore();
                }

                scene = 2;
            }
        } else {            // end scene

            textSize(60);
            text("game over!", 250, 400);
            text("Press R to Restart", 220, 500);
            textSize(30);
            text("Score: " + score, 10, 760);
            text("High Score: " + highScore, 10, 790);

        }

    }

    public void keyPressed() {

        if (scene == 0 && key == ' ') {
            scene = 1;
        }

        if (keyCode == LEFT) {
            leftPressed = true;         //smooth movement
        }

        if (keyCode == RIGHT) {
            rightPressed = true;
        }
        if (key == 'r' && scene == 2) {     //restart and set to 0
            scene = 1;
            score = 0;
            lives = 3;

        }
    }

    public void keyReleased() {

        if (keyCode == LEFT) {
            leftPressed = false;        //smooth movement
        }

        if (keyCode == RIGHT) {
            rightPressed = false;
        }
    }

    public void saveHighScore() {       // save high score

        try (PrintWriter writer = new PrintWriter("highscore.txt")) {

            writer.println(highScore);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }

    public void readHighScore() { // load high score

        try (Scanner scanner = new Scanner(Paths.get("highscore.txt"))) {

            while (scanner.hasNextLine()) {

                String row = scanner.nextLine();
                highScore = Integer.valueOf(row);

            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}
