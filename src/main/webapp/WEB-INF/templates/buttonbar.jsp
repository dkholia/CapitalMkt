<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table class="table">
	<tr>
		<td colspan="6" align="right">
			<button type="submit" class="btn btn-primary btn-large center"
				value="Submit" onclick="javascript:showWaitScreen('mainform');">
				<spring:message code="label.submit" />
			</button>
			<button class="btn  btn-large center" type="reset" onclick="">
				<spring:message code="label.reset" />
			</button>
		</td>
	</tr>
</table>
