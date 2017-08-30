package Manager;

public class GameStatus {
	
	public static void showStatus(GameManager player){
		System.out.println();
		System.out.println("===============================================================");
 		System.out.print("플레이어" + player.myPlayer + "("+player.mySpe.name+")"+" | ");
		System.out.print("본부 체력: " + player.myBuild.get(0).HP + " | ");
		System.out.print("미네랄 양: " + player.myMineral + " | ");
		System.out.print("인구수: " + player.myAttack.size()+"/"+player.myPopul+ " | ");
		System.out.print("일꾼수: " + player.myWorker.size()+"\n");
		System.out.println("===============================================================");
	}

}
