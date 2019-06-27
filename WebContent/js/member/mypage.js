window.addEventListener("load",function(){
    var section = document.querySelector("#join");
    
    var pwd = section.querySelector("input[name=password]");
    var check = section.querySelector(".check-pwd");
    var pwd2 = section.querySelector("input[name=password1]");
    var pwdcheck = section.querySelector(".check-pwd1");
    var submit = section.querySelector("input[type=submit]");


    pwd.oninput = function(){
        if(pwd.value.includes(" ")){
            check.innerText = "공백은 포함될 수 없습니다.";
            check.style.color = "red";
            
        }else{
            check.innerText = "";
            check.value="ok";
        }
    }
    pwd2.oninput = function(){
        if(pwd.value == pwd2.value){
            pwdcheck.innerText = "일치합니다."
            pwdcheck.style.color = "green";
            pwdcheck.value="ok";
        }else{
            pwdcheck.innerText = "불일치합니다."
            pwdcheck.style.color = "red";
            pwdcheck.value="not";
        }
    };

    submit.onclick = function(e){

        if(check.value!="ok" || pwdcheck.value!="ok"){
            alert("비밀번호를 다시 확인하십시오.");
            e.preventDefault();
            return;
        }
        
    };
});


