<%@page import="org.springframework.security.core.context.SecurityContextHolder"%><%@page import="org.springframework.security.core.userdetails.User"%>
<div align="right" style="margin-right: 10px;" >
Welcome&nbsp;<%=((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername().toUpperCase() %>
&nbsp;|&nbsp;
<a href="javascript:logout()" > Logout</a>
</div>