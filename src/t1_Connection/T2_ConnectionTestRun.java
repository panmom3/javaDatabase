package t1_Connection;

public class T2_ConnectionTestRun {
	public static void main(String[] args) {
		System.out.println("1.main화면 실행~~~~~~");
		T2_ConnectionDAO t2 = new T2_ConnectionDAO();
		//System.out.println("2.t2 서비스 객체를 이용한 작업처리....");
		
		T2_ConnectionService service = new T2_ConnectionService();
		service.t2_method();
		
		t2.connClose();
		System.out.println("3.t2 메인 객체 작업종료....");
	}
}
