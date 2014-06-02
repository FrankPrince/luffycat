jQuery(function($){
	
	$('.img_draw').click(function(){
		if(!(this.src.indexOf('main')>=0)){
			$('#img1').attr('src',this.src.replace('thumb','main'));
		}
	});
	var default_width = 744;
	var default_top = 465;
	var default_left = 70;
	var image_width = 600;
	var image_height = 650;
	
	var default_left_2 = 85;
	var default_left_3 = 200;
	var default_left_4 = 315;
	var default_left_5 = 430;
	var default_left_6 = 550;
	var default_width_2 = 100;
	var default_top_2 = 1140;
	if(!$('#input_is_load').val()){
		var real_width = Number($('#div_profile_details').css('width').replace('px',''));
		var ratio = real_width / default_width;
		$('#img1').css('width',ratio*image_width+'px');
		$('#img1').css('top',ratio*default_top+'px');
		$('#img1').css('left',ratio*default_left+'px');
		$('#img2').css('width',ratio*default_width_2+'px');
		$('#img2').css('top',ratio*default_top_2+'px');
		$('#img2').css('left',ratio*default_left_2+'px');
		$('#img3').css('width',ratio*default_width_2+'px');
		$('#img3').css('top',ratio*default_top_2+'px');
		$('#img3').css('left',ratio*default_left_3+'px');
		$('#img4').css('width',ratio*default_width_2+'px');
		$('#img4').css('top',ratio*default_top_2+'px');
		$('#img4').css('left',ratio*default_left_4+'px');
		$('#img5').css('width',ratio*default_width_2+'px');
		$('#img5').css('top',ratio*default_top_2+'px');
		$('#img5').css('left',ratio*default_left_5+'px');
		$('#img6').css('width',ratio*default_width_2+'px');
		$('#img6').css('top',ratio*default_top_2+'px');
		$('#img6').css('left',ratio*default_left_6+'px');
		$('#input_is_load').val(true);
		$('#ratio').val(ratio);
	}else{
		var ratio = $('#ratio').val();
		$('#img1').css('width',ratio*image_width+'px');
		$('#img1').css('top',ratio*default_top+'px');
		$('#img1').css('left',ratio*default_left+'px');
		$('#img2').css('width',ratio*default_width_2+'px');
		$('#img2').css('top',ratio*default_top_2+'px');
		$('#img2').css('left',ratio*default_left_2+'px');
		$('#img3').css('width',ratio*default_width_2+'px');
		$('#img3').css('top',ratio*default_top_2+'px');
		$('#img3').css('left',ratio*default_left_3+'px');
		$('#img4').css('width',ratio*default_width_2+'px');
		$('#img4').css('top',ratio*default_top_2+'px');
		$('#img4').css('left',ratio*default_left_4+'px');
		$('#img5').css('width',ratio*default_width_2+'px');
		$('#img5').css('top',ratio*default_top_2+'px');
		$('#img5').css('left',ratio*default_left_5+'px');
		$('#img6').css('width',ratio*default_width_2+'px');
		$('#img6').css('top',ratio*default_top_2+'px');
		$('#img6').css('left',ratio*default_left_6+'px');
	}
});