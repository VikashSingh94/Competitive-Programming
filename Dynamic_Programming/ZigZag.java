package Dynamic_Programming;

public class ZigZag
{

    public  int longestZigZag(int[] sequence)
    {
        int DP[][] = new int[sequence.length][2];
        int length = sequence.length;

        DP[0][0] = 1;
        DP[0][1] = 1;


        for(int j=1 ;j <length;j++)
        {
            for(int i=0;i<j;i++)
            {
                if(sequence[i] < sequence[j])
                {
                    DP[j][1] = Math.max(DP[j][1], DP[i][0] + 1);
                    // System.out.print(DP[j][1]);
                }
                else if(sequence[i] > sequence[j])
                {
                    DP[j][0] = Math.max(DP[j][0], DP[i][1] + 1);
                    // System.out.print(DP[j][0]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<length;i++)
        {
            ans = Math.max( ans , Math.max( DP[i][0] , DP[i][1]));
        }

        return ans ;
    }
}
