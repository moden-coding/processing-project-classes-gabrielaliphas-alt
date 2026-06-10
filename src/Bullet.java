import processing.core.PApplet;

public class Bullet {
    int x;
    int y;

    

    PApplet screen;

    public Bullet(int x, int y, PApplet screen) {
        this.x = x;
        this.y = 700;
        this.screen = screen;
    }

    public void display() {

        screen.fill(255, 255, 0);

        screen.circle(x, y, 10);
       
    }

    public void update() {
        y -= 20;
       
    }

    public void move() {

        y -= 20;
    }

    public int getX(){
        return x;

    }

    public int getY(){
        return y;
    }

}
