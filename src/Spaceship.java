import processing.core.PApplet;

public class Spaceship {

   int x;
   int y;

   PApplet screen;

   public Spaceship(int x, int y, PApplet screen) {
      this.x = 370;
      this.y = 700;
      this.screen = screen;
   }

   public void display() {    //used chat to make it more fancy
    screen.noFill();
screen.stroke(100, 150, 255);
screen.strokeWeight(4);

screen.triangle(
    x, y - 25,
    x - 18, y + 25,
    x + 18, y + 25
);
screen.fill(0, 200, 255);//chat here too
screen.noStroke();
screen.circle(x, y, 6);
}

   public void moveLeft() {
      x -= 8;
   }

   public void moveRight() { // speed
      x += 8;
   }

}

