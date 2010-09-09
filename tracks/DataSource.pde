class DataSource {
  ArrayList<TrackInfo> tracklist;

  DataSource(PApplet app, String xmlFile) {
    tracklist = new ArrayList<TrackInfo>();
    XMLElement xml = new XMLElement(app, xmlFile);
    XMLElement tracks = xml.getChild("recenttracks");
    int numTracks = tracks.getChildCount();
    for (int i = 0; i < numTracks; i++) {
      tracklist.add(new TrackInfo(tracks.getChild(i)));
    }
    println("Filled tracklist with " + tracklist.size() + " entries");
  }

  HashMap artistCount(int threshold) {
    HashMap ac = new HashMap();
    for (int i = 0; i < tracklist.size(); i++)
    {
      TrackInfo ti = tracklist.get(i);
      if (ac.get(ti.artist()) == null)
        ac.put(ti.artist(), new Integer(1));
      else
      {
        Integer val = (Integer) ac.get(ti.artist());
        ac.put(ti.artist(), val + 1);
      }
    }

    // delete all entries with count < threshold
    Iterator i = ac.entrySet().iterator();
    while (i.hasNext())
    {
      Map.Entry me = (Map.Entry) i.next();
      if ((Integer) me.getValue() < threshold)
        i.remove();
    }
    return ac;
  }
}

