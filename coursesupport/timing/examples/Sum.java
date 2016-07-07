package timing.examples;

import java.util.Random;

import timing.Algorithm;
import timing.ExecuteAlgorithm;
import timing.GenResults;
import timing.Ticker;

public class Sum implements Algorithm<Integer[],Integer> {

	private int answer;
	private Integer[] numbers;

	@Override
	public void reset() {
		this.answer = 0;
	}

	@Override
	public void run(Ticker ticker) {
		for (int i=0; i < numbers.length; ++i) {
			answer = answer + numbers[i];
			ticker.tick();
		}

	}

	@Override
	public void loadInput(Integer[] input) {
		this.numbers = input;
	}

	@Override
	public Integer getResults() {
		return answer;
	}

	public String toString() {
		return numbers != null ? "Sum of " + numbers.length + " numbers" : "";
	}

	public static void main(String[] args) {
		int size = 10000000;
		ExecuteAlgorithm<Integer[],Integer> ea = new ExecuteAlgorithm<Integer[], Integer>(new IntArrayGenerator(), new Sum(), size);
		ea.run();
		System.out.println("Answer is " + ea.getResults());
		System.out.println(ea.getTicks());
		System.out.println(ea.getTime());

	}

}
