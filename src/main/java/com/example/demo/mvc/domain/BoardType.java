package com.example.demo.mvc.domain;

/**
 * 게시판 종류
 * @author tr2user
 * 
 * # 장점
 * 1. 불필요한 테이블 및 코드관리가 필요없어진다.
 * 2. 리스트, 상세 조회시 코드에 대한 코드명을 TABLE로 JOIN하거나 FUNCTION을 가져오는 불필요한 쿼리가 없어진다.
 * 3. 쿼리로 안한다면 Front(JSP, Vue.js, React, Native APP, API 등에서 코드명 하드코딩이 없어진다.
 * 4. 위 3개를 통해 결과 나오는 속도가 더 빨라진다.
 * 5. 코드, 코드명 추가/수정/삭제 시 운영서버에 배포만 한다면 DB를 직접 건드리지 않고 자동으로 적용된다.
 * 6. int, String으로 선언한다면 코드에 대해 공백, 자리수, 유효한 값인지 체크 로직이 들어가야 한다. enum은 안해도 된다.
 *    (Enum에 해당하지 않는 값이 들어온다면 Spring에서 에러가 발생)
 * 
 * # 단점
 * 1. 사이트 관리자 및 고객사에서 오픈 이후 코드를 추가, 수정, 삭제가 불가능하다.
 * 2. 코드 추가/수정/삭제는 개발자가 직접 코드를 수정하고 운영서버에 배포하고 재기동을 해야 적용된다.
 * 3. DBMS TOOL에서 직접 INSERT, UPDATE 등을 수행할 때 잘못된 ENUM이 있는 경우 오류가 발생한다.
 * 
 */
public enum BoardType implements BaseCodeLabelEnum {
	
	NOTICE("공지사항"),
	FAQ("자주묻는질문"),
	INQUIRY("1:1문의")
	;
	
	private String code;
	private String label;
	
	BoardType(String label) {
		this.code = name();
		this.label = label;
	}
	
	@Override
	public String code() {
		return code;
	}

	@Override
	public String label() {
		return label;
	}
	
}
