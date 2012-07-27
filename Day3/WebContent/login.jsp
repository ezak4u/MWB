
<%
	String userName = request.getParameter("username");
	String password = request.getParameter("password");
	String output = "{\"authentication\" : \"Failure\"}";
	output = "{\"authentication\" : \"Success\",\"countries\":[\"India\",\"USA\",\"UK\"]}";
	if ("admin".equalsIgnoreCase(userName) && "admin".equals(password)) {
		output = "{\"authentication\" : \"Success\",\"countries\":[\"India\",\"USA\",\"UK\"]}";
		out.print(output);
	} else
		out.print(output);
%>
