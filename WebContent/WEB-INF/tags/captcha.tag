<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<img src="<c:url value="/captcha" />">
<br />
<input type="text" name="captchaResponse" />