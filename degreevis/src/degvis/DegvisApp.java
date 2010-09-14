package degvis;

import java.util.ArrayList;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class DegvisApp extends PApplet {
	DataSource dat;
	DegDist dist;
	int col;

	public void setup() {
		size(400, 600);
		frameRate(10);
		background(255);
		smooth();
		noLoop();
		dat = new DataSource(this, "deg.dat");
		dist = null;
		col = color(random(100), random(100), random(100));
	}

	public void draw() {
		noStroke();
		fill(255, 50);
		rect(0, 0, width, height);
		noFill();
		float xsep = 20;
		float left = width / 2;
		float bottom = height - 2 * xsep;
		float ticlen = 4;
		stroke(180);
		line(left, bottom, width - xsep, bottom);
		line(left, bottom, left, 5*xsep);
		for (int k = 0; k < 20; k++)
		{
			line(left + k*xsep, bottom + ticlen/2, left + k*xsep, bottom - ticlen/2);
			line(left - ticlen/2, bottom - k*10, left + ticlen/2, bottom - k*10);
		}
		if (dat.hasNextDist())
			dist = dat.nextDist().getValue();
		assert (dist != null);
		ArrayList<Double> val = dist.values();
		stroke(col);
		beginShape();
		for (int k = 0; k < val.size(); k++) {
			curveVertex(left + k * xsep, bottom - val.get(k).floatValue());
		}
		endShape();
	}

	public void mousePressed() {
		loop();
		//redraw();
	}
}
