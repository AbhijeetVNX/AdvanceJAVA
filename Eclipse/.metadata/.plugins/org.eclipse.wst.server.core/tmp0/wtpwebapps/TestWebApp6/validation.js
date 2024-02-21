function validate(frm){
	
	frm.vflag.value="yes";
	
	var uname=frm.pname.value;
	var uage=frm.page.value;
	
	if(uname==""){
		
		alert("Person name is Mandatory!!!!!!");
		frm.pname.focus();
		return false;
	}
	if(uage==""){
	
		alert("Person age is Mandatory!!!!!!");
		frm.pname.focus();
		return false;
	}
	else{
		
		if(isNaN(uage)){
			
			alert("age must be numeric value!!");
			frm.page.focus;
			frm.page.value="";
			return false;
		}
	}
	return true;
}