package Species;

public class Protoss extends Species {
	
	
//	public String workerName;
//	public String attackerName;
//	public String mainBuildName;
//	public String PopulationName;
//	public String ProductionName;
	
	public Protoss(int player){
		System.out.println("플레이어" + player + "이 프로토스를 선택했습니다.");
		name = "프로토스";
		workerName = "프로브";
		attackerName = "질럿";
		mainBuildName = "넥서스";
		PopulationName = "파일런";
		ProductionName = "게이트웨이";
		
	}
	
	public String getSpecies(){
		return name;
	}
}
