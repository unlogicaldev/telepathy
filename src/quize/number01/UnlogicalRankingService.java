package quize.number01;

public class UnlogicalRankingService implements RankingService {

	@Override
	public int[] rank(int[] scores) {
		int[] ib = new int[scores.length];
		int c = 0;
		
		for(int i = 0; i< scores.length; i ++){
			for(int j = 0; j<scores.length; j++){
				c += Math.signum(Math.signum(scores[i]-scores[j])+1);
			}
			ib[i] = scores.length + 1 - c;
			c = 0;
		}
		
		/*
		 * 두번째..
		 * 첫번째보다 좀 더 복잡하네요..
		 * 
		for(int i = 0; i< scores.length; i ++){
			for(int j = 0; j<scores.length; j++){
				c +=Math.signum(Math.ceil((double)scores[j]/(double)scores[i]-1D));
			}
			ib[i] = c+1;
			c = 0;
		}
		*/
		
		return ib;
	}
	
	public static void main(String[] args) throws Exception {
		RankingService rs = new UnlogicalRankingService();

		int[] scores = new int[]{80,80,100,60,10,10,1,1000};
		int[] result = rs.rank(scores);
		for( int i = 0 ; i < scores.length ; i ++ ){
			System.out.println(i + " " + scores[i] + " " + result[i]);
		}
	}

}
