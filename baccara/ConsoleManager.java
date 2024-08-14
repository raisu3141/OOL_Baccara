package baccara;

import java.util.Scanner;

import Constant.Constant;
import bean.Dealer;
import bean.Player;

/**
 * コンソール処理関連をまとめてる
 * @author copper_dog
 *
 */
public class ConsoleManager {
    private static final Scanner sc = new Scanner(System.in);

	/** インスタント化させない **/
	private ConsoleManager(){throw new AssertionError();}

	/**
	 * コンソールに文字を出力する
	 * @param printStr 出力する文字
     * @param writeLine 一行記載するか
	 */
	public static final void gameInfoPrint(String printStr, boolean writeLine) {
		if(Constant.SHOULD_OPERATE){
			if(writeLine){
				System.out.println(printStr);
			}else{
				System.out.print(printStr);
			}
		}
	}

	/**
	 * 手札を表示する
	 * @param dealer プレイヤー
	 * @param player ディーラー
	 * @param dealerAllOpen ディーラーが手札を全て表示するか
	 */
	public static final void handOpen(Dealer dealer, Player player, boolean dealerAllOpen) {
		if(Constant.SHOULD_OPERATE){
			if(dealerAllOpen){
				dealer.allOpen(Constant.DEALER);
			}else{
				dealer.open();
			}
			player.open();
			printSeparator();
		}
	}

	/**
	 * コンソールに長めの横線を引く(途中用)
	 */
	public static final void printSeparator() {
		gameInfoPrint(Constant.SEPARATOR_STR, true);
	}

	/**
	 * コンソールに長めの横線を引く(終わり用)
	 */
	public static final void printSeparatorEnd() {
		gameInfoPrint(Constant.EMPTY, true);
		gameInfoPrint(Constant.SEPARATOR_STR_END, true);
		gameInfoPrint(Constant.EMPTY, true);
	}

	/**
	 * ベット金を選択させるための文字を表示する
     * @return ユーザーが入力した文字
	 */
	public static final String choiceBetMoney() {
		gameInfoPrint(Constant.CHOICE_USER_BET, false);
		String inputStr = sc.nextLine();
		return inputStr;
	}

	/**
	 * ベットサイドを選択させるための文字を表示する
	 * @return ユーザーが入力した文字
	 */
	public static final String choiceBetSide() {
		gameInfoPrint(Constant.CHOICE_USER_BET_SIDE, false);
		String inputStr = sc.nextLine();
		return inputStr;
	}

	/**
	 * プレイヤーの行動を促す文字を表示する
     * @param player プレイヤー
     * @return プレイヤーが入力した文字
	 */
	public static final String choicePlayerAction(Player player) {
		String playerName = Constant.PLAYER;

		//文字を作成する
		StringBuilder sb = new StringBuilder();
		sb.append(Constant.CHOICE_PLAYER_ACTION1);
		sb.append(Constant.CHOICE_PLAYER_ACTION_END);

		gameInfoPrint(playerName + sb.toString(), false);
		String inputStr = sc.nextLine();
		return inputStr;
	}

	/**
	 * ユーザーの行動を諭す文字を表示する
     * @return ユーザーが入力した文字
	 */
	public static final String choiceUserAction() {
		gameInfoPrint(Constant.CHOICE_USER_ACTION, false);
		String inputStr = sc.nextLine();
		return inputStr;
	}

	/**
	 * ゲーム起動の文字を表示する
	 */
	public static final void gameStartUp() {
		ConsoleManager.gameInfoPrint(Constant.SEPARATOR_STR_END, true);
		ConsoleManager.gameInfoPrint(Constant.SEPARATOR_STR_END, true);
		ConsoleManager.gameInfoPrint(Constant.HELLO, true);
		ConsoleManager.gameInfoPrint(Constant.SEPARATOR_STR_END, true);
	}
	/**
	 * ゲーム開始の文字を表示する
     * @param pocketMoney 所持ベル
	 */
	public static final void gameStart(int pocketMoney) {
		ConsoleManager.gameInfoPrint(Constant.SEPARATOR_STR, true);
		ConsoleManager.gameInfoPrint(Constant.GAME_START, true);
		ConsoleManager.gameInfoPrint(Constant.SEPARATOR_STR, true);
		ConsoleManager.gameInfoPrint("  " + Constant.PLAYER + Constant.TEACH_POKET_MONEY + pocketMoney, true);
	}
	/**
	 * ゲームでの儲けを表示する
     * @param pocketMoney　所持ベル
	 */
	public static final void resultMoney(int pocketMoney) {
		ConsoleManager.gameInfoPrint("  " + Constant.PLAYER + Constant.TEACH_POKET_MONEY + pocketMoney, true);
		if(pocketMoney >= Constant.POCKET_MONEY){
			ConsoleManager.gameInfoPrint("  " + (pocketMoney - Constant.POCKET_MONEY) + Constant.RESULT_EARNED, true);
		}else{
			ConsoleManager.gameInfoPrint("  " + (Constant.POCKET_MONEY - pocketMoney) + Constant.RESULT_LOST, true);
		}
	}
	/**
	 * ゲーム終了の文字を表示する
	 */
	public static final void gameFinish() {
		ConsoleManager.gameInfoPrint(Constant.THANKS, true);
	}
}
