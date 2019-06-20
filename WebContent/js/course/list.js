window.addEventListener("load",function(){

    var ctable = this.document.querySelector("#course_table");
    var tbody = ctable.querySelector("tbody");

    var pager = this.document.querySelector("#pager");
    var nums = pager.querySelectorAll("a"); 
    //this.console.log(nums);
    //this.console.log(nums[0]);

    for(var i=0;i<nums.length;i++){
        
        nums[i].onclick = function(e){
            //console.log(nums[i].parentNode);
            e.preventDefault();
            for(var j=0;j<nums.length;j++)
                nums[j].style.background = "white";
            e.target.style.background = "red";
            var page = e.target.innerText;

            var request = new XMLHttpRequest();
            request.open("GET","list-ajax?p="+page,false);
            request.send();
     
            var json = JSON.parse(request.responseText);
            
    
            var temp = document.querySelector("main .main-template");
            //var tr = tbody.firstElementChild;
            
            tbody.innerHTML="";
    
            for(var i=0;i<json.length;i++){
                var cloneTr = document.importNode(temp.content,true);
                
                if(i%2!=0)
                    cloneTr.querySelector("tr").className = "even";

                
                var idEl = cloneTr.querySelector(".num");
                var nameEl = cloneTr.querySelector(".name a");
                var teacherEl = cloneTr.querySelector(".teacher");
                var managerEl = cloneTr.querySelector(".manager");
                var openEl = cloneTr.querySelector(".open");
                var endEl = cloneTr.querySelector(".end");
                var totalEl = cloneTr.querySelector(".total");
                var writerEl = cloneTr.querySelector(".writer");
                

                idEl.innerText = json[i].id;
                nameEl.innerText = json[i].name;
                teacherEl.innerText = json[i].teacher;
                managerEl.innerText = json[i].manager;
                if(json[i].openDate != "null" && json[i].openDate != "")
                    openEl.innerText = json[i].openDate.substr(0,10);
                if(json[i].endDate != "null" && json[i].endDate != "")
                    endEl.innerText = json[i].endDate.substr(0,10);
                totalEl.innerText = json[i].total;
                writerEl.innerText = json[i].writerId;
    
                tbody.appendChild(cloneTr);
            }
        };
    }




});

window.addEventListener("load",function(){
    var ctable = this.document.querySelector("#course_table");
    var tbody = ctable.querySelector("tbody");

    var input = this.document.querySelector("main .input");
    var txt = input.querySelector("input[type=text]");
    var btn = input.querySelector("input[type=button]");

    var cloneTr

    btn.onclick = function(){
        var page = "1";
        if(txt.value != null && txt.value != "")
            page = txt.value;
        
        // 데이터 요청하기
         
        var request = new XMLHttpRequest();
        
        request.open("GET","list-ajax?p="+page,false);
        request.send();
 
        var json = JSON.parse(request.responseText);
        


        var tr = tbody.firstElementChild;
        
        tbody.innerHTML="";
        var cloneTr = tr.cloneNode(true);

        for(var i=0;i<json.length;i++){
            var cloneTr = tr.cloneNode(true);

            var idEl = cloneTr.querySelector(".num");
            var nameEl = cloneTr.querySelector(".name a");
            var teacherEl = cloneTr.querySelector(".teacher");
            var managerEl = cloneTr.querySelector(".manager");
            var openEl = cloneTr.querySelector(".open");
            var endEl = cloneTr.querySelector(".end");
            var totalEl = cloneTr.querySelector(".total");
            var writerEl = cloneTr.querySelector(".writer");


            idEl.innerText = json[i].id;
            nameEl.innerText = json[i].name;
            teacherEl.innerText = json[i].teacher;
            teacherEl.innerText = json[i].manager;
            managerEl.innerText = json[i].name;
            openEl.innerText = json[i].openDate;
            endEl.innerText = json[i].endDate;
            totalEl.innerText = json[i].total;
            writerEl.innerText = json[i].writerId;

            tbody.appendChild(cloneTr);
        }
    };
});