package listAction;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import vo.P_ListVO;

import listAction.pagingAction;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryList extends ActionSupport{

	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private List<P_ListVO> list = new ArrayList<P_ListVO>();
	
	private String searchKeyword;
	private int searchNum;
	
	private int currentPage=1;
	private int totalCount;
	private int blockCount = 12;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	private int num = 0;
	
	//mainList
	private List<P_ListVO> blist = new ArrayList<P_ListVO>();
	private List<P_ListVO> nlist = new ArrayList<P_ListVO>();
	//mainList
	
	//mainList
	private List<P_ListVO> blist2 = new ArrayList<P_ListVO>();
	private List<P_ListVO> nlist2 = new ArrayList<P_ListVO>();
	//mainList


	public CategoryList() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();		
		
	}
	
	public String execute() throws Exception {
		
		if(getSearchKeyword() != null)
		{
			return search();
		}
		
		
		list = sqlMapper.queryForList("select_for_list");
		
		totalCount = list.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list = list.subList(page.getStartCount(), lastCount);
		System.out.println(list);
		
		return SUCCESS;
	}
	
	public String search() throws Exception {
		
		//searchKeyword = new String(searchKeyword.getBytes("iso-8859-1"),"euc-kr") ;
		System.out.println(searchKeyword);
		System.out.println(searchNum);
		
		if(searchNum == 0){
			list = sqlMapper.queryForList("selectSearchS", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 1){
			list = sqlMapper.queryForList("selectSearchT", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 2){
			list = sqlMapper.queryForList("selectSearchC", "%"+getSearchKeyword()+"%");
		}
		
		totalCount = list.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	//mainList
	public String mainList() throws Exception{
		
		blist = sqlMapper.queryForList("select_best_product");
		nlist = sqlMapper.queryForList("select_new_product");
		
		mainList2();
		
		return SUCCESS;
	}
	//mainList
	
	public String mainList2() throws Exception{
		
		blist2 = sqlMapper.queryForList("select_best_product2");
		nlist2 = sqlMapper.queryForList("select_new_product2");
		
		return SUCCESS;
	}


	public List<P_ListVO> getList() {
		return list;
	}

	public void setList(List<P_ListVO> list) {
		this.list = list;
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
	
	
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public List<P_ListVO> getBlist() {
		return blist;
	}

	public void setBlist(List<P_ListVO> blist) {
		this.blist = blist;
	}

	public List<P_ListVO> getNlist() {
		return nlist;
	}

	public void setNlist(List<P_ListVO> nlist) {
		this.nlist = nlist;
	}

	public List<P_ListVO> getBlist2() {
		return blist2;
	}

	public void setBlist2(List<P_ListVO> blist2) {
		this.blist2 = blist2;
	}

	public List<P_ListVO> getNlist2() {
		return nlist2;
	}

	public void setNlist2(List<P_ListVO> nlist2) {
		this.nlist2 = nlist2;
	}
	
	

}

