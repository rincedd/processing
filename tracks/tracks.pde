float globalScale = 2;
DataSource data;
PFont font;

void setup() {
  size(900, 600);
  background(200);
  smooth();
  noLoop();
  font = loadFont("DejaVuSans-10.vlw");
  data = new DataSource(this, "tracks.xml");
  makeBubbles();
}

void draw()
{
  background(200);
}

void makeBubbles()
{
  HashMap artistCount = data.artistCount(2);
  Iterator i = artistCount.entrySet().iterator();  // Get an iterator
  int j = 1;
  float space = width / (artistCount.size() + 1);
  while (i.hasNext()) {
    Map.Entry me = (Map.Entry) i.next();
    color c = color(random(255), random(255), random(255));
    DataBubble b = new DataBubble(this, new PVector(j*space, height/2), ((Integer) me.getValue()).floatValue()*globalScale, font);
    b.setAlpha(70);
    b.setLabel((String) me.getKey());
    j++;
  }
}

