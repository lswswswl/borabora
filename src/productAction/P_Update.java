package productAction;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;






import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import vo.P_CommentVO;
import vo.ProductVO;
import vo.P_ImageVO;
import vo.ReviewVO;

public class P_Update extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
		
	// 상품정보 관련
	private ProductVO productVO;
	private ProductVO resultClass;
	
	// 변경 불가
	private int seller;
	private String seller_info;
	private Date reg_date_p;  // 등록일자
	private int status_p; 
	private int no_p;
	
	// 변경 가능
	private String title_p;   // 상품명
	private int price;        // 가격
	private String type_delivery;
	private String type_direct;
	private String area;
	private String content_p; // 내용

	private String line_list;
	Calendar today = Calendar.getInstance();
	
	// private List<File> uploads = new ArrayList<File>();	
	// private List<String> uploadsFileName = new ArrayList<String>();
	private File mainupload2;
	private String mainupload2FileName = new String();
	
	private File uploads2;
	private String uploads2FileName = new String();
	
	private File uploads3;
	private String uploads3FileName = new String();
	
	private File uploads4;
	private String uploads4FileName = new String();
	
	private File uploads5;
	private String uploads5FileName = new String();
	
	private String fileUploadPath = "/borabora/uploads/"; 
	private String realFileUploadPath = "/uploads/";
	
	private P_ImageVO p_ImageVO = new P_ImageVO();
	private P_ImageVO result_ImageVO = new P_ImageVO();

	public P_Update() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String form() throws Exception{		
		productVO = new ProductVO();	
		
		productVO = (ProductVO)sqlMapper.queryForObject("select_one_pro", getNo_p());		
		p_ImageVO = (P_ImageVO)sqlMapper.queryForObject("select_one_img", getNo_p());
		
		return SUCCESS;	
	}

	public String execute() throws Exception {	
		//세션에 넣어놓은 회원번호 값을 받아다가 저장
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		// String seller_info = (String)(session.getAttribute("nickname"));
		
		productVO = new ProductVO();
		
		productVO.setNo_p(getNo_p());
		
		productVO.setSeller(seller);
		productVO.setSeller_info(seller_info);
		productVO.setTitle_p(getTitle_p());
		productVO.setPrice(getPrice());
		productVO.setType_delivery(getType_delivery());
		productVO.setType_direct(getType_direct());
		productVO.setArea(getArea());
		productVO.setContent_p(getContent_p());
		// productVO.setStatus_p(0);
		// productVO.setLine_list("");
		// productVO.setReg_date_p(today.getTime());

			
		sqlMapper.update("updateProduct", productVO);
		resultClass = (ProductVO)sqlMapper.queryForObject("select_one_pro", getNo_p());
		
		
		// 기존 업로드 이미지 경로들이 있는 객체
		p_ImageVO = (P_ImageVO)sqlMapper.queryForObject("select_one_img", getNo_p());
		
		String dest = "D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\borabora\\uploads\\";
		String dest2 = "D:\\workspace\\borabora\\WebContent\\uploads\\";
		
		File destFile, destFile2;
		
		if(mainupload2 != null) {
			System.out.println(getMainupload2FileName());
			result_ImageVO.setMain_image(fileUploadPath + getMainupload2FileName());
			
			destFile = new File(dest + getMainupload2FileName());
			destFile2 = new File(dest2 + getMainupload2FileName());			
			FileUtils.copyFile(getMainupload2(), destFile);
			FileUtils.copyFile(destFile, destFile2);			
		}else if (mainupload2 == null) {
			result_ImageVO.setMain_image(p_ImageVO.getMain_image());
		}
		
		if(uploads2 != null) {
			System.out.println(getUploads2FileName());
			result_ImageVO.setImage2(fileUploadPath + getUploads2FileName());
			
			destFile = new File(dest + getUploads2FileName());
			destFile2 = new File(dest2 + getUploads2FileName());			
			FileUtils.copyFile(getUploads2(), destFile);
			FileUtils.copyFile(destFile, destFile2);
		}else if (uploads2 == null) {
			result_ImageVO.setImage2(p_ImageVO.getImage2());
		}
			
		if(uploads3 != null) {
			result_ImageVO.setImage3(fileUploadPath + getUploads3FileName());
			
			destFile = new File(dest + getUploads3FileName());
			destFile2 = new File(dest2 + getUploads3FileName());			
			FileUtils.copyFile(getUploads3(), destFile);
			FileUtils.copyFile(destFile, destFile2);
		}else if (uploads3 == null) {
			result_ImageVO.setImage3(p_ImageVO.getImage3());
		}
		
		if(uploads4 != null) {
			result_ImageVO.setImage4(fileUploadPath + getUploads4FileName());
			
			destFile = new File(dest + getUploads4FileName());
			destFile2 = new File(dest2 + getUploads4FileName());			
			FileUtils.copyFile(getUploads4(), destFile);
			FileUtils.copyFile(destFile, destFile2);
		}else if (uploads4 == null) {
			result_ImageVO.setImage4(p_ImageVO.getImage4());
		}
		
		if(uploads5 != null) {
			result_ImageVO.setImage5(fileUploadPath + getUploads5FileName());
			
			destFile = new File(dest + getUploads5FileName());
			destFile2 = new File(dest2 + getUploads5FileName());			
			FileUtils.copyFile(getUploads5(), destFile);
			FileUtils.copyFile(destFile, destFile2);
		}else if (uploads5 == null) {
			result_ImageVO.setImage5(p_ImageVO.getImage5());
		}

		// 실제 저장될 디렉토리 구하기
		// realFileUploadPath = ServletActionContext.getServletContext().getRealPath(realFileUploadPath);
			
		System.out.println("ok2");
			
					
		result_ImageVO.setNo_p(getNo_p());
		sqlMapper.update("update_image", result_ImageVO); //이미지경로 DB에 삽입
		p_ImageVO = (P_ImageVO)sqlMapper.queryForObject("select_one_img", getNo_p());
		//상세페이지로 바로 뿌리기 위해서 DB 행을 가져옴

		return SUCCESS;
	}
	


	public void setRealFileUploadPath(String realFileUploadPath) {
		this.realFileUploadPath = realFileUploadPath;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	public ProductVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(ProductVO resultClass) {
		this.resultClass = resultClass;
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

	public String getContent_p() {
		return content_p;
	}

	public void setContent_p(String content_p) {
		this.content_p = content_p;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
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

	public static void main(String[] args) {
	}
		
	
	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public P_ImageVO getP_ImageVO() {
		return p_ImageVO;
	}

	public void setP_ImageVO(P_ImageVO p_ImageVO) {
		this.p_ImageVO = p_ImageVO;
	}

	public int getNo_p() {
		return no_p;
	}

	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}

	public String getSeller_info() {
		return seller_info;
	}

	public void setSeller_info(String seller_info) {
		this.seller_info = seller_info;
	}

	public P_ImageVO getResult_ImageVO() {
		return result_ImageVO;
	}

	public void setResult_ImageVO(P_ImageVO result_ImageVO) {
		this.result_ImageVO = result_ImageVO;
	}

	public File getMainupload2() {
		return mainupload2;
	}

	public void setMainupload2(File mainupload) {
		this.mainupload2 = mainupload;
	}

	public String getMainupload2FileName() {
		return mainupload2FileName;
	}

	public void setMainupload2FileName(String mainupload2FileName) {
		this.mainupload2FileName = mainupload2FileName;
	}

	public File getUploads2() {
		return uploads2;
	}

	public void setUploads2(File uploads2) {
		this.uploads2 = uploads2;
	}

	public String getUploads2FileName() {
		return uploads2FileName;
	}

	public void setUploads2FileName(String uploads2FileName) {
		this.uploads2FileName = uploads2FileName;
	}

	public File getUploads3() {
		return uploads3;
	}

	public void setUploads3(File uploads3) {
		this.uploads3 = uploads3;
	}

	public String getUploads3FileName() {
		return uploads3FileName;
	}

	public void setUploads3FileName(String uploads3FileName) {
		this.uploads3FileName = uploads3FileName;
	}

	public File getUploads4() {
		return uploads4;
	}

	public void setUploads4(File uploads4) {
		this.uploads4 = uploads4;
	}

	public String getUploads4FileName() {
		return uploads4FileName;
	}

	public void setUploads4FileName(String uploads4FileName) {
		this.uploads4FileName = uploads4FileName;
	}

	public File getUploads5() {
		return uploads5;
	}

	public void setUploads5(File uploads5) {
		this.uploads5 = uploads5;
	}

	public String getUploads5FileName() {
		return uploads5FileName;
	}

	public void setUploads5FileName(String uploads5FileName) {
		this.uploads5FileName = uploads5FileName;
	}

	
	
}