function circle(el){
    $(el).circleProgress({fill: {color: '#3B5998'}})
    .on('circle-animation-progress', function(event, progress, stepValue){
        $(this).find('strong').text(String(stepValue.toFixed(2) * 100) + '%');
    });
}

circle('.round');