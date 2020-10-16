package ir.persikala.response;

import java.util.ArrayList;

public class Hits {
	 Total TotalObject;
	 private float max_score;
	 ArrayList < ProductDetail > hits = new ArrayList < ProductDetail > ();


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

	 public ArrayList<ProductDetail> getHits() {
		return hits;
	}

	public void setHits(ArrayList<ProductDetail> hits) {
		this.hits = hits;
	}

	public void setMax_score(float max_score) {
	  this.max_score = max_score;
	 }
	}