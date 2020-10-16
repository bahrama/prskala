package ir.persikala.consts.menu;

public enum Digital {
Mobile("گوشی و تبلت"),Tv("تلویزیون"),Game("ابزار بازی"),Pc("رایانه");

private String digital;

private Digital(String digital) {
	this.digital = digital;
}

public String getUnionName() {
	return digital;
}
}
