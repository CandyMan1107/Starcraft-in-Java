package Manager;
import java.util.ArrayList;
import java.util.Scanner;

import Attacker.Attacker;
import Species.Species;
import Worker.Worker;
import Building.*;

public class GameMenu {
	
	//public static Scanner input = new Scanner(System.in);
	//Building build = new Building();
	
	public static void speciesMenu(int player){
		System.out.println();
		System.out.println("플레이어" + player + "의 플레이할 종족을 선택하세요.");
		System.out.println("1. 저그");
		System.out.println("2. 프로토스");
		System.out.println("3. 테란");
		System.out.println("4. 선택안함");
		System.out.print("선택 : ");
	}
	
	public static void showMenu(int player){
		System.out.println();
		System.out.println(player+"플레이어|무엇을 하시겠습니까?");
		System.out.println("1. 건물 선택.");
		System.out.println("2. 유닛 선택.");
		System.out.println("3. 턴넘기기.");
		System.out.print("선택 : ");
	}
	
	public static void unitMenu(){
		System.out.println();
		System.out.println("유닛 선택|어떤걸 선택하겠습니까?");
		System.out.println("1. 일꾼유닛 선택.");
		System.out.println("2. 공격유닛 선택.");
		System.out.println("3. 취소.");
		System.out.print("선택 : ");
	}
	
	public static void unitMenu_Worker(){
		System.out.println();
		System.out.println("일꾼|어떤걸 선택하겠습니까?");
		System.out.println("1. 건물건설.");
		System.out.println("2. 취소.");
		System.out.print("선택 : ");
	}

	public static void unitMenu_buildList(GameManager gm,Species spe){
		System.out.println();
		System.out.println("건물건설|어떤걸 선택하겠습니까?");
		System.out.println("1."+gm.mySpe.PopulationName+"|"+Population.getPrice(spe)+"미네랄 소모");
		System.out.println("2."+gm.mySpe.ProductionName+"|"+Production.getPrice(spe)+"미네랄 소모");
		System.out.println("3.취소");
		System.out.println("=====건물은 최대 4개까지 건설할 수 있습니다.=======");
		System.out.print("선택 : ");
	}
	public static void unitMenu_Attacker(){
		System.out.println();
		System.out.println("공격유닛|어떤걸 선택하겠습니까?");
		System.out.println("1. 정보보기.");
		System.out.println("2. 공격하기.");
		System.out.println("3. 취소.");
		System.out.print("선택 : ");
	}
	
	public static void buildWorkMenu(Species spe){
		System.out.println("어떤걸 선택하겠습니까?");
		System.out.println("1. "+spe.workerName+"생산|"+Worker.getPrice(spe)+"미네랄소모");
		System.out.println("2. 취소.");
		System.out.print("선택 : ");
	}
	public static void buildAttackMenu(Species spe){
		System.out.println("어떤걸 선택하겠습니까?");
		System.out.println("1. "+spe.attackerName+"생산|"+Attacker.getPrice(spe)+"미네랄소모");
		System.out.println("2. 취소.");
		System.out.print("선택 : ");
	}

	public static void fightMenu(GameManager p1,GameManager p2){
		System.out.println();
		System.out.println(p1.myPlayer+"플레이어"+ "("+p1.mySpe.name+") --공격>> "+p2.myPlayer+"플레이어("+p2.mySpe.name+")");
		System.out.println("==============================");
		System.out.println("ψψψ      상대를     공격합니다!      ψψψ");
		System.out.println("==============================");
		System.out.println("1.공격개체수 설정");
		System.out.println("2.취소");
		System.out.print("선택 : ");
	}
	public static void fightEndMenu(int damage,int count,int nexus){
		System.out.println("");
		System.out.println("=============");
		System.out.println("ψψψ 전투 결과  ψψψ");
		System.out.println("=============");
		System.out.println("적에게가한 피해량 :"+damage);
		System.out.println("상대  유닛  처치수 :"+count);
		System.out.println("상대  본부  피해량 :"+nexus);
	}

}