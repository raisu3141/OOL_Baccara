package Constant;

public class Constant {

    /** ユーザーが操作するか(コンソールに文字を出力するか) **/
	public static final boolean SHOULD_OPERATE = true;


    //デッキ数
    public static final int NUM_DECKS = 6;
    //デッキ枚数
    public static final int CARDS_PER_DECK = 52;
    //デッキ総枚数
    public static final int TOTAL_CARDS = NUM_DECKS * CARDS_PER_DECK;
    /** 初期の所持ベル **/
    public static final int POCKET_MONEY = 1000;
	/** ゲーム数 */
	public static final int MAX_GAMES = 6;
	/** 目標ベル */
	public static final int TARGET_CHIP_COUNT = 3000;



    /** ディーラー **/
	public static final String DEALER = "DEALER";
	/** プレイヤー **/
	public static final String PLAYER = "Player";
	/** 勝負中 **/
	public static final int BATTLE_NOW = 0;
    /** ディーラーの勝ち **/
	public static final int DEALER_WIN = 1;
	/** プレイヤーの勝ち **/
	public static final int PLAYER_WIN = 2;
    /** 引き分け **/
    public static final int DRAW = 3;


    /** スペース **/
	public static final String SPACE = "  ";
    /** 空文字 **/
	public static final String EMPTY = "";
	/** 区切り文字(途中用) **/
	public static final String SEPARATOR_STR = "-----------------------------------";
	/** 区切り文字(終わり用) **/
	public static final String SEPARATOR_STR_END = "****************************************";
	/** open1 **/
	public static final String OPEN_1 = "OPEN";
	/** open2 **/
	public static final String OPEN_2 = "O";
	/** yes1 **/
	public static final String YES_1 = "YES";
	/** yes2 **/
	public static final String YES_2 = "Y";
	/** NO1 **/
	public static final String NO_1 = "NO";
	/** NO2 **/
	public static final String NO_2 = "N";
	/** END **/
	public static final String END = "END";
	/** あなたの文字列定数 **/
	public static final String YOU_ARE = "You are";
	/** プレイヤーの勝ち(nomal)をたたえる **/
	public static final String YOU_ARE_WIN = "congratulation. You are win";
	/** プレイヤーの負けを煽る **/
	public static final String YOU_ARE_LOSE = "You are lose.";
	/** 引き分けだと教える **/
	public static final String YOU_ARE_DRAW = "You are draw.";
	/** 謎のカード **/
	public static final String MYSTERIOUS_CARD = "(??)";
	/** ユーザーにbetサイドを選ばせる文字 **/
	public static final String CHOICE_USER_BET_SIDE = "\nどちらに賭けますか？\n  1: バンカー (x2) 2: プレイヤー (x2) 3: 引き分け (x8)\n  >";
	/** ユーザーにbet金を選ばせる文字 **/
	public static final String CHOICE_USER_BET = "\nベットするベルを入力してください(end -> 終了)\n  >";
	/** ユーザーに次の行動を選ばせる文字 **/
	public static final String CHOICE_USER_ACTION = "続けますか？ \n  y: yes  n:no\n  >";
	/** プレイヤーに次の行動を選ばせる文字1 **/
	public static final String CHOICE_PLAYER_ACTION1 = "カードをオープンしてください。\n  o: open ";
	/** プレイヤーに次の行動を選ばせる文字end **/
	public static final String CHOICE_PLAYER_ACTION_END = "\n  >";
	/** ゲーム起動の挨拶 **/
	public static final String HELLO = "    Baccaraへようこそ!!    ";
	/** 稼いだ報告 **/
	public static final String RESULT_EARNED = "ベル勝ちました。 ";
	/** 損した報告 **/
	public static final String RESULT_LOST = "ベル負けました。 ";
	/** ゲーム終了の挨拶 **/
	public static final String THANKS = "\n  Thank you for playing!! :)    ";
	/** ゲーム開始の挨拶 **/
	public static final String GAME_START = "    ゲーム開始!!    ";
	/** ゲーム開始の挨拶 **/
	public static final String TEACH_POKET_MONEY = "の所持ベル  ->  ";
	/** もう一度入力してください **/
	public static final String ONE_MORE_INPUT = "\n    Error : もう一度入力してください    \n";
	/** ベルがたりません。もう一度入力してください。 **/
	public static final String ONE_MORE_INPUT_LESS_MONEY = "\n    Error : ベルがたりません。もう一度入力してください。    \n";
	/** 0以下が入力されました。もう一度入力してください。 **/
	public static final String ONE_MORE_INPUT_UNDER0 = "\n    Error : 0以下が入力されました。もう一度入力してください。    \n";

    
}