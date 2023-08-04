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


/*	var tab = $('.boardtab>li');
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
	});*/

	$(function() {
      // 페이징을 처리하는 함수
      function handlePagination() {
        // 현재 페이지 번호를 가져온다.
        var currentPage = 1;
        if ($(this).hasClass("prev")) {
          currentPage--;
        } else if ($(this).hasClass("next")) {
          currentPage++;
        }

        // 페이지 번호에 해당하는 목록을 표시한다.
        $.ajax({
          url: "/board/list?page=" + currentPage,
          success: function(data) {
            $(".boardDataWrap1").html(data);
          }
        });
      }

      // 페이징 버튼에 이벤트를 등록한다.
      $(".pagination a").on("click", handlePagination);
    });

});

