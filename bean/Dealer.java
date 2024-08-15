package bean;

import Constant.Constant;
import baccara.ConsoleManager;

/**
 * Singletonパターン ディーラーのbean
 * 注1)状態を持たないこと
 * 注2)ポリモーフィズムが絡むこと
 *
 */
public class Dealer extends Human{
    private static final Dealer instance = new Dealer();

    /**
     * 唯一のインスタンスを返す
     * @return このクラスの唯一のインスタンス
     */
    public static Dealer getInstance() {
        return instance;
    }

    /**
     * 外部からインスタンス化できないよう、コンストラクタをprivateで宣言する
     */
    private Dealer() {

    }

    /**
     * 手札のカード1枚見せる
     */
    @Override
    public void open(){
    	StringBuilder sb = new StringBuilder();
    	//手札の最初の要素が存在した場合は、文字を追加する
    	super.getHand().stream().findFirst().ifPresent(c -> sb.append(c.toString()));
    	sb.append(Constant.SPACE);
    	sb.append(Constant.MYSTERIOUS_CARD);

    	ConsoleManager.gameInfoPrint(Constant.DEALER + "  ("+getOpenOneScore()+"): " + sb.toString(), true);
    }

    /**
	 * 現在表示している点数を取得する
	 * @return 手札の合計点
	 */
	private int getOpenOneScore() {
		int result = hand.get(0).getNumber().getNum();
        if (result >= 10) {
            return result % 10;
        } else {
        return result;
        }
    }

    /**
     * 発言相手によって、メッセージを変える
     * @param playerName 発言する人名
     * @param message メッセージ
     * @return 変換後のメッセージ
     */
    private String changeMsg(String playerName, String message) {
    	if(playerName.equals(Constant.PLAYER)){
    		return message;
    	}else{
    		return message.replace(Constant.YOU_ARE, playerName + " is");
    	}
    }

    /**
     * 勝ち(nomal)をたたえる
     * @param playerName 発言している人の名前
     */
    public void sayYouWin(String playerName) {
    	say(Constant.DEALER, changeMsg(playerName, Constant.YOU_ARE_WIN));
    }

    /**
     * 負けを煽る
     * @param playerName 発言している人の名前
     */
    public void sayYouLose(String playerName) {
    	say(Constant.DEALER, changeMsg(playerName, Constant.YOU_ARE_LOSE));
    }

    /**
     * 引き分けだと伝える
     * @param playerName 発言している人の名前
     */
    public void sayYouDraw(String playerName) {
    	say(Constant.DEALER, changeMsg(playerName, Constant.YOU_ARE_DRAW));
    }
    
}