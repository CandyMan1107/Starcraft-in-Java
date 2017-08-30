package Species;

public class Terran extends Species {
	
	
	
	
	public Terran(int player){
		System.out.println("플레이어" + player + "이 테란을 선택했습니다.");
		name = "테란";
		workerName = "SCV";
		attackerName = "마린";
		mainBuildName = "커맨드센터";
		PopulationName = "서플라이디팟";
		ProductionName = "배럭";
	}
	
	public String getSpecies(){
		return name;
	}
}
