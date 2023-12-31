package SumArrayElementsWithThreads;

public class ThreadSum extends Thread{
	
	private int[] array;
	private int from;
	private int to;
	private int result;
	
	
	public ThreadSum(int[] arr,int inic,int fin) {
		super();
		this.array = arr;
		this.from = inic;
		this.to = fin;
		this.result = 0;
	}
	
	@Override
	public void run() {
		int sum = 0;
		for (int i = this.from; i < this.to; i++) {
			sum += array[i];
		}
		this.result = sum;
	}
	
	public int getResult() {
		return this.result;
	}
	
}
