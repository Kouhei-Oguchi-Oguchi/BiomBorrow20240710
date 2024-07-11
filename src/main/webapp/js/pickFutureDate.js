const row = document.queryselector('#row<%=meNO%>')
const borrowDate = document.queryselector(`#borrowDate`)
const returnDate = document.querySelector(`#returnDate`)
const now = new Date();
const threeMonthAge = now.getMonth() +4;


if(retunDate == null && (borrowDate.getMonth < threeMonthAge)){

 const keyframes = {
	color: ['R0G0B0', 'R0G0B0'],
	backgroudcolor: ['#c83e36','#F7F8FA'],
	opacity: [0,1]
	};
 const options = {
	duration:1000,
	easing :linera,
	iteration :Infinity
}
row.animete(keyframes, options)

}//retunDateがnullでborrowDateが現時刻より3か月ごの場合、文字が赤く点