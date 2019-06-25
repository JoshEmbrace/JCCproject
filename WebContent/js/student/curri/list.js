//페이저 코드
window.addEventListener("load",function(){
    var planbook = document.querySelector("#planbook");
    var history = document.querySelector("#history");
    var btn = history.querySelector("input[type=button]");
    var page = history.querySelector("input[type=hidden]");


    btn.onclick = function(){
        // 데이터 요청하기
        var num = page.value; 
        var request = new XMLHttpRequest();
        request.open("GET","list-ajax?p="+num,false);
        request.send();
        console.log(num);
        page.value = ++num;
        var planbooks = JSON.parse(request.responseText);
        

        var template = document.querySelector("#planbook-template");//복제방법2:템플릿 이용
        //var tr = tbody.firstElementChild; 복제방법1. 기존 노드 복제
        
        //var tr = tbody.querySelector("tr");
        //var tr = tbody.querySelectorAll("tr")[1];
     //   console.log(tr)
        console.log(planbooks.length);

        //planbook.innerHTML="";

        for(var i=0;i<planbooks.length;i++){
            //var cloneTr = tr.cloneNode(true); 복제방법1. 기존 노드 복제
        	var cloneTr = document.importNode(template.content, true);

            var titleEl = cloneTr.querySelector(".title");
            var reg_dateEl = cloneTr.querySelector(".reg_date");
            var contentEl = cloneTr.querySelector(".content");

            titleEl.innerText = planbooks[i].title;
            reg_dateEl.innerText = planbooks[i].regDate;
            contentEl.innerText = planbooks[i].content;

            planbook.append(cloneTr);
        }


         
         
    };
});