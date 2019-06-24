window.addEventListener("load",function(){
    var section = document.querySelector(".main .main-content-box");
    
    var id = section.querySelector("input[name=id]");
    var checkid = section.querySelector("input[name=check-id]");

    checkid.onclick = function(){
        var userid = id.value;
        var exist = section.querySelector(".exist");

        var request = new XMLHttpRequest();
        request.open("GET","signup-check?id="+userid,false);
        request.send();
        var json = JSON.parse(request.responseText);

        if(json["exist"] != 0){
            alert(userid+"는(은) 사용할 수 없습니다.");
            exist.innerText = "사용할 수 없습니다.";
            return;
        }else{
            alert(userid+"는(은) 사용 가능 합니다.");
            exist.innerText = "사용 가능 합니다.";
        }
        

    };
});