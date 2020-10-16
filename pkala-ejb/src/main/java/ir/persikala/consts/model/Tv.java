package ir.persikala.consts.model;

public enum Tv {
	Samsung("سامسونگ"),Lg("الجی"),Apple("اپل"),Mi("شیامی"),Panasonic("پاناسونیک");

	private String tv;

	private Tv(String tv) {
		this.tv = tv;
	}

	public String getUnionName() {
		return tv;
	}
}
