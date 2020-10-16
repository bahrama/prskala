package ir.persikala.request.dasteBrand;

import java.util.ArrayList;

public class Multi_match {
	 private String query;
	 ArrayList < Object > fields = new ArrayList < Object > ();


	 // Getter Methods 

	 public String getQuery() {
	  return query;
	 }

	 // Setter Methods 

	 public void setQuery(String query) {
	  this.query = query;
	 }

	public ArrayList<Object> getFields() {
		return fields;
	}

	public void setFields(ArrayList<Object> fields) {
		this.fields = fields;
	}
	 
	 
}
