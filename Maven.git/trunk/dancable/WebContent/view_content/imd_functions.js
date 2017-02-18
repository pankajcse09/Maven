<!--
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function isEmpty(strName) {
	var obj = document.getElementById(strName);
	if (obj.value.length == 0)
		return true;
	return false;
}

function checkText(strName, strMessage) {
	if (isEmpty(strName)) {
		notify(strName, strMessage);
		return false;
	}
	return true;
}

function checkSelect(strName, strMessage) {
	var obj = document.getElementById(strName);
	if (obj.value == -1) {
		notify(strName, strMessage);
		return false;
	}
	return true;
}

function checkCheckbox(strName, strMessage) {
	var obj = document.getElementById(strName);
	if (!obj.checked) {
		notify(strName, strMessage);
		return false;
	}
	return true;
}

function checkEqual(strName1, strName2, strMessage) {
	var obj1 = document.getElementById(strName1);
	var obj2 = document.getElementById(strName2);
	if (obj1.value != obj2.value) {
		notify(strName2, strMessage);
		return false;
	}
	return true;
}

function checkEmail(strName, strMessage) {
	var obj = document.getElementById(strName);
	var strEmail = "^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$";
	var regex = new RegExp(strEmail);
	if (!regex.test(obj.value)) {
		notify(strName, strMessage);
		return false;
	}
	return true;
}

function checkNumber(strName, strMessage) {
	var obj = document.getElementById(strName);
	if (isNaN(obj.value)) {
		notify(strName, strMessage);
		return false;
	}
	return true;
}

function selectOption(strName, strValue) {
	var obj = document.getElementById(strName);
	if (obj) {
		for (var i = 0; i < obj.length; i++)
		if (obj.options[i].value == strValue)
			obj.options[i].selected = true;
	}
}

function notify(strName, strMessage) {
	var obj = document.getElementById(strName);
	alert(strMessage);
	obj.focus();
}

function hide(strName) {
	var obj = document.getElementById(strName);
	obj.style.display = "none";
}

function show(strName) {
	var obj = document.getElementById(strName);
	obj.style.display = "";
}

function disable(strName) {
	var obj = document.getElementById(strName);
	obj.disabled = true;
}

function enable(strName) {
	var obj = document.getElementById(strName);
	obj.disabled = false;
}

function resetInput(strName) {
	var obj = document.getElementById(strName);
	obj.value = "";
}

//-->