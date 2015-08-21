$(function() {
	// 得到焦点
	$("#password").focus(function() {
		$("#left_hand").animate({
			left : "150",
			top : " -38"
		}, {
			step : function() {
				if (parseInt($("#left_hand").css("left")) > 140) {
					$("#left_hand").attr("class", "left_hand");
				}
			}
		}, 2000);
		$("#right_hand").animate({
			right : "-64",
			top : "-38px"
		}, {
			step : function() {
				if (parseInt($("#right_hand").css("right")) > -70) {
					$("#right_hand").attr("class", "right_hand");
				}
			}
		}, 2000);
	});
	// 失去焦点
	$("#password").blur(function() {
		$("#left_hand").attr("class", "initial_left_hand");
		$("#left_hand").attr("style", "left:100px;top:-12px;");
		$("#right_hand").attr("class", "initial_right_hand");
		$("#right_hand").attr("style", "right:-112px;top:-12px");
	});
});
$('login_btn').on('click', function() {
    $('login_form').on('submit', function() {
        var title = $('inpur[name=title]').val(),
            content = $('textarea').val();
        $(this).ajaxSubmit({
            type: 'post',
            url: 'j_spring_security_check',
            data: {
                'title': title,
                'content': content
            },
            success: function(data) {
                alert('提交成功!');
            }
            $('login_form').reset();
        });
        return false;
    });
});