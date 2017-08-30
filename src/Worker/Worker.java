package Worker;

import Manager.*;
import Species.Species;

public class Worker {
	
	public int price;
	
	public static void GetMineral(GameManager player, int GetCount, int WorkerNumber){
		for(int i = 0; i < WorkerNumber; i++){
			player.myMineral += GetCount;
		}
	}
	
	public static int getPrice(Species spe){ //유닛 가격반환
		
		if(spe.name == "저그") return 500;
		else if(spe.name == "프로토스")return 500;
		else if(spe.name == "테란")return 500;
		
		return 0;
	}
}
