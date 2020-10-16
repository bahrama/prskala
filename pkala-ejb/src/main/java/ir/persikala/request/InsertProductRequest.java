package ir.persikala.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InsertProductRequest {
	private String name;
	 private String brand;
	 private String release_date;
	 private boolean new_old;
	 private float takhfif_darsad;
	 private String description;
	 private String daste;
	 private String noe;
	 ArrayList < Object > omde_tak = new ArrayList < Object > ();
	 private float price;
	 private String shoar;
	 ArrayList < Object > color = new ArrayList < Object > ();
	 private String model;
	 Map<String , Object> vijegi = new HashMap<> ();
	 private boolean mojod;
	 private String contry;
     private int bazdid;
     private int forosh;

	 // Getter Methods 

	 public String getName() {
	  return name;
	 }

	 public String getBrand() {
	  return brand;
	 }



	 public boolean getNew_old() {
	  return new_old;
	 }

	 public float getTakhfif_darsad() {
	  return takhfif_darsad;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public String getDaste() {
	  return daste;
	 }

	 public String getNoe() {
	  return noe;
	 }

	 public float getPrice() {
	  return price;
	 }

	 public String getShoar() {
	  return shoar;
	 }

	 public String getModel() {
	  return model;
	 }

	 public boolean getMojod() {
	  return mojod;
	 }

	 public String getContry() {
	  return contry;
	 }

	 // Setter Methods 

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setBrand(String brand) {
	  this.brand = brand;
	 }




	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public void setNew_old(boolean new_old) {
	  this.new_old = new_old;
	 }

	 public void setTakhfif_darsad(float takhfif_darsad) {
	  this.takhfif_darsad = takhfif_darsad;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }

	 public void setDaste(String daste) {
	  this.daste = daste;
	 }

	 public void setNoe(String noe) {
	  this.noe = noe;
	 }

	 public void setPrice(float price) {
	  this.price = price;
	 }

	 public void setShoar(String shoar) {
	  this.shoar = shoar;
	 }

	 public void setModel(String model) {
	  this.model = model;
	 }

	 public void setMojod(boolean mojod) {
	  this.mojod = mojod;
	 }

	 public void setContry(String contry) {
	  this.contry = contry;
	 }

	public ArrayList<Object> getOmde_tak() {
		return omde_tak;
	}

	public void setOmde_tak(ArrayList<Object> omde_tak) {
		this.omde_tak = omde_tak;
	}

	public ArrayList<Object> getColor() {
		return color;
	}

	public void setColor(ArrayList<Object> color) {
		this.color = color;
	}

	public Map<String, Object> getVijegi() {
		return vijegi;
	}

	public void setVijegi(Map<String, Object> vijegi) {
		this.vijegi = vijegi;
	}

	public int getBazdid() {
		return bazdid;
	}

	public void setBazdid(int bazdid) {
		this.bazdid = bazdid;
	}

	public int getForosh() {
		return forosh;
	}

	public void setForosh(int forosh) {
		this.forosh = forosh;
	}


	 
	 
	}