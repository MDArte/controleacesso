$(function(){
    var checkbox = $('#remember'),
        userField = $('#login'),
        passField = $('#senha'),
	 
        key = 'savedUsername',
        key2 = 'savedPass',
 
        username = jQuery.jStorage.get(key);
        password = jQuery.jStorage.get(key2);
 
    if (username) {
        userField.val(username);
        passField.val(password);
        checkbox.prop('checked', true);
        $('#loginForm').focus();
    }
    else {
        userField.val('').focus();
        checkbox.prop('checked', false);
    }
});

function getPath() {
	return "/controleacesso";
}

function clearForm() {
	if(!$('#remember').prop('checked')) {
		$('#login').val('');
        $('#senha').val('');
    }
}

function saveUsername () {
	if ($('#remember').prop('checked')) {
		jQuery.jStorage.set("savedUsername", $("#login").val());
		jQuery.jStorage.set("savedPass", $("#senha").val());
	}
    else {
		jQuery.jStorage.deleteKey("savedUsername");
		jQuery.jStorage.deleteKey("savedPass");
    }
}
