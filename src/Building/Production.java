package Building;

import Species.Species;

public class Production extends Building {

	public Production(String name){
		//HP = a;
		this.name = name;
		type = "production";

	}
	
	public static int getPrice(Species spe){ //건물 가격반환 -생산건물
		
		if(spe.name == "저그") return 500;
		else if(spe.name == "프로토스")return 700;
		else if(spe.name == "테란")return 600;
		
		return 0;
	}
}
