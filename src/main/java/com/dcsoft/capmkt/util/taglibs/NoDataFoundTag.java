package com.dcsoft.capmkt.util.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class NoDataFoundTag extends TagSupport {
	
	private static final long serialVersionUID = -5939653792048523517L;
		
	@Override
	public int doStartTag() throws JspException {
		try {
		
			StringBuffer sbOut = new StringBuffer();
			sbOut.append("<table class='tg'><thead><tr><th>Result</th></tr><tbody><tr><td align=\"center\">No Data Found</td></tr></tbody></table>");
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
