import org.apache.commons.cli.*;

public abstract class MyList implements Comparable<Comparable> {
	public static void main(String[] args)
	{
		Options options = new Options();
		options.addOption("type", true, "i for Integer s for String");
		options.addOption("key", true, "specifies the value of the search key");
		Option list   = Option.builder("list" )
				.hasArgs()
				.desc(  "specifies the sorted list of integers or strings.")
				.build();
		options.addOption( list );
		CommandLineParser parser = new DefaultParser();
		CommandLine line = null;
		String t;
		Comparable key = null;

		try {
			line = parser.parse( options, args );
		}
		catch( ParseException exp ) {
			System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
		}
        String[] bList = line.getOptionValues("list");
		Comparable [] aList = new Comparable[bList.length];

		t = line.getOptionValue("type");
		if(t.equals("s")) {
            key = line.getOptionValue("key");
            aList = line.getOptionValues("list");
        }

		if(t.equals("i")) {
            key = Integer.parseInt(line.getOptionValue("key"));
            for (int i = 0; i < bList.length; i++)
                aList[i] = Integer.parseInt(bList[i]);
        }
		int m = binSearch(aList,key);

		if (m==-1)
			System.out.println(-1);
		else
		if (m==-2)
			System.out.println(0);
		else
			System.out.println(1);
	}
	@SuppressWarnings("unchecked")
	private static int binSearch(Comparable[]a, Comparable k)
	{
		int any;
		int r = a.length-1;
		int l = 0;
		int mid=0;

		if (l>r)
			return -1;

		while(l<=r)
		{
			mid = ((l+r)/2);
			any = k.compareTo(a[mid]);
			if (any == 0)
				return mid;
			any = k.compareTo(a[mid]);
			if (any < 0)
				r=mid-1;
			else
				l=mid+1;
		}

		if (k == a[mid])
			return mid;
		else
			return -2;
	}
}
