package ir.persikala.consts.menu;

public enum Daste {
	
	 Digital("صوتی و تصویری"),Container("ظروف"),Electrical("وسایل الکتریکی")
	 ,Handicrafts("صنایع دستی"),Zinati("کالای زینتی"),Cloth("پوشاک")
	 ,Health("بهداشتی"),CulturalProducts("محصولات فرهنگی");
	
	private String daste;

	private Daste(String daste) {
		this.daste = daste;
	}

	public String getUnionName() {
		return daste;
	}
}
