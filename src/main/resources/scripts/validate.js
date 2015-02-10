function validateForm() {
    var amount = $("#roomId").val();
    if (amount == "") {
        $("#roomIdError").html("please, provide id of the room");
        return false
    }
}
