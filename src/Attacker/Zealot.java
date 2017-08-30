package Attacker;

public class Zealot extends Attacker {
	
	String name = "질럿";
	public Zealot() {
		hp = 90;
		damage = 60;
		price = 100;
	}
	public void getInfo(){
		System.out.println("===================");
		System.out.println("이름 :"+name);
		System.out.println("체력 :"+hp);
		System.out.println("데미지 :"+damage);
	}
}
