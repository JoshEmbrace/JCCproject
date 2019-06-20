
window.addEventListener("load", function(){
	var freeboard = document.querySelector("#freeboard");
	var pager = document.querySelector("#pager");
	var tbody = freeboard.querySelector('tbody');
	
	var nums =pager.querySelectorAll("a");  //(a태그 엘리먼트 객체배열)
	
	for(var i=0; i<nums.length; i++)
		nums[i].onclick = function(e){
		e.preventDefault();
		e.target.style.background = "pink";
		
		var page = e.target.innerText;
		
		//데이터 요청하기 

 		var request = new XMLHttpRequest();
 		request.open("GET", "/semi-JCC/freeboard/list-ajax?p="+page,false);
 		request.send();
		var json = JSON.parse(request.responseText);
		

		  //복제방법2: 템플릿을 이용한 복제
		
	    var template = freeboard.querySelector(".freeboard-template");
	    
	    tbody.innerHTML ="";
		for(var a = 0; a<json.length; a++) {
		    var cloneTr = document.importNode(template.content, true);
		    
			var idEl = cloneTr.querySelector(".num");
			var titleEl = cloneTr.querySelector(".title a");
			var writerEl = cloneTr.querySelector(".writer");
			var dateEl = cloneTr.querySelector(".date");
			
			idEl.innerText = json[a].id;
			titleEl.innerText = json[a].title;
			writerEl.innerText = json[a]["writer_id"];
			dateEl.innerText = json[a]["reg_date"];
			tbody.append(cloneTr);

		} //for문 종료 
		
	};
	
	
});



window.addEventListener("load", function(){
	
	var freeboard = document.querySelector("#freeboard");
	var testPager = document.querySelector("#test-pager");
	var button1 = testPager.querySelector("input[type=button]");
	var text = testPager.querySelector("input[type=text]");
	var tbody = freeboard.querySelector("tbody");
	
 	button1.onclick = function(){
 		//var page = text.value;

		 var page =1;
		 if(text.value != null && text.value != "")
		 	page = text.value;
 		//데이터 요청하기 
		 
 		var request = new XMLHttpRequest();
 		request.open("GET", "/semi-JCC/freeboard/list-ajax?p="+page,false);
 	
 		request.send();
		var json = JSON.parse(request.responseText);
 		console.log(request.responseText);
 		
 		  //복제방법2: 템플릿을 이용한 복제
 	    var template = freeboard.querySelector(".freeboard-template");
 	    tbody.innerHTML ="";
 
 		for(var a = 0; a<json.length; a++) {
 			//복제 방법1: 기존 노드를 복제하기
 			//var cloneTr = tr.cloneNode(true); // 안의 자식들이 복제되서 만들어진다
				//첫번째 노드가 없을수도 있기 때문에 클론하면 안좋다
				//대신 template을 사용한다
 		    var cloneTr = document.importNode(template.content, true);
			var idEl = cloneTr.querySelector(".num");
 			var titleEl = cloneTr.querySelector(".title a");
 			var writerEl = cloneTr.querySelector(".writer");
 			var dateEl = cloneTr.querySelector(".date");
 			var fileEl = cloneTr.querySelector(".file");
			
 			idEl.innerText = json[a].id;
			 titleEl.innerText = json[a].title;
			var link = "detail?id="+json[a].id;
			titleEl.href=link;
 			writerEl.innerText = json[a]["writer_id"];
 			dateEl.innerText = json[a]["reg_date"];
 			//fileEl.innerText = json[a]["reg_date"];
 			
 		}
 	}
});


window.addEventListener("load", function(){
	var freeboard = document.querySelector("#freeboard");
	var pager = document.querySelector("#pager");
	var tbody = freeboard.querySelector('tbody');
	
	var nums =pager.querySelectorAll("a");  //(a태그 엘리먼트 객체배열)
	
	for(var i=0; i<nums.length; i++)
		nums[i].onclick = function(e){
		e.preventDefault();
		e.target.style.background = "pink";
		
		var page = e.target.innerText;
		
		//데이터 요청하기 

 		var request = new XMLHttpRequest();
 		request.open("GET", "/semi-JCC/freeboard/list-ajax?p="+page,false);
 		request.send();
		var json = JSON.parse(request.responseText);
		
		
		

		  //복제방법2: 템플릿을 이용한 복제
		
	    var template = freeboard.querySelector(".freeboard-template");
	    
	    tbody.innerHTML ="";
		for(var a = 0; a<json.length; a++) {
		    var cloneTr = document.importNode(template.content, true);
		    
			var idEl = cloneTr.querySelector(".num");
			var titleEl = cloneTr.querySelector(".title a");
			var writerEl = cloneTr.querySelector(".writer");
			var dateEl = cloneTr.querySelector(".date");
			
			idEl.innerText = json[a].id;
			titleEl.innerText = json[a].title;
			writerEl.innerText = json[a]["writer_id"];
			dateEl.innerText = json[a]["reg_date"];
			tbody.append(cloneTr);

		} //for문 종료 
		
	};
	
	
});



window.addEventListener("load", function(){
	
	var freeboard = document.querySelector("#freeboard");
	var testPager = document.querySelector("#test-pager");
	var button1 = testPager.querySelector("input[type=button]");
	var text = testPager.querySelector("input[type=text]");
	var tbody = freeboard.querySelector("tbody");
	
 	button1.onclick = function(){
 		//var page = text.value;

		 var page =1;
		 if(text.value != null && text.value != "")
		 	page = text.value;
 		//데이터 요청하기 
		 
 		var request = new XMLHttpRequest();
 		request.open("GET", "/semi-JCC/freeboard/list-ajax?p="+page,false);
 	
 		request.send();
		var json = JSON.parse(request.responseText);
 		console.log(request.responseText);
 		
 		  //복제방법2: 템플릿을 이용한 복제
 	    var template = freeboard.querySelector(".freeboard-template");
 	    tbody.innerHTML ="";

 		for(var a = 0; a<json.length; a++) {
 			//복제 방법1: 기존 노드를 복제하기
 			//var cloneTr = tr.cloneNode(true); // 안의 자식들이 복제되서 만들어진다
				//첫번째 노드가 없을수도 있기 때문에 클론하면 안좋다
				//대신 template을 사용한다
 		    var cloneTr = document.importNode(template.content, true);
 		    
			var idEl = cloneTr.querySelector(".num");
 			var titleEl = cloneTr.querySelector(".title a");
 			var writerEl = cloneTr.querySelector(".writer");
 			var dateEl = cloneTr.querySelector(".date");
			
 			idEl.innerText = json[a].id;
 			titleEl.innerText = json[a].title;
 			writerEl.innerText = json[a]["writer_id"];
 			dateEl.innerText = json[a]["reg_date"];

			tbody.append(cloneTr);

 		} //for문 종료 
 	}
 	
});