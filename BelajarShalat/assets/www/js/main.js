/*!
Intelligent auto-scrolling to hide the mobile device address bar
Optic Swerve, opticswerve.com

*/

var bodyTag;

// Document ready
//----------------
documentReady(function() {
	
	$(".menu_group .menu_item").css("z-index", "100"); // iPhone black border bug fix
	
	// Search box hover active state
	
	$("#menu_item_search_idle").click(function(){
		$(this).fadeOut(function(){
			$("#menu_item_search_active").fadeIn();
		});	
	});	
	
	$("#home_search_reset").click(function(){
	
		$(this).click(function(){
			if($("#home_search_input").val() == "")
			{	
				$("#menu_item_search_active").fadeOut();
				$("#menu_item_search_idle").fadeIn();
			}
		});
		
	});	
	
	
	// Toggle script
	
	$(".container").hide();

	$(".toggle").click(function(){
		$(this).toggleClass("active").next().slideToggle(350);
			return false;
	});	
	
});

// Run specified function when document is ready (HTML5)
//------------------------------------------------------
function documentReady(readyFunction) {
	document.addEventListener('DOMContentLoaded', function() {
		document.removeEventListener('DOMContentLoaded', arguments.callee, false);
		readyFunction();

	}, false);

}
