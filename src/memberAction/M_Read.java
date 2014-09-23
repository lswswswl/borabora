package memberAction;

import com.opensymphony.xwork2.ActionSupport;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import vo.FavoriteVO;
import vo.MemberVO;
import vo.P_ImageVO;
import vo.P_ListVO;
import vo.ProductVO;

public class M_Read extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	//찜하기 검색을 위한 VO
	private List<FavoriteVO> flist = new ArrayList<FavoriteVO>();
	private P_ListVO productVO;
	private List<P_ListVO> plist = new ArrayList<P_ListVO>();
	//찜하기
	
	private MemberVO memberVO;
	
	//필수정보
	private String name;
	private String email;
	private String phone;
	private String password;
	
	//안필수정보
	private String nickname;
	private String profile_image;
	private String address1;
	private String address2;
	private String zipcode;
	private String bank_name;
	private String bank_account;
	private int balance;
	private int registered_product;
	private int sold;
	private int bought;
	
	private Date signup_date;
	

	Calendar today = Calendar.getInstance();

	
	public M_Read() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;	
	}

	public String execute() throws Exception {
		
		memberVO = new MemberVO();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
	
		memberVO = (MemberVO)sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		
		//찜하기 부분
		flist = sqlMapper.queryForList("select_favorite", no_m);
		
		if(!flist.isEmpty()){
			
			for(int i = 0; i < flist.size(); i++){
				
				productVO = new P_ListVO();
				productVO = (P_ListVO)sqlMapper.queryForObject("select_one_pro_list", flist.get(i).getFavorite_list());
				
				plist.add(productVO);
			}
		}
		//찜하기 부분
		
		return SUCCESS;
	}


	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getRegistered_product() {
		return registered_product;
	}

	public void setRegistered_product(int registered_product) {
		this.registered_product = registered_product;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public int getBought() {
		return bought;
	}

	public void setBought(int bought) {
		this.bought = bought;
	}

	public Date getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public List<FavoriteVO> getFlist() {
		return flist;
	}

	public void setFlist(List<FavoriteVO> flist) {
		this.flist = flist;
	}

	public P_ListVO getProductVO() {
		return productVO;
	}

	public void setProductVO(P_ListVO productVO) {
		this.productVO = productVO;
	}

	public List<P_ListVO> getPlist() {
		return plist;
	}

	public void setPlist(List<P_ListVO> plist) {
		this.plist = plist;
	}
	
}	