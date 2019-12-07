// Include form validation functions here
function valid() {
	var name=document.forms["form"]["title"].value;
	var gross=document.forms["form"]["gross1"].value;
	var date=document.forms["form"]["date1"].value;
	if (name=="") {
		alert("title can't be empty");
		return false;
	}
	if ( name.length < 2) {
		alert("Title should have 2 to 100 characters.");
		return false;
	}
	if (date=="") {
		alert("Date of Launcher can't be blank");
		return false;
	}
	if (gross=="") {
		alert("gross can't be empty");
		return false;
	}
    if (/[^0-9]/.test(gross)) {
		alert(" the value should be numbers only");
        return false;
    }
		
}