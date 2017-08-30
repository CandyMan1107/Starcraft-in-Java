package Attacker;

import Species.Species;

public class Attacker {
	
	public int hp;
	public int damage;
	public int price;
	
	public Attacker createUnit(){
		return new Attacker();
	}
	
	public static int getPrice(Species spe){ //유닛 가격반환
		
		if(spe.name == "저그") return 50;
		else if(spe.name == "프로토스")return 100;
		else if(spe.name == "테란")return 50;
		
		return 0;
	}
	
	public void getInfo(){
		System.out.println("체력 :"+hp);
		System.out.println("데미지 :"+damage);
	}

}
