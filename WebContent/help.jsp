<%@ page language ="java" contentType="text/html;charset=GB18030" pageEncoding="GB18030" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import ="java.util.ArrayList" %>
<%@page import="LogAction.LoginAction"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> URL Management System</title>
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
		<!--  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">-->
	</head>
<body class="">
		<!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->

		<!-- HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="img/url.jpg" alt="SmartAdmin"> </span>
				<!-- END LOGO PLACEHOLDER -->
				<!-- span id="logo"> <img src="img/logo.png" alt="SmartAdmin"> </span> -->
				<!-- END LOGO PLACEHOLDER -->

				<!-- Note: The activity badge color changes when clicked and resets the number to 0
				Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->


				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
				<div class="ajax-dropdown">

					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					

					<!-- notification content -->
					<div class="ajax-notifications custom-scroll">

						<div class="alert alert-transparent">
							<h4>Click a button to show messages here</h4>
							This blank page message helps protect your privacy, or you can show the first message here automatically.
						</div>

						<i class="fa fa-lock fa-4x fa-border"></i>

					</div>
					<!-- end notification content -->

					
					<!-- end footer -->

				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>


			<!-- pulled right: nav area -->
			<div class="pull-right">

				

				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end search mobile button -->

				
				<!-- end input: search field -->
				

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		<aside id="left-panel">

			<!-- User info -->
			<div class="login-info">
				<span> <!-- User image size is adjusted inside CSS, it should stay as it --> 
					
					<a href="javascript:void(0);" id="show-shortcut">
						
						<span>
							<s:property value='email'/>
						</span>
						<i class="fa fa-angle-down"></i>
					</a> 
					
				</span>
			</div>
			<!-- end user info -->

			<!-- NAVIGATION : This navigation is also responsive

			To make this navigation dynamic please make sure to link the node
			(the reference to the nav > ul) after page load. Or the navigation
			will not initialize.
			-->
			<nav>
				<ul>
					<li>
						<a href='<s:url action="main"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Home</span></a>
					</li>
						
					<li>
						<a href='<s:url action="Allinformation"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-table"></i> <span class="menu-item-parent">Look Information</span></a>
						
					</li>
					<li>
						<a href='<s:url action="Addhref"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-calendar"></i> <span class="menu-item-parent">Add New Url</span></a>
					</li>
									
					<li>
						<a href='<s:url action="searchref"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-desktop"></i> <span class="menu-item-parent">Search By UrlTag</span></a>
					</li>
					<li>
						<a href='<s:url action="helphref"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-inbox"></i> <span class="menu-item-parent">Help Information</span></a>
					</li>
					
					<li>
						<a href="login.jsp"><i class="fa fa-lg fa-fw fa-pencil-square-o"></i> <span class="menu-item-parent">Logout</span></a>
					</li>
					
				</ul>
			</nav>
			<span class="minifyme"> <i class="fa fa-arrow-circle-left hit"></i> </span>

		</aside>
		<!-- END NAVIGATION -->


		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">

				<span class="ribbon-button-alignment"> <span id="refresh" class="btn btn-ribbon" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true"><i class="fa fa-refresh"></i></span> </span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Home</li><li>Help Information</li>
				</ol>
				<!-- end breadcrumb -->

				<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

			</div>
			<!-- END RIBBON -->
			<!-- MAIN CONTENT -->
			<div id="content">
				
				<!-- widget grid -->
				<section id="widget-grid" class="">
				
				<!-- START ROW -->
				
				<h1  size="50">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome Use Internet </h1>
					<div class="row">
				
						<!-- NEW COL START -->
						 
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget" id="wid-id-1" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
								
				
								<!-- widget div-->
								<h1>This is an introduction to our product and help you to know how to use it</h1>
								<h2>How we work</h2>
								<h2>Our product aims at help those who don't want to check websites everyday, but they want to pay attention to some news or answers for some questions which they are interested in. After registering and adding URLS, we will send an email depends on the URLS that you've added.The email contain all the new information on the websites you have added. Yeah! all new information, it means that if you add an question's URLS from tieba or other website, we will send the message which is just answered after the last time we have sent an email to you.  
								<h2>If you want to use this product, you can follow these steps</h2>
								<h2>1.Register</h2>
								<h3>When you access our website, you can see a button has "CREATE AN ACCOUNT" on it. Just click that button. After that, the web will turn to register page, what you need to do is filling in your email and set your password.</h3>
									<img src="img/help/creatcnt.png" alt="SmartAdmin">
								<h3>After pressing the button, the web will turn to register page, what you need to do is filling in your email and set your password.</h3>
								<h2>After verifying your accout or login, you will turn to the home page</h2>
									<img src="img/help/home.png" alt="SmartAdmin">
								<h2>All the functions are at the left side of the web</h2>
								<h2>2.Add new URL</h2>
								<h3>The most important thing is to add the URL. When you access this page, you have to add the URL which you are interested in and the tags which can help you manage your URLS if you add lots of URLS on our web.</h3>
									<img src="img/help/add.jpg" alt="SmartAdmin">
								<h2>3.View all URLS</h2>
								<h3>If you want to check or edit the URLS you have added, just click the the "Look Information". If you want to edit or delete one of the URLS just click edit button or delete button.</h3>
									<img src="img/help/all.jpg" alt="SmartAdmin">
								<h2>4.Search by Urltag</h2>
								<h3>If you want to search your URLS by tags to avoid check it one by one, just click the the "Search by URLTag" and input which kind of tag you want to search</h3>
									<img src="img/help/tag.jpg" alt="SmartAdmin">
								
								
			
									<!-- end widget content -->
				
								
								<!-- end widget div -->
				
							</div>
							<!-- end widget -->

					</div>
						<!-- END COL -->
						</section>
						
			</div>
	
			<!-- END MAIN CONTENT -->
				<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');
			}
		</script>

		
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>


		<!-- MAIN APP JS FILE -->
		<script src="js/app.js"></script>

		<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->

		

		<script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
		
		})

		</script>

		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script type="text/javascript">
			var _gaq = _gaq || [];
				_gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
				_gaq.push(['_trackPageview']);
			
			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();

		</script>

</body>
</html>