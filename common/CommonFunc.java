package common;

import java.util.List;
import java.util.Optional;

import Constant.Constant;
import bean.Card;
import bean.Dealer;
import bean.Deck;
import bean.Human;

public class CommonFunc {

    /**
	 * 誰が勝ったかを判断する
	 * @param dealerHand　ディーラーの手札
	 * @param playerHand プレイヤーの手札
	 * @return 1-> dealer, 2 -> player,  3 -> draw(引き分け)
	 */
	public static int judgementWinner(List<Card> dealerHand, List<Card> playerHand) {

		if (getScore(playerHand) < getScore(dealerHand)) {
			return Constant.DEALER_WIN;
		} else if (getScore(playerHand) > getScore(dealerHand)) {
			return Constant.PLAYER_WIN;
		} else {
			return Constant.DRAW;
		}
	}

	/**
	 * さらにドローするかを判断する
	 * @param dealerHand ディーラーの手札
	 * @param playerHand プレイヤーの手札
	 * @return 1 -> player側が一枚ドロー, 2 -> 両者がドロー, 3 -> 両者がドローしない
	 */
	public static int judgementDraw(List<Card> dealerHand, List<Card> playerHand) {
		int drawNum = 3;

		if (getScore(playerHand) > 8 || 
			getScore(dealerHand) > 8) {
			//両者がドローしない
			return drawNum;
		} else {
			final int H = 2; //両者ドロー
        	final int S = 1; //player側が一枚ドロー
			final int[][] table = {
				{ H, H, H, H, H, H, H, H, H, H, H },
				{ H, H, H, H, H, H, H, H, H, H, H },
				{ H, H, H, H, H, H, H, H, H, H, H },
				{ H, H, H, H, H, H, H, H, H, S, H },
				{ H, S, S, H, H, H, H, H, H, S, H },
				{ H, S, S, S, S, H, H, H, H, S, S },
				{ S, S, S, S, S, S, S, H, H, S, S },
				{ S, S, S, S, S, S, S, S, S, S, S }
			};
			return (table[getScore(dealerHand)][getScore(playerHand)]);
		}
	}

	/**
	 * カードを引いて手札に加える
	 * @param deck デッキ
     * @param hand 手札
	 */
	public static void draw(Deck deck, List<Card> hand){
		hand.add(deck.draw());
	}

	/**
	 * 手札の初期化後、カードを2枚引いて手札に加える
	 * @param deck デッキ
     * @param human　humanオブジェクト
	 */
	public static void firstAction(Deck deck, Human human){
		human.handClear();
		human.getHand().add(deck.draw());
		human.getHand().add(deck.draw());
	}

    /**
	 * 得点を取得する
     * @param hand 手札
	 * @return 手札の合計点
	 */
	public static int getScore(List<Card> hand) {
		int result = hand.stream().mapToInt(c -> c.getNumber().getNum()).sum();

		if (result >= 10){
			return result % 10;
		} else {
			return result;
		}
	}
}