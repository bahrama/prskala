package ir.persikala.consts.menu;

public enum Health {
	
	Saboon("صابون"),Shampo("شامپو"),Tide("تاید");
	
	private String health;

	private Health(String health) {
		this.health = health;
	}

	public String getUnionName() {
		return health;
	}
}
