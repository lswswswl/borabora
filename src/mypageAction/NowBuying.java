package mypageAction;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import listAction.pagingAction;

import org.apache.struts2.ServletActionContext;

import vo.LineVO;
import vo.MemberVO;
import vo.P_ImageVO;
import vo.P_ListVO;
import vo.ProductVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class NowBuying extends ActionSupport {

	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private LineVO lineVO;
	private int buyers_products;
	private int no_p;

	private List<P_ListVO> buyerlist = new ArrayList<P_ListVO>(); // 구매가능 상품 리스트
	private List<LineVO> lineInfo = new ArrayList<LineVO>();
																	
	private ProductVO forSellerInfo = new ProductVO();
	private MemberVO sellerInfo = new MemberVO();
	private List<String> sellerString = new ArrayList<String>(); // 줄서기 표시

	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 12;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	private int num = 0;

	public NowBuying() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer) session.getAttribute("no_m");

		buyerlist = sqlMapper.queryForList("select_now_buying",
				"%" + Integer.toString(no_m) + "%");

		System.out.println(buyerlist.size());
		if (buyerlist.size() == 0) {
			buyers_products = 0;
		} else {
			buyers_products = buyerlist.size();
		}

		totalCount = buyerlist.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage,
				num, "");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		buyerlist = buyerlist.subList(page.getStartCount(), lastCount);

		// 줄서기 표시
		if (!buyerlist.isEmpty()) {

				for (int i = 0; i < buyerlist.size(); i++) {
					
					
					HashMap getMyLine = new HashMap();
					getMyLine.put("no_m", (String)(Integer.toString(no_m)));
					getMyLine.put("no_p", (buyerlist.get(i)).getNo_p());
					
					System.out.println("(String)(Integer.toString(no_m)) : "+(String)(Integer.toString(no_m)));
					System.out.println("getNo_p()"+getNo_p());
					lineVO = (LineVO) sqlMapper.queryForObject("select_one_line", getMyLine);

					forSellerInfo = (ProductVO) sqlMapper.queryForObject("select_one_pro", buyerlist.get(i).getNo_p());

					sellerInfo = (MemberVO) sqlMapper.queryForObject("select_mem_by_no_m", forSellerInfo.getSeller());
					
					String temp = new String();
					
		/*			lineInfo = sqlMapper.queryForList("line_in_order", buyerlist.get(i).getNo_p());*/
					
					if(lineVO==null){
						
						temp="";
						return SUCCESS;
						
					}else{
					
						if(lineVO.getLine_number()==1){
							if((sellerInfo.getNickname() == "" || sellerInfo.getNickname() == null)==false){
								temp +="판매자 @" + sellerInfo.getNickname() + "\n";
							}else{
								temp +="판매자 @" + sellerInfo.getEmail() + "\n";
							}
							temp += "연락처 " + sellerInfo.getPhone();
							sellerString.add(temp);
							
						}else{
							temp = "나의 줄번호는 "+lineVO.getLine_number()+"번 입니다.";
						}
					}
					
					sellerString.add(temp);
				}
			}
		return SUCCESS;
	}

	public LineVO getLineVO() {
		return lineVO;
	}

	public void setLineVO(LineVO lineVO) {
		this.lineVO = lineVO;
	}

	public int getBuyers_products() {
		return buyers_products;
	}

	public void setBuyers_products(int buyers_products) {
		this.buyers_products = buyers_products;
	}

	public List<P_ListVO> getBuyerlist() {
		return buyerlist;
	}

	public void setBuyerlist(List<P_ListVO> buyerlist) {
		this.buyerlist = buyerlist;
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

	public ProductVO getForSellerInfo() {
		return forSellerInfo;
	}

	public void setForSellerInfo(ProductVO forSellerInfo) {
		this.forSellerInfo = forSellerInfo;
	}

	public MemberVO getSellerInfo() {
		return sellerInfo;
	}

	public void setSellerInfo(MemberVO sellerInfo) {
		this.sellerInfo = sellerInfo;
	}

	public List<String> getSellerString() {
		return sellerString;
	}

	public void setSellerString(List<String> sellerString) {
		this.sellerString = sellerString;
	}

	public int getNo_p() {
		return no_p;
	}

	public void setNo_p(int no_p) {
		this.no_p = no_p;
	}
	
	

}
