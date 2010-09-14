package degvis;

import java.util.ArrayList;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class DegvisApp extends PApplet {
	DataSource dat;
	DegDist dist;
	int col;

	public void setup() {
		size(400, 400);
		frameRate(10);
		background(255);
		smooth();
		noLoop();
		dat = new DataSource(this, "deg.dat");
		dat.normalizeDists();
		dist = null;
		col = color(80, 0, 80);
	}

	public void draw() {
		noStroke();
		fill(255, 50);
		rect(0, 0, width, height);
		pushMatrix();
		float xsep = 20;
		float maxHeight = height / 2;
		translate(20, maxHeight + 20);
		noFill();
		stroke(180);
		drawAxes(0, xsep * 10, 0, -maxHeight, 10, 10);
		if (dat.hasNextDist())
			dist = dat.nextDist().getValue();
		assert (dist != null);
		ArrayList<Double> val = dist.values();
		stroke(col);
		beginShape();
		for (int k = 0; k < val.size(); k++) {
			curveVertex(k * xsep, -val.get(k).floatValue() * maxHeight);
		}
		endShape();
		popMatrix();
	}

	public void drawAxes(float xmin, float xmax, float ymin, float ymax,
			int xtics, int ytics) {
		line(xmin, ymin, xmax, ymin);
		line(xmin, ymin, xmin, ymax);
		float dx = (xmax - xmin) / xtics;
		float dy = (ymax - ymin) / ytics;
		float ticlen = 4;
		for (int i = 0; i < xtics; i++)
			line(xmin + i * dx, -ticlen / 2, xmin + i * dx, ticlen / 2);
		for (int i = 0; i < ytics; i++)
			line(-ticlen / 2, ymin + i * dy, ticlen / 2, ymin + i * dy);
	}

	public void mousePressed() {
		loop();
		// redraw();
	}
}
