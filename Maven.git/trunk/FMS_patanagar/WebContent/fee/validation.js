function validno(i){
  var c=0;
  var count=0;
  var a=document.forms[0].elements[i].value.length;         
          for(j=0;j<a;j++){
          c=document.forms[0].elements[i].value.charCodeAt(j);             
          if(c>=48 && c<=57){             
          continue;        
           }
          else{
          if(c==46){
          count=count+1;
          if(count<=1){
          continue;
             }
          else{
          alert("Please Enter Valid Data");
          document.forms[0].elements[i].focus();
          return false;}
           }
          else{
          alert("Please Enter Valid Data");
          document.forms[0].elements[i].focus();
          return false;}
          }
          }
}

function validint(i){
  var c=0;
  var count=0;
  var a=document.forms[0].elements[i].value.length;         
          for(j=0;j<a;j++){
          c=document.forms[0].elements[i].value.charCodeAt(j);             
          if(c>=48 && c<=57){             
          continue;        
           }
          else{
          alert("Please Enter Valid Number");
          document.forms[0].elements[i].focus();
          return false;
           }
         }
}

function validformno(n,i){
  var c=0;
  var count=0;
  var a=document.forms[n].elements[i].value.length;         
          for(j=0;j<a;j++){
          c=document.forms[n].elements[i].value.charCodeAt(j);             
          if(c>=48 && c<=57){             
          continue;        
           }
          else{
          if(c==46){
          count=count+1;
          if(count<=1){
          continue;
             }
          else{
          alert("Please Enter Valid Data");
          document.forms[n].elements[i].focus();
          return false;}
           }
          else{
          alert("Please Enter Valid Data");
          document.forms[n].elements[i].focus();
          return false;}
          }
          }
}

function validformint(n,i){
  var c=0;
  var count=0;
  var a=document.forms[n].elements[i].value.length;         
          for(j=0;j<a;j++){
          c=document.forms[n].elements[i].value.charCodeAt(j);             
          if(c>=48 && c<=57){             
          continue;        
           }
          else{
          alert("Please Enter Valid Number");
          document.forms[n].elements[i].focus();
          return false;
           }
         }
}


