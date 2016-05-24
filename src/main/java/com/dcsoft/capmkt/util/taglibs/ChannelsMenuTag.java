/**
 * 
 */
package com.dcsoft.capmkt.util.taglibs;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.dcsoft.capmkt.constants.Constants;
import com.dcsoft.capmkt.orm.ChUser;

/**
 * @author Deep
 * This tag is responsible for creating the menu for user based on the fap assigned 
 *
 */
public class ChannelsMenuTag extends TagSupport {

	private static final long serialVersionUID = 4849465170159707320L;
	
	@Override
	public int doStartTag() throws JspException {
		HttpSession session = pageContext.getSession();
		/*String userID = ((ChUser) session.getAttribute(Constants.USER_TOKEN)).getUname();*/
		/*<spring:message code="label.menu.home"/>*/
		StringBuffer sbOut = new StringBuffer(/*"UserID : " + userID*/ );
		sbOut.append("<spring:message code='label.menu.home'/>");
		try {
			pageContext.getOut().append(sbOut.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

}
