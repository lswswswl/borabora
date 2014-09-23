package productAction;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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

public class P_Delete extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private ProductVO productVO;
	private P_ImageVO p_ImageVO;
	private MemberVO memberVO;

	private int no_p;
	private String password;
	
	public P_Delete() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	
	public String execute() throws Exception {
		// 세션에 넣어놓은 회원번호 값을 받아다가 저장
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer) (session.getAttribute("no_m"));
		
		// 세션에서 가져온 회원번호를 이용해 MemberVO를 가져옴
		memberVO = new MemberVO();
		memberVO = (MemberVO) sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		
		// 삭제하려는 제품
		productVO = new ProductVO();
		p_ImageVO = new P_ImageVO();
		productVO = (ProductVO) sqlMapper.queryForObject("select_one_pro", getNo_p());
		p_ImageVO = (P_ImageVO) sqlMapper.queryForObject("select_one_img", getNo_p());
		
		// getPassword() : 입력한 비밀번호
		password = getPassword();		
		if((memberVO.getPassword()).equals(password)) {
			delete(productVO, p_ImageVO);
		} else {
			System.out.println("different password!");
			return ERROR;
		}
		
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	public String delete(ProductVO productVO, P_ImageVO p_ImageVO) throws Exception {
		
		sqlMapper.delete("deleteProduct", productVO);
		sqlMapper.delete("deleteImage", p_ImageVO);
		
		return SUCCESS;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	public P_ImageVO getP_ImageVO() {
		return p_ImageVO;
	}

	public void setP_ImageVO(P_ImageVO p_ImageVO) {
		this.p_ImageVO = p_ImageVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public int getNo_p() {
		return no_p;
	}

	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
