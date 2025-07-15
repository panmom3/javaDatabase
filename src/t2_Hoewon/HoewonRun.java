package t2_Hoewon;

public class HoewonRun {
	public static void main(String[] args) {
		HoewonDAO dao = new HoewonDAO();
		
		// '홍길동' hoewon자료 검색
		HoewonVO vo = dao.getNameSearch("홍길동");
		
		System.out.println("==> 검색 결과 : ");
		if(vo != null) System.out.println("vo : " + vo);
		else System.out.println("검색한 자료가 없습니다.");
		
		dao.connClose();
	}
}
