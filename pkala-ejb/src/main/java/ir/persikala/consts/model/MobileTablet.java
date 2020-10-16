package ir.persikala.consts.model;

public enum MobileTablet {
	Samsung("سامسونگ"),Lg("الجی"),Apple("اپل"),Mi("شیامی");

	private String mobileTablet;

	private MobileTablet(String mobileTablet) {
		this.mobileTablet = mobileTablet;
	}

	public String getUnionName() {
		return mobileTablet;
	}
}
