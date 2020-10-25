package ir.persikala.user.response.findmobile;

public class HitObject {
		 private String _index;
		 private String _type;
		 private String _id;
		 private float _score;
		 _source _sourceObject;


		 // Getter Methods 

		 public String get_index() {
		  return _index;
		 }

		 public String get_type() {
		  return _type;
		 }

		 public String get_id() {
		  return _id;
		 }

		 public float get_score() {
		  return _score;
		 }

		 public _source get_source() {
		  return _sourceObject;
		 }

		 // Setter Methods 

		 public void set_index(String _index) {
		  this._index = _index;
		 }

		 public void set_type(String _type) {
		  this._type = _type;
		 }

		 public void set_id(String _id) {
		  this._id = _id;
		 }

		 public void set_score(float _score) {
		  this._score = _score;
		 }

		 public void set_source(_source _sourceObject) {
		  this._sourceObject = _sourceObject;
		 }
		}
		