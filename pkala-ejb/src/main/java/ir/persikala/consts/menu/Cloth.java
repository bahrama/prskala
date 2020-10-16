package ir.persikala.consts.menu;

public enum Cloth {
	
	Men("پوشاک مردانه"),Women("پوشاک زنانه");

	private String cloth;

	private Cloth(String cloth) {
		this.cloth = cloth;
	}

	public String getUnionName() {
		return cloth;
	}
}
