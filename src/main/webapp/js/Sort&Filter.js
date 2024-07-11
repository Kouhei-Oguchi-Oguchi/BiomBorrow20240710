document.getElementById('sortButton').addEventListener('click',() => {
const placeCells = document.querySelectorAll('.place');
const placeArray = Array.from(placeCells);
const sortPlaceArray = placeArray.sort((a, b) => a.textContent.localeCompare(b.textContent, 'ja'));
const tableBody = document.querySelector('table').getElementsByTagName('tbody')[0];
sortPlaceArray.forEach(cell => {
	const row = cell.parentNode;
	tableBody.appendChild(row);
})
})

