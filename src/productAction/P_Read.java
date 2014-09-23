package productAction;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vo.FavoriteVO;
import vo.MemberVO;
import vo.P_CommentImageVO;
import vo.P_CommentVO;
import vo.P_ListVO;
import vo.ProductVO;
import vo.P_ImageVO;
import vo.LineVO;

import vo.ReviewVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class P_Read extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private ProductVO paramClass;
	private ProductVO resultClass;
	private P_ImageVO p_ImageVO;
	private LineVO lineVO;
	private int myLineStatus;
	
	private List<LineVO> lineList = new ArrayList<LineVO>();
	
	//���� ��ǰ���� �ƴ��� üũ�ϱ����� �߰�
	private FavoriteVO favoClass;
	//���� ��ǰ���� �ƴ��� üũ�ϱ����� �߰�
	
	private int currentPage;
	private int no_p;
	
	// ���� ��� ����
		private ReviewVO reviewVO;
		private int no_r;

		// ��۷����� �ʿ��� ����
		private P_CommentVO commentClass = new P_CommentVO();
		private P_CommentVO commentClass2 = new P_CommentVO();
		private MemberVO cClass = new MemberVO();

		private int no_c;
		private String password;
		private String content_c;
		private String profile_image;

		private List<P_CommentImageVO> commentList = new ArrayList<P_CommentImageVO>();
		private List<P_CommentVO> deleteList = new ArrayList<P_CommentVO>(); 
		private int totalComment;

	
	
	
	public P_Read() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		paramClass = new ProductVO();
		p_ImageVO = new P_ImageVO();
		
		paramClass.setNo_p(getNo_p());
		p_ImageVO.setNo_p(getNo_p());
		sqlMapper.update("updateReadCount",paramClass);
		
		resultClass = (ProductVO) sqlMapper.queryForObject("select_one_pro", getNo_p());
		p_ImageVO = (P_ImageVO) sqlMapper.queryForObject("select_one_img", getNo_p());
		
		lineList = sqlMapper.queryForList("line_in_order", getNo_p());
		
		//���� ��ǰ���� �ƴ��� üũ�ϱ����� �߰�
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		
		if((session.getAttribute("no_m")==null||session.getAttribute("no_m")=="")==false){
			int no_m = (Integer)(session.getAttribute("no_m"));
			
			FavoriteVO favoParam = new FavoriteVO();
			favoParam.setNo_m(no_m);
			favoParam.setFavorite_list(getNo_p());
			
			favoClass = new FavoriteVO();
			favoClass = (FavoriteVO)sqlMapper.queryForObject("select_favorite_check", favoParam);
			
			HashMap myLine = new HashMap();
			myLine.put("no_m", no_m);
			myLine.put("no_p", getNo_p());
			
			lineVO = (LineVO) sqlMapper.queryForObject("select_one_line", myLine); 
			
			if(lineVO==null){
				myLineStatus = 0;
			}else{
				myLineStatus = lineVO.getLine_number();
			}
			

		}		
		
		
		review();
						
				// comment() �޼ҵ� �����Ͽ� ���action�� ����
		comment();
		
		
		return SUCCESS;
	}
	
public String review() throws Exception {
		
		reviewVO = (ReviewVO) sqlMapper.queryForObject("reviewSelectOne", getNo_p());
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String comment() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		if((session.getAttribute("no_m")==null||session.getAttribute("no_m")=="")==false){
			int no_m = (Integer) (session.getAttribute("no_m"));
		
			cClass = (MemberVO)sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		
		}
		commentList = (List<P_CommentImageVO>) sqlMapper.queryForList("commentSelectAll_image", getNo_p());
		
		totalComment = commentList.size();
		return SUCCESS;
	
	}

	public String deleteForm() throws Exception {
		return SUCCESS;
	}
	
	 public String cmtCheckPasswd() throws Exception {
		  // 세션에 넣어놓은 회원번호 값을 받아다가 저장
		  HttpServletRequest request = ServletActionContext.getRequest();

		  HttpSession session = request.getSession();
		  int no_m = (Integer) (session.getAttribute("no_m"));

		  // 세션에서 가져온 회원번호를 이용해 MemberVO를 가져옴
		  cClass = (MemberVO) sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		  
		  // getPassword() : 입력한 비밀번호
		  password = getPassword();

		  // 삭제하려는 코멘트 가져오기
		  commentClass2 = (P_CommentVO) sqlMapper.queryForObject("commentOne", getNo_c());

		  // 자신의 비밀번호와 입력한 비밀번호가 같으면 댓글삭제 함수로 넘어감
		  if ((cClass.getPassword()).equals(password)) {   
		   delete(commentClass2);
		  } else {
		   return "failed"; //to do
		  }

		  return SUCCESS;
		 }


	 @SuppressWarnings("unchecked")
	 public String delete(P_CommentVO commentClass2) throws Exception {
	  
	  // commentClass.setNo_c(getNo_c()); // 삭제되려는 글
	  int ref = commentClass2.getNo_c();

	  // 삭제되려는 글에 댓글들이 달려있을 때, 그 댓글들을 List로 가져옴
	  deleteList = sqlMapper.queryForList("commentSelectList", ref);

	  if(deleteList.size() == 1){
	   sqlMapper.delete("deleteComment", commentClass2);
	  } else {
	   commentClass2.setContent_c("[원본글이 삭제되었습니다]");
	   sqlMapper.update("updateCommentContent", commentClass2);
	  }
	  

	  return SUCCESS;
	 }
	
	public String favorite() throws Exception{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		System.out.println("no_m : " + no_m);
		System.out.println("no_p : " + getNo_p());
		
		FavoriteVO favoriteVO = new FavoriteVO();
		favoriteVO.setNo_m(no_m);
		favoriteVO.setFavorite_list(getNo_p());
		
		sqlMapper.insert("insert_product_favorite", favoriteVO);
		
		currentPage = getCurrentPage();
		return SUCCESS;
	}
	
	public String favoriteDel() throws Exception{
			
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		System.out.println("no_m : " + no_m);
		System.out.println("no_p : " + getNo_p());
		
		FavoriteVO favoriteVO = new FavoriteVO();
		favoriteVO.setNo_m(no_m);
		favoriteVO.setFavorite_list(getNo_p());
		
		sqlMapper.delete("delete_product_favorite", favoriteVO);
		
		currentPage = getCurrentPage();
		return SUCCESS;
	}


	public P_ImageVO getP_ImageVO() {
		return p_ImageVO;
	}

	public void setP_ImageVO(P_ImageVO p_ImageVO) {
		this.p_ImageVO = p_ImageVO;
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

	public int getNo_p() {
		return no_p;
	}

	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public LineVO getLineVO() {
		return lineVO;
	}

	public void setLineVO(LineVO lineVO) {
		this.lineVO = lineVO;
	}

	public List<LineVO> getLineList() {
		return lineList;
	}

	public void setLineList(List<LineVO> lineList) {
		this.lineList = lineList;
	}

	public FavoriteVO getFavoClass() {
		return favoClass;
	}

	public void setFavoClass(FavoriteVO favoClass) {
		this.favoClass = favoClass;
	}

	public ReviewVO getReviewVO() {
		return reviewVO;
	}

	public void setReviewVO(ReviewVO reviewVO) {
		this.reviewVO = reviewVO;
	}

	public int getNo_r() {
		return no_r;
	}

	public void setNo_r(int no_r) {
		this.no_r = no_r;
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

	public MemberVO getcClass() {
		return cClass;
	}

	public void setcClass(MemberVO cClass) {
		this.cClass = cClass;
	}

	public int getNo_c() {
		return no_c;
	}

	public void setNo_c(int no_c) {
		this.no_c = no_c;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent_c() {
		return content_c;
	}

	public void setContent_c(String content_c) {
		this.content_c = content_c;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}


	public List<P_CommentImageVO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<P_CommentImageVO> commentList) {
		this.commentList = commentList;
	}

	public List<P_CommentVO> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<P_CommentVO> deleteList) {
		this.deleteList = deleteList;
	}

	public int getMyLineStatus() {
		return myLineStatus;
	}

	public void setMyLineStatus(int myLineStatus) {
		this.myLineStatus = myLineStatus;
	}

	public int getTotalComment() {
		return totalComment;
	}

	public void setTotalComment(int totalComment) {
		this.totalComment = totalComment;
	}
	
	
	
}
