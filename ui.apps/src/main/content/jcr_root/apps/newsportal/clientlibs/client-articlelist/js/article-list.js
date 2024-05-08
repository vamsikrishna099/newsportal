function fetchDataFromServlet() {
    
    $.ajax({
        url: '/bin/content/krishna0003',
        type: 'GET',
        dataType: 'text',
        success: function(data) {
            var jsonData = JSON.parse(data);
            renderData(jsonData);
        },
        error: function(xhr, status, error) {
            console.error('Error fetching data from servlet:', error);
        }
    });
}


$(document).ready(function() {
    fetchDataFromServlet();
});

function renderData(jsonData) {
    var html = '';
    $.each(jsonData, function(index, obj) {
        html += '<div data-sly-list="${jsonData}" data-sly-unwrap>';
        html += '<p>id: ' + obj.id + '</p><p>user_id: ' + obj.user_id + '</p>';
        html += '<p>Title: ' + obj.title + '</p><p>Body: ' + obj.body + '</p>';
        html += '</div>';
        html += '<br>';
    });
    $('#data-container').html(html);
}

    // $('#data-container').html('<p>' + jsonData.id + '</p><p>' + jsonData.user_id + '</p><p>' + jsonData.title + '</p><p>' + jsonData.body + '</p>');

