$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});

 $('.submit-btn').on('click', function(){
              var date = new Date($('#date-input').val());
              var day = $('#date-input').getDate();
              var month = $('#date-input').getMonth() + 1;
              var year = $('#date-input').getFullYear();
              alert(day+"/"+ month+"/"+year);
            });
