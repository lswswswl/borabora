(function($) {
    /**
	 * Default English package. It's included in the dist, so you do NOT need to
	 * include it to your head tag The only reason I put it here is that you can
	 * clone it, and translate it into your language
	 */

	$.fn.bootstrapValidator.i18n = $.extend(true, $.fn.bootstrapValidator.i18n, {
    	 base64: {  'default': '유효한 Base64 인코딩을 입력하십시오'
    	 }, 
         between: { 
             'default': '%s에서 %s 사이에 입력하십시오', 
             notInclusive: '엄밀히 %s에서 %s 사이에 입력하십시오' 
         }, 
         callback: { 
             'default': '유효한 값을 입력하십시오', 
         }, 
         choice: { 
             'default': '유효한 값을 입력하십시오', 
             less: '최소한 %s을 선택하십시오', 
             more: '최대에서도 %s을 선택하십시오', 
             between: '%s - %s에서 선택하십시오' 
         }, 
         creditCard: { 
             'default': '유효한 신용 카드 번호를 입력하십시오' 
         }, 
         cusip: { 
             'default': '유효한 CUSIP 번호를 입력하십시오' 
         }, 
         cvv: { 
             'default': '유효한 CVV 번호를 입력하십시오' 
         }, 
         date: { 
             'default': '유효한 날짜를 입력하십시오. ' 
         }, 
         different: { 
             'default': '다른 값을 입력하십시오' 
         },
         digits: { 
              'default': '숫자 만 입력하십시오' 
         }, 
         ean: { 
             'default': '유효한 EAN 코드를 입력하십시오' 
         }, 
         emailAddress: { 
             'default': '유효한 이메일 주소를 입력하십시오' 
         }, 
         file: { 
             'default': '올바른 파일을 선택하십시오' 
         }, 
         greaterThan: { 
             'default': '%s보다 큰 값을 입력하십시오', 
             notInclusive: '%s보다 큰 값을 입력하십시오' 
         }, 
         grid: { 
             'default': '유효한 GRId 코드를 입력하십시오' 
         }, 
         hex: { 
             'default': '유효한 16 진수를 입력하십시오. ' 
         }, 
         hexColor: { 
             'default': '올바른 색상 코드 (RGB 16 진수)을 입력하십시오' 
         }, 
         iban: { 
             'default': '유효한 IBAN 코드를 입력하세요', 
             countryNotSupported: '국가 코드 %s는 지원되지 않습니다', 
             country: '효과적인 %s의 IBAN 코드를 입력하세요', 
             countries: { 
                 AD: '안도라', 
                 AE: '아랍 에미리트', 
                 AL: '알바니아', 
                 AO: '앙골라', 
                 AT: '오스트리아', 
                 AZ: '아제르바이잔', 
                 BA: '보스니아 헤르체고비나', 
                 BE: '벨기에', 
                 BF: '부르 키나 파소', 
                 BG: '불가리아', 
                 BH: '바레인', 
                 BI: '부룬디', 
                 BJ: '베냉', 
                 BR: '브라질', 
                 CH: '스위스', 
                 CI: '코트 디부 아르', 
                 CM: '카메룬', 
                 CR: '코스타리카', 
                 CV: '카보', 
                 CY: '키프로스', 
                 CZ: '체코', 
                 DE: '독일',
                 DK: '덴마크', 
                 DO: '도미니카 공화국', 
                 DZ: '알제리', 
                 EE: '에스토니아', 
                 ES: '스페인', 
                 FI: '핀란드', 
                 FO: '페로 제도', 
                 FR: '프랑스', 
                 GB: '영국', 
                 GE: '조지아', 
                 GI: '지브롤터', 
                 GL: '그린 랜드', 
                 GR: '그리스', 
                 GT: '과테말라', 
                 HR: '크로아티아', 
                 HU: '헝가리', 
                 IE: '아일랜드', 
                 IL: '이스라엘', 
                 IR: '이란', 
                 IS: '아이스 랜드', 
                 IT: '이탈리아', 
                 JO: '요르단', 
                 KW: '쿠웨이트', 
                 KZ: '카자흐스탄', 
                 LB: '레바논', 
                 LI: '리히텐슈타인', 
                 LT: '리투아니아', 
                 LU: '룩셈부르크', 
                 LV: '라트비아', 
                 MC: '모나코', 
                 MD: '몰도바', 
                 ME: '몬테네그로', 
                 MG: '마다가스카르', 
                 MK: '마케도니아', 
                 ML: '마리', 
                 MR: '모리타니', 
                 MT: '몰타', 
                 MU: '모리셔스', 
                 MZ: '모잠비크', 
                 NL: '네덜란드', 
                 NO: '노르웨이', 
                 PK: '파키스탄', 
                 PL: '폴란드', 
                 PS: '팔레스타인', 
                 PT: '포르투갈', 
                 QA: '카타르', 
                 RO: '루마니아', 
                 RS: '세르비아',
                 SA: '사우디', 
                 SE: '스웨덴', 
                 SI: '슬로베니아', 
                 SK: '슬로바키아', 
                 SM: '산 마리노', 
                 SN: '세네갈', 
                 TN: '튀니지', 
                 TR: '터키', 
                 VG: '영국령 버진 아일랜드' 
             } 
         }, 
         id: { 
             'default': '유효한 ID를 입력하십시오', 
             countryNotSupported: '국가 코드 %s는 지원되지 않습니다', 
             country: '효과적인 %s의 ID를 입력하십시오', 
             countries: { 
                 BA: '스니아 헤르체고비나', 
                 BG: '불가리아',
                 BR: '브라질', 
                 CH: '스위스', 
                 CL: '칠레', 
                 CZ: '체코', 
                 DK: '덴마크', 
                 EE: '에스토니아', 
                 ES: '스페인', 
                 FI: '핀란드',
                 HR: '크로아티아', 
                 IE: '아일랜드', 
                 IS: '아이스 랜드', 
                 LT: '리투아니아', 
                 LV: '라트비아', 
                 ME: '몬테네그로', 
                 MK: '마케도니아', 
                 NL: '네덜란드', 
                 RO: '루마니아', 
                 RS: '세르비아', 
                 SE: '스웨덴', 
                 SI: '슬로베니아', 
                 SK: '슬로바키아', 
                 SM: '산 마리노', 
                 ZA: '남아프리카 공화국' 
             } 
         }, 
         identical: { 
             'default': '같은 값을 입력하십시오' 
         }, 
         imei: { 
             'default': '유효한 IMEI를 입력하십시오' 
         }, 
         imo: { 
             'default': '유효한 IMO를 입력하십시오' 
         }, 
         integer: { 
             'default': '유효한 숫자를 입력하십시오' 
         }, 
         ip: { 
             'default': '유효한 IP 주소를 입력하십시오', 
             ipv4: '유효한 IPv4 주소를 입력하십시오', 
             ipv6: '유효한 IPv6 주소를 입력하십시오' 
         }, 
         isbn: { 
             'default': '유효한 ISBN 번호를 입력하십시오' 
         }, 
         isin: { 
             'default': '유효한 ISIN 번호를 입력하십시오' 
         }, 
         ismn: { 
             'default': '유효한 ISMN 번호를 입력하십시오' 
         }, 
         issn: { 
             'default': '유효한 ISSN 번호를 입력하십시오' 
         }, 
         lessThan: { 
             'default': '%s 미만의 값을 입력하십시오', 
             notInclusive: '%s 미만의 값을 입력하십시오' 
         }, 
         mac: { 
             'default': '올바른 MAC 주소를 입력하십시오' 
         }, 
         meid: { 
             'default': '유효한 MEID 번호를 입력하십시오' 
         }, 
         notEmpty: { 
             'default': '값을 입력하십시오' 
         }, 
         numeric: { 
             'default': '유효한 부동 소수점 숫자를 입력하십시오. ' 
         }, 
         phone: { 
             'default': '유효한 전화 번호를 입력하십시오', 
             countryNotSupported: '국가 코드 %s는 지원되지 않습니다', 
             country: '효과적인 %s의 전화 번호를 입력하십시오', 
             countries: { 
                 BR: '브라질', 
                 ES: '스페인', 
                 FR: '프랑스', 
                 GB: '영국', 
                 MA: '모로코', 
                 PK: '파키스탄', 
                 US: '미국' 
             } 
         }, 
         regexp: { 
             'default': '정규 표현식에 일치하는 값을 입력하십시오' 
         }, 
         remote: { 
             'default': '유효한 값을 입력하십시오. ' 
         }, 
         rtn: { 
             'default': '유효한 RTN 번호를 입력하십시오' 
         }, 
         sedol: { 
             'default': '유효한 SEDOL 번호를 입력하십시오' 
         }, 
         siren: { 
             'default': '유효한 SIREN 번호를 입력하십시오' 
         }, 
         siret: { 
             'default': '유효한 SIRET 번호를 입력하십시오' 
         }, 
         step: { 
             'default': '%s의 효과적인 조치를 입력하십시오' 
         }, 
         stringCase: { 
             'default': '문자 만 입력하십시오', 
             upper: '대문자로 입력하십시오' 
         }, 
         stringLength: { 
             'default': '유효한 길이 값을 입력하십시오', 
             less: '%s 자 미만으로 입력하십시오', 
             more: '%s 문자보다 크게 입력하십시오', 
             between: '%s 문자에서 %s 문자까지 입력하십시오' 
         }, 
         uri: { 
             'default': '유효한 URI를 입력하십시오. ' 
         }, 
         uuid: { 
             'default': '유효한 UUID를 입력하십시오', 
             version: '유효한 버전 %s UUID를 입력하십시오' 
         }, 
         vat: { 
             'default': '유효한 VAT 번호를 입력하십시오', 
             countryNotSupported: '국가 코드 %s는 지원되지 않습니다', 
             country: '효과적인 %s의 VAT 번호를 입력하십시오', 
             countries: { 
                 AT: '오스트리아', 
                 BE: '벨기에', 
                 BG: '불가리아', 
                 BR: '브라질', 
                 CH: '스위스', 
                 CY: '키프로스 등', 
                 CZ: '체코', 
                 DE: '독일', 
                 DK: '덴마크', 
                 EE: '에스토니아', 
                 ES: '스페인', 
                 FI: '핀란드', 
                 FR: '프랑스', 
                 GB: '영국', 
                 GR: '그리스', 
                 EL: '그리스', 
                 HU: '헝가리', 
                 HR: '크로아티아', 
                 IE: '아일랜드', 
                 IS: '아이스 랜드', 
                 IT: '이탈리아', 
                 LT: '리투아니아', 
                 LU: '룩셈부르크', 
                 LV: '라트비아', 
                 MT: '몰타', 
                 NL: '네덜란드', 
                 NO: '노르웨이', 
                 PL: '폴란드', 
                 PT: '포르투갈', 
                 RO: '루마니아', 
                 RU: '러시아', 
                 RS: '세르비아', 
                 SE: '스웨덴', 
                 SI: '슬로베니아', 
                 SK: '슬로바키아', 
                 VE: '베네수엘라', 
                 ZA: '남아프리카 공화국' 
             } 
         }, 
         vin: { 
             'default': '유효한 VIN 번호를 입력하십시오' 
         }, 
         zipCode: { 
             'default': '올바른 우편 번호를 입력하십시오', 
             countryNotSupported: '국가 코드 %s는 지원되지 않습니다', 
             country: '효과적인 %s를 입력하십시오', 
             countries: { 
                 BR: '브라질 우편 번호', 
                 CA: '캐나다 우편 번호', 
                 DK: '덴마크의 우편 번호', 
                 GB: '영국 우편 번호', 
                 IT: '이탈리아 우편 번호', 
                 MA: '모로코의 우편 번호', 
                 NL: '네덜란드 우편 번호', 
                 SE: '스위스 우편 번호', 
                 SG: '싱가포르 우편 번호', 
                 US: '미국 우편 번호' 
             } 
         } 
     }); 
}(window.jQuery));