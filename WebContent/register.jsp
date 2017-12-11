<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> URL Management System </title>
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- Use the correct meta names below for your web application
			 Ref: http://davidbcalhoun.com/2010/viewport-metatag 
			 
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">-->
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">	
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.css">	
		
		<!-- SmartAdmin RTL Support is under construction
			<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->
		
		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.css">

		<!-- FAVICONS -->
		<link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">

		<!-- GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

	</head>
	<body id="login">
		<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
		<header id="header">
			<!--<span id="logo"></span>-->

			<div id="logo-group">
				<span id="logo"> <img src="img/url.jpg" alt="SmartAdmin"> </span>

				<!-- END AJAX-DROPDOWN -->
			</div>

			<span id="login-header-space"> <span class="hidden-mobile">Already registered?</span> <a href="login.jsp" class="btn btn-danger">Sign In</a> </span>
<ul>
							<li>
								contact us: 2282550468@qq.com / 2819963552@qq.com / 648923307@qq.com
							<a href="help.jsp">or you just want some instruction?</a>
							</li>
						</ul>
		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-7 hidden-xs hidden-sm">
						<h1 class="txt-color-red login-header-big">register page</h1>
						<div class="hero">

							<div class="pull-left login-desc-box-l">
								<h4 class="paragraph-header">It's Okay to be begin. Experience it, everywhere you go!</h4>
								
							</div>
							
							<img src="img/urlpic.jpg" alt="" class="pull-right display-image" style="width:210px">
							
						</div>

						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h5 class="about-heading">About Website - Are you up to date?</h5>
								<p>
									Use your email you can get an experience!
								</p>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h5 class="about-heading">Not just your average template!</h5>
								<p>
									Input the useable url and you get information from your email on time!
								</p>
							</div>
						</div>

					</div>
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
						<div class="well no-padding">

							<form action="Register" id="smart-form-register" class="smart-form client-form">
								<header>
									 Registration Of Our System is FREE
								</header>

								<fieldset>

									<section>
										<label class="input"> <i class="icon-append fa fa-envelope"></i>
											<input type="email" name="email" placeholder="Email address">
											<b class="tooltip tooltip-bottom-right">Needed to verify your account</b> </label>
									</section>

									<section>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="password" placeholder="Password" id="password">
											<b class="tooltip tooltip-bottom-right">Don't forget your password</b> </label>
									</section>

									<section>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="passwordConfirm" placeholder="Confirm password">
											<b class="tooltip tooltip-bottom-right">Don't forget your password</b> </label>
									</section>
								</fieldset>

								<fieldset>
									
								<section>
										<label class="checkbox">
											<input type="checkbox" name="subscription" id="subscription">
											<i></i>I want to receive news and special offers</label>
										<label class="checkbox">
											<input type="checkbox" name="terms" id="terms">
											<i></i>I agree with the <a href="#" data-toggle="modal" data-target="#myModal"> Terms and Conditions </a></label>
									</section>
								</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary">
										Register
									</button>
								</footer>

								<div class="message">
									<i class="fa fa-check"></i>
									<p>
										Thank you for your registration!
									</p>
								</div>
							</form>

						</div>
							
							
					
					</div>
				</div>
			</div>

		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
					</div>
					<div class="modal-body custom-scroll terms-body">
						
 <div id="left">



            尊敬的用户：您好！<br>
欢迎光临WebGoGO网站（以下简称“本站”）。
<br>用户需要同意本服务条款才能成为本站的注册用户并享受本网站所提供的各项服务。用户注册是完全免费的，继续注册前请先阅读服务条款。
<br>
<br>1. 本站服务条款确认与接纳
<br>本协议是用户（您）与本站之间的协议，本站依据本协议条款为您提供服务。
<br>1.1 本协议服务条款构成您（无论是个人或者单位）使用本站所提供服务之先决条件。如您不同意本协议服务条款或其随时对其的修改，您应不使用或主动取消本站提供的服务。您的使用行为将被视为您对本协议服务条款及其随时修改版本的完全接受；
<br>1.2 这些条款可由本站随时更新，且毋须另行通知。修改后的服务条款一旦在本站上公布即取代替原来的服务条款，并构成本条款整体之一部分。您可随时访问本站查阅最新的服务条款。
<br>
<br>2. 本站提供的服务
<br>2.1 本站向您提供包括但不限于如下服务：
<br>（1）本站主页webgogo.applinzi.com（含其他任何由本站直接所有或运营的任何网站）； 
<br>（2）本站提供给您的任何其他技术和/或服务。
<br>2.2 您在此明确陈述并保证对所有上传、传播到本站上的内容，拥有或取得了所有必要的权利并承担全部的法律责任，包括但不限于：您有权或已取得必要的许可、授权、准许来使用或授权本站使用所有与上传作品有关的所有专利、商标、商业秘密、版权、表演者权及其他私有权利；
<br>2.3 对所有上传至本站的内容（您在此保证已获得权利人的明确授权），您在此同意授予本站对所有上述作品和内容的在全球范围内的免费、不可撤销的、无限期的、并且可转让的非独家使用权许可；本站有权视情况展示、散布及推广前述内容，有权对前述内容进行任何形式的复制、修改、出版、发行及以其他方式使用或者授权第三方进行复制、修改、出版、发行及以其他方式使
用；
<br>2.4 本站并不担保您所有上传内容能够通过本站服务为其他用户所获取、浏览，本站没有义务和责任对所有您上传、传播的内容进行监测；但本站保留根据国家法律、法规的要求对上传、传播的内容进行不定时抽查的权利，并有权在不事先通知的情况下移除获断开链接违法、侵权的内容。此款的规定并不排除您对上传内容的版权担保，亦并非表明本站有责任及能力判断您上传内容的版权归属 。
<br>
<br>3. 用户注册
<br>如果您使用本站提供的定时消息提醒功能，您需要注册一个账号、密码，并确保注册信息的真实性、正确性及完整性，如果上述注册信息发生变化，您应及时更改。在安全完成本服务的登记程序并收到一个密码及账号后，您应维持密码及账号的机密安全。您应对任何人利用您的密码及账号所进行的活动负完全的责任，本站无法对非法或未经您授权使用您账号及
密码的行为做出甄别，因此本站不承担任何责任。在此，您同意并承诺做到：
<br>3.1 当您的密码或账号遭到未获授权的使用，或者发生其他任何安全问题时，您会立即有效地通知到本站；
<br>3.2 当您每次登录本站或使用其他相关服务后，会将有关账号等安全退出；
<br>3.3 您同意接受本站通过电子邮件、客户端、网页或其他合法方式向您发送相关商业信息。在使用电信增值服务的情况下，您同意接受本站及其合作公司通过增值服务系统或其他方式向您发送的相关服务信息或其他信息，其他信息包括但不限于通知信息、宣传信息、广告信息等；
<br>3.4 您承诺不在注册、使用本站账号时从事下列行为：
<br>（1） 故意冒用他人信息为自己注册本站账号； 
<br>（2） 未经他人合法授权以他人名义注册本站账号；
<br>（3） 使用侮辱、诽谤、色情等违反公序良俗的词语注册本站账号。
<br>3.5 您在此同意，本站有权根据自己的判定，对违反上述条款的用户拒绝提供账号注册或取消该账号的使用；
<br>3.6 本站保证，您提供给本站的所有注册信息将根据本站隐私保护政策予以保密，但根据国家法律强制性要求予以披露的除外。
<br>
<br>4. 用户行为与承诺
<br>您单独承担发布内容的责任。您对服务的使用是根据所有适用于服务的地方法律、国家法律和国际法律标准的。
<br>用户承诺：
<br>4.1 在本站的网页上发布信息或者利用本站的服务时必须符合中国有关法规，不得在本站的网页上或者利用本站的服务制作、复制、发布、传播以下信息：
<br>（1）反对宪法所确定的基本原则的；
<br>（2）危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；
<br>（3）损害国家荣誉和利益的；
<br>（4）煽动民族仇恨、民族歧视，破坏民族团结的；
<br>（5）破坏国家宗教政策，宣扬邪教和封建迷信的；
<br>（6）散布谣言，扰乱社会秩序，破坏社会稳定的；
<br>（7）散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；
<br>（8）侮辱或者诽谤他人，侵害他人合法权益的；
<br>（9）煽动非法集会、结社、游行、示威、聚众扰乱社会秩序的；
<br>（10）以非法民间组织名义活动的；
<br>（11）含有法律、行政法规禁止的其他内容的。
<br>4.2 不利用本站的服务从事以下活动：
<br>（1）未经允许，进入计算机信息网络或者使用计算机信息网络资源的；
<br>（2）未经允许，对计算机信息网络功能进行删除、修改或者增加的； 
<br>（3）未经允许，对进入计算机信息网络中存储、处理或者传输的数据和应用程序进行删除、修改或者增加的；
<br>（4）故意制作、传播计算机病毒等破坏性程序的；
<br>（5）其他危害计算机信息网络安全的行为。
<br>4.3 遵守本站的所有其他规定和程序。
<br>
<br>5. 隐私保护
<br>当您注册本站的服务时，您须提供个人信息。本站收集个人信息的目的是为您提供尽可能多的个人化网上服务。本站不会在未经合法获得您授权时，公开、编辑或透露您的个人信息及保存在本站中的非公开内容，除非有下列情况：
<br>（1）有关法律规定或本站合法服务程序规定； 
<br>（2）在紧急情况下，为维护您及公众的权益； 
<br>（3）为维护本站的商标权、专利权及其他任何合法权益；
<br>（4）其他依法需要公开、编辑或透露个人信息的情况。
<br>
<br>6. 免责声明
<br>6.1本站本身不直接上传、发布任何包括但不限于文档（文字）、图片、音视频课件等内容。所有内容均由用户上传、发布，本站合理信赖内容上传（发布）者是原创作者或是已经征得著作权人的同意并与著作权人就相关问题做出了妥善处理。内容上传（发布）者担保对利用本站服务上传、传播的内容负全部法律责任，本站不负担任何责任。
<br>6.2 本网站发布的各类数字产品文档，访问者在本网站发表的观点以及以链接形式推荐的其他网站内容，仅为提供更多信息以参考使用或者学习交流，并不代表本网站观点，也不构成任何销售建议。
<br>6.3以下情形导致的个人信息泄露，本站免责： 
<br>（1）政府部门、司法机关等依照法定程序要求本站披露个人资料时，本站将根据执法单位之要求或为公共安全之目的提供个人资料； 
<br>（2）由于用户将个人密码告知他人或与他人共享注册账户，由此导致的任何个人资料泄露； 
<br>（3）任何由于计算机问题、黑客攻击、计算机病毒侵入或发作、因政府管制而造成的暂时性关闭等影响网络正常经营的不可抗力而造成的个人资料泄露、丢失、被盗用或被窜改等； 
<br>（4）由于与本站链接的其他网站所造成之个人资料泄露； 
<br>6.4 本站若因线路及本站控制范围外的硬件故障或其它不可抗力而导致暂停服务，暂停服务期间给用户造成的一切损失，本站不承担任何法律责任。
<br>6.5 除本站注明之服务条款外，其他一切因使用本站而引致之任何意外、疏忽、诽谤、版权或知识产权侵犯及其所造成的损失（包括因下载而感染电脑病毒），本站不承担任何法律责任。 
<br>6.6 为方便您使用，本站服务可能会提供与第三方国际互联网网站或资源进行链接。除非另有声明，本站无法对第三方网站服务进行控制，您因使用或依赖上述网站或资源所产生的损失或损害，本站不负担任何责任。
<br>
<br>7. 版权政策
<br>本站根据用户指令提供内容上传、传播的信息网络存储空间，我们充分尊重原创作者的著作权和知识产权。根据《中国人民共和国版权法》、《信息网络传播权保护条例》、《互联网著作权行政保护办法》等相关法律、法规的规定，本站针对网络侵权采取如下版权政策：
<br>（1）本站对网络版权保护尽合理、审慎的义务，在有理由确信有任何明显侵犯任何第三人版权的内容存在时，有权不事先通知随时删除该侵权内容；
<br>（2）在接到符合法定要求的版权通知时，迅速删除涉嫌侵权内容；
<br>（3）采取必要的技术措施，尽量防止相同侵权内容的再次上传；
<br>（4）对有证据证明反复上传侵权内容的用户随时停止提供网络存储空间的技术服务和信息发布服务。
<br>
<br>8. 服务终止
<br>8.1 您同意本站有权基于其自行之考虑，因任何理由，包括但不限于缺乏使用或本站认为您已经违反本协议的文字及精神，而终止您的账号或服务之全部或任何部分，并将您在本站的服务内的任何内容加以移除并删除；
<br>8.2 您同意依本协议任何规定提供之服务，无需进行事先通知即可中断或终止，您承认并同意，本站可立即关闭或删除您的账号及您账号中所有相关信息及文件，及/或禁止继续使用前述文件或本站的服务。
此外，您同意若本站的服务之使用被中断、终止或您的账号及相关信息和文件被关闭、删除，本站对您或任何第三人均不承担任何责任。
<br>
<br>9. 其他
<br>请确认您已仔细阅读了本服务条款，接受本站服务条款全部内容，成为本站的正式用户。用户在享受本站服务时必须完全、严格遵守本服务条款。 
<br>本服务条款的所有解释权归本站所有。
<br>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Cancel
						</button>
						<button type="button" class="btn btn-primary" id="i-agree">
							<i class="fa fa-check"></i> I Agree
						</button>
						
						<button type="button" class="btn btn-danger pull-left" id="print">
							<i class="fa fa-print"></i> Print
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>-->

	    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script> if (!window.jQuery) { document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');} </script>

	    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script> if (!window.jQuery.ui) { document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');} </script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->		
		<script src="js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="js/smartwidgets/jarvis.widget.min.js"></script>
		
		<!-- EASY PIE CHARTS -->
		<script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>
		
		<!-- SPARKLINES -->
		<script src="js/plugin/sparkline/jquery.sparkline.min.js"></script>
		
		<!-- JQUERY VALIDATE -->
		<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>
		
		<!-- JQUERY SELECT2 INPUT -->
		<script src="js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
		
		<!-- browser msie issue fix -->
		<script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script>
		
		<!-- FastClick: For mobile devices -->
		<script src="js/plugin/fastclick/fastclick.js"></script>
		
		<!--[if IE 7]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->
		
		<!-- MAIN APP JS FILE -->
		<script src="js/app.js"></script>

		<script type="text/javascript">
			runAllForms();
			
			// Model i agree button
			$("#i-agree").click(function(){
				$this=$("#terms");
				if($this.checked) {
					$('#myModal').modal('toggle');
				} else {
					$this.prop('checked', true);
					$('#myModal').modal('toggle');
				}
			});
			
			// Validation
			$(function() {
				// Validation
				$("#smart-form-register").validate({

					// Rules for form validation
					rules : {
						username : {
							required : true
						},
						email : {
							required : true,
							email : true
						},
						password : {
							required : true,
							minlength : 3,
							maxlength : 20
						},
						passwordConfirm : {
							required : true,
							minlength : 3,
							maxlength : 20,
							equalTo : '#password'
						},
						firstname : {
							required : true
						},
						lastname : {
							required : true
						},
						gender : {
							required : true
						},
						terms : {
							required : true
						}
					},

					// Messages for form validation
					messages : {
						login : {
							required : 'Please enter your login'
						},
						email : {
							required : 'Please enter your email address',
							email : 'Please enter a VALID email address'
						},
						password : {
							required : 'Please enter your password'
						},
						passwordConfirm : {
							required : 'Please enter your password one more time',
							equalTo : 'Please enter the same password as above'
						},
						firstname : {
							required : 'Please select your first name'
						},
						lastname : {
							required : 'Please select your last name'
						},
						gender : {
							required : 'Please select your gender'
						},
						terms : {
							required : 'You must agree with Terms and Conditions'
						}
					},

					// Ajax form submition
					submitHandler : function(form) {
						$(form).ajaxSubmit({
							success : function() {
								$("#smart-form-register").addClass('submited');
							}
						});
					},

					// Do not change code below
					errorPlacement : function(error, element) {
						error.insertAfter(element.parent());
					}
				});

			});
		</script>

	</body>
</html>