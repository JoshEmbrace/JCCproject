
window.addEventListener("load", function(){
    var mynote = document.querySelector("#mynote");
    var textPager = document.querySelector("#text-pager");
    var txt1 = textPager.querySelector("input[type=textarea]");
    var btn1 = textPager.querySelector("input[type=button]");
    var body = mynote.querySelector("body");
    
    btn1.onclick = function(){
        var page = 1;
        if(txt1.value !=null && txt1.value !="")
            page = txt1.value; //사용자가 입력안했을 때 기본값
        //데이터 요청하기
         var request = new XMLHttpRequest();
         request.open("GET","/mynote/list-ajax?p="+page,false);
         request.send();
         var json = JSON.parse(request.responseText);
        


        //첫번째tr얻기
        //tbody.children()[0]
        //tbody.firstElementChild
        //tbody.querySelector("tr : first-child")
        var tr = body.firstElementChild; 

        tbody.innerHTML = ""; //다 지우기

        for(var i=0; i<json.length; i++){
        var cloneTr = tr.cloneNode(true);  //cloneNode 복제

        var idE1 = cloneTr.querySelector(".num");
        var contentE1 = cloneTr.querySelector(".content");
        var fileE1 = cloneTr.querySelector(".file");

        idE1.innerText = json[i].id;
        contentE1.innerText = json[i].content;
        fileE1.innerText = json[i].file;
    
        tbody.appendChild(cloneTr);
        }

        
        // console.log(json[0].title);
        // notices = notices.concat(json);

    }
    });