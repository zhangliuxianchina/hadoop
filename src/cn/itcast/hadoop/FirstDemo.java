package cn.itcast.hadoop;


import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

public class FirstDemo {
	FileSystem fs=null;
	Configuration conf=null;
	
	@Before
	public void init() throws Exception{
		conf = new Configuration();
		fs=FileSystem.get(new URI("hdfs://192.168.204.128:9000"), conf, "root");
	}
	
	@Test
	public void testPut() throws Exception{
		fs.copyFromLocalFile(new Path("d:/sts-bundle.zip"), new Path("/"));
		fs.close();
	}
	
	@Test
	public void testDownLoad() throws Exception{
		boolean useRawLocalFileSystem=true;
		fs.copyToLocalFile(false,new Path("/first"), new Path("e:/"), useRawLocalFileSystem);
		fs.close();
	}
	@Test
	public void testMkdirs() throws Exception{
		fs.mkdirs(new Path("/aaa/bbb/c"));
		fs.close();
	}
	
	

}
