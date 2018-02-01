$(document).ready(function () {
    $("td").each(function () {
        $('.edit').click(function () {

            $("#updateA").css("display", "block");
        });
        $(".close").click(function () {
            $("#updateA").css("display", "none");
        });
    })

});


