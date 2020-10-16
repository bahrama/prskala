package ir.persikala.response;

public class _shards {
	 private float total;
	 private float successful;
	 private float skipped;
	 private float failed;


	 // Getter Methods 

	 public float getTotal() {
	  return total;
	 }

	 public float getSuccessful() {
	  return successful;
	 }

	 public float getSkipped() {
	  return skipped;
	 }

	 public float getFailed() {
	  return failed;
	 }

	 // Setter Methods 

	 public void setTotal(float total) {
	  this.total = total;
	 }

	 public void setSuccessful(float successful) {
	  this.successful = successful;
	 }

	 public void setSkipped(float skipped) {
	  this.skipped = skipped;
	 }

	 public void setFailed(float failed) {
	  this.failed = failed;
	 }
}
