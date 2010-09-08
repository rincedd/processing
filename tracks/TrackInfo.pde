class TrackInfo
{
  String artist;
  String title;
  String timestamp;
  TrackInfo(XMLElement track)
  {
    artist = track.getChild("artist").getContent();
    title = track.getChild("name").getContent();
    timestamp = track.getChild("date").getStringAttribute("uts");
  }
  
  String artist()
  {
    return artist;
  }
  
  String title()
  {
    return title;
  }
  
  String timestamp()
  {
    return timestamp;
  }
}
