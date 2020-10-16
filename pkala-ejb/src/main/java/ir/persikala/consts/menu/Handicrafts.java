package ir.persikala.consts.menu;

public enum Handicrafts {
	
	Carpet("فرش"),Mojasame("مجسمه");
	
	private String handicrafts;

	private Handicrafts(String handicrafts) {
		this.handicrafts = handicrafts;
	}

	public String getUnionName() {
		return handicrafts;
	}
}
