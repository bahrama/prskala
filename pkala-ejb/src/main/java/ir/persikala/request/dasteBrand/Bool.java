package ir.persikala.request.dasteBrand;

import java.util.ArrayList;

public class Bool {
	 ArrayList < Must > must = new ArrayList < Must > ();
	 ArrayList < Filter > filter = new ArrayList < Filter > ();
	public ArrayList<Must> getMust() {
		return must;
	}
	public void setMust(ArrayList<Must> must) {
		this.must = must;
	}
	public ArrayList<Filter> getFilter() {
		return filter;
	}
	public void setFilter(ArrayList<Filter> filter) {
		this.filter = filter;
	}


}
