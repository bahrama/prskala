package ir.persikala.consts.menu;

public enum Container {
	
	Chini("چینی"),Yekbar("یکبار مصرف");

private String cotainer;

private Container(String cotainer) {
	this.cotainer = cotainer;
}

public String getUnionName() {
	return cotainer;
}
}
