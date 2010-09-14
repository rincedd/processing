package degvis;

import java.util.ArrayList;

public class DegDist {

	ArrayList<Double> vals;

	public DegDist(Double val[]) {
		vals = new ArrayList<Double>();
		for (int i = 0; i < val.length; i++)
			vals.add(val[i]);
	}

	public DegDist(Double val[], Integer deg[]) {
		assert(val.length == deg.length);
		vals = new ArrayList<Double>();
		for (int i = 0; i < val.length; i++)
		{
			while (deg[i] >= vals.size())
				vals.add(0.0);
			vals.set(deg[i], val[i]);
		}
	}
	
	public DegDist(ArrayList<Double> val, ArrayList<Integer> deg) {
		assert(val.size() == deg.size());
		vals = new ArrayList<Double>();
		for (int i = 0; i < val.size(); i++)
		{
			while (deg.get(i) >= vals.size())
				vals.add(0.0);
			vals.set(deg.get(i), val.get(i));
		}
	}
	public void print() {
		for (int i = 0; i < vals.size(); i++)
		{
			System.out.println(String.valueOf(i) + "\t" + vals.get(i).toString());
		}
	}
	
	public ArrayList<Double> values() {
		return vals;
	}
}
