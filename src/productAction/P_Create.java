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

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import vo.P_CommentVO;
import vo.ProductVO;
import vo.P_ImageVO;
import vo.ReviewVO;

public class P_Create extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
		
	private ProductVO paramClass;
	private ProductVO resultClass;
	
	private int seller;
	private String title_p;  
	private Date reg_date_p; 
	private int price;        
	private String type_delivery;
	private String type_direct;
	private String area;
	private String content_p; 
	private int status_p; 
	private String line_list;
	Calendar today = Calendar.getInstance();

	private File mainupload;
	private String mainuploadFileName;
	private String mainuploadContentType;
	
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadsFileName = new ArrayList<String>();
	private List<String> uploadsContentType = new ArrayList<String>();
	private String fileUploadPath = "/borabora/uploads/"; //메인 이미지와 공통 사용 path
	private String realFileUploadPath = "/uploads/";
	
	private P_ImageVO p_ImageVO = new P_ImageVO();
	
	private int currentPage;
	// ���� ��� ����
		private ReviewVO reviewVO;
		private int no_p;
		private int no_r;
		private int reviewer;
		private String reviewer_info;
		private String title_r;
		private String content_r;
		private String image_r;
		private Date reg_date_r;

		// ��ǰ�ı� �̹��� ���ε�
		private File reviews;
		private String reviewsFileName;
		private String reviewsContentType;
		private String fileReviewPath = "/borabora/review/"; // ������ ����
		private String realFileReviewPath ="/review/";

		// ��ǰ ��� ���
		private P_CommentVO commentClass;
		private P_CommentVO commentClass2;

		private int no_c;
		private int commentor;
		private String commentor_info;
		private String content_c;
		private int ref;
		private int re_step;
		private int re_level;
		private Date reg_date_c;
		private String replyto;
	
	
	public P_Create() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String form() throws Exception{
		return SUCCESS;	
	}

	public String execute() throws Exception {
	
		HttpServletRequest request=ServletActionContext.getRequest();

		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		String seller_info = (String)(session.getAttribute("nickname"));
		
		paramClass = new ProductVO();
		resultClass = new ProductVO();
		
		paramClass.setSeller(no_m);
		paramClass.setSeller_info(seller_info);
		paramClass.setTitle_p(getTitle_p());
		paramClass.setPrice(getPrice());
		paramClass.setType_delivery(getType_delivery());
		paramClass.setType_direct(getType_direct());
		paramClass.setArea(getArea());
		paramClass.setContent_p(getContent_p());
		paramClass.setStatus_p(0);
		paramClass.setLine_list("");
		paramClass.setReg_date_p(today.getTime());
		
		sqlMapper.insert("insert_product", paramClass);

		resultClass = (ProductVO)sqlMapper.queryForObject("select_created_pro");
	
		String mainFileName = getMainuploadFileName();
		String mainFilePath = fileUploadPath + mainFileName;
		
		
		System.out.println("mainFileName : "+mainFileName);
		System.out.println("mainFilePath : "+mainFilePath);
		
		
		if ((mainFileName == "" || mainFileName == null)==false) {
			
			System.out.println(getMainuploadFileName());	
			
			System.out.println("메인 이미지 업로드");
			p_ImageVO.setMain_image(mainFilePath);
			
			File destFile = new File("D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\borabora\\uploads\\" + mainFileName);
			File destFile2 = new File("D:\\workspace\\borabora\\WebContent\\uploads\\"+mainFileName);
			
			FileUtils.copyFile(getMainupload(), destFile); 
			FileUtils.copyFile(destFile, destFile2);
			System.out.println(destFile);
		}	
		
		for (int i = 0; i < uploads.size(); i++) {
			
			String fileName = getUploadsFileName().get(i);
			String filePath = fileUploadPath + fileName;
			
			if (i == 0) {
				if (fileName != null) {
					p_ImageVO.setImage2(filePath);
				}else{
					p_ImageVO.setImage2("null");
				}
			} else if (i == 1) {
				if (fileName != null) {
					p_ImageVO.setImage3(filePath);
				}else{
					p_ImageVO.setImage3("null");
				}
			} else if (i == 2) {
				if (fileName != null) {
					p_ImageVO.setImage4(filePath);
				}else{
					p_ImageVO.setImage4("null");
				}
			} else if (i == 3) {
				if (fileName != null) {
					p_ImageVO.setImage5(filePath);
				}else{
					p_ImageVO.setImage5("null");
				}
			}
			
			// ���� ����� ���丮 ���ϱ�
			realFileUploadPath = ServletActionContext.getServletContext().getRealPath(realFileUploadPath);
			
			//���� ���Ͽ� ���ε�
/*			File destFile = new File(realFileUploadPath + fileName); //�̰� ������.
		
			System.out.println(realFileUploadPath);�̰ɷ� realpath�� ���� �Ŀ� �������� �뿪*/ 
			
			File destFile = new File("D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\borabora\\uploads\\" + fileName);
			File destFile2 = new File("D:\\workspace\\borabora\\WebContent\\uploads\\"+fileName);
			
			FileUtils.copyFile(getUploads().get(i), destFile);
			FileUtils.copyFile(destFile, destFile2);
			
		}

		sqlMapper.insert("insert_image", p_ImageVO); //�̹������ DB�� ����
		p_ImageVO = (P_ImageVO)sqlMapper.queryForObject("select_created_img"); //���������� �ٷ� �Ѹ��� ���ؼ� ��� ������ DB ���� ������

		return SUCCESS;
	}
	
	// ���� �޼ҵ�
		public String review() throws Exception {
			// ���ǿ� �־���� ȸ���ȣ ���� �޾ƴٰ� ����
			HttpServletRequest request = ServletActionContext.getRequest();

			HttpSession session = request.getSession();
			int no_m = (Integer) (session.getAttribute("no_m"));
			String reviewer_info = (String) (session.getAttribute("nickname"));

			reviewVO = new ReviewVO();

			reviewVO.setNo_p(getNo_p());
			reviewVO.setReviewer(no_m);
			reviewVO.setReviewer_info(reviewer_info);
			reviewVO.setTitle_r(getTitle_r());
			reviewVO.setContent_r(getContent_r());
			reviewVO.setImage_r(getImage_r());
			reviewVO.setReg_date_r(today.getTime());

			String imageName = getReviewsFileName();
			String imagePath = fileReviewPath + imageName;
			
			File destFile = new File("D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\borabora\\review\\" + imageName);
			File destFile2 = new File("D:\\workspace\\borabora\\WebContent\\review\\"+imageName);
			
			FileUtils.copyFile(getReviews(), destFile);
			FileUtils.copyFile(destFile, destFile2);
			
			reviewVO.setImage_r(imagePath);


			sqlMapper.insert("insertReview", reviewVO);

			return SUCCESS;
		}

		// ù��° ��� ����
		public String board() throws Exception {

			// ���ǿ� �־���� ȸ���ȣ ���� �޾ƴٰ� ����
			HttpServletRequest request = ServletActionContext.getRequest();

			HttpSession session = request.getSession();
			int no_m = (Integer) (session.getAttribute("no_m"));
			String commentor_info = (String) (session.getAttribute("nickname"));

			commentClass = new P_CommentVO();

			commentClass.setCommentor(no_m);
			commentClass.setCommentor_info(commentor_info);

			commentClass.setNo_p(getNo_p());

			commentClass.setContent_c(getContent_c());
			commentClass.setReg_date_c(today.getTime());
			commentClass.setRe_step(0);
			commentClass.setRe_level(0);
			commentClass.setRef(0);
			commentClass.setReplyto("");
			sqlMapper.insert("insertComment", commentClass);
			
			currentPage = getCurrentPage();
			return SUCCESS;
		}

		public String comment() throws Exception {
			// ���ǿ� �־���� ȸ���ȣ ���� �޾ƴٰ� ����
			HttpServletRequest request = ServletActionContext.getRequest();

			HttpSession session = request.getSession();
			int no_m = (Integer) (session.getAttribute("no_m"));
			String commentor_info = (String) (session.getAttribute("nickname"));

			commentClass = new P_CommentVO();
			commentClass2 = new P_CommentVO();

			commentClass2 = (P_CommentVO) sqlMapper.queryForObject("commentOne",
					getNo_c());

			commentClass2.setRef(commentClass2.getRef());
			commentClass2.setRe_step(commentClass2.getRe_step());
			sqlMapper.update("updateCommentStep", commentClass2);

			commentClass.setNo_p(getNo_p());
			commentClass.setCommentor(no_m);
			commentClass.setCommentor_info(commentor_info);
			commentClass.setContent_c(getContent_c());
			commentClass.setReg_date_c(today.getTime());

			commentClass.setRe_step(commentClass2.getRe_step() + 1);
			commentClass.setRe_level(commentClass2.getRe_level() + 1);
			commentClass.setRef(commentClass2.getRef());
			commentClass.setReplyto(commentClass2.getCommentor_info());

			sqlMapper.insert("insertComment2", commentClass);

			currentPage = getCurrentPage();
			return SUCCESS;
		}
	
	public String getRealFileUploadPath() {
		return realFileUploadPath;
	}

	public void setRealFileUploadPath(String realFileUploadPath) {
		this.realFileUploadPath = realFileUploadPath;
	}

	public ProductVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(ProductVO paramClass) {
		this.paramClass = paramClass;
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
	
	//�̹��� ���
	public List<File> getUploads() {
		return uploads;
	}

	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	public List<String> getUploadsFileName() {
		return uploadsFileName;
	}

	public void setUploadsFileName(List<String> uploadsFileName) {

		this.uploadsFileName = uploadsFileName;
	}

	public List<String> getUploadsContentType() {
		return uploadsContentType;
	}

	public void setUploadsContentType(List<String> uploadsContentType) {
		this.uploadsContentType = uploadsContentType;
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

	public ReviewVO getReviewVO() {
		return reviewVO;
	}

	public void setReviewVO(ReviewVO reviewVO) {
		this.reviewVO = reviewVO;
	}

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

	public File getReviews() {
		return reviews;
	}

	public void setReviews(File reviews) {
		this.reviews = reviews;
	}

	public String getReviewsFileName() {
		return reviewsFileName;
	}

	public void setReviewsFileName(String reviewsFileName) {
		this.reviewsFileName = reviewsFileName;
	}

	public String getReviewsContentType() {
		return reviewsContentType;
	}

	public void setReviewsContentType(String reviewsContentType) {
		this.reviewsContentType = reviewsContentType;
	}

	public String getFileReviewPath() {
		return fileReviewPath;
	}

	public void setFileReviewPath(String fileReviewPath) {
		this.fileReviewPath = fileReviewPath;
	}

	public P_CommentVO getCommentClass() {
		return commentClass;
	}

	public void setCommentClass(P_CommentVO commentClass) {
		this.commentClass = commentClass;
	}

	public P_CommentVO getCommentClass2() {
		return commentClass2;
	}

	public void setCommentClass2(P_CommentVO commentClass2) {
		this.commentClass2 = commentClass2;
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

	public String getRealFileReviewPath() {
		return realFileReviewPath;
	}

	public void setRealFileReviewPath(String realFileReviewPath) {
		this.realFileReviewPath = realFileReviewPath;
	}

	public String getReplyto() {
		return replyto;
	}

	public void setReplyto(String replyto) {
		this.replyto = replyto;
	}
	
	public File getMainupload() {
		return mainupload;
	}

	public void setMainupload(File mainupload) {
		this.mainupload = mainupload;
	}

	public String getMainuploadFileName() {
		return mainuploadFileName;
	}

	public void setMainuploadFileName(String mainuploadFileName) {
		this.mainuploadFileName = mainuploadFileName;
	}

	public String getMainuploadContentType() {
		return mainuploadContentType;
	}

	public void setMainuploadContentType(String mainuploadContentType) {
		this.mainuploadContentType = mainuploadContentType;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
