package ir.persikala.consts.menu;

public enum CulturalProducts {
	
	Film("فیلم"),Music("موزیک");
	
	private String cult;

	private CulturalProducts(String cult) {
		this.cult = cult;
	}

	public String getUnionName() {
		return cult;
	}
}
