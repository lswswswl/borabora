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

public class Login extends ActionSupport {

	// sql reader
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO resultClass = new MemberVO();

	private String email;
	private String password;
	
	public Login() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		
		email = getEmail();
		password = getPassword();

		resultClass = (MemberVO) sqlMapper.queryForObject("select_mem_by_email", email);

		if(resultClass.getPassword().equals(password)){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("logined", true);
			session.setAttribute("no_m", new Integer(resultClass.getNo_m()));
			if(resultClass.getNickname()==null){
				session.setAttribute("nickname", resultClass.getEmail());
			}else{
				
				session.setAttribute("nickname", resultClass.getNickname());				
			}
			
			return SUCCESS;
		}else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("logined", false);
		}
		
		return "failed";
	}
	
	public String logout() throws Exception {
 
		Map session = ActionContext.getContext().getSession();
		session.remove("logined");
		session.remove("no_m");
		return SUCCESS;
  }

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}