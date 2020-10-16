package ir.persikala.consts.menu;

public enum Electrical {

	Diode("دیود"),Capacitor("خازن");
	
private String electrical;

private Electrical(String electrical) {
	this.electrical = electrical;
}

public String getUnionName() {
	return electrical;
}
}
