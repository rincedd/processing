float globalScale = 2;
DataSource data;

void setup() {
  size(900, 600);
  background(200);
  smooth();
  noLoop();
  data = new DataSource(this, "tracks.xml");
  makeBubbles();
}

void draw()
{
}

void makeBubbles()
{
  HashMap artistCount = data.artistCount();
  Iterator i = artistCount.entrySet().iterator();  // Get an iterator
  int j = 1;
  float space = width / artistCount.size();
  while (i.hasNext()) {
    Map.Entry me = (Map.Entry) i.next();
    color c = color(random(255), random(255), random(255));
    DataBubble b = new DataBubble(this, new PVector(j*space, height/2), ((Integer) me.getValue()).floatValue()*globalScale);
    b.setAlpha(70);
    b.setLabel((String) me.getKey());
    j++;
  }
}

