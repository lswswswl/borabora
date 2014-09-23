package vo;

import java.util.Date;

public class ProductVO {
	
	private int no_p;
	private int seller;
	private String seller_info;
	private String title_p;
	private Date reg_date_p;
	private int price;
	private String type_delivery;
	private String type_direct;
	private String area;
	private String content_p;
	private int status_p;
	private String line_list;
	private int read_count;
	
	public int getNo_p() {
		return no_p;
	}
	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}
	public int getSeller() {
		return seller;
	}
	public void setSeller(int seller) {
		this.seller = seller;
	}
	public String getSeller_info() {
		return seller_info;
	}
	public void setSeller_info(String seller_info) {
		this.seller_info = seller_info;
	}
	public String getTitle_p() {
		return title_p;
	}
	public void setTitle_p(String title_p) {
		this.title_p = title_p;
	}
	public Date getReg_date_p() {
		return reg_date_p;
	}
	public void setReg_date_p(Date reg_date_p) {
		this.reg_date_p = reg_date_p;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType_delivery() {
		return type_delivery;
	}
	public void setType_delivery(String type_delivery) {
		this.type_delivery = type_delivery;
	}
	public String getType_direct() {
		return type_direct;
	}
	public void setType_direct(String type_direct) {
		this.type_direct = type_direct;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getContent_p() {
		return content_p;
	}
	public void setContent_p(String content_p) {
		this.content_p = content_p;
	}
	public int getStatus_p() {
		return status_p;
	}
	public void setStatus_p(int status_p) {
		this.status_p = status_p;
	}
	public String getLine_list() {
		return line_list;
	}
	public void setLine_list(String line_list) {
		this.line_list = line_list;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
}
