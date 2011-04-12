public class DataBubble
{
  PVector location;
  float radius;
  color col;
  int alphaVal;
  String label;
  PApplet parent;
  PFont font;
  boolean hovered;

  DataBubble(PApplet parent, PVector location, float radius, PFont font)
  {
    this.parent = parent;
    this.font = font;
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
    if (hovered != val) {
      hovered = val;
      parent.redraw();
    }
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
    if (hovered)
      fill(255);
    else
      fill(col, 255);
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
    }
  }
}

