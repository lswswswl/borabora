package memberAction;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;

import vo.MemberVO;

public class M_Create extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO paramClass;
	private MemberVO resultClass;
	
	private String name;
	private String email;
	private String phone;
	private String password;
	
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
	
	private File uploads;
	private String uploadsFileName = "";
	private String uploadsContentType = "";
	private String fileUploadPath = "/borabora/profile/"; //������ ����
	private String realFileUploadPath = "/profile/";
	
	
	public M_Create() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;	
	}

	public String execute() throws Exception {
		
		paramClass = new MemberVO();
		resultClass = new MemberVO();
		
		paramClass.setName(getName());
		paramClass.setEmail(getEmail());
		paramClass.setPhone(getPhone());
		paramClass.setPassword(getPassword());
		paramClass.setNickname(getNickname());
		paramClass.setAddress1(getAddress1());
		paramClass.setAddress2(getAddress2());
		paramClass.setZipcode(getZipcode());
		paramClass.setBank_name(getBank_name());
		paramClass.setBank_account(getBank_account());
		paramClass.setBalance(getBalance());
		paramClass.setRegistered_product(getRegistered_product());
		paramClass.setSold(getSold());
		paramClass.setBought(getBought());
		paramClass.setProfile_image("");
		
		paramClass.setSignup_date(today.getTime());
			

		String fileName = getUploadsFileName();
		String filePath = fileUploadPath + fileName;
		
		if ((fileName == "" || fileName == null)==false) {
			paramClass.setProfile_image(filePath);
			
			File destFile = new File("D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\borabora\\profile\\" + fileName);
			File destFile2 = new File("D:\\workspace\\borabora\\WebContent\\profile\\"+fileName);
			
			FileUtils.copyFile(getUploads(), destFile); 
			FileUtils.copyFile(destFile, destFile2);
			
		}else{
			paramClass.setProfile_image("");
		}
		
		sqlMapper.insert("insert_member", paramClass);		
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		M_Create.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		M_Create.sqlMapper = sqlMapper;
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
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

	public File getUploads() {
		return uploads;
	}

	public void setUploads(File uploads) {
		this.uploads = uploads;
	}

	public String getUploadsFileName() {
		return uploadsFileName;
	}

	public void setUploadsFileName(String uploadsFileName) {
		this.uploadsFileName = uploadsFileName;
	}

	public String getUploadsContentType() {
		return uploadsContentType;
	}

	public void setUploadsContentType(String uploadsContentType) {
		this.uploadsContentType = uploadsContentType;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public String getRealFileUploadPath() {
		return realFileUploadPath;
	}

	public void setRealFileUploadPath(String realFileUploadPath) {
		this.realFileUploadPath = realFileUploadPath;
	}

}	