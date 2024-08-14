package bean;


public class Card {

    /** 
    * コンストラクタ
    * @param トランプの柄情報(列挙型)
    * @param トランプの数字情報(列挙型)
    */
	public Card(Suite suite, Number number) {
		this.suite = suite;
		this.number = number;
	}

	/**
	 * トランプの数字
	 */
	private Number number;
	/**
	 * トランプのマーク
	 */
	private Suite suite;

	public Suite getSuite() {
		return suite;
	}
	public Number getNumber() {
		return number;
	}
	public void setNumber(Number number) {
		this.number = number;
	}

	/**
	 * トランプの柄の列挙クラス
	 * @author copper_dog
	 */
	public enum Suite {
		//SPADE("♠"), CLUB("♣"), DIAMOND("♦"), HEART("♥");
		SPADE("S "), CLUB("C "), DIAMOND("D "), HEART("H ");

		/** トランプの柄 **/
		private String label;

		Suite(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
	}

	/**
	 * トランプの数字の列挙クラス
	 * @author copper_dog
	 */
	public enum Number {
		n1(1,"A "),n2(2,"2 "),n3(3,"3 "),
		n4(4,"4 "),n5(5,"5 "),n6(6,"6 "),
		n7(7,"7 "),n8(8,"8 "),n9(9,"9 "),
		n10(10,"10"),n11(10,"J "),n12(10,"Q "),n13(10,"K ");

		/** トランプの数字(計算する値) **/
		private int num;
		/** トランプの数字(表示する値) **/
		private String displayNum;

		Number(int num, String displayNum) {
			this.num = num;
			this.displayNum = displayNum;
		}

		public int getNum() {
			return num;
		}
		public String getDisplayNum() {
			return displayNum;
		}
	}

	/**
	 * インスタンスの文字列化
     * @return (♦A )とか(♥6 )とか(♣10)の文字
	 */
	@Override
	public String toString() {
		//例 : (♦A )とか(♥6 )とか(♣10)
		return "(" + suite.getLabel() + number.getDisplayNum() + ")";
	}
}
