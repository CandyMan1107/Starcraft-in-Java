package Building;

import Species.Species;

public class Population extends Building {

	public Population(String name){
		//HP = a;
		this.name = name;
		type = "population";
	}
	public static int getPrice(Species spe){ //건물 가격반환 -인구건물
		
		if(spe.name == "저그") return 600;
		else if(spe.name == "프로토스")return 600;
		else if(spe.name == "테란")return 600;
		
		return 0;
	}
}
