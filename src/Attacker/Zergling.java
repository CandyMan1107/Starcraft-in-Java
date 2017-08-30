package Attacker;

public class Zergling extends Attacker {
	
	String name = "저글링";
	public Zergling() {
		hp = 35;
		damage = 70;
		price = 50;
	}
	public void getInfo(){
		System.out.println("===================");
		System.out.println("이름 :"+name);
		System.out.println("체력 :"+hp);
		System.out.println("데미지 :"+damage);
	}
}
