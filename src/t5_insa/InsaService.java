package t5_insa;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;
	// 오늘 날짜 구하기
	public InsaVO getCurrentDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance();      //서비스 객체
		vo.setCbYY(cal.get(Calendar.YEAR)+"");
		vo.setCbMM((cal.get(Calendar.MONTH) + 1)+"");
		vo.setCbDD(cal.get(Calendar.DATE)+"");
		
		return vo;
	}
	
}
