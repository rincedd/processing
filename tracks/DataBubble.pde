public class DataBubble
{
  PVector location;
  float radius;
  color col;
  int alphaVal;
  String label;
  PApplet parent;
  boolean hovered;

  DataBubble(PApplet parent, PVector location, float radius)
  {
    this.parent = parent;
    this.location = location;
    this.radius = radius;
    this.col = color(random(255), random(255), random(255));
    this.alphaVal = 255;
    this.label = new String("");
    this.hovered = false;
    this.parent.registerDraw(this);
    this.parent.registerMouseEvent(this);
  }

  void setColor(color col)
  {
    this.col = col;
  }

  void setAlpha(int alphaVal)
  {
    this.alphaVal = alphaVal;
  }

  void setLabel(String lbl)
  {
    label = lbl;
  }

  void setHovered(boolean val) {
    hovered = val;
  }

  void draw()
  {
    translate(location.x, location.y);
    rotate(HALF_PI);
    if (hovered)
      stroke(255);
    else
      noStroke();
    fill(col, alphaVal);
    ellipse(0, 0, 2*radius, 2*radius);
    textMode(MODEL);
    textAlign(LEFT);
    fill(col, 255);
    PFont font = loadFont("DejaVuSans-10.vlw");
    textFont(font, 10);
    text(label, 5, 3);
    rotate(-HALF_PI);
    translate(-location.x, -location.y);
  }

  void mouseEvent(MouseEvent event) {
    if (event.getID() == MouseEvent.MOUSE_MOVED)
    {
      PVector mouse = new PVector(event.getX(), event.getY());
      if (PVector.dist(mouse, location) <= radius)
        setHovered(true);
      else
        setHovered(false);
      parent.redraw();
    }
  }
}

