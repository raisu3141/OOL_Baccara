package bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Constant.Constant;

import net.goui.util.MTRandom;

/**
 * デッキクラス
 *
 */
public class Deck {

	//デッキ
	private List<Card> deck = null;
	//次に引くカードの要素位置
	private int nextDrawIndex = 0;

    /**
    * コンストラクタ
    * デッキの生成を行う(シャッフルもする)
    */
	public Deck(){
		this.deck = createDeck();
		//デッキの状態をリセットする
		reset();
	}

	/**
	 * デッキの状態をリセットする
	 */
	public void reset(){
		//デッキのシャッフルをする
		long seed = System.currentTimeMillis();
		MTRandom random = new MTRandom(seed); // seedをシードとして使用
		for(int i = 0; i < Constant.TOTAL_CARDS; i++){
			int j = random.nextInt(Constant.TOTAL_CARDS);
			Card tmp = deck.get(i);
			deck.set(i, deck.get(j));
			deck.set(j, tmp);
		}
		
		//次に引くカードの要素位置を0に戻す
		nextDrawIndex = 0;
	}

	/**
	 * カードを1枚引く
	 * @return 引いたカード
	 */
	public Card draw(){
		if(this.deck.size() <= nextDrawIndex){
			//***********カードが足りないため、引くカードがありません***********
			//デッキの状態をリセットする
			reset();
		}
		//代入と後置インクリメント
		int drawIndex = nextDrawIndex++;
		return deck.get(drawIndex);
	}

	/**
	 * 設定されたデッキ数setする
	 * @return デッキ
	 */
	@SuppressWarnings("unchecked")
	private List<Card> createDeck(){
		List<Card> allDeck = new ArrayList<>();

		//1デッキ作成
		ArrayList<Card> oneDeck = createOneDeck();
		//設定されたデッキ数setする
		for(int i = 0; i < Constant.NUM_DECKS; i++){
			allDeck.addAll((List<Card>)oneDeck.clone());
		}

		return allDeck;
	}

	/**
	 * １デッキ＝52枚(１～13のトランプ、ジョーカー抜き)を作成
	 * @return １デッキ
	 */
	private ArrayList<Card> createOneDeck(){
		ArrayList<Card> deck = new ArrayList<>();

		//numberのenum loop 1～13 (注:filterあり)
		Arrays.stream(Card.Number.values()).forEach(number -> {
			//suiteのenum loop
			Arrays.stream(Card.Suite.values()).forEach(suite -> {
				deck.add(new Card(suite, number));
			});
		});

		return deck;
	}
}
