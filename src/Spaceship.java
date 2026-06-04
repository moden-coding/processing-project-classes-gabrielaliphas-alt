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

   public void display() {
      // this.display();
 
      screen.fill(220);

      screen.triangle(
            x, y - 30,
            x - 20, y + 20,
            x + 20, y + 20);
   }

   public void moveLeft() {
      x -= 20;
   }

   public void moveRight() {
      x += 20;
   }

}

// if (moveLeft) {
// SpaceshipX -= 10;
// speed of paddles moving

// if (moveRight) {
// SpaceshipY += 10;
