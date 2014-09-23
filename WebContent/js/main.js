$(function() {
    
    // 댓글 삭제 모달
    $('.btn-del').click(function(){
        var data = $(this).data();
        $("#nop").val(data.nop);
        $("#noc").val(data.noc);
        $('#delModal').modal('show');
    });

    // 사기목록에서 삭제 모달
    $('.buy-del').click(function(){
        var data = $(this).data();
       /* $("#nom").val(data.nom);*/
        $("#nop").val(data.nop);
        $('#delModal').modal('show');
    });
    
    // -추가- 제품 삭제 모달
    $('.btn-delPro').click(function(){
     var data = $(this).data();
     $("#nop").val(data.nop);
     $('#delProModal').modal('show');
    });
    
    
    // 로그인 모달 창
    $('.btn-login').click(function(){
        $('#loginModal').modal('show');
    });
    
     $('#loginForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	
        	email: {
                validators: {
                    notEmpty: {
                        message: '이메일을 입력해 주세요.'
                    }
                }
            },
        
            password: {
                validators: {
                    notEmpty: {
                        message: '비밀번호를 입력해주세요.'
                    }
                }
            }
        }
    }).on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

		var formURL = $form.attr('action');
		console.log('formUrl=',formURL);
		var postData = $form.serialize(); // form 데이터를  js array 형태로 변환
		console.log('postData=',postData);
		
		// jquery ajax api 보기
		$.ajax({
			url: formURL,
			type: "POST",
			data: postData,

			success: function(data, textStatus, jqXHR) {
				console.log('성공');
				alert('안녕하세요! \n환영합니다! ');
				console.log(data);
				console.log(data.msg);
				console.log(textStatus);
				console.log(jqXHR);
			/*	location.href = "main.action";*/
				location.reload();
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log(jqXHR);
				console.log('실패');
				alert('로그인 실패 : \n비밀번호 또는 아이디를 확인해 주세요.');
			}
		});
        
    });
     
     // http://bootstrapvalidator.com/examples/enable-validator/
     $('#productForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            title_p: {
                validators: {
                	notEmpty: {
                        message: '상품명을 입력해 주세요.'
                    },
                    stringLength: {
                        max: 15,
                        message: '상품명은 15글자 이내로 입력해 주세요.'
                    }
                }
            },
            price: {
                validators: {
                    notEmpty: {
                        message: '가격을 입력해 주세요.'
                    },
                    numeric: {
                        message: '숫자를 입력해 주세요.'
                    }
                }
            },
            area: {
            	validators: {
                    stringLength: {
                        max: 15,
                        message: '거래 지역은 15글자 이내로 입력해 주세요.'
                    }
                }
            },
            content_p: {
            	validators: {
            		notEmpty: {
                        message: '상품 설명을 입력해 주세요.'
                    },
                    stringLength: {
                        max: 400,
                        message: '상품 설명은 200글자 이내로 입력해 주세요.'
                    }
                }
            },
            mainupload:{
            	enable: false,
            	validators: {
            		notEmpty: {
                        message: '대표 이미지를 업로드해 주세요.' 
                    }
                }
            }
        }
    }).on('change', '[name="mainupload"]', function() {
        var isEmpty = $(this).val() == '';
        var limit_size = 2723641; //2.5mb
        var input, file;

        // (Can't use `typeof FileReader === "function"` because apparently
        // it comes back as "object" on some browsers. So just see if it's there
        // at all.)
        if (!window.FileReader) {
            alert("The file API isn't supported on this browser yet.");
            return;
        }
        var input = this;
        if (!input) {
            console.log("Um, couldn't find the fileinput element.");
        }
        else if (!input.files) {
            console.log("This browser doesn't seem to support the `files` property of file inputs.");
        }
        else if (!input.files[0]) {
        	console.log("Please select a file before clicking 'Load'");
        }
        else {
            file = input.files[0];
            console.log("File " + file.name + " is " + file.size + " bytes in size");
            if ( file.size > limit_size ){
            	alert('2.5MB 미만의 이미지를 업로드해주세요.');
            	input.value = "";
            	$('#productForm').data('bootstrapValidator').resetField('mainupload', true);
            }
        }
    }).on('change', '[name="uploads"]', function() {
        var isEmpty = $(this).val() == '';
        var limit_size = 2723641; //2.5mb
        var input, file;

        // (Can't use `typeof FileReader === "function"` because apparently
        // it comes back as "object" on some browsers. So just see if it's there
        // at all.)
        if (!window.FileReader) {
            alert("The file API isn't supported on this browser yet.");
            return;
        }
        var input = this;
        if (!input) {
            console.log("Um, couldn't find the fileinput element.");
        }
        else if (!input.files) {
            console.log("This browser doesn't seem to support the `files` property of file inputs.");
        }
        else if (!input.files[0]) {
        	console.log("Please select a file before clicking 'Load'");
        }
        else {
            file = input.files[0];
            console.log("File " + file.name + " is " + file.size + " bytes in size");
            if ( file.size > limit_size ){
            	alert('2.5MB 미만의 이미지를 업로드해주세요.');
            	input.value = "";
            	$('#productForm').data('bootstrapValidator').resetField('uploads', true);
            }
        }
    });
     
     
     $('#signupForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: '이름을 입력해 주세요.'
                    },
                    stringLength: {
                        max: 15,
                        message: '이름은 15글자 이내로 입력해 주세요.'
                    }
        
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '이메일을 입력해 주세요.'
                    }
                }
            },
            phone:{
            	validators: {
                    notEmpty: {
                        message: '휴대폰번호을 입력해 주세요.'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '비밀번호를 입력해주세요.'
                    },
                    stringLength: {
                    	max: 15,
                    	message: '비밀번호는 15글자 이내로 입력해 주세요.'
                    }
                }
            },
            password_check: {
            	validators: {
                    notEmpty: {
                        message: '비밀번호체크를 입력해주세요.'
                    },
                    stringLength: {
                    	max: 15,
                    	message: '비밀번호는 15글자 이내로 입력해 주세요.'
                    }
                }
            },
            nickname: {
            	validators: {
                    stringLength: {
                    	max: 8,
                    	message: '닉네임은 8글자 이내로 입력해 주세요.'
                    }
                }
            }
        }
     }).on('change', '[name="uploads"]', function() {
         var isEmpty = $(this).val() == '';
         var limit_size = 2723641; //2.5mb
         var input, file;

         // (Can't use `typeof FileReader === "function"` because apparently
         // it comes back as "object" on some browsers. So just see if it's there
         // at all.)
         if (!window.FileReader) {
             alert("The file API isn't supported on this browser yet.");
             return;
         }
         var input = this;
         if (!input) {
             console.log("Um, couldn't find the fileinput element.");
         }
         else if (!input.files) {
             console.log("This browser doesn't seem to support the `files` property of file inputs.");
         }
         else if (!input.files[0]) {
         	console.log("Please select a file before clicking 'Load'");
         }
         else {
             file = input.files[0];
             console.log("File " + file.name + " is " + file.size + " bytes in size");
             if ( file.size > limit_size ){
             	alert('2.5MB 미만의 이미지를 업로드해주세요.');
             	input.value = "";
             	$('#signupForm').data('bootstrapValidator').resetField('uploads', true);
             }
         }
     });

     // pure ajax  test
	 $("#login_ajax_form").submit(function(event){
//     $("#loginModal").submit(function(event){
		event.preventDefault(); //기존에 있던 submit 이벤트를 제거
				
		console.log(event);
		console.log('확인 됫지롱 뿌잉');
		console.log('this=',this);
		console.log($(this).html());
		var formURL = $(this).attr('action');
		console.log('formUrl=',formURL);
		var postData = $(this).serializeArray(); // form 데이터를  js array 형태로 변환
		console.log('postData=',postData);
		
		// jquery ajax api 보기
		$.ajax({
			url: formURL,
//			url: "loginJson.action", 해도댐
			type: "POST",
			data: postData,

			success: function(data, textStatus, jqXHR) {
				console.log('성공');
				alert('로그인 성공');
				console.log(data);
				alert(data.msg);
				console.log(textStatus);
				console.log(jqXHR);
//				location.href = "http://www.naver.com"; 이동
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log(jqXHR);
				console.log('실패');
				alert('로그인 실패');
			}
		});
	});
	 
	// jquery ajax api ---- (http://api.jquery.com/jQuery.ajax/)
	// http 요청 --- status code, get, post
	// 유효성 검사에 적용 참고 ----- (http://bootstrapvalidator.com/examples/ajax-submit/)
     
});






