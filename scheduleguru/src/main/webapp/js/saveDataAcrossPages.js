
function build1button(){
	window.location.href = "/build2";
}

function build2button(){
	var tr='',mwf='',temp;
	var sT = $('input[name=radioStart]:checked').val();
	var eT = $('input[name=radioEnd]:checked').val();
	var arr = $('input[name=days]:checked');
	for(var a=0; a<arr.length; a++){
		temp = arr[a]['value'];
		if(temp === 'T' || temp === 'R')
			tr += temp;
		else
			mwf += temp;	
	}
	localStorage.setItem("mwf",mwf);
	localStorage.setItem("tr",tr);
	localStorage.setItem("sT",sT);
	localStorage.setItem("eT",eT);
	var majorlist = document.getElementById("selectMajor");
	var major = majorlist.options[majorlist.selectedIndex].value;
	localStorage.setItem("major",major);
	window.location.href = "/build3";
}
function build3button(){
	window.location.href = "/build4";
}
function build4button(){
	window.location.href = "/build5";
}
function build5button(){
	
}