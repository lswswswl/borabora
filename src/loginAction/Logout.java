package loginAction;


import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vo.MemberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport {

	// sql reader
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	public Logout() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		session.remove("logined");
		session.remove("no_m");
		return SUCCESS;

	}	

}