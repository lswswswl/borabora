package productAction;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import vo.LineVO;
import vo.MemberVO;
import vo.P_ListVO;
import vo.ProductVO;
import vo.P_ImageVO;

public class P_Status extends ActionSupport{	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private StringBuffer line; //DB�� line_list�� �б� ���� ���� StringBuffer ��ü
	private ProductVO lineInfo; //line_list �÷� ���� �������� �����ϴ� ��ü
	private LineVO lineVO; //for_line DB table�� ä�� ��ü
	private MemberVO memberVO; 
	private List<LineVO> oldLineList; 
	private List<LineVO> lineList; 
	private int lineCount; //��ü �� ����
	private int line_number; //�� �ټ��� ��ġ
	private String[] lineArray;
	
	private ProductVO resultClass; //������Ʈ ��ް�ü
	private P_ImageVO p_ImageVO;
	
	private int status_p;
	private int no_p;
	
	private int currentPage;
	
	private StringBuffer redirectURI;
	private String detailURI;

	public P_Status() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		resultClass = new ProductVO(); //������Ʈ ��� ��ü
		p_ImageVO = new P_ImageVO();
		
		resultClass.setStatus_p(1); //1�� ��������
		resultClass.setNo_p(getNo_p()); //no_p�� �޾Ƽ� ���������� �Ķ���ͷ� ���
		
		line = new StringBuffer();
		 
		lineInfo = new ProductVO(); // DB���� �����ϴ� line_list���� �����ٰ� append��Ŵ.
		
		lineInfo = (ProductVO) sqlMapper.queryForObject("select_one_pro", getNo_p());
		System.out.println("lineInfo.getLine_list() =" +lineInfo.getLine_list());
		
		if(lineInfo.getLine_list()==null || lineInfo.getLine_list().equals("")){
			lineInfo.setLine_list("");
		}
		
		line.append(lineInfo.getLine_list());
		line.append(no_m+",");
		
		resultClass.setLine_list(line.toString()); // ������Ʈ ��ü�� line_list ����
		sqlMapper.update("statusTo1", resultClass); // DB�� status_p�� �ٲ��� 1��.

		resultClass = (ProductVO) sqlMapper.queryForObject("select_one_pro", getNo_p());
		p_ImageVO = (P_ImageVO) sqlMapper.queryForObject("select_one_img", getNo_p());
		System.out.println(sqlMapper.toString());
		
		lineVO = new LineVO();
		memberVO = new MemberVO();
		
		memberVO = (MemberVO) sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		
		
		lineList = new ArrayList<LineVO>();
		
		oldLineList = new ArrayList<LineVO>();
		oldLineList = sqlMapper.queryForList("line_in_order", getNo_p()); //���� ������ ����Ʈ

		lineVO.setNo_p(getNo_p());
		lineVO.setBuyers(no_m);
		
		if((memberVO.getNickname() == "" || memberVO.getNickname() == null)==false){
			lineVO.setBuyers_nickname(memberVO.getNickname());
		}else{
			lineVO.setBuyers_nickname(memberVO.getEmail());
		}
		lineVO.setBuyers_phone(memberVO.getPhone());
		
		if(oldLineList.size()==0){
			lineVO.setLine_number(1);
		}else{
			lineVO.setLine_number(oldLineList.size()+1);
		}
		
		sqlMapper.insert("insert_into_line", lineVO); //for_line DB ���̺? ������
		lineList = sqlMapper.queryForList("line_in_order", getNo_p()); //���� ������ ����Ʈ
		
		
/*		리프레쉬 시 계속된 action의 실행 때문에 시도했으나 되지 않았다.....ㅠ */
/*		currentPage = getCurrentPage();
		detailURI = "/borabora/productRead.action?currentPage="+currentPage+"&no_p="+getNo_p(); 
		System.out.println(detailURI);
*/
		
/*		//안됨. html로 그냥 찍힘 
		redirectURI = new StringBuffer();
		redirectURI.append("<%response.sendRedirect(\"");
	   	redirectURI.append(detailURI);
	   	redirectURI.append("\"); %>");
	   	System.out.println(redirectURI);
		*/
		
		currentPage = getCurrentPage();
		
		return SUCCESS;
		
	}

	
	public String to2() throws Exception {
		//���ſϷ��� , �� �Ǹ��ڰ� �ǸſϷ� ��������
		return SUCCESS;
	}
	
	public String to3() throws Exception {
		//�ǸſϷ�, �� �����ڰ� ���ſϷ� ������ �� 
		return SUCCESS;
	}
	
	public String updateline() throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		lineVO = new LineVO();
		
		HashMap deleteKey = new HashMap();
		deleteKey.put("no_m", no_m);
		deleteKey.put("no_p", getNo_p());
		
		lineVO = (LineVO) sqlMapper.queryForObject("select_one_line", deleteKey); 
		
		if(lineVO.getLine_number()!=0){
			int check = sqlMapper.delete("delete_line",no_m);
			if(check == 1){
				sqlMapper.update("update_line", lineVO.getLine_number());
			}
		}
		
		lineList = new ArrayList<LineVO>();
		lineList = sqlMapper.queryForList("line_in_order", getNo_p());
		
		if(lineList.size()==0){
			resultClass = new ProductVO();
			resultClass.setNo_p(getNo_p()); //no_p�� �޾Ƽ� ���������� �Ķ���ͷ� ���
			resultClass.setStatus_p(0);
			sqlMapper.update("statusTo1", resultClass);
		}
		currentPage = getCurrentPage();
		
		return SUCCESS;
	}
	

	public StringBuffer getLine() {
		return line;
	}

	public void setLine(StringBuffer line) {
		this.line = line;
	}

	public ProductVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(ProductVO resultClass) {
		this.resultClass = resultClass;
	}

	public P_ImageVO getP_ImageVO() {
		return p_ImageVO;
	}

	public void setP_ImageVO(P_ImageVO p_ImageVO) {
		this.p_ImageVO = p_ImageVO;
	}

	public int getStatus_p() {
		return status_p;
	}

	public void setStatus_p(int status_p) {
		this.status_p = status_p;
	}

	public int getNo_p() {
		return no_p;
	}

	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}

	public ProductVO getLineInfo() {
		return lineInfo;
	}

	public void setLineInfo(ProductVO lineInfo) {
		this.lineInfo = lineInfo;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getLine_number() {
		return line_number;
	}

	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}

	public String[] getLineArray() {
		return lineArray;
	}

	public void setLineArray(String[] lineArray) {
		this.lineArray = lineArray;
	}

	public LineVO getLineVO() {
		return lineVO;
	}

	public void setLineVO(LineVO lineVO) {
		this.lineVO = lineVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public List<LineVO> getOldLineList() {
		return oldLineList;
	}

	public void setOldLineList(List<LineVO> oldLineList) {
		this.oldLineList = oldLineList;
	}

	public List<LineVO> getLineList() {
		return lineList;
	}

	public void setLineList(List<LineVO> lineList) {
		this.lineList = lineList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
/*
	public String getDetailURI() {
		return detailURI;
	}

	public void setDetailURI(String detailURI) {
		this.detailURI = detailURI;
	}

	public StringBuffer getRedirectURI() {
		return redirectURI;
	}

	public void setRedirectURI(StringBuffer redirectURI) {
		this.redirectURI = redirectURI;
	}
	
	*/

}
