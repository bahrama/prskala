package ir.persikala.request.multiMatch.brand;

public class MultiBrandFilter {
	 Query QueryObject;
	 private float size;
	 private float from;


	 // Getter Methods 

	 public Query getQuery() {
	  return QueryObject;
	 }

	 public float getSize() {
	  return size;
	 }

	 public float getFrom() {
	  return from;
	 }

	 // Setter Methods 

	 public void setQuery(Query queryObject) {
	  this.QueryObject = queryObject;
	 }

	 public void setSize(float size) {
	  this.size = size;
	 }

	 public void setFrom(float from) {
	  this.from = from;
	 }
	}

