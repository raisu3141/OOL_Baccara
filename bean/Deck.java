package bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.goui.util.MTRandom;
import static Constant.Constant.*;


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
		//デッキのシャッフル
        shuffleDeck(this.deck);

		//次に引くカードの要素位置を0に戻す
		nextDrawIndex = 0;
	}

    //デッキのシャッフル
    private void shuffleDeck() {
        final double seed = System.currentTimeMillis();
        MTRandom random = new MTRandom((long) (seed * 1e9)); // rndをシードとして使用
        for (int i = TOTAL_CARDS - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
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
		for(int i = 0; i < NUM_DECKS; i++){
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
		Arrays.stream(Card.Number.values()).filter(e -> e.getStartCreate()).forEach(number -> {
			//suiteのenum loop
			Arrays.stream(Card.Suite.values()).forEach(suite -> {
				deck.add(new Card(suite, number));
			});
		});

		return deck;
	}

}
