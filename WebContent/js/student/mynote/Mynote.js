window.addEventListener("load",function(){
	var mynote = document.querySelector("#mynote");
	var history = document.querySelector("#history");
	var morepage = history.querySelector("input[type=hidden]");
	var morebtn = history.querySelector("input[type=button]");
	

	morebtn.onclick = function(){
		var num = morepage.value;
		alert(morepage.value);
		var request = new XMLHttpRequest();
		request.open("GET", "list-ajax?p="+num, false);
		request.send();
		console.log(num);
		morepage.value = ++num;
		console.log(num);
		var mynotejson = JSON.parse(request.responseText);
		
		var template = document.querySelector("main .mynote-template");
		
		//body.innerHTML = ""; //다 지우기
		for (var i = 0; i < mynotejson.length; i++) {

			var cloneTr = document.importNode(template.content, true);
			
			var eidEl = cloneTr.querySelector("input[name=eid]");
			var didEl = cloneTr.querySelector("input[name=did]");
			var contentEl = cloneTr.querySelector(".content");
			var dateEl = cloneTr.querySelector(".reg_date");

			eidEl.innerText = mynotejson[i].id;
			didEl.innerText = mynotejson[i].id;
			contentEl.innerText = mynotejson[i].content;
			dateEl.innerText = mynotejson[i].regDate;
			//fileEl.innerText = mynote[i].file;
			console.log(mynotejson[i].id);
			mynote.append(cloneTr);


		}
	}
});


window.addEventListener("load", function() {

	var textPager = document.querySelector("#text-pager");
	var txt1 = textPager.querySelector("input[type=text]");
	var btn1 = textPager.querySelector("input[type=button]");
	var body = document.querySelector("main .body");

	

	btn1.onclick = function() {
		var page = 1;
		if (txt1.value != null && txt1.value != "")
			page = txt1.value; //사용자가 입력안했을 때 기본값

		//데이터 요청하기
		var request = new XMLHttpRequest();
		request.open("GET", "/semi-JCC/student/mynote/list-ajax?p=" + page, false);
		request.send();
		alert(page);
		
		var mynotejson = JSON.parse(request.responseText);
		alert(mynotejson[0].content);
		//템플릿을 이용한 복제

		var template = document.querySelector("main .mynote-template");
		
		body.innerHTML = ""; //다 지우기
		for (var i = 0; i < mynotejson.length; i++) {

			var cloneTr = document.importNode(template.content, true);
			
			var eidEl = cloneTr.querySelector("input[name=eid]");
			var didEl = cloneTr.querySelector("input[name=did]");
			var contentEl = cloneTr.querySelector(".content");
			var dateEl = cloneTr.querySelector(".reg_date");

			eidEl.innerText = mynotejson[i].id;
			didEl.innerText = mynotejson[i].id;
			contentEl.innerText = mynotejson[i].content;
			dateEl.innerText = mynotejson[i].regDate;
			//fileEl.innerText = mynote[i].file;
			console.log(mynotejson[i].id);
			body.append(cloneTr);

		}

	}	
});

//window.addEventListener("load", function(){
//    var mynote = document.querySelector("#mynote");
//    var textPager = document.querySelector("#text-pager");
//    var txt1 = textPager.querySelector("input[type=textarea]");
//    var btn1 = textPager.querySelector("input[type=button]");
//    var body = mynote.querySelector("body");
//    
//    btn1.onclick = function(){
//        var page = 1;
//        if(txt1.value !=null && txt1.value !="")
//            page = txt1.value; //사용자가 입력안했을 때 기본값
//        //데이터 요청하기
//         var request = new XMLHttpRequest();
//         request.open("GET","/mynote/list-ajax?p="+page,false);
//         request.send();
//         var json = JSON.parse(request.responseText);
//        
//
//
//        //첫번째tr얻기
//        //tbody.children()[0]
//        //tbody.firstElementChild
//        //tbody.querySelector("tr : first-child")
//        var tr = body.firstElementChild; 
//
//        tbody.innerHTML = ""; //다 지우기
//
//        for(var i=0; i<json.length; i++){
//        var cloneTr = tr.cloneNode(true);  //cloneNode 복제
//
//        var idE1 = cloneTr.querySelector(".num");
//        var mynoteE1 = cloneTr.querySelector(".list_section");
//        var fileE1 = cloneTr.querySelector(".file");
//
//        idE1.innerText = json[i].id;
//        contentE1.innerText = json[i].content;
//        fileE1.innerText = json[i].file;
//    
//        tbody.appendChild(cloneTr);
//        }
//
//        
//        console.log(json[0].id);
//        // notices = notices.concat(json);
//
//    }
//    });