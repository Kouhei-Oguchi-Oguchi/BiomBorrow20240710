<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="model.MedicalEquipment"%>
<%
ArrayList<MedicalEquipment> equipments = (ArrayList<MedicalEquipment>) session.getAttribute("equipments");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>UsageStatus</title>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/chartist.js/latest/chartist.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/UsageStatus.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
<script src="${pageContext.request.contextPath}/js/menu.js" defer></script>
<script src="js/pickFutureDate.js" defer></script>
</head>
<body>
	<div class="main-container">
	<h1>使用状況</h1>
		<table border="1">
		<thead>
			<tr>
				<th>MENO</th>
				<th>場所 <button id="sortButton">昇順</button> <button id="originalButton">戻す</button></th>
				<th>貸出日</th>
				<th>返却日</th>
				<th>型番</th>
				<th>シリアル</th>
				<th>製造会社</th>
				<th>機器名</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (equipments != null) {
				for (MedicalEquipment equipment : equipments) {
					int meNO = equipment.getMedicalEquipmentValue();
					String place = equipment.getPlaceNameValue();
					LocalDateTime borrowDate = equipment.getBorrowDateValue();
					LocalDateTime returnDate = equipment.getReturnDateValue();
					String modelNumber = equipment.getModelNumberValue();
					String serialNumber = equipment.getSerialNumberValue();
					String manufacturer = equipment.getManufacturerValue();
					String deviceName = equipment.getDeviceName();
			%>
			<tr id="row<%=meNO%>">
				<td><%=meNO%></td>
				<td class="place"><%=place%></td>
				<td id="borrowDate"><%=borrowDate != null ? borrowDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "不明"%></td>
				<td id="returnDate"><%=returnDate != null ? returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "貸出中"%></td>
				<td><%=modelNumber%></td>
				<td><%=serialNumber%></td>
				<td><%=manufacturer%></td>
				<td><%=deviceName%></td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
		</table>
	  <div class="graph-container">
		<div class="chart-box">
		 <canvas id="myPieChart"></canvas>
		 </div>
	   </div>
	</div>
	<nav>
		<button id="menu-open" class="btn-menu">
			<svg height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
				<path clip-rule="evenodd"
					d="m4.25 8c0-.41421.33579-.75.75-.75s.3358.75.75.75h-14c-.4142 0-.75-.33579-.75-.75zm0 4c0-.4142.33579-.75.75-.75h14c.4142 0 .75.3358.75.75s-.3358.75-.75.75h-14c-.41421 0-.75-.3358-.75-.75zm.75 3.25c-.41421 0-.75.3358-.75.75s.33579.75.75.75h14c.4142 0 .75-.3358.75-.75s-.3358-.75-.75-.75z"
					fill-rule="evenodd" />
			</svg>
		</button>
		<div id="menu-panel">
			<button id="menu-close" class="btn-menu">
				<svg height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
					<path clip-rule="evenodd"
						d="m7.53033 6.46967c-.29289-.29289-.76777-.29289-1.06066 0s-.29289.76777 0 1.06066l4.46963 4.46967-4.46963 4.4697c-.29289.2929-.29289.7677 0 1.0606s.76777.2929 1.06066 0l4.46967-4.4696 4.4697 4.4696c.2929.2929.7677.2929 1.0606 0s.2929-.7677 0-1.0606l-4.4696-4.4697 4.4696-4.46967c.2929-.29289.2929-.76777 0-1.06066s-.7677-.29289-1.0606 0l-4.4697 4.46963z"
						fill-rule="evenodd" />
			</button>
			<ul class="menu-list">
				<li><a href="WelcomeBiomBorrowServlet">BiomBorrow</a></li>
				<li><a href="BorrowStartServlet">Borrow</a></li>
				<li><a href="ReturnStartServlet">Return</a></li>
			</ul>
		</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@0.7.0"></script>
<script src="js/graph.js"></script>
<script src="js/Sort&Filter.js"></script>
</body>
</html>