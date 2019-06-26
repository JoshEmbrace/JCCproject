<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="nav">
				<ul class="nav-container">
				
					<li>
						<a href="/semi-JCC/member/index"><i class="material-icons md-36">description</i><span>Home</span></a>
					</li>
					<li>
						<a href="#Mynote"><i class="material-icons md-36">description</i><span>개인정보수정</span></a>
					</li>
					<li>
						<a href="#Curriculum"><i class="material-icons md-36">date_range</i><span>회원탈퇴</span></a>
					</li>
					
				</ul>
			</nav>
			<script>
				var dropdown = document.getElementsByClassName(".dropdown-menu");

				for (var i = 0; i < dropdown.length; i++) {
					dropdown[i].addEventListener("click", function () {
						this.classList.toggle("active");
						var dropdownContent = this.nextElementSibling;
						if (dropdownContent.style.display === "block") {
							dropdownContent.style.display = "none";
						} else {
							dropdownContent.style.display = "block";
						}
					});
				}
			</script>