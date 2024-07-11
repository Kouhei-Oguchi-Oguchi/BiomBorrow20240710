const placeCells = document.querySelectorAll('.place');

const extractText = cell => cell.textContent.trim();

const placesArray = Array.from(placeCells, extractText);

const departmentCounts = {
   unit3EDept: 0,
   unit3WDept: 0,
   unit2EDept: 0,
   unit2WDept: 0,
   unit4SDept: 0,
   unit3SDept: 0,
   unit2SDept: 0,
   unit1SDept: 0,
   unitNS1Dept: 0,
   unitRehabilitationDept: 0,
   unitME: 0,
};
const dapartmentLabels = {
   unit3EDept: "本館3階東",
   unit3WDept: "本館3階西",
   unit2EDept: "介護医療院（2E)",
   unit2WDept: "本館2階西",
   unit4SDept: "南館4階",
   unit3SDept: "南館3階",
   unit2SDept: "南館2階",
   unit1SDept: "南館1階",
   unitNS1Dept: "南新館",
   unitRehabilitationDept: "リハビリ",
   unitME: "ME",
}


placesArray.forEach(place => {
    switch(place) {
        case "本館3階東":
            departmentCounts.unit3EDept++;
            break;
        case "本館3階西":
            departmentCounts.unit3WDept++;
            break;
        case "介護医療院":
            departmentCounts.unit2EDept++;
            break;
        case "本館2階西病棟":
            departmentCounts.unit2WDept++;
            break;
        case "南館4階病棟":
            departmentCounts.unit4SDept++;
            break;
        case "南館3階病棟":
            departmentCounts.unit3SDept++;
            break;
        case "南館2階病棟":
            departmentCounts.unit2SDept++;
            break;
        case "南館1階病棟":
            departmentCounts.unit1SDept++;
            break;
        case "南新館病棟":
            departmentCounts.unitNS1Dept++;
            break;
        case "リハビリ":
            departmentCounts.unitRehabilitationDept++;
            break;
        case "ME":
            departmentCounts.unitME++;
            break;
    }
});

const ctx = document.getElementById('myPieChart').getContext('2d');
const myPieChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: [],
        datasets: [{
            data: [],
            backgroundColor: [
                '#FF6384', '#36A2EB', '#FFCE56', 
                '#4BC0C0', '#9966FF', '#FF9F40', 
                '#66FF66', '#FF6384', '#36A2EB', 
                '#C9CBCF', '#FFCD56'             
            ],
            borderColor: ['#FFFFFF']
        }]
    },
   options: {
        responsive: true,
        legend:{
	      display: true,
	      position: 'top',
	      align: 'start'
},
        plugins: {
            datalabels: {
                display: (context) => {
	              return context.dataset.data[context.dataIndex] >= 1;
	              },
                color: 'black',
                font: {
                    size: 5
                },
                anchor: 'center',
                align: 'center',
                formatter: (value, ctx) => {
                    return ctx.chart.data.labels[ctx.dataIndex] + '\n' + value;
                }
            }
        },
      }
    });
const sortedDate = Object.keys(departmentCounts);
const keyValuePairs = sortedDate.map(department => ({
    department: dapartmentLabels[department],
    count: departmentCounts[department]
}));

keyValuePairs.sort((a, b) => b.count - a.count);
myPieChart.data.labels = keyValuePairs.map(pair => pair.department);
myPieChart.data.datasets[0].data = keyValuePairs.map(pair => pair.count);
myPieChart.update();

    
    
   

	

