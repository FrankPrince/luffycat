jQuery(function($){
	$('#content').load('./menu_item/draw.luffycat');
	
	$('.a_menu_item').click(function(){
		$('.a_menu_item').each(function(){
			$(this).parent().removeClass('current-menu-item');
		});
		$(this).parent().addClass('current-menu-item');
		$('body').removeClass("nav-expand");
		$('.main-navigation').removeClass("nav-expand");
		$('#content').load(this.href);
		return false;
	});
});