package degvis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import processing.core.PApplet;

public class DataSource {
	PApplet app;
	Map<Double, DegDist> dists;
	Iterator<?> current;
	
	public DataSource(PApplet parent, String filename) {
		this.app = parent;
		dists = new TreeMap<Double, DegDist>();
		current = null;
		if (!filename.isEmpty())
			load(filename);
	}

	void load(String filename) {
		String lines[] = app.loadStrings(filename);
		Double time = 0.0;
		Double lastTime = 0.0;
		ArrayList<Integer> degs = new ArrayList<Integer>();
		ArrayList<Double> vals = new ArrayList<Double>();
		for (int i = 0; i < lines.length; i++)
		{
			if (lines[i].trim().startsWith("#") || lines[i].trim().isEmpty())
				continue;
			String tokens[] = lines[i].trim().split("\\s");
			assert(tokens.length >= 3);
			time = new Double(tokens[0]);
			if (!time.equals(lastTime) || (i + 1 == lines.length))
			{
				lastTime = time;
				dists.put(time, new DegDist(vals, degs));
				vals.clear();
				degs.clear();
			}
			degs.add(new Integer(tokens[1]));
			vals.add(new Double(tokens[2]));
		}
		current = dists.entrySet().iterator();
	}

	@SuppressWarnings("unchecked")
	public void print() {
		Iterator<?> i = dists.entrySet().iterator();
		while (i.hasNext())
		{
			Map.Entry<Double, DegDist> e = (Map.Entry<Double, DegDist>) i.next();
			System.out.println("# t = " + String.valueOf((Double) e.getKey()));
			((DegDist) e.getValue()).print();
		}
	}
	
	public boolean hasNextDist() {
		assert(current != null);
		return current.hasNext();
	}
	
	@SuppressWarnings("unchecked")
	public Map.Entry<Double, DegDist> nextDist() {
		assert(current != null);
		if (current.hasNext())
			return (Map.Entry<Double, DegDist>) current.next();
		else return null;
	}
}
