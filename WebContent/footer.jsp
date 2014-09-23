<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<hr>

<footer>
  <p>&copy; Company 2014</p>
</footer>
</div> <!-- /container -->        

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form id="loginForm" class="bv-form" action="loginJson.action" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">로그인을 해주세요.</h4>
      </div>
      <div class="modal-body">
      	<style type="text/css">
		#profileForm .form-control-feedback {
		    top: 35px;
		    right: 0px;
		}
		</style>
		    <div class="form-group">
		        <label>Email address</label>
		        <input type="email" class="form-control" name="email" required/>
		    </div>
		    <div class="form-group">
		        <label>Password</label>
		        <input type="password" class="form-control" name="password" required/>
		    </div>
        <a href="signupForm.action">*혹시 아직 회원이 아니신가요?</a>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-round-sm2" data-dismiss="modal">취소하기</button>
        <button type="submit" class="btn btn-round-sm1">로그인하기</button>
      </div>
      </form>
    </div>
  </div>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')</script>

  <script src="js/vendor/bootstrap.min.js"></script>
  <script src="js/bootstrapValidator.min.js"></script>
  <script src="js/language/ko_KR.js"></script>
  <script src="js/main.js"></script>
</body>
</html>
   