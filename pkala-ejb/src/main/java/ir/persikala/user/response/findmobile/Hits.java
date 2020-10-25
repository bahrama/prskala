package ir.persikala.user.response.findmobile;

import java.util.ArrayList;

public class Hits {
	 Total TotalObject;
	 private float max_score;
	 ArrayList < HitObject > hits = new ArrayList < HitObject > ();


	 // Getter Methods 

	 public Total getTotal() {
	  return TotalObject;
	 }

	 public float getMax_score() {
	  return max_score;
	 }

	 // Setter Methods 

	 public void setTotal(Total totalObject) {
	  this.TotalObject = totalObject;
	 }

	 public void setMax_score(float max_score) {
	  this.max_score = max_score;
	 }

	public Total getTotalObject() {
		return TotalObject;
	}

	public void setTotalObject(Total totalObject) {
		TotalObject = totalObject;
	}

	public ArrayList<HitObject> getHits() {
		return hits;
	}

	public void setHits(ArrayList<HitObject> hits) {
		this.hits = hits;
	}
	 
	 
	}