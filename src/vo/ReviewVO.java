package vo;

import java.util.Date;

public class ReviewVO {

	private int no_p;
	private int no_r;
	private int reviewer;
	private String reviewer_info;
	private String title_r;
	private String content_r;
	private String image_r;
	private Date reg_date_r;
	
	public int getNo_p() {
		return no_p;
	}
	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}
	public int getNo_r() {
		return no_r;
	}
	public void setNo_r(int no_r) {
		this.no_r = no_r;
	}
	public int getReviewer() {
		return reviewer;
	}
	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}
	public String getReviewer_info() {
		return reviewer_info;
	}
	public void setReviewer_info(String reviewer_info) {
		this.reviewer_info = reviewer_info;
	}
	public String getTitle_r() {
		return title_r;
	}
	public void setTitle_r(String title_r) {
		this.title_r = title_r;
	}
	public String getContent_r() {
		return content_r;
	}
	public void setContent_r(String content_r) {
		this.content_r = content_r;
	}
	public String getImage_r() {
		return image_r;
	}
	public void setImage_r(String image_r) {
		this.image_r = image_r;
	}
	public Date getReg_date_r() {
		return reg_date_r;
	}
	public void setReg_date_r(Date reg_date_r) {
		this.reg_date_r = reg_date_r;
	}
	
	
	
}
