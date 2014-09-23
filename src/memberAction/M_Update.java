package memberAction;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import vo.MemberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class M_Update extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO memberVO;
	private MemberVO paramClass;
	
	//�ʼ�����
/*	private String name;
	private String email;*/
	private String phone;
	private String password;
	
	//���ʼ�����
	private String nickname;
	private String profile_image;
	private String address1;
	private String address2;
	private String zipcode;
	private String bank_name;
	private String bank_account;
/*	private int balance;
	private int registered_product;
	private int sold;
	private int bought;
	
	private Date signup_date;
	

	Calendar today = Calendar.getInstance();
*/
	
	//������ �̹��� ���ε�
	private File uploads;
	private String uploadsFileName = "";
	private String uploadsContentType = "";
	private String fileUploadPath = "/borabora/profile/"; //������ ����
	private String realFileUploadPath = "/profile/";
	
	
	
	public M_Update() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception{
		
		memberVO = new MemberVO();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
	
		memberVO = (MemberVO)sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		
		return SUCCESS;
	}

	public String execute() throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		paramClass = new MemberVO();
		
		paramClass.setNo_m(no_m);
		paramClass.setPhone(getPhone());
		paramClass.setPassword(getPassword());
		paramClass.setNickname(getNickname());
		paramClass.setAddress1(getAddress1());
		paramClass.setAddress2(getAddress2());
		paramClass.setZipcode(getZipcode());
		paramClass.setBank_name(getBank_name());
		paramClass.setBank_account(getBank_account());
		
		memberVO = (MemberVO)sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		profile_image = memberVO.getProfile_image(); // ���� ������ �̹��� ���
		
		
		String fileName = getUploadsFileName(); // ���� ����ϰԵǴ� �̹������ϸ�
		
		System.out.println(profile_image); // /borabora/profile/Jellyfish.jpg
		System.out.println(fileName);      // Lighthouse.jpg
		
		// if)   �̹����� ���� ������� �ʴ´ٸ� ������ �̹��� ��θ� �ٽ� �־���
		// else) ���� �̹����� ����ϸ� destFile�� �����ϰ� profile_image�� ���� �ٲ�
		if(fileName.equals("") || fileName == null) {
			paramClass.setProfile_image(profile_image);
		} else {
			String filePath = fileUploadPath + fileName;
			
			paramClass.setProfile_image(filePath);
			System.out.println("check check check");
			System.out.println(fileName); 
			System.out.println(filePath); 
			
			File destFile = new File("D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\borabora\\profile\\" + fileName);
			File destFile2 = new File("D:\\workspace\\borabora\\WebContent\\profile\\"+fileName);
			
			FileUtils.copyFile(getUploads(), destFile); // ����
			FileUtils.copyFile(destFile, destFile2);
		}
		
		if((paramClass.getNickname() == null || paramClass.getNickname() =="") == false){
			session.setAttribute("nickname", paramClass.getNickname());
		}
		
		sqlMapper.update("update_member", paramClass);
		
		memberVO = (MemberVO)sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		
		return SUCCESS;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
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