package mypageAction;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import listAction.pagingAction;

import org.apache.struts2.ServletActionContext;

import vo.LineVO;
import vo.P_ImageVO;
import vo.P_ListVO;
import vo.ProductVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class NowSelling extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private LineVO lineVO;
	private int my_products; //�� ��ǰ ����
	private int no_m;
	
	private List<P_ListVO> list = new ArrayList<P_ListVO>(); 
	private List<LineVO> lineInfo = new ArrayList<LineVO>();
	private List<String> buyersString = new ArrayList<String>(); //줄서기 표시

	
	private int currentPage=1;
	private int totalCount;
	private int blockCount = 12;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	private int num = 0;

	
	public NowSelling() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		list = sqlMapper.queryForList("select_my_products", no_m); 
		//��ü ��ǰ�� �ش� �Ǹ����� ��ǰ����Ʈ ����
		System.out.println(list.size());
		if(list.size()==0){
			my_products = 0;
		}else{
			my_products = list.size();
		}
		
		totalCount = list.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list = list.subList(page.getStartCount(), lastCount);
		System.out.println(list);
		
		//줄서기 표시
		if(!list.isEmpty()){
			
			for(int i = 0; i < list.size(); i++){
				
				lineInfo = sqlMapper.queryForList("line_in_order", list.get(i).getNo_p());
/*				System.out.println("list.get(i).getNo_p : "+list.get(i).getNo_p()+ ", i : "+ i + " , lineInfo.size() : "+ lineInfo.size());
*/				
				String temp = new String();
				
				
				if(lineInfo.size() != 0){
					temp += "구매 대기자가 "+lineInfo.size()+"명 있습니다.\n";
					for(int j = 0; j < lineInfo.size(); j++){
						
						temp += lineInfo.get(j).getLine_number() + ".@"
								+ lineInfo.get(j).getBuyers_nickname() + " "
								+ lineInfo.get(j).getBuyers_phone()
								+ "\n";
					}
					temp = temp.substring(0, temp.lastIndexOf('\n'));
					
				} else {
					temp += "아직 구매자가 없습니다.";
				}
				buyersString.add(temp);
			}
		}
		//줄서기 표시


		return SUCCESS;
	}

	public LineVO getLineVO() {
		return lineVO;
	}

	public void setLineVO(LineVO lineVO) {
		this.lineVO = lineVO;
	}

	public int getMy_products() {
		return my_products;
	}

	public void setMy_products(int my_products) {
		this.my_products = my_products;
	}

	public int getNo_m() {
		return no_m;
	}

	public void setNo_m(int no_m) {
		this.no_m = no_m;
	}

	public List<P_ListVO> getList() {
		return list;
	}

	public void setList(List<P_ListVO> list) {
		this.list = list;
	}

	public List<LineVO> getLineInfo() {
		return lineInfo;
	}

	public void setLineInfo(List<LineVO> lineInfo) {
		this.lineInfo = lineInfo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public pagingAction getPage() {
		return page;
	}

	public void setPage(pagingAction page) {
		this.page = page;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<String> getBuyersString() {
		return buyersString;
	}

	public void setBuyersString(List<String> buyersString) {
		this.buyersString = buyersString;
	}

	
	
}
