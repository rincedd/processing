package degvis;

import org.gwoptics.graphics.graph2D.Graph2D;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class DegvisApp extends PApplet {
	DataSource dat;
	Graph2D graph_;
	DegDistTrace trace_;

	public DegvisApp() {
		super();
	}
	
	public void setup() {
		size(600, 600);
		frameRate(10);
		background(255);
		smooth();
		noLoop();

		graph_ = new Graph2D(this, 400, 400, true);
		graph_.setAxisColour(220, 220, 220);
		graph_.setFontColour(255, 255, 255);

		graph_.position.y = 10;
		graph_.position.x = 10;

		graph_.setYAxisTickSpacing(0.1f);
		graph_.setXAxisTickSpacing(10f);

		graph_.setXAxisMinorTicks(1);
		graph_.setYAxisMinorTicks(1);

		graph_.setYAxisMin(0f);
		graph_.setYAxisMax(1f);

		graph_.setXAxisMin(0f);
		graph_.setXAxisMax(20f);
		// graph_.setXAxisLabelAccuracy(0);
		graph_.setXAxisLabel("k");
		graph_.setYAxisLabel("p(k)");
		graph_.setNoBorder();

		trace_ = new DegDistTrace();
		trace_.setColor(color(255, 0, 0));
		graph_.addTrace(trace_);

		dat = new DataSource(this, "../data/deg.dat");
		dat.normalizeDists();
	}

	public void draw() {
		DegDist dist = null;
		if (dat.hasNextDist())
			dist = dat.nextDist().getValue();
		assert (dist != null);
		trace_.setDist(dist);
		graph_.generateTrace(0);
		noStroke();
		fill(255, 50);
		rect(0, 0, width, height);
		graph_.draw();
		// noStroke();
		// fill(255, 50);
		// rect(0, 0, width, height);
		// pushMatrix();
		// float xsep = 20;
		// float maxHeight = height / 2;
		// translate(20, maxHeight + 20);
		// noFill();
		// stroke(180);
		// drawAxes(0, xsep * 10, 0, -maxHeight, 10, 10);
		// if (dat.hasNextDist())
		// dist = dat.nextDist().getValue();
		// assert (dist != null);
		// ArrayList<Double> val = dist.values();
		// assert (val.size() > 0);
		// stroke(col);
		// beginShape();
		// curveVertex(0, -val.get(0).floatValue() * maxHeight);
		// for (int k = 0; k < val.size(); k++) {
		// curveVertex(k * xsep, -val.get(k).floatValue() * maxHeight);
		// }
		// curveVertex((val.size() - 1) * xsep, -val.get(val.size() - 1)
		// .floatValue() * maxHeight);
		// endShape();
		// popMatrix();
	}

	public void mousePressed() {
		loop();
		redraw();
	}
}
