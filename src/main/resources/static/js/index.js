$(document).ready(function(e) {
    $("#submit").click(function() {
        if(isDataValid()){
            submit(getData());
        }
    });
});

function isDataValid(){
    return $("#nombre").val().length <= 100;
}

function getData(){
    var nombre = $("#nombre").val(),
        monto = $("#monto").val(),
        descuento = $("#descuento").val();

    return {
        "nombre": nombre,
        "monto": parseInt(monto),
        "descuento": parseInt(descuento)
    };
}

function submit(data){
    $.ajax({
        type: "post",
        url: "pedido",
        data: JSON.stringify(data),
        contentType: "application/json",

        success: function(responseData, textStatus, jqXHR) {
            alert("Pedido guardado con id " + responseData["id"] + ".");
        },

        error: function(jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    })
}