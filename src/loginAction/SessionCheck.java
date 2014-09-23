package loginAction;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class SessionCheck extends ActionSupport {

	boolean login;
	String headerResult;
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	public SessionCheck() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		
		if (session.getAttribute("no_m") != null) {
			login = true;
		} else {
			login = false;
		}

		if (login == true) {
			headerResult = "/header_on.jsp";
		} else {
			headerResult = "/header_off.jsp";
		}
		
	}

	public String execute() throws Exception {

		return SUCCESS;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getHeaderResult() {
		return headerResult;
	}

	public void setHeaderResult(String headerResult) {
		this.headerResult = headerResult;
	}

}	
