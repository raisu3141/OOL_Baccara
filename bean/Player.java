package bean;


import Constant.Constant;


/**
 * プレイヤーのbean
 * @author copper_dog
 *
 */
public class Player extends Human {
    /** 手持ちのベル(残金) */
	private Integer pocketMoney = 0;
	/** ゲームでベットしたベル */
	private Integer betMoney = 0;

    /** どちらに賭けたか */
	/** バンカーに賭けた場合は 1、プレイヤーに賭けた場合は 2, 引き分けの場合は 3 */
    private int witchBet = 0;

    /**
    * コンストラクタ
    * @param pocketMoney 初期で持たせる所持ベル
    */
	public Player(int pocketMoney) {
		this.pocketMoney = pocketMoney;
	}

	/**
	 * 手札の初期化後、カードを2枚引いて手札に加える
	 * @param deck デッキ
	 */
	@Override
	public void firstAction(Deck deck){
		//初期状態に戻す
		betMoney = 0;

		super.firstAction(deck);
	}

    /**
	 * 手札の初期化
	 */
    @Override
	public void handClear() {
		super.handClear();
	}

	/**
     * 手札のカードを見せる
     */
    @Override
    public void open(){
    	allOpen(Constant.PLAYER);
    }

    /**
     * 手札のカード全て見せる
     * @param humanName 手札を持っている人名
     */
    @Override
    public void allOpen(String humanName){
		super.allOpen(humanName);
    }

	/**
     * どちらに賭けたかを返す
     * @return バンカーに賭けた場合は 1、プレイヤーに賭けた場合は 2, 引き分けの場合は 3
     */
    public int getWitchBet() {
        return witchBet;
    }

    /**
     * 賭けた先を設定する
     * @param witchBet バンカーに賭けた場合は 1、プレイヤーに賭けた場合は 2, 引き分けの場合は 3
     */
    public void setWitchBet(int witchBet) {
        this.witchBet = witchBet;
    }

    /**
	 * @return 所持ベル
	 */
	public Integer getPocketMoney() {
		return pocketMoney;
	}
	/**
	 * @param pocketMoney セットする pocketMoney
	 */
	public void setPocketMoney(Integer pocketMoney) {
		this.pocketMoney = pocketMoney;
	}
	/**
	 * @return betMoney ベットするベル額
	 */
	public Integer getBetMoney() {
		return betMoney;
	}
	/**
	 * @param betMoney セットする betMoney
	 */
	public void setBetMoney(Integer betMoney) {
		this.betMoney = betMoney;
	}
}
