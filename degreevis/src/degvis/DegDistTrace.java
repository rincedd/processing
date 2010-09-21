package degvis;

import java.util.ArrayList;

import org.gwoptics.graphics.graph2D.traces.Blank2DTrace;

import processing.core.PGraphics;

class DegDistTrace extends Blank2DTrace {
	private DegDist dist_;
	private int col_;

	public DegDistTrace() {
		dist_ = null;
		col_ = 0;
	}

	public void setDist(DegDist dist) {
		dist_ = dist;
	}

	public void setColor(int col) {
		col_ = col;
	}
	
	public void generate() {
		super.generate();
	}

	public void TraceDraw(PGraphics canvas) {
		if (dist_ != null) {
			ArrayList<Double> val = dist_.values();
			assert (val.size() > 0);
			canvas.pushStyle();
			canvas.stroke(col_);
			canvas.beginShape();
			canvas.curveVertex(0, -val.get(0).floatValue());
			for (int k = 0; k < val.size(); k++) {
				canvas.curveVertex(k, val.get(k).floatValue());
			}
			canvas.curveVertex((val.size() - 1), val.get(val.size() - 1)
					.floatValue());
			canvas.endShape();
			canvas.popStyle();
		}
	}
}