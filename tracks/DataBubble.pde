public class DataBubble
{
  PVector location;
  float radius;
  color col;
  int alphaVal;
  String label;
  PApplet parent;

  DataBubble(PApplet parent, PVector location, float radius)
  {
    this.parent = parent;
    this.location = location;
    this.radius = radius;
    this.col = color(random(255), random(255), random(255));
    this.alphaVal = 255;
    this.label = new String("");
    this.parent.registerDraw(this);
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

  void draw()
  {
    pushMatrix();
    translate(location.x, location.y);
    rotate(HALF_PI);
    noStroke();
    fill(col, alphaVal);
    ellipse(0, 0, 2*radius, 2*radius);
    textMode(MODEL);
    textAlign(LEFT);
    fill(col, 255);
    PFont font = loadFont("DejaVuSans-10.vlw");
    textFont(font, 10);
    text(label, 5, 3);
    popMatrix();
  }
}

