<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="subnavi hidden">
	<div class="entry">
		<spring:url value="/login" var="loginUrl" />
		
		<sec:authorize access="isAnonymous()">
			<form action="${loginUrl}" method="post" accept-charset="utf-8">
				<label for="name">Name</label>
				<input class="textinput" type="text" name="username" value="" id="name"> 
				<label for="passwort">Passwort</label>
				<input class="textinput" type="text" name="password" value="" id="passwort">
				<input class="button" type="submit" value="Submit">
				<div class="clear"></div>
			</form>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
			<div>Welcome <sec:authentication property="principal.displayName" /></div>
			<spring:url value="/logout" var="logoutUrl" />
			<a href="${logoutUrl}">logout</a>
		</sec:authorize>

	</div>
	<hr />
	<div class="entry">
		<h5>Terms of Use</h5>
		<p>Blues Booze And Babes, all day, all year!</p>
	</div>
</div>