package timing.examples;

import java.util.Random;

import timing.Algorithm;
import timing.ComplexityParameters;
import timing.ExecuteAlgorithm;
import timing.GenResults;
import timing.Ticker;
import timing.utils.IntArrayGenerator;

public class Sum implements Algorithm<Integer[],Integer> {

	private int answer;
	private Integer[] numbers;
	private Ticker ticker;

	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
		this.answer = 0;
	}

	@Override
	public void run() {
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
		ExecuteAlgorithm<Integer[],Integer> ea = new ExecuteAlgorithm<Integer[], Integer>(new IntArrayGenerator(), new Sum(), ComplexityParameters.gen(size));
		ea.run();
		System.out.println("Answer is " + ea.getResults());
		System.out.println(ea.getTicks());
		System.out.println(ea.getTime());

	}

}
