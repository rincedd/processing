ArrayList ants;

color white = color(255);

void setup()
{
  size(400, 400);
  background(0);
  ants = new ArrayList();
}

void draw()
{
  for (int i = 0; i < ants.size(); i++)
  {
    Ant ant = (Ant) ants.get(i);
    ant.move();
    ant.draw();
  }
}

void mouseClicked()
{
  ants.add(new Ant(new PVector(mouseX, mouseY), 2, color(random(255), random(255), random(255))));
}

class Ant {
  PVector loc;
  float radius;
  color col;
  Ant(PVector location, float r, color c) {
    loc = location;
    radius = r;
    col = c;
  }

  void move() {
    loc.add(new PVector(random(-1.0, 1.0)*radius, random(-1.0, 1.0)*radius));
  }

  void draw() {
    pushMatrix();
    translate(loc.x, loc.y);
    noStroke();
    fill(col, 30);
    ellipse(0, 0, 2*radius, 2*radius);
    popMatrix();
  }
};

