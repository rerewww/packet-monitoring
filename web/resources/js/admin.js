/**
 * Created by son on 2018-11-24.
 */
var admin = {
    login: function () {
        $.ajax({
            url: '/login',
            type:'POST',
            async: true,
            data: {
                id: document.getElementById('id').value,
                password: document.getElementById('password').value
            },
            dataType: 'json',
            success: function(response) {
                if (response === null || response === undefined) {
                    return;
                }
                window.location.href = "/network"
            },
            error: function(response) {
                console.log(response);
            }
        });
    }
};