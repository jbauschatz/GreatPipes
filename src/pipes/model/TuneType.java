package pipes.model;

public enum TuneType {
	MARCH("March"),
	STRATHSPEY("Strathspey"),
	REEL("Reel"),
	JIG("Jig"),
	HORNPIPE("Hornpipe"),
	SLOW_AIR("Slow Air"),
	RETREAT("Retreat"),
	WALTZ("Waltz");
	
	public String toString() {
		return name;
	}
	
	TuneType(String name) {
		this.name = name;
	}
	
	private String name;
}
