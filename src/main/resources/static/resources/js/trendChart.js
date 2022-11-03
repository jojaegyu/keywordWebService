function ChangeValue(){
    var keyword_dom = document.getElementById("keyword_text");
    var ageCategory_dom = document.getElementById("ageCategory");
    var gender_dom = document.getElementById("gender");
    var period_dom = document.getElementById("period");

    var keyword = keyword_dom.innerText;
    var ageCategory = ageCategory_dom.options[ageCategory_dom.selectedIndex].value;
    var gender = gender_dom.options[gender_dom.selectedIndex].value;
    var period = period_dom.options[period_dom.selectedIndex].value;

    var data = {keyword: keyword, ageCategory: ageCategory, gender: gender, period: period};

    $.ajax({
        url: "/getTrend",
        data: data,
        method: "GET",
        dataType: "json"
    }).done(function(json) {
        var trend = json.ratios;
        var trend_Datetime = json.periods;

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
                    text: keyword
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
        const trend_canvas = document.getElementById("trends")
        const trend_ctx = trend_canvas.getContext("2d");
        trend_ctx.clearRect(0, 0, trend_canvas.width, trend_canvas.height);
        if (trendChart != null){
            trendChart.destroy();
        }
        trendChart = new Chart(trend_ctx, trend_config);

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
}

var trendChart = null;
ChangeValue();
