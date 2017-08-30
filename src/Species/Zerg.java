package Species;

public class Zerg extends Species {
	
	

		
	public Zerg(int player){
		System.out.println("플레이어" + player + "이 저그를 선택했습니다.");
//		System.out.println("폭풍저그 콩진호가 간다! (~~~~~간다!)");
		name = "저그";
		workerName = "드론";
		attackerName = "저글링";
		mainBuildName = "해처리";
		PopulationName = "오버로드";
		ProductionName = "스포닝풀";
	}
	
	public String getSpecies(){
		return name;
	}
}
