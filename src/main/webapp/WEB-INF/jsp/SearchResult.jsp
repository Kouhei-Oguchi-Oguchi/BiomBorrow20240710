<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MedicalEquipment"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.util.Optional"%>
<%
MedicalEquipment medicalEquipmentValue = (MedicalEquipment) session.getAttribute("medicalEquipmentValue");
%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/SearchResult.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
<script src="${pageContext.request.contextPath}/js/menu.js" defer></script>
<meta charset="UTF-8">
<title>SearchResult</title>
</head>
<body>
	<h1>機器情報</h1>
	<div class="container">
		<div class="info">
			<p>
				<%
				Optional<LocalDateTime> optionalIntroducedDate = medicalEquipmentValue.getIntroducedDate();
				Optional<LocalDateTime> optionalBorrowDate = medicalEquipmentValue.getBorrowDate();
				Optional<LocalDateTime> optionalReturnDate = medicalEquipmentValue.getReturnDate();
				LocalDateTime introducedDate;
				LocalDateTime borrowDate = null;
				LocalDateTime returnDate = null;
				introducedDate = optionalIntroducedDate.get();
				if (optionalBorrowDate.isPresent()) {
					borrowDate = optionalBorrowDate.get();
				}
				if (optionalReturnDate.isPresent()) {
					returnDate = optionalReturnDate.get();
				}
				String introducedDateString;
				String borrowDateString;
				String returnDateString;
				if (borrowDate == null) {
					borrowDateString = "不明";
				} else {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					borrowDateString = borrowDate.format(formatter);
				}
				if (returnDate == null) {
					returnDateString = "貸出中";
				} else {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					returnDateString = returnDate.format(formatter);
				}
				if (borrowDate == null && returnDate == null) {
					borrowDateString = "不明";
					returnDateString = "不明";
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				introducedDateString = introducedDate.format(formatter);
				%>

				<span class="info-label">MENO:</span>
				<%=medicalEquipmentValue.getMedicalEquipmen()%><br> <span
					class="info-label">型式:</span>
				<%=medicalEquipmentValue.getModelNumber()%><br> <span
					class="info-label">S/N:</span>
				<%=medicalEquipmentValue.getSerialNumber()%><br> <span
					class="info-label">製造会社:</span>
				<%=medicalEquipmentValue.getManufacturer()%><br> <span
					class="info-label">導入日:</span>
				<%=introducedDateString%><br> <span class="info-label">貸出日:</span>
				<%=borrowDateString%><br> <span class="info-label">返却日:</span><%=returnDateString%><br>
				<span class="info-label">現在地:</span>
				<%=medicalEquipmentValue.getPlace()%><br>
			</p>
		</div>
		<img src="<%=session.getAttribute("imageFileName")%>"
			alt="Medical Equipment Image">
	</div>
	<nav>
		<button id="menu-open" class="btn-menu">
			<svg height="24" viewBox="0 0 24 24" width="24"
				xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd"
					d="m4.25 8c0-.41421.33579-.75.75-.75h14c.4142 0 .75.33579.75.75s-.3358.75-.75.75h-14c-.41421 0-.75-.33579-.75-.75zm0 4c0-.4142.33579-.75.75-.75h14c.4142 0 .75.3358.75.75s-.3358.75-.75.75h-14c-.41421 0-.75-.3358-.75-.75zm.75 3.25c-.41421 0-.75.3358-.75.75s.33579.75.75.75h14c.4142 0 .75-.3358.75-.75s-.3358-.75-.75-.75z"
					fill-rule="evenodd" />
        </svg>
		</button>
		<div id="menu-panel">
			<button id="menu-close" class="btn-menu">
				<svg height="24" viewBox="0 0 24 24" width="24"
					xmlns="http://www.w3.org/2000/svg">
                <path clip-rule="evenodd"
						d="m7.53033 6.46967c-.29289-.29289-.76777-.29289-1.06066 0s-.29289.76777 0 1.06066l4.46963 4.46967-4.46963 4.4697c-.29289.2929-.29289.7677 0 1.0606s.76777.2929 1.06066 0l4.46967-4.4696 4.4697 4.4696c.2929.2929.7677.2929 1.0606 0s.2929-.7677 0-1.0606l-4.4696-4.4697 4.4696-4.46967c.2929-.29289.2929-.76777 0-1.06066s-.7677-.29289-1.0606 0l-4.4697 4.46963z"
						fill-rule="evenodd" />
            </svg>
			</button>
			<ul class="menu-list">
				<li><a href="WelcomeBiomBorrowServlet">BiomBorrow</a></li>
				<li><a href="BorrowStartServlet">Borrow</a></li>
				<li><a href="ReturnStartServlet">Return</a></li>
			</ul>
		</div>
	</nav>

</body>
</html>













