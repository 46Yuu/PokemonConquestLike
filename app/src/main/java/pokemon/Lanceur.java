package pokemon;

import pokemon.vue.Vue;

public class Lanceur {
    public static void main(String[] args) {
		Vue test = new Vue();
		test.pack();
		test.setVisible (true);
	}
}
