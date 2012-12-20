jQuery(document).ready(function() {
	simtru.initNavigation();
	simtru.initImageboard();
	simtru.initFileUpload();
});

var simtru = {};

simtru.initNavigation = function() {
	var topNaviDivs = jQuery('#topnavi .navipart');

	topNaviDivs.bind('mouseenter mouseleave', function() {
		var currNavipart = jQuery(this);
		currNavipart.find('.navilink').toggleClass('hover');
		currNavipart.find('.subnavi').toggleClass('hidden');
	});
};

simtru.initImageboard = function() {
	var imageBoxes = jQuery('#pageContent .imagerow .imagebox');
	imageBoxes.bind('mouseenter mouseleave', function() {
		var currImageBox = jQuery(this);
		var currContentBox = currImageBox.find('.content');
		var currImageHeight = currImageBox.find('.image').height();
		currContentBox.height(currImageHeight - 10);

		currImageBox.find('.contentWrapper').toggleClass('hidden hover');
	});
};

simtru.initFileUpload = function() {
	jQuery('#uploadItem').bind('change', function(event) {
		var form = jQuery('#editComment');
		form.find('input[name="isUpload"]').val("true");
		form.submit();
	});
};