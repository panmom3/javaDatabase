package t5_Hoewon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HoewonService {
	Scanner scanner = new Scanner(System.in);
	HoewonDAO dao = new HoewonDAO();
	HoewonVO vo = null;
	//회원가입 처리
	public void setHoewonInput() {
		String name = "", gender = "", address = "";
		int age;
		
		while(true) {
		// 회원 가입, 각 필드에 유효성 검사 할것~~**
			System.out.print("회원가입할 성명을 입력하세요? ");
			name = scanner.next();
			// name에 대한 유효성 검사..
			
			// 동명2인처리..
			vo = dao.getNameCheck(name);
			if(vo != null) {
				System.out.println("같은 성명이 존재합니다. 다른 이름으로 가입하세요");
			} else break;
		}
		
		System.out.print("회원가입할 나이을 입력하세요? ");
		age = scanner.nextInt();
		//System.out.print("회원가입할 성별을 입력하세요? ");
		//gender = scanner.next();
		System.out.println("성별 선택 : 1.남자, 2:여자");
		int sel = scanner.nextInt();
		gender = sel == 1 ? "남자" : "여자";
		System.out.print("회원가입할 주소을 입력하세요? ");
		address = scanner.next();
		
		//유효성검사가 끝나면 변수를 vo객체에 담아준다.
		vo = new HoewonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		
		int res = dao.setHoewonInput(vo);
		if(res != 0) System.out.println("==> 회원가입 완료 : ");
		else System.out.println("==> 회원가입 실패!! : ");	
	}
	
	//개별조회
	public void getHoewonSearch() {
		System.out.print("검색할 회원번호을 입력하세요? ");
		int idx = scanner.nextInt();
		
		vo = dao.getNameSearch(idx);
		
		System.out.println("==> 검색 결과 : ");
		if(vo != null) {
			subTitle(60);
			System.out.print(vo.getIdx() + "\t" + vo.getName() + "\t" + vo.getAge() + "\t" + vo.getGender() + "\t" + vo.getAddress() + "\n");
		}
		else System.out.println("검색한 자료가 없습니다.");
	}
	
	//회원 삭제
	public void setHoewonDelete() {
		System.out.print("삭제할 성명을 입력하세요? ");
		String name = scanner.next();
		
		int res = dao.setHoewonDelete(name);
		
		if(res != 0) System.out.println("==> 삭제완료 ");
		else System.out.println("==> 삭제할 자료가 없습니다.");
	}
	
	//작업종료
	public void connClose() {
		dao.connClose();
	}
	//전체조회
	public void getHoewonList() {
		int line = 60;
		getMainTitle(line);
		ArrayList<HoewonVO> vos = dao.getHoewonList();
		for(int i=0; i<vos.size(); i++) {
			System.out.print(vos.get(i).getIdx() + "\t" + vos.get(i).getName() + "\t" + vos.get(i).getAge() + "\t" + vos.get(i).getGender() + "\t" + vos.get(i).getAddress() + "\n");
		}
		lineMethod(line);
	}
	//선그리기
	private void lineMethod(int line) {
		System.out.println("=".repeat(line));
	}

	// 회원정보 수정
	public void setHoewonUpdate() {
		int idx = 0;
		boolean run = true;
		while(run) {
			System.out.print("수정할 회원번호를 입력하세요? ");
			try {
				idx = scanner.nextInt();
				run = false;
			} catch (InputMismatchException e) {
				System.out.println("회원번호를 양수값으로 입력하세요....");
				scanner.next();	// scanner.nextInt()로 입력시 예외발생할경우는 catch구문에서 입력버퍼를 삭제처리한다.
			}
		}
		vo = dao.getNameSearch(idx);
		
		System.out.println("==> 검색 결과 : ");
		if(vo != null) {
			subTitle(60);
			System.out.print(vo.getIdx() + "\t" + vo.getName() + "\t" + vo.getAge() + "\t" + vo.getGender() + "\t" + vo.getAddress() + "\n");
		}
		else {
			System.out.println("검색한 자료가 없습니다.");
			return;
		}
		System.out.println();
		
		int choice = 0;
		String content = "";
		while(true) {
			System.out.print("수정할 항목? 1.성명   2.나이   3.성별   4.주소  ==> ");
			choice = scanner.nextInt();
			
			int sel = 1;
			
			if(choice == 3) {
				System.out.println("성별 선택 : 1.남자, 2:여자");
				sel = scanner.nextInt();
				content = sel == 1 ? "남자" : "여자";
			} else {
				System.out.print("수정할 내용? ");
				content = scanner.next();
			}
			
			// 성명을 수정할시는 동명2인이 있는지를 체크해야 한다.
			if(choice == 1) {
				HoewonVO vo2 = dao.getNameCheck(content);
				if(vo2 != null) {
					System.out.println("같은 이름이 존재합니다. 다시 입력하세요");
				} else break;
			}
		}

		int res = dao.setHoewonUpdate(vo.getIdx(), choice, content);   //중복방지 vo.getIdx()
		if(res != 0) System.out.println("==> 회원정보 수정완료 : ");
		else System.out.println("==> 회원정보 수정실패!! : ");	
	}
	
	//리스트 제목 출력
	private void getMainTitle(int line) {
		System.out.println("\n\t\t*** 전 체 회 원 리 스 트");
		subTitle(line);
	}
	//부제목 출력
	private void subTitle(int line) {
		lineMethod(line);
		System.out.println("번호\t성명\t나이\t성별\t주소");
		lineMethod(line);
	}

}
