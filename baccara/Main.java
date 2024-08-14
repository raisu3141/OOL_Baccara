package baccara;

import Constant.Constant;

public class Main {

	public static int gamesPlayed = 1;

    /**
	 * ここからスタート
	 * @param arges
	 */
	public static void main(String[] arges) {
		GameManage gm = new GameManage(Constant.POCKET_MONEY);

		boolean finishGame = false;
do{
			//ゲーム開始
			boolean exeFnish = gm.play();
			//ゲームを強制終了するか
			gamesPlayed++;
			if (gm.getPlayer().getPocketMoney() >= Constant.TARGET_CHIP_COUNT) {
				System.out.println("目標チップ数に達成しました！おめでとうございます！");
				finishGame = true;
			} else if (gamesPlayed >= Constant.MAX_GAMES) {
				System.out.println("ゲームオーバーです。目標チップ数に達成できませんでした。");
				finishGame = true;
			} else if(exeFnish){
				finishGame = true;
			}else{
				finishGame = !needRetryPlay();
				//見やすいように区切りを入れる
				ConsoleManager.printSeparatorEnd();
			}
		}while(!finishGame);

		//ゲーム終了
		gm.close();
	}

	/**
	 * もう一度プレイするか確認する
     * @return もう一度プレイするか
	 */
	private static boolean needRetryPlay(){
		Boolean needRetryPlay = null;

		//userの選択の取得
		do{
			String userInputStr = ConsoleManager.choiceUserAction();
			switch (userInputStr.toUpperCase()) {
				case Constant.YES_1:
				case Constant.YES_2:
					needRetryPlay = true;
					break;
				case Constant.NO_1:
				case Constant.NO_2:
					needRetryPlay = false;
					break;
				default:
					break;
			}
		}while(needRetryPlay == null);

		return needRetryPlay.booleanValue();
	}
}