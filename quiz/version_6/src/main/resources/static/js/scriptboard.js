$(function(){
		var guideClass = 'mute';                    
	
	$('.guideText').each(function(){
		var guideText = this.defaultValue;
		var element = $(this);
		element.focus(function(){
			if(element.val()===guideText){      
				element.val('');                
				element.removeClass(guideClass);   
			}
		}).blur(function(){                       
			if(element.val()===''){             
				element.val(guideText);         
				element.addClass(guideClass);      
			}
		});
		if(element.val()===guideText){          
			element.addClass(guideClass);
		};
	});


	var tab = $('.boardtab>li');
	tab.eq(0).addClass('active');
	var content = $('.boardWrap>div');
	content.hide();
	content.eq(0).show();
	tab.click(function(e){
		e.preventDefault();
		var tg = $(this);
		var i = tg.index();
		tab.removeClass('active');
		tg.addClass('active');
		content.css('display','none');
		content.eq(i).css('display','block');
	});

});

