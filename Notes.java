	/*
	 * class test2
	 * {
	 *   public static void main (String args[])
	 *   {
	 *     int i=Integer.persing("101");  101
	 *     s.o.p(i);
	 *     int j=Integer.persing("101",2);   6
	 *     s.o.p(j);
	 *     
	 *   }
	 * }
	 */
	
	class A
	{
		void x()
		{
			
		}
		void add1(int i , int j)  //only datatypes can be same not variable.
		{
			int ans=i+j;
			System.out.println(ans);
		}
		public static void main(String args[])
		{
			A a1=new A();
			a1.x(); //inline function
			int i=Integer.parseInt(args[0]);
			int j=Integer.parseInt(args[1]);
			a1.add(i,j);
		}
	}
	
	Arguments and Parameters
	->




