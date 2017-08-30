package Manager;

public class StarCraft {
	public static void main(String[] args) {
		
		GameManager player1 = new GameManager(1);
		GameManager player2 = new GameManager(2);
		int userTurn = 1;
		
		GameMenu.speciesMenu(1);		
		player1.createSpecies();
		
		GameMenu.speciesMenu(2);		
		player2.createSpecies();
		//종족을 고름
		
		//유저마다 인터페이스 
		while(true){
			if(userTurn == 1){
				GameStatus.showStatus(player1);
				userTurn = player1.selectMenu(2,player2);
				
				player1.getMineral();
			}
			else if (userTurn == 3){
				break;
			}
			else{
				GameStatus.showStatus(player2);
				userTurn = player2.selectMenu(1,player1);
				
//				userTurn = 1;
				player2.getMineral();
			}
			
		}
	
		
		
		//게임을 종료합니다. (젤나가.. 맙소사!)
	}
}
