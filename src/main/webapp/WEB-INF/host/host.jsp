<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Host Page</title>

<!-- <script src="http://code.jquery.com/jquery-1.9.1.js" type="text/javascript"></script> -->
<script src="http://code.highcharts.com/highcharts.js" type="text/javascript"></script>
<!-- <script src="http://code.highcharts.com/modules/exporting.js" type="text/javascript"></script> -->
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<c:url var="addAction" value="/host/add" ></c:url>
<!-- <table>
<tr>
<td><div id="container" style="width:48%; height:300px;"></div></td><td><div id="container1" style="width:48%; height:300px;"></div></td>
</tr>
</table> -->
<form:form action="${addAction}"   method="post" commandName="host" >
<table>
	<c:if test="${!empty host.hostName}">
	<tr>
		<td>
			<form:label path="hostId">
				<spring:message text="hostId"/>
			</form:label>
		</td>
		<td>
			<form:input path="hostId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="hostId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="hostName">
				Host Name
			</form:label>
		</td>
		<spring:bind path="hostName">
		<td>
			<form:input path="hostName" />
			<form:errors path="hostName" />
		</td> 
		</spring:bind>
	</tr>
	<tr>
		<td>
			<form:label path="hostDescription">
				Description
			</form:label>
		</td>
		<td>
			<form:input path="hostDescription" />
			<form:errors path="hostDescription" cssClass="error" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty host.hostId}">
				<input type="submit"
					value="<spring:message text="Edit Host"/>" />
			</c:if>
			<c:if test="${empty host.hostId}">
				<input type="submit"
					value="<spring:message text="Add Host"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Host List</h3>
<c:if test="${!empty listHost}">
	<table class="tg">
	<tr>
		<th width="80">Host ID</th>
		<th width="120">Host Name</th>
		<th width="120">Host Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listHost}" var="host">
		<tr>
			<td>${host.hostId}</td>
			<td>${host.hostName}</td>
			<td>${host.hostDescription}</td>
			<td><a href="<c:url value='/host/edit/${host.hostId}' />" >Edit</a></td>
			<td><a href="<c:url value='/host/remove/${host.hostId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


<script type="text/javascript">
$(function () {
	 $('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: 'Efficiency Optimization by Branch'
	        },
	        xAxis: {
	            categories: [
	                'Seattle HQ',
	                'San Francisco',
	                'Tokyo'
	            ]
	        },
	        yAxis: [{
	            min: 0,
	            title: {
	                text: 'Employees'
	            }
	        }, {
	            title: {
	                text: 'Profit (millions)'
	            },
	            opposite: true
	        }],
	        legend: {
	            shadow: false
	        },
	        tooltip: {
	            shared: true
	        },
	        plotOptions: {
	            column: {
	                grouping: false,
	                shadow: false,
	                borderWidth: 0
	            }
	        },
	        credits: {
	            enabled: false
	     },
	        series: [{
	            name: 'Employees',
	            color: 'rgba(165,170,217,1)',
	            data: [150, 73, 20],
	            pointPadding: 0.3,
	            pointPlacement: -0.2
	        }, {
	            name: 'Employees Optimized',
	            color: 'rgba(126,86,134,.9)',
	            data: [140, 90, 40],
	            pointPadding: 0.4,
	            pointPlacement: -0.2
	        }, {
	            name: 'Profit',
	            color: 'rgba(248,161,63,1)',
	            data: [183.6, 178.8, 198.5],
	            tooltip: {
	                valuePrefix: '$',
	                valueSuffix: ' M'
	            },
	            pointPadding: 0.3,
	            pointPlacement: 0.2,
	            yAxis: 1
	        }, {
	            name: 'Profit Optimized',
	            color: 'rgba(186,60,61,.9)',
	            data: [203.6, 198.8, 208.5],
	            tooltip: {
	                valuePrefix: '$',
	                valueSuffix: ' M'
	            },
	            pointPadding: 0.4,
	            pointPlacement: 0.2,
	            yAxis: 1
	        }]
	    });
	$('#container1').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: 'Monthly Average Temperature'
        },
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            }
        },
        credits: {
            enabled: false
     },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            name: 'Tokyo',
            data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }, {
            name: 'London',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
    });
});
</script>
</body>
</html>
