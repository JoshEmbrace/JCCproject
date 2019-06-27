<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="../layout/layout.css">
<link rel="shortcut icon" type="image/png"
	href="/semi-JCC/images/member/inc/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="../css/member/mypage.css">
<script src="../js/member/mypage.js"></script>
<!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->

</head>


<body>
	<div id="container">
		<!-- --header block------------------------------------------------------------------ -->
		<jsp:include page="../inc/header.jsp" />



		<!-- --body block------------------------------------------------------------------ -->

		<div class="body-container">
			<jsp:include page="../inc/aside.jsp" />
			<main class="main">
			<div class="main-container">
				<ol class="breadcrumb">
                       <li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
                       <li><i class="material-icons">
                               chevron_right
                           </i><span>My page</span></li>
				</ol>
				
				<div class="main-content-box">
				<section id="join">
					<form method="post">
						<div class="container">
							<div class="row">

								<div class="col-md-7 ">

									<div class="panel panel-default">
										<div class="panel-heading">
											<h4>User Profile</h4>
										</div>
										<div class="panel-body">

											<div class="box box-info">

												<div class="box-body">
													<div class="col-sm-6">
														<div align="center">
															<img alt="User Pic"
																src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
																id="profile-image1" class="img-circle img-responsive">

															<input id="profile-image-upload" class="hidden"
																type="file">
															<div style="color: #999;">프로필 사진 변경</div>
															<!--Upload Image Js And Css-->
														</div>
														<br>
														<!-- /input-group -->
													</div>


													<div class="col-sm-6">
														<h4 style="color: #00b1b1;">${sessionScope.user["name"]}</h4>
													</div>
													<div class="clearfix"></div>
													<hr style="margin: 5px 0 5px 0;">


													<div class="col-sm-5 col-xs-6 title ">아이디:</div>
													<div class="col-sm-7 col-xs-6 ">${sessionScope.user["user_id"]}</div>

													<div class="clearfix"></div>
													<div class="bot-border"></div>


													<div class="col-sm-5 col-xs-6 title ">비밀번호:</div>
													<div class="col-sm-7">
														<input type="password" name="password" maxlength="15">
														<span class="check-pwd" value="not"></span>
													</div>


													<div class="clearfix"></div>
													<div class="bot-border"></div>

													<div class="col-sm-5 col-xs-6 title ">비밀번호 확인:</div>
													<div class="col-sm-7">
														<input type="password" name="password1" maxlength="15">
														<span class="check-pwd1" value="not"></span>
													</div>


													<div class="clearfix"></div>
													<div class="bot-border"></div>

													<div class="col-sm-5 col-xs-6 title ">생일:</div>
													<div class="col-sm-7">${sessionScope.user["birthday"]}</div>

													<div class="clearfix"></div>
													<div class="bot-border"></div>

													<div class="col-sm-5 col-xs-6 title ">이메일:</div>
													<div class="col-sm-7">${sessionScope.user["email"]}</div>


													<div class="clearfix"></div>
													<div class="bot-border"></div>


													<div class="col-sm-5 col-xs-6 title ">성별:</div>
													<div class="col-sm-7">${(sessionScope.user["gender"]
													== 1)?"남자":"여자"}</div>

													<br> <input type="submit" value="수정" /> <a
														onclick='history.back(-1); return false;'><input
														type="button" value="취소"></a>

												</div>
												<!-- /.box -->

											</div>


										</div>
									</div>
								</div>
							

							</div>
						</div>

					</form>

				</section>
			</div>
			</div>
			</main>

		</div>
	</div>
</body>
</html>
