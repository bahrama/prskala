package ir.persikala.request.searchMach;

public class FindMatchRequestDaste {
	Query3 QueryObject;
	 private float size;
	 private float from;


	 // Getter Methods 

	 public Query3 getQuery() {
	  return QueryObject;
	 }

	 public float getSize() {
	  return size;
	 }

	 public float getFrom() {
	  return from;
	 }

	 // Setter Methods 

	 public void setQuery(Query3 queryObject) {
	  this.QueryObject = queryObject;
	 }

	 public void setSize(float size) {
	  this.size = size;
	 }

	 public void setFrom(float from) {
	  this.from = from;
	 }
	}
