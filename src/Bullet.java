import processing.core.PApplet;

public class Bullet {
    int x;
    int y;

    

    PApplet screen;

    public Bullet(int x, int y, PApplet screen) {
        this.x = x;
        this.y = 700;           //x and y pos
        this.screen = screen;
    }

    public void display() {//show the bullet

        screen.fill(255, 255, 0);

        screen.circle(x, y, 10);
       
    }

    public void update() {
        y -= 30;
       
    }

    public void move() {

        y -= 30;
    }

    public int getX(){//return position
        return x;

    }

    public int getY(){
        return y;
    }

}
