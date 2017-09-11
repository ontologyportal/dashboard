<!-- This code is copyright Infosys Ltd 2017. -->
<!DOCTYPE html>
<Html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.bundle.js">
</script>
<style>
.chart-container {
	position: relative;
	height: 50vh;
	width: 50vw;
}
</style>
</head>
<Body>
	<%	
		out.write("<h1>" + "Short Answer Performance Dashboard" + "</h1>");
		int numGraphs = (int) request.getAttribute("numCharts");
		java.util.List<String> chartNames = (java.util.List<String>) request.getAttribute("chartNames");
		for (int i = 0; i < numGraphs; i++) {
			out.write("<h2>" + chartNames.get(i) + "</h2>");
			out.write("<div class=\"chart-container\">");
			out.write("<canvas id=\"myChart" + i + "\"></canvas>");
			out.write("</div>");
		}
	%>
</Body>
<script>
	var num = ${numCharts};
	var charts = ${charts};
	for (var i = 0; i < num; i++) {
		var ctx = document.getElementById("myChart" + i);
		var myChart = new Chart(ctx, charts[i]);
	}
</script>
</html>