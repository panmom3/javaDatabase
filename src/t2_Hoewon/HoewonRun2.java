package t2_Hoewon;

import java.util.Scanner;

public class HoewonRun2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoewonDAO dao = new HoewonDAO();
		boolean run = true;
		
		while(run) {
			System.out.print("==> 1:회원가입  2:개별조회  3:회원삭제  0:종료? ");
			int choice = scanner.nextInt();
			String name = "";
			switch (choice) {
				case 1:
					// 회원 가입
					System.out.print("회원가입할 성명을 입력하세요? ");
					name = scanner.next();
					
					dao.setHoewonInput(name);
					
					System.out.println("==> 회원가입 완료 : ");
					break;
				case 2:
					// '홍길동' hoewon자료 검색
					System.out.print("검색할 성명을 입력하세요? ");
					name = scanner.next();
					
					HoewonVO vo = dao.getNameSearch(name);
					
					System.out.println("==> 검색 결과 : ");
					if(vo != null) System.out.println("vo : " + vo);
					else System.out.println("검색한 자료가 없습니다.");
					break;
				case 3:
					// 회원 삭제
					System.out.print("삭제할 성명을 입력하세요? ");
					name = scanner.next();
					
					int res = dao.setHoewonDelete(name);
					
					if(res != 0) System.out.println("==> 삭제완료 ");
					else System.out.println("==> 삭제할 자료가 없습니다.");
					break;
				default:
					run = false;
			}
		}
		System.out.println("작업을 종료합니다.......");
		
		dao.connClose();
		scanner.close();
	}
}
