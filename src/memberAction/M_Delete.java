package memberAction;

import java.io.Reader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vo.MemberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class M_Delete extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO memberVO;
	
	public String execute() throws Exception {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int no_m = (Integer)(session.getAttribute("no_m"));
		
		memberVO = new MemberVO();
		
		memberVO = (MemberVO)sqlMapper.queryForObject("select_mem_by_no_m", no_m);
		sqlMapper.delete("delete_member", memberVO);
		session.removeValue("logined");
		session.removeValue("no_m");
		
		return SUCCESS;
	}

}
