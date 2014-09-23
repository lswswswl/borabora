package listAction;

public class pagingAction {
	
	private int currentPage;
	private int totalCount;
	private int totalPage;
	private int blockCount;
	private int blockPage;
	private int startCount;
	private int endCount;
	private int startPage;
	private int endPage;
	
	private StringBuffer pagingHtml;
	
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage, int searchNum, String isSearch)
	{
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if(totalPage == 0)
		{
			totalPage = 1;
		}
		
		if(currentPage > totalPage)
		{
			currentPage = totalPage;
		}
		
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount-1;
		
		startPage = (int)((currentPage - 1)/blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;
		
		if(endPage > totalPage)
		{
			endPage = totalPage;
		}
		
		
		pagingHtml = new StringBuffer();
	   	pagingHtml.append("<div class='text-center'><ul class='pagination'>");
		if(currentPage > blockPage)
		{
			
			if(isSearch != "")
				pagingHtml.append("<li><a href=categoryList.action?currentPage=" + (startPage - 1) + "&searchKeyword="+isSearch+"&searchNum="+searchNum+">");
			else
			pagingHtml.append("<li><a href=categoryList.action?currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("<<");
			pagingHtml.append("</a></li>");
		}
		
		
		for(int i = startPage;i<=endPage;i++)
		{
			if(i > totalPage)
			{
				break;
			}
			if(i == currentPage)
			{
				pagingHtml.append("<li class='active'><a>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			}
			else
			{
				pagingHtml.append("<li><a href='categoryList.action?currentPage=");
				pagingHtml.append(i);
				if(isSearch != "")
					pagingHtml.append("&searchKeyword="+isSearch);
				pagingHtml.append("'>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			}
		}
		
		if(totalPage - startPage >= blockPage)
		{
			pagingHtml.append("<li><a href='categoryList.action?currentPage=");
			pagingHtml.append((endPage+1));
			if(isSearch != "")
				pagingHtml.append("&searchKeyword="+isSearch);
			pagingHtml.append("'>");
			pagingHtml.append(">>");
			pagingHtml.append("</a><li>");
		}
	   	pagingHtml.append("</ul></div>");
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(StringBuffer pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	
	

}
