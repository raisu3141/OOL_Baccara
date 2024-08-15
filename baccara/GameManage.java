package baccara;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Constant.Constant;
import bean.Card;
import bean.Dealer;
import bean.Deck;
import bean.Player;
import common.CommonFunc;

public class GameManage {

    public Player getPlayer() {
        return player;
    }
    
    /** ディーラーの作成 **/
	private Dealer dealer;
	/** プレイヤーの作成 **/
	private Player player;
	/** デッキ **/
	private Deck deck;

	/**
	 * Gameに必要なものを作成
     * @param pocketMoney 所持するベル
	 */
	public GameManage(int pocketMoney){
		//挨拶をおこなう
		ConsoleManager.gameStartUp();

		/** ディーラーの作成 **/
		this.dealer = Dealer.getInstance();
		/** プレイヤーの作成 **/
		this.player = new Player(pocketMoney);
		/** デッキの作成 **/
		this.deck = new Deck();
	}

    /**
	 * ゲームを終了する
	 */
	public void close() {
		//儲けの表示
		ConsoleManager.resultMoney(player.getPocketMoney());
		//挨拶をおこなう
		ConsoleManager.gameFinish();
	}

    /**
     * ゲームを開始する
     * @return ゲームを強制終了するか
     */
    public boolean play() {
        int gameStatus =  Constant.BATTLE_NOW;

		//ゲーム開始の合図
		ConsoleManager.gameStart(player.getPocketMoney());

		//ブラックジャックの最初の行動を行う
		firstAction();

        //ベットサイドを選択させる
        boolean exeEnd1 = choiceBetSide();
        if(exeEnd1) return exeEnd1;

		//ベット金を選択させる
		boolean exeEnd = choiceBetMoneyOrEnd();
		if(exeEnd) return exeEnd;

		//今の手札を表示する
		ConsoleManager.handOpen(dealer, player, false);

        //プレイヤーの行動
        do {
            String userInputStr = ConsoleManager.choicePlayerAction(player);
            if (playerAction(userInputStr)) {
                break;
            }
        } while (true);

        int drow = CommonFunc.judgementDraw(dealer.getHand(), player.getHand());
        if (drow == 1 ){
            //プレイヤーが一枚ドローする
            player.getHand().add(deck.draw());

            System.out.println("プレイヤーが１枚ドローします");

            //プレイヤーの行動
            do {
                String userInputStr = ConsoleManager.choicePlayerAction(player);
                if (playerAction(userInputStr)) {
                    break;
                }
            } while (true);

            int drow2 = CommonFunc.judgementDraw2(dealer.getHand(), player.getHand());
            if (drow2 == 1){
                //ディーラーがドローする
                dealer.getHand().add(deck.draw());
                System.out.println("ディーラーが１枚ドローします");
                //プレイヤーの行動
                do {
                    String userInputStr = ConsoleManager.choicePlayerAction(player);
                    if (playerAction(userInputStr)) {
                        break;
                    }
                } while (true);
            } else if (drow2 == 2){
                //ディーラーがドローしない
            }

        } else if (drow == 2){
            //両者がドローしない
        }


        //勝敗の判定と、それによる行動を行う
		judgementAction(gameStatus, player);

        return player.getPocketMoney() == 0;

    }

    /**
     * ベットするサイドを選択してもらうメソッド
     * @return ゲームを強制終了するか
     */

    private boolean choiceBetSide(){
        do{
            String userInputStr = ConsoleManager.choiceBetSide();
            if (Constant.END.equals(userInputStr.toUpperCase())) return true;

            int betSide;
            try {
                // String を int に変換
                betSide = Integer.parseInt(userInputStr);
            } catch (NumberFormatException e) {
                // 変換できない場合は無効な入力として処理
                System.out.println("無効な入力です。もう一度入力してください。");
                continue;
            }

            switch (betSide) {
                case Constant.DEALER_WIN:
                    player.setWitchBet(Constant.DEALER_WIN);
                    break;
                case Constant.PLAYER_WIN:
                    player.setWitchBet(Constant.PLAYER_WIN);
                    break;
                case Constant.DRAW:
                    player.setWitchBet(Constant.DRAW);
                    break;
                default:
                    ConsoleManager.gameInfoPrint(Constant.ONE_MORE_INPUT, true);
                    break;
            }
        }while(player.getWitchBet() == 0);

        return false;
    }

    /**
	 * ベットするベルを選択してもらうメソッド
	 * @return ゲームを強制終了するか
	 */
	private boolean choiceBetMoneyOrEnd(){
		do{
			String userInputStr = ConsoleManager.choiceBetMoney();
			if(Constant.END.equals(userInputStr.toUpperCase())) return true;

			try{
				int betMoney = Integer.parseInt(userInputStr);
				if(betMoney <= 0){
					//0円以下をベットした場合
					ConsoleManager.gameInfoPrint(Constant.ONE_MORE_INPUT_UNDER0, true);
				}else if(betMoney > player.getPocketMoney()){
					//持っているベルより、多くをベットした場合
					ConsoleManager.gameInfoPrint(Constant.ONE_MORE_INPUT_LESS_MONEY, true);
				}else{
					player.setBetMoney(betMoney);
					player.setPocketMoney(player.getPocketMoney() - betMoney);
					break;
				}
			}catch(NumberFormatException e){
				ConsoleManager.gameInfoPrint(Constant.ONE_MORE_INPUT, true);
			}
		}while(true);

		return false;
	}

    /**
	 * 最初の行動を行う
	 */
	private void firstAction(){
		//プレイヤーとディーラーの手札を初期化し、カードを二枚ひく
		player.firstAction(deck);
		dealer.firstAction(deck);
	}

    /**
     * プレイヤーの行動
     * @param userInputStr ユーザーが入力した文字
     * @return errorが無い場合はtrue
     */

     private boolean playerAction(String userInputStr){
        boolean isNotError = true;
        switch (userInputStr.toUpperCase()) {
            case Constant.OPEN_1:
                //カードを表示する
                ConsoleManager.handOpen(dealer, player, true);
                break;
            case Constant.OPEN_2:
                //カードを表示する
                ConsoleManager.handOpen(dealer, player, true);
                break;
            default:
                //エラー
                ConsoleManager.gameInfoPrint(Constant.ONE_MORE_INPUT, true);
                isNotError = false;
                break;
        }
        return isNotError;
     }


    /**
	 * 勝敗を決める
	 * @param gameStatus ゲームの状態 (勝負中:0, ディーラーの勝ち : 1, プレイヤー勝ち : 2, 引き分け : 3,)
     * @param player プレイヤーオブジェクト
	 */
    private void judgementAction(int gameStatus, Player player){
        int betMoney = player.getBetMoney();
        int witchBet = player.getWitchBet();

        Map<String, Integer> resultList = new LinkedHashMap<>();

        //勝敗を決める
		int winnerNum = gameStatus == Constant.BATTLE_NOW ? CommonFunc.judgementWinner(dealer.getHand(), player.getHand()) : gameStatus;
        resultList.put(Constant.PLAYER, winnerNum);

        //今の手札を表示する
		ConsoleManager.handOpen(dealer, player, true);


        resultList.forEach((key, val) -> {
            switch (val) {
                case Constant.DEALER_WIN:
                    //ディーラーの勝ち
                    if (witchBet == Constant.DEALER_WIN) {
                        //ディーラーに賭けていた場合
                        player.setPocketMoney(player.getPocketMoney() + betMoney * 2);
                        player.say(Constant.PLAYER, Constant.YOU_ARE_WIN);
                        
                    } else {
                        //その他に賭けていた場合
                        System.out.println("ディーラーの勝ちです");
                        dealer.say(Constant.DEALER, Constant.YOU_ARE_LOSE);
                    }
                    break;
                case Constant.PLAYER_WIN:
                    //プレイヤーの勝ち
                    if (witchBet == Constant.PLAYER_WIN) {
                        //プレイヤーに賭けていた場合
                        player.setPocketMoney(player.getPocketMoney() + betMoney * 2);
                        player.say(Constant.PLAYER, Constant.YOU_ARE_WIN);
                    } else {
                        //その他に賭けていた場合
                        System.out.println("プレイヤーの勝ち");
                        dealer.say(Constant.DEALER, Constant.YOU_ARE_LOSE);
                    }
                    break;
                case Constant.DRAW:
                    //引き分け
                    if (witchBet == Constant.DRAW) {
                        //引き分けに賭けていた場合
                        player.setPocketMoney(player.getPocketMoney() + betMoney * 8);
                        player.say(Constant.PLAYER, Constant.YOU_ARE_DRAW);
                    } else {
                        //その他に賭けていた場合
                        System.out.println("引き分けです");
                        player.say(Constant.DEALER, Constant.YOU_ARE_LOSE);
                    }
                    break;
                default:
                    break;
            }
        });
        System.out.println("Playerの所持ベル -> " + player.getPocketMoney());
        //見やすいように区切りを入れる
		ConsoleManager.printSeparatorEnd();
    }

}
