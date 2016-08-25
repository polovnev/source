$("#registration").submit(function(event) {
	if(!validate()) {
		event.preventDefault();
	}
});

function validate() {
	var result = true;
    var user_name=$("[name=user_name]").val();
    var email=$("[name=email]").val();
    var pas=$("[name=pas]").val();
    var r_pas=$("[name=r_pas]").val();
	var error=$("#error"); 
	
	error.html("");
	
	if(isEmpty(user_name, email, pas, r_pas)) {
		error.append("<p>Some fields are empty</p>");
		result = false;
	}
	
	if(validateEmail(email)) {
		error.append("<p>Email is not valid</p>");
		result = false;
	}
	
	if(isNotCorrectPasswods(pas, r_pas)) {
		error.append("<p>Passwords is not match</p>");
		result = false;
	}
	return result;
}


function isEmpty(user_name, email, pas, r_pas) {
	return (!user_name || !email || !pas || !r_pas);
}


function isNotCorrectPasswods(pas, r_pas) {
	return pas != r_pas;
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return !re.test(email);
}