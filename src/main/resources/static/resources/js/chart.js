var data;
$.ajax({
    url: "/Analysis",
    data: {},
    method: "GET",
    dataType: "json"
}).done(function(json) {
    data = json.trend

    var context = document
        .getElementById('myChart')
        .getContext('2d');

    var myChart = new Chart(context, {
        type: 'line', // 차트의 형태
        data: { // 차트에 들어갈 데이터
            labels: [
//x 축
                '1','2','3','4','5','6','7'
            ],
            datasets: [
                { //데이터
                    label: 'test1', //차트 제목
                    fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                    data: data,
                    backgroundColor: [
//색상
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
//경계선 색상
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1 //경계선 굵기
                }/* ,
                    {
                        label: 'test2',
                        fill: false,
                        data: [
                            8, 34, 12, 24
                        ],
                        backgroundColor: 'rgb(157, 109, 12)',
                        borderColor: 'rgb(157, 109, 12)'
                    } */
            ]
        },
        options: {
            scales: {
                yAxes: [
                    {
                        ticks: {
                            beginAtZero: true
                        }
                    }
                ]
            },
            hover: {
                mode: 'nearest',
                intersect: true
            }
        }

    });


})

