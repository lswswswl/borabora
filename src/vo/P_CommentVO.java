package vo;

import java.util.Date;

public class P_CommentVO {
	
    private int no_p;
	private int no_c;
	private int commentor;
	private String commentor_info;
	private String content_c;
	private int ref;         
	private int re_step;     
	private int re_level;    
	private Date reg_date_c;
	private String replyto;
	
	public int getNo_p() {
		return no_p;
	}
	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}
	public int getNo_c() {
		return no_c;
	}
	public void setNo_c(int no_c) {
		this.no_c = no_c;
	}
	public int getCommentor() {
		return commentor;
	}
	public void setCommentor(int commentor) {
		this.commentor = commentor;
	}
	public String getCommentor_info() {
		return commentor_info;
	}
	public void setCommentor_info(String commentor_info) {
		this.commentor_info = commentor_info;
	}
	public String getContent_c() {
		return content_c;
	}
	public void setContent_c(String content_c) {
		this.content_c = content_c;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public Date getReg_date_c() {
		return reg_date_c;
	}
	public void setReg_date_c(Date reg_date_c) {
		this.reg_date_c = reg_date_c;
	}
	public String getReplyto() {
		return replyto;
	}
	public void setReplyto(String replyto) {
		this.replyto = replyto;
	}
	
	
	
	
}
