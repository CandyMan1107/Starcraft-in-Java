package Attacker;

public class Marine extends Attacker {
	
	String name = "마린";
	public Marine() {
		hp = 50;
		damage = 50;
		price = 50;
	}
	public void getInfo(){
		System.out.println("===================");
		System.out.println("이름 :"+name);
		System.out.println("체력 :"+hp);
		System.out.println("데미지 :"+damage);
	}
}
