package ir.persikala.consts.menu;

public enum Zinati {
	
	Watch("ساعت"),Gardanband("گردنبند");
	
	private String zinati;

	private Zinati(String zinati) {
		this.zinati = zinati;
	}

	public String getUnionName() {
		return zinati;
	}
}
