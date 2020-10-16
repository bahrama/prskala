package ir.persikala.request;

public class FindAllProductsRequest {
	 private Query QueryObject;
	 private int size;
	 private int from;


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

	 public void setSize(int size) {
	  this.size = size;
	 }

	 public void setFrom(int from) {
	  this.from = from;
	 }
	}
	 class Query {
	 Match_all Match_allObject;


	 // Getter Methods 

	 public Match_all getMatch_all() {
	  return Match_allObject;
	 }

	 // Setter Methods 

	 public void setMatch_all(Match_all match_allObject) {
	  this.Match_allObject = match_allObject;
	 }
	}
	class Match_all {
	}
