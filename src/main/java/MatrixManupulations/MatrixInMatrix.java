package MatrixManupulations;

public class MatrixInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
     Integer[][] ssuper = { {1,2,3,4,5},
    		                {6,7,8,9,1},
    		                {4,5,6,7,8},
    		                {2,3,4,5,6},
    		                {6,5,1,2,4}
    		                
                          };
     Integer[][] sub = {{4,5},{1,2}}; 
     
     isSubInSuper(ssuper,sub);
	
	}

	private static void isSubInSuper(Integer[][] ssuper, Integer[][] sub) {
       int x=0, y=0; 
		
		for(int i=0; i < sub.length; i++)
		{
			Integer[] arr = isPresentInSuper(ssuper,sub[i],x,y); 
			if(arr !=null)
	        {
				isPresentInSuper(ssuper,sub[++i],arr[0],arr[1]); 
	        }
			
		}
	}

	private static Integer[] isPresentInSuper(Integer[][] ssuper, Integer[] sub, int x, int y) {

		int k=0;
		boolean found = false;
		for(int i=x; i<ssuper.length; i++)
		{
			for(int j=y; j<ssuper[i].length-sub.length; j++)
			{
				if(sub[k]==ssuper[i][j])
				{
					for(int p=1; p<sub.length; p++)
					{
						if(j+p <= ssuper[i].length && ssuper[i][j+p]!=sub[p])
						{
							found=false;
							break;
						}
						else{
							found = true;
							continue;
						}
					}
					if(found)
					 return new Integer[]{i,j};
				}
			}	
		}
		
		return null;
	}

}
