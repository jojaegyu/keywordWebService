$.ajax({
    url: "/Analysis",
    data: {},
    method: "GET",
    dataType: "json"
}).done(function(json) {
    var trend = json.trend;
    var trend_Datetime = json.trend_Datetime;

    window.chartColors = {
        red: 'rgb(255, 99, 132)',
        orange: 'rgb(255, 159, 64)',
        yellow: 'rgb(255, 205, 86)',
        green: 'rgb(75, 192, 192)',
        blue: 'rgb(54, 162, 235)',
        purple: 'rgb(153, 102, 255)',
        grey: 'rgb(231,233,237)'
    };

    var trend_config = {
        type: 'line',
        data: {
            labels: trend_Datetime,
            datasets: [{
                label: "My First dataset",
                backgroundColor: window.chartColors.red,
                borderColor: window.chartColors.red,
                data: trend,
                fill: false,
            }]
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Chart.js Line Chart'
            },
            tooltips: {
                mode: 'index',
                intersect: false,
            },
            hover: {
                mode: 'nearest',
                intersect: true
            },
            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Month'
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                    },
                }]
            }
        }
    };

    var trend_ctx = document.getElementById("trends").getContext("2d");
    var myLine = new Chart(trend_ctx, trend_config);

    var emotions = json.emotions
    let emotion_data = {
        labels: ['foo', 'bar', 'baz', 'fie', 'foe', 'fee', 'qqq'],
        datasets: [{
            data: emotions,
            backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
        }]
    };

    let emotion_ctx = document.getElementById('emotions').getContext('2d');
    let emotion_config = {
        type : 'pie',
        data : emotion_data,
        options : {
            responsive: false,
            pieceLabel: {
                mode : 'label',
                position: "outside",
                fontSize: 5,
                fontStyle: 'bold'
            }
        },

        plugins : {
            pieceLabel: {
                mode : 'label',
                position: "outside",
                fontSize: 5,
                fontStyle: 'bold'
            }
        }
    }
    let emotion_chart = new Chart(emotion_ctx, emotion_config);



});