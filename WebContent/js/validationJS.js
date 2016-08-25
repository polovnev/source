document.getElementById("registration").onsubmit = function() {return validate();};

function validate() {

	var result = true;
    var user_name=document.forms["user_form"]["user_name"].value;
    var email=document.forms["user_form"]["email"].value;
    var pas=document.forms["user_form"]["pas"].value;
    var r_pas=document.forms["user_form"]["r_pas"].value;
	var error = document.getElementById("error");
	
	error.innerHTML = ""; 
	
	if(isEmpty(user_name, email, pas, r_pas)) {
		var textError = document.createElement('p');
		textError.appendChild(document.createTextNode("Some fields are empty"));
		error.appendChild(textError);
		result = false;
	}
	
	
	if(validateEmail(email)) {
		var textError = document.createElement('p');
		textError.appendChild(document.createTextNode("Email is not valid"));
		error.appendChild(textError);
		result = false;
	}
	
	if(isNotCorrectPasswods(pas, r_pas)) {
		var textError = document.createElement('p');
		textError.appendChild(document.createTextNode("Passwords is not match"));
		error.appendChild(textError);
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