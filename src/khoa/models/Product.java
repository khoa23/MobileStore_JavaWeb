package khoa.models;

public class Product {

	private int id;
	private String name;
	private float price;
	private int quantity;
	private String description;
	private String manufacturer;
	private int cateid;
	private String condition;
	private String image;
	private String category;

	public Product() {

	}

	public Product(String name, float price, int quantity, String description, String manufacturer, int cateid, String condition, String image) {
		//this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.manufacturer = manufacturer;
		this.cateid = cateid;
		this.condition = condition;
		this.image = image;
		//this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getCateID() {
		return cateid;
	}
	
	public void setCateID(int cateid) {
		this.cateid = cateid;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String image){
		this.image = image;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

}
