package ir.persikala.user.response.findmobile;

public class UserFindEntity {

		 private float took;
		 private boolean timed_out;
		 _shards _shardsObject;
		 Hits HitsObject;


		 // Getter Methods 

		 public float getTook() {
		  return took;
		 }

		 public boolean getTimed_out() {
		  return timed_out;
		 }

		 public _shards get_shards() {
		  return _shardsObject;
		 }

		 public Hits getHits() {
		  return HitsObject;
		 }

		 // Setter Methods 

		 public void setTook(float took) {
		  this.took = took;
		 }

		 public void setTimed_out(boolean timed_out) {
		  this.timed_out = timed_out;
		 }

		 public void set_shards(_shards _shardsObject) {
		  this._shardsObject = _shardsObject;
		 }

		 public void setHits(Hits hitsObject) {
		  this.HitsObject = hitsObject;
		 }
		}
		
		
	