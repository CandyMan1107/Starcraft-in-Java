package Manager;
import java.util.*;

import Attacker.*;
import Species.*;
import Worker.*;
import Building.*;

public class GameManager implements SPECIES {
	
	public ArrayList<Building> myBuild = new ArrayList<Building>(4);
	public ArrayList<Worker> myWorker = new ArrayList<Worker>(8);
	public ArrayList<Attacker> myAttack = new ArrayList<Attacker>();
	public Species mySpe;		//사용자종족
	public int myPlayer;		//사용자구분
	public int myPopul = 10; 	//사용자인구수
	public int myMineral = 0;	//사용자자원량

		
	public GameManager(int player){
		myPlayer = player;
	}
	
	public void createSpecies() {//사용자 종족선택 및 본부체력
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		switch(input){
		case ZERG:
			mySpe = new Zerg(myPlayer);
			myBuild.add(new Nexus(500,mySpe.mainBuildName));
			for(int i = 0; i < 2; i++){
				myWorker.add(new Drone());				
			}
			myMineral = 500;
			break;		
			
		case PROTOSS:
			mySpe = new Protoss(myPlayer);
			myBuild.add(new Nexus(500,mySpe.mainBuildName));
			for(int i = 0; i < 2; i++){
				myWorker.add(new Prove());
			}
			myMineral = 500;
			break;
			
		case TERRAN:
			mySpe = new Terran(myPlayer);
			myBuild.add(new Nexus(500,mySpe.mainBuildName));
			for(int i = 0; i < 2; i++){
				myWorker.add(new SCV());
			}
			myMineral = 500;
			break;
			
		case EXIT:
			return;
		}
	}
	
	public void getMineral(){//미네랄 채취
		Worker.GetMineral(this, 150, myWorker.size());//턴당 일꾼 수만큼 오르는 금액
		System.out.print(myPlayer+"플레이어 턴이 끝났습니다ㅎ..");
	
	}
	
	public int selectMenu(int player,GameManager Enemy){//베이스 선택메뉴

		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int input; 
		
		while(flag){
			GameMenu.showMenu(myPlayer);
			while(true){
				input = scan.nextInt();
				if(input >= 1 && input <= 3)break;
			}
			
			switch(input){
			case 1://건물선택
				useBuild(this);
				break;
			case 2://유닛선택
				useUnit(this,Enemy);
				if(playerWin(Enemy) == true) return 3;
				break;
			case 3://포기 텀넘기기
				return player;
			}
		}
		return player;
	}
	
	public Building selectBuild(){//건물 선택하는 메소드
		System.out.println();
		for (int i=0 ;i<myBuild.size();i++){//건물배열안의 존재하는 목록출력
				System.out.print(myBuild.get(i).name+"|");
		}
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		int selectBuild; 
		while(true){//건물 선택 반복
			System.out.println("건물을 선택하시오!(인구건물은 선택할 수 없습니다.) 1~"+myBuild.size());
			System.out.print("선택 : ");
			selectBuild = scan.nextInt();
			selectBuild--;//입력값을 인덱스값에 맞게 -1
			if(selectBuild >=0 && selectBuild < myBuild.size() && "population" != myBuild.get(selectBuild).type)
				break;//메뉴 1~건물수 선택시/인구건물 제외 반복종료
		}
		
		return myBuild.get(selectBuild); //선택된 건물 반환
	}
	
	public void useBuild(GameManager player){//건물선택 옵션
		boolean flag =true;
		Building build = selectBuild();
		while(flag){//생산을 할시 true로 반복생산 그외에 false로 취소
				
			if(build.type == "center"){
				GameStatus.showStatus(player);
				System.out.print(build.name+"|");
				GameMenu.buildWorkMenu(mySpe);
				flag = createWorker(mySpe.workerName);
				
			}else if(build.type == "production"){
				GameStatus.showStatus(player);
				System.out.print(build.name+"|");
				GameMenu.buildAttackMenu(mySpe);
				flag = createUnit(mySpe.attackerName);
			}
		}
	}
	
	public boolean createWorker(String name){//flag변수에 맞게 불린형 반환
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true){
			input = scan.nextInt();
			if(input ==1 || input ==2 ) break;
		}
		
		switch(input){
		case 1:
			if(myMineral >= Worker.getPrice(mySpe) && myWorker.size() < 8){
				myMineral -= Worker.getPrice(mySpe);
				
				if(name == "드론")myWorker.add(new Drone());
				else if(name == "프로브")myWorker.add(new Prove());
				else if(name == "SCV")myWorker.add(new SCV());
				
				System.out.println(name+"를 생산했습니다.");
				return true;
			}else if(myMineral < Worker.getPrice(mySpe)){
				System.out.println("미네랄이 부족합니다.");
				break;
			}else{
				System.out.println("일꾼이 너무 많습니다.");
				break;
			}
		case 2:
		}
		
		return false;
	}
	public boolean createUnit(String name){//공격유닛 소환


		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true){
			input = scan.nextInt();
			if(input ==1 || input ==2 ) break;
		}
		
		switch(input){
		case 1:
			if(myMineral >= Attacker.getPrice(mySpe) && myPopul > myAttack.size()){
				myMineral -= Attacker.getPrice(mySpe);
				
				if(name == "저글링")myAttack.add(new Zergling());
				else if(name == "질럿")myAttack.add(new Zealot());
				else if(name == "마린")myAttack.add(new Marine());
				
				System.out.println(name+"를 생산했습니다.");
				return true;
			}else if(myMineral < Attacker.getPrice(mySpe)){
				System.out.println("미네랄이 부족합니다.");
				break;
			}else{
				System.out.println("인구가 부족합니다.");
				break;
			}
		case 2:
		}
		
		return false;
	}

	public void useUnit(GameManager player,GameManager Enemy){//유닛선택 옵션
		boolean flag =true;
		Scanner scan = new Scanner(System.in);
		int input;
		//while(flag){//생산을 할시 true로 반복생산 그외에 false로 취소	
			GameStatus.showStatus(player);
			GameMenu.unitMenu(); //유닛 선택메뉴 출력
			input = scan.nextInt();
			
			switch(input){
			case 1://일꾼유닛선택
				flag = unitAttributeMenu(); //일꾼 유닛 옵션메서드
				break;
			case 2://공격유닛선택
				flag = attackUnitAttributeMenu(player,Enemy); //공격 유닛 옵션메서드
				break;
			case 3:	//취소하기
				flag = false;
				break;
			default:
			}
			
		//}
	}
	
	public boolean unitAttributeMenu(){//일반 유닛 메뉴

		
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true){
			GameMenu.unitMenu_Worker();		//서택된 유닛의 행동결정 메뉴출력
			input = scan.nextInt();
			switch(input){
			case 1:	//건물건설
				getBuild(); //건물 생산 메서드 호출
				return true;
			case 2:	//취소
				return false;
			default:
			}
		}
	}
	public void getBuild(){//건물을 생성하는 메서드
		
		GameMenu.unitMenu_buildList(this,mySpe);
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true){
			input = scan.nextInt();
			if(input >=1 || input <=3 ) break;
		}
		
		switch(input){
		case 1: //인구건물 생성
			if(myMineral >= Population.getPrice(mySpe) && myBuild.size() < 4) //건물 가격과 건물 갯수 조건이 맞을때
			{
				myMineral -= Population.getPrice(mySpe);
				myPopul += 10;
				myBuild.add(new Population(mySpe.PopulationName)); //사용자 종족에따른 인구건물 생성
				System.out.println(mySpe.PopulationName+"를 생산했습니다.");
			}else if(myMineral < Population.getPrice(mySpe)){
				System.out.println("미네랄이 부족합니다.");
			}else System.out.println("공간이 부족합니다.");
			break;
		case 2: //생산건물 생성
			if(myMineral >= Production.getPrice(mySpe) && myBuild.size() < 4) //건물 가격과 건물 갯수 조건이 맞을때
			{
				myMineral -= Production.getPrice(mySpe);
				myBuild.add(new Production(mySpe.ProductionName)); //사용자 종족에따른 생성건물 생성
				System.out.println(mySpe.ProductionName+"를 생산했습니다.");
			}else if(myMineral < Production.getPrice(mySpe)){
				System.out.println("미네랄이 부족합니다.");
			}else System.out.println("공간이 부족합니다.");
			break;
		case 3: //취소!
			return;
		}
	}
	
	public boolean attackUnitAttributeMenu(GameManager player,GameManager Enemy){//공격 유닉 메뉴

		
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true){
			GameMenu.unitMenu_Attacker();	//서택된 유닛의 행동결정 메뉴출력
			input = scan.nextInt();
			switch(input){
			case 1:	//정보보기

				System.out.println("보유중인 "+mySpe.attackerName+" :"+myAttack.size()+"기");
				if(myAttack.size() <= 0){
					System.out.println("유닛이 없어 정보를 볼 수 없습니다.");
				}else{
					myAttack.get(0).getInfo();
				}
				
				return true;
			case 2:	//공격하기
				enemyAttack(player,Enemy);
				return true;
			case 3: // 취소
				return false;
			default:
			}
		}
	
	}
	public void enemyAttack(GameManager player,GameManager Enemy){//공격실행 메서드
		
		
		Scanner scan = new Scanner(System.in);
		int input;
		while(true){
			GameMenu.fightMenu(player,Enemy);
			input = scan.nextInt();
			if(input >= 1 && input <= 2) break;
		}
		switch(input){
		case 1://공격개체수 정해서 공격
			if(player.myAttack.size() <= 0){	//병력이없을경우 종료
				System.out.println("병력이 없습니다..");
				break;
			}
			
			int AttackValue;
			int TotalDamage = 0;
			int count = 0;		//처치수 저장
			int Damage_temp;	//총피해량 저장
			int Nexus_temp = 0;		//본부피해량 저장
			int TempDamage;
			
			while(true){//전투유닛 선택
				System.out.println("보유중인 "+player.mySpe.attackerName+" :"+player.myAttack.size()+"기");
				System.out.println("공격보낼 수를 입력하시오 (보유중인 수보다 더 보낼수는 없습니다.)");
				System.out.print("입력 : ");
				AttackValue = scan.nextInt();
				if(AttackValue <= player.myAttack.size()) break;
			}//보유중인 수보다 적거나 같게 유닛을 선택할때 탈출
			
				for(int i=0;i<AttackValue;i++){//선택한만큼 반복한다 자동적으로 뒤에서 제거
					TotalDamage += player.myAttack.get(0).damage;//유닛의 데미지만 추출
					player.myAttack.remove(0); //보낸유닛은삭제
				}
				Damage_temp = TotalDamage;	//총피해량저장
				
				//추출된 공격력으로 상대방을 깎아나간다.
				
				for(int i=0;0<TotalDamage;i++){
					if(Enemy.myAttack.size() > 0) //상대방에 유닛이 있으면~
					{
					TempDamage = TotalDamage;
					TotalDamage -= Enemy.myAttack.get(0).hp; //상대유닛의 체력으로 총공격력을 깐다.
						if(Enemy.myAttack.get(0).hp-TempDamage <= 0)//상대유닛의 체력이 0되면 삭제
						{
							count++;					//적 처치수
							Enemy.myAttack.remove(0);	//처치된적 배열에서 삭제
						}else{
							Enemy.myAttack.get(0).hp = Enemy.myAttack.get(0).hp-TempDamage; //
						}
					}
					else if(Enemy.myAttack.size() <= 0){ //상대방 유닛없으면~
						Enemy.myAttack.clear();
						Enemy.myBuild.get(0).HP -= TotalDamage; //남은총공격력으로 상대 본부체력을 깐다.
						Nexus_temp = TotalDamage; //넥서스피해량 저장
						TotalDamage = 0;
					
						
					}
//					else if(TotalDamage <= 0){ //데미지없으면~
//						break; //공격종료
//					}
					System.out.println("ψψ 전투:"+(i+1)+" ψψ");	
				}
				GameMenu.fightEndMenu(Damage_temp, count, Nexus_temp);
			break;
		case 2://취소하기
			break;
		}
	}
	public boolean playerWin(GameManager Enemy){//승리메서드
		if(Enemy.myBuild.get(0).HP <= 0){
			System.out.println(myPlayer+"플레이어의 승리입니다.");
			return true;
			//승리
		}
		return false;
		
	}
	}
