<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="/header.jsp"/>

<!-- 테이블메뉴 스크립트 시작--> 
<script language="javascript">  
         
        function clickblock(num)  
        {  
                for (i=1;i<8;i++)  {      //8 수는 줄수보다 1 더한값을 적어주세요//
                 var left_menu=eval("block"+i+".style");                                                    
                 if (num==i) {  
                  if (left_menu.display=="block") { 
       left_menu.display="none";   
                  }else{  
                   left_menu.display="block";
                  }  
                 }else {
      left_menu.display="none";
     }  
                }  
        }  

</script> 

<h2 class="faq-title">자주 묻는 질문</h2>
<br>
여러분들의 궁금한 사항이나 이용에 대한 불편을 한데모아 놓았습니다.<br>

<table width="700" cellSpacing="0" cellPadding="0" borderColorDark="#ffffff" borderColorLight="#A1C5B9" border="1">
 <br>
      <tr bgcolor="#EEF4F2">
                          <td class="faq-table-tr faq-table faq-table-round" width="590" style="CURSOR:hand" onclick="clickblock(1)"><b>Q1.거래 중에 판매자와 연락이 두절되면 어떻게 해야 하나요?</b><br></td>
                          </tr>
                     
      
      <tr id="block1" style="display:none">
                          <td class="faq-table-tr faq-table-round">▶  borabora(주)는 통신판매 중계자로서 해당 거래의 당사자가 아닙니다. 따라서 거래시 판매자의 인적,연락 사항을 꼼꼼히 기록하셔야 합니다.</td>
                          </tr>       
        
        
        
      <tr bgcolor="#EEF4F2">
                          <td class="faq-table-tr faq-table faq-table-round" width="590" style="CURSOR:hand" onClick="clickblock(2)"><b>Q2.상품 등록 시 유의사항이 있나요?</b></td>
                          </tr>
                        
      
      <tr id="block2" style="display:none">
                          <td class="faq-table-tr faq-table-round">▶ 이용 규칙이나 법률에 위반되는 상품(ex 마약,도박류)의 판매는 금지되거나 이용정지 될 수 있으며 형사 처벌도 가능합니다. </td>
                          </tr>
        
        
        <tr bgcolor="#EEF4F2">
                          <td class="faq-table-tr faq-table faq-table-round" width="590" style="CURSOR:hand" onClick="clickblock(3)"><b>Q3.직거래 주의사항은 어떤 것들이 있나요?</b></td>
                          </tr>
                        
      
      <tr id="block3" style="display:none">
                          <td class="faq-table-tr faq-table-round">▶ 직거래란 판매자와 구매자가 물품과 물품대금을 직접 주고받는 행위를 말합니다.<br>
                           borabora(주)에서는 매매보호장치가 별도로 없기 때문에 큰 금액의 거래시 판매자의 주민번호,거래내역,연락처를 필히 저장하시길 권고드립니다.</td>
                          </tr>
        
        
        
        
        <tr bgcolor="#EEF4F2">
                          <td class="faq-table-tr faq-table faq-table-round" width="590" style="CURSOR:hand" onClick="clickblock(4)"><b>Q4.줄서기 기능이 무엇인가요?</b></td>
                          </tr>
                        
      
      <tr id="block4" style="display:none">
                          <td class="faq-table-tr faq-table-round">▶ 현재 거래가 진행중인 상품이 불발되었을 경우, 구매를 원하시는 분들에게 선착순으로 기회를 드리는 제도입니다. <br>
                                 줄서기 버튼을 눌러 놓으시면 실시간으로 해당 상품의 정보를 얻으실 수 있습니다.  </td>
                          </tr>
        
        
        
        
        <tr bgcolor="#EEF4F2">
                          <td class="faq-table-tr faq-table faq-table-round" width="590" style="CURSOR:hand" onClick="clickblock(5)"><b>Q5.판매중이던 상품이 없어졌어요 ㅜ</b></td>
                          </tr>
                        
      
      <tr id="block5" style="display:none">
                          <td class="faq-table-tr faq-table-round">▶ 등록된 상품이 불법이거나 부적합한 내용이 포함되어 있을경우 이에대한 조치로 해당 상품은 판매금지 됩니다. <br>
                                 사안에 따라 아이디가 이용정지 당할수도 있으니 불법제품은 상품등록을 불허합니다.</td>
                          </tr>
        
        
        
        <tr bgcolor="#EEF4F2">
                          <td class="faq-table-tr faq-table faq-table-round" width="590" style="CURSOR:hand" onClick="clickblock(6)"><b>Q6.유명인의 사진,동영상,캡쳐이미지를 사용하면 안되나요?</b></td>
                          </tr>
                        
      
      <tr id="block6" style="display:none">
                          <td class="faq-table-tr faq-table-round">▶ 유명인의 저작권 침해에 관한 사항에 대해 borabora(주)는 책임지지 않습니다.</td>
                          </tr>
        
        
        <tr bgcolor="#EEF4F2">
                          <td class="faq-table-tr faq-table faq-table-round" width="590" style="CURSOR:hand" onClick="clickblock(7)"><b>Q7.불법 판매자 소송시 필요한 서류는 무엇인지요?</b></td>
                          </tr>
                        
      
      <tr id="block7" style="display:none">
                          <td class="faq-table-tr faq-table-round">▶ 거래사실 증명서(판매자 또는 구매자의 발생된 거래에 대해 본인 증명을 하는 증빙 서류 입니다.)</td>
                          </tr>
        
                  </table>
 

   <!-- FAQ 끝 -->

<jsp:include page="/footer.jsp"/>